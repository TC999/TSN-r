package com.bytedance.pangle;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.bytedance.pangle.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InterfaceC6128g extends IInterface {
    /* renamed from: a */
    int mo36944a();

    /* renamed from: a */
    void mo36943a(ComponentName componentName, IBinder iBinder);

    /* renamed from: com.bytedance.pangle.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static abstract class AbstractBinderC6129a extends Binder implements InterfaceC6128g {
        public AbstractBinderC6129a() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        /* renamed from: a */
        public static InterfaceC6128g m37141a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC6128g)) {
                return (InterfaceC6128g) queryLocalInterface;
            }
            return new C6130a(iBinder);
        }

        /* renamed from: b */
        public static InterfaceC6128g m37138b() {
            return C6130a.f22012a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                mo36943a(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                return true;
            } else {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                int mo36944a = mo36944a();
                parcel2.writeNoException();
                parcel2.writeInt(mo36944a);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.pangle.g$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static class C6130a implements InterfaceC6128g {

            /* renamed from: a */
            public static InterfaceC6128g f22012a;

            /* renamed from: b */
            private IBinder f22013b;

            C6130a(IBinder iBinder) {
                this.f22013b = iBinder;
            }

            @Override // com.bytedance.pangle.InterfaceC6128g
            /* renamed from: a */
            public final void mo36943a(ComponentName componentName, IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.f22013b.transact(1, obtain, obtain2, 0) && AbstractBinderC6129a.m37138b() != null) {
                        AbstractBinderC6129a.m37138b().mo36943a(componentName, iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f22013b;
            }

            @Override // com.bytedance.pangle.InterfaceC6128g
            /* renamed from: a */
            public final int mo36944a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.f22013b.transact(2, obtain, obtain2, 0) && AbstractBinderC6129a.m37138b() != null) {
                        return AbstractBinderC6129a.m37138b().mo36944a();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
