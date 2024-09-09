package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f61477a;

    /* renamed from: b  reason: collision with root package name */
    private String f61478b;

    /* renamed from: c  reason: collision with root package name */
    private f1 f61479c;

    /* renamed from: d  reason: collision with root package name */
    ServiceConnection f61480d;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            z0.this.f61479c = new f1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            z0.this.f61479c = null;
        }
    }

    public z0(Context context) {
        String str = (String) pblk.a(16777217, 0, 0L, "691653", new byte[]{8, 14, 107, 102});
        this.f61480d = new pgla();
        this.f61477a = context;
    }

    private String a(f1 f1Var, String str) {
        Signature[] signatureArr;
        String str2;
        MessageDigest messageDigest;
        String str3;
        String packageName = this.f61477a.getPackageName();
        if (this.f61478b == null) {
            try {
                signatureArr = this.f61477a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception unused) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    messageDigest = MessageDigest.getInstance((String) pblk.a(16777217, 0, 0L, "eb453a", new byte[]{71, 72, 102, 16}));
                } catch (Exception unused2) {
                }
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b4 : digest) {
                        sb.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                    }
                    str2 = sb.toString();
                    this.f61478b = str2;
                }
            }
            str2 = null;
            this.f61478b = str2;
        }
        String str4 = this.f61478b;
        f1Var.getClass();
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken((String) pblk.a(16777217, 0, 0L, "bacd5b", new byte[]{112, 108, 29, 94, 2, 112, 120, 84, 51, 36, 61, 108, 0, 21, 4, 124, 101, 14, 27, 27, 99, 102, 30, 57, 46}));
                obtain.writeString(packageName);
                obtain.writeString(str4);
                obtain.writeString(str);
                f1Var.f61392a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str3 = obtain2.readString();
            } catch (Exception unused3) {
                String str5 = (String) pblk.a(16777217, 0, 0L, "76dccd", new byte[]{41, 36, 30});
                str3 = null;
            }
            return str3;
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x009f, code lost:
        if (r3 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c4, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(ms.bz.bd.c.Pgl.u0.pblb r14) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.z0.b(ms.bz.bd.c.Pgl.u0$pblb):java.lang.String");
    }
}
