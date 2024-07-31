package com.beizi.fusion.p073sm.p074a.p075a;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.beizi.fusion.p073sm.p074a.IGetter;
import com.beizi.fusion.p073sm.p074a.IOAID;
import com.beizi.fusion.p073sm.p074a.OAIDException;
import com.beizi.fusion.p073sm.p074a.OAIDLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.fusion.sm.a.a.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NubiaImpl implements IOAID {

    /* renamed from: a */
    private final Context f11506a;

    public NubiaImpl(Context context) {
        this.f11506a = context;
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    @SuppressLint({"AnnotateVersionCheck"})
    /* renamed from: a */
    public boolean mo48132a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        if (this.f11506a == null || iGetter == null) {
            return;
        }
        if (!mo48132a()) {
            OAIDLog.m48130a("Only supports Android 10.0 and above for Nubia");
            iGetter.mo48134a(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f11506a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
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
                    OAIDLog.m48130a("OAID query success: " + string);
                    iGetter.mo48133a(string);
                    return;
                }
                throw new OAIDException("OAID query failed: " + call.getString("message"));
            }
            throw new OAIDException("OAID query failed: bundle is null");
        } catch (Exception e) {
            OAIDLog.m48130a(e);
            iGetter.mo48134a(e);
        }
    }
}
