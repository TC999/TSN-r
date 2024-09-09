package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ux extends IInterface {
    String c(String str);

    boolean c();

    String sr(String str);

    String ux(String str);

    String w();

    String w(String str);

    String xv(String str);

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements ux {
        public static ux c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ux)) {
                return (ux) queryLocalInterface;
            }
            return new C0383c(iBinder);
        }

        public static ux xv() {
            return C0383c.f26825c;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String c4 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(c4);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String w3 = w(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(w3);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String xv = xv(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(xv);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String sr = sr(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(sr);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String ux = ux(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(ux);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        boolean c5 = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c5 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String w4 = w();
                        parcel2.writeNoException();
                        parcel2.writeString(w4);
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.embedapplog.ux$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0383c implements ux {

            /* renamed from: c  reason: collision with root package name */
            public static ux f26825c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f26826w;

            C0383c(IBinder iBinder) {
                this.f26826w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f26826w;
            }

            @Override // com.bytedance.embedapplog.ux
            public String c(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f26826w.transact(1, obtain, obtain2, 0) && c.xv() != null) {
                        return c.xv().c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ux
            public String sr(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f26826w.transact(4, obtain, obtain2, 0) && c.xv() != null) {
                        return c.xv().sr(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ux
            public String ux(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f26826w.transact(5, obtain, obtain2, 0) && c.xv() != null) {
                        return c.xv().ux(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ux
            public String w(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f26826w.transact(2, obtain, obtain2, 0) && c.xv() != null) {
                        return c.xv().w(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ux
            public String xv(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f26826w.transact(3, obtain, obtain2, 0) && c.xv() != null) {
                        return c.xv().xv(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ux
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.f26826w.transact(6, obtain, obtain2, 0) && c.xv() != null) {
                        return c.xv().c();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ux
            public String w() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.f26826w.transact(7, obtain, obtain2, 0) && c.xv() != null) {
                        return c.xv().w();
                    }
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
