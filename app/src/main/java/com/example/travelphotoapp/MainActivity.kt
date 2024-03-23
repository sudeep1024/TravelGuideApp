package com.example.travelphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage=0
    lateinit var image:ImageView
    var places= arrayOf("India gate(Delhi)","Gate Way of India(Mumbai)","Chennai","Visakhapatnam(vizag)","Kolkata")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next=findViewById<ImageButton>(R.id.btnNxt)
        val prev=findViewById<ImageButton>(R.id.btnPrev)
        val placeName=findViewById<TextView>(R.id.tVName)

        next.setOnClickListener{
            // i want to go to nxt image
            var idCurrentImageString= "pic$currentImage"
            // get the integer address for each view
            var idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image=findViewById(idCurrentImageInt)
            image.alpha= 0F

            currentImage=(5+currentImage+1)%5

            var idImageToShowString="pic$currentImage"
            var idImageToShowInt=this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1F

            placeName.text=places[currentImage]
        }
        prev.setOnClickListener {
            // i want to go to prev image
            var idCurrentImageString= "pic$currentImage"
            // get the integer address for each view
            var idCurrentImageInt=this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image=findViewById(idCurrentImageInt)
            image.alpha= 0F

            currentImage=(5+currentImage-1)%5

            var idImageToShowString="pic$currentImage"
            var idImageToShowInt=this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1F

            placeName.text=places[currentImage]
        }
    }
}