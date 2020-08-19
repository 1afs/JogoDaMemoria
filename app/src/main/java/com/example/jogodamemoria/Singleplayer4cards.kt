package com.example.jogodamemoria

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_singleplayer4cards.*
import kotlin.properties.Delegates


class Singleplayer4cards : AppCompatActivity() {

    var global = 0
    var verifica1= 0
    var verifica2= 0

    val totalPares = 4
    var concluidos by Delegates.observable(0){ property, oldValue, newValue ->
        if(newValue == totalPares){
            idresultado.text = "PARABÉN, VOCÊ CONSEGUIU !!!"
        }
    }
    private lateinit var ref: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleplayer4cards)


        val array : IntArray = intArrayOf(1,2,3,4,5,6,7,8)
        array.shuffle()

        resetaCarta(img1)
        resetaCarta(img2)
        resetaCarta(img3)
        resetaCarta(img4)
        resetaCarta(img5)
        resetaCarta(img6)
        resetaCarta(img7)
        resetaCarta(img8)

       // idresultado.setText(Arrays.toString(array))


        reactButton(img1, array[0])
        reactButton(img2, array[1])
        reactButton(img3, array[2])
        reactButton(img4, array[3])
        reactButton(img5, array[4])
        reactButton(img6, array[5])
        reactButton(img7, array[6])
        reactButton(img8, array[7])



    }

    fun descobrirPar(n1 : Int): Boolean {
        //Se o primeiro numero for par
        return if(n1 %2 == 0){
            //Se coincidir os numeros, dá certo. Se naõ, reseta tudo
            n1-1 == verifica1
        }else{
            n1+1 == verifica1
        }
    }

    private fun reactButton(botao : ImageButton, valor : Int){
        botao.setOnClickListener {
            global++
            if(global < 2){
                verifica1 = valor
                sorteiaFigura(botao,valor)
                ref = botao
            }else{
                verifica2 = valor
                if(descobrirPar(verifica2)){
                    Toast.makeText(this,"BOAAAA, ACERTOU", Toast.LENGTH_SHORT).show()
                    sorteiaFigura(botao,valor)
                    botao.isClickable = false
                    ref.isClickable = false

                    concluidos++

                }else{
                    Toast.makeText(this,"Poxa, tenta de novo", Toast.LENGTH_SHORT).show()
                    resetaCarta(botao)
                    resetaCarta(ref)
                }
                global= 0
            }
        }
    }


    private fun resetaCarta(slot : ImageView){
        val imagem = R.drawable.padrao
        slot.setImageResource(imagem)
    }


    private fun sorteiaFigura(slot : ImageView, valor: Int){
        val imagem = when(valor){
            1 -> R.drawable.amarelo
            2 -> R.drawable.amarelo
            3 -> R.drawable.azul
            4 -> R.drawable.azul
            5 -> R.drawable.verde
            6 -> R.drawable.verde
            else -> R.drawable.vermelho
        }
        slot.setImageResource(imagem)
    }


}

