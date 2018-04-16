package ss.com.lbs.jingdong01.presenters.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.bean.ShouYeBean;

/**
 * author:Created by WangZhiQiang on 2018/4/10.
 */

public class MyTuiJian_Adapter extends RecyclerView.Adapter<MyTuiJian_Adapter.MyViewHolber> {

    Context context;
    ShouYeBean shouYeBean;
    private Itemclick item;
    public MyTuiJian_Adapter(Context context, ShouYeBean shouYeBean) {
        this.context = context;
        this.shouYeBean = shouYeBean;
    }

    @Override
    public MyViewHolber onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tuijian_view, parent, false);
        MyViewHolber myViewHolber = new MyViewHolber(view);
        return myViewHolber;
    }

    @Override
    public void onBindViewHolder(final MyViewHolber holder, final int position) {
        holder.tuijian_tv1.setText(shouYeBean.getTuijian().getList().get(position).getTitle());
        holder.tuijian_tv2.setText(shouYeBean.getTuijian().getList().get(position).getSubhead());
        holder.tuijian_tv3.setText(shouYeBean.getTuijian().getList().get(position).getPid());
        String images = shouYeBean.getTuijian().getList().get(position).getImages();
        if (images.contains("|")){
            String[] split = images.split("\\|");
            holder.tuijian_iv.setImageURI(split[0]);
        }else {
            holder.tuijian_iv.setImageURI(images);
        }
        //item为接口的变量名
        if (item!=null){
            //holder为Myhodler holder的参数
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //调用接口的方法
                    item.itemclick(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return shouYeBean.getTuijian().getList().size();
    }

    class MyViewHolber extends RecyclerView.ViewHolder{

        private final SimpleDraweeView tuijian_iv;
        private final TextView tuijian_tv1;
        private final TextView tuijian_tv2;
        private final TextView tuijian_tv3;

        public MyViewHolber(View itemView) {
            super(itemView);
            tuijian_iv = itemView.findViewById(R.id.tuijian_iv);
            tuijian_tv1 = itemView.findViewById(R.id.tuijian_tv1);
            tuijian_tv2 = itemView.findViewById(R.id.tuijian_tv2);
            tuijian_tv3 = itemView.findViewById(R.id.tuijian_tv3);
        }
    }

    //定义接口
    public interface Itemclick{
        void itemclick(View view,int position);
    }

    //定义方法   参数1为接口  2为接口的变量名
    public void huidiao(Itemclick item){
        this.item = item;
    }

}
