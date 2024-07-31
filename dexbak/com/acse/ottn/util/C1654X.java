package com.acse.ottn.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.stub.StubApp;

/* renamed from: com.acse.ottn.util.X */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1654X {

    /* renamed from: a */
    private static int f3282a = -1;

    /* renamed from: b */
    private static int f3283b = -1;

    /* renamed from: a */
    public static int m56118a(Context context) {
        int i = f3283b;
        if (i != -1) {
            return i;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        f3283b = i2;
        f3282a = displayMetrics.widthPixels;
        return i2;
    }

    /* renamed from: a */
    public static int m56117a(Context context, float f) {
        return (int) ((f * StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static int m56116a(Context context, int i) {
        return BitmapFactory.decodeResource(StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources(), i).getWidth();
    }

    /* renamed from: b */
    public static int m56115b(Context context) {
        int i = f3282a;
        if (i != -1) {
            return i;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        f3282a = i2;
        f3283b = displayMetrics.heightPixels;
        return i2;
    }

    /* renamed from: b */
    public static int m56114b(Context context, float f) {
        return (int) ((f / StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: c */
    public static int m56113c(Context context) {
        int identifier = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.f8430OS);
        if (identifier > 0) {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: c */
    public static int m56112c(Context context, float f) {
        return (int) ((f / StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* renamed from: d */
    public static int m56111d(Context context, float f) {
        return (int) ((f * StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
