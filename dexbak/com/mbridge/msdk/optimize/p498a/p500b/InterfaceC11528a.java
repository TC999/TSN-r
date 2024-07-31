package com.mbridge.msdk.optimize.p498a.p500b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* compiled from: ASUSIDInterface.java */
/* renamed from: com.mbridge.msdk.optimize.a.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC11528a extends IInterface {

    /* compiled from: ASUSIDInterface.java */
    /* renamed from: com.mbridge.msdk.optimize.a.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C11529a implements InterfaceC11528a {

        /* renamed from: a */
        private IBinder f31649a;

        public C11529a(IBinder iBinder) {
            this.f31649a = iBinder;
        }

        /* renamed from: a */
        public final String m21349a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                this.f31649a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain.recycle();
            obtain2.recycle();
            return str;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f31649a;
        }
    }
}
