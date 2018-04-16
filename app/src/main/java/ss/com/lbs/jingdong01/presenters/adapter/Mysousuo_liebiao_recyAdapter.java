package ss.com.lbs.jingdong01.presenters.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.bean.SouSuoShangPinBean;

/**
 * author:Created by WangZhiQiang on 2018/4/13.
 */

public class Mysousuo_liebiao_recyAdapter extends RecyclerView.Adapter<Mysousuo_liebiao_recyAdapter.MyViewHolber1> {


    Context context ;
    List<SouSuoShangPinBean.DataBean> data;

    public Mysousuo_liebiao_recyAdapter(Context context, List<SouSuoShangPinBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolber1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sousuo_liebiao_item_view, parent, false);
        MyViewHolber1 myViewHolber1 = new MyViewHolber1(view);
        return myViewHolber1;
    }

    @Override
    public void onBindViewHolder(MyViewHolber1 holder, int position) {

        String images = data.get(position).getImages();
        if (images.contains("|")) {
            String[] split = images.split("\\|");
            holder.sousuo_liebiao_item_view_iv.setImageURI(split[0]);
        }else {
            holder.sousuo_liebiao_item_view_iv.setImageURI(images);
        }
        holder.sousuo_liebiao_item_view_tv1.setText(data.get(position).getTitle());
        holder.sousuo_liebiao_item_view_tv2.setText(data.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolber1 extends  RecyclerView.ViewHolder{

        private final SimpleDraweeView sousuo_liebiao_item_view_iv;
        private final TextView sousuo_liebiao_item_view_tv1;
        private final TextView sousuo_liebiao_item_view_tv2;

        public MyViewHolber1(View itemView) {
            super(itemView);
            sousuo_liebiao_item_view_iv = itemView.findViewById(R.id.sousuo_liebiao_item_view_iv);
            sousuo_liebiao_item_view_tv1 = itemView.findViewById(R.id.sousuo_liebiao_item_view_tv1);
            sousuo_liebiao_item_view_tv2 = itemView.findViewById(R.id.sousuo_liebiao_item_view_tv2);
        }
    }

}
