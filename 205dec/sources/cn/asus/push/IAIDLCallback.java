package cn.asus.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface IAIDLCallback extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class Default implements IAIDLCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cn.asus.push.IAIDLCallback
        public void call(DataBuffer dataBuffer) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public abstract class Stub extends Binder implements IAIDLCallback {
        private static final String DESCRIPTOR = "cn.asus.push.IAIDLCallback";
        static final int TRANSACTION_call = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAIDLCallback)) ? new c(iBinder) : (IAIDLCallback) queryLocalInterface;
        }

        public static IAIDLCallback getDefaultImpl() {
            return c.f1528b;
        }

        public static boolean setDefaultImpl(IAIDLCallback iAIDLCallback) {
            if (c.f1528b != null || iAIDLCallback == null) {
                return false;
            }
            c.f1528b = iAIDLCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                call(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i4 != 1598968902) {
                return super.onTransact(i4, parcel, parcel2, i5);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void call(DataBuffer dataBuffer);
}
