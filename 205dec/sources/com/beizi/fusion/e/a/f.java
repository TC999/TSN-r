package com.beizi.fusion.e.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NubiaDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Context f14702a;

    public f(Context context) {
        this.f14702a = context;
    }

    public String a() {
        Bundle call;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 > 17) {
                ContentProviderClient acquireContentProviderClient = this.f14702a.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (i4 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.f14702a.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
            call.getString("message");
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
