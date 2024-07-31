package com.mbridge.msdk.optimize.p498a.p500b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: OppoIDInterface.java */
/* renamed from: com.mbridge.msdk.optimize.a.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC11536d extends IInterface {

    /* compiled from: OppoIDInterface.java */
    /* renamed from: com.mbridge.msdk.optimize.a.b.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractBinderC11537a extends Binder implements InterfaceC11536d {

        /* compiled from: OppoIDInterface.java */
        /* renamed from: com.mbridge.msdk.optimize.a.b.d$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C11538a implements InterfaceC11536d {

            /* renamed from: a */
            public IBinder f31652a;

            public C11538a(IBinder iBinder) {
                this.f31652a = iBinder;
            }

            /* renamed from: a */
            public final String m21340a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.f31652a.transact(1, obtain, obtain2, 0);
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
                return this.f31652a;
            }
        }

        /* renamed from: a */
        public static InterfaceC11536d m21341a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC11536d)) {
                    return (InterfaceC11536d) queryLocalInterface;
                }
                return new C11538a(iBinder);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
