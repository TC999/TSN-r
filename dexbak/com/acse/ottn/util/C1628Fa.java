package com.acse.ottn.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: com.acse.ottn.util.Fa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1628Fa {

    /* renamed from: a */
    private static C1628Fa f3149a;

    private C1628Fa() {
    }

    /* renamed from: a */
    public static C1628Fa m56270a() {
        if (f3149a == null) {
            synchronized (C1628Fa.class) {
                if (f3149a == null) {
                    f3149a = new C1628Fa();
                }
            }
        }
        return f3149a;
    }

    /* renamed from: a */
    public static void m56269a(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.STREAM", uri);
        context.startActivity(Intent.createChooser(intent, str));
    }

    /* renamed from: a */
    public void m56268a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        context.startActivity(Intent.createChooser(intent, str));
    }
}
