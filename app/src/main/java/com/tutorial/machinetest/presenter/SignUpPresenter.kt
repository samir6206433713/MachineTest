package com.tutorial.machinetest.presenter

import android.content.Context
import android.util.Log
import com.tutorial.machinetest.model.ApiInterface
import com.tutorial.machinetest.network.Apiclient
import com.tutorial.machinetest.pojoclass.HomeScreenModel
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class SignUpPresenter(var signUpPresenterView: SignUpPresenterView) {
    private val context: Context? = null
    fun retrofitSignUp() {
        val map: MutableMap<String?, String?> = HashMap()
        map["Content-Type"] = "application/json"
        map["Accept"] = "application/json"
        map["Authorization"] = "Bearer {942|xdfxzVuGcIoQCirz2LylgT2bR3lx4HJnYoUMsNcF}"
        val mediaType = MediaType.parse("application/json")
        val obj = JSONObject()
        /* try {
            obj.put("phone_number", "Preferences.getInstance(context).getdata(Preferences.Phone_NO)");
            Log.i("SignUpPresenterBody", obj.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }*/Log.i("SignUpPresenterBody", "" + obj.toString())
        val body = RequestBody.create(mediaType, obj.toString())
        val apiService = Apiclient.client?.create(ApiInterface::class.java)
        apiService?.gethome(map)!!.enqueue(object : Callback<HomeScreenModel?> {
            override fun onResponse(call: Call<HomeScreenModel?>, response: Response<HomeScreenModel?>) {
                if (response.code() == 200) {
                    Log.i("SignUpPresenteResCode", "" + response.code())


                    /*Preferences.getInstance(context).update
                            (Preferences.USER_ID,response.body().getUserId().trim());
                    Preferences.getInstance(context).update(Preferences.WALLET_ID,response.body().getWalletId().trim());
                    Preferences.getInstance(context).update(Preferences.WALLET_NAME,response.body().getWalletName().trim());*/
                    /* signUpPresenterView.getErrorSignUpPresenter(response.body().getStatus());
                    signUpPresenterView.getErrorSignUpPresenter(response.body().getStatus());


                    signUpPresenterView.responceSignup(response.body().getStatus());*/
                } else {
                    Log.i("Errorcode", "" + "response.code()")
                    /*Log.i("SignUpPresenteResponse", "" + response.code());


                    Gson gson = new GsonBuilder().create();
                    ErrorData mError = new ErrorData();
                    try {
                        mError = gson.fromJson(response.errorBody().string(), ErrorData.class);
                        if (response.code() == 502) {

                            if (mError.getMessage().equals("Internal server error")) {
                                signUpPresenterView.responceSignup(mError.getMessage().trim());
                            }
                        }

                        if (response.code() == 400) {
                            if (mError.getStatus().equals("Error")) {

                                Log.i("SignUpPresenterErrorMsg", "" + mError.getMessage());

                                signUpPresenterView.responceSignup(mError.getMessage().trim());


                            }
                        }


                    } catch (IOException e) {
                        Log.i("SignUpPresetexception", "" + e.toString());

                    }
*/
                }
            }

            override fun onFailure(call: Call<HomeScreenModel?>, t: Throwable) {
                Log.i("SignUpFailureNET", "" + call.toString().trim { it <= ' ' })
                //  signUpPresenterView.responceSignup(t.getLocalizedMessage());
            }
        })
    }

    interface SignUpPresenterView {
        fun getErrorSignUpPresenter(error: String?)
        fun responceSignup(resonse: String?)
    }

}