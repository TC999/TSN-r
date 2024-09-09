package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.em;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.ok;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface q extends IInterface {
    DownloadInfo a(String str, String str2) throws RemoteException;

    List<DownloadInfo> a() throws RemoteException;

    List<DownloadInfo> a(String str) throws RemoteException;

    void a(int i4, int i5, com.ss.android.socialbase.downloader.depend.q qVar, int i6, boolean z3) throws RemoteException;

    void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException;

    void a(int i4, boolean z3) throws RemoteException;

    void a(List<String> list) throws RemoteException;

    boolean a(int i4) throws RemoteException;

    boolean a(DownloadInfo downloadInfo) throws RemoteException;

    List<DownloadInfo> bl(String str) throws RemoteException;

    void bl(int i4) throws RemoteException;

    void bl(int i4, boolean z3) throws RemoteException;

    boolean bl() throws RemoteException;

    boolean h(int i4) throws RemoteException;

    boolean i(int i4) throws RemoteException;

    void j(int i4) throws RemoteException;

    void k(int i4) throws RemoteException;

    int kf(int i4) throws RemoteException;

    boolean kf() throws RemoteException;

    long n(int i4) throws RemoteException;

    List<DownloadInfo> n(String str) throws RemoteException;

    void n() throws RemoteException;

    int ok(String str, String str2) throws RemoteException;

    List<DownloadInfo> ok(String str) throws RemoteException;

    void ok() throws RemoteException;

    void ok(int i4) throws RemoteException;

    void ok(int i4, int i5) throws RemoteException;

    void ok(int i4, int i5, int i6, int i7) throws RemoteException;

    void ok(int i4, int i5, int i6, long j4) throws RemoteException;

    void ok(int i4, int i5, long j4) throws RemoteException;

    void ok(int i4, int i5, com.ss.android.socialbase.downloader.depend.q qVar, int i6, boolean z3) throws RemoteException;

    void ok(int i4, int i5, com.ss.android.socialbase.downloader.depend.q qVar, int i6, boolean z3, boolean z4) throws RemoteException;

    void ok(int i4, long j4) throws RemoteException;

    void ok(int i4, Notification notification) throws RemoteException;

    void ok(int i4, m mVar) throws RemoteException;

    void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException;

    void ok(int i4, boolean z3) throws RemoteException;

    void ok(em emVar) throws RemoteException;

    void ok(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException;

    void ok(com.ss.android.socialbase.downloader.model.ok okVar) throws RemoteException;

    void ok(List<String> list) throws RemoteException;

    void ok(boolean z3) throws RemoteException;

    boolean ok(DownloadInfo downloadInfo) throws RemoteException;

    DownloadInfo p(int i4) throws RemoteException;

    List<com.ss.android.socialbase.downloader.model.a> q(int i4) throws RemoteException;

    boolean r(int i4) throws RemoteException;

    boolean rh(int i4) throws RemoteException;

    List<DownloadInfo> s(String str) throws RemoteException;

    void s(int i4) throws RemoteException;

    void s(int i4, boolean z3) throws RemoteException;

    boolean s() throws RemoteException;

    void t(int i4) throws RemoteException;

    g td(int i4) throws RemoteException;

    m x(int i4) throws RemoteException;

    int z(int i4) throws RemoteException;

    com.ss.android.socialbase.downloader.depend.h zz(int i4) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class ok extends Binder implements q {
        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static q h() {
            return C1007ok.ok;
        }

        public static q ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof q)) {
                return (q) queryLocalInterface;
            }
            return new C1007ok(iBinder);
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
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(ok.AbstractBinderC1015ok.ok(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean a4 = a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(a4 ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        bl(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        s(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        long n4 = n(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(n4);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int kf = kf(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(kf);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean h4 = h(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(h4 ? 1 : 0);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        DownloadInfo p3 = p(parcel.readInt());
                        parcel2.writeNoException();
                        if (p3 != null) {
                            parcel2.writeInt(1);
                            p3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> ok = ok(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(ok);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<com.ss.android.socialbase.downloader.model.a> q3 = q(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(q3);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int ok2 = ok(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(ok2);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        DownloadInfo a5 = a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (a5 != null) {
                            parcel2.writeInt(1);
                            a5.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> a6 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(a6);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> bl = bl(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(bl);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> s3 = s(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(s3);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> a7 = a();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(a7);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        bl(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        k(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.readInt(), q.ok.ok(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.readInt(), q.ok.ok(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.readInt(), q.ok.ok(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean ok3 = ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(ok3 ? 1 : 0);
                        return true;
                    case 29:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt() != 0);
                        return true;
                    case 31:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean bl2 = bl();
                        parcel2.writeNoException();
                        parcel2.writeInt(bl2 ? 1 : 0);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> n5 = n(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(n5);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean r3 = r(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(r3 ? 1 : 0);
                        return true;
                    case 34:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        j(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean s4 = s();
                        parcel2.writeNoException();
                        parcel2.writeInt(s4 ? 1 : 0);
                        return true;
                    case 36:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        s(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int z3 = z(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(z3);
                        return true;
                    case 38:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.a.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean a8 = a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(a8 ? 1 : 0);
                        return true;
                    case 40:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean rh = rh(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(rh ? 1 : 0);
                        return true;
                    case 41:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        t(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 42:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 43:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 45:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean i6 = i(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(i6 ? 1 : 0);
                        return true;
                    case 46:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        n();
                        parcel2.writeNoException();
                        return true;
                    case 47:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 48:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        a(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 49:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(em.ok.ok(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 50:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 51:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        m x3 = x(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(x3 != null ? x3.asBinder() : null);
                        return true;
                    case 52:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        g td = td(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(td != null ? td.asBinder() : null);
                        return true;
                    case 53:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), m.ok.ok(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 54:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        com.ss.android.socialbase.downloader.depend.h zz = zz(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(zz != null ? zz.asBinder() : null);
                        return true;
                    case 55:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean kf2 = kf();
                        parcel2.writeNoException();
                        parcel2.writeInt(kf2 ? 1 : 0);
                        return true;
                    case 56:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        ok(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.downloader.q$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class C1007ok implements q {
            public static q ok;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49490a;

            C1007ok(IBinder iBinder) {
                this.f49490a = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean a(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(4, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().a(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49490a;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void bl(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(5, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().bl(i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean h(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(10, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().h(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean i(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(45, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().i(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void j(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(34, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().j(i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void k(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(24, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().k(i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public int kf(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(9, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().kf(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public long n(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(8, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().n(i4);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(com.ss.android.socialbase.downloader.model.ok okVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(okVar != null ? okVar.asBinder() : null);
                    if (!this.f49490a.transact(1, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(okVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public DownloadInfo p(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(11, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().p(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<com.ss.android.socialbase.downloader.model.a> q(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(13, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().q(i4);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean r(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(33, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().r(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean rh(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(40, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().rh(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void s(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(6, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().s(i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void t(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(41, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().t(i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public g td(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(52, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().td(i4);
                    }
                    obtain2.readException();
                    return g.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public m x(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(51, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().x(i4);
                    }
                    obtain2.readException();
                    return m.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public int z(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(37, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().z(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public com.ss.android.socialbase.downloader.depend.h zz(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(54, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().zz(i4);
                    }
                    obtain2.readException();
                    return h.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> bl(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f49490a.transact(17, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().bl(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (!this.f49490a.transact(2, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> s(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f49490a.transact(18, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().s(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public DownloadInfo a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f49490a.transact(15, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean kf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f49490a.transact(55, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().kf();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> n(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f49490a.transact(32, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().n(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!this.f49490a.transact(3, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, z3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void bl(int i4, boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!this.f49490a.transact(23, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().bl(i4, z3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f49490a.transact(35, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().s();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f49490a.transact(46, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().n();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f49490a.transact(16, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().a(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f49490a.transact(7, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void s(int i4, boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!this.f49490a.transact(36, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().s(i4, z3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean bl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f49490a.transact(31, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().bl();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f49490a.transact(19, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().a();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> ok(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f49490a.transact(12, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().ok(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void a(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    if (!this.f49490a.transact(21, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().a(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public int ok(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f49490a.transact(14, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().ok(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void a(int i4, boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!this.f49490a.transact(22, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().a(i4, z3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    if (!this.f49490a.transact(20, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void a(int i4, int i5, com.ss.android.socialbase.downloader.depend.q qVar, int i6, boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    obtain.writeInt(i6);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!this.f49490a.transact(26, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().a(i4, i5, qVar, i6, z3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, int i5, com.ss.android.socialbase.downloader.depend.q qVar, int i6, boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    obtain.writeInt(i6);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!this.f49490a.transact(25, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, i5, qVar, i6, z3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f49490a.transact(39, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().a(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, int i5, com.ss.android.socialbase.downloader.depend.q qVar, int i6, boolean z3, boolean z4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    obtain.writeInt(i6);
                    int i7 = 1;
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!z4) {
                        i7 = 0;
                    }
                    obtain.writeInt(i7);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.f49490a.transact(27, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, i5, qVar, i6, z3, z4);
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeTypedList(list);
                    if (!this.f49490a.transact(48, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().a(i4, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean ok(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f49490a.transact(28, obtain, obtain2, 0) && ok.h() != null) {
                        return ok.h().ok(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f49490a.transact(29, obtain, null, 1) || ok.h() == null) {
                        return;
                    }
                    ok.h().ok(i4, notification);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(z3 ? 1 : 0);
                    if (this.f49490a.transact(30, obtain, null, 1) || ok.h() == null) {
                        return;
                    }
                    ok.h().ok(z3);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f49490a.transact(38, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, int i5, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeLong(j4);
                    if (!this.f49490a.transact(42, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, i5, j4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, int i5, int i6, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeLong(j4);
                    if (!this.f49490a.transact(43, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, i5, i6, j4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, int i5, int i6, int i7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (!this.f49490a.transact(44, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, i5, i6, i7);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeTypedList(list);
                    if (!this.f49490a.transact(47, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(em emVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(emVar != null ? emVar.asBinder() : null);
                    if (!this.f49490a.transact(49, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(emVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.f49490a.transact(50, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, i5);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, m mVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    if (!this.f49490a.transact(53, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, mVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f49490a.transact(56, obtain, obtain2, 0) && ok.h() != null) {
                        ok.h().ok(i4, j4);
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
