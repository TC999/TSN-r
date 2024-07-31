package com.bytedance.pangle;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.InterfaceC6128g;

/* renamed from: com.bytedance.pangle.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InterfaceC6091e extends IInterface {
    /* renamed from: a */
    ComponentName mo36957a(Intent intent, String str);

    /* renamed from: a */
    void mo36956a(InterfaceC6128g interfaceC6128g);

    /* renamed from: a */
    boolean mo36959a(Intent intent, InterfaceC6128g interfaceC6128g, int i, String str);

    /* renamed from: b */
    boolean mo36950b(Intent intent, String str);

    /* renamed from: com.bytedance.pangle.e$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static abstract class AbstractBinderC6092a extends Binder implements InterfaceC6091e {
        public AbstractBinderC6092a() {
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        /* renamed from: a */
        public static InterfaceC6091e m37202a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC6091e)) {
                return (InterfaceC6091e) queryLocalInterface;
            }
            return new C6093a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                ComponentName mo36957a = mo36957a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                if (mo36957a != null) {
                    parcel2.writeInt(1);
                    mo36957a.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean mo36950b = mo36950b(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(mo36950b ? 1 : 0);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean mo36959a = mo36959a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, InterfaceC6128g.AbstractBinderC6129a.m37141a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(mo36959a ? 1 : 0);
                return true;
            } else if (i != 4) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.pangle.IServiceManager");
                return true;
            } else {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                mo36956a(InterfaceC6128g.AbstractBinderC6129a.m37141a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }

        /* renamed from: a */
        public static InterfaceC6091e m37203a() {
            return C6093a.f21939a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.pangle.e$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static class C6093a implements InterfaceC6091e {

            /* renamed from: a */
            public static InterfaceC6091e f21939a;

            /* renamed from: b */
            private IBinder f21940b;

            C6093a(IBinder iBinder) {
                this.f21940b = iBinder;
            }

            @Override // com.bytedance.pangle.InterfaceC6091e
            /* renamed from: a */
            public final ComponentName mo36957a(Intent intent, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.f21940b.transact(1, obtain, obtain2, 0) && AbstractBinderC6092a.m37203a() != null) {
                        return AbstractBinderC6092a.m37203a().mo36957a(intent, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f21940b;
            }

            @Override // com.bytedance.pangle.InterfaceC6091e
            /* renamed from: b */
            public final boolean mo36950b(Intent intent, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.f21940b.transact(2, obtain, obtain2, 0) && AbstractBinderC6092a.m37203a() != null) {
                        return AbstractBinderC6092a.m37203a().mo36950b(intent, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.InterfaceC6091e
            /* renamed from: a */
            public final boolean mo36959a(Intent intent, InterfaceC6128g interfaceC6128g, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(interfaceC6128g != null ? interfaceC6128g.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.f21940b.transact(3, obtain, obtain2, 0) && AbstractBinderC6092a.m37203a() != null) {
                        return AbstractBinderC6092a.m37203a().mo36959a(intent, interfaceC6128g, i, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.InterfaceC6091e
            /* renamed from: a */
            public final void mo36956a(InterfaceC6128g interfaceC6128g) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    obtain.writeStrongBinder(interfaceC6128g != null ? interfaceC6128g.asBinder() : null);
                    if (!this.f21940b.transact(4, obtain, obtain2, 0) && AbstractBinderC6092a.m37203a() != null) {
                        AbstractBinderC6092a.m37203a().mo36956a(interfaceC6128g);
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
