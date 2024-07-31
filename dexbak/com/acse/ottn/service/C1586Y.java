package com.acse.ottn.service;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.acse.ottn.C1239R;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.p030a.C1249a;
import com.acse.ottn.p030a.C1252c;
import com.acse.ottn.util.C1632Ha;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.ExecutorC1627F;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.widget.RoundRectImageView;
import com.bumptech.glide.Glide;
import com.clj.fastble.BleManager;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.TimerTask;
import java.util.TreeMap;

/* renamed from: com.acse.ottn.service.Y */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1586Y {

    /* renamed from: a */
    private static String f3041a = "ViewUtil";

    /* renamed from: b */
    private static C1586Y f3042b;

    /* renamed from: c */
    public static TimerTask f3043c;

    /* renamed from: d */
    float f3044d;

    /* renamed from: e */
    float f3045e;

    /* renamed from: com.acse.ottn.service.Y$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1587a {
        /* renamed from: a */
        void mo56359a();

        /* renamed from: a */
        void mo56358a(String str);
    }

    private C1586Y() {
    }

    /* renamed from: a */
    private void m56392a(Context context, RelativeLayout relativeLayout, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        relativeLayout.setOnTouchListener(new View$OnTouchListenerC1574N(this, relativeLayout, relativeLayout.getY(), relativeLayout.getX(), interfaceC1587a, accessiblityModel, context));
    }

    /* renamed from: a */
    private void m56389a(ImageView imageView, InterfaceC1587a interfaceC1587a) {
        imageView.setOnClickListener(new View$OnClickListenerC1563C(this, interfaceC1587a));
    }

    /* renamed from: a */
    private void m56388a(ImageView imageView, String str, InterfaceC1587a interfaceC1587a) {
        imageView.setOnClickListener(new View$OnClickListenerC1564D(this, str, interfaceC1587a));
    }

    /* renamed from: a */
    public static void m56387a(InterfaceC1587a interfaceC1587a) {
        TimerTask timerTask = f3043c;
        if (timerTask != null) {
            timerTask.cancel();
            f3043c = null;
        }
        m56378c();
        if (interfaceC1587a != null) {
            interfaceC1587a.mo56359a();
        }
    }

    /* renamed from: a */
    public static void m56384a(String str, InterfaceC1587a interfaceC1587a) {
        m56378c();
        if (interfaceC1587a != null) {
            interfaceC1587a.mo56358a(str);
        }
    }

    /* renamed from: a */
    private boolean m56385a(String str) {
        return TextUtils.isEmpty(str);
    }

    /* renamed from: b */
    public static C1586Y m56383b() {
        if (f3042b == null) {
            synchronized (C1586Y.class) {
                if (f3042b == null) {
                    f3042b = new C1586Y();
                }
            }
        }
        return f3042b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m56382b(int i, InterfaceC1587a interfaceC1587a) {
        f3043c = C1648S.m56165a().m56163b(i, 500, new C1612v(interfaceC1587a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m56380b(String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("limitType", "coupon");
        treeMap.put("is_snt", "0");
        treeMap.put("package_name", str);
        new C1249a().m57362o(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1575O(this), new C1576P(this));
    }

    /* renamed from: b */
    private static void m56379b(String str, InterfaceC1587a interfaceC1587a) {
        m56378c();
        if (interfaceC1587a != null) {
            interfaceC1587a.mo56358a(str);
        }
    }

    /* renamed from: c */
    public static void m56378c() {
        try {
            if (f3043c != null) {
                C1694ra.m55917a(f3041a, "timer is not null");
                f3043c.cancel();
                f3043c = null;
            }
        } catch (Exception unused) {
            C1694ra.m55917a(f3041a, "current window is Destroy");
        }
    }

    /* renamed from: d */
    private Object m56376d() throws ObjectStreamException {
        return f3042b;
    }

    /* renamed from: a */
    public void m56393a(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.baidu_wp_close).setOnClickListener(new View$OnClickListenerC1580U(this, interfaceC1587a));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1239R.C1242id.baidu_wp);
        linearLayout.setOnClickListener(new View$OnClickListenerC1581V(this, context, accessiblityModel, interfaceC1587a));
        linearLayout.setVisibility(0);
        if (m56385a(accessiblityModel.getData().getSpop_coupon_price()) || m56385a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(C1239R.C1242id.baidu_wp_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(C1239R.C1242id.baidu_wp_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b((int) BleManager.f22896l, interfaceC1587a);
    }

    /* renamed from: a */
    public void m56391a(Context context, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        if (CommonUtil.isShwoToast) {
            HelpShopAppUtil.getInstance();
            Toast.makeText(context, HelpShopAppUtil.sessionNewID(), 1).show();
        }
        C1694ra.m55914c(f3041a, "开始点击");
        if (accessiblityModel == null || m56385a(accessiblityModel.getData().getSpop_link()) || m56385a(accessiblityModel.getData().getSpop_deeplink())) {
            return;
        }
        if (!"1".equals(accessiblityModel.getData().getPic_type())) {
            C1632Ha.m56256b().m56255b(context, accessiblityModel);
            m56387a(interfaceC1587a);
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("spop_coupon_price", accessiblityModel.getData().getSpop_coupon_price());
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, accessiblityModel.getData().getPackage_name());
        treeMap.put("spop_link", accessiblityModel.getData().getSpop_link());
        new C1252c().m57358b(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1567G(this, interfaceC1587a, accessiblityModel, context), new C1577Q(this, interfaceC1587a));
    }

    /* renamed from: a */
    public void m56390a(View view, String str, InterfaceC1587a interfaceC1587a) {
        ((TextView) view.findViewById(C1239R.C1242id.tv_close)).setOnClickListener(new View$OnClickListenerC1570J(this, str, interfaceC1587a));
        ((ImageView) view.findViewById(C1239R.C1242id.iv_no_show_smill_close)).setOnClickListener(new View$OnClickListenerC1571K(this, interfaceC1587a));
        m56382b(4000, interfaceC1587a);
    }

    /* renamed from: b */
    public void m56381b(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.taobao_close).setOnClickListener(new View$OnClickListenerC1572L(this, interfaceC1587a));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1239R.C1242id.video_taobao_man);
        ImageView imageView = (ImageView) view.findViewById(C1239R.C1242id.taobao_main_box);
        imageView.setOnClickListener(new View$OnClickListenerC1573M(this, context, accessiblityModel, interfaceC1587a));
        if (TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            return;
        }
        Glide.m45751C(context).mo45507a(accessiblityModel.getData().getSpop_pic()).m45551i1(imageView);
        linearLayout.setVisibility(0);
        m56382b((int) BleManager.f22896l, interfaceC1587a);
    }

    /* renamed from: c */
    public void m56377c(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.tencent_close).setOnClickListener(new View$OnClickListenerC1582W(this, interfaceC1587a));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1239R.C1242id.tencent_wp);
        linearLayout.setOnClickListener(new View$OnClickListenerC1585X(this, context, accessiblityModel, interfaceC1587a));
        linearLayout.setVisibility(0);
        if (m56385a(accessiblityModel.getData().getSpop_coupon_price()) || m56385a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(C1239R.C1242id.tencent_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(C1239R.C1242id.tencent_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b((int) BleManager.f22896l, interfaceC1587a);
    }

    /* renamed from: d */
    public void m56375d(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.aiqiyi_close).setOnClickListener(new View$OnClickListenerC1578S(this, interfaceC1587a));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1239R.C1242id.video_aiqiyi);
        linearLayout.setOnClickListener(new View$OnClickListenerC1579T(this, context, accessiblityModel, interfaceC1587a));
        linearLayout.setVisibility(0);
        if (m56385a(accessiblityModel.getData().getNew_time_remaining()) || m56385a(accessiblityModel.getData().getSpop_coupon_price()) || m56385a(accessiblityModel.getData().getOriginal_price())) {
            return;
        }
        ((TextView) view.findViewById(C1239R.C1242id.aiqiyi_monery)).setText(accessiblityModel.getData().getSpop_coupon_price());
        TextView textView = (TextView) view.findViewById(C1239R.C1242id.aiqiyi_all_monery);
        textView.setText(accessiblityModel.getData().getOriginal_price());
        textView.getPaint().setFlags(16);
        ((TextView) view.findViewById(C1239R.C1242id.aiqiyi_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b((int) BleManager.f22896l, interfaceC1587a);
    }

    /* renamed from: e */
    public void m56374e(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.youku_close).setOnClickListener(new View$OnClickListenerC1602l(this, interfaceC1587a));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1239R.C1242id.youku_wp);
        linearLayout.setOnClickListener(new View$OnClickListenerC1603m(this, context, accessiblityModel, interfaceC1587a));
        linearLayout.setVisibility(0);
        if (m56385a(accessiblityModel.getData().getSpop_coupon_price()) || m56385a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(C1239R.C1242id.youku_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(C1239R.C1242id.youku_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b((int) BleManager.f22896l, interfaceC1587a);
    }

    /* renamed from: f */
    public void m56373f(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.didi_close).setOnClickListener(new View$OnClickListenerC1561A(this, interfaceC1587a));
        ((LinearLayout) view.findViewById(C1239R.C1242id.didi_big)).setOnClickListener(new View$OnClickListenerC1562B(this, context, accessiblityModel, interfaceC1587a));
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: g */
    public void m56372g(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        TextView textView = (TextView) view.findViewById(C1239R.C1242id.didi_content_info);
        TextView textView2 = (TextView) view.findViewById(C1239R.C1242id.didi_small_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C1239R.C1242id.didi_small);
        m56389a((ImageView) view.findViewById(C1239R.C1242id.iv_didi_close), interfaceC1587a);
        if (m56385a(accessiblityModel.getData().getPackage_name()) || m56385a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        m56388a((ImageView) view.findViewById(C1239R.C1242id.iv_didi_setting), accessiblityModel.getData().getPackage_name(), interfaceC1587a);
        relativeLayout.setVisibility(0);
        m56392a(context, relativeLayout, accessiblityModel, interfaceC1587a);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: h */
    public void m56371h(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        TextView textView = (TextView) view.findViewById(C1239R.C1242id.meituan_content_info);
        TextView textView2 = (TextView) view.findViewById(C1239R.C1242id.meituan_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C1239R.C1242id.meituan_small_layout);
        m56389a((ImageView) view.findViewById(C1239R.C1242id.iv_meituan_smile_close), interfaceC1587a);
        if (m56385a(accessiblityModel.getData().getPackage_name()) || m56385a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        m56388a((ImageView) view.findViewById(C1239R.C1242id.iv_meituan_smile_setting), accessiblityModel.getData().getPackage_name(), interfaceC1587a);
        relativeLayout.setVisibility(0);
        m56392a(context, relativeLayout, accessiblityModel, interfaceC1587a);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: i */
    public void m56370i(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.meituan_close).setOnClickListener(new View$OnClickListenerC1565E(this, interfaceC1587a));
        view.setOnClickListener(new View$OnClickListenerC1566F(this, context, accessiblityModel, interfaceC1587a));
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: j */
    public void m56369j(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.iv_close).setOnClickListener(new View$OnClickListenerC1604n(this, interfaceC1587a));
        ((ImageView) view.findViewById(C1239R.C1242id.taobao_treasure_box)).setOnClickListener(new View$OnClickListenerC1605o(this, context, accessiblityModel, interfaceC1587a));
        if (m56385a(accessiblityModel.getData().getSpop_coupon_price()) || m56385a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(C1239R.C1242id.tb_coupon_price)).setText("¥" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(C1239R.C1242id.tb_textview)).setText(accessiblityModel.getData().getSpop_coupon_title());
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: k */
    public void m56368k(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.jd_lijin_close).setOnClickListener(new View$OnClickListenerC1613w(this, interfaceC1587a));
        ((LinearLayout) view.findViewById(C1239R.C1242id.jd_lijin_big)).setOnClickListener(new View$OnClickListenerC1614x(this, context, accessiblityModel, interfaceC1587a));
        Glide.m45751C(context).mo45499p(Integer.valueOf(C1239R.mipmap.cash)).m45551i1((ImageView) view.findViewById(C1239R.C1242id.jd_lijin_coupon_price));
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: l */
    public void m56367l(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(C1239R.C1242id.iv_tb_big_recommend_icon);
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            Glide.m45751C(context).mo45507a(accessiblityModel.getData().getSpop_pic()).m45551i1(roundRectImageView);
        }
        TextView textView = (TextView) view.findViewById(C1239R.C1242id.tb_content_info);
        TextView textView2 = (TextView) view.findViewById(C1239R.C1242id.tb_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C1239R.C1242id.tb_small);
        m56389a((ImageView) view.findViewById(C1239R.C1242id.iv_smill_close), interfaceC1587a);
        ImageView imageView = (ImageView) view.findViewById(C1239R.C1242id.iv_setting);
        if (m56385a(accessiblityModel.getData().getPackage_name()) || m56385a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        m56388a(imageView, accessiblityModel.getData().getPackage_name(), interfaceC1587a);
        m56392a(context, relativeLayout, accessiblityModel, interfaceC1587a);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: m */
    public void m56366m(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.xbk_close).setOnClickListener(new View$OnClickListenerC1568H(this, interfaceC1587a));
        view.setOnClickListener(new View$OnClickListenerC1569I(this, context, accessiblityModel, interfaceC1587a));
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: n */
    public void m56365n(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.eleme_close).setOnClickListener(new View$OnClickListenerC1615y(this, interfaceC1587a));
        view.setOnClickListener(new View$OnClickListenerC1616z(this, context, accessiblityModel, interfaceC1587a));
        if (m56385a(accessiblityModel.getData().getSpop_coupon_price())) {
            return;
        }
        ((TextView) view.findViewById(C1239R.C1242id.eleme_coupon_price)).setText("¥" + accessiblityModel.getData().getSpop_coupon_price());
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: o */
    public void m56364o(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        TextView textView = (TextView) view.findViewById(C1239R.C1242id.eleme_content_info);
        TextView textView2 = (TextView) view.findViewById(C1239R.C1242id.eleme_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C1239R.C1242id.eleme_small_layout);
        m56389a((ImageView) view.findViewById(C1239R.C1242id.iv_eleme_smile_close), interfaceC1587a);
        if (m56385a(accessiblityModel.getData().getPackage_name()) || m56385a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        m56388a((ImageView) view.findViewById(C1239R.C1242id.iv_eleme_smile_setting), accessiblityModel.getData().getPackage_name(), interfaceC1587a);
        m56392a(context, relativeLayout, accessiblityModel, interfaceC1587a);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: p */
    public void m56363p(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.hxz_close).setOnClickListener(new View$OnClickListenerC1606p(this, interfaceC1587a));
        ((LinearLayout) view.findViewById(C1239R.C1242id.hxz_big)).setOnClickListener(new View$OnClickListenerC1607q(this, context, accessiblityModel, interfaceC1587a));
        if (m56385a(accessiblityModel.getData().getNew_time_remaining()) || m56385a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(C1239R.C1242id.hxz_content_info)).setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: q */
    public void m56362q(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.jd_close).setOnClickListener(new View$OnClickListenerC1608r(this, interfaceC1587a));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1239R.C1242id.jd_big);
        linearLayout.setOnClickListener(new View$OnClickListenerC1609s(this, context, accessiblityModel, interfaceC1587a));
        linearLayout.setVisibility(0);
        if (m56385a(accessiblityModel.getData().getSpop_coupon_price()) || m56385a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(C1239R.C1242id.jd_coupon_price)).setText("¥" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(C1239R.C1242id.jd_action_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: r */
    public void m56361r(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        view.findViewById(C1239R.C1242id.jd_lijin_close).setOnClickListener(new View$OnClickListenerC1610t(this, interfaceC1587a));
        ((LinearLayout) view.findViewById(C1239R.C1242id.jd_lijin_big)).setOnClickListener(new View$OnClickListenerC1611u(this, context, accessiblityModel, interfaceC1587a));
        Glide.m45751C(context).mo45499p(Integer.valueOf(C1239R.mipmap.cash)).m45551i1((ImageView) view.findViewById(C1239R.C1242id.jd_lijin_coupon_price));
        m56382b(8000, interfaceC1587a);
    }

    /* renamed from: s */
    public void m56360s(Context context, View view, AccessiblityModel accessiblityModel, InterfaceC1587a interfaceC1587a) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(C1239R.C1242id.iv_jd_recommend_icon);
        TextView textView = (TextView) view.findViewById(C1239R.C1242id.jd_content_info);
        TextView textView2 = (TextView) view.findViewById(C1239R.C1242id.jd_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C1239R.C1242id.jd_small);
        m56389a((ImageView) view.findViewById(C1239R.C1242id.iv_jd_smill_close), interfaceC1587a);
        if (m56385a(accessiblityModel.getData().getPackage_name()) || m56385a(accessiblityModel.getData().getSpop_pic()) || m56385a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        m56388a((ImageView) view.findViewById(C1239R.C1242id.iv_jd_smill_setting), accessiblityModel.getData().getPackage_name(), interfaceC1587a);
        relativeLayout.setVisibility(0);
        m56392a(context, relativeLayout, accessiblityModel, interfaceC1587a);
        Glide.m45751C(context).mo45507a(accessiblityModel.getData().getSpop_pic()).m45551i1(roundRectImageView);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        m56382b(8000, interfaceC1587a);
    }
}
