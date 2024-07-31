package com.beizi.fusion.p068e.p070b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.beizi.fusion.e.b.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface SamsungIDInterface extends IInterface {

    /* compiled from: SamsungIDInterface.java */
    /* renamed from: com.beizi.fusion.e.b.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3109a implements SamsungIDInterface {

        /* renamed from: a */
        private IBinder f11218a;

        public C3109a(IBinder iBinder) {
            this.f11218a = iBinder;
        }

        /* renamed from: a */
        public String m48533a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.f11218a.transact(1, obtain, obtain2, 0);
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
            return this.f11218a;
        }
    }
}
