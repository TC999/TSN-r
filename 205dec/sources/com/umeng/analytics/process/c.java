package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMProcessDBManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f53192a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, a> f53193b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f53194c;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(Context context) {
        if (f53192a == null) {
            synchronized (c.class) {
                if (f53192a == null) {
                    f53192a = new c();
                }
            }
        }
        c cVar = f53192a;
        cVar.f53194c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f53193b.get(str) == null) {
            a a4 = a.a(this.f53194c, str);
            this.f53193b.put(str, a4);
            return a4;
        }
        return this.f53193b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(String str) {
        c(str).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMProcessDBManager.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f53195a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        private SQLiteOpenHelper f53196b;

        /* renamed from: c  reason: collision with root package name */
        private SQLiteDatabase f53197c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f53196b = b.a(appContext, str);
            return aVar;
        }

        synchronized void b() {
            try {
                if (this.f53195a.decrementAndGet() == 0) {
                    this.f53197c.close();
                }
            } catch (Throwable unused) {
            }
        }

        synchronized SQLiteDatabase a() {
            if (this.f53195a.incrementAndGet() == 1) {
                this.f53197c = this.f53196b.getWritableDatabase();
            }
            return this.f53197c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
