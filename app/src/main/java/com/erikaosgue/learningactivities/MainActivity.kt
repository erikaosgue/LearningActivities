package com.erikaosgue.learningactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.erikaosgue.learningactivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val REQUEST_CODE = 1

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val parrot = activityMainBinding.parrotId
        val duck = activityMainBinding.duckId
        val eagle = activityMainBinding.eagleId

        //register the Onclick listener
        parrot.setOnClickListener(this)
        duck.setOnClickListener(this)
        eagle.setOnClickListener(this)

    }

    override fun onClick(view: View?) {

        when(view?.id) {
           activityMainBinding.parrotId.id -> {


               Toast.makeText(this, "This is the parrot Image", Toast.LENGTH_LONG).show()

               val parrotIntent = Intent(this, SecondActivity::class.java)
               parrotIntent.putExtra("animal", "parrot")
               startActivityForResult(parrotIntent, REQUEST_CODE)
            }
            activityMainBinding.duckId.id -> {
                Toast.makeText(this, "This is the duck Image", Toast.LENGTH_LONG).show()
                val duckIntent = Intent(this, SecondActivity::class.java)
                duckIntent.putExtra("animal", "duck")
                startActivityForResult(duckIntent, REQUEST_CODE)
            }

            activityMainBinding.eagleId.id -> {
                Toast.makeText(this, "This is the eagle Image", Toast.LENGTH_LONG).show()
                val eagleIntent = Intent(this, SecondActivity::class.java)
                eagleIntent.putExtra("animal", "eagle")
                startActivityForResult(eagleIntent, REQUEST_CODE)
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK){
                // Data is the hashMap => information we send in the intent from SecondActivity
                val result = data?.extras?.get("return")
                result.let {
                    Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}