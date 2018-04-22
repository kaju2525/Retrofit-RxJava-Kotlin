package demo.com

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import demo.com.model.ResponseData
import demo.com.restservices.APIService
import demo.com.restservices.ApiUtils
import org.json.JSONObject
import retrofit2.adapter.rxjava.HttpException
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private var apiService: APIService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        apiService = ApiUtils.apiService

        //Log.d("TAGS",response!!.body().result.toString())


        apiService!!.savePost("+91", "89308285453", "riukkkjf@gmai.com", "12345678")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError)
    }


    private fun handleResponse(responseData: ResponseData) {

        Log.d("TAGS", " responseData : " + responseData.result.toString())
        Toast.makeText(this, "responseData : " + responseData.message, Toast.LENGTH_SHORT).show()

        Toast.makeText(this, "responseData : " + responseData.result.toString(), Toast.LENGTH_SHORT).show()

    }

    private fun handleError(error: Throwable) {
        Log.d("TAGS", error.localizedMessage)

       val code= (error as HttpException).code()

        Toast.makeText(this, "Erro Code : $code", Toast.LENGTH_SHORT).show()


        val responseBody = error.response().errorBody()!!.string()
        val errorResponseKey="message"
        return try {
            val jObjError = JSONObject(responseBody)
            val string = jObjError.getString(errorResponseKey)
            Toast.makeText(this, " $string", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) { }

    }



}



