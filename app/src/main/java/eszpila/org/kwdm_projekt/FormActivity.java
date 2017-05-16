package eszpila.org.kwdm_projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import eszpila.org.kwdm_projekt.presenter.FormPresenter;
import eszpila.org.kwdm_projekt.view.IFormView;

public class FormActivity extends AppCompatActivity implements IFormView{

    private EditText editTextName;
    private EditText editTextSurname;
    private Spinner spinner;
    private Button button;

    private FormPresenter formPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        this.initViews();
        this.formPresenter = new FormPresenter(this);
    }

    private void initViews() {
        this.editTextName = (EditText) findViewById(R.id.form_name);
        this.editTextSurname = (EditText) findViewById(R.id.form_surname);
        this.spinner = (Spinner) findViewById(R.id.form_spinner);
        this.button = (Button) findViewById(R.id.form_button);

        List<String> subjectList = new ArrayList<String>() {
            {
                add("Filozofia");
                add("Bioetyka");
                add("ITiG");
                add("HTO");
                add("KWDM - projekt");
                add("NOwDiT - projekt");
                add("WAPFI");
                add("PW");
                add("Seminarium");
            }
        };

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, subjectList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(arrayAdapter);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setEnabled(false);

                String name = editTextName.getText().toString();
                String surname = editTextSurname.getText().toString();
                String subject = spinner.getSelectedItem().toString();

                formPresenter.postInfo(name, surname, subject);

            }
        });
    }

    @Override
    public void onSendSuccess() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        this.finish();
    }

    @Override
    public void onError() {
        Toast.makeText(this, R.string.error_get, Toast.LENGTH_SHORT).show();
        this.button.setEnabled(true);
    }
}
