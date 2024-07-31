package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.ranger.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10959d {
    public static final String TAG = "d";

    /* renamed from: a */
    private static void m24369a(@NonNull C10957c c10957c) {
        try {
            C10944a.m24395a(c10957c);
        } catch (Throwable th) {
            C10331c.m26250e(TAG, Log.getStackTraceString(th));
        }
    }

    /* renamed from: c */
    public static void m24368c(@NonNull C10957c c10957c) {
        if (new Random().nextFloat() >= c10957c.sampleRate) {
            String str = TAG;
            C10331c.m26254d(str, "config.sampleRate：" + c10957c.sampleRate + " return");
            return;
        }
        if (c10957c.m24372KD()) {
            m24369a(c10957c);
        }
        if (c10957c.m24371KE()) {
            m24366d(c10957c);
        }
    }

    /* renamed from: cH */
    public static void m24367cH(final String str) {
        C11095g.schedule(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.ranger.d.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    C10331c.m26246w(C10959d.TAG, "config is empty");
                    return;
                }
                C10957c m24365go = C10959d.m24365go(str2);
                if (m24365go != null) {
                    String str3 = C10959d.TAG;
                    C10331c.m26254d(str3, "config:" + m24365go.toJson().toString());
                }
                if (m24365go == null || m24365go.m24373KC()) {
                    return;
                }
                C10959d.m24368c(m24365go);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    /* renamed from: d */
    private static void m24366d(C10957c c10957c) {
        C10949b.m24386KA().m24378b(c10957c);
    }

    /* renamed from: go */
    public static C10957c m24365go(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C10957c c10957c = new C10957c();
            c10957c.parseJson(jSONObject);
            return c10957c;
        } catch (Exception e) {
            C10331c.m26245w(TAG, e);
            return null;
        }
    }
}
