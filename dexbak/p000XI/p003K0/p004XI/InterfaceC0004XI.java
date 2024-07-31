package p000XI.p003K0.p004XI;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* renamed from: XI.K0.XI.XI */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface InterfaceC0004XI extends IInterface {

    /* renamed from: XI.K0.XI.XI$K0 */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0005K0 {

        /* renamed from: XI */
        public InterfaceC0004XI f19XI = null;

        /* renamed from: K0 */
        public String f18K0 = null;

        /* renamed from: kM */
        public String f20kM = null;

        /* renamed from: xo */
        public final Object f21xo = new Object();

        /* renamed from: CA */
        public ServiceConnection f17CA = new ServiceConnectionC0007XI();

        /* renamed from: XI.K0.XI.XI$K0$K0 */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public static class C0006K0 {

            /* renamed from: XI */
            public static final C0005K0 f22XI = new C0005K0();
        }

        /* renamed from: XI.K0.XI.XI$K0$XI */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public class ServiceConnectionC0007XI implements ServiceConnection {
            public ServiceConnectionC0007XI() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                InterfaceC0004XI c0009xi;
                C0005K0 c0005k0 = C0005K0.this;
                int i = AbstractBinderC0008XI.f24XI;
                if (iBinder == null) {
                    c0009xi = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                    c0009xi = (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0004XI)) ? new AbstractBinderC0008XI.C0009XI(iBinder) : (InterfaceC0004XI) queryLocalInterface;
                }
                c0005k0.f19XI = c0009xi;
                synchronized (C0005K0.this.f21xo) {
                    C0005K0.this.f21xo.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C0005K0.this.f19XI = null;
            }
        }

        /* renamed from: K0 */
        public final String m60071K0(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.f18K0)) {
                this.f18K0 = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.f20kM)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.f18K0, 64).signatures;
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
                this.f20kM = str2;
            }
            InterfaceC0004XI interfaceC0004XI = this.f19XI;
            if (interfaceC0004XI == null) {
                context.getPackageName();
                return "";
            }
            String str3 = this.f18K0;
            String str4 = this.f20kM;
            AbstractBinderC0008XI.C0009XI c0009xi = (AbstractBinderC0008XI.C0009XI) interfaceC0004XI;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str3);
                obtain.writeString(str4);
                obtain.writeString(str);
                c0009xi.f25XI.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return TextUtils.isEmpty(readString) ? "" : readString;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }

        /* renamed from: XI */
        public synchronized String m60070XI(Context context, String str) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return "";
            }
            if (this.f19XI != null) {
                try {
                    return m60071K0(context, str);
                } catch (RemoteException unused) {
                    return "";
                }
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.f17CA, 1)) {
                synchronized (this.f21xo) {
                    try {
                        this.f21xo.wait(3000L);
                    } catch (InterruptedException unused2) {
                    }
                }
            }
            if (this.f19XI == null) {
                return "";
            }
            try {
                return m60071K0(context, str);
            } catch (RemoteException unused3) {
                return "";
            }
        }
    }

    /* renamed from: XI.K0.XI.XI$XI */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static abstract class AbstractBinderC0008XI extends Binder implements InterfaceC0004XI {

        /* renamed from: XI */
        public static final /* synthetic */ int f24XI = 0;

        /* renamed from: XI.K0.XI.XI$XI$XI */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public static class C0009XI implements InterfaceC0004XI {

            /* renamed from: XI */
            public IBinder f25XI;

            public C0009XI(IBinder iBinder) {
                this.f25XI = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25XI;
            }
        }
    }
}
