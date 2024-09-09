package com.beizi.fusion.e.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OppoIDInterface.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface e extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: OppoIDInterface.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class a extends Binder implements e {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: OppoIDInterface.java */
        /* renamed from: com.beizi.fusion.e.b.e$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class C0140a implements e {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f14735a;

            public C0140a(IBinder iBinder) {
                this.f14735a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.f14735a.transact(1, obtain, obtain2, 0);
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
            public IBinder asBinder() {
                return this.f14735a;
            }
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof e)) {
                return (e) queryLocalInterface;
            }
            return new C0140a(iBinder);
        }
    }
}
