package defpackage;

import UkJkysonJaAT.ySJi.jKGV.o.BridgeService;
import android.app.ActivityThread;
import android.app.IActivityController;
import android.app.IActivityManager;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;

/* renamed from: c  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class IActivityController$StubC1343c extends IActivityController.Stub {

    /* renamed from: a  reason: collision with root package name */
    public static final Constructor f1460a;

    /* renamed from: b  reason: collision with root package name */
    public static final Method f1461b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f1462c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f1463d;

    /* renamed from: e  reason: collision with root package name */
    public static IActivityController f1464e;

    /* renamed from: f  reason: collision with root package name */
    public static IActivityController$StubC1343c f1465f;

    static {
        try {
            Class<?> cls = Class.forName("com.android.server.am.ActivityManagerShellCommand$MyActivityController", false, ActivityThread.currentActivityThread().getSystemContext().getClassLoader());
            try {
                f1460a = cls.getDeclaredConstructor(IActivityManager.class, PrintWriter.class, InputStream.class, String.class, Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                try {
                    Class<?> cls2 = Boolean.TYPE;
                    f1460a = cls.getDeclaredConstructor(IActivityManager.class, PrintWriter.class, InputStream.class, String.class, cls2, cls2, String.class, cls2);
                } catch (NoSuchMethodException unused2) {
                    Class<?> cls3 = Boolean.TYPE;
                    f1460a = cls.getDeclaredConstructor(IActivityManager.class, PrintWriter.class, InputStream.class, String.class, cls3, cls3, String.class, cls3, cls3);
                }
            }
            f1460a.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("run", new Class[0]);
            f1461b = declaredMethod;
            declaredMethod.setAccessible(true);
            Parcel obtain = Parcel.obtain();
            obtain.writeFileDescriptor(FileDescriptor.in);
            f1463d = obtain.dataPosition();
            obtain.recycle();
            f1462c = true;
        } catch (Throwable th) {
            Log.e("LSPosed Bridge", "Failed to init ActivityController", th);
        }
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [c, android.app.IActivityController$Stub] */
    public static void f(Parcel parcel) {
        if (f1462c) {
            try {
                int dataPosition = parcel.dataPosition();
                f1464e = IActivityController.Stub.asInterface(parcel.readStrongBinder());
                if (f1465f == null) {
                    f1465f = new IActivityController.Stub();
                }
                IActivityController.Stub stub = f1465f;
                int readInt = parcel.readInt();
                parcel.setDataSize(dataPosition);
                parcel.setDataPosition(dataPosition);
                parcel.writeStrongInterface(stub);
                parcel.writeInt(readInt);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static boolean g(IBinder iBinder, Parcel parcel, Parcel parcel2) {
        if (f1462c) {
            try {
                parcel.setDataPosition(f1463d * 3);
                String[] createStringArray = parcel.createStringArray();
                if (createStringArray.length <= 0 || !"monitor".equals(createStringArray[0])) {
                    return false;
                }
                parcel.setDataPosition(0);
                ParcelFileDescriptor readFileDescriptor = parcel.readFileDescriptor();
                try {
                    ParcelFileDescriptor readFileDescriptor2 = parcel.readFileDescriptor();
                    readFileDescriptor = parcel.readFileDescriptor();
                    try {
                        parcel.createStringArray();
                        new ShellCommand().exec((Binder) iBinder, readFileDescriptor.getFileDescriptor(), readFileDescriptor2.getFileDescriptor(), readFileDescriptor.getFileDescriptor(), createStringArray, (ShellCallback) ShellCallback.CREATOR.createFromParcel(parcel), (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel));
                        readFileDescriptor.close();
                        readFileDescriptor2.close();
                        readFileDescriptor.close();
                        parcel2.writeNoException();
                        parcel.setDataPosition(0);
                        return true;
                    } finally {
                    }
                } finally {
                }
            } finally {
                parcel.setDataPosition(0);
            }
        }
        return false;
    }

    public final boolean activityResuming(String str) {
        IActivityController iActivityController = f1464e;
        return iActivityController == null || iActivityController.activityResuming(str);
    }

    public final boolean activityStarting(Intent intent, String str) {
        Objects.toString(intent);
        Objects.toString(intent.getExtras());
        E e4 = BridgeService.f63b;
        if (e4 != null && "com.android.shell".equals(str)) {
            try {
                return ((C) e4).g(intent, str);
            } catch (Throwable th) {
                Log.e("LSPosed Bridge", "request manager", th);
            }
        }
        IActivityController iActivityController = f1464e;
        return iActivityController == null || iActivityController.activityStarting(intent, str);
    }

    public final boolean appCrashed(String str, int i4, String str2, String str3, long j4, String str4) {
        IActivityController iActivityController = f1464e;
        return iActivityController == null || iActivityController.appCrashed(str, i4, str2, str3, j4, str4);
    }

    public final int appEarlyNotResponding(String str, int i4, String str2) {
        IActivityController iActivityController = f1464e;
        if (iActivityController == null) {
            return 0;
        }
        return iActivityController.appNotResponding(str, i4, str2);
    }

    public final int appNotResponding(String str, int i4, String str2) {
        IActivityController iActivityController = f1464e;
        if (iActivityController == null) {
            return 0;
        }
        return iActivityController.appNotResponding(str, i4, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final IBinder asBinder() {
        return this;
    }

    public final boolean moveTaskToFront(String str, int i4, int i5, Bundle bundle) {
        IActivityController iActivityController = f1464e;
        return iActivityController == null || iActivityController.moveTaskToFront(str, i4, i5, bundle);
    }

    public final int systemNotResponding(String str) {
        IActivityController iActivityController = f1464e;
        if (iActivityController == null) {
            return -1;
        }
        return iActivityController.systemNotResponding(str);
    }
}
