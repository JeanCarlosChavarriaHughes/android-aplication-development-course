package com.example.recyclerviewclass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;
    ItemClicked activity;
    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public PersonAdapter (Context context, ArrayList<Person> list){
        people = list;
        activity = (ItemClicked) context;
        Log.d("Test", people.get(0).getName());  //works
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPref;
        TextView tvName, tvSurname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            ivPref = itemView.findViewById(R.id.ivPref);

            Log.d("Test", (String) tvName.getText());  //doesn't works


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // action with item is clicked
                    activity.onItemClicked(people.indexOf((Person) v.getTag()));
                    String surname = ((Person) v.getTag()).getSurname().toString();
                    Log.d("Test surname", surname);
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        Log.d("Test", v.toString()); //doesn't work
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {
        //this runs for each element in the array "people"
        Log.d("Test", people.get(i).getName());  //doesn't work
        viewHolder.itemView.setTag(people.get(i));
        viewHolder.tvName.setText(people.get(i).getName());
        viewHolder.tvSurname.setText(people.get(i).getSurname());

        String objectPreference = people.get(i).getPreference();
        switch (objectPreference){
            case "bus":
                viewHolder.ivPref.setImageResource(R.drawable.ic_bus);
                break;

            case "plane":
                viewHolder.ivPref.setImageResource(R.drawable.ic_plane);
                break;

        }
    }

    @Override
    public int getItemCount() {
        Log.d("Test", String.valueOf(people.size())); //doesn't work
        return people.size();
    }
}
