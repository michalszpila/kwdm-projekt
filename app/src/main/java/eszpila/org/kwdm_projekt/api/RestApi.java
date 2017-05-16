package eszpila.org.kwdm_projekt.api;

import eszpila.org.kwdm_projekt.model.PersonResponse;
import eszpila.org.kwdm_projekt.model.SuccessResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Michał on 2017-05-15.
 */

public interface RestApi {

    @GET("/getInfo")
    Observable<PersonResponse> getInfo();

    @FormUrlEncoded
    @POST("/postInfo")
    Observable<SuccessResponse> postInfo(@Field("first_name") String firstName, @Field("last_name") String lastName, @Field("subject") String subject);


}
