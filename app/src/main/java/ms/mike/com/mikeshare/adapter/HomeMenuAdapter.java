package ms.mike.com.mikeshare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ms.mike.com.mikeshar.R;
import ms.mike.com.mikeshare.bean.HomeMenuBean;

/**
 * 主界面菜单入口列表适配器
 * Created by  wangkai
 * on  2017-08-18.
 */

public class HomeMenuAdapter extends BaseAdapter{
    
    private Context context;
    private List<HomeMenuBean> list = new ArrayList<HomeMenuBean>();

    public HomeMenuAdapter(Context context,List<HomeMenuBean> list){
        this.context = context;
        this.list = list;
    }
    
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView==null) {
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.homemenu_item_lay, null);
            holder.tvItem = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
        holder.tvItem.setText(list.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        TextView tvItem;
    }
}
