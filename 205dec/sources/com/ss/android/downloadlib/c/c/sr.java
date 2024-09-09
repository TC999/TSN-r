package com.ss.android.downloadlib.c.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface sr extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class c extends Binder implements sr {

        /* renamed from: c  reason: collision with root package name */
        private static String f48779c = "";

        /* renamed from: com.ss.android.downloadlib.c.c.sr$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        private static class C0948c implements sr {

            /* renamed from: c  reason: collision with root package name */
            private IBinder f48780c;

            C0948c(IBinder iBinder) {
                if (TextUtils.isEmpty(c.f48779c)) {
                    JSONObject gd = k.gd();
                    String unused = c.f48779c = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("t"), gd.optString("s"));
                }
                this.f48780c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f48780c;
            }

            @Override // com.ss.android.downloadlib.c.c.sr
            public void c(w wVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f48779c);
                    if (wVar != null) {
                        obtain.writeInt(1);
                        wVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f48780c.transact(1, obtain, obtain2, 0);
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
                parcel.enforceInterface(f48779c);
                c(parcel.readInt() != 0 ? w.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i4 != 1598968902) {
                return super.onTransact(i4, parcel, parcel2, i5);
            } else {
                parcel2.writeString(f48779c);
                return true;
            }
        }

        public static sr c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f48779c);
            if (queryLocalInterface != null && (queryLocalInterface instanceof sr)) {
                return (sr) queryLocalInterface;
            }
            return new C0948c(iBinder);
        }
    }

    void c(w wVar) throws RemoteException;
}
