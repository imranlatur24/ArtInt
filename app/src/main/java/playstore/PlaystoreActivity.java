package playstore;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;

import java.util.Locale;

import otpex2.root.example.com.artint.R;

/**
 * Created by root on 29/9/17.
 */

public class PlaystoreActivity extends Activity implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playstore);
    }
    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.speak("started", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
}
