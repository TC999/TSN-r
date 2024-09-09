package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.q;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: PermissionsManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    private static final String f308d = "e";

    /* renamed from: e  reason: collision with root package name */
    private static e f309e;

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f310a = new HashSet(1);

    /* renamed from: b  reason: collision with root package name */
    private final List<WeakReference<f>> f311b = new ArrayList(1);

    /* renamed from: c  reason: collision with root package name */
    private final List<f> f312c = new ArrayList(1);

    private e() {
        b();
    }

    public static e a() {
        if (f309e == null) {
            f309e = new e();
        }
        return f309e;
    }

    private synchronized void b() {
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e4) {
                Log.e(f308d, "Could not access field", e4);
            }
            this.f310a.add(str);
        }
    }

    @NonNull
    private List<String> c(@NonNull Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f310a.contains(str)) {
                if (!a(activity, str)) {
                    arrayList.add(str);
                } else if (fVar != null) {
                    fVar.a(str, d.GRANTED);
                }
            } else if (fVar != null) {
                fVar.a(str, d.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private synchronized void a(@NonNull String[] strArr, @Nullable f fVar) {
        if (fVar == null) {
            return;
        }
        fVar.a(strArr);
        this.f312c.add(fVar);
        this.f311b.add(new WeakReference<>(fVar));
    }

    private void b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        boolean a4;
        for (String str : strArr) {
            if (fVar != null) {
                try {
                    if (!this.f310a.contains(str)) {
                        a4 = fVar.a(str, d.NOT_FOUND);
                    } else if (c.a(activity, str) != 0) {
                        a4 = fVar.a(str, d.DENIED);
                    } else {
                        a4 = fVar.a(str, d.GRANTED);
                    }
                    if (a4) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        a(fVar);
    }

    private synchronized void a(@Nullable f fVar) {
        Iterator<WeakReference<f>> it = this.f311b.iterator();
        while (it.hasNext()) {
            WeakReference<f> next = it.next();
            if (next.get() == fVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<f> it2 = this.f312c.iterator();
        while (it2.hasNext()) {
            if (it2.next() == fVar) {
                it2.remove();
            }
        }
    }

    public synchronized boolean a(@Nullable Context context, @NonNull String str) {
        boolean z3 = false;
        if (context == null) {
            return false;
        }
        if (q.t()) {
            if (b.b(context, str) && (c.a(context, str) == 0 || !this.f310a.contains(str))) {
                z3 = true;
            }
            return z3;
        }
        return (c.a(context, str) == 0 || !this.f310a.contains(str)) ? true : true;
    }

    public synchronized void a(@Nullable Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        if (activity == null) {
            return;
        }
        try {
            a(strArr, fVar);
            if (Build.VERSION.SDK_INT < 23) {
                b(activity, strArr, fVar);
            } else {
                List<String> c4 = c(activity, strArr, fVar);
                if (c4.isEmpty()) {
                    a(fVar);
                } else {
                    c.a(activity, (String[]) c4.toArray(new String[c4.size()]), 1);
                }
            }
        } finally {
        }
    }

    public synchronized void a(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                String str = strArr[i4];
                if ((iArr[i4] == -1 || (q.t() && !b.b(activity, str))) && iArr[i4] != -1) {
                    iArr[i4] = -1;
                }
            }
            a(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(@NonNull String[] strArr, @NonNull int[] iArr, String[] strArr2) {
        int i4;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<f>> it = this.f311b.iterator();
            while (it.hasNext()) {
                f fVar = it.next().get();
                while (i4 < length) {
                    i4 = (fVar == null || fVar.a(strArr[i4], iArr[i4])) ? 0 : i4 + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<f> it2 = this.f312c.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
