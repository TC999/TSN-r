package GRJhK.P.EpFniY.cxZDuh;

import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.ArrayList;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;
import ulL.WeEFDVoZmmWVmW.yXd.XposedInit;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class Main {
    /* JADX WARN: Type inference failed for: r0v2, types: [t, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object, z] */
    public static void forkCommon(boolean z3, String str, String str2, IBinder iBinder) {
        InterfaceC1484v interfaceC1484v;
        int i4 = AbstractBinderC1483u.f64411a;
        B b4 = null;
        if (iBinder == null) {
            interfaceC1484v = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("org.lsposed.lspd.service.ILSPApplicationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1484v)) {
                ?? obj = new Object();
                obj.f64371a = iBinder;
                interfaceC1484v = obj;
            } else {
                interfaceC1484v = (InterfaceC1484v) queryLocalInterface;
            }
        }
        synchronized (C1455d.class) {
            IBinder asBinder = interfaceC1484v.asBinder();
            if (C1455d.f54605b == null && asBinder != null) {
                try {
                    C1455d.f54605b = new C1455d(interfaceC1484v);
                } catch (RemoteException e4) {
                    K0.a("link to death error: ", e4);
                }
            }
        }
        XposedBridge.initXResources();
        XposedInit.startsSystemServer = z3;
        N.f39e = z3;
        N.f40f = str;
        AbstractC1457e.a("boot_image", null);
        if (str.equals("com.android.shell") || str.equals("org.lsposed.manager")) {
            PackageInfo packageInfo = E0.f14a;
            ArrayList arrayList = new ArrayList(1);
            try {
                ParcelFileDescriptor a4 = C1455d.f54605b.a(arrayList);
                if (arrayList.size() > 0 && arrayList.get(0) != null && a4 != null) {
                    E0.f15b = a4.detachFd();
                    IBinder iBinder2 = (IBinder) arrayList.get(0);
                    int i5 = A.f3a;
                    if (iBinder2 != null) {
                        IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("org.lsposed.lspd.ILSPManagerService");
                        if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof B)) {
                            ?? obj2 = new Object();
                            obj2.f65070a = iBinder2;
                            b4 = obj2;
                        } else {
                            b4 = (B) queryLocalInterface2;
                        }
                    }
                    E0.c(b4);
                    boolean z4 = K0.f35a;
                    a4.close();
                    Log.i("LSPosed", "Loaded manager, skipping next steps");
                    return;
                } else if (a4 != null) {
                    a4.close();
                }
            } catch (Throwable th) {
                K0.a("failed to inject manager", th);
            }
        }
        String str3 = "Loading xposed for " + str + TTPathConst.sSeparator + Process.myUid();
        boolean z5 = K0.f35a;
        Log.i("LSPosed", str3);
        try {
            AbstractC1457e.m(XposedInit.startsSystemServer);
            XposedInit.loadLegacyModules();
        } catch (Throwable th2) {
            K0.a("error during Xposed initialization", th2);
        }
    }
}
