package ss.com.lbs.jingdong01.fragments;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ss.com.lbs.jingdong01.R;
import ss.com.lbs.jingdong01.activity.DengLu_ZhuCe;
import ss.com.lbs.jingdong01.activity.XiangQingxinxi;
import ss.com.lbs.jingdong01.bean.AddGouWuCheBean;
import ss.com.lbs.jingdong01.bean.ChuangJianDingDan;
import ss.com.lbs.jingdong01.bean.DingDanLieBiaoBean;
import ss.com.lbs.jingdong01.bean.FenLei_LieBiao_Bean;
import ss.com.lbs.jingdong01.bean.FenZiListBean;
import ss.com.lbs.jingdong01.bean.GouWuChechaBean;
import ss.com.lbs.jingdong01.bean.JuiGongGeBean;
import ss.com.lbs.jingdong01.bean.RemoveGouWuCheBean;
import ss.com.lbs.jingdong01.bean.ShouYeBean;
import ss.com.lbs.jingdong01.bean.SouSuoShangPinBean;
import ss.com.lbs.jingdong01.bean.XiangQingBean;
import ss.com.lbs.jingdong01.bean.ZhuCeBean;
import ss.com.lbs.jingdong01.moudle.LogMoudle;
import ss.com.lbs.jingdong01.presenters.LogPresenters;
import ss.com.lbs.jingdong01.presenters.adapter.MywdtjAdapter;
import ss.com.lbs.jingdong01.utils.UploadUtil;
import ss.com.lbs.jingdong01.view.OnView;

import static android.content.Context.MODE_PRIVATE;

/**
 * author:Created by WangZhiQiang on 2018/4/9.
 */

public class MyDe_frag extends Fragment implements OnView,UploadUtil.OnUploadProcessListener {

