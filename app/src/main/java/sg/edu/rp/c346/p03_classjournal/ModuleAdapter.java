package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Modules> {

    private ArrayList<Modules> modules;
    private Context context;
    private TextView tvWeek;
    private TextView tvGrade;
    private TextView tvDG;
    private ImageView imageView;

    public ModuleAdapter(Context context, int resource, ArrayList<Modules> objects) {
        super(context, resource, objects);
        modules = objects;
        this.context = context;
    }

    public View getView(int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvGrade = rowView.findViewById(R.id.textViewGrade);
        imageView = rowView.findViewById(R.id.imageView);
        tvDG = rowView.findViewById(R.id.textViewDG);
        Modules object = modules.get(pos);
        tvWeek.setText("Week: " + object.getWeek());
        tvGrade.setText(object.getGrade());
        imageView.setImageResource(R.drawable.dg);
        tvDG.setText("DG");
        return rowView;
    }
}
