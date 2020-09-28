package gmail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Locale;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class GmailActivity extends Activity implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmail);
        textToSpeech=new TextToSpeech(this,this);
        Intent gmail = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
        startActivity(gmail);
    }

    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.speak("gmail application started",TextToSpeech.QUEUE_ADD,null,null);
        finish();
    }
}
