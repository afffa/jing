package ss.com.lbs.jingdong01.presenters.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.bean.JuiGongGeBean;

/**
 * author:Created by WangZhiQiang on 2018/4/10.
 */

public class Myjiugongge_Adapter extends RecyclerView.Adapter<Myjiugongge_Adapter.MyViewHolber> {

    Context context;
    JuiGongGeBean juiGongGeBean;
    private Itemclick item;

    public Myjiugongge_Adapter(Context context, JuiGongGeBean juiGongGeBean) {
        this.context = context;
        this.juiGongGeBean = juiGongGeBean;
    }

    @Override
    public MyViewHolber onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jiugongge_view, parent, false);
        MyViewHolber myViewHolber = new MyViewHolber(view);
        return myViewHolber;
    }

    @Override
    public void onBindViewHolder(final MyViewHolber holder, final int position) {
        String icon = juiGongGeBean.getData().get(position).getIcon();
        if (icon.contains("|")){
            String[] split = icon.split("\\|");
            holder.jiugongge_iv.setImageURI(split[0]);
        }else {
            holder.jiugongge_iv.setImageURI(icon);
        }
        holder.jiugongge_tv.setText(juiGongGeBean.getData().get(position).getName());
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
        return juiGongGeBean.getData().size();
    }

    class MyViewHolber extends RecyclerView.ViewHolder{

        private final SimpleDraweeView jiugongge_iv;
        private final TextView jiugongge_tv;

        public MyViewHolber(View itemView) {
            super(itemView);
            jiugongge_iv = itemView.findViewById(R.id.jiugongge_iv);
            jiugongge_tv = itemView.findViewById(R.id.jiugongge_tv);
        }
    }
    //定义接口
    public interface Itemclick{
        void itemclick(View view,int position);
    }

    //定义方法   参数1为接口  2为接口的变量名
    public void OnClickItemjiu(Itemclick item){
        this.item=item;
    }

}
