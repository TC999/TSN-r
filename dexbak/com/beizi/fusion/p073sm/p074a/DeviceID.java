package com.beizi.fusion.p073sm.p074a;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.p073sm.p074a.p075a.OAIDFactory;

/* renamed from: com.beizi.fusion.sm.a.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DeviceID implements IGetter {

    /* renamed from: a */
    private Application f11485a;

    /* renamed from: b */
    private String f11486b;

    /* compiled from: DeviceID.java */
    /* renamed from: com.beizi.fusion.sm.a.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3193a {

        /* renamed from: a */
        static final DeviceID f11487a = new DeviceID();
    }

    /* renamed from: a */
    public static void m48150a(Application application) {
        if (application == null) {
            return;
        }
        DeviceID deviceID = C3193a.f11487a;
        deviceID.f11485a = application;
        m48148a(application, deviceID);
    }

    @Override // com.beizi.fusion.p073sm.p074a.IGetter
    /* renamed from: a */
    public void mo48134a(Exception exc) {
    }

    private DeviceID() {
    }

    /* renamed from: a */
    public static void m48148a(Context context, IGetter iGetter) {
        OAIDFactory.m48145a(context).mo48131a(iGetter);
    }

    /* renamed from: a */
    public static boolean m48149a(Context context) {
        return OAIDFactory.m48145a(context).mo48132a();
    }

    @Override // com.beizi.fusion.p073sm.p074a.IGetter
    /* renamed from: a */
    public void mo48133a(String str) {
        if (TextUtils.isEmpty(str)) {
            mo48134a(new OAIDException("OAID is empty"));
        } else {
            this.f11486b = str;
        }
    }
}
