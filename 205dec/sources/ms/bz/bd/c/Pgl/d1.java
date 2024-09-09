package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d1 implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f61390a;

    public d1(IBinder iBinder) {
        this.f61390a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f61390a;
    }

    public String c() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) pblk.a(16777217, 0, 0L, "a4992f", new byte[]{115, 57, 71, 3, 24, 126, 102, 28, 123, 39, Byte.MAX_VALUE, 38, 79, 67, 9, 116, 116, 28, 107, 108, 62, 55, 67, 73, 1, 63, 77, 5, 109, 103, 84, 51, 92, 68, 14, 116, 75, 17, 109, 103, 100, 63, 76, 68, 8, 99, 81, 16, 122, Byte.MAX_VALUE, 121, 53, 79}));
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f61390a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th2) {
            th = th2;
            obtain.recycle();
            obtain2.recycle();
            th.printStackTrace();
            str = null;
            obtain.recycle();
            obtain2.recycle();
            return str;
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }
}
