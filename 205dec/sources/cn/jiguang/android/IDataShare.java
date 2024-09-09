package cn.jiguang.android;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface IDataShare extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class Stub extends Binder implements IDataShare {
        private static final String DESCRIPTOR = "cn.jiguang.android.IDataShare";
        static final int TRANSACTION_bind = 4;
        static final int TRANSACTION_execute = 3;
        static final int TRANSACTION_getBinderByType = 1;
        static final int TRANSACTION_onAction = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public static class a implements IDataShare {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f2327a;

            a(IBinder iBinder) {
                this.f2327a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2327a;
            }

            @Override // cn.jiguang.android.IDataShare
            public String bind(IDataShare iDataShare, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDataShare != null ? iDataShare.asBinder() : null);
                    obtain.writeString(str);
                    this.f2327a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.jiguang.android.IDataShare
            public Bundle execute(String str, String str2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2327a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.jiguang.android.IDataShare
            public IBinder getBinderByType(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2327a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.jiguang.android.IDataShare
            public void onAction(String str, String str2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2327a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDataShare asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDataShare)) ? new a(iBinder) : (IDataShare) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IBinder binderByType = getBinderByType(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(binderByType);
                return true;
            }
            if (i4 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onAction(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i4 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                Bundle execute = execute(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (execute != null) {
                    parcel2.writeInt(1);
                    execute.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i4 != 4) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                String bind = bind(asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(bind);
                return true;
            }
        }
    }

    String bind(IDataShare iDataShare, String str);

    Bundle execute(String str, String str2, Bundle bundle);

    IBinder getBinderByType(String str, String str2);

    void onAction(String str, String str2, Bundle bundle);
}
