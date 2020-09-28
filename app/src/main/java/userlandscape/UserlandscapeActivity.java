package userlandscape;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 29/9/17.
 */

public class UserlandscapeActivity extends Activity implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlandscape);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);
        Toast.makeText(getApplicationContext(), "USER LANDSCAPE", Toast.LENGTH_LONG).show();
        finish();
    }
        @Override
        public void onInit(int i)
        {
            textToSpeech.setLanguage(Locale.ENGLISH);
            textToSpeech.speak("Activated..",TextToSpeech.QUEUE_ADD,null,null);
            finish();
        }
}
