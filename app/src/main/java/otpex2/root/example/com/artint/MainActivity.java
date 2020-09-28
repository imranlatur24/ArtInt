package otpex2.root.example.com.artint;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;

    private RecyclerView recyclerView_gridview;
    private GridLayoutManager gridLayoutManager;
    private HomeMenuAdapter homeMenuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
    }

    private void init()
    {
        mTTS = new TextToSpeech(this, this);
        recyclerView_gridview = (RecyclerView) findViewById(R.id.recyclerView_gridview);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView_gridview.setLayoutManager(gridLayoutManager);
        homeMenuAdapter = new HomeMenuAdapter(MainActivity.this);
        recyclerView_gridview.setAdapter(homeMenuAdapter);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("Welcome To The Darvis World", TextToSpeech.QUEUE_ADD, null, null);
    }
}