package sms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Locale;

import brighton.BrightonActivity;
import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 29/9/17.
 */

public class SmsActivity extends Activity implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        textToSpeech=new TextToSpeech(this,this);
    }
    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.speak("sms started for you",TextToSpeech.QUEUE_ADD,null,null);
       finish();
    }
}
