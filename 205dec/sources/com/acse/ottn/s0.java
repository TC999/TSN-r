package com.acse.ottn;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    public static int f6257a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static int f6258b = -1;

    public static int a(Context context) {
        int i4 = f6258b;
        if (i4 != -1) {
            return i4;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i5 = displayMetrics.heightPixels;
        f6258b = i5;
        f6257a = displayMetrics.widthPixels;
        return i5;
    }

    public static int b(Context context) {
        int i4 = f6257a;
        if (i4 != -1) {
            return i4;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i5 = displayMetrics.widthPixels;
        f6257a = i5;
        f6258b = displayMetrics.heightPixels;
        return i5;
    }

    public static int c(Context context) {
        int identifier = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int d(Context context, float f4) {
        return (int) ((f4 * StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int c(Context context, float f4) {
        return (int) ((f4 / StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int a(Context context, int i4) {
        return BitmapFactory.decodeResource(StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources(), i4).getWidth();
    }

    public static int b(Context context, float f4) {
        return (int) ((f4 / StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, float f4) {
        return (int) ((f4 * StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().density) + 0.5f);
    }
}
