package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: F  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class F extends Binder implements IInterface {
    public F() {
        attachInterface(this, "org.lsposed.lspd.service.IRemotePreferenceCallback");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 >= 1 && i4 <= 16777215) {
            parcel.enforceInterface("org.lsposed.lspd.service.IRemotePreferenceCallback");
        }
        if (i4 == 1598968902) {
            parcel2.writeString("org.lsposed.lspd.service.IRemotePreferenceCallback");
            return true;
        } else if (i4 != 1) {
            return super.onTransact(i4, parcel, parcel2, i5);
        } else {
            ((BinderC1342b0) this).f((Bundle) AbstractC1457e.i(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
