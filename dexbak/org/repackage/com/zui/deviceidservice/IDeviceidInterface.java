package org.repackage.com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface IDeviceidInterface extends IInterface {
    /* renamed from: a */
    String mo2685a() throws RemoteException;

    /* renamed from: a */
    String mo2684a(String str) throws RemoteException;

    /* renamed from: b */
    String mo2683b() throws RemoteException;

    /* renamed from: b */
    String mo2682b(String str) throws RemoteException;

    /* renamed from: c */
    boolean mo2681c() throws RemoteException;

    /* renamed from: c */
    boolean mo2680c(String str) throws RemoteException;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* renamed from: a */
        private static final String f44274a = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        /* renamed from: b */
        static final int f44275b = 1;

        /* renamed from: c */
        static final int f44276c = 2;

        /* renamed from: d */
        static final int f44277d = 3;

        /* renamed from: e */
        static final int f44278e = 4;

        /* renamed from: f */
        static final int f44279f = 5;

        /* renamed from: g */
        static final int f44280g = 6;

        public Stub() {
            attachInterface(this, f44274a);
        }

        /* renamed from: a */
        public static IDeviceidInterface m2686a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f44274a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDeviceidInterface)) {
                return (IDeviceidInterface) queryLocalInterface;
            }
            return new C15419a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(f44274a);
                        String mo2685a = mo2685a();
                        parcel2.writeNoException();
                        parcel2.writeString(mo2685a);
                        return true;
                    case 2:
                        parcel.enforceInterface(f44274a);
                        String mo2683b = mo2683b();
                        parcel2.writeNoException();
                        parcel2.writeString(mo2683b);
                        return true;
                    case 3:
                        parcel.enforceInterface(f44274a);
                        boolean mo2681c = mo2681c();
                        parcel2.writeNoException();
                        parcel2.writeInt(mo2681c ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(f44274a);
                        String mo2684a = mo2684a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(mo2684a);
                        return true;
                    case 5:
                        parcel.enforceInterface(f44274a);
                        String mo2682b = mo2682b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(mo2682b);
                        return true;
                    case 6:
                        parcel.enforceInterface(f44274a);
                        boolean mo2680c = mo2680c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo2680c ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(f44274a);
            return true;
        }

        /* renamed from: org.repackage.com.zui.deviceidservice.IDeviceidInterface$Stub$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        private static class C15419a implements IDeviceidInterface {

            /* renamed from: a */
            private IBinder f44281a;

            C15419a(IBinder iBinder) {
                this.f44281a = iBinder;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            /* renamed from: a */
            public String mo2685a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f44274a);
                    this.f44281a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f44281a;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            /* renamed from: b */
            public String mo2683b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f44274a);
                    this.f44281a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            /* renamed from: c */
            public boolean mo2681c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f44274a);
                    this.f44281a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public String m2679g() {
                return Stub.f44274a;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            /* renamed from: a */
            public String mo2684a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f44274a);
                    obtain.writeString(str);
                    this.f44281a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            /* renamed from: b */
            public String mo2682b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f44274a);
                    obtain.writeString(str);
                    this.f44281a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            /* renamed from: c */
            public boolean mo2680c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f44274a);
                    obtain.writeString(str);
                    this.f44281a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
