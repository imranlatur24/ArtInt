package gpsoff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import java.io.IOException;
import java.util.Locale;

import chrome.ChromeActivity;
import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class GpsoffActivity extends Activity  implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpsoff);
        Process proc = null;
        try {
            proc = Runtime.getRuntime().exec(new String[]{"su",
                    "pm grant com.imran.mycloud.mytest android.permission.WRITE_SECURE_SETTINGS",
                    "settings get secure location_providers_disabled"});
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
        textToSpeech.speak("gps activated", TextToSpeech.QUEUE_ADD,null,null);
        finish();
    }
}
