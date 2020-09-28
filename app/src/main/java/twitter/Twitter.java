package twitter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.Locale;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;


/**
 * Created by root on 26/10/17.
 */

public class Twitter extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter);
        mTTS = new TextToSpeech(this, this);
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.twitter.com"));
        startActivity(intent);
    }

    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("twitter started......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
}
