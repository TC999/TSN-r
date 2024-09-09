package com.acse.ottn;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class x3 {

    /* renamed from: a  reason: collision with root package name */
    public static x3 f7000a;

    public static x3 a() {
        if (f7000a == null) {
            synchronized (x3.class) {
                if (f7000a == null) {
                    f7000a = new x3();
                }
            }
        }
        return f7000a;
    }

    public void a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        context.startActivity(Intent.createChooser(intent, str));
    }

    public static void a(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.STREAM", uri);
        context.startActivity(Intent.createChooser(intent, str));
    }
}
