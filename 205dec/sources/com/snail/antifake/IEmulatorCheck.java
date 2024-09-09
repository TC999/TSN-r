package com.snail.antifake;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface IEmulatorCheck extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class Stub extends Binder implements IEmulatorCheck {

        /* renamed from: a  reason: collision with root package name */
        private static final String f48117a = "com.snail.antifake.IEmulatorCheck";

        /* renamed from: b  reason: collision with root package name */
        static final int f48118b = 1;

        /* renamed from: c  reason: collision with root package name */
        static final int f48119c = 2;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        private static class a implements IEmulatorCheck {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f48120a;

            a(IBinder iBinder) {
                this.f48120a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f48120a;
            }

            @Override // com.snail.antifake.IEmulatorCheck
            public boolean d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.snail.antifake.IEmulatorCheck");
                    this.f48120a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.snail.antifake.IEmulatorCheck
            public void e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.snail.antifake.IEmulatorCheck");
                    this.f48120a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String g() {
                return "com.snail.antifake.IEmulatorCheck";
            }
        }

        public Stub() {
            attachInterface(this, "com.snail.antifake.IEmulatorCheck");
        }

        public static IEmulatorCheck a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.snail.antifake.IEmulatorCheck");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IEmulatorCheck)) {
                return (IEmulatorCheck) queryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 == 1) {
                parcel.enforceInterface("com.snail.antifake.IEmulatorCheck");
                boolean d4 = d();
                parcel2.writeNoException();
                parcel2.writeInt(d4 ? 1 : 0);
                return true;
            } else if (i4 != 2) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.snail.antifake.IEmulatorCheck");
                return true;
            } else {
                parcel.enforceInterface("com.snail.antifake.IEmulatorCheck");
                e();
                parcel2.writeNoException();
                return true;
            }
        }
    }

    boolean d() throws RemoteException;

    void e() throws RemoteException;
}
