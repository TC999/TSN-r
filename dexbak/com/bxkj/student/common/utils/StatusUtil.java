package com.bxkj.student.common.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.idl.face.platform.FaceEnvironment;

/* renamed from: com.bxkj.student.common.utils.m */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StatusUtil {
    /* renamed from: a */
    public static int m42800a(Resources res, String key) {
        int identifier = res.getIdentifier(key, "dimen", FaceEnvironment.f8430OS);
        if (identifier > 0) {
            return res.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @TargetApi(19)
    /* renamed from: b */
    public static void m42799b(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ((ViewGroup) viewGroup.findViewById(16908290)).getChildAt(0).setFitsSystemWindows(true);
            View view = new View(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m42800a(activity.getResources(), "status_bar_height"));
            layoutParams.gravity = 48;
            view.setLayoutParams(layoutParams);
            view.setBackgroundColor(color);
            viewGroup.addView(view);
        }
    }

    @TargetApi(19)
    /* renamed from: c */
    public static void m42798c(Activity activity, int res) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ((ViewGroup) viewGroup.findViewById(16908290)).getChildAt(0).setFitsSystemWindows(true);
            View view = new View(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m42800a(activity.getResources(), "status_bar_height"));
            layoutParams.gravity = 48;
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(res);
            viewGroup.addView(view);
        }
    }

    /* renamed from: d */
    public static void m42797d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
        }
    }
}
