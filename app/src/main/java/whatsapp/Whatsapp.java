package whatsapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.Locale;
import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;


/**
 * Created by root on 29/9/17.
 */

public class Whatsapp extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatsapp);
        mTTS = new TextToSpeech(this, this);
        Intent wapp = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        startActivity(wapp);
    }
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Whatsapp application started......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
}
