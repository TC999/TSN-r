package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.bytedance.pangle.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InterfaceC6075d extends IInterface {

    /* renamed from: com.bytedance.pangle.d$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static abstract class AbstractBinderC6076a extends Binder implements InterfaceC6075d {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.pangle.d$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static class C6077a implements InterfaceC6075d {

            /* renamed from: a */
            public static InterfaceC6075d f21910a;

            /* renamed from: b */
            private IBinder f21911b;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C6077a(IBinder iBinder) {
                this.f21911b = iBinder;
            }

            @Override // com.bytedance.pangle.InterfaceC6075d
            /* renamed from: a */
            public final void mo37145a(String str, int i, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPluginInstallListener");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (!this.f21911b.transact(1, obtain, obtain2, 0) && AbstractBinderC6076a.m37252a() != null) {
                        AbstractBinderC6076a.m37252a().mo37145a(str, i, str2);
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
                return this.f21911b;
            }
        }

        public AbstractBinderC6076a() {
            attachInterface(this, "com.bytedance.pangle.IPluginInstallListener");
        }

        /* renamed from: a */
        public static InterfaceC6075d m37252a() {
            return C6077a.f21910a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.pangle.IPluginInstallListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPluginInstallListener");
            mo37145a(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo37145a(String str, int i, String str2);
}
