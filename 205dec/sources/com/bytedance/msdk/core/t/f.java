package com.bytedance.msdk.core.t;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class f {

    /* renamed from: c  reason: collision with root package name */
    private static final String f28189c = "f";

    /* renamed from: w  reason: collision with root package name */
    private Looper f28190w = Looper.getMainLooper();
    private final Set<String> xv = new HashSet(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.msdk.core.t.f$5  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f28197c;

        static {
            int[] iArr = new int[sr.values().length];
            f28197c = iArr;
            try {
                iArr[sr.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28197c[sr.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28197c[sr.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract void c();

    public abstract void c(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean c(@NonNull String str, int i4) {
        if (i4 == 0) {
            return c(str, sr.GRANTED);
        }
        return c(str, sr.DENIED);
    }

    public synchronized boolean w(String str) {
        String str2 = f28189c;
        com.bytedance.msdk.adapter.sr.xv.w(str2, "permission not found:" + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean c(@NonNull final String str, sr srVar) {
        this.xv.remove(str);
        int i4 = AnonymousClass5.f28197c[srVar.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                new Handler(this.f28190w).post(new Runnable() { // from class: com.bytedance.msdk.core.t.f.2
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.c(str);
                    }
                });
                return true;
            } else if (i4 == 3) {
                if (w(str)) {
                    if (this.xv.isEmpty()) {
                        new Handler(this.f28190w).post(new Runnable() { // from class: com.bytedance.msdk.core.t.f.3
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.c();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.f28190w).post(new Runnable() { // from class: com.bytedance.msdk.core.t.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.c(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.xv.isEmpty()) {
            new Handler(this.f28190w).post(new Runnable() { // from class: com.bytedance.msdk.core.t.f.1
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
    public final synchronized void c(@NonNull String[] strArr) {
        Collections.addAll(this.xv, strArr);
    }
}
