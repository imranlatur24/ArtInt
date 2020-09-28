package dataoff;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
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

public class DataoffActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataoff);mTTS = new TextToSpeech(this, this);
        Process proc = null;
        try {
            proc = Runtime.getRuntime().exec(new String[]{"su",
                    "pm grant com.imran.mycloud.mytest android.permission.WRITE_SECURE_SETTINGS",
                    "svc data disable"});
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
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("deactivated......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }

}
