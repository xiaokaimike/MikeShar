package ms.mike.com.mikeshar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import ms.mike.com.mikeshare.view.actionbar.MyActionBar;

/**
 * 工资、五险一金、个人所得税计算
 * Created by  wangkai
 * on  2017-08-18.
 */

public class WageCalculateActivity extends Activity implements View.OnClickListener{

    private MyActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wagecalculate);
        init();
    }
    
    private void init(){
        actionBar = (MyActionBar) findViewById(R.id.title_bar);
        actionBar.setLeftBtnRes(R.mipmap.btn_back);
        actionBar.setTitle("计算器");
        actionBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
        }
    }
}
