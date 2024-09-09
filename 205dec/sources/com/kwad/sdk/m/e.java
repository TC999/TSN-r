package com.kwad.sdk.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class e {
    public static final String TAG = "e";

    private static void a(@NonNull c cVar) {
        try {
            a.a(cVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static void c(@NonNull c cVar) {
        if (new Random().nextFloat() >= cVar.sampleRate) {
            String str = TAG;
            com.kwad.sdk.core.e.c.d(str, "config.sampleRate\uff1a" + cVar.sampleRate + " return");
            return;
        }
        if (cVar.Ll()) {
            a(cVar);
        }
        if (cVar.Lm()) {
            d(cVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.kwad.sdk.m.e$1, java.lang.Runnable] */
    public static void cM(final String str) {
        g.schedule(new az() { // from class: com.kwad.sdk.m.e.1
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.e.c.w(e.TAG, "config is empty");
                    return;
                }
                c gx = e.gx(str2);
                if (gx != null) {
                    String str3 = e.TAG;
                    com.kwad.sdk.core.e.c.d(str3, "config:" + gx.toJson().toString());
                }
                if (gx == null || gx.Lk()) {
                    return;
                }
                e.c(gx);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    private static void d(c cVar) {
        b.Li().b(cVar);
    }

    public static c gx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.w(TAG, e4);
            return null;
        }
    }
}
