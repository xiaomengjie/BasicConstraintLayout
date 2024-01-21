package com.xiao.today.basicconstraintlayout

import android.content.Context
import android.util.AttributeSet
import android.view.ViewAnimationUtils
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.math.hypot

class CustomHelper(context: Context, attrs: AttributeSet) : ConstraintHelper(context, attrs) {
    /**
     *
     */
    override fun updatePostLayout(container: ConstraintLayout) {
        super.updatePostLayout(container)
        referencedIds.forEach {
            val view = container.getViewById(it)
            val radius = hypot(view.width.toFloat(), view.height.toFloat())
            ViewAnimationUtils.createCircularReveal(
                view, 0, 0, 0f, radius
            ).setDuration(2_000).start()
        }
    }
}