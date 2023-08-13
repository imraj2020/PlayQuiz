package com.cse.playquiz

import androidx.lifecycle.ViewModel

class KnowledgeQuizViewModel:ViewModel() {



    private var quizQuestions = KnowledgeDataSource.QuizQuestions
    private var quizQuestion =quizQuestions


    init {
        quizQuestion.shuffle()

    }

    private  var currentQuestionindex = 0
    var score = 0



    fun restart() {
        currentQuestionindex = 0
    }

   fun currentQuestion():KnowledgeQuizQuestion{

       return quizQuestions[currentQuestionindex]
   }



    fun nextQuestion():KnowledgeQuizQuestion?{

        currentQuestionindex++


      return if(currentQuestionindex<quizQuestions.size){
          quizQuestion[currentQuestionindex]
        }else{
            null
        }




    }
    fun score():Int{

        return score
    }


    fun QuestionSize():Int{

        return quizQuestions.size
    }


    fun checkAnswer(selectedIndex:Int) :Boolean{
        val currentquestion = quizQuestions[currentQuestionindex]


        return if(selectedIndex==currentquestion.correctAnswerIndex){
            score++
            true
        }
        else{
            false
        }
    }

    fun questionCount() : Int{
      var count =  currentQuestionindex+1

        return count
    }



}