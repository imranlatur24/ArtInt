package purpose;

/**
 * Created by root on 12/10/17.
 */
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.Locale;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

public class DorvisPurpose extends AppCompatActivity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.darvispurpose);
        mTTS = new TextToSpeech(this, this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("my primary target to save human being and to save the world.", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }

}
