package com.tencent.turingfd.sdk.ams.au;

import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class UrsaMinor {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f52206a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Pattern[] f52207b;

    static {
        int[] iArr = Cextends.f52288o;
        int[] iArr2 = Cextends.f52290p;
        int[] iArr3 = Cextends.f52292q;
        int[] iArr4 = Cextends.f52294r;
        int[] iArr5 = Cextends.f52296s;
        int[] iArr6 = Cextends.f52298t;
        int[] iArr7 = Cextends.f52300u;
        int[] iArr8 = Cextends.f52302v;
        int[] iArr9 = Cextends.f52306x;
        int[] iArr10 = Cextends.E;
        int[] iArr11 = Cextends.F;
        int[] iArr12 = Cextends.G;
        int[] iArr13 = Cextends.H;
        int[] iArr14 = Cextends.I;
        f52206a = new String[]{Cextends.a(iArr), Cextends.a(iArr2), Cextends.a(iArr3), Cextends.a(iArr4), Cextends.a(iArr5), Cextends.a(iArr6), Cextends.a(iArr7), Cextends.a(iArr8), Cextends.a(Cextends.f52304w), Cextends.a(iArr9), Cextends.a(Cextends.f52308y), Cextends.a(Cextends.f52310z), Cextends.a(Cextends.A), Cextends.a(Cextends.B), Cextends.a(Cextends.C), Cextends.a(Cextends.D), Cextends.a(iArr10), Cextends.a(iArr11), Cextends.a(iArr12), Cextends.a(iArr13), Cextends.a(iArr14)};
        Cextends.a(iArr);
        Cextends.a(iArr2);
        Cextends.a(iArr3);
        Cextends.a(iArr4);
        Cextends.a(iArr5);
        Cextends.a(iArr6);
        Cextends.a(iArr7);
        Cextends.a(iArr8);
        Cextends.a(iArr9);
        Cextends.a(iArr10);
        Cextends.a(iArr11);
        Cextends.a(iArr12);
        Cextends.a(iArr13);
        Cextends.a(iArr14);
        f52207b = null;
    }

    public static synchronized Pattern[] a() {
        synchronized (UrsaMinor.class) {
            if (f52207b != null) {
                return f52207b;
            }
            String[] strArr = f52206a;
            f52207b = new Pattern[strArr.length];
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < f52207b.length; i4++) {
                try {
                    arrayList.add(Pattern.compile(strArr[i4]));
                } catch (Throwable unused) {
                }
            }
            f52207b = (Pattern[]) arrayList.toArray(new Pattern[0]);
            return f52207b;
        }
    }
}
