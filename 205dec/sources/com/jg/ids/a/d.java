package com.jg.ids.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f37807a;

    public d(IBinder iBinder) {
        this.f37807a = iBinder;
    }

    @Override // com.jg.ids.a.b
    public final boolean a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            this.f37807a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            r0 = obtain2.readInt() != 0;
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
        }
        return r0;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f37807a;
    }

    @Override // com.jg.ids.a.b
    public final String b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            this.f37807a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }

    @Override // com.jg.ids.a.b
    public final String c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            this.f37807a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }

    @Override // com.jg.ids.a.b
    public final String d() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            this.f37807a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }

    @Override // com.jg.ids.a.b
    public final String e() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            this.f37807a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return readString;
        } catch (RemoteException e4) {
            obtain2.recycle();
            obtain.recycle();
            return "";
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }
}
