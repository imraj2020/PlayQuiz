package com.cse.playquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.viewModels
import com.cse.playquiz.databinding.ActivityGeneralKnoledgeBinding
import com.cse.playquiz.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    private val viewModel: KnowledgeQuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val receivescore = intent.getIntExtra("score",0)
        val totalquestion = intent.getIntExtra("questionsize",0)



        binding.results.text = receivescore.toString()
        binding.totalquestions.text = totalquestion.toString()


        binding.newQuizbtn.setOnClickListener(View.OnClickListener {
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

    }

    override fun onBackPressed() {
        intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }
}


