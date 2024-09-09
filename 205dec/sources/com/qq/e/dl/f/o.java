package com.qq.e.dl.f;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.qq.e.dl.f.h;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class o extends h.a {

    /* renamed from: b  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, Float> f46879b = new a(this, Float.class, "scaleX");

    /* renamed from: c  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, Float> f46880c = new b(this, Float.class, "scaleY");

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends Property<com.qq.e.dl.l.h, Float> {
        a(o oVar, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            hVar.a(f4, (Float) null);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            View m4 = hVar.m();
            return Float.valueOf(m4 == null ? 1.0f : m4.getScaleX());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b extends Property<com.qq.e.dl.l.h, Float> {
        b(o oVar, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            hVar.a((Float) null, f4);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            View m4 = hVar.m();
            return Float.valueOf(m4 == null ? 1.0f : m4.getScaleY());
        }
    }

    @Override // com.qq.e.dl.f.h.a
    PropertyValuesHolder[] a(com.qq.e.dl.i.a aVar) {
        JSONArray jSONArray = aVar.f46910c;
        if (jSONArray.length() < 2) {
            return null;
        }
        PropertyValuesHolder a4 = a(this.f46879b, jSONArray);
        PropertyValuesHolder a5 = a(this.f46880c, jSONArray);
        if (a4 == null && a5 == null) {
            return null;
        }
        return (a4 == null || a5 == null) ? a4 != null ? new PropertyValuesHolder[]{a4} : new PropertyValuesHolder[]{a5} : new PropertyValuesHolder[]{a4, a5};
    }

    private PropertyValuesHolder a(Property<?, Float> property, JSONArray jSONArray) {
        int i4;
        if (this.f46879b == property) {
            i4 = 0;
        } else if (this.f46880c != property) {
            return null;
        } else {
            i4 = 2;
        }
        if (jSONArray.length() <= i4) {
            return null;
        }
        return PropertyValuesHolder.ofFloat(property, (float) jSONArray.optDouble(i4, 1.0d), (float) jSONArray.optDouble(i4 + 1, 1.0d));
    }
}
