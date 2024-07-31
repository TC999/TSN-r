package com.p521ss.android.socialbase.downloader.p548a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p548a.InterfaceC12381a;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.a.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12384bl extends IInterface {
    /* renamed from: a */
    DownloadInfo mo17975a(int i) throws RemoteException;

    /* renamed from: a */
    DownloadInfo mo17974a(int i, long j) throws RemoteException;

    /* renamed from: a */
    List<DownloadInfo> mo17976a() throws RemoteException;

    /* renamed from: a */
    List<DownloadInfo> mo17968a(String str) throws RemoteException;

    /* renamed from: a */
    void mo17973a(int i, List<C12598a> list) throws RemoteException;

    /* renamed from: a */
    void mo17971a(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: a */
    void mo17969a(C12598a c12598a) throws RemoteException;

    /* renamed from: bl */
    DownloadInfo mo17965bl(int i, long j) throws RemoteException;

    /* renamed from: bl */
    List<C12598a> mo17966bl(int i) throws RemoteException;

    /* renamed from: bl */
    List<DownloadInfo> mo17962bl(String str) throws RemoteException;

    /* renamed from: bl */
    void mo17967bl() throws RemoteException;

    /* renamed from: h */
    DownloadInfo mo17960h(int i) throws RemoteException;

    /* renamed from: k */
    DownloadInfo mo17958k(int i) throws RemoteException;

    /* renamed from: kf */
    boolean mo17957kf(int i) throws RemoteException;

    /* renamed from: n */
    DownloadInfo mo17954n(int i, long j) throws RemoteException;

    /* renamed from: n */
    boolean mo17956n() throws RemoteException;

    /* renamed from: n */
    boolean mo17955n(int i) throws RemoteException;

    /* renamed from: ok */
    DownloadInfo mo17951ok(int i, int i2) throws RemoteException;

    /* renamed from: ok */
    DownloadInfo mo17944ok(int i, long j) throws RemoteException;

    /* renamed from: ok */
    DownloadInfo mo17943ok(int i, long j, String str, String str2) throws RemoteException;

    /* renamed from: ok */
    List<DownloadInfo> mo17921ok(String str) throws RemoteException;

    /* renamed from: ok */
    void mo17953ok() throws RemoteException;

    /* renamed from: ok */
    void mo17950ok(int i, int i2, int i3, int i4) throws RemoteException;

    /* renamed from: ok */
    void mo17948ok(int i, int i2, int i3, long j) throws RemoteException;

    /* renamed from: ok */
    void mo17946ok(int i, int i2, long j) throws RemoteException;

    /* renamed from: ok */
    void mo17940ok(int i, List<C12598a> list) throws RemoteException;

    /* renamed from: ok */
    void mo17938ok(InterfaceC12381a interfaceC12381a) throws RemoteException;

    /* renamed from: ok */
    void mo17923ok(C12598a c12598a) throws RemoteException;

    /* renamed from: ok */
    boolean mo17952ok(int i) throws RemoteException;

    /* renamed from: ok */
    boolean mo17925ok(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: p */
    DownloadInfo mo17917p(int i) throws RemoteException;

    /* renamed from: q */
    DownloadInfo mo17915q(int i) throws RemoteException;

    /* renamed from: s */
    DownloadInfo mo17910s(int i, long j) throws RemoteException;

    /* renamed from: s */
    List<DownloadInfo> mo17907s(String str) throws RemoteException;

    /* renamed from: s */
    void mo17911s(int i) throws RemoteException;

    /* renamed from: s */
    boolean mo17912s() throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.a.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12385ok extends Binder implements InterfaceC12384bl {
        public AbstractBinderC12385ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        /* renamed from: kf */
        public static InterfaceC12384bl m17998kf() {
            return C12386ok.f34892ok;
        }

        /* renamed from: ok */
        public static InterfaceC12384bl m17997ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12384bl)) {
                return (InterfaceC12384bl) queryLocalInterface;
            }
            return new C12386ok(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17953ok();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean mo17952ok = mo17952ok(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17952ok ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17975a = mo17975a(parcel.readInt());
                        parcel2.writeNoException();
                        if (mo17975a != null) {
                            parcel2.writeInt(1);
                            mo17975a.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> mo17921ok = mo17921ok(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17921ok);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> mo17968a = mo17968a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17968a);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> mo17962bl = mo17962bl(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17962bl);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> mo17907s = mo17907s(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17907s);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> mo17976a = mo17976a();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17976a);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<C12598a> mo17966bl = mo17966bl(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17966bl);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17911s(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17923ok(parcel.readInt() != 0 ? C12598a.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17969a(parcel.readInt() != 0 ? C12598a.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17946ok(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17948ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17950ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17951ok = mo17951ok(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        if (mo17951ok != null) {
                            parcel2.writeInt(1);
                            mo17951ok.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean mo17925ok = mo17925ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17925ok ? 1 : 0);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean mo17955n = mo17955n(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17955n ? 1 : 0);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean mo17957kf = mo17957kf(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17957kf ? 1 : 0);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17967bl();
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17960h = mo17960h(parcel.readInt());
                        parcel2.writeNoException();
                        if (mo17960h != null) {
                            parcel2.writeInt(1);
                            mo17960h.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 22:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17943ok = mo17943ok(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (mo17943ok != null) {
                            parcel2.writeInt(1);
                            mo17943ok.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 23:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17944ok = mo17944ok(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (mo17944ok != null) {
                            parcel2.writeInt(1);
                            mo17944ok.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 24:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17974a = mo17974a(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (mo17974a != null) {
                            parcel2.writeInt(1);
                            mo17974a.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 25:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17917p = mo17917p(parcel.readInt());
                        parcel2.writeNoException();
                        if (mo17917p != null) {
                            parcel2.writeInt(1);
                            mo17917p.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 26:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17965bl = mo17965bl(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (mo17965bl != null) {
                            parcel2.writeInt(1);
                            mo17965bl.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 27:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17910s = mo17910s(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (mo17910s != null) {
                            parcel2.writeInt(1);
                            mo17910s.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 28:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17954n = mo17954n(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (mo17954n != null) {
                            parcel2.writeInt(1);
                            mo17954n.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 29:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17915q = mo17915q(parcel.readInt());
                        parcel2.writeNoException();
                        if (mo17915q != null) {
                            parcel2.writeInt(1);
                            mo17915q.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 30:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo mo17958k = mo17958k(parcel.readInt());
                        parcel2.writeNoException();
                        if (mo17958k != null) {
                            parcel2.writeInt(1);
                            mo17958k.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 31:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean mo17912s = mo17912s();
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17912s ? 1 : 0);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean mo17956n = mo17956n();
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17956n ? 1 : 0);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17971a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17940ok(parcel.readInt(), parcel.createTypedArrayList(C12598a.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17973a(parcel.readInt(), parcel.createTypedArrayList(C12598a.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        mo17938ok(InterfaceC12381a.AbstractBinderC12382ok.m17999ok(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.a.bl$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12386ok implements InterfaceC12384bl {

            /* renamed from: ok */
            public static InterfaceC12384bl f34892ok;

            /* renamed from: a */
            private IBinder f34893a;

            C12386ok(IBinder iBinder) {
                this.f34893a = iBinder;
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: a */
            public DownloadInfo mo17975a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(3, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17975a(i);
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
                return this.f34893a;
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: bl */
            public List<DownloadInfo> mo17962bl(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f34893a.transact(6, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17962bl(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: h */
            public DownloadInfo mo17960h(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(21, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17960h(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: k */
            public DownloadInfo mo17958k(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(30, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17958k(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: kf */
            public boolean mo17957kf(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(19, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17957kf(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: n */
            public boolean mo17955n(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(18, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17955n(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public void mo17953ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f34893a.transact(1, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17953ok();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: p */
            public DownloadInfo mo17917p(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(25, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17917p(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: q */
            public DownloadInfo mo17915q(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(29, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17915q(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: s */
            public List<DownloadInfo> mo17907s(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f34893a.transact(7, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17907s(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public boolean mo17952ok(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(2, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17952ok(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: bl */
            public List<C12598a> mo17966bl(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(9, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17966bl(i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(C12598a.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: n */
            public DownloadInfo mo17954n(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.f34893a.transact(28, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17954n(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: s */
            public void mo17911s(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    if (!this.f34893a.transact(10, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17911s(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: a */
            public List<DownloadInfo> mo17968a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f34893a.transact(5, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17968a(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public List<DownloadInfo> mo17921ok(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f34893a.transact(4, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17921ok(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: s */
            public DownloadInfo mo17910s(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.f34893a.transact(27, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17910s(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: bl */
            public void mo17967bl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f34893a.transact(20, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17967bl();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: a */
            public List<DownloadInfo> mo17976a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f34893a.transact(8, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17976a();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: n */
            public boolean mo17956n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f34893a.transact(32, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17956n();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: bl */
            public DownloadInfo mo17965bl(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.f34893a.transact(26, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17965bl(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public void mo17923ok(C12598a c12598a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (c12598a != null) {
                        obtain.writeInt(1);
                        c12598a.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f34893a.transact(11, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17923ok(c12598a);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: a */
            public void mo17969a(C12598a c12598a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (c12598a != null) {
                        obtain.writeInt(1);
                        c12598a.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f34893a.transact(12, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17969a(c12598a);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: s */
            public boolean mo17912s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f34893a.transact(31, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17912s();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public void mo17946ok(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    if (!this.f34893a.transact(13, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17946ok(i, i2, j);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: a */
            public DownloadInfo mo17974a(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.f34893a.transact(24, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17974a(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public void mo17948ok(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    if (!this.f34893a.transact(14, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17948ok(i, i2, i3, j);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: a */
            public void mo17971a(DownloadInfo downloadInfo) throws RemoteException {
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
                    if (!this.f34893a.transact(33, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17971a(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public void mo17950ok(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (!this.f34893a.transact(15, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17950ok(i, i2, i3, i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: a */
            public void mo17973a(int i, List<C12598a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (!this.f34893a.transact(35, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17973a(i, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public DownloadInfo mo17951ok(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.f34893a.transact(16, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17951ok(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public boolean mo17925ok(DownloadInfo downloadInfo) throws RemoteException {
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
                    if (!this.f34893a.transact(17, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17925ok(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public DownloadInfo mo17943ok(int i, long j, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f34893a.transact(22, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17943ok(i, j, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public DownloadInfo mo17944ok(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.f34893a.transact(23, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        return AbstractBinderC12385ok.m17998kf().mo17944ok(i, j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public void mo17940ok(int i, List<C12598a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (!this.f34893a.transact(34, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17940ok(i, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl
            /* renamed from: ok */
            public void mo17938ok(InterfaceC12381a interfaceC12381a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeStrongBinder(interfaceC12381a != null ? interfaceC12381a.asBinder() : null);
                    if (!this.f34893a.transact(36, obtain, obtain2, 0) && AbstractBinderC12385ok.m17998kf() != null) {
                        AbstractBinderC12385ok.m17998kf().mo17938ok(interfaceC12381a);
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
