package videos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.VideoView;
import memo.MemoActivity;
import otpex2.root.example.com.artint.R;
import otpex2.root.example.com.artint.SpeakActivity;

/**
 * Created by root on 29/9/17.
 */

public class VideosActivity extends Activity {
    VideoView view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos);
        view = (VideoView) findViewById(R.id.video);
       /* String path = "android.resource://" + getPackageName() + "/" + R.raw.alone;
        view.setVideoURI(Uri.parse(path));
        view.start();
    */}
    public void backvideos(View view)
    {
        Intent intent = new Intent(VideosActivity.this, SpeakActivity.class);
        startActivity(intent);
        finish();
    }
}
