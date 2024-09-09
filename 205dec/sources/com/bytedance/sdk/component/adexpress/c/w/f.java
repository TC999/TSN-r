package com.bytedance.sdk.component.adexpress.c.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static int f29024c = 2000;

    /* renamed from: w  reason: collision with root package name */
    private static volatile f f29025w;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.c.xv.xv> ux;
    private final Object sr = new Object();

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f29026f = new AtomicBoolean(false);

    /* renamed from: r  reason: collision with root package name */
    private LruCache<String, com.bytedance.sdk.component.adexpress.c.xv.w> f29027r = new LruCache<String, com.bytedance.sdk.component.adexpress.c.xv.w>(f29024c) { // from class: com.bytedance.sdk.component.adexpress.c.w.f.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: c */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.c.xv.w wVar) {
            return 1;
        }
    };
    private Set<String> xv = Collections.synchronizedSet(new HashSet());

    private f() {
    }

    public static f c() {
        if (f29025w == null) {
            synchronized (f.class) {
                if (f29025w == null) {
                    f29025w = new f();
                }
            }
        }
        return f29025w;
    }

    private void sr(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.c.xv.w> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.f29027r) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.sr) {
            this.f29027r.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<com.bytedance.sdk.component.adexpress.c.xv.w> w(String str) {
        com.bytedance.sdk.component.adexpress.c.xv.w wVar;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.c.c.c.c().w() == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor query = com.bytedance.sdk.component.adexpress.c.c.c.c().w().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex("id"));
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.sr) {
                                wVar = this.f29027r.get(string);
                            }
                            if (wVar != null) {
                                hashSet.add(wVar);
                            } else {
                                String string2 = query.getString(query.getColumnIndex("md5"));
                                String string3 = query.getString(query.getColumnIndex("url"));
                                String string4 = query.getString(query.getColumnIndex("data"));
                                com.bytedance.sdk.component.adexpress.c.xv.w c4 = new com.bytedance.sdk.component.adexpress.c.xv.w().c(str).w(string).xv(string2).sr(string3).ux(string4).f(query.getString(query.getColumnIndex("version"))).c(Long.valueOf(query.getLong(query.getColumnIndex("update_time"))));
                                hashSet.add(c4);
                                synchronized (this.sr) {
                                    this.f29027r.put(string, c4);
                                }
                                this.xv.add(string);
                            }
                        }
                    } while (query.moveToNext());
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                query.close();
                throw th;
            }
            query.close();
        }
        return hashSet;
    }

    void xv(String str) {
        com.bytedance.sdk.component.adexpress.c.xv.xv xvVar;
        try {
            if (this.ux == null || this.ux.isEmpty() || (xvVar = this.ux.get(str)) == null) {
                return;
            }
            String c4 = xvVar.c();
            if (!TextUtils.isEmpty(c4) && com.bytedance.sdk.component.adexpress.c.c.c.c().f() != null) {
                com.bytedance.sdk.component.adexpress.c.c.c.c().f().delete(c4, str);
            }
            this.ux.remove(str);
        } catch (Throwable unused) {
        }
    }

    public static String xv() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.component.adexpress.c.xv.w c(String str) {
        com.bytedance.sdk.component.adexpress.c.xv.w wVar;
        com.bytedance.sdk.component.adexpress.c.xv.w c4;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.c.c.c.c().w() == null) {
            return null;
        }
        synchronized (this.sr) {
            wVar = this.f29027r.get(String.valueOf(str));
        }
        if (wVar != null) {
            return wVar;
        }
        Cursor query = com.bytedance.sdk.component.adexpress.c.c.c.c().w().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex("rit"));
                        String string2 = query.getString(query.getColumnIndex("id"));
                        String string3 = query.getString(query.getColumnIndex("md5"));
                        String string4 = query.getString(query.getColumnIndex("url"));
                        String string5 = query.getString(query.getColumnIndex("data"));
                        c4 = new com.bytedance.sdk.component.adexpress.c.xv.w().c(string).w(string2).xv(string3).sr(string4).ux(string5).f(query.getString(query.getColumnIndex("version"))).c(Long.valueOf(query.getLong(query.getColumnIndex("update_time"))));
                        synchronized (this.sr) {
                            this.f29027r.put(string2, c4);
                        }
                        this.xv.add(string2);
                    } while (query.moveToNext());
                    return c4;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public List<com.bytedance.sdk.component.adexpress.c.xv.w> w() {
        if (com.bytedance.sdk.component.adexpress.c.c.c.c().w() == null) {
            return null;
        }
        boolean z3 = this.f29026f.get();
        this.f29026f.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor query = com.bytedance.sdk.component.adexpress.c.c.c.c().w().query("template_diff_new", null, null, null, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    String string = query.getString(query.getColumnIndex("rit"));
                    String string2 = query.getString(query.getColumnIndex("id"));
                    String string3 = query.getString(query.getColumnIndex("md5"));
                    String string4 = query.getString(query.getColumnIndex("url"));
                    String string5 = query.getString(query.getColumnIndex("data"));
                    String string6 = query.getString(query.getColumnIndex("version"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.c.xv.w().c(string).w(string2).xv(string3).sr(string4).ux(string5).f(string6).c(Long.valueOf(query.getLong(query.getColumnIndex("update_time")))));
                    synchronized (this.sr) {
                        this.f29027r.put(string2, arrayList.get(arrayList.size() - 1));
                    }
                    this.xv.add(string2);
                    if (!z3 && com.bytedance.sdk.component.adexpress.c.c.c.c().f() != null) {
                        if (this.ux == null) {
                            this.ux = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.ux.contains(string2)) {
                            this.ux.put(string2, new com.bytedance.sdk.component.adexpress.c.xv.xv(string, string2, string3));
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.sdk.component.adexpress.c.xv.w wVar, boolean z3) {
        if (wVar == null || com.bytedance.sdk.component.adexpress.c.c.c.c().w() == null || TextUtils.isEmpty(wVar.w())) {
            return;
        }
        Cursor query = com.bytedance.sdk.component.adexpress.c.c.c.c().w().query("template_diff_new", null, "id=?", new String[]{wVar.w()}, null, null, null);
        boolean z4 = query != null && query.getCount() > 0;
        if (query != null) {
            try {
                r3 = query.moveToFirst() ? query.getString(query.getColumnIndex("rit")) : null;
                query.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", wVar.c());
        contentValues.put("id", wVar.w());
        contentValues.put("md5", wVar.xv());
        contentValues.put("url", wVar.sr());
        contentValues.put("data", wVar.ux());
        contentValues.put("version", wVar.f());
        contentValues.put("update_time", wVar.r());
        if (z4) {
            com.bytedance.sdk.component.adexpress.c.c.c.c().w().update("template_diff_new", contentValues, "id=?", new String[]{wVar.w()});
        } else {
            com.bytedance.sdk.component.adexpress.c.c.c.c().w().insert("template_diff_new", contentValues);
        }
        synchronized (this.sr) {
            this.f29027r.put(wVar.w(), wVar);
        }
        this.xv.add(wVar.w());
        if (z3) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.c.c.c.c().f() == null) {
                return;
            }
            if (this.ux == null) {
                this.ux = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.c.xv.xv xvVar = new com.bytedance.sdk.component.adexpress.c.xv.xv(wVar.c(), wVar.w(), wVar.xv());
            this.ux.put(wVar.w(), xvVar);
            if (r3 != null) {
                com.bytedance.sdk.component.adexpress.c.c.c.c().f().delete(r3, xvVar.w());
            }
            com.bytedance.sdk.component.adexpress.c.c.c.c().f().update(wVar.c(), xvVar);
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.c.c.c.c().w() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i4 = 0; i4 < strArr.length; i4++) {
                sr(strArr[i4]);
                com.bytedance.sdk.component.adexpress.c.c.c.c().w().delete("template_diff_new", "id=?", new String[]{strArr[i4]});
                xv(strArr[i4]);
            }
        }
    }
}
