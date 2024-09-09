package com.ss.android.downloadlib.ok.ok;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.ok.ok.s;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface bl extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class ok extends Binder implements bl {
        private static String ok = "";

        /* renamed from: com.ss.android.downloadlib.ok.ok.bl$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        private static class C0953ok implements bl {
            private IBinder ok;

            C0953ok(IBinder iBinder) {
                if (TextUtils.isEmpty(ok.ok)) {
                    JSONObject q3 = r.q();
                    String unused = ok.ok = com.ss.android.socialbase.appdownloader.kf.bl.ok(q3.optString("r"), q3.optString("s"));
                }
                this.ok = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.ok;
            }

            @Override // com.ss.android.downloadlib.ok.ok.bl
            public void ok(a aVar, s sVar) throws RemoteException {
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
                    obtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    this.ok.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 == 1598968902) {
                parcel2.writeString(ok);
                return true;
            }
            if (i4 != 1) {
                return super.onTransact(i4, parcel, parcel2, i5);
            }
            parcel.enforceInterface(ok);
            ok(parcel.readInt() != 0 ? a.CREATOR.createFromParcel(parcel) : null, s.ok.ok(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static bl ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ok);
            if (queryLocalInterface != null && (queryLocalInterface instanceof bl)) {
                return (bl) queryLocalInterface;
            }
            return new C0953ok(iBinder);
        }
    }

    void ok(a aVar, s sVar) throws RemoteException;
}
