package com.beizi.fusion.p068e.p069a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* renamed from: com.beizi.fusion.e.a.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NubiaDeviceIDHelper {

    /* renamed from: a */
    private Context f11184a;

    public NubiaDeviceIDHelper(Context context) {
        this.f11184a = context;
    }

    /* renamed from: a */
    public String m48557a() {
        Bundle call;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i = Build.VERSION.SDK_INT;
            if (i > 17) {
                ContentProviderClient acquireContentProviderClient = this.f11184a.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (i >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.f11184a.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
            call.getString("message");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
