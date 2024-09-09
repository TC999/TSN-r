package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface bl extends IInterface {
    DownloadInfo a(int i4) throws RemoteException;

    DownloadInfo a(int i4, long j4) throws RemoteException;

    List<DownloadInfo> a() throws RemoteException;

    List<DownloadInfo> a(String str) throws RemoteException;

    void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException;

    void a(DownloadInfo downloadInfo) throws RemoteException;

    void a(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException;

    DownloadInfo bl(int i4, long j4) throws RemoteException;

    List<com.ss.android.socialbase.downloader.model.a> bl(int i4) throws RemoteException;

    List<DownloadInfo> bl(String str) throws RemoteException;

    void bl() throws RemoteException;

    DownloadInfo h(int i4) throws RemoteException;

    DownloadInfo k(int i4) throws RemoteException;

    boolean kf(int i4) throws RemoteException;

    DownloadInfo n(int i4, long j4) throws RemoteException;

    boolean n() throws RemoteException;

    boolean n(int i4) throws RemoteException;

    DownloadInfo ok(int i4, int i5) throws RemoteException;

    DownloadInfo ok(int i4, long j4) throws RemoteException;

    DownloadInfo ok(int i4, long j4, String str, String str2) throws RemoteException;

    List<DownloadInfo> ok(String str) throws RemoteException;

    void ok() throws RemoteException;

    void ok(int i4, int i5, int i6, int i7) throws RemoteException;

    void ok(int i4, int i5, int i6, long j4) throws RemoteException;

    void ok(int i4, int i5, long j4) throws RemoteException;

    void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException;

    void ok(a aVar) throws RemoteException;

    void ok(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException;

    boolean ok(int i4) throws RemoteException;

    boolean ok(DownloadInfo downloadInfo) throws RemoteException;

    DownloadInfo p(int i4) throws RemoteException;

    DownloadInfo q(int i4) throws RemoteException;

    DownloadInfo s(int i4, long j4) throws RemoteException;

    List<DownloadInfo> s(String str) throws RemoteException;

    void s(int i4) throws RemoteException;

    boolean s() throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class ok extends Binder implements bl {
        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static bl kf() {
            return C0972ok.ok;
        }

        public static bl ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (queryLocalInterface != null && (queryLocalInterface instanceof bl)) {
                return (bl) queryLocalInterface;
            }
            return new C0972ok(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        ok();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean ok = ok(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(ok ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo a4 = a(parcel.readInt());
                        parcel2.writeNoException();
                        if (a4 != null) {
                            parcel2.writeInt(1);
                            a4.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> ok2 = ok(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(ok2);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> a5 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(a5);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> bl = bl(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(bl);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> s3 = s(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(s3);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> a6 = a();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(a6);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<com.ss.android.socialbase.downloader.model.a> bl2 = bl(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(bl2);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        s(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        ok(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.a.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        a(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.a.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        ok(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo ok3 = ok(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        if (ok3 != null) {
                            parcel2.writeInt(1);
                            ok3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean ok4 = ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(ok4 ? 1 : 0);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean n4 = n(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(n4 ? 1 : 0);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean kf = kf(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(kf ? 1 : 0);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        bl();
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo h4 = h(parcel.readInt());
                        parcel2.writeNoException();
                        if (h4 != null) {
                            parcel2.writeInt(1);
                            h4.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 22:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo ok5 = ok(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (ok5 != null) {
                            parcel2.writeInt(1);
                            ok5.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 23:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo ok6 = ok(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (ok6 != null) {
                            parcel2.writeInt(1);
                            ok6.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 24:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo a7 = a(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (a7 != null) {
                            parcel2.writeInt(1);
                            a7.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 25:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo p3 = p(parcel.readInt());
                        parcel2.writeNoException();
                        if (p3 != null) {
                            parcel2.writeInt(1);
                            p3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 26:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo bl3 = bl(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (bl3 != null) {
                            parcel2.writeInt(1);
                            bl3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 27:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo s4 = s(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (s4 != null) {
                            parcel2.writeInt(1);
                            s4.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 28:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo n5 = n(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (n5 != null) {
                            parcel2.writeInt(1);
                            n5.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 29:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo q3 = q(parcel.readInt());
                        parcel2.writeNoException();
                        if (q3 != null) {
                            parcel2.writeInt(1);
                            q3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 30:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo k4 = k(parcel.readInt());
                        parcel2.writeNoException();
                        if (k4 != null) {
                            parcel2.writeInt(1);
                            k4.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 31:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean s5 = s();
                        parcel2.writeNoException();
                        parcel2.writeInt(s5 ? 1 : 0);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean n6 = n();
                        parcel2.writeNoException();
                        parcel2.writeInt(n6 ? 1 : 0);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        ok(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        a(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        ok(a.ok.ok(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.a.bl$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class C0972ok implements bl {
            public static bl ok;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49265a;

            C0972ok(IBinder iBinder) {
                this.f49265a = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo a(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(3, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().a(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49265a;
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> bl(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f49265a.transact(6, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().bl(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo h(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(21, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().h(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo k(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(30, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().k(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean kf(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(19, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().kf(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean n(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(18, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().n(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f49265a.transact(1, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().ok();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo p(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(25, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().p(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo q(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(29, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().q(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> s(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f49265a.transact(7, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().s(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean ok(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(2, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<com.ss.android.socialbase.downloader.model.a> bl(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(9, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().bl(i4);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo n(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f49265a.transact(28, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().n(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void s(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f49265a.transact(10, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().s(i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f49265a.transact(5, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().a(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> ok(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f49265a.transact(4, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo s(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f49265a.transact(27, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().s(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void bl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f49265a.transact(20, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().bl();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f49265a.transact(8, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().a();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f49265a.transact(32, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().n();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo bl(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f49265a.transact(26, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().bl(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f49265a.transact(11, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void a(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f49265a.transact(12, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().a(aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f49265a.transact(31, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().s();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(int i4, int i5, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeLong(j4);
                    if (!this.f49265a.transact(13, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(i4, i5, j4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo a(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f49265a.transact(24, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().a(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(int i4, int i5, int i6, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeLong(j4);
                    if (!this.f49265a.transact(14, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(i4, i5, i6, j4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void a(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f49265a.transact(33, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().a(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(int i4, int i5, int i6, int i7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (!this.f49265a.transact(15, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(i4, i5, i6, i7);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeTypedList(list);
                    if (!this.f49265a.transact(35, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().a(i4, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo ok(int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.f49265a.transact(16, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(i4, i5);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean ok(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f49265a.transact(17, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo ok(int i4, long j4, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f49265a.transact(22, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(i4, j4, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo ok(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f49265a.transact(23, obtain, obtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeTypedList(list);
                    if (!this.f49265a.transact(34, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(i4, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (!this.f49265a.transact(36, obtain, obtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(aVar);
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
