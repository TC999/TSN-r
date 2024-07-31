package com.kwad.components.p208ad.interstitial.p240c;

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
/* renamed from: com.kwad.components.ad.interstitial.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7723a extends C10482a {

    /* renamed from: gL */
    private static SimpleDateFormat f26126gL = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: gM */
    public long f26127gM = -1;

    /* renamed from: jA */
    public int f26128jA = 0;

    /* renamed from: H */
    public static void m32566H(Context context) {
        String m23639LF = C11137y.m23639LF();
        C7723a c7723a = new C7723a();
        if (TextUtils.isEmpty(m23639LF)) {
            c7723a.f26128jA = 1;
            c7723a.f26127gM = System.currentTimeMillis();
            C11137y.m23617Z(context, c7723a.toJson().toString());
            return;
        }
        try {
            c7723a.parseJson(new JSONObject(m23639LF));
            if (m32565c(c7723a.f26127gM, System.currentTimeMillis())) {
                c7723a.f26128jA++;
            } else {
                c7723a.f26128jA = 1;
                c7723a.f26127gM = System.currentTimeMillis();
            }
            C11137y.m23617Z(context, c7723a.toJson().toString());
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    /* renamed from: c */
    private static boolean m32565c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return f26126gL.format(new Date(j)).equals(f26126gL.format(new Date(j2)));
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    /* renamed from: cM */
    public static int m32564cM() {
        String m23639LF = C11137y.m23639LF();
        if (TextUtils.isEmpty(m23639LF)) {
            return 0;
        }
        C7723a c7723a = new C7723a();
        try {
            c7723a.parseJson(new JSONObject(m23639LF));
            if (m32565c(c7723a.f26127gM, System.currentTimeMillis())) {
                return c7723a.f26128jA;
            }
            return 0;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return 0;
        }
    }
}
