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
/* renamed from: com.kwad.components.ad.interstitial.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7724b extends C10482a {

    /* renamed from: gL */
    private static SimpleDateFormat f26129gL = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: gM */
    public long f26130gM = -1;

    /* renamed from: jB */
    public int f26131jB = 0;

    /* renamed from: jC */
    public int f26132jC = 0;

    /* renamed from: H */
    public static void m32563H(Context context) {
        String m23640LE = C11137y.m23640LE();
        C7724b c7724b = new C7724b();
        if (TextUtils.isEmpty(m23640LE)) {
            c7724b.f26131jB = 1;
            c7724b.f26130gM = System.currentTimeMillis();
            C11137y.m23618Y(context, c7724b.toJson().toString());
            return;
        }
        try {
            c7724b.parseJson(new JSONObject(m23640LE));
            if (m32561c(c7724b.f26130gM, System.currentTimeMillis())) {
                c7724b.f26131jB++;
            } else {
                c7724b.f26131jB = 1;
                c7724b.f26132jC = 0;
                c7724b.f26130gM = System.currentTimeMillis();
            }
            C11137y.m23618Y(context, c7724b.toJson().toString());
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    /* renamed from: I */
    public static void m32562I(Context context) {
        String m23640LE = C11137y.m23640LE();
        C7724b c7724b = new C7724b();
        if (TextUtils.isEmpty(m23640LE)) {
            c7724b.f26132jC = 1;
            c7724b.f26130gM = System.currentTimeMillis();
            C11137y.m23618Y(context, c7724b.toJson().toString());
            return;
        }
        try {
            c7724b.parseJson(new JSONObject(m23640LE));
            if (m32561c(c7724b.f26130gM, System.currentTimeMillis())) {
                c7724b.f26132jC++;
            } else {
                c7724b.f26132jC = 1;
                c7724b.f26131jB = 0;
                c7724b.f26130gM = System.currentTimeMillis();
            }
            C11137y.m23618Y(context, c7724b.toJson().toString());
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    /* renamed from: c */
    private static boolean m32561c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return f26129gL.format(new Date(j)).equals(f26129gL.format(new Date(j2)));
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    /* renamed from: cM */
    public static int m32560cM() {
        String m23640LE = C11137y.m23640LE();
        if (TextUtils.isEmpty(m23640LE)) {
            return 0;
        }
        C7724b c7724b = new C7724b();
        try {
            c7724b.parseJson(new JSONObject(m23640LE));
            return c7724b.f26131jB;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return 0;
        }
    }

    /* renamed from: cN */
    public static int m32559cN() {
        String m23640LE = C11137y.m23640LE();
        if (TextUtils.isEmpty(m23640LE)) {
            return 0;
        }
        C7724b c7724b = new C7724b();
        try {
            c7724b.parseJson(new JSONObject(m23640LE));
            return c7724b.f26132jC;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return 0;
        }
    }
}
