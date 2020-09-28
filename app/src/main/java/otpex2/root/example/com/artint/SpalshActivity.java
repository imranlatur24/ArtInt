package otpex2.root.example.com.artint;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.VideoView;

import java.util.Locale;

public class SpalshActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_spalsh);

        //getSupportActionBar().hide();

        videoView = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);

        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (isFinishing())
                    return;

                startActivity(new Intent(SpalshActivity.this, MainActivity.class));
                finish();
            }
        });

        videoView.start();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Welcome To The Darvis World...", TextToSpeech.QUEUE_ADD, null, null);
    }
}
