package ms.mike.com.mikeshare.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算器界面标准与自定义输入界面适配器
 * Created by  wangkai
 * on  2017-08-21.
 */

public class WageCalculateAdapter extends FragmentPagerAdapter{
    
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    
    
    public WageCalculateAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.fragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
