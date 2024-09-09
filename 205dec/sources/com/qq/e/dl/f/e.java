package com.qq.e.dl.f;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import com.qq.e.dl.f.h;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class e extends h.a {

    /* renamed from: b  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, Integer> f46835b = new a(this, Integer.class, "borderWidth");

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends Property<com.qq.e.dl.l.h, Integer> {
        a(e eVar, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Integer num) {
            hVar.g(num.intValue());
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(com.qq.e.dl.l.h hVar) {
            return 0;
        }
    }

    @Override // com.qq.e.dl.f.h.a
    PropertyValuesHolder[] a(com.qq.e.dl.i.a aVar) {
        JSONArray jSONArray = aVar.f46910c;
        if (jSONArray.length() < 2) {
            return null;
        }
        return new PropertyValuesHolder[]{PropertyValuesHolder.ofInt(this.f46835b, com.qq.e.dl.k.l.c(jSONArray.opt(0)).a(new JSONObject[0]), com.qq.e.dl.k.l.c(jSONArray.opt(1)).a(new JSONObject[0]))};
    }
}
