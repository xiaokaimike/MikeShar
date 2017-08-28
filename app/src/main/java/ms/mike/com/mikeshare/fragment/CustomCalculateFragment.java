package ms.mike.com.mikeshare.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ms.mike.com.mikeshar.R;

/**
 * 自定义计算界面
 * Created by  wangkai
 * on  2017-08-21.
 */

public class CustomCalculateFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customcalculate, container, false);
        init(rootView);
        return rootView;
    }


    /**
     * 初始化
     * @param view
     */
    private void init(View view){
        
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
