package ss.com.lbs.jingdong01.presenters.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.bean.FenLei_LieBiao_Bean;

/**
 * author:Created by WangZhiQiang on 2018/4/12.
 */

public class MyFenLei_liebiaoAdapter extends BaseAdapter {

    Context context;
    List<FenLei_LieBiao_Bean.DataBean> data;
    private MyViewHolber myViewHolber;
    private TextView fenlie_liebiao_item_tv1;

    public MyFenLei_liebiaoAdapter(Context context, List<FenLei_LieBiao_Bean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
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
            myViewHolber = new MyViewHolber();
            view = View.inflate(context, R.layout.fenleiliebiao_item_view, null);
            view.setTag(myViewHolber);
        }else {
            view.getTag();
        }
        myViewHolber.iv1 = view.findViewById(R.id.fenlie_liebiao_item_iv);
        myViewHolber.tv1 = view.findViewById(R.id.fenlie_liebiao_item_tv1);
        myViewHolber.tv2 = view.findViewById(R.id.fenlie_liebiao_item_tv2);

        String images = data.get(i).getImages();
        if (images.contains("|")) {
            String[] split = images.split("\\|");
            myViewHolber.iv1.setImageURI(split[0]);
        }else {
            myViewHolber.iv1.setImageURI(images);
        }
        myViewHolber.tv1.setText(data.get(i).getTitle());
        myViewHolber.tv2.setText(data.get(i).getSubhead());
        return view;
    }
    class MyViewHolber{
        SimpleDraweeView iv1;
        TextView tv1;
        TextView tv2;
    }

}
