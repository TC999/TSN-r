package com.bytedance.adsdk.w.w.w.c;

import com.bytedance.adsdk.w.w.sr.w;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class l implements r0.a {

    /* renamed from: a  reason: collision with root package name */
    private r0.a[] f26457a;

    /* renamed from: b  reason: collision with root package name */
    private String f26458b;

    /* renamed from: c  reason: collision with root package name */
    private o0.a f26459c;

    public l(String str) {
        this.f26458b = str;
    }

    public Object c(Map<String, JSONObject> map) {
        o0.a aVar = new o0.a();
        this.f26459c = aVar;
        aVar.b(this.f26458b);
        Object[] objArr = new Object[this.f26457a.length];
        int i4 = 0;
        while (true) {
            r0.a[] aVarArr = this.f26457a;
            if (i4 < aVarArr.length) {
                if (aVarArr[i4] != null) {
                    objArr[i4] = aVarArr[i4].c(map);
                }
                i4++;
            } else {
                this.f26459c.c(objArr);
                return this.f26459c;
            }
        }
    }

    public void d(r0.a[] aVarArr) {
        this.f26457a = aVarArr;
    }

    public String w() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f26458b);
        sb.append("(");
        r0.a[] aVarArr = this.f26457a;
        if (aVarArr != null && aVarArr.length > 0) {
            int i4 = 0;
            while (true) {
                r0.a[] aVarArr2 = this.f26457a;
                if (i4 >= aVarArr2.length) {
                    break;
                }
                sb.append(aVarArr2[i4].w());
                sb.append(",");
                i4++;
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public p0.a c() {
        return w.METHOD;
    }
}
