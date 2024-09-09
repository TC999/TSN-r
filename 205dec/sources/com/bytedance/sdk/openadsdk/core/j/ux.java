package com.bytedance.sdk.openadsdk.core.j;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.core.ls;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static final String f33814c = "ux";
    private static volatile ux ux;

    /* renamed from: w  reason: collision with root package name */
    private final CopyOnWriteArraySet<String> f33815w = new CopyOnWriteArraySet<>();
    private final List<WeakReference<f>> xv = new ArrayList(1);
    private final List<f> sr = new ArrayList(1);

    private ux() {
        w();
    }

    public static ux c() {
        if (ux == null) {
            synchronized (ux.class) {
                if (ux == null) {
                    ux = new ux();
                }
            }
        }
        return ux;
    }

    private void w() {
        if (Build.VERSION.SDK_INT > 28) {
            xv();
            return;
        }
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e4) {
                Log.e(f33814c, "Could not access field", e4);
            }
            this.f33815w.add(str);
        }
    }

    private void xv() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = ls.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    if (!TextUtils.isEmpty(strArr[i4])) {
                        this.f33815w.add(strArr[i4]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void c(String[] strArr, f fVar) {
        if (fVar == null) {
            return;
        }
        fVar.c(strArr);
        this.sr.add(fVar);
        this.xv.add(new WeakReference<>(fVar));
    }

    private void w(Activity activity, String[] strArr, f fVar) {
        boolean c4;
        for (String str : strArr) {
            if (fVar != null) {
                try {
                    if (!this.f33815w.contains(str)) {
                        c4 = fVar.c(str, sr.NOT_FOUND);
                    } else if (w.c(activity, str) != 0) {
                        c4 = fVar.c(str, sr.DENIED);
                    } else {
                        c4 = fVar.c(str, sr.GRANTED);
                    }
                    if (c4) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        c(fVar);
    }

    private List<String> xv(Activity activity, String[] strArr, f fVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f33815w.contains(str)) {
                if (!c(activity, str)) {
                    arrayList.add(str);
                } else if (fVar != null) {
                    fVar.c(str, sr.GRANTED);
                }
            } else if (fVar != null) {
                fVar.c(str, sr.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private synchronized void c(f fVar) {
        Iterator<WeakReference<f>> it = this.xv.iterator();
        while (it.hasNext()) {
            WeakReference<f> next = it.next();
            if (next.get() == fVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<f> it2 = this.sr.iterator();
        while (it2.hasNext()) {
            if (it2.next() == fVar) {
                it2.remove();
            }
        }
    }

    public boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.eq.ls.w() ? xv.c(context, str) && w.c(context, str) == 0 : w.c(context, str) == 0;
    }

    public synchronized void c(Activity activity, String[] strArr, f fVar) {
        if (activity == null) {
            return;
        }
        try {
            c(strArr, fVar);
            if (Build.VERSION.SDK_INT < 23) {
                w(activity, strArr, fVar);
            } else {
                List<String> xv = xv(activity, strArr, fVar);
                if (xv.isEmpty()) {
                    c(fVar);
                } else {
                    w.requestPermissions(activity, (String[]) xv.toArray(new String[xv.size()]), 1);
                }
            }
        } finally {
        }
    }

    public synchronized void c(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                String str = strArr[i4];
                if ((iArr[i4] == -1 || (com.bytedance.sdk.openadsdk.core.eq.ls.w() && !xv.c(activity, str))) && iArr[i4] != -1) {
                    iArr[i4] = -1;
                }
            }
            c(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(String[] strArr, int[] iArr, String[] strArr2) {
        int i4;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<f>> it = this.xv.iterator();
            while (it.hasNext()) {
                f fVar = it.next().get();
                while (i4 < length) {
                    i4 = (fVar == null || fVar.c(strArr[i4], iArr[i4])) ? 0 : i4 + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<f> it2 = this.sr.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
