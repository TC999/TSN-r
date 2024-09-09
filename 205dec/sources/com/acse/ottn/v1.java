package com.acse.ottn;

import android.view.animation.Interpolator;
import com.acse.ottn.u1;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class v1 {

    /* renamed from: a  reason: collision with root package name */
    public int f6905a;

    /* renamed from: b  reason: collision with root package name */
    public u1 f6906b;

    /* renamed from: c  reason: collision with root package name */
    public u1 f6907c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f6908d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<u1> f6909e;

    /* renamed from: f  reason: collision with root package name */
    public f4 f6910f;

    public v1(u1... u1VarArr) {
        this.f6905a = u1VarArr.length;
        ArrayList<u1> arrayList = new ArrayList<>();
        this.f6909e = arrayList;
        arrayList.addAll(Arrays.asList(u1VarArr));
        this.f6906b = this.f6909e.get(0);
        u1 u1Var = this.f6909e.get(this.f6905a - 1);
        this.f6907c = u1Var;
        this.f6908d = u1Var.c();
    }

    public static v1 a(int... iArr) {
        int length = iArr.length;
        u1.b[] bVarArr = new u1.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (u1.b) u1.b(0.0f);
            bVarArr[1] = (u1.b) u1.a(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (u1.b) u1.a(0.0f, iArr[0]);
            for (int i4 = 1; i4 < length; i4++) {
                bVarArr[i4] = (u1.b) u1.a(i4 / (length - 1), iArr[i4]);
            }
        }
        return new r1(bVarArr);
    }

    public String toString() {
        String str = " ";
        for (int i4 = 0; i4 < this.f6905a; i4++) {
            str = str + this.f6909e.get(i4).e() + "  ";
        }
        return str;
    }

    public static v1 a(float... fArr) {
        int length = fArr.length;
        u1.a[] aVarArr = new u1.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (u1.a) u1.a(0.0f);
            aVarArr[1] = (u1.a) u1.a(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (u1.a) u1.a(0.0f, fArr[0]);
            for (int i4 = 1; i4 < length; i4++) {
                aVarArr[i4] = (u1.a) u1.a(i4 / (length - 1), fArr[i4]);
            }
        }
        return new c1(aVarArr);
    }

    public static v1 a(u1... u1VarArr) {
        int length = u1VarArr.length;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        for (u1 u1Var : u1VarArr) {
            if (u1Var instanceof u1.a) {
                z3 = true;
            } else if (u1Var instanceof u1.b) {
                z4 = true;
            } else {
                z5 = true;
            }
        }
        if (z3 && !z4 && !z5) {
            u1.a[] aVarArr = new u1.a[length];
            while (i4 < length) {
                aVarArr[i4] = (u1.a) u1VarArr[i4];
                i4++;
            }
            return new c1(aVarArr);
        } else if (z4 && !z3 && !z5) {
            u1.b[] bVarArr = new u1.b[length];
            while (i4 < length) {
                bVarArr[i4] = (u1.b) u1VarArr[i4];
                i4++;
            }
            return new r1(bVarArr);
        } else {
            return new v1(u1VarArr);
        }
    }

    public static v1 a(Object... objArr) {
        int length = objArr.length;
        u1.c[] cVarArr = new u1.c[Math.max(length, 2)];
        if (length == 1) {
            cVarArr[0] = (u1.c) u1.c(0.0f);
            cVarArr[1] = (u1.c) u1.a(1.0f, objArr[0]);
        } else {
            cVarArr[0] = (u1.c) u1.a(0.0f, objArr[0]);
            for (int i4 = 1; i4 < length; i4++) {
                cVarArr[i4] = (u1.c) u1.a(i4 / (length - 1), objArr[i4]);
            }
        }
        return new v1(cVarArr);
    }

    public void a(f4 f4Var) {
        this.f6910f = f4Var;
    }

    @Override // 
    /* renamed from: a */
    public v1 clone() {
        ArrayList<u1> arrayList = this.f6909e;
        int size = arrayList.size();
        u1[] u1VarArr = new u1[size];
        for (int i4 = 0; i4 < size; i4++) {
            u1VarArr[i4] = arrayList.get(i4).clone();
        }
        return new v1(u1VarArr);
    }

    public Object a(float f4) {
        int i4 = this.f6905a;
        if (i4 == 2) {
            Interpolator interpolator = this.f6908d;
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            return this.f6910f.evaluate(f4, this.f6906b.e(), this.f6907c.e());
        }
        int i5 = 1;
        if (f4 <= 0.0f) {
            u1 u1Var = this.f6909e.get(1);
            Interpolator c4 = u1Var.c();
            if (c4 != null) {
                f4 = c4.getInterpolation(f4);
            }
            float b4 = this.f6906b.b();
            return this.f6910f.evaluate((f4 - b4) / (u1Var.b() - b4), this.f6906b.e(), u1Var.e());
        } else if (f4 >= 1.0f) {
            u1 u1Var2 = this.f6909e.get(i4 - 2);
            Interpolator c5 = this.f6907c.c();
            if (c5 != null) {
                f4 = c5.getInterpolation(f4);
            }
            float b5 = u1Var2.b();
            return this.f6910f.evaluate((f4 - b5) / (this.f6907c.b() - b5), u1Var2.e(), this.f6907c.e());
        } else {
            u1 u1Var3 = this.f6906b;
            while (i5 < this.f6905a) {
                u1 u1Var4 = this.f6909e.get(i5);
                if (f4 < u1Var4.b()) {
                    Interpolator c6 = u1Var4.c();
                    if (c6 != null) {
                        f4 = c6.getInterpolation(f4);
                    }
                    float b6 = u1Var3.b();
                    return this.f6910f.evaluate((f4 - b6) / (u1Var4.b() - b6), u1Var3.e(), u1Var4.e());
                }
                i5++;
                u1Var3 = u1Var4;
            }
            return this.f6907c.e();
        }
    }
}
