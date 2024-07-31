package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CacheApi {

    /* renamed from: a */
    private static String f39540a = "CacheApi";

    /* renamed from: e */
    private static CacheApi f39541e;

    /* renamed from: b */
    private Handler f39542b;

    /* renamed from: c */
    private CacheExector f39543c = new CacheExector(m13255a());

    /* renamed from: d */
    private Context f39544d;

    private CacheApi(Context context) {
        this.f39544d = context;
    }

    /* renamed from: a */
    private String m13255a() {
        Context context = this.f39544d;
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getPath();
    }

    public static CacheApi get(Context context) {
        if (f39541e == null) {
            f39541e = new CacheApi(context);
        }
        return f39541e;
    }

    public double checkSize(String str) {
        CacheExector cacheExector = this.f39543c;
        return cacheExector == null ? Utils.DOUBLE_EPSILON : cacheExector.checkSize(str);
    }

    public boolean delete(String str) {
        CacheExector cacheExector = this.f39543c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.deleteFile(str);
    }

    public IReader read(String str, Class cls) {
        CacheExector cacheExector = this.f39543c;
        if (cacheExector == null) {
            return null;
        }
        return cacheExector.readFile(str, cls);
    }

    public boolean save(String str, String str2) {
        CacheExector cacheExector = this.f39543c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.save(str, str2);
    }
}
