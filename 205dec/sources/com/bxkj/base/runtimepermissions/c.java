package com.bxkj.base.runtimepermissions;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PermissionsResultAction.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    private static final String f18313c = "c";

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f18314a;

    /* renamed from: b  reason: collision with root package name */
    private Looper f18315b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionsResultAction.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionsResultAction.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18317a;

        b(String str) {
            this.f18317a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f18317a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: com.bxkj.base.runtimepermissions.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class RunnableC0197c implements Runnable {
        RunnableC0197c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionsResultAction.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18320a;

        d(String str) {
            this.f18320a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f18320a);
        }
    }

    public c() {
        this.f18314a = new HashSet(1);
        this.f18315b = Looper.getMainLooper();
    }

    public abstract void a(String str);

    public abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public final synchronized boolean c(@NonNull String str, int i4) {
        if (i4 == 0) {
            return d(str, com.bxkj.base.runtimepermissions.a.GRANTED);
        }
        return d(str, com.bxkj.base.runtimepermissions.a.DENIED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public final synchronized boolean d(@NonNull String str, com.bxkj.base.runtimepermissions.a aVar) {
        this.f18314a.remove(str);
        if (aVar == com.bxkj.base.runtimepermissions.a.GRANTED) {
            if (this.f18314a.isEmpty()) {
                new Handler(this.f18315b).post(new a());
                return true;
            }
        } else if (aVar == com.bxkj.base.runtimepermissions.a.DENIED) {
            new Handler(this.f18315b).post(new b(str));
            return true;
        } else if (aVar == com.bxkj.base.runtimepermissions.a.NOT_FOUND) {
            if (f(str)) {
                if (this.f18314a.isEmpty()) {
                    new Handler(this.f18315b).post(new RunnableC0197c());
                    return true;
                }
            } else {
                new Handler(this.f18315b).post(new d(str));
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public final synchronized void e(@NonNull String[] strArr) {
        Collections.addAll(this.f18314a, strArr);
    }

    public synchronized boolean f(String str) {
        String str2 = f18313c;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    public c(@NonNull Looper looper) {
        this.f18314a = new HashSet(1);
        Looper.getMainLooper();
        this.f18315b = looper;
    }
}
