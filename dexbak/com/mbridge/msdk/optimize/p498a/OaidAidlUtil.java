package com.mbridge.msdk.optimize.p498a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.mbridge.msdk.optimize.p498a.OpenDeviceIdentifierService;

/* renamed from: com.mbridge.msdk.optimize.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class OaidAidlUtil {

    /* renamed from: a */
    private Context f31610a;

    /* renamed from: b */
    private ServiceConnection f31611b;

    /* renamed from: c */
    private OpenDeviceIdentifierService f31612c;

    /* renamed from: d */
    private OaidCallback f31613d;

    /* compiled from: OaidAidlUtil.java */
    /* renamed from: com.mbridge.msdk.optimize.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private final class ServiceConnectionC11521a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OaidAidlUtil.this.f31612c = OpenDeviceIdentifierService.AbstractBinderC11544a.m21337a(iBinder);
            try {
                if (OaidAidlUtil.this.f31612c != null) {
                    try {
                        if (OaidAidlUtil.this.f31613d != null) {
                            OaidAidlUtil.this.f31613d.mo21350a(OaidAidlUtil.this.f31612c.mo21336a(), OaidAidlUtil.this.f31612c.mo21335b());
                        }
                    } catch (RemoteException e) {
                        if (OaidAidlUtil.this.f31613d != null) {
                            OaidAidlUtil.this.f31613d.mo21351a(e.getMessage());
                        }
                    } catch (Exception e2) {
                        if (OaidAidlUtil.this.f31613d != null) {
                            OaidAidlUtil.this.f31613d.mo21351a(e2.getMessage());
                        }
                    }
                }
            } finally {
                OaidAidlUtil.m21364c(OaidAidlUtil.this);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            OaidAidlUtil.this.f31612c = null;
        }

        private ServiceConnectionC11521a() {
        }
    }

    public OaidAidlUtil(Context context) {
        this.f31610a = context;
    }

    /* renamed from: c */
    static /* synthetic */ void m21364c(OaidAidlUtil oaidAidlUtil) {
        ServiceConnection serviceConnection;
        Context context = oaidAidlUtil.f31610a;
        if (context == null || (serviceConnection = oaidAidlUtil.f31611b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
        oaidAidlUtil.f31612c = null;
        oaidAidlUtil.f31610a = null;
        oaidAidlUtil.f31613d = null;
    }

    /* renamed from: a */
    public final void m21366a(OaidCallback oaidCallback) {
        if (oaidCallback == null) {
            return;
        }
        try {
            this.f31613d = oaidCallback;
            if (this.f31610a == null) {
                return;
            }
            this.f31611b = new ServiceConnectionC11521a();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.f31610a.bindService(intent, this.f31611b, 1);
        } catch (Throwable unused) {
        }
    }
}
