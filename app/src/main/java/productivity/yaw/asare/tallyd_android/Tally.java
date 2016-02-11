package productivity.yaw.asare.tallyd_android;

import java.util.Calendar;

/**
 * Created by yaw on 1/22/16.
 */
public class Tally{

    public Habit mHabit;
    public Calendar mDate;
    private int mID;

    public Tally(Habit habit){
        mHabit = habit;
        mDate = Calendar.getInstance();
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }
}
