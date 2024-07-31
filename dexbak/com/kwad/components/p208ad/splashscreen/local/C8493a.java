package com.kwad.components.p208ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11137y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.components.ad.splashscreen.local.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8493a extends C10482a {

    /* renamed from: gL */
    private static SimpleDateFormat f27893gL = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: gM */
    public long f27894gM = 0;

    /* renamed from: gN */
    public int f27895gN = 0;

    /* renamed from: R */
    public static void m30594R(Context context) {
        String m23637LH = C11137y.m23637LH();
        C8493a c8493a = new C8493a();
        if (TextUtils.isEmpty(m23637LH)) {
            c8493a.f27895gN = 1;
            c8493a.f27894gM = System.currentTimeMillis();
            C11137y.m23605ac(context, c8493a.toJson().toString());
            return;
        }
        try {
            c8493a.parseJson(new JSONObject(m23637LH));
            if (m30593c(c8493a.f27894gM, System.currentTimeMillis())) {
                c8493a.f27895gN++;
            } else {
                c8493a.f27895gN = 1;
            }
            c8493a.f27894gM = System.currentTimeMillis();
            C11137y.m23605ac(context, c8493a.toJson().toString());
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    /* renamed from: c */
    private static boolean m30593c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return f27893gL.format(new Date(j)).equals(f27893gL.format(new Date(j2)));
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }
        return false;
    }
}
