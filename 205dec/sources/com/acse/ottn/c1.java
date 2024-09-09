package com.acse.ottn;

import android.view.animation.Interpolator;
import com.acse.ottn.u1;
import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c1 extends v1 {

    /* renamed from: g  reason: collision with root package name */
    public float f5334g;

    /* renamed from: h  reason: collision with root package name */
    public float f5335h;

    /* renamed from: i  reason: collision with root package name */
    public float f5336i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5337j;

    public c1(u1.a... aVarArr) {
        super(aVarArr);
        this.f5337j = true;
    }

    @Override // com.acse.ottn.v1
    /* renamed from: b */
    public c1 clone() {
        ArrayList<u1> arrayList = this.f6909e;
        int size = arrayList.size();
        u1.a[] aVarArr = new u1.a[size];
        for (int i4 = 0; i4 < size; i4++) {
            aVarArr[i4] = (u1.a) arrayList.get(i4).clone();
        }
        return new c1(aVarArr);
    }

    @Override // com.acse.ottn.v1
    public Object a(float f4) {
        return Float.valueOf(b(f4));
    }

    public float b(float f4) {
        int i4 = this.f6905a;
        if (i4 == 2) {
            if (this.f5337j) {
                this.f5337j = false;
                this.f5334g = ((u1.a) this.f6909e.get(0)).h();
                float h4 = ((u1.a) this.f6909e.get(1)).h();
                this.f5335h = h4;
                this.f5336i = h4 - this.f5334g;
            }
            Interpolator interpolator = this.f6908d;
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            f4 f4Var = this.f6910f;
            if (f4Var == null) {
                return this.f5334g + (f4 * this.f5336i);
            }
            return ((Number) f4Var.evaluate(f4, Float.valueOf(this.f5334g), Float.valueOf(this.f5335h))).floatValue();
        } else if (f4 <= 0.0f) {
            u1.a aVar = (u1.a) this.f6909e.get(0);
            u1.a aVar2 = (u1.a) this.f6909e.get(1);
            float h5 = aVar.h();
            float h6 = aVar2.h();
            float b4 = aVar.b();
            float b5 = aVar2.b();
            Interpolator c4 = aVar2.c();
            if (c4 != null) {
                f4 = c4.getInterpolation(f4);
            }
            float f5 = (f4 - b4) / (b5 - b4);
            f4 f4Var2 = this.f6910f;
            return f4Var2 == null ? h5 + (f5 * (h6 - h5)) : ((Number) f4Var2.evaluate(f5, Float.valueOf(h5), Float.valueOf(h6))).floatValue();
        } else if (f4 >= 1.0f) {
            u1.a aVar3 = (u1.a) this.f6909e.get(i4 - 2);
            u1.a aVar4 = (u1.a) this.f6909e.get(this.f6905a - 1);
            float h7 = aVar3.h();
            float h8 = aVar4.h();
            float b6 = aVar3.b();
            float b7 = aVar4.b();
            Interpolator c5 = aVar4.c();
            if (c5 != null) {
                f4 = c5.getInterpolation(f4);
            }
            float f6 = (f4 - b6) / (b7 - b6);
            f4 f4Var3 = this.f6910f;
            return f4Var3 == null ? h7 + (f6 * (h8 - h7)) : ((Number) f4Var3.evaluate(f6, Float.valueOf(h7), Float.valueOf(h8))).floatValue();
        } else {
            u1.a aVar5 = (u1.a) this.f6909e.get(0);
            int i5 = 1;
            while (true) {
                int i6 = this.f6905a;
                if (i5 < i6) {
                    u1.a aVar6 = (u1.a) this.f6909e.get(i5);
                    if (f4 < aVar6.b()) {
                        Interpolator c6 = aVar6.c();
                        if (c6 != null) {
                            f4 = c6.getInterpolation(f4);
                        }
                        float b8 = (f4 - aVar5.b()) / (aVar6.b() - aVar5.b());
                        float h9 = aVar5.h();
                        float h10 = aVar6.h();
                        f4 f4Var4 = this.f6910f;
                        return f4Var4 == null ? h9 + (b8 * (h10 - h9)) : ((Number) f4Var4.evaluate(b8, Float.valueOf(h9), Float.valueOf(h10))).floatValue();
                    }
                    i5++;
                    aVar5 = aVar6;
                } else {
                    return ((Number) this.f6909e.get(i6 - 1).e()).floatValue();
                }
            }
        }
    }
}
