package com.mbridge.msdk.optimize.p498a.p500b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: OnePlusIDInterface.java */
/* renamed from: com.mbridge.msdk.optimize.a.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC11533c extends IInterface {

    /* compiled from: OnePlusIDInterface.java */
    /* renamed from: com.mbridge.msdk.optimize.a.b.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractBinderC11534a extends Binder implements InterfaceC11533c {

        /* compiled from: OnePlusIDInterface.java */
        /* renamed from: com.mbridge.msdk.optimize.a.b.c$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C11535a implements InterfaceC11533c {

            /* renamed from: a */
            public IBinder f31651a;

            public C11535a(IBinder iBinder) {
                this.f31651a = iBinder;
            }

            /* renamed from: a */
            public final String m21342a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.f31651a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e) {
                        e.printStackTrace();
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
                return this.f31651a;
            }
        }

        /* renamed from: a */
        public static InterfaceC11533c m21343a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC11533c)) {
                    return (InterfaceC11533c) queryLocalInterface;
                }
                return new C11535a(iBinder);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
