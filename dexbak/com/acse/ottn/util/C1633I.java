package com.acse.ottn.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.C1239R;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.acse.ottn.p042d.C1533k;

/* renamed from: com.acse.ottn.util.I */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1633I {

    /* renamed from: a */
    private static C1633I f3245a = null;

    /* renamed from: b */
    private static String f3246b = "ButtonColorUtil";

    private C1633I() {
    }

    /* renamed from: a */
    public static C1633I m56254a() {
        if (f3245a == null) {
            synchronized (C1633I.class) {
                if (f3245a == null) {
                    f3245a = new C1633I();
                }
            }
        }
        return f3245a;
    }

    /* renamed from: a */
    public String m56253a(Activity activity) {
        return activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/index.html" : "https://www.boxkj.com/resources/user_agreement.html";
    }

    /* renamed from: a */
    public void m56252a(Activity activity, TextPaint textPaint) {
        textPaint.setColor(Color.parseColor(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "#5FCA8B" : "#3ECDA1"));
    }

    /* renamed from: a */
    public void m56251a(Activity activity, ImageView imageView) {
        imageView.setImageResource(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? C1239R.mipmap.ydsj_up : C1239R.mipmap.up_green);
    }

    /* renamed from: a */
    public void m56250a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView) {
        int i;
        int i2 = C1239R.mipmap.premission_unreadly;
        imageView.setImageResource(i2);
        imageView3.setImageResource(i2);
        imageView2.setImageResource(i2);
        imageView4.setImageResource(i2);
        int i3 = C1239R.C1241drawable.permission_background;
        relativeLayout.setBackgroundResource(i3);
        relativeLayout3.setBackgroundResource(i3);
        relativeLayout4.setBackgroundResource(i3);
        relativeLayout2.setBackgroundResource(i3);
        textView.setText("允许后台使用精准定位，以便持续记录跑步轨迹。");
        textView.setTextColor(Color.parseColor("#AAAAAA"));
        if (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME)) {
            if (C1684n.m55975c().m55965e()) {
                imageView.setImageResource(C1239R.mipmap.permission_readly);
                relativeLayout.setBackgroundResource(C1239R.C1241drawable.permission_green_background);
            }
            if (C1684n.m55975c().m55984b()) {
                imageView3.setImageResource(C1239R.mipmap.permission_readly);
                relativeLayout3.setBackgroundResource(C1239R.C1241drawable.permission_green_background);
            }
            if (C1692qa.m55930a().m55928a((Context) activity) && C1692qa.m55930a().m55925b((Context) activity)) {
                imageView2.setImageResource(C1239R.mipmap.permission_readly);
                relativeLayout2.setBackgroundResource(C1239R.C1241drawable.permission_green_background);
            } else if (C1661ba.m56097a().m56090b("location_permission_size") > 2) {
                imageView2.setImageResource(C1239R.mipmap.premission_location_exceptional);
                textView.setText("开启异常请在设置中手动开启");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (!C1533k.m56493a().m56489b(activity.getPackageName())) {
                return;
            }
            imageView4.setImageResource(C1239R.mipmap.permission_readly);
            i = C1239R.C1241drawable.permission_green_background;
        } else {
            if (C1684n.m55975c().m55965e()) {
                imageView.setImageResource(C1239R.mipmap.permission_readly_tsn);
                relativeLayout.setBackgroundResource(C1239R.C1241drawable.permission_tsn_green_background);
            }
            if (C1692qa.m55930a().m55928a((Context) activity) && C1692qa.m55930a().m55925b((Context) activity)) {
                imageView2.setImageResource(C1239R.mipmap.permission_readly);
                relativeLayout2.setBackgroundResource(C1239R.C1241drawable.permission_tsn_green_background);
            } else if (C1661ba.m56097a().m56090b("location_permission_size") > 2) {
                imageView2.setImageResource(C1239R.mipmap.premission_location_exceptional);
                textView.setText("开启异常请在设置中手动开启");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (C1684n.m55975c().m55984b()) {
                imageView3.setImageResource(C1239R.mipmap.permission_readly_tsn);
                relativeLayout3.setBackgroundResource(C1239R.C1241drawable.permission_tsn_green_background);
            }
            if (!C1533k.m56493a().m56489b(activity.getPackageName())) {
                return;
            }
            imageView4.setImageResource(C1239R.mipmap.permission_readly_tsn);
            i = C1239R.C1241drawable.permission_tsn_green_background;
        }
        relativeLayout4.setBackgroundResource(i);
    }

    /* renamed from: a */
    public void m56248a(Activity activity, TextView textView) {
        textView.setBackgroundResource(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? C1239R.C1241drawable.accessibilty_ydsj_green_button : C1239R.C1241drawable.accessibilty_green_button);
    }

    /* renamed from: a */
    public void m56247a(Activity activity, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        if (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) || activity.getPackageName().equals(CommonUtil.TSN_PACKAGENAME)) {
            textView.setText("警告");
            textView2.setText("当前必要权限不完整，将无法记录准确的跑步轨迹，可能会影响您的跑步成绩! \n \n您仍然可以开始跑步，但建议您保持程序一直在前台运行，并保持屏幕常亮，以便记录成绩。\n");
            textView3.setText("继续使用");
            textView4.setText("尝试开权限");
        }
    }

    /* renamed from: a */
    public boolean m56249a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, AutoScrollViewPager autoScrollViewPager, ImageView imageView5) {
        int i;
        boolean equals = activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME);
        autoScrollViewPager.setVisibility(8);
        if (equals) {
            imageView5.setImageResource(C1239R.mipmap.yundong);
            imageView.setImageResource(C1239R.mipmap.ydsj_accessiblity_green);
            imageView3.setImageResource(C1239R.mipmap.ydsj_flow_window_green);
            imageView2.setImageResource(C1239R.mipmap.ydsj_location_green_position);
            i = C1239R.mipmap.ydsj_battery_green;
        } else {
            imageView.setImageResource(C1239R.mipmap.accessiblity_green_logo);
            imageView2.setImageResource(C1239R.mipmap.location_green_position);
            imageView3.setImageResource(C1239R.mipmap.flow_window_green);
            imageView5.setImageResource(C1239R.mipmap.banner_6);
            i = C1239R.mipmap.battery_green_icon;
        }
        imageView4.setImageResource(i);
        return true;
    }

    /* renamed from: b */
    public String m56246b(Activity activity) {
        return (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) || activity.getPackageName().equals(CommonUtil.TSN_PACKAGENAME)) ? "https://www.idazhe.net/course/snt-privacyagreement?name=DETN" : "https://www.idazhe.net/course/snt-privacyagreement?name=省钱助手";
    }

    /* renamed from: b */
    public void m56245b(Activity activity, ImageView imageView) {
        if (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME)) {
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(C1239R.mipmap.run_dialog_icon);
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(C1239R.mipmap.running_icon);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, 60, 0, 0);
        imageView.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    public void m56244b(Activity activity, TextView textView) {
        activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME);
        textView.setVisibility(0);
    }

    /* renamed from: c */
    public String m56243c(Activity activity) {
        return activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/userService.html" : "https://www.boxkj.com/resources/user_agreement_info.html";
    }

    /* renamed from: c */
    public void m56242c(Activity activity, ImageView imageView) {
        imageView.setImageResource(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? C1239R.mipmap.sjxy_warning : C1239R.mipmap.warning);
    }

    /* renamed from: c */
    public void m56241c(Activity activity, TextView textView) {
        textView.setTextColor(Color.parseColor(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "#5FCA8B" : "#3ECDA1"));
    }

    /* renamed from: d */
    public String m56240d(Activity activity) {
        return (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) || activity.getPackageName().equals(CommonUtil.TSN_PACKAGENAME)) ? "https://www.idazhe.net/course/snt-serviceagreement?name=DETN" : "https://www.idazhe.net/course/snt-serviceagreement?name=省钱助手";
    }

    /* renamed from: d */
    public void m56239d(Activity activity, TextView textView) {
        activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME);
        textView.setVisibility(0);
    }

    /* renamed from: e */
    public String m56238e(Activity activity) {
        return activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "#5FCA8B" : "#3ECDA1";
    }
}
