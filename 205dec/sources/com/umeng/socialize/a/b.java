package com.umeng.socialize.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DataStore.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f53885a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f53886b = ContextUtil.getContext().getSharedPreferences("um_social_azx", 0);

    private b() {
    }

    public static b a() {
        if (f53885a == null) {
            synchronized (b.class) {
                if (f53885a == null) {
                    f53885a = new b();
                }
            }
        }
        return f53885a;
    }

    public String b(String str, String str2) {
        return this.f53886b.getString(str, str2);
    }

    public Map<String, ?> b() {
        return this.f53886b.getAll();
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f53886b.edit().putString(str, str2).apply();
    }

    public int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        SharedPreferences.Editor edit = this.f53886b.edit();
        int i4 = 0;
        for (String str : strArr) {
            if (this.f53886b.contains(str)) {
                edit.remove(str);
                i4++;
            }
        }
        if (i4 > 0) {
            edit.apply();
        }
        return i4;
    }

    public void a(String str) {
        if (this.f53886b.contains(str)) {
            this.f53886b.edit().remove(str).apply();
        }
    }
}
