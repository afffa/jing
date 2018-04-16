package ss.com.lbs.jingdong01.presenters.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.bean.DingDanLieBiaoBean;

/**
 * author:Created by WangZhiQiang on 2018/4/16.
 */

public class Mydingdan_liebiaoAbapter extends RecyclerView.Adapter<Mydingdan_liebiaoAbapter.MyViewHolber> {

    Context context;
    List<DingDanLieBiaoBean.DataBean> data;

    public Mydingdan_liebiaoAbapter(Context context, List<DingDanLieBiaoBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolber onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dingdanliebiao_recy_view, parent, false);
        MyViewHolber myViewHolber = new MyViewHolber(view);
        return myViewHolber;
    }

    @Override
    public void onBindViewHolder(MyViewHolber holder, int position) {
        holder.dingdanliebiao_recy_view_tv.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolber extends RecyclerView.ViewHolder{

        private final TextView dingdanliebiao_recy_view_tv;

        public MyViewHolber(View itemView) {
            super(itemView);
            dingdanliebiao_recy_view_tv = itemView.findViewById(R.id.dingdanliebiao_recy_view_tv);
        }
    }
}
