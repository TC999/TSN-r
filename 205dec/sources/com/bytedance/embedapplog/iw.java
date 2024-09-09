package com.bytedance.embedapplog;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.zg;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class iw implements zg {
    @Override // com.bytedance.embedapplog.zg
    public boolean c(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.bytedance.embedapplog.zg
    public zg.c w(Context context) {
        Bundle call;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 > 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient == null) {
                    return null;
                }
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (i4 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call == null) {
                return null;
            }
            if (call.getInt("code", -1) == 0) {
                zg.c cVar = new zg.c();
                cVar.f26861w = call.getString("id");
                return cVar;
            }
            String string = call.getString("message");
            if (!TextUtils.isEmpty(string)) {
                be.w(string);
            }
            return null;
        } catch (Exception e4) {
            be.c(e4);
            return null;
        }
    }
}
