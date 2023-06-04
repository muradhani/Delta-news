package com.example.deltanews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this) // Initialize FirebaseApp

        val database = FirebaseDatabase.getInstance()
        val myref = database.getReference("message")
        myref.setValue("hello world")
        myref.get().addOnSuccessListener {
            println(it.value)
        }
    }
}