package qyw.xhx.zwzs;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.dialog.widget.base.BaseDialog;
import com.squareup.picasso.Picasso;

public class AdDialog extends BaseDialog<AdDialog> {
    private Context context;
    private ImageView iv_ad;
    private ImageView back;
    private TextView ts;
    private String bbcode;
    private String bbnr;
    private Button sjbtn;
    private TextView title;


    public AdDialog(Context context,String bbcode,String bbnr) {
        super(context);
        this.context = context;
        this.bbcode = bbcode;
        this.bbnr = bbnr;
    }

    //该方法用来出来数据初始化代码
    @Override
    public View onCreateView() {
        widthScale(0.85f);
        //填充弹窗布局
        View inflate = View.inflate(context, R.layout.update_dialog, null);
        //用来放整个图片的控件
        iv_ad = (ImageView) inflate.findViewById(R.id.iv_ad);
        title=(TextView) inflate.findViewById(R.id.tv_title);
        title.setText("已有最新版本"+bbcode);
        ts = (TextView) inflate.findViewById(R.id.tv_update_info);
//        ts.setText("1、升级\n2、升级");
        ts.setText(bbnr);
        sjbtn = (Button) inflate.findViewById(R.id.btn_update);
        //放在透明部分和错号上的隐形控件，用来点击使弹窗消失
//        back = (ImageView) inflate.findViewById(R.id.ad_back);
        //用来加载网络图片，填充iv_ad控件，注意要添加网络权限，和Picasso的依赖和混淆
        int resourceId = R.mipmap.xupdate_bg_app_top;
        Picasso.with(context)
                .load(resourceId)
                .into(iv_ad);
//        int backId = R.mipmap.xupdate_icon_app_close;
//        Picasso.with(context)
////                .load("https://img-blog?.csdn.net/20170906094014301?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzY2MjE5OTA=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast")
//                .load(backId)
//                .into(back);
        return inflate;
    }
    //该方法用来处理逻辑代码
    @Override
    public void setUiBeforShow() {
        //点击弹窗相应位置，处理相关逻辑。
//        iv_ad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"哈哈",Toast.LENGTH_SHORT).show();
//                //处理完逻辑关闭弹框的代码
//                dismiss();
//            }
//        });
        sjbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"shengji",Toast.LENGTH_SHORT).show();
                //处理完逻辑关闭弹框的代码
                dismiss();
            }
        });
        //点×关闭弹框的代码
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //关闭弹框的代码
//                dismiss();
//            }
//        });
    }
}