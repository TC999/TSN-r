package com.mbridge.msdk.optimize.a.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* compiled from: ASUSIDInterface.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface a extends IInterface {

    /* compiled from: ASUSIDInterface.java */
    /* renamed from: com.mbridge.msdk.optimize.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class C0754a implements a {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f40422a;

        public C0754a(IBinder iBinder) {
            this.f40422a = iBinder;
        }

        public final String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                this.f40422a.transact(3, obtain, obtain2, 0);
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
            return this.f40422a;
        }
    }
}
