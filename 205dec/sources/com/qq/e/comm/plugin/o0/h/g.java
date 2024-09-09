package com.qq.e.comm.plugin.o0.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Context f45194a = com.qq.e.comm.plugin.d0.a.d().a();

    public static int a(String str) {
        return f45194a.getResources().getIdentifier(str, "drawable", f45194a.getPackageName());
    }

    public static void a(boolean z3) {
    }

    public static Bitmap b(Context context) {
        return a(context, a("gdt_ic_express_play"));
    }

    private static Bitmap a(Context context, int i4) {
        return BitmapFactory.decodeResource(context.getResources(), i4);
    }

    public static Bitmap a(Context context) {
        return a(context, a("gdt_ic_express_pause"));
    }
}
