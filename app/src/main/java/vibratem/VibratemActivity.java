package vibratem;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import java.util.Locale;
import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 29/9/17.
 */

public class VibratemActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibratem);
        mTTS = new TextToSpeech(this, this);
        final AudioManager am = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        Toast.makeText(getApplicationContext(), "..!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Virbate Mode Activated......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
}
