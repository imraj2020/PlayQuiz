package com.cse.playquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cse.playquiz.databinding.ActivityMainBinding
import com.cse.playquiz.databinding.ActivityNoteScreenBinding

class NoteScreen : AppCompatActivity() {
    private lateinit var binding: ActivityNoteScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.next2.setOnClickListener(View.OnClickListener {
            intent = Intent(this,GeneralKnoledgeActivity::class.java)
            //   intent.putExtra("imraj", "10")
            startActivity(intent)
        })
    }
}