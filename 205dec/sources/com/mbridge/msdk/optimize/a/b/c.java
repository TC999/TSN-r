package com.mbridge.msdk.optimize.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: OnePlusIDInterface.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface c extends IInterface {

    /* compiled from: OnePlusIDInterface.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class a extends Binder implements c {

        /* compiled from: OnePlusIDInterface.java */
        /* renamed from: com.mbridge.msdk.optimize.a.b.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class C0756a implements c {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f40424a;

            public C0756a(IBinder iBinder) {
                this.f40424a = iBinder;
            }

            public final String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.f40424a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        obtain.recycle();
                        obtain2.recycle();
                        return null;
                    }
                } finally {
                    obtain.recycle();
                    obtain2.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f40424a;
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                    return (c) queryLocalInterface;
                }
                return new C0756a(iBinder);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
