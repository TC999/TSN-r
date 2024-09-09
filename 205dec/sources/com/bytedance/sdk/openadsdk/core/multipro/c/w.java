package com.bytedance.sdk.openadsdk.core.multipro.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.core.ev;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements ITTProvider {

    /* renamed from: c  reason: collision with root package name */
    private Context f33968c;

    private boolean c(Uri uri) {
        boolean z3 = uri == null || TextUtils.isEmpty(uri.getPath());
        if (z3) {
            a.w("DBMultiProviderImpl", "==check uri is null==");
        }
        return z3;
    }

    private Context getContext() {
        Context context = this.f33968c;
        return context == null ? ls.getContext() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        String[] split;
        if (!c(uri) && (split = uri.getPath().split(TTPathConst.sSeparator)) != null && split.length >= 4) {
            String str2 = split[2];
            String str3 = split[3];
            if ("ttopensdk.db".equals(str2)) {
                return ev.c(getContext()).c().delete(str3, str, strArr);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        String[] split;
        if (!c(uri) && (split = uri.getPath().split(TTPathConst.sSeparator)) != null && split.length >= 5) {
            String str = split[2];
            String str2 = split[3];
            String str3 = split[4];
            if ("ttopensdk.db".equals(str)) {
                if ("execSQL".equals(str3)) {
                    String queryParameter = uri.getQueryParameter("sql");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        ev.c(getContext()).c().c(Uri.decode(queryParameter));
                    }
                } else if ("transactionBegin".equals(str3)) {
                    ev.c(getContext()).c().xv();
                } else if ("transactionSetSuccess".equals(str3)) {
                    ev.c(getContext()).c().sr();
                } else if ("transactionEnd".equals(str3)) {
                    ev.c(getContext()).c().ux();
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        this.f33968c = context;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        String[] split;
        if (!c(uri) && (split = uri.getPath().split(TTPathConst.sSeparator)) != null && split.length >= 4) {
            String str = split[2];
            String str2 = split[3];
            if ("ttopensdk.db".equals(str)) {
                ev.c(getContext()).c().insert(str2, null, contentValues);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] split;
        if (!c(uri) && (split = uri.getPath().split(TTPathConst.sSeparator)) != null && split.length >= 4) {
            String str3 = split[2];
            String str4 = split[3];
            if ("ttopensdk.db".equals(str3)) {
                return ev.c(getContext()).c().query(str4, strArr, str, strArr2, null, null, str2);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String[] split;
        if (!c(uri) && (split = uri.getPath().split(TTPathConst.sSeparator)) != null && split.length >= 4) {
            String str2 = split[2];
            String str3 = split[3];
            if ("ttopensdk.db".equals(str2)) {
                return ev.c(getContext()).c().update(str3, contentValues, str, strArr);
            }
        }
        return 0;
    }
}
