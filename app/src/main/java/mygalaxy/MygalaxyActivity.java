package mygalaxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class MygalaxyActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mygalaxy);
        Intent galaxy = getPackageManager().getLaunchIntentForPackage("com.mygalaxy");
        startActivity(galaxy);
    }
    public void backbrighton(View view)
    {
        Intent intent = new Intent(MygalaxyActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
}
