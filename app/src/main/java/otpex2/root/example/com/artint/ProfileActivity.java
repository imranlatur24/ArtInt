package otpex2.root.example.com.artint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    private TextView textView;
    Animation animBlink,animrotate,animmove;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mTTS = new TextToSpeech(this, this);
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        animrotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        animmove = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.move);
        //Initializing textview
        textView = (TextView) findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);

        //Fetching email from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(Config.EMAIL_SHARED_PREF,"Not Available");

        //Showing the current logged in email to textview
        textView.setText("Current User: " + email);
        animblink();
        buttonblink();

    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Hi Imran......welcome to the darvis world......................please press enter for entering darvis world", TextToSpeech.QUEUE_ADD, null, null);
    }

    private void buttonblink() {
        button.setVisibility(View.VISIBLE);
        button.startAnimation(animBlink);
    }


    private void animblink() {
        textView.setVisibility(View.VISIBLE);
        textView.startAnimation(animBlink);
    }

    //Logout function
    private void logout(){
        //Creating an alert dialog to confirm logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Imran sir, Are you sure you want to logout?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        //Getting out sharedpreferences
                        SharedPreferences preferences = getSharedPreferences(Config.SHARED_PREF_NAME,Context.MODE_PRIVATE);
                        //Getting editor
                        SharedPreferences.Editor editor = preferences.edit();

                        //Puting the value false for loggedin
                        editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, false);

                        //Putting blank value to email
                        editor.putString(Config.EMAIL_SHARED_PREF, "");

                        //Saving the sharedpreferences
                        editor.commit();

                        //Starting login activity
                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Adding our menu to toolbar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuLogout) {
            //calling logout method when the logout button is clicked
            logout();
        }
        return super.onOptionsItemSelected(item);
    }
    public void dorvis(View view){
        Intent intent = new Intent(ProfileActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
}