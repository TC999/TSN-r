package com.mbridge.msdk.optimize.p498a.p499a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* renamed from: com.mbridge.msdk.optimize.a.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class NubiaDeviceHelper {

    /* renamed from: a */
    private Context f31624a;

    public NubiaDeviceHelper(Context context) {
        this.f31624a = context;
    }

    /* renamed from: a */
    public final String m21360a() {
        Bundle call;
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i = Build.VERSION.SDK_INT;
            if (i > 17) {
                ContentProviderClient acquireContentProviderClient = this.f31624a.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (i >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.f31624a.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if ((call != null ? call.getInt("code", -1) : -1) == 0) {
                return call.getString("id");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
