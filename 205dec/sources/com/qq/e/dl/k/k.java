package com.qq.e.dl.k;

import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k extends c {

    /* renamed from: a  reason: collision with root package name */
    private final g f47023a;

    /* renamed from: b  reason: collision with root package name */
    private final g f47024b;

    /* renamed from: c  reason: collision with root package name */
    private final g f47025c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f47026d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, g gVar2, g gVar3) {
        this.f47023a = gVar;
        this.f47024b = gVar2;
        this.f47025c = gVar3;
    }

    private boolean e(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return ((String) obj).length() == 0;
        } else if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        } else {
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            return (obj instanceof JSONArray) && ((JSONArray) obj).length() == 0;
        }
    }

    @Override // com.qq.e.dl.k.g
    public g a() {
        g gVar = this.f47024b;
        return new k(this.f47023a.a(), gVar == null ? null : gVar.a(), this.f47025c.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.dl.k.c
    public Object a(JSONObject jSONObject) {
        Object c4 = this.f47023a.c(jSONObject);
        boolean equals = JSONObject.NULL.equals(c4);
        if (!equals && !e(c4)) {
            g gVar = this.f47024b;
            if (gVar != null) {
                c4 = gVar.c(jSONObject);
            }
        } else {
            c4 = (equals && this.f47026d) ? null : this.f47025c.c(jSONObject);
        }
        this.f47026d = true;
        return c4;
    }
}
