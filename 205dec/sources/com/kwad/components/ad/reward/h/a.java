package com.kwad.components.ad.reward.h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static long rM = -1;
    public static int rN;

    public static void H(Context context) {
        b bVar = new b();
        if (f(System.currentTimeMillis())) {
            rN++;
        } else {
            rN = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rM = currentTimeMillis;
        bVar.rO = rN;
        bVar.gM = currentTimeMillis;
        y.ab(context, bVar.toJson().toString());
    }

    public static int cM() {
        if (!f(System.currentTimeMillis())) {
            rN = 0;
        }
        return rN;
    }

    private static boolean f(long j4) {
        return gV() > 0 && j4 > 0 && gV() / 2460601000L == j4 / 2460601000L;
    }

    private static long gV() {
        long j4 = rM;
        if (j4 == -1) {
            String LG = y.LG();
            if (TextUtils.isEmpty(LG)) {
                return 0L;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(LG));
                rM = bVar.gM;
                rN = bVar.rO;
            } catch (Exception e4) {
                c.printStackTraceOnly(e4);
            }
            return rM;
        }
        return j4;
    }
}
