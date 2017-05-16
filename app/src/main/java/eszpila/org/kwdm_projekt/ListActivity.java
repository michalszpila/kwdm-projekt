package eszpila.org.kwdm_projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import eszpila.org.kwdm_projekt.model.PersonResponse;
import eszpila.org.kwdm_projekt.presenter.ListPresenter;
import eszpila.org.kwdm_projekt.view.IListView;

public class ListActivity extends AppCompatActivity implements IListView {

    private static final int ADD_REQUEST_CODE = 100;

    private ListAdapter listAdapter;

    private ListPresenter listPresenter;

    private RecyclerView recyclerView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.initViews();

        this.listPresenter = new ListPresenter(this);
        this.listPresenter.getItems();

    }

    private void initViews() {
        this.recyclerView = (RecyclerView) findViewById(R.id.list_recycler_view);
        this.button = (Button) findViewById(R.id.list_button_add);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, FormActivity.class);
                startActivityForResult(intent, ADD_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this, R.string.new_item_added, Toast.LENGTH_SHORT).show();
            this.listPresenter.getItems();
        }
    }

    @Override
    public void onLoadSuccess(PersonResponse personResponse) {
        this.listAdapter = new ListAdapter();
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(listAdapter);

    }

    @Override
    public void onError() {
        Toast.makeText(this, R.string.error_get, Toast.LENGTH_SHORT).show();
    }
}
