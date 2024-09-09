package com.qq.e.dl.f;

import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.util.Property;
import com.qq.e.dl.f.h;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d extends h.a {

    /* renamed from: b  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, Integer> f46832b = new a(this, Integer.class, "sameBorderRadius");

    /* renamed from: c  reason: collision with root package name */
    private final Property<com.qq.e.dl.l.h, int[]> f46833c = new b(this, int[].class, "diffBorderRadius");

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b extends Property<com.qq.e.dl.l.h, int[]> {
        b(d dVar, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, int[] iArr) {
            hVar.a(iArr);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public int[] get(com.qq.e.dl.l.h hVar) {
            return new int[4];
        }
    }

    @Override // com.qq.e.dl.f.h.a
    PropertyValuesHolder[] a(com.qq.e.dl.i.a aVar) {
        JSONArray jSONArray = aVar.f46910c;
        if (jSONArray.length() < 1) {
            return null;
        }
        Object opt = jSONArray.opt(0);
        if (JSONObject.NULL.equals(opt) || (opt instanceof JSONArray)) {
            return new PropertyValuesHolder[]{a(opt instanceof JSONArray ? (JSONArray) opt : null, jSONArray)};
        } else if (jSONArray.length() >= 2) {
            return new PropertyValuesHolder[]{a(opt, jSONArray)};
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends Property<com.qq.e.dl.l.h, Integer> {
        a(d dVar, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(com.qq.e.dl.l.h hVar, Integer num) {
            int intValue = num.intValue();
            hVar.a(new int[]{intValue, intValue, intValue, intValue});
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(com.qq.e.dl.l.h hVar) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements TypeEvaluator<int[]> {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f46834a;

        private c() {
            this.f46834a = new int[]{-1, -1, -1, -1};
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public int[] evaluate(float f4, int[] iArr, int[] iArr2) {
            int i4 = 0;
            while (true) {
                int[] iArr3 = this.f46834a;
                if (i4 >= iArr3.length) {
                    return iArr3;
                }
                int i5 = iArr[i4];
                if (i5 >= 0) {
                    iArr3[i4] = (int) (i5 + ((iArr2[i4] - i5) * f4));
                }
                i4++;
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    private PropertyValuesHolder a(Object obj, JSONArray jSONArray) {
        return PropertyValuesHolder.ofInt(this.f46832b, com.qq.e.dl.k.l.c(obj).f(new JSONObject[0]).d(), com.qq.e.dl.k.l.c(jSONArray.opt(1)).f(new JSONObject[0]).d());
    }

    private PropertyValuesHolder a(JSONArray jSONArray, JSONArray jSONArray2) {
        int[] iArr = {-1, -1, -1, -1};
        int[] iArr2 = {-1, -1, -1, -1};
        int min = Math.min(jSONArray2.length(), 4);
        int i4 = 0;
        do {
            if (jSONArray != null && jSONArray.length() > 1) {
                iArr[i4] = com.qq.e.dl.k.l.c(jSONArray.opt(0)).f(new JSONObject[0]).d();
                iArr2[i4] = com.qq.e.dl.k.l.c(jSONArray.opt(1)).f(new JSONObject[0]).d();
            }
            i4++;
            jSONArray = jSONArray2.optJSONArray(i4);
        } while (i4 < min);
        return PropertyValuesHolder.ofObject(this.f46833c, new c(null), iArr, iArr2);
    }
}
