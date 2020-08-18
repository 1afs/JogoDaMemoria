package com.example.jogodamemoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_singleplayer4cards.*
import kotlinx.android.synthetic.main.activity_singleplayer4cards.view.*

class Singleplayer4cards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleplayer4cards)

        //val slot1= img1




        sorteiaFigura(img1)
        sorteiaFigura(img2)
        sorteiaFigura(img3)
        sorteiaFigura(img4)
        sorteiaFigura(img5)
        sorteiaFigura(img6)
        sorteiaFigura(img7)
        sorteiaFigura(img8)


    }
}


fun sorteiaFigura( slot : ImageView){

    val sorteio = (1..4).random()
    val defineImagem: ImageView = slot



    val imagem = when(sorteio){
        1 -> R.drawable.amarelo
        2 -> R.drawable.azul
        3 -> R.drawable.verde
        else -> R.drawable.vermelho
    }

    slot.setImageResource(imagem)




}