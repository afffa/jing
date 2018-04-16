package ss.com.lbs.jingdong01.presenters.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.bean.FenZiListBean;

/**
 * author:Created by WangZhiQiang on 2018/4/11.
 */

public class My_Fen_List_recy_Adapters extends RecyclerView.Adapter<My_Fen_List_recy_Adapters.MyViewHolber> {

    Context context;
    FenZiListBean.DataBean dataBean;
    private Itemclick item;

    public My_Fen_List_recy_Adapters(Context context, FenZiListBean.DataBean dataBean) {
        this.context = context;
        this.dataBean = dataBean;
    }

    @Override
    public MyViewHolber onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fen_list_view_item2_recy_view, parent, false);
        MyViewHolber myViewHolber = new MyViewHolber(view);
        return myViewHolber;
    }

    @Override
    public void onBindViewHolder(final MyViewHolber holder, final int position) {
        String icon = dataBean.getList().get(position).getIcon();
        if (icon.contains("|")) {
            String[] split = icon.split("\\|");
            holder.fen_list_view_item1_recy1_iv.setImageURI(split[0]);
        }else {
            holder.fen_list_view_item1_recy1_iv.setImageURI(icon);
        }
        holder.fen_list_view_item1_recy1_tv.setText(dataBean.getList().get(position).getName());


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
        return dataBean.getList().size();
    }

    class MyViewHolber extends RecyclerView.ViewHolder {

        private final TextView fen_list_view_item1_recy1_tv;
        private final SimpleDraweeView fen_list_view_item1_recy1_iv;

        public MyViewHolber(View itemView) {
            super(itemView);
            fen_list_view_item1_recy1_iv = itemView.findViewById(R.id.fen_list_view_item1_recy1_iv);
            fen_list_view_item1_recy1_tv = itemView.findViewById(R.id.fen_list_view_item1_recy1_tv);
        }
    }

    //定义接口
    public interface Itemclick{
        void itemclick(View view,int position);
    }

    //定义方法   参数1为接口  2为接口的变量名
    public void onItem(Itemclick item){
        this.item=item;
    }


}
