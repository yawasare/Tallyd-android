package productivity.yaw.asare.tallyd_android;

import java.util.ArrayList;

/**
 * Created by yaw on 1/22/16.
 */
public class Habit {
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
}
