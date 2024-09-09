package com.mbridge.msdk.optimize.a.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* compiled from: NubiaDeviceHelper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f40397a;

    public d(Context context) {
        this.f40397a = context;
    }

    public final String a() {
        Bundle call;
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i4 = Build.VERSION.SDK_INT;
            if (i4 > 17) {
                ContentProviderClient acquireContentProviderClient = this.f40397a.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (i4 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.f40397a.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if ((call != null ? call.getInt("code", -1) : -1) == 0) {
                return call.getString("id");
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
