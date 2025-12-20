package com.buy2enjoy.feature_list

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

object SellerCenter {
    private const val BASE_PK = "https://sellercenter.daraz.pk/orders"

    fun openOrdersPage(context: Context) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(BASE_PK))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try { context.startActivity(intent) } catch (_: ActivityNotFoundException) {}
    }
}
