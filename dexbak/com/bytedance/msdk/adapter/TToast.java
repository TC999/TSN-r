package com.bytedance.msdk.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class TToast {

    /* renamed from: a */
    private static Toast f21327a;

    @SuppressLint({"ShowToast"})
    /* renamed from: a */
    private static Toast m37855a(Context context) {
        if (context == null) {
            return f21327a;
        }
        Toast makeText = Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), "", 0);
        f21327a = makeText;
        return makeText;
    }

    public static void reset() {
        f21327a = null;
    }

    public static void show(Context context, String str) {
        show(context, str, 1);
    }

    public static void show(Context context, String str, int i) {
        Toast m37855a = m37855a(context);
        if (m37855a != null) {
            m37855a.setDuration(i);
            m37855a.setText(String.valueOf(str));
            m37855a.show();
            return;
        }
        Log.i("TToast", "toast msg: " + String.valueOf(str));
    }
}
