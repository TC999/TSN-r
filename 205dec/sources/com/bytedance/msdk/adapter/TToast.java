package com.bytedance.msdk.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class TToast {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f26911a;

    @SuppressLint({"ShowToast"})
    private static Toast a(Context context) {
        if (context == null) {
            return f26911a;
        }
        Toast makeText = Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), "", 0);
        f26911a = makeText;
        return makeText;
    }

    public static void reset() {
        f26911a = null;
    }

    public static void show(Context context, String str) {
        show(context, str, 1);
    }

    public static void show(Context context, String str, int i4) {
        Toast a4 = a(context);
        if (a4 != null) {
            a4.setDuration(i4);
            a4.setText(String.valueOf(str));
            a4.show();
            return;
        }
        Log.i("TToast", "toast msg: " + String.valueOf(str));
    }
}
