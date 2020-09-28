package weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 29/9/17.
 */

public class Weather extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wheather);
        Intent weather = getPackageManager().getLaunchIntentForPackage("com.sec.android.widgetapp.ap.hero.accuweather");
        startActivity(weather);
    }
    public void backwheather(View view)
    {
        Intent intent = new Intent(Weather.this, SpeakActivity.class);
        startActivity(intent);
        finish();
    }
}
