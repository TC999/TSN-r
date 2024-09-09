package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements ITTProvider {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.component.f.xv.c.sr f33981c = new com.bytedance.sdk.component.f.xv.c.sr();

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f33981c.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return this.f33981c.c();
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        return this.f33981c.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
        this.f33981c.w();
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        this.f33981c.c(context);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.f33981c.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.f33981c.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.f33981c.update(uri, contentValues, str, strArr);
    }
}
