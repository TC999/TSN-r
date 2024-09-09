package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface bs extends IInterface {
    void c(int i4, long j4, boolean z3, float f4, double d4, String str);

    void c(int i4, Bundle bundle);

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements bs {
        public c() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        public static bs c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            if (queryLocalInterface != null && (queryLocalInterface instanceof bs)) {
                return (bs) queryLocalInterface;
            }
            return new C0376c(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                c(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i4 != 2) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                return true;
            } else {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                c(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
        }

        public static bs c() {
            return C0376c.f26711c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.embedapplog.bs$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0376c implements bs {

            /* renamed from: c  reason: collision with root package name */
            public static bs f26711c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f26712w;

            C0376c(IBinder iBinder) {
                this.f26712w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f26712w;
            }

            @Override // com.bytedance.embedapplog.bs
            public void c(int i4, long j4, boolean z3, float f4, double d4, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    obtain.writeInt(z3 ? 1 : 0);
                    obtain.writeFloat(f4);
                    obtain.writeDouble(d4);
                    obtain.writeString(str);
                    try {
                        if (!this.f26712w.transact(1, obtain, obtain2, 0) && c.c() != null) {
                            c.c().c(i4, j4, z3, f4, d4, str);
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.bytedance.embedapplog.bs
            public void c(int i4, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    obtain.writeInt(i4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f26712w.transact(2, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(i4, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
