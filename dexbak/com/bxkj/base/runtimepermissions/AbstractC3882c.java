package com.bxkj.base.runtimepermissions;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PermissionsResultAction.java */
/* renamed from: com.bxkj.base.runtimepermissions.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC3882c {

    /* renamed from: c */
    private static final String f14828c = "c";

    /* renamed from: a */
    private final Set<String> f14829a;

    /* renamed from: b */
    private Looper f14830b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: com.bxkj.base.runtimepermissions.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC3883a implements Runnable {
        RunnableC3883a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC3882c.this.m44156b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: com.bxkj.base.runtimepermissions.c$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC3884b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f14832a;

        RunnableC3884b(String str) {
            this.f14832a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC3882c.this.m44157a(this.f14832a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: com.bxkj.base.runtimepermissions.c$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC3885c implements Runnable {
        RunnableC3885c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC3882c.this.m44156b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: com.bxkj.base.runtimepermissions.c$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC3886d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f14835a;

        RunnableC3886d(String str) {
            this.f14835a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC3882c.this.m44157a(this.f14835a);
        }
    }

    public AbstractC3882c() {
        this.f14829a = new HashSet(1);
        this.f14830b = Looper.getMainLooper();
    }

    /* renamed from: a */
    public abstract void m44157a(String str);

    /* renamed from: b */
    public abstract void m44156b();

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    /* renamed from: c */
    public final synchronized boolean m44155c(@NonNull String str, int i) {
        if (i == 0) {
            return m44154d(str, EnumC3880a.GRANTED);
        }
        return m44154d(str, EnumC3880a.DENIED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    /* renamed from: d */
    public final synchronized boolean m44154d(@NonNull String str, EnumC3880a enumC3880a) {
        this.f14829a.remove(str);
        if (enumC3880a == EnumC3880a.GRANTED) {
            if (this.f14829a.isEmpty()) {
                new Handler(this.f14830b).post(new RunnableC3883a());
                return true;
            }
        } else if (enumC3880a == EnumC3880a.DENIED) {
            new Handler(this.f14830b).post(new RunnableC3884b(str));
            return true;
        } else if (enumC3880a == EnumC3880a.NOT_FOUND) {
            if (m44152f(str)) {
                if (this.f14829a.isEmpty()) {
                    new Handler(this.f14830b).post(new RunnableC3885c());
                    return true;
                }
            } else {
                new Handler(this.f14830b).post(new RunnableC3886d(str));
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    /* renamed from: e */
    public final synchronized void m44153e(@NonNull String[] strArr) {
        Collections.addAll(this.f14829a, strArr);
    }

    /* renamed from: f */
    public synchronized boolean m44152f(String str) {
        String str2 = f14828c;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    public AbstractC3882c(@NonNull Looper looper) {
        this.f14829a = new HashSet(1);
        Looper.getMainLooper();
        this.f14830b = looper;
    }
}
