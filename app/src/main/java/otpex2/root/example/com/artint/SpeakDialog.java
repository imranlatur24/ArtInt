package otpex2.root.example.com.artint;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ai.api.AIServiceContext;
import ai.api.AIServiceContextBuilder;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.model.AIRequest;


public class SpeakDialog extends BaseActivity
{
    AIDataService aiDataService;
    AIServiceContext aiServiceContext;
    AIRequest aiRequest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak_demo);
        init();
    }

    private void init()
    {
        /*final AIConfiguration configuration = new AIConfiguration("7100aa37e437454c9af191789bc0cf16",
        AIConfiguration.SupportedLanguages.English,
        AIConfiguration.RecognitionEngine.System);

        aiDataService = new AIDataService(this,configuration);
        aiServiceContext = AIServiceContextBuilder.buildFromSessionId();

        aiRequest = new AIRequest();*/



    }
}
