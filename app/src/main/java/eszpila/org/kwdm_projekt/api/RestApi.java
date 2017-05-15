package eszpila.org.kwdm_projekt.api;

import eszpila.org.kwdm_projekt.model.PersonResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Michał on 2017-05-15.
 */

public interface RestApi {

    @GET("/getInfo")
    Observable<PersonResponse> getInfo();



}
