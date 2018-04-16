package ss.com.lbs.jingdong01.presenters.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.activity.FenLei_LieBiao_Activity;
import ss.com.lbs.jingdong01.bean.FenZiListBean;

/**
 * author:Created by WangZhiQiang on 2018/4/11.
 */

public class My_Zi_Fen_ListAdapters extends BaseExpandableListAdapter {

    Context context;
    FenZiListBean fenZiListBean;
    private MyHolber1 myHolber1;
    private MyHolber2 myHolber2;

    public My_Zi_Fen_ListAdapters(Context context, FenZiListBean fenZiListBean) {
        this.context = context;
        this.fenZiListBean = fenZiListBean;
    }

    @Override
    public int getGroupCount() {
        return fenZiListBean.getData().size();
    }

    @Override
    public int getChildrenCount(int i) {
        return fenZiListBean.getData().get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return fenZiListBean.getData().get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return fenZiListBean.getData().get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            myHolber1 = new MyHolber1();
            view = View.inflate(context, R.layout.fen_list_view_item1, null);
            view.setTag(myHolber1);
        }else {
            view.getTag();
        }
        myHolber1.tv = view.findViewById(R.id.fen_list_view_item1_tv);
        myHolber1.tv.setText(fenZiListBean.getData().get(i).getName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            myHolber2 = new MyHolber2();
            view = View.inflate(context, R.layout.fen_list_view_item2, null);
            view.setTag(myHolber2);
        }else {
            view.getTag();
        }
        myHolber2.recyc1 = view.findViewById(R.id.fen_list_view_item1_recy1);
        myHolber2.recyc1.setLayoutManager(new GridLayoutManager(context,3));
        final FenZiListBean.DataBean dataBean = fenZiListBean.getData().get(i);
        My_Fen_List_recy_Adapters my_fen_list_recy_adapters = new My_Fen_List_recy_Adapters(context,dataBean);
        myHolber2.recyc1.setAdapter(my_fen_list_recy_adapters);
        my_fen_list_recy_adapters.onItem(new My_Fen_List_recy_Adapters.Itemclick() {
            @Override
            public void itemclick(View view, int position) {
                Intent intent = new Intent(context, FenLei_LieBiao_Activity.class);
                intent.putExtra("pid",""+dataBean.getList().get(position).getPscid());
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class MyHolber1{
        TextView tv;
    }
    class MyHolber2{
        RecyclerView recyc1;
    }
}
