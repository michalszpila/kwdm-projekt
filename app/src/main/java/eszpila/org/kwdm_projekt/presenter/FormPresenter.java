package eszpila.org.kwdm_projekt.presenter;

import eszpila.org.kwdm_projekt.view.IFormView;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Michał on 2017-05-15.
 */

public class FormPresenter {

    private Retrofit retrofit;

    private IFormView view;

    public FormPresenter(IFormView view) {
        this.view = view;

        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://www.e-szpila.16mb.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void postInfo(String name, String surname, String subject){
        // TODO: 2017-05-16 uzupełnić
    }


}
