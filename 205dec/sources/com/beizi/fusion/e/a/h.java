package com.beizi.fusion.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.beizi.fusion.e.a.b;
import com.beizi.fusion.e.b.e;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OppoDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    com.beizi.fusion.e.b.e f14710b;

    /* renamed from: d  reason: collision with root package name */
    private Context f14712d;

    /* renamed from: e  reason: collision with root package name */
    private String f14713e;

    /* renamed from: a  reason: collision with root package name */
    public String f14709a = "OUID";

    /* renamed from: c  reason: collision with root package name */
    ServiceConnection f14711c = new ServiceConnection() { // from class: com.beizi.fusion.e.a.h.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h.this.f14710b = e.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h.this.f14710b = null;
        }
    };

    public h(Context context) {
        this.f14712d = context;
    }

    public String a(b.a aVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f14712d.bindService(intent, this.f14711c, 1)) {
                try {
                    SystemClock.sleep(3000L);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (this.f14710b != null) {
                    String a4 = a("OUID");
                    if (aVar != null) {
                        aVar.a(a4);
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
        String packageName = this.f14712d.getPackageName();
        if (this.f14713e == null) {
            String str2 = null;
            try {
                signatureArr = this.f14712d.getPackageManager().getPackageInfo(packageName, 64).signatures;
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
            this.f14713e = str2;
        }
        return ((e.a.C0140a) this.f14710b).a(packageName, this.f14713e, str);
    }
}
