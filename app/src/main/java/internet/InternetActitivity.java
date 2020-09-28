package internet;

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

public class InternetActitivity extends Activity implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet);
        textToSpeech=new TextToSpeech(this,this);
        Intent internet = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.sbrowser");
        startActivity(internet);
    }
    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.speak("internet started for you",textToSpeech.QUEUE_ADD,null,null);
        finish();
    }
}
