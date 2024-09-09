package com.acse.ottn;

import android.view.animation.Interpolator;
import com.acse.ottn.u1;
import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class r1 extends v1 {

    /* renamed from: g  reason: collision with root package name */
    public int f6196g;

    /* renamed from: h  reason: collision with root package name */
    public int f6197h;

    /* renamed from: i  reason: collision with root package name */
    public int f6198i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f6199j;

    public r1(u1.b... bVarArr) {
        super(bVarArr);
        this.f6199j = true;
    }

    @Override // com.acse.ottn.v1
    /* renamed from: b */
    public r1 clone() {
        ArrayList<u1> arrayList = this.f6909e;
        int size = arrayList.size();
        u1.b[] bVarArr = new u1.b[size];
        for (int i4 = 0; i4 < size; i4++) {
            bVarArr[i4] = (u1.b) arrayList.get(i4).clone();
        }
        return new r1(bVarArr);
    }

    @Override // com.acse.ottn.v1
    public Object a(float f4) {
        return Integer.valueOf(b(f4));
    }

    public int b(float f4) {
        int i4 = this.f6905a;
        if (i4 == 2) {
            if (this.f6199j) {
                this.f6199j = false;
                this.f6196g = ((u1.b) this.f6909e.get(0)).h();
                int h4 = ((u1.b) this.f6909e.get(1)).h();
                this.f6197h = h4;
                this.f6198i = h4 - this.f6196g;
            }
            Interpolator interpolator = this.f6908d;
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            f4 f4Var = this.f6910f;
            if (f4Var == null) {
                return this.f6196g + ((int) (f4 * this.f6198i));
            }
            return ((Number) f4Var.evaluate(f4, Integer.valueOf(this.f6196g), Integer.valueOf(this.f6197h))).intValue();
        } else if (f4 <= 0.0f) {
            u1.b bVar = (u1.b) this.f6909e.get(0);
            u1.b bVar2 = (u1.b) this.f6909e.get(1);
            int h5 = bVar.h();
            int h6 = bVar2.h();
            float b4 = bVar.b();
            float b5 = bVar2.b();
            Interpolator c4 = bVar2.c();
            if (c4 != null) {
                f4 = c4.getInterpolation(f4);
            }
            float f5 = (f4 - b4) / (b5 - b4);
            f4 f4Var2 = this.f6910f;
            return f4Var2 == null ? h5 + ((int) (f5 * (h6 - h5))) : ((Number) f4Var2.evaluate(f5, Integer.valueOf(h5), Integer.valueOf(h6))).intValue();
        } else if (f4 >= 1.0f) {
            u1.b bVar3 = (u1.b) this.f6909e.get(i4 - 2);
            u1.b bVar4 = (u1.b) this.f6909e.get(this.f6905a - 1);
            int h7 = bVar3.h();
            int h8 = bVar4.h();
            float b6 = bVar3.b();
            float b7 = bVar4.b();
            Interpolator c5 = bVar4.c();
            if (c5 != null) {
                f4 = c5.getInterpolation(f4);
            }
            float f6 = (f4 - b6) / (b7 - b6);
            f4 f4Var3 = this.f6910f;
            return f4Var3 == null ? h7 + ((int) (f6 * (h8 - h7))) : ((Number) f4Var3.evaluate(f6, Integer.valueOf(h7), Integer.valueOf(h8))).intValue();
        } else {
            u1.b bVar5 = (u1.b) this.f6909e.get(0);
            int i5 = 1;
            while (true) {
                int i6 = this.f6905a;
                if (i5 < i6) {
                    u1.b bVar6 = (u1.b) this.f6909e.get(i5);
                    if (f4 < bVar6.b()) {
                        Interpolator c6 = bVar6.c();
                        if (c6 != null) {
                            f4 = c6.getInterpolation(f4);
                        }
                        float b8 = (f4 - bVar5.b()) / (bVar6.b() - bVar5.b());
                        int h9 = bVar5.h();
                        int h10 = bVar6.h();
                        f4 f4Var4 = this.f6910f;
                        return f4Var4 == null ? h9 + ((int) (b8 * (h10 - h9))) : ((Number) f4Var4.evaluate(b8, Integer.valueOf(h9), Integer.valueOf(h10))).intValue();
                    }
                    i5++;
                    bVar5 = bVar6;
                } else {
                    return ((Number) this.f6909e.get(i6 - 1).e()).intValue();
                }
            }
        }
    }
}
