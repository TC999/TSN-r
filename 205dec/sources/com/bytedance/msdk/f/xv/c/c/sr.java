package com.bytedance.msdk.f.xv.c.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements ITTProvider {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.f.c.c f28371c;

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.msdk.f.c.c cVar = this.f28371c;
        if (cVar != null) {
            cVar.w(str, strArr);
            return 1;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "gromore_prime_rit_adn_perform";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
        if (com.bytedance.msdk.core.c.getContext() != null) {
            this.f28371c = new com.bytedance.msdk.f.c.c(com.bytedance.msdk.core.c.getContext());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.msdk.f.c.c cVar = this.f28371c;
        if (cVar != null) {
            cVar.c(contentValues);
            return uri;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, @Nullable String str, @Nullable String[] strArr2, String str2) {
        com.bytedance.msdk.f.c.c cVar = this.f28371c;
        if (cVar != null) {
            return cVar.c(str, strArr2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
