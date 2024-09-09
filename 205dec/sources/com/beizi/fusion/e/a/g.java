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
import com.beizi.fusion.e.b.d;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OnePlusDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    com.beizi.fusion.e.b.d f14704b;

    /* renamed from: d  reason: collision with root package name */
    private Context f14706d;

    /* renamed from: e  reason: collision with root package name */
    private String f14707e;

    /* renamed from: a  reason: collision with root package name */
    public String f14703a = "OUID";

    /* renamed from: c  reason: collision with root package name */
    ServiceConnection f14705c = new ServiceConnection() { // from class: com.beizi.fusion.e.a.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.f14704b = d.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            g.this.f14704b = null;
        }
    };

    public g(Context context) {
        this.f14706d = context;
    }

    public String a(b.a aVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f14706d.bindService(intent, this.f14705c, 1)) {
                try {
                    SystemClock.sleep(3000L);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (this.f14704b != null) {
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
        String packageName = this.f14706d.getPackageName();
        if (this.f14707e == null) {
            String str2 = null;
            try {
                signatureArr = this.f14706d.getPackageManager().getPackageInfo(packageName, 64).signatures;
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
            this.f14707e = str2;
        }
        return ((d.a.C0139a) this.f14704b).a(packageName, this.f14707e, str);
    }
}
