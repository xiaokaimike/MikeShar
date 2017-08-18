package ms.mike.com.mikeshare.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * 工具类
 * Created by  wangkai
 * on  2017-08-18.
 */
public class MyUtils {


    /**
     * 统一跳转界面方法
     * @param context
     * @param toActivity
     * @param isFinish
     */
    public static void createIntent(Context context,Class<?> toActivity,boolean isFinish){
        Intent intent = new Intent();
        intent.setClass(context,toActivity);
        context.startActivity(intent);
        if (isFinish){
            ((Activity)context).finish();
        }
    }
    
}
