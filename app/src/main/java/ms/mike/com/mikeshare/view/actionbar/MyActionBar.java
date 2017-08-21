package ms.mike.com.mikeshare.view.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ms.mike.com.mikeshar.R;


/**
 * ActionBar View
 * @author wangkai
 *
 * @date 2016年12月21日
 */
public class MyActionBar extends LinearLayout implements OnClickListener{
	
	
	private OnClickListener listener;
	
	private ImageView ivLeft;
	private TextView tvTitle;
	private ImageView ivRight;

	public MyActionBar(Context context) {
		this(context, null);
	}

	public MyActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.myactionbar_lay,this,true);
		init();
	}
	
	private void init(){
		ivLeft = (ImageView) findViewById(R.id.iv_left);
		tvTitle = (TextView) findViewById(R.id.tv_title);
		ivRight = (ImageView) findViewById(R.id.iv_right);

		ivLeft.setOnClickListener(this);
		ivRight.setOnClickListener(this);
	}
	
	/**
	 * 设置左边按钮显示图片
	 * @param leftIvRes
	 */
	public void setLeftBtnRes(int leftIvRes){
		ivLeft.setImageResource(leftIvRes);
	}
	
	
	/**
	 * 设置title显示字符
	 * @param titleStr
	 */
	public void setTitle(String titleStr){
		tvTitle.setText(titleStr);
	}
	
	
	/**
	 * 设置右边图片显示
	 * @param rightIvRes
	 */
	public void setRightIvRes(int rightIvRes){
		ivRight.setImageResource(rightIvRes);
	}

	@Override
	public void setOnClickListener(OnClickListener l) {
		this.listener = l;
	}

	public void onClick(View v) {
		if (listener != null) {
			listener.onClick(v);
		}		
	}

}
