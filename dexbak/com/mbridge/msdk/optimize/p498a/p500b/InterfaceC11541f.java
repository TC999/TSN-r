package com.mbridge.msdk.optimize.p498a.p500b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: ZTEIDInterface.java */
/* renamed from: com.mbridge.msdk.optimize.a.b.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC11541f extends IInterface {

    /* compiled from: ZTEIDInterface.java */
    /* renamed from: com.mbridge.msdk.optimize.a.b.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractBinderC11542a extends Binder implements InterfaceC11541f {

        /* compiled from: ZTEIDInterface.java */
        /* renamed from: com.mbridge.msdk.optimize.a.b.f$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C11543a implements InterfaceC11541f {

            /* renamed from: a */
            private IBinder f31654a;

            public C11543a(IBinder iBinder) {
                this.f31654a = iBinder;
            }

            @Override // com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11541f
            /* renamed from: a */
            public final String mo21338a() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f31654a.transact(3, obtain, obtain2, 0);
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
                return this.f31654a;
            }
        }
    }

    /* renamed from: a */
    String mo21338a();
}
