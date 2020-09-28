package gallery;

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
 * Created by root on 28/9/17.
 */

public class GalleryActivity extends Activity implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        textToSpeech=new TextToSpeech(this,this);
        Intent gallery = getPackageManager().getLaunchIntentForPackage("com.sec.android.gallery3d");
        startActivity(gallery);
    }
    public void backgallery(View view)
    {
        Intent intent = new Intent(GalleryActivity.this, SpeakActivity.class);
        startActivity(intent);
    }

    @Override
    public void onInit(int i) {
        textToSpeech.setLanguage(Locale.ENGLISH);
        textToSpeech.speak("gallery application stared",TextToSpeech.QUEUE_ADD,null,null);
        finish();
    }
}
