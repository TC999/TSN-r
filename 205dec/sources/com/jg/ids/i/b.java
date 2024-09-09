package com.jg.ids.i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public abstract class b extends Binder implements a {
    public static a a(IBinder iBinder) {
        a cVar;
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                cVar = new c(iBinder);
            } else {
                cVar = (a) queryLocalInterface;
            }
            return cVar;
        } catch (Throwable th) {
            return null;
        }
    }
}