    private TextView denglu_tv;
    private LogPresenters logPresenters;
    private RecyclerView myde_recy2;
    boolean ss;
    private boolean boo1;
    private ImageView tuichu_dneglu;
    private ImageView mImageView;
    private static final int PHOTO_REQUEST = 1;
    private static final int CAMERA_REQUEST = 2;
    private static final int PHOTO_CLIP = 3;
    private static final int UPLOAD_INIT_PROCESS = 4;//上传初始化
    protected static final int UPLOAD_FILE_DONE = 2;//上传中
    private static final int UPLOAD_IN_PROCESS = 5;//上传文件响应
    private ProgressDialog pd;
    private File filepath;//返回的文件地址




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myde_frag_view, container, false);
        //实例p
        logPresenters = new LogPresenters();
        //调用p首页方法主要获取首页推荐
        logPresenters.getShouYe(this,new LogMoudle());
        logPresenters.getChuangJianDingDan(this,new LogMoudle(),"12588","5199");
        logPresenters.getDingDanLieBiao(this,new LogMoudle(),"12588");
        denglu_tv = view.findViewById(R.id.my_name);
        myde_recy2 = view.findViewById(R.id.myde_recy2);
        mImageView = view.findViewById(R.id.myde_touxiang);

        tuichu_dneglu = view.findViewById(R.id.tuichu_dneglu);
        //布局管理器
        myde_recy2.setLayoutManager(new GridLayoutManager(getActivity(),2));
        ///d登录成功

        //退出登录事件
        tuichu_dneglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences data2 = getActivity().getSharedPreferences("data2", MODE_PRIVATE);
                SharedPreferences.Editor edit = data2.edit();
                edit.putBoolean("boo",false);
                edit.putString("kname","请登录，谢谢" );
                edit.commit();
                boolean boo = data2.getBoolean("boo", false);
                String kname = data2.getString("kname", denglu_tv+"");
                denglu_tv.setText(kname);
                boo1 = boo;
            }
        });

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog builder = new AlertDialog.Builder(getActivity())
                        .setTitle("选择头像")
                        .setPositiveButton("相机", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                getCamera();

                            }
                        })
                        .setNegativeButton("相册", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                getPhoto();

                            }
                        })
                        .show();
            }
        });






        return view;
    }



    private void getPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        startActivityForResult(intent, PHOTO_REQUEST);
    }



    private void getCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 下面这句指定调用相机拍照后的照片存储的路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(
                Environment.getExternalStorageDirectory(), "hand.jpg")));
        startActivityForResult(intent, CAMERA_REQUEST);
    }




    private void photoClip(Uri uri) {
        // 调用系统中自带的图片剪裁
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTO_CLIP);
    }


    private void toUploadFile() {
        pd = ProgressDialog.show(getActivity(), "", "正在上传文件...");
        pd.show();
        String fileKey = "avatarFile";
        UploadUtil uploadUtil = UploadUtil.getInstance();
        uploadUtil.setOnUploadProcessListener(MyDe_frag.this); //设置监听器监听上传状态

        Map<String, String> params = new HashMap<String, String>();//上传map对象
        params.put("userId", "");
        uploadUtil.uploadFile(filepath, fileKey, "上传头像的地址", params);
        Toast.makeText(getActivity(), "上传成功", Toast.LENGTH_LONG).show();
    }



    @Override
    public void onUploadDone(int responseCode, String message) {

        pd.dismiss();
        Message msg = Message.obtain();
        msg.what = UPLOAD_FILE_DONE;
        msg.arg1 = responseCode;
        msg.obj = message;
    }

    @Override
    public void onUploadProcess(int uploadSize) {

        //上传中
        Message msg = Message.obtain();
        msg.what = UPLOAD_IN_PROCESS;
        msg.arg1 = uploadSize;
    }

    @Override
    public void initUpload(int fileSize) {

        //准备上传
        Message msg = Message.obtain();
        msg.what = UPLOAD_INIT_PROCESS;
        msg.arg1 = fileSize;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_REQUEST:
                switch (resultCode) {
                    case -1://-1表示拍照成功
                        File file = new File(Environment.getExternalStorageDirectory()
                                + "/hand.jpg");//保存图片
                        if (file.exists()) {
                            //对相机拍照照片进行裁剪
                            photoClip(Uri.fromFile(file));
                        }
                }
                break;

            case PHOTO_REQUEST://从相册取
                if (data != null) {
                    Uri uri = data.getData();
                    //对相册取出照片进行裁剪
                    photoClip(uri);

                }
                break;
            case PHOTO_CLIP:
                //完成
                if (data != null) {

                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        Bitmap photo = extras.getParcelable("data");
                        try {
                            //获得图片路径
                            filepath = UploadUtil.saveFile(photo, Environment.getExternalStorageDirectory().toString(), "hand.jpg");
                            //上传照片
                            toUploadFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //上传完成将照片写入imageview与用户进行交互
                        mImageView.setImageBitmap(photo);
                    }
                }
                break;
        }
    }







    @Override
    public void onSuccessM(Object object) {
    }

    @Override
    public void onzhuce(ZhuCeBean object) {

    }

    @Override
    public void onshouye(ShouYeBean shouYeBean) {
        //首页接口回调方法
//        Log.i("LLL",""+shouYeBean.getTuijian().getList().get(0).getTitle());
        //取出推荐
        ShouYeBean.TuijianBean tuijian = shouYeBean.getTuijian();
        final List<ShouYeBean.TuijianBean.ListBean> list = tuijian.getList();
        //添加适配器
        MywdtjAdapter mywdtjAdapter = new MywdtjAdapter(getActivity(),list);
        myde_recy2.setAdapter(mywdtjAdapter);
        //适配器单击事件
        mywdtjAdapter.huidiao(new MywdtjAdapter.Itemclick() {
            @Override
            public void itemclick(View view, int position) {
//                TextView wdtj_tv3 = view.findViewById(R.id.wdtj_tv3);
//                String string = wdtj_tv3.getText().toString();
                //获取pid跳转到详情
                String pid = list.get(position).getPid();
                Intent intent = new Intent(getActivity(), XiangQingxinxi.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onXiangqing(XiangQingBean xiangQingBean) {

    }

    @Override
    public void onJuiGongGe(JuiGongGeBean juiGongGeBean) {

    }

    @Override
    public void onFenZiLei(FenZiListBean fenZiListBean) {

    }

    @Override
    public void onGouWuChe(GouWuChechaBean gouWuChechaBean) {

    }

    @Override
    public void heji() {


    }

    @Override
    public void onFenLei_LieBiao(FenLei_LieBiao_Bean fenLei_lieBiao) {

    }

    @Override
    public void onAddGouWuChe(AddGouWuCheBean addGouWuCheBean) {

    }

    @Override
    public void onRemoveGouWiuChe(RemoveGouWuCheBean removeGouWuCheBean) {

    }

    @Override
    public void onSouSuoShangPin(SouSuoShangPinBean souSuoShangPinBean) {
    }

    @Override
    public void onChuangJianDingDan(ChuangJianDingDan chuangJianDingDan) {
        Log.i("LLLLCJDD",""+chuangJianDingDan.getMsg());
    }

    @Override
    public void onDingDanLieBiao(DingDanLieBiaoBean dingDanLieBiaoBean) {
        Log.i("LLLLDDLB",""+dingDanLieBiaoBean.getMsg());
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences data2 = getActivity().getSharedPreferences("data2", MODE_PRIVATE);
        String data21 = data2.getString("kname",denglu_tv+"" );
        boo1 = data2.getBoolean("boo", ss);
        ///d登录成功
        if (boo1 ==true){
            denglu_tv.setText(data21);
        }else if (boo1 ==false){
            denglu_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (boo1 ==false){
                        //登录Activity
                        Intent intent = new Intent(getActivity(), DengLu_ZhuCe.class);
                        startActivity(intent);
                    }else {
                    }
                }
            });
        }
    }
}
