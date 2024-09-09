package com.acse.ottn.service;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.acse.ottn.R;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.Ha;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.util.ra;
import com.acse.ottn.widget.RoundRectImageView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.TimerTask;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Y {

    /* renamed from: a  reason: collision with root package name */
    private static String f6415a = "ViewUtil";

    /* renamed from: b  reason: collision with root package name */
    private static Y f6416b;

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f6417c;

    /* renamed from: d  reason: collision with root package name */
    float f6418d;

    /* renamed from: e  reason: collision with root package name */
    float f6419e;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void a();

        void a(String str);
    }

    private Y() {
    }

    private void a(Context context, RelativeLayout relativeLayout, AccessiblityModel accessiblityModel, a aVar) {
        relativeLayout.setOnTouchListener(new N(this, relativeLayout, relativeLayout.getY(), relativeLayout.getX(), aVar, accessiblityModel, context));
    }

    private void a(ImageView imageView, a aVar) {
        imageView.setOnClickListener(new C(this, aVar));
    }

    private void a(ImageView imageView, String str, a aVar) {
        imageView.setOnClickListener(new D(this, str, aVar));
    }

    public static void a(a aVar) {
        TimerTask timerTask = f6417c;
        if (timerTask != null) {
            timerTask.cancel();
            f6417c = null;
        }
        c();
        if (aVar != null) {
            aVar.a();
        }
    }

    public static void a(String str, a aVar) {
        c();
        if (aVar != null) {
            aVar.a(str);
        }
    }

    private boolean a(String str) {
        return TextUtils.isEmpty(str);
    }

    public static Y b() {
        if (f6416b == null) {
            synchronized (Y.class) {
                if (f6416b == null) {
                    f6416b = new Y();
                }
            }
        }
        return f6416b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i4, a aVar) {
        f6417c = com.acse.ottn.util.S.a().b(i4, 500, new C1411v(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("limitType", PangleAdapterUtils.MEDIA_EXTRA_COUPON);
        treeMap.put("is_snt", "0");
        treeMap.put("package_name", str);
        new com.acse.ottn.a.a().o(com.acse.ottn.util.V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.util.F.a()).subscribe(new O(this), new P(this));
    }

    private static void b(String str, a aVar) {
        c();
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public static void c() {
        try {
            if (f6417c != null) {
                ra.a(f6415a, "timer is not null");
                f6417c.cancel();
                f6417c = null;
            }
        } catch (Exception unused) {
            ra.a(f6415a, "current window is Destroy");
        }
    }

    private Object d() throws ObjectStreamException {
        return f6416b;
    }

    public void a(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.baidu_wp_close).setOnClickListener(new U(this, aVar));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.baidu_wp);
        linearLayout.setOnClickListener(new V(this, context, accessiblityModel, aVar));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.baidu_wp_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.baidu_wp_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, aVar);
    }

    public void a(Context context, AccessiblityModel accessiblityModel, a aVar) {
        if (CommonUtil.isShwoToast) {
            HelpShopAppUtil.getInstance();
            Toast.makeText(context, HelpShopAppUtil.sessionNewID(), 1).show();
        }
        ra.c(f6415a, "\u5f00\u59cb\u70b9\u51fb");
        if (accessiblityModel == null || a(accessiblityModel.getData().getSpop_link()) || a(accessiblityModel.getData().getSpop_deeplink())) {
            return;
        }
        if (!"1".equals(accessiblityModel.getData().getPic_type())) {
            Ha.b().b(context, accessiblityModel);
            a(aVar);
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("spop_coupon_price", accessiblityModel.getData().getSpop_coupon_price());
        treeMap.put("app", accessiblityModel.getData().getPackage_name());
        treeMap.put("spop_link", accessiblityModel.getData().getSpop_link());
        new com.acse.ottn.a.c().b(com.acse.ottn.util.V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.util.F.a()).subscribe(new G(this, aVar, accessiblityModel, context), new Q(this, aVar));
    }

    public void a(View view, String str, a aVar) {
        ((TextView) view.findViewById(R.id.tv_close)).setOnClickListener(new J(this, str, aVar));
        ((ImageView) view.findViewById(R.id.iv_no_show_smill_close)).setOnClickListener(new K(this, aVar));
        b(4000, aVar);
    }

    public void b(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.taobao_close).setOnClickListener(new L(this, aVar));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_taobao_man);
        ImageView imageView = (ImageView) view.findViewById(R.id.taobao_main_box);
        imageView.setOnClickListener(new M(this, context, accessiblityModel, aVar));
        if (TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            return;
        }
        com.bumptech.glide.d.C(context).a(accessiblityModel.getData().getSpop_pic()).i1(imageView);
        linearLayout.setVisibility(0);
        b(10000, aVar);
    }

    public void c(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.tencent_close).setOnClickListener(new W(this, aVar));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.tencent_wp);
        linearLayout.setOnClickListener(new X(this, context, accessiblityModel, aVar));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.tencent_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.tencent_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, aVar);
    }

    public void d(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.aiqiyi_close).setOnClickListener(new S(this, aVar));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_aiqiyi);
        linearLayout.setOnClickListener(new T(this, context, accessiblityModel, aVar));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getNew_time_remaining()) || a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getOriginal_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.aiqiyi_monery)).setText(accessiblityModel.getData().getSpop_coupon_price());
        TextView textView = (TextView) view.findViewById(R.id.aiqiyi_all_monery);
        textView.setText(accessiblityModel.getData().getOriginal_price());
        textView.getPaint().setFlags(16);
        ((TextView) view.findViewById(R.id.aiqiyi_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, aVar);
    }

    public void e(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.youku_close).setOnClickListener(new View$OnClickListenerC1402l(this, aVar));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.youku_wp);
        linearLayout.setOnClickListener(new View$OnClickListenerC1403m(this, context, accessiblityModel, aVar));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.youku_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.youku_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, aVar);
    }

    public void f(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.didi_close).setOnClickListener(new A(this, aVar));
        ((LinearLayout) view.findViewById(R.id.didi_big)).setOnClickListener(new B(this, context, accessiblityModel, aVar));
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void g(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        TextView textView = (TextView) view.findViewById(R.id.didi_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.didi_small_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.didi_small);
        a((ImageView) view.findViewById(R.id.iv_didi_close), aVar);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_didi_setting), accessiblityModel.getData().getPackage_name(), aVar);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, aVar);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void h(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        TextView textView = (TextView) view.findViewById(R.id.meituan_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.meituan_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.meituan_small_layout);
        a((ImageView) view.findViewById(R.id.iv_meituan_smile_close), aVar);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_meituan_smile_setting), accessiblityModel.getData().getPackage_name(), aVar);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, aVar);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void i(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.meituan_close).setOnClickListener(new E(this, aVar));
        view.setOnClickListener(new F(this, context, accessiblityModel, aVar));
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void j(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.iv_close).setOnClickListener(new View$OnClickListenerC1404n(this, aVar));
        ((ImageView) view.findViewById(R.id.taobao_treasure_box)).setOnClickListener(new View$OnClickListenerC1405o(this, context, accessiblityModel, aVar));
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(R.id.tb_coupon_price)).setText("\u00a5" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.tb_textview)).setText(accessiblityModel.getData().getSpop_coupon_title());
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void k(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.jd_lijin_close).setOnClickListener(new View$OnClickListenerC1412w(this, aVar));
        ((LinearLayout) view.findViewById(R.id.jd_lijin_big)).setOnClickListener(new View$OnClickListenerC1413x(this, context, accessiblityModel, aVar));
        com.bumptech.glide.d.C(context).p(Integer.valueOf(R.mipmap.cash)).i1((ImageView) view.findViewById(R.id.jd_lijin_coupon_price));
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void l(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_tb_big_recommend_icon);
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            com.bumptech.glide.d.C(context).a(accessiblityModel.getData().getSpop_pic()).i1(roundRectImageView);
        }
        TextView textView = (TextView) view.findViewById(R.id.tb_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.tb_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tb_small);
        a((ImageView) view.findViewById(R.id.iv_smill_close), aVar);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_setting);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a(imageView, accessiblityModel.getData().getPackage_name(), aVar);
        a(context, relativeLayout, accessiblityModel, aVar);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void m(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.xbk_close).setOnClickListener(new H(this, aVar));
        view.setOnClickListener(new I(this, context, accessiblityModel, aVar));
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void n(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.eleme_close).setOnClickListener(new View$OnClickListenerC1414y(this, aVar));
        view.setOnClickListener(new View$OnClickListenerC1415z(this, context, accessiblityModel, aVar));
        if (a(accessiblityModel.getData().getSpop_coupon_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.eleme_coupon_price)).setText("\u00a5" + accessiblityModel.getData().getSpop_coupon_price());
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void o(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        TextView textView = (TextView) view.findViewById(R.id.eleme_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.eleme_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.eleme_small_layout);
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_close), aVar);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_setting), accessiblityModel.getData().getPackage_name(), aVar);
        a(context, relativeLayout, accessiblityModel, aVar);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void p(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.hxz_close).setOnClickListener(new View$OnClickListenerC1406p(this, aVar));
        ((LinearLayout) view.findViewById(R.id.hxz_big)).setOnClickListener(new View$OnClickListenerC1407q(this, context, accessiblityModel, aVar));
        if (a(accessiblityModel.getData().getNew_time_remaining()) || a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(R.id.hxz_content_info)).setText(accessiblityModel.getData().getNew_time_remaining());
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void q(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.jd_close).setOnClickListener(new r(this, aVar));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.jd_big);
        linearLayout.setOnClickListener(new View$OnClickListenerC1408s(this, context, accessiblityModel, aVar));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.jd_coupon_price)).setText("\u00a5" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.jd_action_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void r(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        view.findViewById(R.id.jd_lijin_close).setOnClickListener(new View$OnClickListenerC1409t(this, aVar));
        ((LinearLayout) view.findViewById(R.id.jd_lijin_big)).setOnClickListener(new View$OnClickListenerC1410u(this, context, accessiblityModel, aVar));
        com.bumptech.glide.d.C(context).p(Integer.valueOf(R.mipmap.cash)).i1((ImageView) view.findViewById(R.id.jd_lijin_coupon_price));
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }

    public void s(Context context, View view, AccessiblityModel accessiblityModel, a aVar) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_jd_recommend_icon);
        TextView textView = (TextView) view.findViewById(R.id.jd_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.jd_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.jd_small);
        a((ImageView) view.findViewById(R.id.iv_jd_smill_close), aVar);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_pic()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_jd_smill_setting), accessiblityModel.getData().getPackage_name(), aVar);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, aVar);
        com.bumptech.glide.d.C(context).a(accessiblityModel.getData().getSpop_pic()).i1(roundRectImageView);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b((int) AVMDLDataLoader.KeyIsLiveSetLoaderType, aVar);
    }
}
