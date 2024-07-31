package com.beizi.fusion.p068e.p069a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.beizi.fusion.p068e.p069a.DevicesIDsHelper;
import com.beizi.fusion.p068e.p070b.OppoIDInterface;
import java.security.MessageDigest;
import kotlin.UByte;

/* renamed from: com.beizi.fusion.e.a.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OppoDeviceIDHelper {

    /* renamed from: b */
    OppoIDInterface f11192b;

    /* renamed from: d */
    private Context f11194d;

    /* renamed from: e */
    private String f11195e;

    /* renamed from: a */
    public String f11191a = "OUID";

    /* renamed from: c */
    ServiceConnection f11193c = new ServiceConnection() { // from class: com.beizi.fusion.e.a.h.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OppoDeviceIDHelper.this.f11192b = OppoIDInterface.AbstractBinderC3107a.m48535a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            OppoDeviceIDHelper.this.f11192b = null;
        }
    };

    public OppoDeviceIDHelper(Context context) {
        this.f11194d = context;
    }

    /* renamed from: a */
    public String m48554a(DevicesIDsHelper.InterfaceC3094a interfaceC3094a) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f11194d.bindService(intent, this.f11193c, 1)) {
                try {
                    SystemClock.sleep(3000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.f11192b != null) {
                    String m48553a = m48553a("OUID");
                    if (interfaceC3094a != null) {
                        interfaceC3094a.mo48445a(m48553a);
                        return m48553a;
                    }
                    return m48553a;
                }
            }
            return null;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    /* renamed from: a */
    private String m48553a(String str) {
        Signature[] signatureArr;
        String packageName = this.f11194d.getPackageName();
        if (this.f11195e == null) {
            String str2 = null;
            try {
                signatureArr = this.f11194d.getPackageManager().getPackageInfo(packageName, 64).signatures;
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
            this.f11195e = str2;
        }
        return ((OppoIDInterface.AbstractBinderC3107a.C3108a) this.f11192b).m48534a(packageName, this.f11195e, str);
    }
}
