package backCamera;

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

public class BackCameraActivity extends Activity  implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backcamera);
        mTTS = new TextToSpeech(this, this);
        Intent camera = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.camera");
        startActivity(camera);
    }


    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Camera Started......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }

}
