package ms.mike.com.mikeshar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import ms.mike.com.mikeshare.adapter.WageCalculateAdapter;
import ms.mike.com.mikeshare.fragment.CustomCalculateFragment;
import ms.mike.com.mikeshare.fragment.StandardCalculateFragment;
import ms.mike.com.mikeshare.view.actionbar.MyActionBar;

/**
 * 工资、五险一金、个人所得税计算
 * Created by  wangkai
 * on  2017-08-18.
 */

public class WageCalculateActivity extends FragmentActivity implements View.OnClickListener{

    private MyActionBar actionBar;
    private RadioGroup rgType;//标题单选按钮
    private ImageView ivIndicator;//游标线
    private LayoutInflater mInflater;
    private ViewPager vpMain;
    private int indicatorWidth;
    private int currentIndicatorLeft = 0;//游标移动位置距离
    
    private WageCalculateAdapter adapter;
    
    private List<String> typeList = new ArrayList<String>();
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

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

        rgType = (RadioGroup) findViewById(R.id.rg_type);
        ivIndicator = (ImageView) findViewById(R.id.iv_indicator);
        vpMain = (ViewPager) findViewById(R.id.vp_main);

        initType();
    }
    
    
    private void initType(){
        typeList = new ArrayList<String>();
        typeList.add("标准");
        typeList.add("自定义");
        
        fragmentList = new ArrayList<Fragment>();
        StandardCalculateFragment standardCalculateFragment = new StandardCalculateFragment();
        CustomCalculateFragment customCalculateFragment = new CustomCalculateFragment();
        fragmentList.add(standardCalculateFragment);
        fragmentList.add(customCalculateFragment);
        
        
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        indicatorWidth = (dm.widthPixels) / 2;
        RelativeLayout.LayoutParams cursor_Params = (RelativeLayout.LayoutParams) ivIndicator.getLayoutParams();
        cursor_Params.width = indicatorWidth;// 初始化滑动下标的宽
        ivIndicator.setLayoutParams(cursor_Params);
        //获取布局填充器
        mInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        adapter = new WageCalculateAdapter(getSupportFragmentManager(),fragmentList);
        if (adapter != null) {
            vpMain.setAdapter(adapter);
        }
        initTypeRG();
        setListener();
    }


    private void initTypeRG() {
        rgType.removeAllViews();
        for(int i=0;i<typeList.size();i++){
            RadioButton rb = (RadioButton) mInflater.inflate(R.layout.calculatetype_rgbtn_lay, null);
            if (i == 0) {
                rb.setTextColor(0xff1a1a1a);
            }
            rb.setId(i);
            rb.setBackgroundColor(0xffffffff);
            rb.setText(typeList.get(i));
            rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        buttonView.setTextColor(0xff1a1a1a);
                    }else{
                        buttonView.setTextColor(0xff747474);
                    }
                }
            });
            rb.setLayoutParams(new RadioGroup.LayoutParams(indicatorWidth, RadioGroup.LayoutParams.MATCH_PARENT));
            rgType.addView(rb);
        }
//        RadioButton rb = (RadioButton) mInflater.inflate(R.layout.sync_nav_radiogroup_item, null);
//        rb.setId(tabTitle.size());
//        rb.setText(""+"\r\n"+"");
//        rb.setTextColor(0xffa48a6f);
//        rb.setBackgroundColor(0xffffffff);
//        rg_nav_content.addView(rb);
    }

    private void setListener() {
        vpMain.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if(rgType!=null && rgType.getChildCount()>position){
                    ((RadioButton)rgType.getChildAt(position)).performClick();
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {}
            @Override
            public void onPageScrollStateChanged(int arg0) {}
        });
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rgType.getChildAt(checkedId)!=null){
                    TranslateAnimation animation = new TranslateAnimation(
                            currentIndicatorLeft ,
                            ((RadioButton) rgType.getChildAt(checkedId)).getLeft(), 0f, 0f);
                    animation.setInterpolator(new LinearInterpolator());
                    animation.setDuration(100);
                    animation.setFillAfter(true);
                    //执行位移动画
                    ivIndicator.startAnimation(animation);
                    vpMain.setCurrentItem(checkedId);	//ViewPager 跟随一起 切换
                    //记录当前 下标的距最左侧的 距离
                    currentIndicatorLeft = ((RadioButton) rgType.getChildAt(checkedId)).getLeft();
//                    mHsv.smoothScrollTo(
//                            (checkedId > 1 ? ((RadioButton) rg_nav_content.getChildAt(checkedId)).getLeft() : 0) - ((RadioButton) rg_nav_content.getChildAt(2)).getLeft(), 0);
                }
            }
        });

        adapter.notifyDataSetChanged();
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
