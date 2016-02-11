package productivity.yaw.asare.tallyd_android;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaw on 1/22/16.
 */
public class Habit implements ParentListItem {
    private ArrayList<Tally> mTallies;
    private String mName;
    private int mId;


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public ArrayList<Tally> getTallies() {
        return mTallies;
    }

    public void setTallies(ArrayList<Tally> mTallies) {
        this.mTallies = mTallies;
    }

    @Override
    public List<?> getChildItemList() {
        return null;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
