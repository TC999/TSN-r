package com.kwad.sdk.core.f.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str;
        Bundle call;
        str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i4 = Build.VERSION.SDK_INT;
            if (i4 > 17) {
                ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (i4 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.mContext.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call != null) {
                str = call.getInt("code", -1) == 0 ? call.getString("id") : "";
                call.getString("message");
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
