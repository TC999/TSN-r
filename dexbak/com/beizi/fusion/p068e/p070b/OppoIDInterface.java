package com.beizi.fusion.p068e.p070b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.beizi.fusion.e.b.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface OppoIDInterface extends IInterface {

    /* compiled from: OppoIDInterface.java */
    /* renamed from: com.beizi.fusion.e.b.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractBinderC3107a extends Binder implements OppoIDInterface {

        /* compiled from: OppoIDInterface.java */
        /* renamed from: com.beizi.fusion.e.b.e$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C3108a implements OppoIDInterface {

            /* renamed from: a */
            public IBinder f11217a;

            public C3108a(IBinder iBinder) {
                this.f11217a = iBinder;
            }

            /* renamed from: a */
            public String m48534a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.f11217a.transact(1, obtain, obtain2, 0);
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
            public IBinder asBinder() {
                return this.f11217a;
            }
        }

        /* renamed from: a */
        public static OppoIDInterface m48535a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof OppoIDInterface)) {
                return (OppoIDInterface) queryLocalInterface;
            }
            return new C3108a(iBinder);
        }
    }
}
