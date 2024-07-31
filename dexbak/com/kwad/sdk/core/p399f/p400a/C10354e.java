package com.kwad.sdk.core.p399f.p400a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* renamed from: com.kwad.sdk.core.f.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10354e {
    private Context mContext;

    public C10354e(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str;
        Bundle call;
        str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i = Build.VERSION.SDK_INT;
            if (i > 17) {
                ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (i >= 24) {
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
