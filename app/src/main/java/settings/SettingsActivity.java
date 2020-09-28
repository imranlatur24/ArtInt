package settings;

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

public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Intent settings = getPackageManager().getLaunchIntentForPackage("com.android.setting");
        startActivity(settings);
    }
    public void backsettings(View view)
    {
        Intent intent = new Intent(SettingsActivity.this, SpeakActivity.class);
        startActivity(intent);
        finish();
    }
}
