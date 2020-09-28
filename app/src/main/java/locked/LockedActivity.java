package locked;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 28/9/17.
 */

public class LockedActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locked);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        Toast.makeText(getApplicationContext(), "LOCKED", Toast.LENGTH_LONG).show();

    }
    public void backlocked(View view)
    {
        Intent intent = new Intent(LockedActivity.this, SpeakActivity.class);
        startActivity(intent);
        finish();
    }
}
