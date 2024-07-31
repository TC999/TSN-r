package com.p521ss.android.downloadlib.p537ok.p538ok;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12315bl;
import com.umeng.analytics.pro.UMCommonContent;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.ok.ok.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12254s extends IInterface {

    /* renamed from: com.ss.android.downloadlib.ok.ok.s$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12255ok extends Binder implements InterfaceC12254s {

        /* renamed from: ok */
        private static String f34564ok = "";

        /* renamed from: com.ss.android.downloadlib.ok.ok.s$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        private static class C12256ok implements InterfaceC12254s {

            /* renamed from: ok */
            private IBinder f34565ok;

            C12256ok(IBinder iBinder) {
                if (TextUtils.isEmpty(AbstractBinderC12255ok.f34564ok)) {
                    JSONObject m18946q = C12128r.m18946q();
                    String unused = AbstractBinderC12255ok.f34564ok = C12315bl.m18260ok(m18946q.optString(UMCommonContent.f37782aL), m18946q.optString("s"));
                }
                this.f34565ok = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f34565ok;
            }

            @Override // com.p521ss.android.downloadlib.p537ok.p538ok.InterfaceC12254s
            /* renamed from: ok */
            public void mo18582ok(C12246a c12246a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC12255ok.f34564ok);
                    if (c12246a != null) {
                        obtain.writeInt(1);
                        c12246a.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f34565ok.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(f34564ok);
                mo18582ok(parcel.readInt() != 0 ? C12246a.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(f34564ok);
                return true;
            }
        }

        /* renamed from: ok */
        public static InterfaceC12254s m18584ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f34564ok);
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12254s)) {
                return (InterfaceC12254s) queryLocalInterface;
            }
            return new C12256ok(iBinder);
        }
    }

    /* renamed from: ok */
    void mo18582ok(C12246a c12246a) throws RemoteException;
}
