package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.InterfaceC6075d;

/* renamed from: com.bytedance.pangle.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InterfaceC6069c extends IInterface {
    /* renamed from: a */
    void mo37171a(int i);

    /* renamed from: a */
    void mo37170a(int i, InterfaceC6075d interfaceC6075d);

    /* renamed from: a */
    boolean mo37169a(String str);

    /* renamed from: a */
    boolean mo37168a(String str, String str2);

    /* renamed from: b */
    int mo37166b(String str);

    /* renamed from: com.bytedance.pangle.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static abstract class AbstractBinderC6070a extends Binder implements InterfaceC6069c {
        public AbstractBinderC6070a() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        /* renamed from: a */
        public static InterfaceC6069c m37255a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC6069c)) {
                return (InterfaceC6069c) queryLocalInterface;
            }
            return new C6071a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            InterfaceC6075d c6077a;
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean mo37169a = mo37169a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(mo37169a ? 1 : 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int mo37166b = mo37166b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(mo37166b);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean mo37168a = mo37168a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(mo37168a ? 1 : 0);
                return true;
            } else if (i != 4) {
                if (i != 5) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                }
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                mo37171a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int readInt = parcel.readInt();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    c6077a = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC6075d)) {
                        c6077a = (InterfaceC6075d) queryLocalInterface;
                    } else {
                        c6077a = new InterfaceC6075d.AbstractBinderC6076a.C6077a(readStrongBinder);
                    }
                }
                mo37170a(readInt, c6077a);
                parcel2.writeNoException();
                return true;
            }
        }

        /* renamed from: a */
        public static InterfaceC6069c m37256a() {
            return C6071a.f21862a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.pangle.c$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static class C6071a implements InterfaceC6069c {

            /* renamed from: a */
            public static InterfaceC6069c f21862a;

            /* renamed from: b */
            private IBinder f21863b;

            C6071a(IBinder iBinder) {
                this.f21863b = iBinder;
            }

            @Override // com.bytedance.pangle.InterfaceC6069c
            /* renamed from: a */
            public final boolean mo37169a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f21863b.transact(1, obtain, obtain2, 0) && AbstractBinderC6070a.m37256a() != null) {
                        return AbstractBinderC6070a.m37256a().mo37169a(str);
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
                return this.f21863b;
            }

            @Override // com.bytedance.pangle.InterfaceC6069c
            /* renamed from: b */
            public final int mo37166b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f21863b.transact(2, obtain, obtain2, 0) && AbstractBinderC6070a.m37256a() != null) {
                        return AbstractBinderC6070a.m37256a().mo37166b(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.InterfaceC6069c
            /* renamed from: a */
            public final boolean mo37168a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f21863b.transact(3, obtain, obtain2, 0) && AbstractBinderC6070a.m37256a() != null) {
                        return AbstractBinderC6070a.m37256a().mo37168a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.InterfaceC6069c
            /* renamed from: a */
            public final void mo37170a(int i, InterfaceC6075d interfaceC6075d) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(interfaceC6075d != null ? interfaceC6075d.asBinder() : null);
                    if (!this.f21863b.transact(4, obtain, obtain2, 0) && AbstractBinderC6070a.m37256a() != null) {
                        AbstractBinderC6070a.m37256a().mo37170a(i, interfaceC6075d);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.InterfaceC6069c
            /* renamed from: a */
            public final void mo37171a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i);
                    if (!this.f21863b.transact(5, obtain, obtain2, 0) && AbstractBinderC6070a.m37256a() != null) {
                        AbstractBinderC6070a.m37256a().mo37171a(i);
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
