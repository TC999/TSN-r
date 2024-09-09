package com.bytedance.msdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr {

    /* renamed from: c  reason: collision with root package name */
    private static Toast f27491c;

    public static void c(Context context, String str) {
        c(context, str, 0);
    }

    public static void c(Context context, String str, int i4) {
        Toast c4 = c(context);
        if (c4 != null) {
            c4.setDuration(i4);
            c4.setText(String.valueOf(str));
            c4.show();
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.w("TToast", "toast msg: " + String.valueOf(str));
    }

    @SuppressLint({"ShowToast"})
    private static Toast c(Context context) {
        if (context == null) {
            return f27491c;
        }
        Toast makeText = Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), "", 0);
        f27491c = makeText;
        return makeText;
    }
}
