package chrome;

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
 * Created by root on 28/9/17.
 */

public class ChromeActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chrome);
        mTTS = new TextToSpeech(this, this);
        Intent mcIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
        startActivity(mcIntent);
    }
    public void backch(View view)
    {
        Intent intent = new Intent(ChromeActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("google chrome started......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }

}
