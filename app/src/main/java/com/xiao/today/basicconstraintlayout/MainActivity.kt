package com.xiao.today.basicconstraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        ConstraintSet().apply {
            isForceId = false //防⽌布局中有⽆ id 控件时报错
            clone(constraintLayout)
            connect(R.id.button15, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            connect(R.id.button15, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            connect(R.id.button15, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        }.applyTo(constraintLayout)
    }

    /*
    * 通过代码向ConstraintLayout中添加控件
    * */
    private fun addWeightToConstraintLayout(constraintLayout: ConstraintLayout, viewId: Int){
        ConstraintSet().apply {
            /* 克隆已有依赖 */
            clone(constraintLayout)

            /* 控件居中显示 */
            /* app:layout_constraintStart_toStartOf="parent" */
            connect(viewId, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            /* app:layout_constraintEnd_toEndOf="parent" */
            connect(viewId, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            /* app:layout_constraintTop_toTopOf="parent" */
            connect(viewId, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            /* app:layout_constraintBottom_toBottomOf="parent" */
            connect(viewId, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        }
            /*应用到constraintLayout*/
            .applyTo(constraintLayout)
    }
}