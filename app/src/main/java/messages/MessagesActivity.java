package messages;

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

public class MessagesActivity extends Activity implements TextToSpeech.OnInitListener {
public TextToSpeech mTTS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages);
        mTTS = new TextToSpeech(this, this);
        Intent msg = getPackageManager().getLaunchIntentForPackage("com.android.mms");
        startActivity(msg);
    }
    public void backmessage(View view)
    {
        Intent intent = new Intent(MessagesActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Check your messages......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
}
