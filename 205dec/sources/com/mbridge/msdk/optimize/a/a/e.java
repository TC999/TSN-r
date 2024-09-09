package com.mbridge.msdk.optimize.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.mbridge.msdk.optimize.a.b.c;
import java.security.MessageDigest;

/* compiled from: OnePlusDeviceHelper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    com.mbridge.msdk.optimize.a.b.c f40399b;

    /* renamed from: d  reason: collision with root package name */
    private Context f40401d;

    /* renamed from: e  reason: collision with root package name */
    private String f40402e;

    /* renamed from: a  reason: collision with root package name */
    public String f40398a = "OUID";

    /* renamed from: c  reason: collision with root package name */
    ServiceConnection f40400c = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.e.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                e.this.f40399b = c.a.a(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            e.this.f40399b = null;
        }
    };

    public e(Context context) {
        this.f40401d = context;
    }

    public final String a(com.mbridge.msdk.optimize.a.b bVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f40401d.bindService(intent, this.f40400c, 1)) {
                try {
                    SystemClock.sleep(3000L);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (this.f40399b != null) {
                    String a4 = a("OUID");
                    a("DUID");
                    a("AUID");
                    if (bVar != null) {
                        bVar.a(a4, false);
                        return a4;
                    }
                    return a4;
                }
            }
            return null;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    private String a(String str) {
        Signature[] signatureArr;
        String packageName = this.f40401d.getPackageName();
        if (this.f40402e == null) {
            String str2 = null;
            try {
                signatureArr = this.f40401d.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e4) {
                e4.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b4 : digest) {
                            sb.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            this.f40402e = str2;
        }
        return ((c.a.C0756a) this.f40399b).a(packageName, this.f40402e, str);
    }
}
