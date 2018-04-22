package demo.com.restservices



import demo.com.model.ResponseData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import rx.Observable


interface APIService {




    @GET("/karunkumarpune/Expandeble/master/question_test.json")
    fun getQuestion(): Observable<ResponseData>



    @POST("/immigration/api/signup")
    @FormUrlEncoded
    fun savePost(@Field("countryCode") countryCode: String,
                 @Field("contact") contact: String,
                 @Field("email")email: String,
                 @Field("password") password: String): Observable<ResponseData>

}