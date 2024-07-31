package com.beizi.fusion.p068e.p070b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.beizi.fusion.e.b.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface OnePlusIDInterface extends IInterface {

    /* compiled from: OnePlusIDInterface.java */
    /* renamed from: com.beizi.fusion.e.b.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractBinderC3105a extends Binder implements OnePlusIDInterface {

        /* compiled from: OnePlusIDInterface.java */
        /* renamed from: com.beizi.fusion.e.b.d$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C3106a implements OnePlusIDInterface {

            /* renamed from: a */
            public IBinder f11216a;

            public C3106a(IBinder iBinder) {
                this.f11216a = iBinder;
            }

            /* renamed from: a */
            public String m48536a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.f11216a.transact(1, obtain, obtain2, 0);
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
                return this.f11216a;
            }
        }

        /* renamed from: a */
        public static OnePlusIDInterface m48537a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof OnePlusIDInterface)) {
                return (OnePlusIDInterface) queryLocalInterface;
            }
            return new C3106a(iBinder);
        }
    }
}
