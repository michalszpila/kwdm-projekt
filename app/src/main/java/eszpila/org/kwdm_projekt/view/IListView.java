package eszpila.org.kwdm_projekt.view;

import eszpila.org.kwdm_projekt.model.PersonResponse;

/**
 * Created by Michał on 2017-05-15.
 */

public interface IListView {

    void onLoadSuccess(PersonResponse personResponse);

    void onError();

}
