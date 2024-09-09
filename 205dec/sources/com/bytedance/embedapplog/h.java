package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f26745c;

    public static String c(Context context, n nVar) {
        if (TextUtils.isEmpty(f26745c)) {
            synchronized (h.class) {
                if (!TextUtils.isEmpty(f26745c)) {
                    return f26745c;
                }
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = nVar.sr().getString("google_aid", null);
                } else if (!TextUtils.equals(nVar.sr().getString("google_aid", null), id)) {
                    c(context, id, nVar);
                }
                f26745c = id;
            }
        }
        return f26745c;
    }

    private static void c(Context context, String str, n nVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        nVar.sr().edit().putString("google_aid", str).apply();
    }
}
