package org.repackage.com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface IDeviceidInterface extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String str) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* renamed from: a  reason: collision with root package name */
        private static final String f61675a = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        /* renamed from: b  reason: collision with root package name */
        static final int f61676b = 1;

        /* renamed from: c  reason: collision with root package name */
        static final int f61677c = 2;

        /* renamed from: d  reason: collision with root package name */
        static final int f61678d = 3;

        /* renamed from: e  reason: collision with root package name */
        static final int f61679e = 4;

        /* renamed from: f  reason: collision with root package name */
        static final int f61680f = 5;

        /* renamed from: g  reason: collision with root package name */
        static final int f61681g = 6;

        public Stub() {
            attachInterface(this, "org.repackage.com.zui.deviceidservice.IDeviceidInterface");
        }

        public static IDeviceidInterface c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDeviceidInterface)) {
                return (IDeviceidInterface) queryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                        String a4 = a();
                        parcel2.writeNoException();
                        parcel2.writeString(a4);
                        return true;
                    case 2:
                        parcel.enforceInterface("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                        String b4 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b4);
                        return true;
                    case 3:
                        parcel.enforceInterface("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                        boolean c4 = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c4 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                        String a5 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a5);
                        return true;
                    case 5:
                        parcel.enforceInterface("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                        String b5 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b5);
                        return true;
                    case 6:
                        parcel.enforceInterface("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                        boolean c5 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(c5 ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
            return true;
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        private static class a implements IDeviceidInterface {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f61682a;

            a(IBinder iBinder) {
                this.f61682a = iBinder;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                    this.f61682a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f61682a;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                    this.f61682a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                    this.f61682a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String g() {
                return "org.repackage.com.zui.deviceidservice.IDeviceidInterface";
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f61682a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f61682a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.repackage.com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f61682a.transact(6, obtain, obtain2, 0);
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
