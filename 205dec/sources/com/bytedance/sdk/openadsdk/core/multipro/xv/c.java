package com.bytedance.sdk.openadsdk.core.multipro.xv;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.multipro.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements ITTProvider {

    /* renamed from: c  reason: collision with root package name */
    private Context f33982c;

    public static boolean c(String str) {
        if (ls.getContext() == null) {
            return false;
        }
        try {
            ContentResolver xv = xv();
            if (xv != null) {
                return "true".equals(xv.getType(Uri.parse(sr() + "checkFrequency?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private Context getContext() {
        Context context = this.f33982c;
        return context == null ? ls.getContext() : context;
    }

    private static String sr() {
        return ux.f33973w + TTPathConst.sSeparator + "t_frequent" + TTPathConst.sSeparator;
    }

    public static String w() {
        if (ls.getContext() == null) {
            return null;
        }
        try {
            ContentResolver xv = xv();
            if (xv != null) {
                return xv.getType(Uri.parse(sr() + "maxRit"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static ContentResolver xv() {
        try {
            if (ls.getContext() != null) {
                return ls.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        a.w("FrequentCallProviderImpl", "get type uri: " + String.valueOf(uri));
        String str = uri.getPath().split(TTPathConst.sSeparator)[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.bk.c.c().c(uri.getQueryParameter("rit")) ? "true" : "false";
        } else if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.bk.c.c().w() ? "true" : "false";
        } else if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.bk.c.c().xv();
        } else {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        this.f33982c = context;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static boolean c() {
        if (ls.getContext() == null) {
            return false;
        }
        try {
            ContentResolver xv = xv();
            if (xv != null) {
                return "true".equals(xv.getType(Uri.parse(sr() + "isSilent")));
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
