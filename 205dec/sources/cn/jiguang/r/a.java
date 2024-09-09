package cn.jiguang.r;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.ah.d;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f3775a;

    /* renamed from: b  reason: collision with root package name */
    private String f3776b = d.f("Mpy0fkBSw1N+kug2cBPj2Z07jpK2SYpu9oSV4B2lEuO7ZdtoaGwNjuH9BjHR80mN");

    public a(IBinder iBinder) {
        this.f3775a = iBinder;
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f3776b);
            this.f3775a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                cn.jiguang.w.a.f("ZuiAdvertisingInterface", "get Ids-o error: " + th.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
