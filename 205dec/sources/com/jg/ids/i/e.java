package com.jg.ids.i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public abstract class e extends Binder implements d {
    public static d a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.stdid.IStdID");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
            return new f(iBinder);
        }
        return (d) queryLocalInterface;
    }
}
