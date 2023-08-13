package com.cse.playquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import com.cse.playquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.knowledgequiz.setOnClickListener(View.OnClickListener {
            intent = Intent(this,GeneralKnoledgeActivity::class.java)
         //   intent.putExtra("imraj", "10")
            startActivity(intent)
        })





    }
}