package cn.asus.push;

import android.os.IBinder;
import android.os.Parcel;
import cn.asus.push.IAIDLCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class c implements IAIDLCallback {

    /* renamed from: b  reason: collision with root package name */
    public static IAIDLCallback f1528b;

    /* renamed from: a  reason: collision with root package name */
    private IBinder f1529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IBinder iBinder) {
        this.f1529a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1529a;
    }

    @Override // cn.asus.push.IAIDLCallback
    public final void call(DataBuffer dataBuffer) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLCallback");
            if (dataBuffer != null) {
                obtain.writeInt(1);
                dataBuffer.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (this.f1529a.transact(1, obtain, null, 1) || IAIDLCallback.Stub.getDefaultImpl() == null) {
                return;
            }
            IAIDLCallback.Stub.getDefaultImpl().call(dataBuffer);
        } finally {
            obtain.recycle();
        }
    }
}
