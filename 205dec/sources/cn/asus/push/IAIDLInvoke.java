package cn.asus.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.asus.push.IAIDLCallback;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface IAIDLInvoke extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class Default implements IAIDLInvoke {
        @Override // cn.asus.push.IAIDLInvoke
        public void a(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cn.asus.push.IAIDLInvoke
        public void b(DataBuffer dataBuffer) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public abstract class Stub extends Binder implements IAIDLInvoke {

        /* renamed from: a  reason: collision with root package name */
        private static final String f1519a = "cn.asus.push.IAIDLInvoke";

        /* renamed from: b  reason: collision with root package name */
        static final int f1520b = 1;

        /* renamed from: c  reason: collision with root package name */
        static final int f1521c = 2;

        public Stub() {
            attachInterface(this, f1519a);
        }

        public static IAIDLInvoke c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1519a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAIDLInvoke)) ? new d(iBinder) : (IAIDLInvoke) queryLocalInterface;
        }

        public static IAIDLInvoke g() {
            return d.f1530b;
        }

        public static boolean h(IAIDLInvoke iAIDLInvoke) {
            if (d.f1530b != null || iAIDLInvoke == null) {
                return false;
            }
            d.f1530b = iAIDLInvoke;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface(f1519a);
                b(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface(f1519a);
                a(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null, IAIDLCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i4 != 1598968902) {
                return super.onTransact(i4, parcel, parcel2, i5);
            } else {
                parcel2.writeString(f1519a);
                return true;
            }
        }
    }

    void a(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback);

    void b(DataBuffer dataBuffer);
}
