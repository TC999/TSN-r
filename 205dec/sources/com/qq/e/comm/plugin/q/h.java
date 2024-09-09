package com.qq.e.comm.plugin.q;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    private static final String f45423b = "DynamicScript-" + h.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f45424a = new StringBuilder();

    private h() {
    }

    private static String a(Object obj) {
        if (!(obj instanceof String)) {
            return obj == null ? "null" : obj.toString();
        }
        return "\"" + a((String) obj) + "\"";
    }

    public static h b() {
        return new h();
    }

    public h c() {
        this.f45424a.append("} ");
        return this;
    }

    public h d() {
        this.f45424a.append("} else ");
        return this;
    }

    public h b(String str, String str2, Object... objArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            StringBuilder sb = this.f45424a;
            sb.append(str);
            sb.append(".");
            sb.append(str2);
            sb.append('(');
            for (int i4 = 0; i4 < objArr.length; i4++) {
                this.f45424a.append(a(objArr[i4]));
                if (i4 < objArr.length - 1) {
                    this.f45424a.append(", ");
                }
            }
            this.f45424a.append("); ");
            return this;
        }
        d1.b(f45423b, "Function name cannot be null or empty.");
        return this;
    }

    private static String a(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    public h a(String str, String str2) {
        return b("typeof " + str + " !== 'undefined' && typeof " + str + "." + str2 + " === 'function' ");
    }

    public h a(String str, String str2, Object... objArr) {
        return a(str, str2).b(str, str2, objArr);
    }

    public h a(String str, Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return a("GDTEventBus", "emit").b("GDTEventBus", "emit", str);
        }
        Object[] objArr2 = new Object[objArr.length + 2];
        objArr2[0] = str;
        objArr2[1] = 0;
        System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
        return a("GDTEventBus", "emit").b("GDTEventBus", "emit", objArr2);
    }

    public h b(String str) {
        StringBuilder sb = this.f45424a;
        sb.append("if (");
        sb.append(str);
        sb.append(") {");
        return this;
    }

    public String a() {
        return this.f45424a.toString();
    }

    public Object a(com.qq.e.comm.dynamic.b bVar, com.qq.e.comm.plugin.n0.c cVar) {
        if (bVar != null) {
            String a4 = a();
            try {
                return bVar.b(a4);
            } catch (Throwable th) {
                d1.a(f45423b, "safeEvaluate script error", th);
                i.a(a4, cVar, th);
                return null;
            }
        }
        return null;
    }
}
