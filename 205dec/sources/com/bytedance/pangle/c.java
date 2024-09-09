package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface c extends IInterface {
    void a(int i4);

    void a(int i4, d dVar);

    boolean a(String str);

    boolean a(String str, String str2);

    int b(String str);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0425a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            d c0426a;
            if (i4 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a4 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a4 ? 1 : 0);
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int b4 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b4);
                return true;
            } else if (i4 == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a5 = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a5 ? 1 : 0);
                return true;
            } else if (i4 != 4) {
                if (i4 != 5) {
                    if (i4 != 1598968902) {
                        return super.onTransact(i4, parcel, parcel2, i5);
                    }
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                }
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int readInt = parcel.readInt();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    c0426a = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                        c0426a = (d) queryLocalInterface;
                    } else {
                        c0426a = new d.a.C0426a(readStrongBinder);
                    }
                }
                a(readInt, c0426a);
                parcel2.writeNoException();
                return true;
            }
        }

        public static c a() {
            return C0425a.f28631a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* renamed from: com.bytedance.pangle.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0425a implements c {

            /* renamed from: a  reason: collision with root package name */
            public static c f28631a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f28632b;

            C0425a(IBinder iBinder) {
                this.f28632b = iBinder;
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f28632b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f28632b;
            }

            @Override // com.bytedance.pangle.c
            public final int b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f28632b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f28632b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final void a(int i4, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i4);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (!this.f28632b.transact(4, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(i4, dVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final void a(int i4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i4);
                    if (!this.f28632b.transact(5, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(i4);
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
