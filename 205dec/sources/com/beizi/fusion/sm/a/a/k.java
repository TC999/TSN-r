package com.beizi.fusion.sm.a.a;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* compiled from: NubiaImpl.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class k implements com.beizi.fusion.sm.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15056a;

    public k(Context context) {
        this.f15056a = context;
    }

    @Override // com.beizi.fusion.sm.a.d
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.beizi.fusion.sm.a.d
    public void a(com.beizi.fusion.sm.a.c cVar) {
        if (this.f15056a == null || cVar == null) {
            return;
        }
        if (!a()) {
            com.beizi.fusion.sm.a.f.a("Only supports Android 10.0 and above for Nubia");
            cVar.a(new com.beizi.fusion.sm.a.e("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f15056a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            if (call != null) {
                String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
                if (string != null && string.length() != 0) {
                    com.beizi.fusion.sm.a.f.a("OAID query success: " + string);
                    cVar.a(string);
                    return;
                }
                throw new com.beizi.fusion.sm.a.e("OAID query failed: " + call.getString("message"));
            }
            throw new com.beizi.fusion.sm.a.e("OAID query failed: bundle is null");
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
            cVar.a(e4);
        }
    }
}
