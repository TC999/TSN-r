package com.beizi.fusion.sm.b.a;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* compiled from: NubiaImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class k implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15093a;

    public k(Context context) {
        this.f15093a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15093a == null || bVar == null) {
            return;
        }
        if (!a()) {
            com.beizi.fusion.sm.b.e.a("Only supports Android 10.0 and above for Nubia");
            bVar.a(new com.beizi.fusion.sm.b.d("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f15093a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
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
                    com.beizi.fusion.sm.b.e.a("OAID query success: " + string);
                    bVar.a(string);
                    return;
                }
                throw new com.beizi.fusion.sm.b.d("OAID query failed: " + call.getString("message"));
            }
            throw new com.beizi.fusion.sm.b.d("OAID query failed: bundle is null");
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            bVar.a(e4);
        }
    }
}
