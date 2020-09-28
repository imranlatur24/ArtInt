package shareit;

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
 * Created by root on 27/10/17.
 */

public class Shareit extends Activity implements TextToSpeech.OnInitListener{
   private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shareit);
        textToSpeech=new TextToSpeech(this,this);
        Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.lenovo.anyshare.gps");
        startActivity(mIntent);
    }
    public void backshare(View view){
        Intent ludo = new Intent(Shareit.this, SpeakActivity.class);
        startActivity(ludo);
    }

    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.speak("shareit started for you",TextToSpeech.QUEUE_ADD,null,null);
        finish();
    }
}
