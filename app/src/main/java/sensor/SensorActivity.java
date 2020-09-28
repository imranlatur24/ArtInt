package sensor;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
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

public class SensorActivity extends Activity  implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        Toast.makeText(getApplicationContext(), "SENSOR", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.speak("sensor activated",TextToSpeech.QUEUE_ADD,null,null);
        finish();
    }
}
