package eszpila.org.kwdm_projekt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.initViews();


    }

    private void initViews(){
        this.recyclerView = (RecyclerView) findViewById(R.id.list_recycler_view);
        this.button = (Button) findViewById(R.id.list_button_add);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
