package wifioff;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
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

public class Wifioff extends Activity implements TextToSpeech.OnInitListener {
    public TextToSpeech mTTS;
    @SuppressLint({"WifiManagerLeak", "MissingPermission"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifioff);
        mTTS = new TextToSpeech(this, this);
        WifiManager wifimanager;
        wifimanager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifimanager.setWifiEnabled(false);
    }

    @Override
    public void onInit(int i) {
        mTTS.setLanguage(Locale.ENGLISH);
        mTTS.speak("wifi turned off......................", TextToSpeech.QUEUE_ADD, null, null);
        finish();
    }
}
