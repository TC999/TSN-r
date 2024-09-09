package com.bytedance.msdk.f.xv.c.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.pangle.sdk.component.log.impl.core.multi.EventProviderImpl;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements ITTProvider {

    /* renamed from: c  reason: collision with root package name */
    private EventProviderImpl f28370c;

    public c(EventProviderImpl eventProviderImpl) {
        this.f28370c = eventProviderImpl;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        EventProviderImpl eventProviderImpl = this.f28370c;
        if (eventProviderImpl != null) {
            return eventProviderImpl.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        EventProviderImpl eventProviderImpl = this.f28370c;
        if (eventProviderImpl != null) {
            return eventProviderImpl.getTableName();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        com.bytedance.msdk.adapter.sr.xv.c("wrapper getType1");
        EventProviderImpl eventProviderImpl = this.f28370c;
        if (eventProviderImpl != null) {
            return eventProviderImpl.getType(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
        EventProviderImpl eventProviderImpl = this.f28370c;
        if (eventProviderImpl != null) {
            eventProviderImpl.init();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        EventProviderImpl eventProviderImpl = this.f28370c;
        if (eventProviderImpl != null) {
            eventProviderImpl.injectContext(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        EventProviderImpl eventProviderImpl = this.f28370c;
        if (eventProviderImpl != null) {
            return eventProviderImpl.insert(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        EventProviderImpl eventProviderImpl = this.f28370c;
        if (eventProviderImpl != null) {
            return eventProviderImpl.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        EventProviderImpl eventProviderImpl = this.f28370c;
        if (eventProviderImpl != null) {
            return eventProviderImpl.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
