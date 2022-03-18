package mx.edu.practica1_copos_de_nieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Copo(l:Lienzo) {
    val l = l
    var x = 0f
    var y = 0f
    var movX = 0f
    var movY = 0f
    var inix = 0f
    var iniy = 0f
    var color = Color.WHITE
    var contador = 1

    init {
        x = rand(1000)
        y = rand(1000)
        movX = rand(6)+2
        movY = rand(6)+2
    }

    private fun rand(hasta:Int) : Float{
        return kotlin.random.Random.nextInt(hasta).toFloat()
    }

    fun mover(){
        x+=movX
        y+=movY
        if(x<0 || x>l.width){
            x = rand(500)
        }
        if(y>l.height){
            y = rand(800)
        }
        contador++
    }


    fun acelerar(){
        x+=movX*rand(5)
        y+=movY*rand(5)
        contador++
    }

    fun reiniciar(){
        contador=0
    }
    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color = color
        canvas.drawCircle(x,y,5f,p)

    }
}//class copo