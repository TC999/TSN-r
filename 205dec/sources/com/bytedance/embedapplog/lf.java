package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.embedapplog.bs;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface lf extends IInterface {
    void c(int i4, long j4, boolean z3, float f4, double d4, String str);

    void c(bs bsVar);

    void w(bs bsVar);

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements lf {
        public static lf c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof lf)) {
                return (lf) queryLocalInterface;
            }
            return new C0380c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                c(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                c(bs.c.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i4 != 3) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDService");
                return true;
            } else {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                w(bs.c.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }

        public static lf c() {
            return C0380c.f26758c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.embedapplog.lf$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0380c implements lf {

            /* renamed from: c  reason: collision with root package name */
            public static lf f26758c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f26759w;

            C0380c(IBinder iBinder) {
                this.f26759w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f26759w;
            }

            @Override // com.bytedance.embedapplog.lf
            public void c(int i4, long j4, boolean z3, float f4, double d4, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    obtain.writeInt(z3 ? 1 : 0);
                    obtain.writeFloat(f4);
                    obtain.writeDouble(d4);
                    obtain.writeString(str);
                    try {
                        if (!this.f26759w.transact(1, obtain, obtain2, 0) && c.c() != null) {
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

            @Override // com.bytedance.embedapplog.lf
            public void w(bs bsVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeStrongBinder(bsVar != null ? bsVar.asBinder() : null);
                    if (!this.f26759w.transact(3, obtain, obtain2, 0) && c.c() != null) {
                        c.c().w(bsVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.lf
            public void c(bs bsVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeStrongBinder(bsVar != null ? bsVar.asBinder() : null);
                    if (!this.f26759w.transact(2, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(bsVar);
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
