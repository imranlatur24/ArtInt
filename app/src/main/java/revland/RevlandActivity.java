package revland;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import chrome.ChromeActivity;
import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 29/9/17.
 */

public class RevlandActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revland);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        Toast.makeText(getApplicationContext(), "REVERSE LANDSCAPE", Toast.LENGTH_LONG).show();
    }
    public void backrevland(View view)
    {
        Intent intent = new Intent(RevlandActivity.this, SpeakActivity.class);
        startActivity(intent);
    }
}
