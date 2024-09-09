package com.bytedance.pangle.e;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class e implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile IBinder f28705a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Object f28706b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class b extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        private a f28707a;

        public b() {
            super(null);
            this.f28707a = null;
        }

        @Override // android.os.ResultReceiver
        protected final void onReceiveResult(int i4, Bundle bundle) {
            super.onReceiveResult(i4, bundle);
        }
    }

    private static void a(String[] strArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeFileDescriptor(FileDescriptor.in);
        obtain.writeFileDescriptor(FileDescriptor.out);
        obtain.writeFileDescriptor(FileDescriptor.err);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(null);
        new b().writeToParcel(obtain, 0);
        try {
            f28705a.transact(1598246212, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
        obtain.recycle();
        obtain2.recycle();
    }

    private static Object a(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object a(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i4) {
        boolean z3;
        IBinder asBinder;
        if (f28705a == null) {
            PackageManager packageManager = Zeus.getAppApplication().getPackageManager();
            Field field = packageManager == null ? null : FieldUtils.getField(packageManager.getClass(), "mPM");
            if (field != null) {
                Object a4 = a(field, packageManager);
                f28706b = a4;
                if ((a4 instanceof IInterface) && (asBinder = ((IInterface) f28706b).asBinder()) != null) {
                    f28705a = asBinder;
                }
            }
        }
        if (str != null) {
            String b4 = com.bytedance.pangle.d.c.b(str, i4);
            String e4 = com.bytedance.pangle.d.c.e(str, i4);
            try {
                com.bytedance.pangle.util.h.a(b4, e4);
            } catch (Exception unused) {
            }
            String packageName = Zeus.getAppApplication().getPackageName();
            String a5 = com.bytedance.pangle.e.b.a();
            int i5 = Build.VERSION.SDK_INT;
            if (i5 == 30) {
                if (f28706b != null && packageName != null && e4 != null && a5 != null) {
                    a(f28706b, "notifyDexLoad", new Object[]{packageName, Collections.singletonMap(e4, "PCL[]"), a5}, new Class[]{String.class, Map.class, String.class});
                }
            } else if (i5 == 29 && f28706b != null && packageName != null && e4 != null && a5 != null) {
                a(f28706b, "notifyDexLoad", new Object[]{packageName, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(e4), a5}, new Class[]{String.class, List.class, List.class, String.class});
            }
        }
        String e5 = com.bytedance.pangle.d.c.e(str, i4);
        String str2 = com.bytedance.pangle.d.c.h(str, i4) + File.separator + com.bytedance.pangle.e.b.a(e5);
        int i6 = 1;
        while (true) {
            if (i6 > 3) {
                z3 = false;
                break;
            }
            a(new String[]{"compile", "-m", "speed", "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName()});
            if (com.bytedance.pangle.e.b.a(str2)) {
                z3 = true;
                break;
            }
            i6++;
        }
        if (str != null) {
            try {
                com.bytedance.pangle.util.g.a(com.bytedance.pangle.d.c.g(str, i4), com.bytedance.pangle.d.c.f(str, i4));
            } catch (Exception unused2) {
            }
            try {
                File file = new File(com.bytedance.pangle.d.c.e(str, i4));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused3) {
            }
            a(new String[]{"reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName()});
        }
        return z3;
    }
}
