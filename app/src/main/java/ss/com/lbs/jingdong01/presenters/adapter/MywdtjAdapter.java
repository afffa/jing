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
import ss.com.lbs.jingdong01.bean.ShouYeBean;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class MywdtjAdapter extends RecyclerView.Adapter<MywdtjAdapter.MyViewHolber> {
    Context context;
    List<ShouYeBean.TuijianBean.ListBean> list;
    private Itemclick item;

    public MywdtjAdapter(Context context, List<ShouYeBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolber onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wdtj_view, parent, false);
        MyViewHolber myViewHolber = new MyViewHolber(view);
        return myViewHolber;
    }

    @Override
    public void onBindViewHolder(final MyViewHolber holder, final int position) {
        holder.wdtj_tv1.setText(list.get(position).getTitle());
        holder.wdtj_tv2.setText(list.get(position).getSubhead());
        holder.wdtj_tv3.setText(list.get(position).getPid());
        String images = list.get(position).getImages();
        if (images.contains("|")){
            String[] split = images.split("\\|");
            holder.wdtj_iv.setImageURI(split[0]);
        }else {
            holder.wdtj_iv.setImageURI(images);
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
        return list.size();
    }

    class MyViewHolber extends RecyclerView.ViewHolder{

        private final SimpleDraweeView wdtj_iv;
        private final TextView wdtj_tv1;
        private final TextView wdtj_tv2;
        private final TextView wdtj_tv3;

        public MyViewHolber(View itemView) {
            super(itemView);
            wdtj_iv = itemView.findViewById(R.id.wdtj_iv);
            wdtj_tv1 = itemView.findViewById(R.id.wdtj_tv1);
            wdtj_tv2 = itemView.findViewById(R.id.wdtj_tv2);
            wdtj_tv3 = itemView.findViewById(R.id.wdtj_tv3);
        }
    }

    //定义接口
    public interface Itemclick{
        void itemclick(View view,int position);
    }

    //定义方法   参数1为接口  2为接口的变量名
    public void huidiao(Itemclick item){
        this.item=item;
    }

}
