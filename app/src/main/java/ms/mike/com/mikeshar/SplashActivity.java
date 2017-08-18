package ms.mike.com.mikeshar;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import ms.mike.com.mikeshare.util.MyUtils;

/**
 * 闪屏界面
 * Created by  wangkai
 * on  2017-08-18.
 */
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
        setAnim();
    }


    /**
     * 设置AppTitle渐变效果
     */
    private void setAnim(){
        Animation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(5000);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                MyUtils.createIntent(SplashActivity.this,HomeActivity.class,true);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        tvAppTitle.setAnimation(animation);
    }
}
