package com.kwad.sdk.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static int aag = 0;
    public static long rM = -1;

    public static void H(Context context) {
        a aVar = new a();
        if (f(System.currentTimeMillis())) {
            aag++;
        } else {
            aag = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rM = currentTimeMillis;
        aVar.aag = aag;
        aVar.gM = currentTimeMillis;
        y.ak(context, aVar.toJson().toString());
    }

    public static int cM() {
        if (!f(System.currentTimeMillis())) {
            aag = 0;
        }
        return aag;
    }

    private static boolean f(long j4) {
        return gV() > 0 && j4 > 0 && gV() / 2460601000L == j4 / 2460601000L;
    }

    private static long gV() {
        long j4 = rM;
        if (j4 == -1) {
            String LN = y.LN();
            if (TextUtils.isEmpty(LN)) {
                return 0L;
            }
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(LN));
                rM = aVar.gM;
                aag = aVar.aag;
            } catch (Exception e4) {
                c.printStackTraceOnly(e4);
            }
            return rM;
        }
        return j4;
    }
}
