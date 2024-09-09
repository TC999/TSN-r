package com.bytedance.sdk.openadsdk.core.eq;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class eq {

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentHashMap<ViewGroup, Object> f33217c = new ConcurrentHashMap<>();

    /* renamed from: w  reason: collision with root package name */
    private static final Object f33218w = new Object();
    private static volatile boolean xv = false;

    private eq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
        if (r0.top < r1.top) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00db A[LOOP:1: B:41:0x0097->B:51:0x00db, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void sr() {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.eq.eq.sr():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0090, code lost:
        if (r0.top < r1.top) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void xv() {
        /*
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r0 = com.bytedance.sdk.openadsdk.core.eq.eq.f33217c
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L9
            return
        L9:
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.ls.getContext()
            int r1 = com.bytedance.sdk.openadsdk.core.eq.xk.ux(r1)
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            r5 = r3
            r6 = r5
            r4 = 2147483647(0x7fffffff, float:NaN)
        L22:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L77
            java.lang.Object r7 = r0.next()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            if (r7 != 0) goto L31
            goto L22
        L31:
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            boolean r9 = r7.getGlobalVisibleRect(r8)
            if (r9 != 0) goto L42
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r8 = com.bytedance.sdk.openadsdk.core.eq.eq.f33217c
            r8.remove(r7)
            goto L22
        L42:
            boolean r9 = com.bytedance.sdk.openadsdk.core.wx.c(r7)
            if (r9 != 0) goto L4e
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r8 = com.bytedance.sdk.openadsdk.core.eq.eq.f33217c
            r8.remove(r7)
            goto L22
        L4e:
            int r9 = r1 / 2
            int r10 = r8.bottom
            if (r10 > r9) goto L57
            int r11 = r9 - r10
            goto L5a
        L57:
            r11 = 2147483647(0x7fffffff, float:NaN)
        L5a:
            int r8 = r8.top
            if (r8 < r9) goto L61
            int r12 = r8 - r9
            goto L64
        L61:
            r12 = 2147483647(0x7fffffff, float:NaN)
        L64:
            if (r10 <= r9) goto L6a
            if (r8 >= r9) goto L6a
            r5 = r7
            goto L77
        L6a:
            int r8 = java.lang.Math.min(r12, r11)
            if (r8 >= r4) goto L73
            r5 = r7
            r4 = r8
            goto L22
        L73:
            if (r8 != r4) goto L22
            r6 = r7
            goto L22
        L77:
            if (r5 != 0) goto L7a
            return
        L7a:
            if (r6 == 0) goto L93
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.getGlobalVisibleRect(r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r6.getGlobalVisibleRect(r1)
            int r0 = r0.top
            int r1 = r1.top
            if (r0 >= r1) goto L93
            goto L94
        L93:
            r6 = r5
        L94:
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r0 = com.bytedance.sdk.openadsdk.core.eq.eq.f33217c
            java.lang.Object r1 = r0.get(r6)
            boolean r1 = r1 instanceof com.bytedance.sdk.openadsdk.core.w.xv
            if (r1 == 0) goto La5
            java.lang.Object r1 = r0.get(r6)
            r3 = r1
            com.bytedance.sdk.openadsdk.core.w.xv r3 = (com.bytedance.sdk.openadsdk.core.w.xv) r3
        La5:
            r1 = 1
            c(r6, r1)
            r0.clear()
            r0 = 0
            com.bytedance.sdk.openadsdk.core.eq.eq.xv = r0
            if (r3 == 0) goto Lb4
            r3.c()
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.eq.eq.xv():void");
    }

    public static void c(WeakReference<ViewGroup> weakReference, com.bytedance.sdk.openadsdk.core.w.xv xvVar) {
        if (weakReference == null || xvVar == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.bytedance.sdk.openadsdk.core.wx.c(viewGroup)) {
            c(viewGroup, false);
            return;
        }
        f33217c.put(viewGroup, xvVar);
        if (xv) {
            c(viewGroup, false);
            return;
        }
        synchronized (eq.class) {
            if (xv) {
                c(viewGroup, false);
                return;
            }
            xv = true;
            com.bytedance.sdk.openadsdk.core.q.f().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.eq.1
                @Override // java.lang.Runnable
                public void run() {
                    eq.xv();
                }
            }, 50L);
        }
    }

    public static boolean c(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag();
        if (tag instanceof Map) {
            Object obj = ((Map) tag).get("is_shake_efficient");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private static void c(ViewGroup viewGroup, boolean z3) {
        if (viewGroup == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_shake_efficient", Boolean.valueOf(z3));
        viewGroup.setTag(hashMap);
    }

    public static void c(WeakReference<ViewGroup> weakReference, float f4, float f5, long j4) {
        if (weakReference == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (com.bytedance.sdk.openadsdk.core.wx.c(viewGroup) && c(f4, f5, j4)) {
            f33217c.put(viewGroup, f33218w);
            if (xv) {
                return;
            }
            synchronized (eq.class) {
                if (xv) {
                    return;
                }
                xv = true;
                com.bytedance.sdk.openadsdk.core.q.f().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.eq.2
                    @Override // java.lang.Runnable
                    public void run() {
                        eq.sr();
                    }
                }, 50L);
            }
        }
    }

    private static boolean c(float f4, float f5, long j4) {
        if (f4 == -1.0f) {
            return true;
        }
        if (f4 < 0.0f) {
            return false;
        }
        if (f4 == 0.0f && f5 == 2.1474836E9f) {
            return true;
        }
        if (f5 <= f4) {
            return false;
        }
        float currentTimeMillis = ((float) (System.currentTimeMillis() - j4)) / 1000.0f;
        return currentTimeMillis >= f4 && currentTimeMillis <= f5;
    }
}
