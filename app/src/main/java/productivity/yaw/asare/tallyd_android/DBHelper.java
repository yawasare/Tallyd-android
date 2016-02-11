package productivity.yaw.asare.tallyd_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by yaw on 12/6/15.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Tallyd.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    public static abstract class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String COLUMN_NAME_NAME= "name";
        public static final String COLUMN_NAME_CREATED_AT = "created_at";
    }


    public static abstract class TallyEntry implements BaseColumns {
        public static final String TABLE_NAME = "Tally";
        public static final String COLUMN_NAME_CREATED_AT = "created_at";
        public static final String COLUMN_NAME_HABIT_ID = "habitid";
    }
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_HABIT_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + HabitEntry.TABLE_NAME + " (" + HabitEntry._ID +
            " INTEGER PRIMARY KEY," + HabitEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    HabitEntry.COLUMN_NAME_CREATED_AT + TEXT_TYPE  + " );";

    private static final String SQL_DELETE_HABIT_ENTRIES =
            "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME;

    private static final String SQL_CREATE_TALLY_ENTRIES =
            "CREATE TABLE IF NOT EXIST " + TallyEntry.TABLE_NAME + " C" + TallyEntry._ID +
            " INTEGER PRIMARY KEY," + TallyEntry.COLUMN_NAME_CREATED_AT + TEXT_TYPE + COMMA_SEP+
            TallyEntry.COLUMN_NAME_HABIT_ID + INTEGER_TYPE +  " );";

    private static final String SQL_DELETE_TALLY_ENTRIES =
            "DROP TABLE IF EXISTS " + TallyEntry.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_HABIT_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_HABIT_ENTRIES);
        onCreate(db);
    }

    public void addHabit(Habit habit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(HabitEntry.COLUMN_NAME_NAME, habit.getName());

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());

        contentValues.put(HabitEntry.COLUMN_NAME_CREATED_AT, nowAsISO);


        db.insert(HabitEntry.TABLE_NAME, null, contentValues);
    }

    public ArrayList<Habit> getHabits(){
        return null;
    }

    public void deleteHabit(Habit habit){
        SQLiteDatabase db = this.getWritableDatabase();
         db.delete(HabitEntry.TABLE_NAME,
                 HabitEntry._ID + " = ? ",
                new String[] { "" + habit.getId()});
    }

    public void addTally(Tally tally){

    }

    public ArrayList<Tally> getTallies(Habit habit){
        return null;
    }
}
