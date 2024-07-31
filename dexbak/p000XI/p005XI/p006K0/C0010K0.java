package p000XI.p005XI.p006K0;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import p000XI.p005XI.p007XI.InterfaceC0015XI;
import p011a.R8$$SyntheticClass;

/* renamed from: XI.XI.K0.K0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C0010K0 implements InterfaceC0013kM {

    /* renamed from: K0 */
    public InterfaceC0015XI f26K0;

    /* renamed from: XI */
    public Context f27XI;

    /* renamed from: kM */
    public InterfaceC0014xo f28kM;

    /* renamed from: xo */
    public ServiceConnection f29xo = new ServiceConnectionC0011XI();

    /* renamed from: XI.XI.K0.K0$XI */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class ServiceConnectionC0011XI implements ServiceConnection {
        public ServiceConnectionC0011XI() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InterfaceC0015XI c0017xi;
            C0010K0 c0010k0 = C0010K0.this;
            int i = InterfaceC0015XI.AbstractBinderC0016XI.f33a;
            if (iBinder == null) {
                c0017xi = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                c0017xi = (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0015XI)) ? new InterfaceC0015XI.AbstractBinderC0016XI.C0017XI(iBinder) : (InterfaceC0015XI) queryLocalInterface;
            }
            c0010k0.f26K0 = c0017xi;
            C0010K0.this.f28kM.connectSuccess(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C0010K0.this.f26K0 = null;
        }
    }

    public C0010K0(Context context) {
        this.f27XI = context;
    }

    /* renamed from: XI */
    public boolean m60069XI() {
        boolean isSupported;
        InterfaceC0015XI interfaceC0015XI = this.f26K0;
        if (interfaceC0015XI != null) {
            try {
                isSupported = interfaceC0015XI.isSupported();
            } catch (RemoteException e) {
                e.getMessage();
                e.printStackTrace();
            }
            R8$$SyntheticClass.m60055a(this.f26K0);
            return isSupported;
        }
        isSupported = false;
        R8$$SyntheticClass.m60055a(this.f26K0);
        return isSupported;
    }
}
