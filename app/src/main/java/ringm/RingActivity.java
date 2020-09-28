package ringm;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Locale;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;


/**
 * Created by root on 28/9/17.
 */

public class RingActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    public Button backbutton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ringmode);
        mTTS = new TextToSpeech(this, this);
        backbutton = findViewById(R.id.backbutton);
        final AudioManager am = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        Toast.makeText(getApplicationContext(), "Mode:Normal Mode Activited..!", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Ringing Mode Activated......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
}
