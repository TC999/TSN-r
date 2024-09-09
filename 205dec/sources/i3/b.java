package i3;

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
import org.repackage.a.a.a.a;

/* compiled from: OpenIDHelper.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public org.repackage.a.a.a.a f54767a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f54768b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f54769c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f54770d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f54771e = new a();

    /* compiled from: OpenIDHelper.java */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f54767a = a.AbstractBinderC1249a.c(iBinder);
            synchronized (b.this.f54770d) {
                b.this.f54770d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f54767a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OpenIDHelper.java */
    /* renamed from: i3.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class C1080b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f54773a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
    }

    public synchronized String a(Context context, String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.f54767a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.f54771e, 1)) {
                    synchronized (this.f54770d) {
                        try {
                            this.f54770d.wait(3000L);
                        } catch (InterruptedException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
                if (this.f54767a == null) {
                    return "";
                }
                try {
                    return c(context, str);
                } catch (RemoteException e5) {
                    e5.printStackTrace();
                    return "";
                }
            }
            try {
                return c(context, str);
            } catch (RemoteException e6) {
                e6.printStackTrace();
                return "";
            }
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    public boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode >= 1;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final String c(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f54768b)) {
            this.f54768b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f54769c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f54768b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e4) {
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
                } catch (NoSuchAlgorithmException e5) {
                    e5.printStackTrace();
                }
            }
            this.f54769c = str2;
        }
        String f4 = ((a.AbstractBinderC1249a.C1250a) this.f54767a).f(this.f54768b, this.f54769c, str);
        return TextUtils.isEmpty(f4) ? "" : f4;
    }
}
