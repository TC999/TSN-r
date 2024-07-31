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

/* compiled from: PermissionsManager.java */
/* renamed from: com.bxkj.base.runtimepermissions.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3881b {

    /* renamed from: d */
    private static final String f14823d = "b";

    /* renamed from: e */
    private static C3881b f14824e;

    /* renamed from: a */
    private final Set<String> f14825a = new HashSet(1);

    /* renamed from: b */
    private final Set<String> f14826b = new HashSet(1);

    /* renamed from: c */
    private final List<WeakReference<AbstractC3882c>> f14827c = new ArrayList(1);

    private C3881b() {
        m44163h();
    }

    /* renamed from: a */
    private synchronized void m44170a(@NonNull String[] strArr, @Nullable AbstractC3882c abstractC3882c) {
        if (abstractC3882c == null) {
            return;
        }
        abstractC3882c.m44153e(strArr);
        this.f14827c.add(new WeakReference<>(abstractC3882c));
    }

    /* renamed from: b */
    private void m44169b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable AbstractC3882c abstractC3882c) {
        for (String str : strArr) {
            if (abstractC3882c != null) {
                if (!this.f14826b.contains(str)) {
                    abstractC3882c.m44154d(str, EnumC3880a.NOT_FOUND);
                } else if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                    abstractC3882c.m44154d(str, EnumC3880a.DENIED);
                } else {
                    abstractC3882c.m44154d(str, EnumC3880a.GRANTED);
                }
            }
        }
    }

    /* renamed from: c */
    public static C3881b m44168c() {
        if (f14824e == null) {
            f14824e = new C3881b();
        }
        return f14824e;
    }

    @NonNull
    /* renamed from: d */
    private synchronized String[] m44167d(@NonNull Activity activity) {
        ArrayList arrayList;
        String[] strArr;
        PackageInfo packageInfo = null;
        arrayList = new ArrayList(1);
        try {
            Log.d(f14823d, activity.getPackageName());
            packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(f14823d, "A problem occurred when retrieving permissions", e);
        }
        if (packageInfo != null && (strArr = packageInfo.requestedPermissions) != null) {
            for (String str : strArr) {
                Log.d(f14823d, "Manifest contained permission: " + str);
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @NonNull
    /* renamed from: e */
    private List<String> m44166e(@NonNull Activity activity, @NonNull String[] strArr, @Nullable AbstractC3882c abstractC3882c) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f14826b.contains(str)) {
                if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                    if (!this.f14825a.contains(str)) {
                        arrayList.add(str);
                    }
                } else if (abstractC3882c != null) {
                    abstractC3882c.m44154d(str, EnumC3880a.GRANTED);
                }
            } else if (abstractC3882c != null) {
                abstractC3882c.m44154d(str, EnumC3880a.NOT_FOUND);
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    private synchronized void m44163h() {
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e) {
                Log.e(f14823d, "Could not access field", e);
            }
            this.f14826b.add(str);
        }
    }

    /* renamed from: j */
    private synchronized void m44161j(@Nullable AbstractC3882c abstractC3882c) {
        Iterator<WeakReference<AbstractC3882c>> it = this.f14827c.iterator();
        while (it.hasNext()) {
            WeakReference<AbstractC3882c> next = it.next();
            if (next.get() == abstractC3882c || next.get() == null) {
                it.remove();
            }
        }
    }

    /* renamed from: f */
    public synchronized boolean m44165f(@Nullable Context context, @NonNull String[] strArr) {
        if (context == null) {
            return false;
        }
        boolean z = true;
        for (String str : strArr) {
            z &= m44164g(context, str);
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
        if (r0.f14826b.contains(r2) == false) goto L13;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m44164g(@androidx.annotation.Nullable android.content.Context r1, @androidx.annotation.NonNull java.lang.String r2) {
        /*
            r0 = this;
            monitor-enter(r0)
            if (r1 == 0) goto L16
            int r1 = androidx.core.content.ContextCompat.checkSelfPermission(r1, r2)     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L11
            java.util.Set<java.lang.String> r1 = r0.f14826b     // Catch: java.lang.Throwable -> L13
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.runtimepermissions.C3881b.m44164g(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: i */
    public synchronized void m44162i(@NonNull String[] strArr, @NonNull int[] iArr) {
        int i;
        int length = strArr.length;
        if (iArr.length < length) {
            length = iArr.length;
        }
        Iterator<WeakReference<AbstractC3882c>> it = this.f14827c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractC3882c abstractC3882c = it.next().get();
            while (i < length) {
                i = (abstractC3882c == null || abstractC3882c.m44155c(strArr[i], iArr[i])) ? 0 : i + 1;
                it.remove();
                break;
            }
        }
        while (i < length) {
            this.f14825a.remove(strArr[i]);
            i++;
        }
    }

    /* renamed from: k */
    public synchronized void m44160k(@Nullable Activity activity, @Nullable AbstractC3882c abstractC3882c) {
        if (activity == null) {
            return;
        }
        m44159l(activity, m44167d(activity), abstractC3882c);
    }

    /* renamed from: l */
    public synchronized void m44159l(@Nullable Activity activity, @NonNull String[] strArr, @Nullable AbstractC3882c abstractC3882c) {
        if (activity == null) {
            return;
        }
        m44170a(strArr, abstractC3882c);
        if (Build.VERSION.SDK_INT < 23) {
            m44169b(activity, strArr, abstractC3882c);
        } else {
            List<String> m44166e = m44166e(activity, strArr, abstractC3882c);
            if (m44166e.isEmpty()) {
                m44161j(abstractC3882c);
            } else {
                this.f14825a.addAll(m44166e);
                ActivityCompat.requestPermissions(activity, (String[]) m44166e.toArray(new String[m44166e.size()]), 1);
            }
        }
    }

    /* renamed from: m */
    public synchronized void m44158m(@NonNull Fragment fragment, @NonNull String[] strArr, @Nullable AbstractC3882c abstractC3882c) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        m44170a(strArr, abstractC3882c);
        if (Build.VERSION.SDK_INT < 23) {
            m44169b(activity, strArr, abstractC3882c);
        } else {
            List<String> m44166e = m44166e(activity, strArr, abstractC3882c);
            if (m44166e.isEmpty()) {
                m44161j(abstractC3882c);
            } else {
                this.f14825a.addAll(m44166e);
                fragment.requestPermissions((String[]) m44166e.toArray(new String[m44166e.size()]), 1);
            }
        }
    }
}
