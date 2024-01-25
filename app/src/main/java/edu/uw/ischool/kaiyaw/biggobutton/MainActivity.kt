package edu.uw.ischool.kaiyaw.biggobutton

import kotlin.random.Random
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val genRndColor = {
            Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        }

        val btnPush = findViewById<Button>(R.id.btn_push)
        val layoutMain = findViewById<ConstraintLayout>(R.id.layout_main)
        val animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
        var count = 0
        var rotating = false
        btnPush.setOnClickListener {
            count++
            btnPush.text = resources.getQuantityString(R.plurals.btn_pushed, count, count)
            btnPush.setTextColor(genRndColor())
            layoutMain.background = ColorDrawable(genRndColor())
            if (rotating) {
                rotating = false
                btnPush.clearAnimation()
            } else {
                rotating = true
                btnPush.startAnimation(animRotate)
            }
        }
    }
}