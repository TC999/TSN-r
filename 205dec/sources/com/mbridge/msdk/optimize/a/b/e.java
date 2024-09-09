package com.mbridge.msdk.optimize.a.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: SamsungIDInterface.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface e extends IInterface {

    /* compiled from: SamsungIDInterface.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements e {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f40426a;

        public a(IBinder iBinder) {
            this.f40426a = iBinder;
        }

        public final String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.f40426a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return str;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f40426a;
        }
    }
}
