package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ModuleActivity extends AppCompatActivity {

    int requestCode = 1;

    Button btnInfo, btnAdd, btnEmail;

    ListView lvGrades;
    ArrayAdapter aa;
    ArrayList<Modules> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modules);

        lvGrades = findViewById(R.id.listViewGrades);
        btnInfo = findViewById(R.id.btnInfo);
        btnAdd = findViewById(R.id.btnAdd);
        btnEmail = findViewById(R.id.btnEmail);

        modules = new ArrayList<Modules>();

        Intent intent = getIntent();
        final String module = intent.getStringExtra("module");
        this.setTitle("Info for " + module);

        if (module.equals("C347")) {
            modules.add(new Modules("1", "B"));
            modules.add(new Modules("2", "C"));
            modules.add(new Modules("3", "A"));
        }

        aa = new ModuleAdapter(this, R.layout.row, modules);
        lvGrades.setAdapter(aa);


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer num = modules.size() + 1;
                String week = num.toString();

                Intent intent = new Intent(ModuleActivity.this, AddActivity.class);
                intent.putExtra("week", week);
                startActivityForResult(intent, requestCode);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "");
                email.putExtra(Intent.EXTRA_TEXT,
                        "");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            Integer num = modules.size() + 1;

            // Only handle when 2nd activity closed normally
            //  and data contains something
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    // Get data passed back from 2nd activity
                    String grade = data.getStringExtra("grade");
                    String statement = "";
                    modules.add(new Modules(num.toString(), grade));

                    aa.notifyDataSetChanged();
                }
            }
        }
    }

