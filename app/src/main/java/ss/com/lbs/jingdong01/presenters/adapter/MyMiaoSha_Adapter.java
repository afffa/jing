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

public class MyMiaoSha_Adapter extends RecyclerView.Adapter<MyMiaoSha_Adapter.MyViewHolber> {
    Context context;
    ShouYeBean shouYeBean;
    private Itemclick item;

    public MyMiaoSha_Adapter(Context context, ShouYeBean shouYeBean) {
        this.context = context;
        this.shouYeBean = shouYeBean;
    }

    @Override
    public MyViewHolber onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.miaosha_view, parent, false);
        MyViewHolber myViewHolber = new MyViewHolber(view);
        return myViewHolber;
    }

    @Override
    public void onBindViewHolder(final MyViewHolber holder, final int position) {
        String images1 = shouYeBean.getMiaosha().getList().get(position).getImages();
        if (images1.contains("|")) {
            String[] split1 = images1.split("\\|");
            holder.miaosha_iv.setImageURI(split1[0]);
        }else {
            holder.miaosha_iv.setImageURI(images1);
        }
        holder.miaosha_tv1.setText(shouYeBean.getMiaosha().getList().get(position).getTitle());
        holder.miaosha_tv2.setText("￥"+shouYeBean.getMiaosha().getList().get(position).getPrice());

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
        return shouYeBean.getMiaosha().getList().size();
    }

    class MyViewHolber extends RecyclerView.ViewHolder{

        private final SimpleDraweeView miaosha_iv;
        private final TextView miaosha_tv1;
        private final TextView miaosha_tv2;

        public MyViewHolber(View itemView) {
            super(itemView);
            miaosha_iv = itemView.findViewById(R.id.miaosha_iv);
            miaosha_tv1 = itemView.findViewById(R.id.miaosha_tv1);
            miaosha_tv2 = itemView.findViewById(R.id.miaosha_tv2);
        }
    }

    //定义接口
    public interface Itemclick{
        void itemclick(View view,int position);
    }

    //定义方法   参数1为接口  2为接口的变量名
    public void onClickItem(Itemclick item){
        this.item=item;
    }

}
