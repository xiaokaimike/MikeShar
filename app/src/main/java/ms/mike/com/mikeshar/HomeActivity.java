package ms.mike.com.mikeshar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ms.mike.com.mikeshare.adapter.HomeMenuAdapter;
import ms.mike.com.mikeshare.bean.HomeMenuBean;
import ms.mike.com.mikeshare.util.MyUtils;

/**
 * 主界面
 * Created by  wangkai
 * on  2017-08-18.
 */
public class HomeActivity extends Activity{
    
    
    private ListView lvMain;
    private HomeMenuAdapter menuAadapter;
    private List<HomeMenuBean> menuList = new ArrayList<HomeMenuBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_home);
        init();
    }


    /**
     * 初始化
     */
    private void init(){
        lvMain = (ListView) findViewById(R.id.lv_main);
        menuList = new ArrayList<HomeMenuBean>();

        HomeMenuBean bean1 = new HomeMenuBean();
        bean1.setFlag(1);
        bean1.setName("五险一金、个人所得税计算");
        
        menuList.add(bean1);
        
        menuAadapter = new HomeMenuAdapter(this,menuList);
        lvMain.setAdapter(menuAadapter);
        
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (menuList.get(i).getFlag() == 1){
                    MyUtils.createIntent(HomeActivity.this,WageCalculateActivity.class,false);
                }
            }
        });
    }
}
