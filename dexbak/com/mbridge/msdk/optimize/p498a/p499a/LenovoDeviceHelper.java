package com.mbridge.msdk.optimize.p498a.p499a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mbridge.msdk.optimize.p498a.OaidCallback;
import com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11530b;

/* renamed from: com.mbridge.msdk.optimize.a.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class LenovoDeviceHelper {

    /* renamed from: a */
    InterfaceC11530b f31619a;

    /* renamed from: b */
    ServiceConnection f31620b = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                LenovoDeviceHelper.this.f31619a = new InterfaceC11530b.AbstractBinderC11531a.C11532a(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c */
    private Context f31621c;

    public LenovoDeviceHelper(Context context) {
        this.f31621c = context;
    }

    /* renamed from: a */
    public final void m21362a(OaidCallback oaidCallback) {
        InterfaceC11530b interfaceC11530b;
        try {
            this.f31621c.getPackageName();
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f31621c.bindService(intent, this.f31620b, 1) || (interfaceC11530b = this.f31619a) == null) {
                return;
            }
            String mo21348a = interfaceC11530b.mo21348a();
            if (oaidCallback != null) {
                oaidCallback.mo21350a(mo21348a, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
