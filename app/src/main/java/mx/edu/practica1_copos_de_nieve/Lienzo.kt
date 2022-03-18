package mx.edu.practica1_copos_de_nieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(este:MainActivity) : View(este){//class
    var este = este
    var cantidad = 1000
    var fondo = Color.rgb(106,233,250)
    val copos = Array<Copo>(cantidad,{Copo(this)})
    val corutina = GlobalScope.launch {
        while(true){
            este.runOnUiThread {
                invalidate()
            }
            delay(20L)
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()
        c.drawColor(fondo)
        p.color = Color.WHITE
        c.drawRoundRect(0f,1600f,1080f,2320f,800f,200f,p)

        p.color = Color.rgb(151,106,58)//cafe claro
        c.drawRect(340f,1190f,760f,1610f,p)

        p.color = Color.rgb(90,66,40)//cafe oscuro
        c.drawRect(350f,1200f,750f,1610f,p)


        p.color = Color.rgb(151,106,58)//cafe claro
        c.drawRect(500f,1400f,600f,1610f,p)

        p.color = Color.rgb(90,66,40)//cafe oscuro
        c.drawRect(510f,1410f,590f,1610f,p)

        p.color = Color.rgb(151,106,58)//cafe claro
        c.drawRect(290f,1180f,820f,1200f,p)
        c.drawCircle(570f,1511f,5f,p)

        c.drawRect(145f,1500f,185f,1800f,p)
        c.drawRect(860f,1500f,905f,1800f,p)
        p.color = Color.rgb(244,233,220)//blanquillo
        c.drawOval(85f,1000f,245f,1600f,p)
        c.drawOval(800f,1000f,955f,1600f,p)


        //Dibujar copos de nieve
        for(cop in copos){
            cop.mover()
            cop.pintar(c)
            este.setTitle("LADM - Cristian Villagrana")
            if(cop.contador>100){
                cop.acelerar()
                cop.pintar(c)
            }
            if(cop.contador>300){
                cop.reiniciar()
            }

        }




    }
}

