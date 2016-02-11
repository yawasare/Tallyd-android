package productivity.yaw.asare.tallyd_android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaw on 1/22/16.
 */
public class HabitAdapter extends ExpandableRecyclerAdapter<HabitAdapter.ParentHolder, HabitAdapter.ChildHolder>{

    private LayoutInflater mInflater;
    ArrayList<Habit> habits;

    /**
     * Primary constructor. Sets up {@link #mParentItemList} and {@link #mItemList}.
     * <p/>
     * Changes to {@link #mParentItemList} should be made through add/remove methods in
     * {@link ExpandableRecyclerAdapter}
     *
     * @param parentItemList List of all {@link ParentListItem} objects to be
     *                       displayed in the RecyclerView that this
     *                       adapter is linked to
     */
    public HabitAdapter(List<ParentListItem> parentItemList) {
        super(parentItemList);
    }

    public static class ParentHolder extends ParentViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ParentHolder(View v) {
            super(v);
            mView = v;
        }

        public void setText(String text){

        }
    }

    public static class ChildHolder extends ChildViewHolder {

        /**
         * Default constructor.
         *
         * @param itemView The {@link View} being hosted in this ViewHolder
         */
        public ChildHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public HabitAdapter.ParentHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.habit_item, parent, false);
        // set the view's size, margins, paddings and layout parameters


        ParentHolder vh = new ParentHolder(v);
        return vh;
    }

    @Override
    public ParentHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        return null;
    }

    @Override
    public ChildHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        return null;
    }


    @Override
    public void onBindParentViewHolder(ParentHolder parentViewHolder, int position, ParentListItem parentListItem) {
        
    }

    @Override
    public void onBindChildViewHolder(ChildHolder childViewHolder, int position, Object childListItem) {

    }

}
