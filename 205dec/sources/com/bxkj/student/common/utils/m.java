package com.bxkj.student.common.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StatusUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class m {
    public static int a(Resources res, String key) {
        int identifier = res.getIdentifier(key, "dimen", "android");
        if (identifier > 0) {
            return res.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @TargetApi(19)
    public static void b(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ((ViewGroup) viewGroup.findViewById(16908290)).getChildAt(0).setFitsSystemWindows(true);
            View view = new View(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a(activity.getResources(), "status_bar_height"));
            layoutParams.gravity = 48;
            view.setLayoutParams(layoutParams);
            view.setBackgroundColor(color);
            viewGroup.addView(view);
        }
    }

    @TargetApi(19)
    public static void c(Activity activity, int res) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ((ViewGroup) viewGroup.findViewById(16908290)).getChildAt(0).setFitsSystemWindows(true);
            View view = new View(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a(activity.getResources(), "status_bar_height"));
            layoutParams.gravity = 48;
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(res);
            viewGroup.addView(view);
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
        }
    }
}
