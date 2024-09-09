package XI.XI.K0;

import XI.XI.XI.XI;
import a.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class K0 implements kM {
    public XI.XI.XI.XI K0;

    /* renamed from: XI  reason: collision with root package name */
    public Context f78XI;
    public xo kM;
    public ServiceConnection xo = new XI();

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class XI implements ServiceConnection {
        public XI() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            XI.XI.XI.XI c0005xi;
            K0 k02 = K0.this;
            int i4 = XI.AbstractBinderC0004XI.f81a;
            if (iBinder == null) {
                c0005xi = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                c0005xi = (queryLocalInterface == null || !(queryLocalInterface instanceof XI.XI.XI.XI)) ? new XI.AbstractBinderC0004XI.C0005XI(iBinder) : (XI.XI.XI.XI) queryLocalInterface;
            }
            k02.K0 = c0005xi;
            K0.this.kM.connectSuccess(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            K0.this.K0 = null;
        }
    }

    public K0(Context context) {
        this.f78XI = context;
    }

    public boolean XI() {
        boolean isSupported;
        XI.XI.XI.XI xi = this.K0;
        if (xi != null) {
            try {
                isSupported = xi.isSupported();
            } catch (RemoteException e4) {
                e4.getMessage();
                e4.printStackTrace();
            }
            a.a(this.K0);
            return isSupported;
        }
        isSupported = false;
        a.a(this.K0);
        return isSupported;
    }
}
