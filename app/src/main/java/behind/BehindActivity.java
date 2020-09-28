package behind;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import java.util.Locale;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

public class BehindActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.behind);
        mTTS = new TextToSpeech(this, this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
        Toast.makeText(getApplicationContext(), "BEHIND", Toast.LENGTH_LONG).show();
    }
    public void backbehind(View view)
    {
        Intent intent = new Intent(BehindActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("behind sensor activited......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }

}
