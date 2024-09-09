package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Phoenix extends Perseus {

    /* renamed from: b  reason: collision with root package name */
    public static final String f52167b = Cextends.a(Cextends.f52272i);

    @Override // com.tencent.turingfd.sdk.ams.au.Perseus
    public String a(IBinder iBinder) throws Exception {
        Context context;
        synchronized (Ctry.class) {
            context = Ctry.f52366a;
        }
        String packageName = context.getPackageName();
        Signature[] a4 = Ctransient.a(context, packageName);
        String str = null;
        if (a4 != null && a4.length > 0) {
            byte[] byteArray = a4[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b4 : digest) {
                        sb.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                    }
                    str = sb.toString();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        String a5 = Cextends.a(Cextends.f52275j);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f52167b);
            obtain.writeString(packageName);
            obtain.writeString(str);
            obtain.writeString(a5);
            iBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
