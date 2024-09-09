package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CacheApi {

    /* renamed from: a  reason: collision with root package name */
    private static String f54115a = "CacheApi";

    /* renamed from: e  reason: collision with root package name */
    private static CacheApi f54116e;

    /* renamed from: b  reason: collision with root package name */
    private Handler f54117b;

    /* renamed from: c  reason: collision with root package name */
    private CacheExector f54118c = new CacheExector(a());

    /* renamed from: d  reason: collision with root package name */
    private Context f54119d;

    private CacheApi(Context context) {
        this.f54119d = context;
    }

    private String a() {
        Context context = this.f54119d;
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getPath();
    }

    public static CacheApi get(Context context) {
        if (f54116e == null) {
            f54116e = new CacheApi(context);
        }
        return f54116e;
    }

    public double checkSize(String str) {
        CacheExector cacheExector = this.f54118c;
        if (cacheExector == null) {
            return 0.0d;
        }
        return cacheExector.checkSize(str);
    }

    public boolean delete(String str) {
        CacheExector cacheExector = this.f54118c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.deleteFile(str);
    }

    public IReader read(String str, Class cls) {
        CacheExector cacheExector = this.f54118c;
        if (cacheExector == null) {
            return null;
        }
        return cacheExector.readFile(str, cls);
    }

    public boolean save(String str, String str2) {
        CacheExector cacheExector = this.f54118c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.save(str, str2);
    }
}
