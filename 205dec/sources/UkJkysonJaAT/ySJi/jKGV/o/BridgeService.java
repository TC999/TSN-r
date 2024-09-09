package UkJkysonJaAT.ySJi.jKGV.o;

import android.app.ActivityThread;
import android.app.ContextImpl;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class BridgeService {

    /* renamed from: a  reason: collision with root package name */
    public static IBinder f62a;

    /* renamed from: b  reason: collision with root package name */
    public static E f63b;

    /* renamed from: c  reason: collision with root package name */
    public static final C1467j f64c = new Object();

    public static boolean a(Parcel parcel, Parcel parcel2) {
        InterfaceC1484v h4;
        if (AbstractC1457e.l(parcel, "LSPosed")) {
            try {
                int i4 = AbstractC1469k.b(3)[parcel.readInt()];
                Binder.getCallingUid();
                Binder.getCallingPid();
                int a4 = AbstractC1469k.a(i4);
                if (a4 != 1) {
                    if (a4 == 2) {
                        IBinder iBinder = null;
                        try {
                            String readString = parcel.readString();
                            IBinder readStrongBinder = parcel.readStrongBinder();
                            E e4 = f63b;
                            if (e4 == null) {
                                h4 = null;
                            } else {
                                h4 = ((C) e4).h(Binder.getCallingUid(), Binder.getCallingPid(), readString, readStrongBinder);
                            }
                            if (h4 != null) {
                                iBinder = h4.asBinder();
                            }
                        } catch (RemoteException e5) {
                            Log.e("LSPosed Bridge", Log.getStackTraceString(e5));
                        }
                        if (iBinder != null) {
                            parcel2.writeNoException();
                            iBinder.toString();
                            parcel2.writeStrongBinder(iBinder);
                            return true;
                        }
                        return false;
                    }
                } else if (Binder.getCallingUid() == 0) {
                    b(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                }
            } catch (Throwable th) {
                Log.e("LSPosed Bridge", "onTransact", th);
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [C, java.lang.Object] */
    public static void b(IBinder iBinder) {
        E e4;
        if (iBinder == null) {
            Log.e("LSPosed Bridge", "received empty binder");
            return;
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        IBinder iBinder2 = f62a;
        C1467j c1467j = f64c;
        if (iBinder2 != null) {
            iBinder2.unlinkToDeath(c1467j, 0);
        }
        Binder.restoreCallingIdentity(clearCallingIdentity);
        IBinder allowBlocking = Binder.allowBlocking(iBinder);
        f62a = allowBlocking;
        int i4 = D.f11a;
        if (allowBlocking == null) {
            e4 = null;
        } else {
            IInterface queryLocalInterface = allowBlocking.queryLocalInterface("org.lsposed.lspd.service.ILSPosedService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof E)) {
                ?? obj = new Object();
                obj.f9a = allowBlocking;
                e4 = obj;
            } else {
                e4 = (E) queryLocalInterface;
            }
        }
        f63b = e4;
        try {
            f62a.linkToDeath(c1467j, 0);
        } catch (Throwable th) {
            Log.e("LSPosed Bridge", "service link to death: ", th);
        }
        try {
            ActivityThread.ApplicationThread applicationThread = ActivityThread.currentActivityThread().getApplicationThread();
            ContextImpl systemContext = ActivityThread.currentActivityThread().getSystemContext();
            ((C) f63b).f(applicationThread.asBinder(), systemContext.getActivityToken());
        } catch (Throwable th2) {
            Log.e("LSPosed Bridge", "dispatch context: ", th2);
        }
        Log.i("LSPosed Bridge", "binder received");
    }

    public static boolean execTransact(IBinder iBinder, int i4, long j4, long j5, int i5) {
        if (i4 != 1598837584) {
            return false;
        }
        Parcel b4 = AbstractC1457e.b(j4);
        Parcel b5 = AbstractC1457e.b(j5);
        if (b4 != null) {
            try {
                if (b5 != null) {
                    return a(b4, b5);
                }
            } catch (Exception e4) {
                if ((i5 & 1) != 0) {
                    Log.w("LSPosed Bridge", "Caught a Exception from the binder stub implementation. ", e4);
                } else {
                    b5.setDataPosition(0);
                    b5.writeException(e4);
                }
                Log.w("LSPosed Bridge", "on transact", e4);
                return true;
            } finally {
                b4.recycle();
                b5.recycle();
            }
        }
        Log.w("LSPosed Bridge", "Got transaction with null data or reply");
        return false;
    }

    public static boolean replaceActivityController(IBinder iBinder, int i4, long j4, long j5, int i5) {
        Parcel b4 = AbstractC1457e.b(j4);
        Parcel b5 = AbstractC1457e.b(j5);
        if (b4 == null || b5 == null) {
            Log.w("LSPosed Bridge", "Got transaction with null data or reply");
            return false;
        }
        try {
            if (AbstractC1457e.l(b4, "android.app.IActivityManager") || AbstractC1457e.l(b4, "com.sonymobile.hookservice.HookActivityService")) {
                IActivityController$StubC1343c.f(b4);
                return false;
            }
            return false;
        } finally {
            b4.setDataPosition(0);
        }
    }

    public static boolean replaceShellCommand(IBinder iBinder, int i4, long j4, long j5, int i5) {
        Parcel b4 = AbstractC1457e.b(j4);
        Parcel b5 = AbstractC1457e.b(j5);
        if (b4 == null || b5 == null) {
            Log.w("LSPosed Bridge", "Got transaction with null data or reply");
            return false;
        }
        try {
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if ("android.app.IActivityManager".equals(interfaceDescriptor) || "com.sonymobile.hookservice.HookActivityService".equals(interfaceDescriptor)) {
                return IActivityController$StubC1343c.g(iBinder, b4, b5);
            }
            return false;
        } catch (Throwable th) {
            try {
                Log.e("LSPosed Bridge", "replace shell command", th);
                return false;
            } finally {
                b4.setDataPosition(0);
            }
        }
    }
}
