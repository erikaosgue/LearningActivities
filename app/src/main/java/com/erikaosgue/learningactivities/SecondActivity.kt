package com.erikaosgue.learningactivities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erikaosgue.learningactivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    val duckInfo = "Duck is the common name for numerous species in the waterfowl family Anatidae" +
            " which also includes swans and geese. Ducks are divided among several subfamilies in " +
            "the family Anatidae; they do not represent a monophyletic group (the group of all " +
            "descendants of a single common ancestral species) but a form taxon, since swans and " +
            "geese are not considered ducks. Ducks are mostly aquatic birds, mostly smaller than the " +
            "swans and geese, and may be found in both fresh water and sea water.\n"

    val parrotInfo = "Parrots, also known as psittacines are birds of the roughly 398 " +
            "species in 92 genera comprising the order Psittaciformes found mostly in " +
            "tropical and subtropical regions. The order is subdivided into three superfamilies: the " +
            "Psittacoidea (\"true\" parrots), the Cacatuoidea (cockatoos), and the Strigopoidea (New Zealand parrots). " +
            "One-third of all parrot species are threatened by extinction, with higher aggregate extinction risk " +
            "(IUCN Red List Index) than any other comparable bird group.[4] Parrots have a generally pantropical distribution " +
            "with several species inhabiting temperate regions in the Southern Hemisphere, as well. The greatest diversity of " +
            "parrots is in South America and Australasia."

    val eagleInfo = "Eagle is the common name for many large birds of prey of the family Accipitridae. Eagles belong to several " +
            "groups of genera, some of which are closely related. Most of the 60 species of eagle are from Eurasia and Africa." +
            " Outside this area, just 14 species can be found—2 in North America, 9 in Central and South America, and 3 in Australia." +
            " It is nicknamed the king of all birds."

    lateinit var activitySecondBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySecondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(activitySecondBinding.root)

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second)

        val animal = intent.extras

        animal.let {

            if (animal?.get("animal") == "parrot") {
                activitySecondBinding.deafultAnimal.setImageDrawable(application.getDrawable(R.drawable.parrot))
                activitySecondBinding.titleTexView.text = "PARROT"
                activitySecondBinding.descriptionTextView.text = parrotInfo
            }
            else if (animal?.get("animal") == "eagle") {
                activitySecondBinding.deafultAnimal.setImageDrawable(application.getDrawable(R.drawable.eagle))
                activitySecondBinding.titleTexView.text = "EAGLE"
                activitySecondBinding.descriptionTextView.text = eagleInfo
            }else {
                activitySecondBinding.deafultAnimal.setImageDrawable(application.getDrawable(R.drawable.duck))
                activitySecondBinding.titleTexView.text = "DUCK"
                activitySecondBinding.descriptionTextView.text = duckInfo
            }
        }

        activitySecondBinding.backButtonId.setOnClickListener{

            val returnIntent = this.intent
            returnIntent.putExtra("return", "Hello from Second Activity")
            setResult(RESULT_OK, returnIntent)
            // finish() Close the Activity
            finish()
        }



    }
}