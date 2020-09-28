package welcome;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Locale;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

public class Dorviswelcome extends AppCompatActivity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        mTTS = new TextToSpeech(this, this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.UK);//daar vis kee doonii yame apka swaagat hei.."
        mTTS.speak("welcome to the darvis world..I am voice mobile operating system for android device for make task easy to use and faster than human",TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
    public void backwelcome(View view)
    {
        Intent welintent = new Intent(Dorviswelcome.this, SpeakActivity.class);
        startActivity(welintent);
        finish();
    }
}
