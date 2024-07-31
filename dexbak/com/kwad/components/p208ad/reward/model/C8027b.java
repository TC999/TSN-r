package com.kwad.components.p208ad.reward.model;

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
/* renamed from: com.kwad.components.ad.reward.model.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8027b extends C10482a {

    /* renamed from: gL */
    private static SimpleDateFormat f26766gL = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: jD */
    public long f26767jD = -1;

    /* renamed from: jE */
    public int f26768jE = 0;

    /* renamed from: J */
    public static void m31799J(Context context) {
        String m23636LI = C11137y.m23636LI();
        C8027b c8027b = new C8027b();
        if (TextUtils.isEmpty(m23636LI)) {
            c8027b.f26768jE = 1;
            c8027b.f26767jD = System.currentTimeMillis();
            C11137y.m23604ad(context, c8027b.toJson().toString());
            return;
        }
        try {
            c8027b.parseJson(new JSONObject(m23636LI));
            if (m31798c(c8027b.f26767jD, System.currentTimeMillis())) {
                c8027b.f26768jE++;
            } else {
                c8027b.f26768jE = 1;
                c8027b.f26767jD = System.currentTimeMillis();
            }
            C11137y.m23604ad(context, c8027b.toJson().toString());
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    /* renamed from: c */
    private static boolean m31798c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return f26766gL.format(new Date(j)).equals(f26766gL.format(new Date(j2)));
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        }
        return false;
    }

    /* renamed from: cO */
    public static int m31797cO() {
        String m23636LI = C11137y.m23636LI();
        if (TextUtils.isEmpty(m23636LI)) {
            return 0;
        }
        C8027b c8027b = new C8027b();
        try {
            c8027b.parseJson(new JSONObject(m23636LI));
            if (m31798c(c8027b.f26767jD, System.currentTimeMillis())) {
                return c8027b.f26768jE;
            }
            return 0;
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            return 0;
        }
    }
}
