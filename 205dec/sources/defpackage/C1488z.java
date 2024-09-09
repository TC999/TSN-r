package defpackage;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: z  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1488z implements B {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f65070a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f65070a;
    }

    public final void f(Intent intent) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.ILSPManagerService");
            AbstractC1457e.o(obtain, intent);
            this.f65070a.transact(36, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
