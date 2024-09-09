package cn.jiguang.j;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.ah.d;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f3686a;

    /* renamed from: b  reason: collision with root package name */
    private String f3687b = d.f("axDZqud6H+CDQBXA/yBXOryhAsxzPh1PgN4N991nACfTSsXdCfZsE70k+cjPDPVB6dhHsO0zfFF8mVkwxeVKdQ==");

    public a(IBinder iBinder) {
        this.f3686a = iBinder;
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken(this.f3687b);
                this.f3686a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } catch (Exception e4) {
                cn.jiguang.w.a.f("HuaweiAdvertisingInterface", "getIds error: " + e4.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
