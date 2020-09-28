package brightoff;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class BrightoffActivity extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    Camera camera;
    boolean checked = true;
    boolean off = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brightoff);
        setContentView(R.layout.demo);
        try {
            if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
                camera.stopPreview();
                camera.release();
                camera = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Exception throws in turning off flashlight.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("deactivated....................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
}
