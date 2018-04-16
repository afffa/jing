package ss.com.lbs.jingdong01.presenters.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.activity.XiangQingxinxi;
import ss.com.lbs.jingdong01.bean.JuiGongGeBean;
import ss.com.lbs.jingdong01.bean.ShouYeBean;

/**
 * author:Created by WangZhiQiang on 2018/4/10.
 */

public class MyxrecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private ShouYeBean shouYeBean;
    private JuiGongGeBean juiGongGeBean;
    private static final int TWO = 0;
    private static final int THREE = 1;
    private static final int FOUR = 2;

    public MyxrecyAdapter(Context context, ShouYeBean shouYeBean, JuiGongGeBean juiGongGeBean) {
        this.context = context;
        this.shouYeBean = shouYeBean;
        this.juiGongGeBean = juiGongGeBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TWO) {
            View view = LayoutInflater.from(context).inflate(R.layout.sxrecy_item_view2, parent, false);
            ViewHolder2 viewHolder2 = new ViewHolder2(view);
            return viewHolder2;
        } else if (viewType == THREE) {
            View view = LayoutInflater.from(context).inflate(R.layout.sxrecy_item_view3, parent, false);
            ViewHolder3 viewHolder3 = new ViewHolder3(view);
            return viewHolder3;
        } else if (viewType == FOUR) {
            View view = LayoutInflater.from(context).inflate(R.layout.sxrecy_item_view4, parent, false);
            ViewHolder4 viewHolder4 = new ViewHolder4(view);
            return viewHolder4;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder2) {
            RecyclerView shou_item2_recy = ((ViewHolder2) holder).shou_item2_recy;
            StaggeredGridLayoutManager staggered2 = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            shou_item2_recy.setLayoutManager(staggered2);
            Myjiugongge_Adapter myjiugongge_adapter = new Myjiugongge_Adapter(context, juiGongGeBean);
            shou_item2_recy.setAdapter(myjiugongge_adapter);
            myjiugongge_adapter.OnClickItemjiu(new Myjiugongge_Adapter.Itemclick() {
                @Override
                public void itemclick(View view, int position) {
//                    int cid = juiGongGeBean.getData().get(position).getCid();
                    Toast.makeText(context, "您单击啦："+juiGongGeBean.getData().get(position).getName(), Toast.LENGTH_SHORT).show();
                }
            });

        } else if (holder instanceof ViewHolder3) {
            RecyclerView shou_item3_recy = ((ViewHolder3) holder).shou_item3_recy;
            LinearLayoutManager layoutManager2 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
            shou_item3_recy.setLayoutManager(layoutManager2);
            MyMiaoSha_Adapter myMiaoSha_adapter = new MyMiaoSha_Adapter(context, shouYeBean);
            myMiaoSha_adapter.onClickItem(new MyMiaoSha_Adapter.Itemclick() {
                @Override
                public void itemclick(View view, int position) {
                    int pid = shouYeBean.getMiaosha().getList().get(position).getPid();
                    Intent intent = new Intent(context,XiangQingxinxi.class);
                    intent.putExtra("pid",""+pid);
                    context.startActivity(intent);
                }
            });

            shou_item3_recy.setAdapter(myMiaoSha_adapter);
        } else {
            RecyclerView shou_item4_recy = ((ViewHolder4) holder).shou_item4_recy;
            GridLayoutManager layoutManager3 = new GridLayoutManager(context,2);
            shou_item4_recy.setLayoutManager(layoutManager3);
            MyTuiJian_Adapter myTuiJian_adapter = new MyTuiJian_Adapter(context,shouYeBean);
            myTuiJian_adapter.huidiao(new MyTuiJian_Adapter.Itemclick() {

                private TextView tuijian_tv3;

                @Override
                public void itemclick(View view, int position) {
                    tuijian_tv3 = view.findViewById(R.id.tuijian_tv3);
                    String string = tuijian_tv3.getText().toString();
                    Intent intent = new Intent(context, XiangQingxinxi.class);
                    intent.putExtra("pid",""+string);
                    context.startActivity(intent);
                }
            });
            shou_item4_recy.setAdapter(myTuiJian_adapter);
        }
    }

    //多条目
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TWO;
        } else if (position == 1) {
            return THREE;
        } else {
            return FOUR;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        private final RecyclerView shou_item2_recy;

        public ViewHolder2(View itemView) {
            super(itemView);
            shou_item2_recy = itemView.findViewById(R.id.shou_item2_recy);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {

        private final RecyclerView shou_item3_recy;

        public ViewHolder3(View itemView) {
            super(itemView);
            shou_item3_recy = itemView.findViewById(R.id.shou_item3_recy);
        }
    }

    class ViewHolder4 extends RecyclerView.ViewHolder {

        private final RecyclerView shou_item4_recy;

        public ViewHolder4(View itemView) {
            super(itemView);
            shou_item4_recy = itemView.findViewById(R.id.shou_item4_recy);
        }
    }
}
