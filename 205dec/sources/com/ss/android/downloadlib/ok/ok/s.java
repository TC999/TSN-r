package com.ss.android.downloadlib.ok.ok;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.r;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface s extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class ok extends Binder implements s {
        private static String ok = "";

        /* renamed from: com.ss.android.downloadlib.ok.ok.s$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        private static class C0955ok implements s {
            private IBinder ok;

            C0955ok(IBinder iBinder) {
                if (TextUtils.isEmpty(ok.ok)) {
                    JSONObject q3 = r.q();
                    String unused = ok.ok = com.ss.android.socialbase.appdownloader.kf.bl.ok(q3.optString("t"), q3.optString("s"));
                }
                this.ok = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.ok;
            }

            @Override // com.ss.android.downloadlib.ok.ok.s
            public void ok(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ok.ok);
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ok.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 == 1) {
                parcel.enforceInterface(ok);
                ok(parcel.readInt() != 0 ? a.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i4 != 1598968902) {
                return super.onTransact(i4, parcel, parcel2, i5);
            } else {
                parcel2.writeString(ok);
                return true;
            }
        }

        public static s ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ok);
            if (queryLocalInterface != null && (queryLocalInterface instanceof s)) {
                return (s) queryLocalInterface;
            }
            return new C0955ok(iBinder);
        }
    }

    void ok(a aVar) throws RemoteException;
}
