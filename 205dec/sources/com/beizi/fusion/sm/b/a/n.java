package com.beizi.fusion.sm.b.a;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.heytap.openid.IOpenID;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: OppoImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class n implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15098a;

    /* renamed from: b  reason: collision with root package name */
    private String f15099b;

    public n(Context context) {
        if (context instanceof Application) {
            this.f15098a = context;
        } else {
            this.f15098a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f15098a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15098a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        m.a(this.f15098a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.n.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                try {
                    return n.this.a(iBinder);
                } catch (RemoteException e4) {
                    throw e4;
                } catch (com.beizi.fusion.sm.b.d e5) {
                    throw e5;
                } catch (Exception e6) {
                    throw new com.beizi.fusion.sm.b.d(e6);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    public String a(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, com.beizi.fusion.sm.b.d {
        String packageName = this.f15098a.getPackageName();
        String str = this.f15099b;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f15098a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b4 : digest) {
                sb.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            String sb2 = sb.toString();
            this.f15099b = sb2;
            return a(iBinder, packageName, sb2);
        }
        return a(iBinder, packageName, str);
    }

    private String a(IBinder iBinder, String str, String str2) throws RemoteException, com.beizi.fusion.sm.b.d {
        IOpenID asInterface = IOpenID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new com.beizi.fusion.sm.b.d("IOpenID is null");
    }
}
