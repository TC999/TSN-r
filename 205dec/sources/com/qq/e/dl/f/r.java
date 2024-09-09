package com.qq.e.dl.f;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.qq.e.dl.f.h;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class r extends h.a {

    /* renamed from: b  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, Float> f46887b = new a(this, Float.class, "translationX");

    /* renamed from: c  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, Float> f46888c = new b(this, Float.class, "translationY");

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends Property<com.qq.e.dl.l.h, Float> {
        a(r rVar, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            hVar.b(f4, (Float) null);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            View m4 = hVar.m();
            return Float.valueOf(m4 == null ? 0.0f : m4.getTranslationX());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b extends Property<com.qq.e.dl.l.h, Float> {
        b(r rVar, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            hVar.b((Float) null, f4);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            View m4 = hVar.m();
            return Float.valueOf(m4 == null ? 0.0f : m4.getTranslationY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class c extends Property<com.qq.e.dl.l.h, Float> {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f46889a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f46890b;

        /* renamed from: c  reason: collision with root package name */
        private int f46891c;

        c(boolean z3, boolean z4) {
            super(Float.class, "translation");
            this.f46890b = z3;
            this.f46889a = z4;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            View view;
            if (this.f46891c <= 0) {
                View m4 = hVar.m();
                if (m4 == null || (view = (View) m4.getParent()) == null) {
                    return;
                }
                int width = this.f46889a ? view.getWidth() : view.getHeight();
                this.f46891c = width;
                if (width <= 0) {
                    return;
                }
            }
            Float valueOf = Float.valueOf(f4.floatValue() * this.f46891c);
            if (this.f46890b) {
                hVar.b(valueOf, (Float) null);
            } else {
                hVar.b((Float) null, valueOf);
            }
        }
    }

    @Override // com.qq.e.dl.f.h.a
    PropertyValuesHolder[] a(com.qq.e.dl.i.a aVar) {
        JSONArray jSONArray = aVar.f46910c;
        if (jSONArray.length() < 2) {
            return null;
        }
        PropertyValuesHolder a4 = a(true, jSONArray);
        PropertyValuesHolder a5 = a(false, jSONArray);
        if (a4 == null && a5 == null) {
            return null;
        }
        return (a4 == null || a5 == null) ? a4 != null ? new PropertyValuesHolder[]{a4} : new PropertyValuesHolder[]{a5} : new PropertyValuesHolder[]{a4, a5};
    }

    private PropertyValuesHolder a(boolean z3, JSONArray jSONArray) {
        boolean booleanValue;
        int i4 = z3 ? 0 : 2;
        if (jSONArray.length() <= i4) {
            return null;
        }
        com.qq.e.dl.k.i f4 = com.qq.e.dl.k.l.c(jSONArray.opt(i4)).f(new JSONObject[0]);
        com.qq.e.dl.k.i f5 = com.qq.e.dl.k.l.c(jSONArray.opt(i4 + 1)).f(new JSONObject[0]);
        Boolean valueOf = f4.c() ? Boolean.valueOf(f4.a()) : null;
        Boolean valueOf2 = f5.c() ? Boolean.valueOf(f5.a()) : null;
        if (valueOf == null && valueOf2 == null) {
            return PropertyValuesHolder.ofFloat(z3 ? this.f46887b : this.f46888c, f4.d(), f5.d());
        }
        if (valueOf == null) {
            if (f4.b() != 0.0f) {
                return null;
            }
            booleanValue = valueOf2.booleanValue();
        } else if (valueOf2 == null) {
            if (f5.b() != 0.0f) {
                return null;
            }
            booleanValue = valueOf.booleanValue();
        } else if (valueOf != valueOf2) {
            return null;
        } else {
            booleanValue = valueOf.booleanValue();
        }
        return PropertyValuesHolder.ofFloat(new c(z3, booleanValue), f4.b() / 100.0f, f5.b() / 100.0f);
    }
}
