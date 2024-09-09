package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c1 implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f61389a;

    public c1(IBinder iBinder) {
        this.f61389a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f61389a;
    }

    public String c() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken((String) pblk.a(16777217, 0, 0L, "6d034a", new byte[]{36, 105, 78, 9, 10, 101, 32, 86, 47, 110, 52, 103, 13, 116, 30, 102, 37, 73, 100, 110, 34, 104, 87, 70, 25, 111, 17, 108, 69, 45, 14, 66, 74, 67, 42, Byte.MAX_VALUE, 49, 73, 72, 109, 51, 99, 81, 65, 10, 117, 48}));
            try {
                this.f61389a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable unused) {
                obtain.recycle();
                obtain2.recycle();
                str = null;
                obtain.recycle();
                obtain2.recycle();
                return str;
            }
        } catch (Throwable unused2) {
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }
}
