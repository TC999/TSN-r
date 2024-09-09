package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface r extends IInterface {
    String c();

    String c(String str);

    String w();

    String w(String str);

    boolean xv();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements r {
        public static r c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof r)) {
                return (r) queryLocalInterface;
            }
            return new C0382c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String c4 = c();
                parcel2.writeNoException();
                parcel2.writeString(c4);
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String w3 = w();
                parcel2.writeNoException();
                parcel2.writeString(w3);
                return true;
            } else if (i4 == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean xv = xv();
                parcel2.writeNoException();
                parcel2.writeInt(xv ? 1 : 0);
                return true;
            } else if (i4 == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String c5 = c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(c5);
                return true;
            } else if (i4 != 5) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            } else {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String w4 = w(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(w4);
                return true;
            }
        }

        /* renamed from: com.bytedance.embedapplog.r$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        static class C0382c implements r {

            /* renamed from: c  reason: collision with root package name */
            private IBinder f26787c;

            C0382c(IBinder iBinder) {
                this.f26787c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f26787c;
            }

            @Override // com.bytedance.embedapplog.r
            public String c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f26787c.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.r
            public String w() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f26787c.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.r
            public boolean xv() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f26787c.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.r
            public String c(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f26787c.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.r
            public String w(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f26787c.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
