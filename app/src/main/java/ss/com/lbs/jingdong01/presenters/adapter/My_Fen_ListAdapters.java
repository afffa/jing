package ss.com.lbs.jingdong01.presenters.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.bean.JuiGongGeBean;

/**
 * author:Created by WangZhiQiang on 2018/4/11.
 */

public class My_Fen_ListAdapters extends BaseAdapter {

    private Context context;
    private JuiGongGeBean juiGongGeBean;
    private MyHolber myHolber;

    public My_Fen_ListAdapters(Context context, JuiGongGeBean juiGongGeBean) {
        this.context = context;
        this.juiGongGeBean = juiGongGeBean;
    }

    @Override
    public int getCount() {
        return juiGongGeBean.getData().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            myHolber = new MyHolber();
            view = View.inflate(context, R.layout.fen_list_view, null);
            view.setTag(myHolber);
        }else {
            view.getTag();
        }
        myHolber.tv = view.findViewById(R.id.fen_list_tv);
        myHolber.tv.setText(juiGongGeBean.getData().get(i).getName());
        return view;
    }
    class MyHolber{
        TextView tv;
    }

}
