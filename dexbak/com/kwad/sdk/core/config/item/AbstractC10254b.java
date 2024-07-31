package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.config.C10249b;
import com.kwad.sdk.core.p385a.C9886c;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.config.item.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10254b<T> {
    private T atk;
    private T atl;
    private String mKey;

    public AbstractC10254b(String str, T t) {
        this(str, t, t);
    }

    /* renamed from: dk */
    public static String m26494dk(String str) {
        return !TextUtils.isEmpty(str) ? C9886c.m27439dH(str) : str;
    }

    /* renamed from: dl */
    public static String m26493dl(String str) {
        return (TextUtils.isEmpty(str) || !C9886c.m27437dJ(str)) ? str : C9886c.m27438dI(str);
    }

    /* renamed from: CH */
    public final T m26495CH() {
        return this.atk;
    }

    /* renamed from: a */
    public abstract void mo26480a(SharedPreferences sharedPreferences);

    /* renamed from: b */
    public abstract void mo26479b(SharedPreferences.Editor editor);

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.atl;
    }

    /* renamed from: k */
    public abstract void mo26478k(JSONObject jSONObject);

    public final void setValue(T t) {
        this.atl = t;
    }

    private AbstractC10254b(String str, T t, T t2) {
        this.mKey = str;
        this.atl = t;
        this.atk = t2;
        C10249b.m26598a(this);
    }
}
