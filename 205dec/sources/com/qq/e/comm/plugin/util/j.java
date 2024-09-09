package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c  reason: collision with root package name */
    private static volatile j f46493c;

    /* renamed from: a  reason: collision with root package name */
    private int f46494a;

    /* renamed from: b  reason: collision with root package name */
    SparseArray<LinkedHashMap<Integer, Integer>> f46495b = new SparseArray<>();

    private j() {
    }

    private void a(Activity activity, String str) {
    }

    public static j b() {
        if (f46493c == null) {
            synchronized (j.class) {
                if (f46493c == null) {
                    f46493c = new j();
                }
            }
        }
        return f46493c;
    }

    public int a() {
        return this.f46494a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Map.Entry<Integer, Integer> b4 = b(activity);
        if (b4 != null) {
            if (b4.getValue().intValue() == 6) {
                a(activity).remove(b4.getKey());
            } else if (b4.getValue().intValue() == 5) {
                this.f46494a = activity.hashCode();
            }
        }
        a(activity, "onActivityCreated");
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity.isChangingConfigurations()) {
            a(activity, 6);
        } else {
            a(activity).remove(Integer.valueOf(activity.hashCode()));
        }
        if (activity.hashCode() == this.f46494a) {
            this.f46494a = 0;
        }
        a(activity, "onActivityDestroyed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity, "onActivityPaused");
        a(activity, 4);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity, "onActivityResumed");
        a(activity, 3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        a(activity, "onActivityStarted");
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        a(activity, "onActivityStopped");
        a(activity, 5);
    }

    private void a(Activity activity, int i4) {
        a(activity).put(Integer.valueOf(activity.hashCode()), Integer.valueOf(i4));
    }

    private LinkedHashMap<Integer, Integer> a(Activity activity) {
        LinkedHashMap<Integer, Integer> linkedHashMap = this.f46495b.get(activity.getTaskId());
        if (linkedHashMap == null) {
            LinkedHashMap<Integer, Integer> linkedHashMap2 = new LinkedHashMap<>();
            this.f46495b.put(activity.getTaskId(), linkedHashMap2);
            return linkedHashMap2;
        }
        return linkedHashMap;
    }

    private Map.Entry<Integer, Integer> b(Activity activity) {
        Iterator<Map.Entry<Integer, Integer>> it = a(activity).entrySet().iterator();
        Map.Entry<Integer, Integer> entry = null;
        while (it.hasNext()) {
            entry = it.next();
        }
        return entry;
    }
}
