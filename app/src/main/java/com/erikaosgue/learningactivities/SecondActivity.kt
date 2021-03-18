package com.erikaosgue.learningactivities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.erikaosgue.learningactivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var activitySecondBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySecondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(activitySecondBinding.root)


        val animal = intent.extras

        animal.let {

            if (animal?.get("animal") == "parrot") {
                activitySecondBinding.deafultAnimal.setImageDrawable(application.getDrawable(R.drawable.parrot))
                activitySecondBinding.titleTexView.text = "PARROT"
                activitySecondBinding.descriptionTextView.text = R.string.parrotInfo.toString()
            }
            else if (animal?.get("animal") == "eagle") {
                activitySecondBinding.deafultAnimal.setImageDrawable(application.getDrawable(R.drawable.eagle))
                activitySecondBinding.titleTexView.text = "EAGLE"
                activitySecondBinding.descriptionTextView.text = R.string.eagleInfo.toString()
            }else {
                activitySecondBinding.deafultAnimal.setImageDrawable(application.getDrawable(R.drawable.duck))
                activitySecondBinding.titleTexView.text = "DUCK"
                activitySecondBinding.descriptionTextView.text = R.string.duckInfo.toString()
            }
        }


        activitySecondBinding.backButtonId.setOnClickListener{
//
//            val returnIntent = this.intent
//            returnIntent.putExtra("return", "Hello from Second Activity")
//            setResult(RESULT_OK, returnIntent)
            // finish() Close the Activity
            finish()
        }



    }

    // Sending a Toast Message before going the user can go Back
    var variable: Int = 0
    override fun onBackPressed() {

        if (variable == 1) {
            super.onBackPressed()
        }else {
            Toast.makeText(this, "Press Back again if you Want to leave", Toast.LENGTH_LONG).show()
            variable = 1
        }
    }
}