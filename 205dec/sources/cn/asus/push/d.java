package cn.asus.push;

import android.os.IBinder;
import android.os.Parcel;
import cn.asus.push.IAIDLInvoke;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class d implements IAIDLInvoke {

    /* renamed from: b  reason: collision with root package name */
    public static IAIDLInvoke f1530b;

    /* renamed from: a  reason: collision with root package name */
    private IBinder f1531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(IBinder iBinder) {
        this.f1531a = iBinder;
    }

    @Override // cn.asus.push.IAIDLInvoke
    public final void a(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLInvoke");
            if (dataBuffer != null) {
                obtain.writeInt(1);
                dataBuffer.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(iAIDLCallback != null ? iAIDLCallback.asBinder() : null);
            if (this.f1531a.transact(2, obtain, null, 1) || IAIDLInvoke.Stub.g() == null) {
                return;
            }
            IAIDLInvoke.Stub.g().a(dataBuffer, iAIDLCallback);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1531a;
    }

    @Override // cn.asus.push.IAIDLInvoke
    public final void b(DataBuffer dataBuffer) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLInvoke");
            if (dataBuffer != null) {
                obtain.writeInt(1);
                dataBuffer.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (this.f1531a.transact(1, obtain, obtain2, 0) || IAIDLInvoke.Stub.g() == null) {
                obtain2.readException();
            } else {
                IAIDLInvoke.Stub.g().b(dataBuffer);
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
