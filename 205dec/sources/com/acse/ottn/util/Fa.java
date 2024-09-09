package com.acse.ottn.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Fa {

    /* renamed from: a  reason: collision with root package name */
    private static Fa f6722a;

    private Fa() {
    }

    public static Fa a() {
        if (f6722a == null) {
            synchronized (Fa.class) {
                if (f6722a == null) {
                    f6722a = new Fa();
                }
            }
        }
        return f6722a;
    }

    public static void a(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.STREAM", uri);
        context.startActivity(Intent.createChooser(intent, str));
    }

    public void a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        context.startActivity(Intent.createChooser(intent, str));
    }
}
