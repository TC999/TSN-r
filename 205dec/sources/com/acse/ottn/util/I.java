package com.acse.ottn.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.adapter.AutoScrollViewPager;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class I {

    /* renamed from: a  reason: collision with root package name */
    private static I f6755a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6756b = "ButtonColorUtil";

    private I() {
    }

    public static I a() {
        if (f6755a == null) {
            synchronized (I.class) {
                if (f6755a == null) {
                    f6755a = new I();
                }
            }
        }
        return f6755a;
    }

    public String a(Activity activity) {
        return activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/index.html" : "https://www.boxkj.com/resources/user_agreement.html";
    }

    public void a(Activity activity, TextPaint textPaint) {
        textPaint.setColor(Color.parseColor(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "#5FCA8B" : "#3ECDA1"));
    }

    public void a(Activity activity, ImageView imageView) {
        imageView.setImageResource(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? R.mipmap.ydsj_up : R.mipmap.up_green);
    }

    public void a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView) {
        int i4;
        int i5 = R.mipmap.premission_unreadly;
        imageView.setImageResource(i5);
        imageView3.setImageResource(i5);
        imageView2.setImageResource(i5);
        imageView4.setImageResource(i5);
        int i6 = R.drawable.permission_background;
        relativeLayout.setBackgroundResource(i6);
        relativeLayout3.setBackgroundResource(i6);
        relativeLayout4.setBackgroundResource(i6);
        relativeLayout2.setBackgroundResource(i6);
        textView.setText("\u5141\u8bb8\u540e\u53f0\u4f7f\u7528\u7cbe\u51c6\u5b9a\u4f4d\uff0c\u4ee5\u4fbf\u6301\u7eed\u8bb0\u5f55\u8dd1\u6b65\u8f68\u8ff9\u3002");
        textView.setTextColor(Color.parseColor("#AAAAAA"));
        if (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME)) {
            if (C1442n.c().e()) {
                imageView.setImageResource(R.mipmap.permission_readly);
                relativeLayout.setBackgroundResource(R.drawable.permission_green_background);
            }
            if (C1442n.c().b()) {
                imageView3.setImageResource(R.mipmap.permission_readly);
                relativeLayout3.setBackgroundResource(R.drawable.permission_green_background);
            }
            if (qa.a().a((Context) activity) && qa.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.permission_readly);
                relativeLayout2.setBackgroundResource(R.drawable.permission_green_background);
            } else if (C1419ba.a().b("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("\u5f00\u542f\u5f02\u5e38\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u624b\u52a8\u5f00\u542f");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (!com.acse.ottn.d.k.a().b(activity.getPackageName())) {
                return;
            }
            imageView4.setImageResource(R.mipmap.permission_readly);
            i4 = R.drawable.permission_green_background;
        } else {
            if (C1442n.c().e()) {
                imageView.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
            if (qa.a().a((Context) activity) && qa.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.permission_readly);
                relativeLayout2.setBackgroundResource(R.drawable.permission_tsn_green_background);
            } else if (C1419ba.a().b("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("\u5f00\u542f\u5f02\u5e38\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u624b\u52a8\u5f00\u542f");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (C1442n.c().b()) {
                imageView3.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout3.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
            if (!com.acse.ottn.d.k.a().b(activity.getPackageName())) {
                return;
            }
            imageView4.setImageResource(R.mipmap.permission_readly_tsn);
            i4 = R.drawable.permission_tsn_green_background;
        }
        relativeLayout4.setBackgroundResource(i4);
    }

    public void a(Activity activity, TextView textView) {
        textView.setBackgroundResource(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? R.drawable.accessibilty_ydsj_green_button : R.drawable.accessibilty_green_button);
    }

    public void a(Activity activity, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        if (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) || activity.getPackageName().equals(CommonUtil.TSN_PACKAGENAME)) {
            textView.setText("\u8b66\u544a");
            textView2.setText("\u5f53\u524d\u5fc5\u8981\u6743\u9650\u4e0d\u5b8c\u6574\uff0c\u5c06\u65e0\u6cd5\u8bb0\u5f55\u51c6\u786e\u7684\u8dd1\u6b65\u8f68\u8ff9\uff0c\u53ef\u80fd\u4f1a\u5f71\u54cd\u60a8\u7684\u8dd1\u6b65\u6210\u7ee9! \n \n\u60a8\u4ecd\u7136\u53ef\u4ee5\u5f00\u59cb\u8dd1\u6b65\uff0c\u4f46\u5efa\u8bae\u60a8\u4fdd\u6301\u7a0b\u5e8f\u4e00\u76f4\u5728\u524d\u53f0\u8fd0\u884c\uff0c\u5e76\u4fdd\u6301\u5c4f\u5e55\u5e38\u4eae\uff0c\u4ee5\u4fbf\u8bb0\u5f55\u6210\u7ee9\u3002\n");
            textView3.setText("\u7ee7\u7eed\u4f7f\u7528");
            textView4.setText("\u5c1d\u8bd5\u5f00\u6743\u9650");
        }
    }

    public boolean a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, AutoScrollViewPager autoScrollViewPager, ImageView imageView5) {
        int i4;
        boolean equals = activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME);
        autoScrollViewPager.setVisibility(8);
        if (equals) {
            imageView5.setImageResource(R.mipmap.yundong);
            imageView.setImageResource(R.mipmap.ydsj_accessiblity_green);
            imageView3.setImageResource(R.mipmap.ydsj_flow_window_green);
            imageView2.setImageResource(R.mipmap.ydsj_location_green_position);
            i4 = R.mipmap.ydsj_battery_green;
        } else {
            imageView.setImageResource(R.mipmap.accessiblity_green_logo);
            imageView2.setImageResource(R.mipmap.location_green_position);
            imageView3.setImageResource(R.mipmap.flow_window_green);
            imageView5.setImageResource(R.mipmap.banner_6);
            i4 = R.mipmap.battery_green_icon;
        }
        imageView4.setImageResource(i4);
        return true;
    }

    public String b(Activity activity) {
        return (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) || activity.getPackageName().equals(CommonUtil.TSN_PACKAGENAME)) ? "https://www.idazhe.net/course/snt-privacyagreement?name=DETN" : "https://www.idazhe.net/course/snt-privacyagreement?name=\u7701\u94b1\u52a9\u624b";
    }

    public void b(Activity activity, ImageView imageView) {
        if (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME)) {
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.mipmap.run_dialog_icon);
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.mipmap.running_icon);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, 60, 0, 0);
        imageView.setLayoutParams(layoutParams);
    }

    public void b(Activity activity, TextView textView) {
        activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME);
        textView.setVisibility(0);
    }

    public String c(Activity activity) {
        return activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/userService.html" : "https://www.boxkj.com/resources/user_agreement_info.html";
    }

    public void c(Activity activity, ImageView imageView) {
        imageView.setImageResource(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? R.mipmap.sjxy_warning : R.mipmap.warning);
    }

    public void c(Activity activity, TextView textView) {
        textView.setTextColor(Color.parseColor(activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "#5FCA8B" : "#3ECDA1"));
    }

    public String d(Activity activity) {
        return (activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) || activity.getPackageName().equals(CommonUtil.TSN_PACKAGENAME)) ? "https://www.idazhe.net/course/snt-serviceagreement?name=DETN" : "https://www.idazhe.net/course/snt-serviceagreement?name=\u7701\u94b1\u52a9\u624b";
    }

    public void d(Activity activity, TextView textView) {
        activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME);
        textView.setVisibility(0);
    }

    public String e(Activity activity) {
        return activity.getPackageName().equals(CommonUtil.YDSJXU_PACKAGENAME) ? "#5FCA8B" : "#3ECDA1";
    }
}
