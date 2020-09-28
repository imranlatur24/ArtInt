package flighton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import java.io.IOException;
import java.util.Locale;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class FlightonActivity extends Activity implements TextToSpeech.OnInitListener{
private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flighton);
        Process proc = null;
        try {
            proc = Runtime.getRuntime().exec(new String[]{"su",
                    "pm grant com.imran.mycloud.mytest android.permission.WRITE_SECURE_SETTINGS",
                    "settings put global airplane_mode_on 1; am broadcast -a android.intent.action.AIRPLANE_MODE --ez state true"});
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            proc.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.speak("stared", TextToSpeech.QUEUE_ADD,null,null);
        finish();
    }
}
