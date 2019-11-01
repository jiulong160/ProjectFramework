package com.zhoujiulong.widgetlib.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.widget.ImageView

import com.zhoujiulong.widgetlib.R


/**
 * @author zhoujiulong
 * @createtime 2019/2/26 11:43
 * LoadingDialog
 */
class LoadingDialog @JvmOverloads constructor(
    context: Context,
    themeResId: Int = R.style.LoadingDialog
) : Dialog(context, themeResId) {

    companion object {
        fun build(context: Context): LoadingDialog {
            val loadingDialog = LoadingDialog(context)
            loadingDialog.setContentView(R.layout.dialog_loading)
            loadingDialog.setCanceledOnTouchOutside(false)
            loadingDialog.setCancelable(true)
            return loadingDialog
        }
    }

    private val mViewLoading by lazy {
        val view = findViewById<ImageView>(R.id.iv_loading)
        view.setImageResource(R.drawable.anim_loading)
        view
    }
    private val mLoadingAni by lazy { mViewLoading.drawable as AnimationDrawable }

    override fun show() {
        super.show()
        mLoadingAni.start()
    }

    override fun dismiss() {
        super.dismiss()
        mLoadingAni.stop()
    }

    override fun cancel() {
        super.cancel()
        mLoadingAni.stop()
    }


}





















