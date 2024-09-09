package com.bytedance.msdk.f.xv.c.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements ITTProvider {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f28374c;

    /* renamed from: w  reason: collision with root package name */
    private w f28375w = new w();

    private xv() {
    }

    public static xv c() {
        if (f28374c == null) {
            synchronized (xv.class) {
                if (f28374c == null) {
                    f28374c = new xv();
                }
            }
        }
        return f28374c;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f28375w.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        return this.f28375w.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.f28375w.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.f28375w.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.f28375w.update(uri, contentValues, str, strArr);
    }
}
