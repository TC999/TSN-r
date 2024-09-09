package com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface IDeviceidInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* renamed from: a  reason: collision with root package name */
        private static final String f54597a = "com.zui.deviceidservice.IDeviceidInterface";

        /* renamed from: b  reason: collision with root package name */
        public static final int f54598b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f54599c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f54600d = 3;

        /* renamed from: e  reason: collision with root package name */
        public static final int f54601e = 4;

        /* renamed from: f  reason: collision with root package name */
        public static final int f54602f = 5;

        /* renamed from: g  reason: collision with root package name */
        public static final int f54603g = 6;

        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class Proxy implements IDeviceidInterface {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f54604a;

            public Proxy(IBinder iBinder) {
                this.f54604a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f54604a;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public boolean f(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f54597a);
                    obtain.writeString(str);
                    this.f54604a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String g() {
                return Stub.f54597a;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public String getAAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f54597a);
                    obtain.writeString(str);
                    this.f54604a.transact(5, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(Stub.f54597a);
                    this.f54604a.transact(1, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(Stub.f54597a);
                    this.f54604a.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(Stub.f54597a);
                    obtain.writeString(str);
                    this.f54604a.transact(4, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(Stub.f54597a);
                    this.f54604a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, f54597a);
        }

        public static IDeviceidInterface a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f54597a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceidInterface)) ? new Proxy(iBinder) : (IDeviceidInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1598968902) {
                parcel2.writeString(f54597a);
                return true;
            }
            switch (i4) {
                case 1:
                    parcel.enforceInterface(f54597a);
                    String oaid = getOAID();
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 2:
                    parcel.enforceInterface(f54597a);
                    String udid = getUDID();
                    parcel2.writeNoException();
                    parcel2.writeString(udid);
                    return true;
                case 3:
                    parcel.enforceInterface(f54597a);
                    boolean isSupport = isSupport();
                    parcel2.writeNoException();
                    parcel2.writeInt(isSupport ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f54597a);
                    String vaid = getVAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 5:
                    parcel.enforceInterface(f54597a);
                    String aaid = getAAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 6:
                    parcel.enforceInterface(f54597a);
                    boolean f4 = f(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(f4 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i4, parcel, parcel2, i5);
            }
        }
    }

    boolean f(String str);

    String getAAID(String str);

    String getOAID();

    String getUDID();

    String getVAID(String str);

    boolean isSupport();
}
