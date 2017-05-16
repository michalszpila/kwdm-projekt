package eszpila.org.kwdm_projekt.presenter;

import eszpila.org.kwdm_projekt.api.RestApi;
import eszpila.org.kwdm_projekt.model.PersonResponse;
import eszpila.org.kwdm_projekt.view.IListView;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Michał on 2017-05-15.
 */

public class ListPresenter {

    private Retrofit retrofit;

    private IListView view;

    public ListPresenter(IListView view) {
        this.view = view;

        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://www.e-szpila.16mb.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getItems() {
        // TODO: 2017-05-16 Uzupelnic 
        
        this.retrofit.create(RestApi.class).getInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PersonResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(PersonResponse personResponse) {
                    }
                });
    }
}
