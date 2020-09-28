package recordstart;

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

public class RecordstartActivity extends Activity {
    static final String TAG = "MediaRecording";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recordstart);
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.imran.mycloud.myrecording");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }
    }
}
