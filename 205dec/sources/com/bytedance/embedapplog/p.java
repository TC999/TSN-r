package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface p extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements p {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.embedapplog.p$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0381c implements p {

            /* renamed from: c  reason: collision with root package name */
            public static p f26782c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f26783w;

            C0381c(IBinder iBinder) {
                this.f26783w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f26783w;
            }

            @Override // com.bytedance.embedapplog.p
            public String c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f26783w.transact(1, obtain, obtain2, 0) && c.r() != null) {
                        return c.r().c();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public void f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f26783w.transact(6, obtain, obtain2, 0) && c.r() != null) {
                        c.r().f();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public boolean sr() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f26783w.transact(4, obtain, obtain2, 0) && c.r() != null) {
                        return c.r().sr();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public boolean ux() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f26783w.transact(5, obtain, obtain2, 0) && c.r() != null) {
                        return c.r().ux();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public String w() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f26783w.transact(2, obtain, obtain2, 0) && c.r() != null) {
                        return c.r().w();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.p
            public String xv() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f26783w.transact(3, obtain, obtain2, 0) && c.r() != null) {
                        return c.r().xv();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static p c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof p)) {
                return (p) queryLocalInterface;
            }
            return new C0381c(iBinder);
        }

        public static p r() {
            return C0381c.f26782c;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String c4 = c();
                        parcel2.writeNoException();
                        parcel2.writeString(c4);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String w3 = w();
                        parcel2.writeNoException();
                        parcel2.writeString(w3);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String xv = xv();
                        parcel2.writeNoException();
                        parcel2.writeString(xv);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean sr = sr();
                        parcel2.writeNoException();
                        parcel2.writeInt(sr ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean ux = ux();
                        parcel2.writeNoException();
                        parcel2.writeInt(ux ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        f();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.bun.lib.MsaIdInterface");
            return true;
        }
    }

    String c();

    void f();

    boolean sr();

    boolean ux();

    String w();

    String xv();
}
