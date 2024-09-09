package com.beizi.fusion.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SamsungIDInterface.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface f extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: SamsungIDInterface.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements f {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f14736a;

        public a(IBinder iBinder) {
            this.f14736a = iBinder;
        }

        public String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.f14736a.transact(1, obtain, obtain2, 0);
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
        public IBinder asBinder() {
            return this.f14736a;
        }
    }
}
