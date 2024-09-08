package it.saimao.customlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity activity;
    private final List<String> strings;
    private final OnItemClickListener listener;

    public MyListAdapter(Activity activity, List<String> strings, OnItemClickListener listener) {
        super(activity, R.layout.adapter_item, strings);
        this.activity = activity;
        this.strings = strings;
        this.listener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View root = inflater.inflate(R.layout.adapter_item, null, false);

        TextView tv = root.findViewById(R.id.tva);
        String str = strings.get(position);
        tv.setText(str);

        CardView ll = root.findViewById(R.id.cv);
        ll.setOnClickListener(view -> {
            listener.onItemClicked(str);
        });
        return root;

    }
}
