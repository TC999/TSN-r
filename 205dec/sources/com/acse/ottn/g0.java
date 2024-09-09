package com.acse.ottn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.adapter.AutoScrollViewPager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static g0 f5665a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f5666b = "ButtonColorUtil";

    public static g0 a() {
        if (f5665a == null) {
            synchronized (g0.class) {
                if (f5665a == null) {
                    f5665a = new g0();
                }
            }
        }
        return f5665a;
    }

    public void b(Activity activity, ImageView imageView) {
        if (activity.getPackageName().equals(j0.f5776r)) {
            imageView.setImageResource(R.mipmap.sjxy_warning);
        } else if (activity.getPackageName().equals(j0.f5779u)) {
            imageView.setImageResource(R.mipmap.bdlp_warning);
        } else if (activity.getPackageName().equals(j0.f5777s)) {
            imageView.setImageResource(R.mipmap.sdxy_warning);
        } else if (activity.getPackageName().equals(j0.f5780v)) {
            imageView.setImageResource(R.mipmap.ic_yuedong_jinggao);
        } else {
            imageView.setImageResource(R.mipmap.warning);
        }
    }

    public void c(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(j0.f5776r)) {
            textView.setTextColor(Color.parseColor("#5FCA8B"));
        } else if (activity.getPackageName().equals(j0.f5777s)) {
            textView.setTextColor(Color.parseColor("#650AEC"));
        } else {
            textView.setTextColor(Color.parseColor("#3ECDA1"));
        }
    }

    public void d(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(j0.f5776r)) {
            textView.setVisibility(0);
        } else if (activity.getPackageName().equals(j0.f5777s)) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(0);
        }
    }

    public String e(Activity activity) {
        return activity.getPackageName().equals(j0.f5776r) ? "#5FCA8B" : activity.getPackageName().equals(j0.f5777s) ? "#650AEC" : "#3ECDA1";
    }

    public String c(Activity activity) {
        return activity.getPackageName().equals(j0.f5776r) ? "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/userService.html" : activity.getPackageName().equals(j0.f5778t) ? "https://www.boxkj.com/resources/user_agreement_info.html" : activity.getPackageName().equals(j0.f5779u) ? "https://api2.lptiyu.com/v3/api.php/Login/user_notice" : activity.getPackageName().equals(j0.f5777s) ? "https://mh5.huachenjie.com/h5/contract/document.html?code=100" : activity.getPackageName().equals(j0.f5780v) ? "https://global-pubpic.51yund.com/yd_privacy.html" : "";
    }

    public String d(Activity activity) {
        return (activity.getPackageName().equals(j0.f5776r) || activity.getPackageName().equals(j0.f5778t) || activity.getPackageName().equals(j0.f5779u) || activity.getPackageName().equals(j0.f5777s)) ? "https://www.idazhe.net/course/snt-serviceagreement?name=DETN" : "https://www.idazhe.net/course/snt-serviceagreement?name=\u7701\u94b1\u52a9\u624b";
    }

    public void a(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(j0.f5776r)) {
            textView.setBackgroundResource(R.drawable.accessibilty_ydsj_green_button);
        } else if (activity.getPackageName().equals(j0.f5777s)) {
            textView.setBackgroundResource(R.drawable.accessibilty_sdxu_button);
        } else {
            textView.setBackgroundResource(R.drawable.accessibilty_green_button);
        }
    }

    public String b(Activity activity) {
        return (activity.getPackageName().equals(j0.f5776r) || activity.getPackageName().equals(j0.f5778t) || activity.getPackageName().equals(j0.f5779u)) ? "https://www.idazhe.net/course/snt-privacyagreement?name=DETN" : "https://www.idazhe.net/course/snt-privacyagreement?name=\u7701\u94b1\u52a9\u624b";
    }

    public void a(Activity activity, ImageView imageView, ImageView imageView2) {
        imageView2.setVisibility(8);
        imageView.setVisibility(0);
        if (activity.getPackageName().equals(j0.f5776r)) {
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.mipmap.run_dialog_icon);
        } else if (activity.getPackageName().equals(j0.f5779u)) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.mipmap.bdlp_running_icon);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, 60, 0, 0);
            imageView.setLayoutParams(layoutParams);
        } else if (activity.getPackageName().equals(j0.f5777s)) {
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.mipmap.sdxy_run_icon);
        } else if (activity.getPackageName().equals(j0.f5780v)) {
            imageView2.setVisibility(0);
            imageView.setVisibility(8);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.mipmap.running_icon);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            layoutParams2.setMargins(0, 60, 0, 0);
            imageView.setLayoutParams(layoutParams2);
        }
    }

    public void b(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(j0.f5776r)) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(0);
        }
    }

    public void a(Activity activity, ImageView imageView) {
        if (activity.getPackageName().equals(j0.f5776r)) {
            imageView.setImageResource(R.mipmap.ydsj_up);
        } else if (activity.getPackageName().equals(j0.f5777s)) {
            imageView.setImageResource(R.mipmap.sdxy_up);
        } else {
            imageView.setImageResource(R.mipmap.up_green);
        }
    }

    public boolean a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, AutoScrollViewPager autoScrollViewPager, ImageView imageView5) {
        if (activity.getPackageName().equals(j0.f5776r)) {
            autoScrollViewPager.setVisibility(8);
            imageView5.setImageResource(R.mipmap.yundong);
            imageView.setImageResource(R.mipmap.ydsj_accessiblity_green);
            imageView3.setImageResource(R.mipmap.ydsj_flow_window_green);
            imageView2.setImageResource(R.mipmap.ydsj_location_green_position);
            imageView4.setImageResource(R.mipmap.ydsj_battery_green);
            return true;
        } else if (activity.getPackageName().equals(j0.f5779u)) {
            autoScrollViewPager.setVisibility(8);
            imageView.setImageResource(R.mipmap.accessiblity_green_logo);
            imageView2.setImageResource(R.mipmap.location_green_position);
            imageView3.setImageResource(R.mipmap.flow_window_green);
            imageView5.setImageResource(R.mipmap.bdlp_banner);
            imageView4.setImageResource(R.mipmap.battery_green_icon);
            return true;
        } else if (activity.getPackageName().equals(j0.f5780v)) {
            autoScrollViewPager.setVisibility(8);
            imageView.setImageResource(R.mipmap.accessiblity_green_logo);
            imageView2.setImageResource(R.mipmap.location_green_position);
            imageView3.setImageResource(R.mipmap.flow_window_green);
            imageView5.setImageResource(R.mipmap.ic_yuedong_banner);
            imageView4.setImageResource(R.mipmap.battery_green_icon);
            return true;
        } else if (activity.getPackageName().equals(j0.f5777s)) {
            autoScrollViewPager.setVisibility(8);
            imageView.setImageResource(R.mipmap.shandong_fuzhu_s);
            imageView2.setImageResource(R.mipmap.shandong_dingwei_s);
            imageView3.setImageResource(R.mipmap.shandong_xuanfu_s);
            imageView5.setImageResource(R.mipmap.shandong_banner);
            imageView4.setImageResource(R.mipmap.shandong_houtai_s);
            return true;
        } else {
            autoScrollViewPager.setVisibility(8);
            imageView.setImageResource(R.mipmap.accessiblity_green_logo);
            imageView2.setImageResource(R.mipmap.location_green_position);
            imageView3.setImageResource(R.mipmap.flow_window_green);
            imageView5.setImageResource(R.mipmap.banner_6);
            imageView4.setImageResource(R.mipmap.battery_green_icon);
            return true;
        }
    }

    public void a(Activity activity, TextPaint textPaint) {
        if (activity.getPackageName().equals(j0.f5776r)) {
            textPaint.setColor(Color.parseColor("#5FCA8B"));
        } else if (activity.getPackageName().equals(j0.f5777s)) {
            textPaint.setColor(Color.parseColor("#650AEC"));
        } else {
            textPaint.setColor(Color.parseColor("#3ECDA1"));
        }
    }

    public void a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView) {
        int i4 = R.mipmap.premission_unreadly;
        imageView.setImageResource(i4);
        imageView3.setImageResource(i4);
        imageView2.setImageResource(i4);
        imageView4.setImageResource(i4);
        int i5 = R.drawable.permission_background;
        relativeLayout.setBackgroundResource(i5);
        relativeLayout3.setBackgroundResource(i5);
        relativeLayout4.setBackgroundResource(i5);
        relativeLayout2.setBackgroundResource(i5);
        textView.setText("\u5141\u8bb8\u540e\u53f0\u4f7f\u7528\u7cbe\u51c6\u5b9a\u4f4d\uff0c\u4ee5\u4fbf\u6301\u7eed\u8bb0\u5f55\u8dd1\u6b65\u8f68\u8ff9\u3002");
        textView.setTextColor(Color.parseColor("#AAAAAA"));
        if (activity.getPackageName().equals(j0.f5776r)) {
            if (b.d().f()) {
                imageView.setImageResource(R.mipmap.permission_readly);
                relativeLayout.setBackgroundResource(R.drawable.permission_green_background);
            }
            if (b.d().b()) {
                imageView3.setImageResource(R.mipmap.permission_readly);
                relativeLayout3.setBackgroundResource(R.drawable.permission_green_background);
            }
            if (y1.a().a((Context) activity) && y1.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.permission_readly);
                relativeLayout2.setBackgroundResource(R.drawable.permission_green_background);
            } else if (g1.a().b("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("\u5f00\u542f\u5f02\u5e38\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u624b\u52a8\u5f00\u542f");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (q4.a().b(activity.getPackageName())) {
                imageView4.setImageResource(R.mipmap.permission_readly);
                relativeLayout4.setBackgroundResource(R.drawable.permission_green_background);
            }
        } else if (activity.getPackageName().equals(j0.f5777s)) {
            if (b.d().f()) {
                imageView.setImageResource(R.mipmap.shandong_select);
                relativeLayout.setBackgroundResource(R.drawable.permission_sd_background);
            }
            if (b.d().b()) {
                imageView3.setImageResource(R.mipmap.shandong_select);
                relativeLayout3.setBackgroundResource(R.drawable.permission_sd_background);
            }
            if (y1.a().a((Context) activity) && y1.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.shandong_select);
                relativeLayout2.setBackgroundResource(R.drawable.permission_sd_background);
            } else if (g1.a().b("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("\u5f00\u542f\u5f02\u5e38\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u624b\u52a8\u5f00\u542f");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (q4.a().b(activity.getPackageName())) {
                imageView4.setImageResource(R.mipmap.shandong_select);
                relativeLayout4.setBackgroundResource(R.drawable.permission_sd_background);
            }
        } else if (activity.getPackageName().equals(j0.f5780v)) {
            if (b.d().f()) {
                imageView.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
            if (y1.a().a((Context) activity) && y1.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout2.setBackgroundResource(R.drawable.permission_tsn_green_background);
            } else if (g1.a().b("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("\u5f00\u542f\u5f02\u5e38\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u624b\u52a8\u5f00\u542f");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (b.d().b()) {
                imageView3.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout3.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
            if (q4.a().b(activity.getPackageName())) {
                imageView4.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout4.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
        } else {
            if (b.d().f()) {
                imageView.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
            if (y1.a().a((Context) activity) && y1.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout2.setBackgroundResource(R.drawable.permission_tsn_green_background);
            } else if (g1.a().b("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("\u5f00\u542f\u5f02\u5e38\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u624b\u52a8\u5f00\u542f");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (b.d().b()) {
                imageView3.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout3.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
            if (q4.a().b(activity.getPackageName())) {
                imageView4.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout4.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
        }
    }

    public void a(Activity activity, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        if (activity.getPackageName().equals(j0.f5776r) || activity.getPackageName().equals(j0.f5778t) || activity.getPackageName().equals(j0.f5779u) || activity.getPackageName().equals(j0.f5777s)) {
            textView.setText("\u8b66\u544a");
            textView2.setText("\u5f53\u524d\u5fc5\u8981\u6743\u9650\u4e0d\u5b8c\u6574\uff0c\u5c06\u65e0\u6cd5\u8bb0\u5f55\u51c6\u786e\u7684\u8dd1\u6b65\u8f68\u8ff9\uff0c\u53ef\u80fd\u4f1a\u5f71\u54cd\u60a8\u7684\u8dd1\u6b65\u6210\u7ee9! \n \n\u60a8\u4ecd\u7136\u53ef\u4ee5\u5f00\u59cb\u8dd1\u6b65\uff0c\u4f46\u5efa\u8bae\u60a8\u4fdd\u6301\u7a0b\u5e8f\u4e00\u76f4\u5728\u524d\u53f0\u8fd0\u884c\uff0c\u5e76\u4fdd\u6301\u5c4f\u5e55\u5e38\u4eae\uff0c\u4ee5\u4fbf\u8bb0\u5f55\u6210\u7ee9\u3002\n");
            textView3.setText("\u7ee7\u7eed\u4f7f\u7528");
            textView4.setText("\u5c1d\u8bd5\u5f00\u6743\u9650");
        }
    }

    public String a(Activity activity) {
        return activity.getPackageName().equals(j0.f5776r) ? "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/index.html" : activity.getPackageName().equals(j0.f5778t) ? "https://www.boxkj.com/resources/user_agreement.html" : activity.getPackageName().equals(j0.f5779u) ? "https://api2.lptiyu.com/v3/api.php/Login/user_privacy" : activity.getPackageName().equals(j0.f5777s) ? "https://mh5.huachenjie.com/h5/contract/document.html?code=200" : activity.getPackageName().equals(j0.f5780v) ? "https://global-pubpic.51yund.com/yd_privacy.html" : "";
    }

    public void a(Activity activity, TextView textView, RelativeLayout relativeLayout) {
        if (activity.getPackageName().equals(j0.f5780v)) {
            relativeLayout.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, 180, 0, 0);
            textView.setLayoutParams(layoutParams);
        }
    }
}
