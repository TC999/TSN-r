package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b<T> {
    private T atk;
    private T atl;
    private String mKey;

    public b(String str, T t3) {
        this(str, t3, t3);
    }

    public static String dk(String str) {
        return !TextUtils.isEmpty(str) ? com.kwad.sdk.core.a.c.dH(str) : str;
    }

    public static String dl(String str) {
        return (TextUtils.isEmpty(str) || !com.kwad.sdk.core.a.c.dJ(str)) ? str : com.kwad.sdk.core.a.c.dI(str);
    }

    public final T CH() {
        return this.atk;
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.atl;
    }

    public abstract void k(JSONObject jSONObject);

    public final void setValue(T t3) {
        this.atl = t3;
    }

    private b(String str, T t3, T t4) {
        this.mKey = str;
        this.atl = t3;
        this.atk = t4;
        com.kwad.sdk.core.config.b.a(this);
    }
}
