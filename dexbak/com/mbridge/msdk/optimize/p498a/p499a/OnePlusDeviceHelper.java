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
import com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11533c;
import java.security.MessageDigest;
import kotlin.UByte;

/* renamed from: com.mbridge.msdk.optimize.a.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class OnePlusDeviceHelper {

    /* renamed from: b */
    InterfaceC11533c f31626b;

    /* renamed from: d */
    private Context f31628d;

    /* renamed from: e */
    private String f31629e;

    /* renamed from: a */
    public String f31625a = "OUID";

    /* renamed from: c */
    ServiceConnection f31627c = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.e.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                OnePlusDeviceHelper.this.f31626b = InterfaceC11533c.AbstractBinderC11534a.m21343a(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            OnePlusDeviceHelper.this.f31626b = null;
        }
    };

    public OnePlusDeviceHelper(Context context) {
        this.f31628d = context;
    }

    /* renamed from: a */
    public final String m21359a(OaidCallback oaidCallback) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f31628d.bindService(intent, this.f31627c, 1)) {
                try {
                    SystemClock.sleep(3000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.f31626b != null) {
                    String m21358a = m21358a("OUID");
                    m21358a("DUID");
                    m21358a("AUID");
                    if (oaidCallback != null) {
                        oaidCallback.mo21350a(m21358a, false);
                        return m21358a;
                    }
                    return m21358a;
                }
            }
            return null;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    /* renamed from: a */
    private String m21358a(String str) {
        Signature[] signatureArr;
        String packageName = this.f31628d.getPackageName();
        if (this.f31629e == null) {
            String str2 = null;
            try {
                signatureArr = this.f31628d.getPackageManager().getPackageInfo(packageName, 64).signatures;
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
            this.f31629e = str2;
        }
        return ((InterfaceC11533c.AbstractBinderC11534a.C11535a) this.f31626b).m21342a(packageName, this.f31629e, str);
    }
}
