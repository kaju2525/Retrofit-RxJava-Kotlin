package demo.com.model
import com.google.gson.annotations.SerializedName


 class ResponseData(
		@SerializedName("result") val result: Result,
		@SerializedName("message") val message: String
     /*   @SerializedName("result") val result: Result*/
)

data class Result(
		@SerializedName("question_title") val questionTitle: String,
		@SerializedName("answer") val answer: List<Answer>,
		@SerializedName("userId") val userId: Int
)

data class Answer(
		@SerializedName("option") val option: String
)


