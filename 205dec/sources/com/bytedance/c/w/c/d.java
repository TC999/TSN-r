package com.bytedance.c.w.c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.c.w.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, int i4) {
        ActivityManager.ProcessErrorStateInfo b4 = b.e.b(context, i4);
        if (b4 == null || Process.myPid() != b4.pid) {
            return null;
        }
        return e.a(b4);
    }

    public static JSONObject b(boolean z3) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", b.n.b(stackTrace));
        return jSONObject;
    }
}
