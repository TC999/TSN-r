package com.bytedance.msdk.f.xv.c.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.xv.p;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.sdk.component.log.impl.core.multi.EventProviderImpl;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private final c f28372c = new c(new EventProviderImpl());

    /* renamed from: w  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.multipro.c f28373w = new com.bytedance.sdk.openadsdk.core.multipro.c(new com.bytedance.sdk.component.r.w.w.w.c("csj_mediation"));
    private ITTProvider xv;

    private ITTProvider c(Uri uri) {
        if (uri == null) {
            return null;
        }
        String[] split = uri.getPath().split(TTPathConst.sSeparator);
        if (split.length < 2) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "uri is error2");
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "uri is error3");
            return null;
        }
        if (this.xv == null) {
            sr srVar = new sr();
            this.xv = srVar;
            srVar.init();
        }
        if (str.equals(this.xv.getTableName())) {
            return this.xv;
        }
        if (p.c()) {
            if (str.equals(this.f28373w.getTableName())) {
                return this.f28373w;
            }
        } else if (str.equals(this.f28372c.getTableName())) {
            return this.f28372c;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "uri is error4");
        return null;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        ITTProvider c4 = c(uri);
        if (c4 != null) {
            return c4.delete(uri, str, strArr);
        }
        return 0;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        ITTProvider c4 = c(uri);
        if (c4 != null) {
            return c4.getType(uri);
        }
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        ITTProvider c4 = c(uri);
        if (c4 != null) {
            return c4.insert(uri, contentValues);
        }
        return null;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        ITTProvider c4 = c(uri);
        if (c4 != null) {
            return c4.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        ITTProvider c4 = c(uri);
        if (c4 != null) {
            return c4.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
