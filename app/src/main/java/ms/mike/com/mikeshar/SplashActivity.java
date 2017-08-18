package ms.mike.com.mikeshar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends Activity {
    
    
    private TextView tvAppTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }


    /**
     * 初始化
     */
    private void init(){
        tvAppTitle = (TextView) findViewById(R.id.tv_apptitle);
    }
}
