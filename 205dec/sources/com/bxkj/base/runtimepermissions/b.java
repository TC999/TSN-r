package com.bxkj.base.runtimepermissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PermissionsManager.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    private static final String f18308d = "b";

    /* renamed from: e  reason: collision with root package name */
    private static b f18309e;

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f18310a = new HashSet(1);

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f18311b = new HashSet(1);

    /* renamed from: c  reason: collision with root package name */
    private final List<WeakReference<c>> f18312c = new ArrayList(1);

    private b() {
        h();
    }

    private synchronized void a(@NonNull String[] strArr, @Nullable c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.e(strArr);
        this.f18312c.add(new WeakReference<>(cVar));
    }

    private void b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable c cVar) {
        for (String str : strArr) {
            if (cVar != null) {
                if (!this.f18311b.contains(str)) {
                    cVar.d(str, a.NOT_FOUND);
                } else if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                    cVar.d(str, a.DENIED);
                } else {
                    cVar.d(str, a.GRANTED);
                }
            }
        }
    }

    public static b c() {
        if (f18309e == null) {
            f18309e = new b();
        }
        return f18309e;
    }

    @NonNull
    private synchronized String[] d(@NonNull Activity activity) {
        ArrayList arrayList;
        String[] strArr;
        PackageInfo packageInfo = null;
        arrayList = new ArrayList(1);
        try {
            Log.d(f18308d, activity.getPackageName());
            packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException e4) {
            Log.e(f18308d, "A problem occurred when retrieving permissions", e4);
        }
        if (packageInfo != null && (strArr = packageInfo.requestedPermissions) != null) {
            for (String str : strArr) {
                Log.d(f18308d, "Manifest contained permission: " + str);
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @NonNull
    private List<String> e(@NonNull Activity activity, @NonNull String[] strArr, @Nullable c cVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f18311b.contains(str)) {
                if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                    if (!this.f18310a.contains(str)) {
                        arrayList.add(str);
                    }
                } else if (cVar != null) {
                    cVar.d(str, a.GRANTED);
                }
            } else if (cVar != null) {
                cVar.d(str, a.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private synchronized void h() {
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e4) {
                Log.e(f18308d, "Could not access field", e4);
            }
            this.f18311b.add(str);
        }
    }

    private synchronized void j(@Nullable c cVar) {
        Iterator<WeakReference<c>> it = this.f18312c.iterator();
        while (it.hasNext()) {
            WeakReference<c> next = it.next();
            if (next.get() == cVar || next.get() == null) {
                it.remove();
            }
        }
    }

    public synchronized boolean f(@Nullable Context context, @NonNull String[] strArr) {
        if (context == null) {
            return false;
        }
        boolean z3 = true;
        for (String str : strArr) {
            z3 &= g(context, str);
        }
        return z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if (r0.f18311b.contains(r2) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean g(@androidx.annotation.Nullable android.content.Context r1, @androidx.annotation.NonNull java.lang.String r2) {
        /*
            r0 = this;
            monitor-enter(r0)
            if (r1 == 0) goto L16
            int r1 = androidx.core.content.ContextCompat.checkSelfPermission(r1, r2)     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L11
            java.util.Set<java.lang.String> r1 = r0.f18311b     // Catch: java.lang.Throwable -> L13
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L13
            if (r1 != 0) goto L16
        L11:
            r1 = 1
            goto L17
        L13:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L16:
            r1 = 0
        L17:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.runtimepermissions.b.g(android.content.Context, java.lang.String):boolean");
    }

    public synchronized void i(@NonNull String[] strArr, @NonNull int[] iArr) {
        int i4;
        int length = strArr.length;
        if (iArr.length < length) {
            length = iArr.length;
        }
        Iterator<WeakReference<c>> it = this.f18312c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c cVar = it.next().get();
            while (i4 < length) {
                i4 = (cVar == null || cVar.c(strArr[i4], iArr[i4])) ? 0 : i4 + 1;
                it.remove();
                break;
            }
        }
        while (i4 < length) {
            this.f18310a.remove(strArr[i4]);
            i4++;
        }
    }

    public synchronized void k(@Nullable Activity activity, @Nullable c cVar) {
        if (activity == null) {
            return;
        }
        l(activity, d(activity), cVar);
    }

    public synchronized void l(@Nullable Activity activity, @NonNull String[] strArr, @Nullable c cVar) {
        if (activity == null) {
            return;
        }
        a(strArr, cVar);
        if (Build.VERSION.SDK_INT < 23) {
            b(activity, strArr, cVar);
        } else {
            List<String> e4 = e(activity, strArr, cVar);
            if (e4.isEmpty()) {
                j(cVar);
            } else {
                this.f18310a.addAll(e4);
                ActivityCompat.requestPermissions(activity, (String[]) e4.toArray(new String[e4.size()]), 1);
            }
        }
    }

    public synchronized void m(@NonNull Fragment fragment, @NonNull String[] strArr, @Nullable c cVar) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        a(strArr, cVar);
        if (Build.VERSION.SDK_INT < 23) {
            b(activity, strArr, cVar);
        } else {
            List<String> e4 = e(activity, strArr, cVar);
            if (e4.isEmpty()) {
                j(cVar);
            } else {
                this.f18310a.addAll(e4);
                fragment.requestPermissions((String[]) e4.toArray(new String[e4.size()]), 1);
            }
        }
    }
}
