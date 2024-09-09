package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements ITTProvider {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.component.r.w.w.w.c f33967c;

    public c(com.bytedance.sdk.component.r.w.w.w.c cVar) {
        this.f33967c = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.r.w.w.w.c cVar = this.f33967c;
        if (cVar != null) {
            return cVar.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        com.bytedance.sdk.component.r.w.w.w.c cVar = this.f33967c;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        a.c("wrapper getType1");
        com.bytedance.sdk.component.r.w.w.w.c cVar = this.f33967c;
        if (cVar != null) {
            return cVar.getType(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
        com.bytedance.sdk.component.r.w.w.w.c cVar = this.f33967c;
        if (cVar != null) {
            cVar.w();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        com.bytedance.sdk.component.r.w.w.w.c cVar = this.f33967c;
        if (cVar != null) {
            cVar.c(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.r.w.w.w.c cVar = this.f33967c;
        if (cVar != null) {
            return cVar.insert(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.r.w.w.w.c cVar = this.f33967c;
        if (cVar != null) {
            return cVar.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.r.w.w.w.c cVar = this.f33967c;
        if (cVar != null) {
            return cVar.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
