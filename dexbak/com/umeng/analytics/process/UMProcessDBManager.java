package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.umeng.analytics.process.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class UMProcessDBManager {

    /* renamed from: a */
    private static UMProcessDBManager f38521a;

    /* renamed from: b */
    private ConcurrentHashMap<String, C13185a> f38522b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private Context f38523c;

    private UMProcessDBManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static UMProcessDBManager m14126a(Context context) {
        if (f38521a == null) {
            synchronized (UMProcessDBManager.class) {
                if (f38521a == null) {
                    f38521a = new UMProcessDBManager();
                }
            }
        }
        UMProcessDBManager uMProcessDBManager = f38521a;
        uMProcessDBManager.f38523c = context;
        return uMProcessDBManager;
    }

    /* renamed from: c */
    private C13185a m14123c(String str) {
        if (this.f38522b.get(str) == null) {
            C13185a m14121a = C13185a.m14121a(this.f38523c, str);
            this.f38522b.put(str, m14121a);
            return m14121a;
        }
        return this.f38522b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void m14124b(String str) {
        m14123c(str).m14120b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UMProcessDBManager.java */
    /* renamed from: com.umeng.analytics.process.c$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13185a {

        /* renamed from: a */
        private AtomicInteger f38524a = new AtomicInteger();

        /* renamed from: b */
        private SQLiteOpenHelper f38525b;

        /* renamed from: c */
        private SQLiteDatabase f38526c;

        private C13185a() {
        }

        /* renamed from: a */
        static C13185a m14121a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            C13185a c13185a = new C13185a();
            c13185a.f38525b = UMProcessDBCreater.m14129a(appContext, str);
            return c13185a;
        }

        /* renamed from: b */
        synchronized void m14120b() {
            try {
                if (this.f38524a.decrementAndGet() == 0) {
                    this.f38526c.close();
                }
            } catch (Throwable unused) {
            }
        }

        /* renamed from: a */
        synchronized SQLiteDatabase m14122a() {
            if (this.f38524a.incrementAndGet() == 1) {
                this.f38526c = this.f38525b.getWritableDatabase();
            }
            return this.f38526c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized SQLiteDatabase m14125a(String str) {
        return m14123c(str).m14122a();
    }
}
