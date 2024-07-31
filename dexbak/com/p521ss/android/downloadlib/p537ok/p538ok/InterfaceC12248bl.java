package com.p521ss.android.downloadlib.p537ok.p538ok;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p537ok.p538ok.InterfaceC12254s;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12315bl;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.ok.ok.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12248bl extends IInterface {

    /* renamed from: com.ss.android.downloadlib.ok.ok.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12249ok extends Binder implements InterfaceC12248bl {

        /* renamed from: ok */
        private static String f34547ok = "";

        /* renamed from: com.ss.android.downloadlib.ok.ok.bl$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        private static class C12250ok implements InterfaceC12248bl {

            /* renamed from: ok */
            private IBinder f34548ok;

            C12250ok(IBinder iBinder) {
                if (TextUtils.isEmpty(AbstractBinderC12249ok.f34547ok)) {
                    JSONObject m18946q = C12128r.m18946q();
                    String unused = AbstractBinderC12249ok.f34547ok = C12315bl.m18260ok(m18946q.optString("r"), m18946q.optString("s"));
                }
                this.f34548ok = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f34548ok;
            }

            @Override // com.p521ss.android.downloadlib.p537ok.p538ok.InterfaceC12248bl
            /* renamed from: ok */
            public void mo18596ok(C12246a c12246a, InterfaceC12254s interfaceC12254s) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC12249ok.f34547ok);
                    if (c12246a != null) {
                        obtain.writeInt(1);
                        c12246a.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(interfaceC12254s != null ? interfaceC12254s.asBinder() : null);
                    this.f34548ok.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(f34547ok);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(f34547ok);
            mo18596ok(parcel.readInt() != 0 ? C12246a.CREATOR.createFromParcel(parcel) : null, InterfaceC12254s.AbstractBinderC12255ok.m18584ok(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: ok */
        public static InterfaceC12248bl m18598ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f34547ok);
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12248bl)) {
                return (InterfaceC12248bl) queryLocalInterface;
            }
            return new C12250ok(iBinder);
        }
    }

    /* renamed from: ok */
    void mo18596ok(C12246a c12246a, InterfaceC12254s interfaceC12254s) throws RemoteException;
}
