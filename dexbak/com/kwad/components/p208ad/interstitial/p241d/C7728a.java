package com.kwad.components.p208ad.interstitial.p241d;

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
/* renamed from: com.kwad.components.ad.interstitial.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7728a extends C10482a {

    /* renamed from: gL */
    private static SimpleDateFormat f26141gL = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: jD */
    public long f26142jD = -1;

    /* renamed from: jE */
    public int f26143jE = 0;

    /* renamed from: J */
    public static void m32550J(Context context) {
        String m23635LJ = C11137y.m23635LJ();
        C7728a c7728a = new C7728a();
        if (TextUtils.isEmpty(m23635LJ)) {
            c7728a.f26143jE = 1;
            c7728a.f26142jD = System.currentTimeMillis();
            C11137y.m23603ae(context, c7728a.toJson().toString());
            return;
        }
        try {
            c7728a.parseJson(new JSONObject(m23635LJ));
            if (m32549c(c7728a.f26142jD, System.currentTimeMillis())) {
                c7728a.f26143jE++;
            } else {
                c7728a.f26143jE = 1;
                c7728a.f26142jD = System.currentTimeMillis();
            }
            C11137y.m23603ae(context, c7728a.toJson().toString());
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    /* renamed from: c */
    private static boolean m32549c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return f26141gL.format(new Date(j)).equals(f26141gL.format(new Date(j2)));
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        }
        return false;
    }

    /* renamed from: cO */
    public static int m32548cO() {
        String m23635LJ = C11137y.m23635LJ();
        if (TextUtils.isEmpty(m23635LJ)) {
            return 0;
        }
        C7728a c7728a = new C7728a();
        try {
            c7728a.parseJson(new JSONObject(m23635LJ));
            if (m32549c(c7728a.f26142jD, System.currentTimeMillis())) {
                return c7728a.f26143jE;
            }
            return 0;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            return 0;
        }
    }
}
