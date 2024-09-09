package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ev extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements ev {

        /* renamed from: com.bytedance.embedapplog.ev$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        static class C0377c implements ev {

            /* renamed from: c  reason: collision with root package name */
            private IBinder f26726c;

            C0377c(IBinder iBinder) {
                this.f26726c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f26726c;
            }

            @Override // com.bytedance.embedapplog.ev
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    this.f26726c.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ev
            public String sr() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    this.f26726c.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ev
            public String ux() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    this.f26726c.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ev
            public String w() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    this.f26726c.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.ev
            public String xv() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    this.f26726c.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ev c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDidAidlInterface.Stub.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ev)) {
                return (ev) queryLocalInterface;
            }
            return new C0377c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                boolean c4 = c();
                parcel2.writeNoException();
                parcel2.writeInt(c4 ? 1 : 0);
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                String w3 = w();
                parcel2.writeNoException();
                parcel2.writeString(w3);
                return true;
            } else if (i4 == 3) {
                parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                String xv = xv();
                parcel2.writeNoException();
                parcel2.writeString(xv);
                return true;
            } else if (i4 == 4) {
                parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                String sr = sr();
                parcel2.writeNoException();
                parcel2.writeString(sr);
                return true;
            } else if (i4 != 5) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(IDidAidlInterface.Stub.DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                String ux = ux();
                parcel2.writeNoException();
                parcel2.writeString(ux);
                return true;
            }
        }
    }

    boolean c();

    String sr();

    String ux();

    String w();

    String xv();
}
