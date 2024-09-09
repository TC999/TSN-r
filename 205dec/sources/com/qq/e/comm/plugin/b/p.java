package com.qq.e.comm.plugin.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f42036a = new HashMap();

    public boolean a(String str) {
        Object obj;
        if (TextUtils.isEmpty(str) || (obj = this.f42036a.get(str)) == null) {
            return false;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int b(String str) {
        Object obj;
        if (TextUtils.isEmpty(str) || (obj = this.f42036a.get(str)) == null) {
            return 0;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return 0;
        }
    }

    public String c(String str) {
        Object obj;
        if (TextUtils.isEmpty(str) || (obj = this.f42036a.get(str)) == null) {
            return null;
        }
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public void a(String str, int i4) {
        a(str, Integer.valueOf(i4));
    }

    public void a(String str, boolean z3) {
        a(str, Boolean.valueOf(z3));
    }

    public void a(String str, String str2) {
        a(str, (Object) str2);
    }

    private void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.f42036a.put(str, obj);
    }
}
