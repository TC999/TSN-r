package cn.jiguang.be;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.ah.d;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f2583a;

    /* renamed from: b  reason: collision with root package name */
    private String f2584b;

    public a(IBinder iBinder) {
        this.f2584b = "";
        this.f2583a = iBinder;
        this.f2584b = d.f("8lAhWp7NB89J3VIJU4lIGfGqvEuhZG7tBjI4IuOrU/y3j/vpb/c+G/Rylr/l3ZwQ");
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f2584b);
            this.f2583a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                cn.jiguang.w.a.f("AsusAdvertisingInterface", "get ids-o e: " + th.getMessage());
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
        return this.f2583a;
    }
}
