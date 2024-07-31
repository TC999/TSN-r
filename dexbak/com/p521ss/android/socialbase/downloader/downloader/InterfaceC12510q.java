package com.p521ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12424em;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12432g;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12435h;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12454m;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12510q extends IInterface {
    /* renamed from: a */
    DownloadInfo mo17367a(String str, String str2) throws RemoteException;

    /* renamed from: a */
    List<DownloadInfo> mo17374a() throws RemoteException;

    /* renamed from: a */
    List<DownloadInfo> mo17368a(String str) throws RemoteException;

    /* renamed from: a */
    void mo17372a(int i, int i2, InterfaceC12465q interfaceC12465q, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo17371a(int i, List<C12598a> list) throws RemoteException;

    /* renamed from: a */
    void mo17370a(int i, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo17366a(List<String> list) throws RemoteException;

    /* renamed from: a */
    boolean mo17373a(int i) throws RemoteException;

    /* renamed from: a */
    boolean mo17369a(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: bl */
    List<DownloadInfo> mo17362bl(String str) throws RemoteException;

    /* renamed from: bl */
    void mo17364bl(int i) throws RemoteException;

    /* renamed from: bl */
    void mo17363bl(int i, boolean z) throws RemoteException;

    /* renamed from: bl */
    boolean mo17365bl() throws RemoteException;

    /* renamed from: h */
    boolean mo17361h(int i) throws RemoteException;

    /* renamed from: i */
    boolean mo17360i(int i) throws RemoteException;

    /* renamed from: j */
    void mo17359j(int i) throws RemoteException;

    /* renamed from: k */
    void mo17358k(int i) throws RemoteException;

    /* renamed from: kf */
    int mo17356kf(int i) throws RemoteException;

    /* renamed from: kf */
    boolean mo17357kf() throws RemoteException;

    /* renamed from: n */
    long mo17354n(int i) throws RemoteException;

    /* renamed from: n */
    List<DownloadInfo> mo17353n(String str) throws RemoteException;

    /* renamed from: n */
    void mo17355n() throws RemoteException;

    /* renamed from: ok */
    int mo17334ok(String str, String str2) throws RemoteException;

    /* renamed from: ok */
    List<DownloadInfo> mo17335ok(String str) throws RemoteException;

    /* renamed from: ok */
    void mo17352ok() throws RemoteException;

    /* renamed from: ok */
    void mo17351ok(int i) throws RemoteException;

    /* renamed from: ok */
    void mo17350ok(int i, int i2) throws RemoteException;

    /* renamed from: ok */
    void mo17349ok(int i, int i2, int i3, int i4) throws RemoteException;

    /* renamed from: ok */
    void mo17348ok(int i, int i2, int i3, long j) throws RemoteException;

    /* renamed from: ok */
    void mo17347ok(int i, int i2, long j) throws RemoteException;

    /* renamed from: ok */
    void mo17346ok(int i, int i2, InterfaceC12465q interfaceC12465q, int i3, boolean z) throws RemoteException;

    /* renamed from: ok */
    void mo17345ok(int i, int i2, InterfaceC12465q interfaceC12465q, int i3, boolean z, boolean z2) throws RemoteException;

    /* renamed from: ok */
    void mo17344ok(int i, long j) throws RemoteException;

    /* renamed from: ok */
    void mo17343ok(int i, Notification notification) throws RemoteException;

    /* renamed from: ok */
    void mo17342ok(int i, InterfaceC12454m interfaceC12454m) throws RemoteException;

    /* renamed from: ok */
    void mo17341ok(int i, List<C12598a> list) throws RemoteException;

    /* renamed from: ok */
    void mo17340ok(int i, boolean z) throws RemoteException;

    /* renamed from: ok */
    void mo17339ok(InterfaceC12424em interfaceC12424em) throws RemoteException;

    /* renamed from: ok */
    void mo17337ok(C12598a c12598a) throws RemoteException;

    /* renamed from: ok */
    void mo17336ok(InterfaceC12604ok interfaceC12604ok) throws RemoteException;

    /* renamed from: ok */
    void mo17333ok(List<String> list) throws RemoteException;

    /* renamed from: ok */
    void mo17332ok(boolean z) throws RemoteException;

    /* renamed from: ok */
    boolean mo17338ok(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: p */
    DownloadInfo mo17331p(int i) throws RemoteException;

    /* renamed from: q */
    List<C12598a> mo17330q(int i) throws RemoteException;

    /* renamed from: r */
    boolean mo17329r(int i) throws RemoteException;

    /* renamed from: rh */
    boolean mo17328rh(int i) throws RemoteException;

    /* renamed from: s */
    List<DownloadInfo> mo17324s(String str) throws RemoteException;

    /* renamed from: s */
    void mo17326s(int i) throws RemoteException;

    /* renamed from: s */
    void mo17325s(int i, boolean z) throws RemoteException;

    /* renamed from: s */
    boolean mo17327s() throws RemoteException;

    /* renamed from: t */
    void mo17323t(int i) throws RemoteException;

    /* renamed from: td */
    InterfaceC12432g mo17322td(int i) throws RemoteException;

    /* renamed from: x */
    InterfaceC12454m mo17321x(int i) throws RemoteException;

    /* renamed from: z */
    int mo17320z(int i) throws RemoteException;

    /* renamed from: zz */
    InterfaceC12435h mo17319zz(int i) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.q$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12511ok extends Binder implements InterfaceC12510q {
        public AbstractBinderC12511ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        /* renamed from: h */
        public static InterfaceC12510q m17685h() {
            return C12512ok.f35173ok;
        }

        /* renamed from: ok */
        public static InterfaceC12510q m17684ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12510q)) {
                return (InterfaceC12510q) queryLocalInterface;
            }
            return new C12512ok(iBinder);
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
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17336ok(InterfaceC12604ok.AbstractBinderC12605ok.m16990ok(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17351ok(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17340ok(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17373a = mo17373a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17373a ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17364bl(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17326s(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17352ok();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        long mo17354n = mo17354n(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(mo17354n);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int mo17356kf = mo17356kf(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17356kf);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17361h = mo17361h(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17361h ? 1 : 0);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        DownloadInfo mo17331p = mo17331p(parcel.readInt());
                        parcel2.writeNoException();
                        if (mo17331p != null) {
                            parcel2.writeInt(1);
                            mo17331p.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> mo17335ok = mo17335ok(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17335ok);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<C12598a> mo17330q = mo17330q(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17330q);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int mo17334ok = mo17334ok(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17334ok);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        DownloadInfo mo17367a = mo17367a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (mo17367a != null) {
                            parcel2.writeInt(1);
                            mo17367a.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> mo17368a = mo17368a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17368a);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> mo17362bl = mo17362bl(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17362bl);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> mo17324s = mo17324s(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17324s);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> mo17374a = mo17374a();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17374a);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17333ok(parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17366a(parcel.createStringArrayList());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17370a(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17363bl(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17358k(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17346ok(parcel.readInt(), parcel.readInt(), InterfaceC12465q.AbstractBinderC12466ok.m17856ok(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17372a(parcel.readInt(), parcel.readInt(), InterfaceC12465q.AbstractBinderC12466ok.m17856ok(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17345ok(parcel.readInt(), parcel.readInt(), InterfaceC12465q.AbstractBinderC12466ok.m17856ok(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17338ok = mo17338ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17338ok ? 1 : 0);
                        return true;
                    case 29:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17343ok(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17332ok(parcel.readInt() != 0);
                        return true;
                    case 31:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17365bl = mo17365bl();
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17365bl ? 1 : 0);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        List<DownloadInfo> mo17353n = mo17353n(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(mo17353n);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17329r = mo17329r(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17329r ? 1 : 0);
                        return true;
                    case 34:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17359j(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17327s = mo17327s();
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17327s ? 1 : 0);
                        return true;
                    case 36:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17325s(parcel.readInt(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        int mo17320z = mo17320z(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17320z);
                        return true;
                    case 38:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17337ok(parcel.readInt() != 0 ? C12598a.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17369a = mo17369a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17369a ? 1 : 0);
                        return true;
                    case 40:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17328rh = mo17328rh(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17328rh ? 1 : 0);
                        return true;
                    case 41:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17323t(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 42:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17347ok(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 43:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17348ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17349ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 45:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17360i = mo17360i(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17360i ? 1 : 0);
                        return true;
                    case 46:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17355n();
                        parcel2.writeNoException();
                        return true;
                    case 47:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17341ok(parcel.readInt(), parcel.createTypedArrayList(C12598a.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 48:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17371a(parcel.readInt(), parcel.createTypedArrayList(C12598a.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 49:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17339ok(InterfaceC12424em.AbstractBinderC12425ok.m17883ok(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 50:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17350ok(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 51:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        InterfaceC12454m mo17321x = mo17321x(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo17321x != null ? mo17321x.asBinder() : null);
                        return true;
                    case 52:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        InterfaceC12432g mo17322td = mo17322td(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo17322td != null ? mo17322td.asBinder() : null);
                        return true;
                    case 53:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17342ok(parcel.readInt(), InterfaceC12454m.AbstractBinderC12455ok.m17862ok(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 54:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        InterfaceC12435h mo17319zz = mo17319zz(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo17319zz != null ? mo17319zz.asBinder() : null);
                        return true;
                    case 55:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        boolean mo17357kf = mo17357kf();
                        parcel2.writeNoException();
                        parcel2.writeInt(mo17357kf ? 1 : 0);
                        return true;
                    case 56:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                        mo17344ok(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.downloader.q$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12512ok implements InterfaceC12510q {

            /* renamed from: ok */
            public static InterfaceC12510q f35173ok;

            /* renamed from: a */
            private IBinder f35174a;

            C12512ok(IBinder iBinder) {
                this.f35174a = iBinder;
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: a */
            public boolean mo17373a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(4, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17373a(i);
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
                return this.f35174a;
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: bl */
            public void mo17364bl(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(5, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17364bl(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: h */
            public boolean mo17361h(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(10, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17361h(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: i */
            public boolean mo17360i(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(45, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17360i(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: j */
            public void mo17359j(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(34, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17359j(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: k */
            public void mo17358k(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(24, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17358k(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: kf */
            public int mo17356kf(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(9, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17356kf(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: n */
            public long mo17354n(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(8, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17354n(i);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17336ok(InterfaceC12604ok interfaceC12604ok) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(interfaceC12604ok != null ? interfaceC12604ok.asBinder() : null);
                    if (!this.f35174a.transact(1, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17336ok(interfaceC12604ok);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: p */
            public DownloadInfo mo17331p(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(11, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17331p(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: q */
            public List<C12598a> mo17330q(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(13, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17330q(i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(C12598a.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: r */
            public boolean mo17329r(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(33, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17329r(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: rh */
            public boolean mo17328rh(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(40, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17328rh(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: s */
            public void mo17326s(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(6, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17326s(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: t */
            public void mo17323t(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(41, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17323t(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: td */
            public InterfaceC12432g mo17322td(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(52, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17322td(i);
                    }
                    obtain2.readException();
                    return InterfaceC12432g.AbstractBinderC12433ok.m17878ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: x */
            public InterfaceC12454m mo17321x(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(51, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17321x(i);
                    }
                    obtain2.readException();
                    return InterfaceC12454m.AbstractBinderC12455ok.m17862ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: z */
            public int mo17320z(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(37, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17320z(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: zz */
            public InterfaceC12435h mo17319zz(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(54, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17319zz(i);
                    }
                    obtain2.readException();
                    return InterfaceC12435h.AbstractBinderC12436ok.m17876ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: bl */
            public List<DownloadInfo> mo17362bl(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f35174a.transact(17, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17362bl(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17351ok(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (!this.f35174a.transact(2, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17351ok(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: s */
            public List<DownloadInfo> mo17324s(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f35174a.transact(18, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17324s(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: a */
            public DownloadInfo mo17367a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f35174a.transact(15, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17367a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: kf */
            public boolean mo17357kf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f35174a.transact(55, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17357kf();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: n */
            public List<DownloadInfo> mo17353n(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f35174a.transact(32, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17353n(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17340ok(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f35174a.transact(3, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17340ok(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: bl */
            public void mo17363bl(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f35174a.transact(23, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17363bl(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: s */
            public boolean mo17327s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f35174a.transact(35, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17327s();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: n */
            public void mo17355n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f35174a.transact(46, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17355n();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: a */
            public List<DownloadInfo> mo17368a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f35174a.transact(16, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17368a(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17352ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f35174a.transact(7, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17352ok();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: s */
            public void mo17325s(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f35174a.transact(36, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17325s(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: bl */
            public boolean mo17365bl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f35174a.transact(31, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17365bl();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: a */
            public List<DownloadInfo> mo17374a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f35174a.transact(19, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17374a();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public List<DownloadInfo> mo17335ok(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    if (!this.f35174a.transact(12, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17335ok(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: a */
            public void mo17366a(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    if (!this.f35174a.transact(21, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17366a(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public int mo17334ok(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f35174a.transact(14, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17334ok(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: a */
            public void mo17370a(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f35174a.transact(22, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17370a(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17333ok(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    if (!this.f35174a.transact(20, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17333ok(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: a */
            public void mo17372a(int i, int i2, InterfaceC12465q interfaceC12465q, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(interfaceC12465q != null ? interfaceC12465q.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f35174a.transact(26, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17372a(i, i2, interfaceC12465q, i3, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17346ok(int i, int i2, InterfaceC12465q interfaceC12465q, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(interfaceC12465q != null ? interfaceC12465q.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f35174a.transact(25, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17346ok(i, i2, interfaceC12465q, i3, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: a */
            public boolean mo17369a(DownloadInfo downloadInfo) throws RemoteException {
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
                    if (!this.f35174a.transact(39, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17369a(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17345ok(int i, int i2, InterfaceC12465q interfaceC12465q, int i3, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(interfaceC12465q != null ? interfaceC12465q.asBinder() : null);
                    obtain.writeInt(i3);
                    int i4 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.f35174a.transact(27, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17345ok(i, i2, interfaceC12465q, i3, z, z2);
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

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: a */
            public void mo17371a(int i, List<C12598a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (!this.f35174a.transact(48, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17371a(i, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public boolean mo17338ok(DownloadInfo downloadInfo) throws RemoteException {
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
                    if (!this.f35174a.transact(28, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        return AbstractBinderC12511ok.m17685h().mo17338ok(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17343ok(int i, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f35174a.transact(29, obtain, null, 1) || AbstractBinderC12511ok.m17685h() == null) {
                        return;
                    }
                    AbstractBinderC12511ok.m17685h().mo17343ok(i, notification);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17332ok(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(z ? 1 : 0);
                    if (this.f35174a.transact(30, obtain, null, 1) || AbstractBinderC12511ok.m17685h() == null) {
                        return;
                    }
                    AbstractBinderC12511ok.m17685h().mo17332ok(z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17337ok(C12598a c12598a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (c12598a != null) {
                        obtain.writeInt(1);
                        c12598a.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35174a.transact(38, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17337ok(c12598a);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17347ok(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    if (!this.f35174a.transact(42, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17347ok(i, i2, j);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17348ok(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    if (!this.f35174a.transact(43, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17348ok(i, i2, i3, j);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17349ok(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (!this.f35174a.transact(44, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17349ok(i, i2, i3, i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17341ok(int i, List<C12598a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (!this.f35174a.transact(47, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17341ok(i, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17339ok(InterfaceC12424em interfaceC12424em) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(interfaceC12424em != null ? interfaceC12424em.asBinder() : null);
                    if (!this.f35174a.transact(49, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17339ok(interfaceC12424em);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17350ok(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.f35174a.transact(50, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17350ok(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17342ok(int i, InterfaceC12454m interfaceC12454m) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(interfaceC12454m != null ? interfaceC12454m.asBinder() : null);
                    if (!this.f35174a.transact(53, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17342ok(i, interfaceC12454m);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q
            /* renamed from: ok */
            public void mo17344ok(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (!this.f35174a.transact(56, obtain, obtain2, 0) && AbstractBinderC12511ok.m17685h() != null) {
                        AbstractBinderC12511ok.m17685h().mo17344ok(i, j);
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
