package com.umeng.socialize.p569a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import java.util.Map;

/* renamed from: com.umeng.socialize.a.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DataStore {

    /* renamed from: a */
    private static volatile DataStore f39296a;

    /* renamed from: b */
    private final SharedPreferences f39297b = ContextUtil.getContext().getSharedPreferences("um_social_azx", 0);

    private DataStore() {
    }

    /* renamed from: a */
    public static DataStore m13432a() {
        if (f39296a == null) {
            synchronized (DataStore.class) {
                if (f39296a == null) {
                    f39296a = new DataStore();
                }
            }
        }
        return f39296a;
    }

    /* renamed from: b */
    public String m13427b(String str, String str2) {
        return this.f39297b.getString(str, str2);
    }

    /* renamed from: b */
    public Map<String, ?> m13428b() {
        return this.f39297b.getAll();
    }

    /* renamed from: a */
    public void m13430a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f39297b.edit().putString(str, str2).apply();
    }

    /* renamed from: a */
    public int m13429a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        SharedPreferences.Editor edit = this.f39297b.edit();
        int i = 0;
        for (String str : strArr) {
            if (this.f39297b.contains(str)) {
                edit.remove(str);
                i++;
            }
        }
        if (i > 0) {
            edit.apply();
        }
        return i;
    }

    /* renamed from: a */
    public void m13431a(String str) {
        if (this.f39297b.contains(str)) {
            this.f39297b.edit().remove(str).apply();
        }
    }
}
