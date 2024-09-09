package com.bytedance.pangle.sdk.component.log.impl;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IListenerEventManager extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class Default implements IListenerEventManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
        public int delete(Uri uri, String str, String[] strArr) throws RemoteException {
            return 0;
        }

        @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
        public String getType(Uri uri) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
        public String insert(Uri uri, ContentValues contentValues) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
        public Map query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException {
            return 0;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class Stub extends Binder implements IListenerEventManager {
        private static final String DESCRIPTOR = "com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager";
        static final int TRANSACTION_delete = 4;
        static final int TRANSACTION_getType = 2;
        static final int TRANSACTION_insert = 3;
        static final int TRANSACTION_query = 1;
        static final int TRANSACTION_update = 5;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class Proxy implements IListenerEventManager {
            public static IListenerEventManager sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
            public int delete(Uri uri, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().delete(uri, str, strArr);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
            public String getType(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getType(uri);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
            public String insert(Uri uri, ContentValues contentValues) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contentValues != null) {
                        obtain.writeInt(1);
                        contentValues.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().insert(uri, contentValues);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
            public Map query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr2);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().query(uri, strArr, str, strArr2, str2);
                    }
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.sdk.component.log.impl.IListenerEventManager
            public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contentValues != null) {
                        obtain.writeInt(1);
                        contentValues.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().update(uri, contentValues, str, strArr);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IListenerEventManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IListenerEventManager)) {
                return (IListenerEventManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IListenerEventManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IListenerEventManager iListenerEventManager) {
            if (Proxy.sDefaultImpl != null || iListenerEventManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iListenerEventManager;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                Map query = query(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.createStringArray(), parcel.readString(), parcel.createStringArray(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeMap(query);
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String type = getType(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(type);
                return true;
            } else if (i4 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                String insert = insert(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ContentValues) ContentValues.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(insert);
                return true;
            } else if (i4 == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                int delete = delete(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                parcel2.writeInt(delete);
                return true;
            } else if (i4 != 5) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                int update = update(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ContentValues) ContentValues.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                parcel2.writeInt(update);
                return true;
            }
        }
    }

    int delete(Uri uri, String str, String[] strArr) throws RemoteException;

    String getType(Uri uri) throws RemoteException;

    String insert(Uri uri, ContentValues contentValues) throws RemoteException;

    Map query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException;

    int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException;
}
