package com.example.dotaheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dotaheroes.databinding.ActivityMainBinding
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = HttpClient() {
            install(JsonFeature) {
                serializer = GsonSerializer() {
                    setPrettyPrinting()
                    disableHtmlEscaping()
                }
            }
        }
        var body = listOf<DotaHeroes>()


        runBlocking {
            body = client.get("https://api.opendota.com/api/heroStats")
        }
        binding.dotaHeroesRv.adapter = DotaHeroesAdapter(body)
        binding.dotaHeroesRv.layoutManager = LinearLayoutManager(this)

        client.close()
    }
}