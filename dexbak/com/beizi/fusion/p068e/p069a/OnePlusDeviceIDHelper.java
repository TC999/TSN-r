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
import com.beizi.fusion.p068e.p070b.OnePlusIDInterface;
import java.security.MessageDigest;
import kotlin.UByte;

/* renamed from: com.beizi.fusion.e.a.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OnePlusDeviceIDHelper {

    /* renamed from: b */
    OnePlusIDInterface f11186b;

    /* renamed from: d */
    private Context f11188d;

    /* renamed from: e */
    private String f11189e;

    /* renamed from: a */
    public String f11185a = "OUID";

    /* renamed from: c */
    ServiceConnection f11187c = new ServiceConnection() { // from class: com.beizi.fusion.e.a.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OnePlusDeviceIDHelper.this.f11186b = OnePlusIDInterface.AbstractBinderC3105a.m48537a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            OnePlusDeviceIDHelper.this.f11186b = null;
        }
    };

    public OnePlusDeviceIDHelper(Context context) {
        this.f11188d = context;
    }

    /* renamed from: a */
    public String m48556a(DevicesIDsHelper.InterfaceC3094a interfaceC3094a) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f11188d.bindService(intent, this.f11187c, 1)) {
                try {
                    SystemClock.sleep(3000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.f11186b != null) {
                    String m48555a = m48555a("OUID");
                    if (interfaceC3094a != null) {
                        interfaceC3094a.mo48445a(m48555a);
                        return m48555a;
                    }
                    return m48555a;
                }
            }
            return null;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    /* renamed from: a */
    private String m48555a(String str) {
        Signature[] signatureArr;
        String packageName = this.f11188d.getPackageName();
        if (this.f11189e == null) {
            String str2 = null;
            try {
                signatureArr = this.f11188d.getPackageManager().getPackageInfo(packageName, 64).signatures;
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
            this.f11189e = str2;
        }
        return ((OnePlusIDInterface.AbstractBinderC3105a.C3106a) this.f11186b).m48536a(packageName, this.f11189e, str);
    }
}
