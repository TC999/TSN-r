package com.qq.e.dl.f;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import com.qq.e.dl.f.h;
import com.qq.e.dl.k.n;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class l extends h.a {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a extends Property<com.qq.e.dl.l.h, Float> {

        /* renamed from: a  reason: collision with root package name */
        private com.qq.e.dl.i.a f46865a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f46866b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* renamed from: com.qq.e.dl.f.l$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class C0914a implements n.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Float f46867a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.qq.e.dl.l.h f46868b;

            C0914a(Float f4, com.qq.e.dl.l.h hVar) {
                this.f46867a = f4;
                this.f46868b = hVar;
            }

            @Override // com.qq.e.dl.k.n.d
            public void a(Object[] objArr) {
                int[] iArr = (int[]) objArr[0];
                float[] fArr = (float[]) objArr[2];
                if (fArr == null) {
                    fArr = new float[]{0.0f, 1.0f};
                }
                int[] iArr2 = new int[4];
                float[] fArr2 = new float[4];
                float f4 = fArr[0];
                float f5 = fArr[1];
                float f6 = f5 - f4;
                if (a.this.f46866b) {
                    iArr2[0] = iArr[0];
                    iArr2[1] = iArr[0];
                    iArr2[2] = iArr[1];
                    iArr2[3] = iArr[1];
                    fArr2[0] = f4;
                    if (this.f46867a.floatValue() <= 0.5d) {
                        fArr2[1] = f4;
                        fArr2[2] = (this.f46867a.floatValue() * 2.0f * f6) + f4;
                    } else {
                        fArr2[1] = ((this.f46867a.floatValue() - 0.5f) * 2.0f * f6) + f4;
                        fArr2[2] = f5;
                    }
                    fArr2[3] = f5;
                } else {
                    iArr2[0] = iArr[0];
                    iArr2[1] = iArr[0];
                    iArr2[2] = iArr[1];
                    iArr2[3] = iArr[1];
                    fArr2[0] = f4;
                    if (this.f46867a.floatValue() <= 0.5f) {
                        fArr2[1] = f5 - ((this.f46867a.floatValue() * 2.0f) * f6);
                        fArr2[2] = f5;
                    } else {
                        fArr2[1] = f4;
                        fArr2[2] = f5 - (((this.f46867a.floatValue() - 0.5f) * 2.0f) * f6);
                    }
                    fArr2[3] = f5;
                }
                objArr[0] = iArr2;
                objArr[2] = fArr2;
                this.f46868b.a(objArr);
            }
        }

        public a(Class<Float> cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Float f4) {
            JSONArray b4;
            com.qq.e.dl.i.a aVar = this.f46865a;
            if (aVar == null || hVar == null || (b4 = hVar.b(aVar)) == null || b4.length() <= 0) {
                return;
            }
            com.qq.e.dl.k.n.a(com.qq.e.dl.k.l.c(b4.opt(0)), hVar.a().c(), new C0914a(f4, hVar));
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(com.qq.e.dl.l.h hVar) {
            return Float.valueOf(0.0f);
        }
    }

    @Override // com.qq.e.dl.f.h.a
    PropertyValuesHolder[] a(com.qq.e.dl.i.a aVar) {
        Object opt;
        if (aVar == null) {
            return null;
        }
        a aVar2 = new a(Float.class, "backgroundGradient");
        aVar2.f46865a = aVar;
        JSONArray jSONArray = aVar.f46910c;
        if (jSONArray == null || jSONArray.length() != 2 || (opt = jSONArray.opt(1)) == null) {
            return null;
        }
        aVar2.f46866b = Integer.parseInt(opt.toString()) == 0;
        return new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(aVar2, 0.0f, 1.0f)};
    }
}
