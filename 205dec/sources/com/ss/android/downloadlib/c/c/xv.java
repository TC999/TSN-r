package com.ss.android.downloadlib.c.c;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.c.c.sr;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface xv extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class c extends Binder implements xv {

        /* renamed from: c  reason: collision with root package name */
        private static String f48784c = "";

        /* renamed from: com.ss.android.downloadlib.c.c.xv$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        private static class C0949c implements xv {

            /* renamed from: c  reason: collision with root package name */
            private IBinder f48785c;

            C0949c(IBinder iBinder) {
                if (TextUtils.isEmpty(c.f48784c)) {
                    JSONObject gd = k.gd();
                    String unused = c.f48784c = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("r"), gd.optString("s"));
                }
                this.f48785c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f48785c;
            }

            @Override // com.ss.android.downloadlib.c.c.xv
            public void c(w wVar, sr srVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(c.f48784c);
                    if (wVar != null) {
                        obtain.writeInt(1);
                        wVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(srVar != null ? srVar.asBinder() : null);
                    this.f48785c.transact(1, obtain, obtain2, 0);
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
                parcel2.writeString(f48784c);
                return true;
            }
            if (i4 != 1) {
                return super.onTransact(i4, parcel, parcel2, i5);
            }
            parcel.enforceInterface(f48784c);
            c(parcel.readInt() != 0 ? w.CREATOR.createFromParcel(parcel) : null, sr.c.c(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static xv c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f48784c);
            if (queryLocalInterface != null && (queryLocalInterface instanceof xv)) {
                return (xv) queryLocalInterface;
            }
            return new C0949c(iBinder);
        }
    }

    void c(w wVar, sr srVar) throws RemoteException;
}
