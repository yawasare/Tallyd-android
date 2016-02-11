package productivity.yaw.asare.tallyd_android;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mCreateHabitEditText;
    CardView mHabitCard;
    FloatingActionButton fab;
    ImageView mConfirmHabit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mHabitCard = (CardView)findViewById(R.id.new_habit_card);
        mCreateHabitEditText = (EditText)findViewById(R.id.new_habit_edit);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        mCreateHabitEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    mHabitCard.setVisibility(View.GONE);
                    InputMethodManager imm = (InputMethodManager)getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mCreateHabitEditText.getWindowToken(), 0);
                    fab.setImageResource(R.drawable.plus);
                }
                else{
                    InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                    inputMethodManager.toggleSoftInputFromWindow(mCreateHabitEditText.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                    fab.setImageResource(R.drawable.close);
                }
            }
        });

        mConfirmHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mCreateHabitEditText.getText().toString().isEmpty()){
                    
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mHabitCard.getVisibility() == View.VISIBLE){
                    mHabitCard.setVisibility(View.GONE);
                    InputMethodManager imm = (InputMethodManager)getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mCreateHabitEditText.getWindowToken(), 0);
                    fab.setImageResource(R.drawable.plus);
                }
                else{
                    mHabitCard.setVisibility(View.VISIBLE);
                    mCreateHabitEditText.requestFocus();
                    fab.setImageResource(R.drawable.close);
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
        // do something here and don't write super.onBackPressed()
        if(mCreateHabitEditText.hasFocus()){
            mHabitCard.setVisibility(View.GONE);
            InputMethodManager imm = (InputMethodManager)getSystemService(MainActivity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mCreateHabitEditText.getWindowToken(), 0);
            fab.setImageResource(R.drawable.plus);
        }
        else
            finish();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


        // Checks whether a hardware keyboard is available
        if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {

        } else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
            mCreateHabitEditText.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
