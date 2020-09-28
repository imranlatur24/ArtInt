package filemanager;

import android.app.Activity;
import android.content.Intent;
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

public class FileMangerActivity extends Activity implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filemanager);
        textToSpeech=new TextToSpeech(this,this);
        Intent filem = getPackageManager().getLaunchIntentForPackage("com.imran.mycloud.filemanager");
        if (filem != null) {
            startActivity(filem);//null pointer check in case package name was not found
        }
    }

    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.speak("file manager started",TextToSpeech.QUEUE_ADD,null,null);
        finish();
    }
}
