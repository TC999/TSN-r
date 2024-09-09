package com.qq.e.dl.k;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f47018a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f47019b;

    /* renamed from: c  reason: collision with root package name */
    private Float f47020c;

    /* renamed from: d  reason: collision with root package name */
    private String f47021d;

    /* renamed from: e  reason: collision with root package name */
    private i f47022e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Object obj) {
        this.f47018a = obj;
    }

    @Override // com.qq.e.dl.k.g
    public int a(JSONObject... jSONObjectArr) {
        i f4 = f(new JSONObject[0]);
        if (f4 == null) {
            return 0;
        }
        return f4.d();
    }

    @Override // com.qq.e.dl.k.g
    public g a() {
        return this;
    }

    @Override // com.qq.e.dl.k.g
    public int b(JSONObject... jSONObjectArr) {
        if (this.f47019b == null) {
            Integer b4 = super.b(this.f47018a);
            this.f47019b = Integer.valueOf(b4 == null ? 0 : b4.intValue());
        }
        return this.f47019b.intValue();
    }

    @Override // com.qq.e.dl.k.g
    public Object c(JSONObject... jSONObjectArr) {
        return this.f47018a;
    }

    @Override // com.qq.e.dl.k.g
    public float d(JSONObject... jSONObjectArr) {
        if (this.f47020c == null) {
            Float a4 = super.a(this.f47018a);
            this.f47020c = Float.valueOf(a4 == null ? 0.0f : a4.floatValue());
        }
        return this.f47020c.floatValue();
    }

    @Override // com.qq.e.dl.k.g
    public String e(JSONObject... jSONObjectArr) {
        if (this.f47021d == null) {
            this.f47021d = super.d(this.f47018a);
        }
        return this.f47021d;
    }

    public boolean equals(Object obj) {
        Object c4;
        if (this == obj) {
            return true;
        }
        if (this.f47018a == null) {
            if (obj != null) {
                return (obj instanceof j) && ((j) obj).c(new JSONObject[0]) == null;
            }
            return true;
        } else if (!(obj instanceof j) || (c4 = ((j) obj).c(new JSONObject[0])) == null) {
            return false;
        } else {
            Object obj2 = this.f47018a;
            if (c4 == obj2) {
                return true;
            }
            if ((obj2 instanceof Number) && (c4 instanceof Number)) {
                return (((obj2 instanceof Integer) || (obj2 instanceof Long)) && ((c4 instanceof Integer) || (c4 instanceof Long))) ? ((Number) this.f47018a).longValue() == ((Number) c4).longValue() : ((Number) this.f47018a).doubleValue() == ((Number) c4).doubleValue();
            }
            return toString().equals(obj.toString());
        }
    }

    @Override // com.qq.e.dl.k.g
    public i f(JSONObject... jSONObjectArr) {
        i iVar = this.f47022e;
        if (iVar == null) {
            i c4 = super.c(this.f47018a);
            this.f47022e = c4;
            return c4;
        }
        return iVar;
    }

    public String toString() {
        if (this.f47021d == null) {
            this.f47021d = super.d(this.f47018a);
        }
        return this.f47021d;
    }
}
