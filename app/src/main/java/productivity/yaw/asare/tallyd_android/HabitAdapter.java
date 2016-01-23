package productivity.yaw.asare.tallyd_android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yaw on 1/22/16.
 */
public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.ViewHolder> {

    ArrayList<Habit> habits;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }

        public void setText(String text){

        }
    }

    public HabitAdapter(){

    }

    @Override
    public HabitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.habit_item, parent, false);
        // set the view's size, margins, paddings and layout parameters


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.setText(habits.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return habits.size();
    }
}
