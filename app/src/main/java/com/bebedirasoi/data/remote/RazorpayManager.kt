package com.bebedirasoi.data.remote

import android.app.Activity
import com.razorpay.Checkout
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RazorpayManager @Inject constructor() {
    fun launchCheckout(activity: Activity, amountInRupees: Double, orderId: String, email: String) {
        val checkout = Checkout()
        val options = JSONObject().apply {
            put("name", "Bebe Di Rasoi")
            put("description", "Homely meal order")
            put("currency", "INR")
            put("amount", (amountInRupees * 100).toInt())
            put("order_id", orderId)
            put("prefill", JSONObject().put("email", email))
        }
        checkout.open(activity, options)
    }
}
