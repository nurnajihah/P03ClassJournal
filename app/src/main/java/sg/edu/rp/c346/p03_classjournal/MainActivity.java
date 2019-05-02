package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModules;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModules = this.findViewById(R.id.listViewModules);

        al = new ArrayList<String>();
        al.add("C347");

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);

        lvModules.setAdapter(aa);

        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedModule = al.get(position);

                Intent intent = new Intent(MainActivity.this, ModuleActivity.class);
                intent.putExtra("module", selectedModule);
                startActivity(intent);

            }
        });
    }
}
