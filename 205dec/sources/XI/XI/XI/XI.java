package XI.XI.XI;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public interface XI extends IInterface {

    /* renamed from: XI.XI.XI.XI$XI  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static abstract class AbstractBinderC0004XI extends Binder implements XI {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f81a = 0;

        /* renamed from: XI.XI.XI.XI$XI$XI  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        public static class C0005XI implements XI {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f82a;

            public C0005XI(IBinder iBinder) {
                this.f82a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f82a;
            }

            @Override // XI.XI.XI.XI
            public String getAAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    obtain.writeString(str);
                    this.f82a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XI.XI.XI.XI
            public String getOAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    this.f82a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XI.XI.XI.XI
            public String getVAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    this.f82a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XI.XI.XI.XI
            public boolean isSupported() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    this.f82a.transact(1, obtain, obtain2, 0);
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
