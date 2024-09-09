package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class x0 {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<Integer> f46708b;

    /* renamed from: a  reason: collision with root package name */
    private Map<Activity, Integer> f46709a = new WeakHashMap(1);

    static {
        Set<Integer> unmodifiableSet;
        if (Build.VERSION.SDK_INT >= 18) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(-1, 2, 10, 4, 13)));
        } else {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(-1, 2, 10, 4)));
        }
        f46708b = unmodifiableSet;
    }

    public void a(Activity activity) {
        try {
            b(activity);
        } catch (IllegalStateException e4) {
            d1.a("lockOrientation exception", e4);
        }
    }

    public void b(Activity activity) {
        int requestedOrientation = activity.getRequestedOrientation();
        if (f46708b.contains(Integer.valueOf(requestedOrientation))) {
            int i4 = activity.getResources().getConfiguration().orientation;
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            StringBuilder sb = new StringBuilder();
            sb.append("config ORIENTATION=");
            sb.append(i4 == 2 ? "landscape" : "patr");
            sb.append(" \t rotation:");
            sb.append(rotation);
            d1.a(sb.toString(), new Object[0]);
            if (i4 == 2) {
                if (a() && (rotation == 2 || rotation == 3)) {
                    activity.setRequestedOrientation(8);
                } else {
                    activity.setRequestedOrientation(0);
                }
            } else if (a() && (rotation == 2 || rotation == 1)) {
                activity.setRequestedOrientation(9);
            } else {
                activity.setRequestedOrientation(1);
            }
            this.f46709a.put(activity, Integer.valueOf(requestedOrientation));
        }
    }

    public void c() {
        Map<Activity, Integer> map = this.f46709a;
        if (map == null) {
            d1.a("HoldingActivityOrientationMap null");
            return;
        }
        if (map.size() > 1) {
            d1.a("HoldingActivityOrientationMap is holding More than one entry");
        }
        for (Activity activity : this.f46709a.keySet()) {
            if (activity != null) {
                activity.setRequestedOrientation(this.f46709a.get(activity).intValue());
            }
        }
        this.f46709a.clear();
    }

    private boolean a() {
        return Build.VERSION.SDK_INT > 8;
    }

    public void b() {
        try {
            c();
        } catch (IllegalStateException e4) {
            d1.a("unLockOrientation exception", e4);
        }
    }
}
