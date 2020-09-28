package paytm;

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

public class PaytmActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paytm);
        mTTS = new TextToSpeech(this, this);
        Intent payIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
        startActivity(payIntent);
    }
    public void backpaytm(View view)
    {
        Intent intent = new Intent(PaytmActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("started......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
}
