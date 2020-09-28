package systemrestart;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.Locale;

import brighton.BrightonActivity;
import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 29/9/17.
 */

public class SystemrestartActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.systemrestart);
        mTTS = new TextToSpeech(this, this);
        try {
            Process proc = Runtime.getRuntime()
                    .exec(new String[]{"su", "-c", "reboot"});
            proc.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void backsystemrestart(View view)
    {
        Intent intent = new Intent(SystemrestartActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("System going restart......................", TextToSpeech.QUEUE_ADD, null, null);

    }
}
