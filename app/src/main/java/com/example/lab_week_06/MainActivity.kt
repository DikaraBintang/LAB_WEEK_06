package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup adapter & layout manager
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Add data
        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.Bengal, "Max", "Energetic and playful", "https://cdn2.thecatapi.com/images/O3btzLlsO.png"),
                CatModel(Gender.Female, CatBreed.Siamese, "Luna", "Elegant and vocal", "https://cdn2.thecatapi.com/images/ai6.jpg"),
                CatModel(Gender.Male, CatBreed.MaineCoon, "Leo", "Gentle giant", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Unknown, CatBreed.Sphynx, "Mystery", "Hairless but fearless", "https://cdn2.thecatapi.com/images/DbwiefiaY.png"),
                CatModel(Gender.Male, CatBreed.BritishShorthair, "Oliver", "Always napping", "https://cdn2.thecatapi.com/images/s4wQfYoEk.jpg"),
                CatModel(Gender.Female, CatBreed.Persian, "Bella", "Fluffy and spoiled", "https://cdn2.thecatapi.com/images/mt.jpg"),
                CatModel(Gender.Female, CatBreed.Ragdoll, "Chloe", "Loves cuddles", "https://cdn2.thecatapi.com/images/mFuWtzsEX.jpg")

            )
        )



        val itemTouchHelper = ItemTouchHelper(catAdapter.SwipeToDeleteCallback())
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    // Dialog saat item diklik
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK", null)
            .show()
    }
}
