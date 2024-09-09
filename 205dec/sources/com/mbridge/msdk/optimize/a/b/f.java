package com.mbridge.msdk.optimize.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: ZTEIDInterface.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface f extends IInterface {

    /* compiled from: ZTEIDInterface.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class a extends Binder implements f {

        /* compiled from: ZTEIDInterface.java */
        /* renamed from: com.mbridge.msdk.optimize.a.b.f$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class C0758a implements f {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f40427a;

            public C0758a(IBinder iBinder) {
                this.f40427a = iBinder;
            }

            @Override // com.mbridge.msdk.optimize.a.b.f
            public final String a() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f40427a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                    str = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return str;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f40427a;
            }
        }
    }

    String a();
}
