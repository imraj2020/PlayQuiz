package com.cse.playquiz

import android.content.Intent
import android.net.Uri
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


        binding.videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video))


       binding.videoView.setOnPreparedListener { mp ->
            mp.isLooping = false // Set to true if you want video to loop
            binding.videoView.start() // Start video playback
        }

        binding.next.setOnClickListener {
            intent = Intent(this,NoteScreen::class.java)
            //   intent.putExtra("imraj", "10")
            startActivity(intent)
        }


//        binding.knowledgequiz.setOnClickListener(View.OnClickListener {
//            intent = Intent(this,GeneralKnoledgeActivity::class.java)
//         //   intent.putExtra("imraj", "10")
//            startActivity(intent)
//        })





    }
}