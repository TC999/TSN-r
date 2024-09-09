package defpackage;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: C  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C implements E {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f9a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9a;
    }

    public final void f(IBinder iBinder, IBinder iBinder2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPosedService");
            obtain.writeStrongBinder(iBinder);
            obtain.writeStrongBinder(iBinder2);
            obtain.writeString("Zygisk");
            this.f9a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final boolean g(Intent intent, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPosedService");
            obtain.writeString(str);
            AbstractC1457e.r(obtain, intent);
            this.f9a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [t, java.lang.Object] */
    public final InterfaceC1484v h(int i4, int i5, String str, IBinder iBinder) {
        InterfaceC1484v interfaceC1484v;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPosedService");
            obtain.writeInt(i4);
            obtain.writeInt(i5);
            obtain.writeString(str);
            obtain.writeStrongBinder(iBinder);
            this.f9a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            int i6 = AbstractBinderC1483u.f64411a;
            if (readStrongBinder == null) {
                interfaceC1484v = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("org.lsposed.lspd.service.ILSPApplicationService");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1484v)) {
                    ?? obj = new Object();
                    obj.f64371a = readStrongBinder;
                    interfaceC1484v = obj;
                } else {
                    interfaceC1484v = (InterfaceC1484v) queryLocalInterface;
                }
            }
            return interfaceC1484v;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
