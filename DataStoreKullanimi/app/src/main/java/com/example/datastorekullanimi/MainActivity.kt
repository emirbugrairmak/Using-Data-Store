package com.example.datastorekullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.datastorekullanimi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ap=AppPref(this)
        CoroutineScope(Dispatchers.Main).launch {
            ap.kayitAd("Ahmet")
            ap.kayitYas(21)
            ap.kayitBoy(1.78)
            ap.kayitBekar(true)

            val liste=HashSet<String>()
            liste.add("Emir")
            liste.add("Zeynep")
            ap.kayitArkadasListe(liste)

            val gelenAd=ap.okuAd()
            val gelenYas=ap.okuYas()
            val gelenBoy=ap.okuBoy()
            val gelenBekar=ap.okuBekar()

            Log.e("Gelen Ad",gelenAd)
            Log.e("Gelen Yas",gelenYas.toString())
            Log.e("Gelen Boy",gelenBoy.toString())
            Log.e("Gelen Bekar",gelenBekar.toString())

            val gelenListe=ap.okuArkadasListe()

            if (gelenListe!=null){
                for (i in gelenListe){
                    Log.e("Gelen Arkadaş",i)
                }
            }

            var gelenSayac=ap.okuSayac()
            ap.kayitSayac(++gelenSayac)
            binding.textViewSayac.text="Açılış Sayısı : $gelenSayac"

        }

    }
}