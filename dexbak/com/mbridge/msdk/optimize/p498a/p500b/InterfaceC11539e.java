package com.mbridge.msdk.optimize.p498a.p500b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: SamsungIDInterface.java */
/* renamed from: com.mbridge.msdk.optimize.a.b.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC11539e extends IInterface {

    /* compiled from: SamsungIDInterface.java */
    /* renamed from: com.mbridge.msdk.optimize.a.b.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11540a implements InterfaceC11539e {

        /* renamed from: a */
        private IBinder f31653a;

        public C11540a(IBinder iBinder) {
            this.f31653a = iBinder;
        }

        /* renamed from: a */
        public final String m21339a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.f31653a.transact(1, obtain, obtain2, 0);
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
            return this.f31653a;
        }
    }
}
