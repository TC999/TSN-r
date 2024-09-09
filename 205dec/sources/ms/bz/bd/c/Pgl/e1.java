package ms.bz.bd.c.Pgl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e1 implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f61391a;

    public e1(IBinder iBinder) {
        this.f61391a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public String c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken((String) pblk.a(16777217, 0, 0L, "0bb2fe", new byte[]{34, 111, 28, 8, 67, 103, 58, 13, 55, 103, 55, 105, 18, 67, 80, 118, 32, 70, 33, 116, 40, 99, 20, 8, 112, 86, 54, 85, 58, 97, 36, 105, 21, 111, 87, 102, 54, 81, 53, 99, 34, 101}));
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th) {
                th = th;
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
            try {
                this.f61391a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                obtain2.recycle();
                obtain.recycle();
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }
}
