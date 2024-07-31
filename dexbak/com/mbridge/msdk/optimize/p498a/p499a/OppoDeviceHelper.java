package com.mbridge.msdk.optimize.p498a.p499a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.mbridge.msdk.optimize.p498a.OaidCallback;
import com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11536d;
import java.security.MessageDigest;
import kotlin.UByte;

/* renamed from: com.mbridge.msdk.optimize.a.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class OppoDeviceHelper {

    /* renamed from: b */
    InterfaceC11536d f31632b;

    /* renamed from: d */
    private Context f31634d;

    /* renamed from: e */
    private String f31635e;

    /* renamed from: a */
    public String f31631a = "OUID";

    /* renamed from: c */
    ServiceConnection f31633c = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                OppoDeviceHelper.this.f31632b = InterfaceC11536d.AbstractBinderC11537a.m21341a(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            OppoDeviceHelper.this.f31632b = null;
        }
    };

    public OppoDeviceHelper(Context context) {
        this.f31634d = context;
    }

    /* renamed from: a */
    public final String m21357a(OaidCallback oaidCallback) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f31634d.bindService(intent, this.f31633c, 1)) {
                try {
                    SystemClock.sleep(3000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.f31632b != null) {
                    String m21356a = m21356a("OUID");
                    m21356a("DUID");
                    m21356a("AUID");
                    if (oaidCallback != null) {
                        oaidCallback.mo21350a(m21356a, false);
                        return m21356a;
                    }
                    return m21356a;
                }
            }
            return null;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    /* renamed from: a */
    private String m21356a(String str) {
        Signature[] signatureArr;
        String packageName = this.f31634d.getPackageName();
        if (this.f31635e == null) {
            String str2 = null;
            try {
                signatureArr = this.f31634d.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e) {
                e.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & UByte.f41242c) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f31635e = str2;
        }
        return ((InterfaceC11536d.AbstractBinderC11537a.C11538a) this.f31632b).m21340a(packageName, this.f31635e, str);
    }
}
