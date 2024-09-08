package it.saimao.customlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecyclerViewHolder> {

    private final Activity activity;
    private final List<String> strings;
    private final OnItemClickListener itemClickListener;

    public MyRecyclerAdapter(Activity activity, List<String> strings, OnItemClickListener itemClickListener) {
        this.activity = activity;
        this.strings = strings;
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View root = inflater.inflate(R.layout.adapter_item, parent, false);

        return new MyRecyclerViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {


        String string = strings.get(position);
        holder.binding(string);

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        private View view;
        public MyRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }

        public void binding(String string) {
            TextView tva = view.findViewById(R.id.tva);
            CardView cv = view.findViewById(R.id.cv);
            cv.setOnClickListener(v -> itemClickListener.onItemClicked(string));
            tva.setText(string);
        }
    }
}
