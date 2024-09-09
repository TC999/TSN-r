package com.bytedance.msdk.core.t;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.f.me;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {
    private static ux sr;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f28200c = new HashSet(1);

    /* renamed from: w  reason: collision with root package name */
    private final List<f> f28201w = new ArrayList(1);
    private final List<WeakReference<f>> xv = new ArrayList(1);

    private ux() {
        w();
    }

    public static ux c() {
        if (sr == null) {
            sr = new ux();
        }
        return sr;
    }

    private synchronized void w() {
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
            this.f28200c.add(str);
        }
    }

    @NonNull
    private List<String> xv(@NonNull Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f28200c.contains(str)) {
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

    private synchronized void c(@NonNull String[] strArr, @Nullable f fVar) {
        if (fVar != null) {
            fVar.c(strArr);
            this.f28201w.add(fVar);
            this.xv.add(new WeakReference<>(fVar));
        }
    }

    private void w(@NonNull Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        boolean c4;
        for (String str : strArr) {
            if (fVar != null) {
                try {
                    if (!this.f28200c.contains(str)) {
                        c4 = fVar.c(str, sr.NOT_FOUND);
                    } else if (xv.c(activity, str) != 0) {
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

    private synchronized void c(@Nullable f fVar) {
        Iterator<WeakReference<f>> it = this.xv.iterator();
        while (it.hasNext()) {
            WeakReference<f> next = it.next();
            if (next.get() == fVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<f> it2 = this.f28201w.iterator();
        while (it2.hasNext()) {
            if (it2.next() == fVar) {
                it2.remove();
            }
        }
    }

    public synchronized boolean c(@Nullable Context context, @NonNull String str) {
        boolean z3 = false;
        if (context != null) {
            if (me.ux()) {
                if (w.c(context, str) && (xv.c(context, str) == 0 || !this.f28200c.contains(str))) {
                    z3 = true;
                }
                return z3;
            }
            return (xv.c(context, str) == 0 || !this.f28200c.contains(str)) ? true : true;
        }
        return false;
    }

    public synchronized void c(@Nullable Activity activity, @NonNull String[] strArr, @Nullable f fVar) {
        if (activity != null) {
            try {
                c(strArr, fVar);
                if (Build.VERSION.SDK_INT < 23) {
                    w(activity, strArr, fVar);
                } else {
                    List<String> xv = xv(activity, strArr, fVar);
                    if (xv.isEmpty()) {
                        c(fVar);
                    } else {
                        xv.requestPermissions(activity, (String[]) xv.toArray(new String[xv.size()]), 1);
                    }
                }
            } finally {
            }
        }
    }

    public synchronized void c(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                String str = strArr[i4];
                if ((iArr[i4] == -1 || (me.ux() && !w.c(activity, str))) && iArr[i4] != -1) {
                    iArr[i4] = -1;
                }
            }
            c(strArr, iArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(@NonNull String[] strArr, @NonNull int[] iArr) {
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
            Iterator<f> it2 = this.f28201w.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
