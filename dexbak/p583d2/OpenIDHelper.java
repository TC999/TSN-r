package p583d2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;
import org.repackage.p630a.p631a.p632a.IOpenID;

/* renamed from: d2.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OpenIDHelper {

    /* renamed from: a */
    public IOpenID f40108a = null;

    /* renamed from: b */
    public String f40109b = null;

    /* renamed from: c */
    public String f40110c = null;

    /* renamed from: d */
    public final Object f40111d = new Object();

    /* renamed from: e */
    public ServiceConnection f40112e = new ServiceConnectionC13572a();

    /* compiled from: OpenIDHelper.java */
    /* renamed from: d2.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class ServiceConnectionC13572a implements ServiceConnection {
        public ServiceConnectionC13572a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OpenIDHelper.this.f40108a = IOpenID.AbstractBinderC15407a.m2794a(iBinder);
            synchronized (OpenIDHelper.this.f40111d) {
                OpenIDHelper.this.f40111d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            OpenIDHelper.this.f40108a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OpenIDHelper.java */
    /* renamed from: d2.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C13573b {

        /* renamed from: a */
        public static final OpenIDHelper f40114a = new OpenIDHelper(null);
    }

    public /* synthetic */ OpenIDHelper(ServiceConnectionC13572a serviceConnectionC13572a) {
    }

    /* renamed from: a */
    public synchronized String m12839a(Context context, String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.f40108a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.f40112e, 1)) {
                    synchronized (this.f40111d) {
                        try {
                            this.f40111d.wait(3000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (this.f40108a == null) {
                    return "";
                }
                try {
                    return m12837c(context, str);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            try {
                return m12837c(context, str);
            } catch (RemoteException e3) {
                e3.printStackTrace();
                return "";
            }
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    /* renamed from: b */
    public boolean m12838b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode >= 1;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public final String m12837c(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f40109b)) {
            this.f40109b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f40110c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f40109b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e) {
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
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
            }
            this.f40110c = str2;
        }
        String m2793a = ((IOpenID.AbstractBinderC15407a.C15408a) this.f40108a).m2793a(this.f40109b, this.f40110c, str);
        return TextUtils.isEmpty(m2793a) ? "" : m2793a;
    }
}
