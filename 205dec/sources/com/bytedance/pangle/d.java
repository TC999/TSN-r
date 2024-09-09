package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface d extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class a extends Binder implements d {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* renamed from: com.bytedance.pangle.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0426a implements d {

            /* renamed from: a  reason: collision with root package name */
            public static d f28674a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f28675b;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0426a(IBinder iBinder) {
                this.f28675b = iBinder;
            }

            @Override // com.bytedance.pangle.d
            public final void a(String str, int i4, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPluginInstallListener");
                    obtain.writeString(str);
                    obtain.writeInt(i4);
                    obtain.writeString(str2);
                    if (!this.f28675b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(str, i4, str2);
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
                return this.f28675b;
            }
        }

        public a() {
            attachInterface(this, "com.bytedance.pangle.IPluginInstallListener");
        }

        public static d a() {
            return C0426a.f28674a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 != 1) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.bytedance.pangle.IPluginInstallListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPluginInstallListener");
            a(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void a(String str, int i4, String str2);
}
