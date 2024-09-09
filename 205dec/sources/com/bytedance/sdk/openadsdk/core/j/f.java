package com.bytedance.sdk.openadsdk.core.j;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.q;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class f {

    /* renamed from: c  reason: collision with root package name */
    private static final String f33803c = "f";

    /* renamed from: w  reason: collision with root package name */
    private final Set<String> f33804w = new HashSet(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.j.f$5  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f33811c;

        static {
            int[] iArr = new int[sr.values().length];
            f33811c = iArr;
            try {
                iArr[sr.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33811c[sr.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33811c[sr.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract void c();

    public abstract void c(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean c(String str, int i4) {
        if (i4 == 0) {
            return c(str, sr.GRANTED);
        }
        return c(str, sr.DENIED);
    }

    public synchronized boolean w(String str) {
        String str2 = f33803c;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean c(final String str, sr srVar) {
        this.f33804w.remove(str);
        int i4 = AnonymousClass5.f33811c[srVar.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.f.2
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.c(str);
                    }
                });
                return true;
            } else if (i4 == 3) {
                if (w(str)) {
                    if (this.f33804w.isEmpty()) {
                        q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.f.3
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.c();
                            }
                        });
                        return true;
                    }
                } else {
                    q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.c(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.f33804w.isEmpty()) {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.c();
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void c(String[] strArr) {
        Collections.addAll(this.f33804w, strArr);
    }
}
