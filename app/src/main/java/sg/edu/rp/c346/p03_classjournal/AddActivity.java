package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddActivity extends AppCompatActivity {

    RadioGroup rg;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data);

        rg = findViewById(R.id.radiogroup);
        btnSubmit = findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(id);
                final String grade = rb.getText().toString();
                Intent i = new Intent();
                i.putExtra("grade", grade);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}
