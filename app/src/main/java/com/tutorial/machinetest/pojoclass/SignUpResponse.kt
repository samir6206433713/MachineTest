package com.tutorial.machinetest.pojoclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SignUpResponse {
    @SerializedName("statusCode")
    @Expose
    var statusCode: Int? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("wallet_id")
    @Expose
    var walletId: String? = null

    @SerializedName("wallet_name")
    @Expose
    var walletName: String? = null

    @SerializedName("user_id")
    @Expose
    var userId: String? = null

}