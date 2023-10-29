package com.cse.playquiz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.cse.playquiz.databinding.ActivityGeneralKnoledgeBinding
import com.cse.playquiz.databinding.ActivityMainBinding


class GeneralKnoledgeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGeneralKnoledgeBinding
    private val viewModel: KnowledgeQuizViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeneralKnoledgeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.nextQuestion.setOnClickListener(View.OnClickListener {




            val selectedoptionIndex =
                binding.optionsRadioGroup.indexOfChild(findViewById(binding.optionsRadioGroup.checkedRadioButtonId))

            if(selectedoptionIndex!=-1){
               viewModel.checkAnswer(selectedoptionIndex)
                nextquestion()
            }else{
                Toast.makeText(this, "Please Select an Option", Toast.LENGTH_SHORT).show()
            }


        })

        binding.QuitQuiz.setOnClickListener(View.OnClickListener {
            finish()
        })


        showCurrentQuestion();


    }

    private fun showCurrentQuestion() {

        val currentquestion = viewModel.currentQuestion()
        val questionNo = viewModel.questionCount()
        val totalquestion = viewModel.QuestionSize().toString()

        binding.apply {
            questionTextView.text = currentquestion.question
            option1RadioBtn.text = currentquestion.options[0]
            option2RadioBtn.text = currentquestion.options[1]
            option3RadioBtn.text = currentquestion.options[2]
            option4RadioBtn.text = currentquestion.options[3]
            QuestionNo.text = questionNo.toString()
            TotalQuestion.text = "/ $totalquestion"


            optionsRadioGroup.clearCheck()
        }
    }


    private fun nextquestion() {

        val nextquestion = viewModel.nextQuestion()

        if (nextquestion != null) {
            showCurrentQuestion()
        } else {
            val scores = viewModel.score()
            var questionsize = viewModel.QuestionSize()
            intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("score",scores)
            intent.putExtra("questionsize",questionsize)
            startActivity(intent)
        }
    }
}