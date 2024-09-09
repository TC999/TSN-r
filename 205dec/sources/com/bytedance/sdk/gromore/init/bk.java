package com.bytedance.sdk.gromore.init;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk implements ITTProvider {

    /* renamed from: c  reason: collision with root package name */
    private ITTProvider f31250c;

    /* renamed from: w  reason: collision with root package name */
    private ITTProvider f31251w = com.bytedance.msdk.f.xv.c.c.xv.c();

    public bk(ITTProvider iTTProvider) {
        this.f31250c = iTTProvider;
    }

    private boolean c(Uri uri) {
        if (uri == null) {
            return false;
        }
        String[] split = uri.getPath().split(TTPathConst.sSeparator);
        if (split.length < 2) {
            return false;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("gromore");
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (c(uri)) {
            return this.f31251w.delete(uri, str, strArr);
        }
        return this.f31250c.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        return (c(uri) ? this.f31251w : this.f31250c).getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        ITTProvider iTTProvider = this.f31250c;
        if (iTTProvider != null) {
            iTTProvider.injectContext(context);
        }
        ITTProvider iTTProvider2 = this.f31251w;
        if (iTTProvider2 != null) {
            iTTProvider2.injectContext(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (c(uri)) {
            return this.f31251w.insert(uri, contentValues);
        }
        return this.f31250c.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (c(uri)) {
            return this.f31251w.query(uri, strArr, str, strArr2, str2);
        }
        return this.f31250c.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (c(uri)) {
            return this.f31251w.update(uri, contentValues, str, strArr);
        }
        return this.f31250c.update(uri, contentValues, str, strArr);
    }
}
