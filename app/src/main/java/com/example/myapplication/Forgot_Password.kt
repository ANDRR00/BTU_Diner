package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Forgot_Password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        supportActionBar?.hide()

        val rstEmail = findViewById<EditText>(R.id.rst_email)
        val linksenderbtn = findViewById<Button>(R.id.linksendbtn)

       linksenderbtn.setOnClickListener {
           val resetEmail = rstEmail.text.toString()

           if (resetEmail.isEmpty()) {
               Toast.makeText(this, "გრაფა ცარიელია!", Toast.LENGTH_SHORT).show()
           }else {
               FirebaseAuth.getInstance()
                   .sendPasswordResetEmail(resetEmail)
                   .addOnCompleteListener { task ->
                       if (task.isSuccessful) {
                           Toast.makeText(this, "ლინკი გამოგზავნილია მითითებულ მეილზე", Toast.LENGTH_SHORT).show()
                           val intent = Intent(this, LoginActivity::class.java)
                           startActivity(intent)
                           finish()
                       }else {
                           Toast.makeText(this, "დაფიქსირდა შეცდომა!", Toast.LENGTH_SHORT).show()
                       }
                   }
           }

       }





    }
}