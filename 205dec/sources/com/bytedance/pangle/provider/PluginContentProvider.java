package com.bytedance.pangle.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Keep;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class PluginContentProvider extends ContentProvider {
    protected Uri pluginUri;

    @Override // android.content.ContentProvider
    public abstract int delete(Uri uri, String str, String[] strArr);

    @Override // android.content.ContentProvider
    public abstract String getType(Uri uri);

    @Override // android.content.ContentProvider
    public abstract Uri insert(Uri uri, ContentValues contentValues);

    @Override // android.content.ContentProvider
    public abstract Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    @Override // android.content.ContentProvider
    public abstract int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
}
