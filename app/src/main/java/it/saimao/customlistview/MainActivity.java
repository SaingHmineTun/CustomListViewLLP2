package it.saimao.customlistview;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*
List View
Recycler View (Better Performance)
 */
public class MainActivity extends AppCompatActivity {

    private final String[] strings = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initListView();
        initRecyclerView();
    }

    private void initRecyclerView() {
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, List.of(strings), str -> {
            Toast.makeText(this, "String : " + str, Toast.LENGTH_SHORT).show();
        });
        RecyclerView rv = findViewById(R.id.lv);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void initListView() {
        lv = findViewById(R.id.lv);
        MyListAdapter adapter = new MyListAdapter(this, List.of(strings), str -> {
            Toast.makeText(this, "String : " + str, Toast.LENGTH_SHORT).show();
        });
        lv.setAdapter(adapter);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, strings);
//        lv.setAdapter(adapter);
    }
}