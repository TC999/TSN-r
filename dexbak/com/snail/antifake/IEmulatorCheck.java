package com.snail.antifake;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface IEmulatorCheck extends IInterface {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class Stub extends Binder implements IEmulatorCheck {

        /* renamed from: a */
        private static final String f33783a = "com.snail.antifake.IEmulatorCheck";

        /* renamed from: b */
        static final int f33784b = 1;

        /* renamed from: c */
        static final int f33785c = 2;

        /* renamed from: com.snail.antifake.IEmulatorCheck$Stub$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        private static class C11933a implements IEmulatorCheck {

            /* renamed from: a */
            private IBinder f33786a;

            C11933a(IBinder iBinder) {
                this.f33786a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f33786a;
            }

            @Override // com.snail.antifake.IEmulatorCheck
            /* renamed from: d */
            public boolean mo19671d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f33783a);
                    this.f33786a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.snail.antifake.IEmulatorCheck
            /* renamed from: e */
            public void mo19670e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f33783a);
                    this.f33786a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public String m19708g() {
                return Stub.f33783a;
            }
        }

        public Stub() {
            attachInterface(this, f33783a);
        }

        /* renamed from: a */
        public static IEmulatorCheck m19709a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f33783a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IEmulatorCheck)) {
                return (IEmulatorCheck) queryLocalInterface;
            }
            return new C11933a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(f33783a);
                boolean mo19671d = mo19671d();
                parcel2.writeNoException();
                parcel2.writeInt(mo19671d ? 1 : 0);
                return true;
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(f33783a);
                return true;
            } else {
                parcel.enforceInterface(f33783a);
                mo19670e();
                parcel2.writeNoException();
                return true;
            }
        }
    }

    /* renamed from: d */
    boolean mo19671d() throws RemoteException;

    /* renamed from: e */
    void mo19670e() throws RemoteException;
}
