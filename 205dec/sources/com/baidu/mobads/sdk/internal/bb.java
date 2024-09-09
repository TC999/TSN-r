package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private static DisplayMetrics f12455a;

    /* renamed from: b  reason: collision with root package name */
    private static float f12456b;

    public static Rect a(Context context) {
        DisplayMetrics f4 = f(context);
        try {
            if (f4.widthPixels > f4.heightPixels) {
                return new Rect(0, 0, f4.heightPixels, f4.widthPixels);
            }
            return new Rect(0, 0, f4.widthPixels, f4.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(context).width();
    }

    public static int c(Context context) {
        return a(context).height();
    }

    public static Rect d(Context context) {
        DisplayMetrics f4 = f(context);
        return new Rect(0, 0, f4.widthPixels, f4.heightPixels);
    }

    public static float e(Context context) {
        if (f12456b < 0.01d) {
            f12456b = f(context).density;
        }
        return f12456b;
    }

    public static DisplayMetrics f(Context context) {
        try {
            DisplayMetrics displayMetrics = f12455a;
            if (displayMetrics != null && displayMetrics.widthPixels > 0) {
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (bn.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            }
            f12455a = displayMetrics2;
        } catch (Throwable th) {
            f12455a = new DisplayMetrics();
            bv.a().a(th);
        }
        return f12455a;
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int b(Context context, int i4) {
        try {
            return (int) (i4 * e(context));
        } catch (Exception unused) {
            return i4;
        }
    }

    public static int b(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, int i4) {
        try {
            return (int) (i4 / e(context));
        } catch (Exception unused) {
            return i4;
        }
    }

    public static int a(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
