package com.bytedance.pangle.p120e;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.p119d.C6081c;
import com.bytedance.pangle.p120e.C6102f;
import com.bytedance.pangle.util.C6251g;
import com.bytedance.pangle.util.C6252h;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.pangle.e.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6099e implements C6102f.InterfaceC6105a {

    /* renamed from: a */
    private static volatile IBinder f21944a;

    /* renamed from: b */
    private static volatile Object f21945b;

    /* renamed from: com.bytedance.pangle.e.e$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC6100a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.e.e$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class ResultReceiverC6101b extends ResultReceiver {

        /* renamed from: a */
        private InterfaceC6100a f21946a;

        public ResultReceiverC6101b() {
            super(null);
            this.f21946a = null;
        }

        @Override // android.os.ResultReceiver
        protected final void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    /* renamed from: a */
    private static void m37187a(String[] strArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeFileDescriptor(FileDescriptor.in);
        obtain.writeFileDescriptor(FileDescriptor.out);
        obtain.writeFileDescriptor(FileDescriptor.err);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(null);
        new ResultReceiverC6101b().writeToParcel(obtain, 0);
        try {
            f21944a.transact(1598246212, obtain, obtain2, 0);
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

    /* renamed from: a */
    private static Object m37188a(Field field, Object obj) {
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

    /* renamed from: a */
    private static Object m37189a(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.pangle.p120e.C6102f.InterfaceC6105a
    /* renamed from: a */
    public final boolean mo37184a(String str, int i) {
        boolean z;
        IBinder asBinder;
        if (f21944a == null) {
            PackageManager packageManager = Zeus.getAppApplication().getPackageManager();
            Field field = packageManager == null ? null : FieldUtils.getField(packageManager.getClass(), "mPM");
            if (field != null) {
                Object m37188a = m37188a(field, packageManager);
                f21945b = m37188a;
                if ((m37188a instanceof IInterface) && (asBinder = ((IInterface) f21945b).asBinder()) != null) {
                    f21944a = asBinder;
                }
            }
        }
        if (str != null) {
            String m37228b = C6081c.m37228b(str, i);
            String m37223e = C6081c.m37223e(str, i);
            try {
                C6252h.m36889a(m37228b, m37223e);
            } catch (Exception unused) {
            }
            String packageName = Zeus.getAppApplication().getPackageName();
            String m37199a = C6096b.m37199a();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 == 30) {
                if (f21945b != null && packageName != null && m37223e != null && m37199a != null) {
                    m37189a(f21945b, "notifyDexLoad", new Object[]{packageName, Collections.singletonMap(m37223e, "PCL[]"), m37199a}, new Class[]{String.class, Map.class, String.class});
                }
            } else if (i2 == 29 && f21945b != null && packageName != null && m37223e != null && m37199a != null) {
                m37189a(f21945b, "notifyDexLoad", new Object[]{packageName, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(m37223e), m37199a}, new Class[]{String.class, List.class, List.class, String.class});
            }
        }
        String m37223e2 = C6081c.m37223e(str, i);
        String str2 = C6081c.m37220h(str, i) + File.separator + C6096b.m37197a(m37223e2);
        int i3 = 1;
        while (true) {
            if (i3 > 3) {
                z = false;
                break;
            }
            m37187a(new String[]{"compile", "-m", "speed", "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName()});
            if (C6096b.m37193a(str2)) {
                z = true;
                break;
            }
            i3++;
        }
        if (str != null) {
            try {
                C6251g.m36895a(C6081c.m37221g(str, i), C6081c.m37222f(str, i));
            } catch (Exception unused2) {
            }
            try {
                File file = new File(C6081c.m37223e(str, i));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused3) {
            }
            m37187a(new String[]{"reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName()});
        }
        return z;
    }
}
