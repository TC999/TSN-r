package com.bykv.vk.openvk.component.video.c.w.w;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.gd.k;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: w  reason: collision with root package name */
    private static volatile xv f25154w;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Map<String, c>> f25155c;
    private final Executor sr;
    private volatile SQLiteStatement ux;
    private final sr xv;

    private xv(Context context) {
        SparseArray<Map<String, c>> sparseArray = new SparseArray<>(2);
        this.f25155c = sparseArray;
        this.sr = new com.bytedance.sdk.component.gd.sr.sr(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new k(5, "video_proxy_db"));
        this.xv = new sr(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public void delete(final String str, final int i4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, c> map = this.f25155c.get(i4);
        if (map != null) {
            map.remove(str);
        }
        this.sr.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.w.w.xv.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xv.this.xv.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i4)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void insert(final c cVar) {
        if (cVar != null) {
            Map<String, c> map = this.f25155c.get(cVar.sr);
            if (map != null) {
                map.put(cVar.f25147c, cVar);
            }
            this.sr.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.w.w.xv.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (xv.this.ux != null) {
                            xv.this.ux.clearBindings();
                        } else {
                            xv xvVar = xv.this;
                            xvVar.ux = xvVar.xv.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        xv.this.ux.bindString(1, cVar.f25147c);
                        xv.this.ux.bindString(2, cVar.f25148w);
                        xv.this.ux.bindLong(3, cVar.xv);
                        xv.this.ux.bindLong(4, cVar.sr);
                        xv.this.ux.bindString(5, cVar.ux);
                        xv.this.ux.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public c query(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, c> map = this.f25155c.get(i4);
        c cVar = map == null ? null : map.get(str);
        if (cVar != null) {
            return cVar;
        }
        try {
            Cursor query = this.xv.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i4)}, null, null, null, "1");
            if (query != null) {
                if (query.getCount() > 0 && query.moveToNext()) {
                    cVar = new c(query.getString(query.getColumnIndex(DomainCampaignEx.LOOPBACK_KEY)), query.getString(query.getColumnIndex("mime")), query.getInt(query.getColumnIndex("contentLength")), i4, query.getString(query.getColumnIndex("extra")));
                }
                query.close();
            }
            if (cVar != null && map != null) {
                map.put(str, cVar);
            }
            return cVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String w(int i4) {
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 << 1);
        sb.append("?");
        for (int i5 = 1; i5 < i4; i5++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static xv c(Context context) {
        if (f25154w == null) {
            synchronized (xv.class) {
                if (f25154w == null) {
                    f25154w = new xv(context);
                }
            }
        }
        return f25154w;
    }

    public void c(Collection<String> collection, int i4) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        int i5 = -1;
        Map<String, c> map = this.f25155c.get(i4);
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i5++;
            strArr[i5] = str;
        }
        strArr[i5 + 1] = String.valueOf(i4);
        try {
            SQLiteDatabase writableDatabase = this.xv.getWritableDatabase();
            writableDatabase.delete("video_http_header_t", "key IN(" + w(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void c(final int i4) {
        Map<String, c> map = this.f25155c.get(i4);
        if (map != null) {
            map.clear();
        }
        this.sr.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.c.w.w.xv.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xv.this.xv.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i4)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
