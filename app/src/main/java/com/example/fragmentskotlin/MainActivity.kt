package com.example.fragmentskotlin

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fragmentskotlin.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnTime = findViewById<Button>(R.id.btnTime)
        val btnExam = findViewById<Button>(R.id.btnExam)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnTime.setOnClickListener {
            replaceFrameWithFragment(ClockFragment())
        }

        btnExam.setOnClickListener {
            replaceFrameWithFragment(ExamFragment())
        }

        btnValidate.setOnClickListener {
            replaceFrameWithFragment(LoginFragment())
        }
    }

    private fun replaceFrameWithFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}