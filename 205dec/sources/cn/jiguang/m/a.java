package cn.jiguang.m;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import cn.jiguang.ah.d;
import java.security.MessageDigest;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f3706a;

    /* renamed from: b  reason: collision with root package name */
    private String f3707b;

    /* renamed from: c  reason: collision with root package name */
    private String f3708c = d.f("bFWKQsRzI9d+ktdqxw44MA==");

    /* renamed from: d  reason: collision with root package name */
    private String f3709d = d.f("vWw3rdN6/HN94yy83HO8Lw==");

    /* renamed from: e  reason: collision with root package name */
    private String f3710e = d.f("Ha7IUc4OlbRIQFpw3FJeZw==");

    /* renamed from: f  reason: collision with root package name */
    private String f3711f = d.f("qFFOesfckPwVmbfqzGl5oBCLe9WD17E04n+Ic7C9fCw=");

    public a(IBinder iBinder) {
        this.f3706a = iBinder;
    }

    private String a(String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f3711f);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f3706a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                cn.jiguang.w.a.f("OppoAdvertisingInterface", "getIdByType error: " + th.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private String b(Context context) {
        if (TextUtils.isEmpty(this.f3707b)) {
            PackageInfo a4 = cn.jiguang.ag.a.a(context, 64);
            if (a4 == null) {
                cn.jiguang.w.a.f("OppoAdvertisingInterface", "package get sign failed");
                return this.f3707b;
            }
            Signature[] signatureArr = a4.signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(cn.jiguang.ap.b.f2349b);
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b4 : digest) {
                            sb.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                        }
                        this.f3707b = sb.toString();
                    }
                } catch (Throwable th) {
                    cn.jiguang.w.a.f("OppoAdvertisingInterface", "package sign error: " + th.getMessage());
                }
            }
        }
        return this.f3707b;
    }

    public String a(Context context) {
        return context == null ? "" : a(context.getPackageName(), b(context), this.f3708c);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
