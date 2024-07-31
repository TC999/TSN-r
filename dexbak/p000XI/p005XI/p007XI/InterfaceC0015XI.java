package p000XI.p005XI.p007XI;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: XI.XI.XI.XI */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface InterfaceC0015XI extends IInterface {

    /* renamed from: XI.XI.XI.XI$XI */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static abstract class AbstractBinderC0016XI extends Binder implements InterfaceC0015XI {

        /* renamed from: a */
        public static final /* synthetic */ int f33a = 0;

        /* renamed from: XI.XI.XI.XI$XI$XI */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public static class C0017XI implements InterfaceC0015XI {

            /* renamed from: a */
            public IBinder f34a;

            public C0017XI(IBinder iBinder) {
                this.f34a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f34a;
            }

            @Override // p000XI.p005XI.p007XI.InterfaceC0015XI
            public String getAAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    obtain.writeString(str);
                    this.f34a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // p000XI.p005XI.p007XI.InterfaceC0015XI
            public String getOAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    this.f34a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // p000XI.p005XI.p007XI.InterfaceC0015XI
            public String getVAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    this.f34a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // p000XI.p005XI.p007XI.InterfaceC0015XI
            public boolean isSupported() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    this.f34a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    String getAAID(String str);

    String getOAID();

    String getVAID();

    boolean isSupported();
}
