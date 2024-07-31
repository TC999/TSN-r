package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.idl.face.platform.FaceEnvironment;

/* renamed from: com.baidu.mobads.sdk.internal.ay */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2610ay {

    /* renamed from: a */
    private static DisplayMetrics f8636a;

    /* renamed from: b */
    private static float f8637b;

    /* renamed from: a */
    public static Rect m50855a(Context context) {
        DisplayMetrics m50846f = m50846f(context);
        try {
            if (m50846f.widthPixels > m50846f.heightPixels) {
                return new Rect(0, 0, m50846f.heightPixels, m50846f.widthPixels);
            }
            return new Rect(0, 0, m50846f.widthPixels, m50846f.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static int m50852b(Context context) {
        return m50855a(context).width();
    }

    /* renamed from: c */
    public static int m50849c(Context context) {
        return m50855a(context).height();
    }

    /* renamed from: d */
    public static Rect m50848d(Context context) {
        DisplayMetrics m50846f = m50846f(context);
        return new Rect(0, 0, m50846f.widthPixels, m50846f.heightPixels);
    }

    /* renamed from: e */
    public static float m50847e(Context context) {
        if (f8637b < 0.01d) {
            f8637b = m50846f(context).density;
        }
        return f8637b;
    }

    /* renamed from: f */
    public static DisplayMetrics m50846f(Context context) {
        try {
            DisplayMetrics displayMetrics = f8636a;
            if (displayMetrics != null && displayMetrics.widthPixels > 0) {
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (C2624bk.m50799a(context).m50800a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            }
            f8636a = displayMetrics2;
        } catch (Throwable th) {
            f8636a = new DisplayMetrics();
            C2634bs.m50744a().m50738a(th);
        }
        return f8636a;
    }

    /* renamed from: g */
    public static int m50845g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", FaceEnvironment.f8430OS));
    }

    /* renamed from: b */
    public static int m50850b(Context context, int i) {
        try {
            return (int) (i * m50847e(context));
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: b */
    public static int m50851b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static int m50853a(Context context, int i) {
        try {
            return (int) (i / m50847e(context));
        } catch (Exception unused) {
            return i;
        }
    }

    /* renamed from: a */
    public static int m50854a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
