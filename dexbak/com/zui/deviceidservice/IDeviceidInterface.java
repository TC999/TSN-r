package com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface IDeviceidInterface extends IInterface {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* renamed from: a */
        private static final String f40091a = "com.zui.deviceidservice.IDeviceidInterface";

        /* renamed from: b */
        public static final int f40092b = 1;

        /* renamed from: c */
        public static final int f40093c = 2;

        /* renamed from: d */
        public static final int f40094d = 3;

        /* renamed from: e */
        public static final int f40095e = 4;

        /* renamed from: f */
        public static final int f40096f = 5;

        /* renamed from: g */
        public static final int f40097g = 6;

        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class Proxy implements IDeviceidInterface {

            /* renamed from: a */
            private IBinder f40098a;

            public Proxy(IBinder iBinder) {
                this.f40098a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f40098a;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            /* renamed from: f */
            public boolean mo12845f(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f40091a);
                    obtain.writeString(str);
                    this.f40098a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public String m12844g() {
                return Stub.f40091a;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public String getAAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f40091a);
                    obtain.writeString(str);
                    this.f40098a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public String getOAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f40091a);
                    this.f40098a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public String getUDID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f40091a);
                    this.f40098a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public String getVAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f40091a);
                    obtain.writeString(str);
                    this.f40098a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public boolean isSupport() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f40091a);
                    this.f40098a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, f40091a);
        }

        /* renamed from: a */
        public static IDeviceidInterface m12846a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f40091a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceidInterface)) ? new Proxy(iBinder) : (IDeviceidInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(f40091a);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(f40091a);
                    String oaid = getOAID();
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 2:
                    parcel.enforceInterface(f40091a);
                    String udid = getUDID();
                    parcel2.writeNoException();
                    parcel2.writeString(udid);
                    return true;
                case 3:
                    parcel.enforceInterface(f40091a);
                    boolean isSupport = isSupport();
                    parcel2.writeNoException();
                    parcel2.writeInt(isSupport ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f40091a);
                    String vaid = getVAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 5:
                    parcel.enforceInterface(f40091a);
                    String aaid = getAAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 6:
                    parcel.enforceInterface(f40091a);
                    boolean mo12845f = mo12845f(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(mo12845f ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: f */
    boolean mo12845f(String str);

    String getAAID(String str);

    String getOAID();

    String getUDID();

    String getVAID(String str);

    boolean isSupport();
}
