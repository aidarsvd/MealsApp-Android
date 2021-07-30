package pro.aidar.mealsapp.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import pro.aidar.mealsapp.App
import pro.aidar.mealsapp.R

fun View.setThrottleOnClickListener(callback: (view: View) -> Unit) {
    var lastClickTime = 0L
    this.setOnClickListener {
        val currentTimeMillis = System.currentTimeMillis()
        if (currentTimeMillis - lastClickTime > 2000L) {
            lastClickTime = currentTimeMillis
            callback.invoke(it)
        }
    }
}

fun watchYoutubeVideo(context: Context, id: String) {
    val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
    val webIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("http://www.youtube.com/watch?v=$id")
    )
    try {
        context.startActivity(appIntent)
    } catch (ex: ActivityNotFoundException) {
        context.startActivity(webIntent)
    }
}

fun String.getYouTubeVideoId(): String {
    return this.substringAfterLast("v=")
}

fun showToast(text: String) {
    Toast.makeText(App.context, text, Toast.LENGTH_LONG).show()
}

inline fun Fragment.displayPopUp(
    view: View,
    menu: Int,
    itemId: Int,
    crossinline action: () -> Unit
) {
    val popup = PopupMenu(requireContext(), view)
    popup.inflate(menu)
    popup.setOnMenuItemClickListener { item ->
        when (item.itemId) {
            itemId -> {
                action()
                true
            }
            else -> false
        }
    }
    popup.show()
}