package com.qq.e.lib.d;

import android.graphics.Color;
import com.qq.e.lib.d.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    private static final Comparator<b> f47366f = new C0925a();

    /* renamed from: a  reason: collision with root package name */
    final int[] f47367a;

    /* renamed from: b  reason: collision with root package name */
    final int[] f47368b;

    /* renamed from: c  reason: collision with root package name */
    final List<b.d> f47369c;

    /* renamed from: d  reason: collision with root package name */
    final b.c[] f47370d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f47371e = new float[3];

    /* compiled from: A */
    /* renamed from: com.qq.e.lib.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class C0925a implements Comparator<b> {
        C0925a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar2.g() - bVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private int f47372a;

        /* renamed from: b  reason: collision with root package name */
        private int f47373b;

        /* renamed from: c  reason: collision with root package name */
        private int f47374c;

        /* renamed from: d  reason: collision with root package name */
        private int f47375d;

        /* renamed from: e  reason: collision with root package name */
        private int f47376e;

        /* renamed from: f  reason: collision with root package name */
        private int f47377f;

        /* renamed from: g  reason: collision with root package name */
        private int f47378g;

        /* renamed from: h  reason: collision with root package name */
        private int f47379h;

        /* renamed from: i  reason: collision with root package name */
        private int f47380i;

        b(int i4, int i5) {
            this.f47372a = i4;
            this.f47373b = i5;
            c();
        }

        final boolean a() {
            return e() > 1;
        }

        final int b() {
            int f4 = f();
            a aVar = a.this;
            int[] iArr = aVar.f47367a;
            int[] iArr2 = aVar.f47368b;
            a.a(iArr, f4, this.f47372a, this.f47373b);
            Arrays.sort(iArr, this.f47372a, this.f47373b + 1);
            a.a(iArr, f4, this.f47372a, this.f47373b);
            int i4 = this.f47374c / 2;
            int i5 = this.f47372a;
            int i6 = 0;
            while (true) {
                int i7 = this.f47373b;
                if (i5 <= i7) {
                    i6 += iArr2[iArr[i5]];
                    if (i6 >= i4) {
                        return Math.min(i7 - 1, i5);
                    }
                    i5++;
                } else {
                    return this.f47372a;
                }
            }
        }

        final void c() {
            a aVar = a.this;
            int[] iArr = aVar.f47367a;
            int[] iArr2 = aVar.f47368b;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = Integer.MIN_VALUE;
            int i9 = Integer.MIN_VALUE;
            int i10 = 0;
            for (int i11 = this.f47372a; i11 <= this.f47373b; i11++) {
                int i12 = iArr[i11];
                i10 += iArr2[i12];
                int f4 = a.f(i12);
                int e4 = a.e(i12);
                int d4 = a.d(i12);
                if (f4 > i7) {
                    i7 = f4;
                }
                if (f4 < i4) {
                    i4 = f4;
                }
                if (e4 > i8) {
                    i8 = e4;
                }
                if (e4 < i5) {
                    i5 = e4;
                }
                if (d4 > i9) {
                    i9 = d4;
                }
                if (d4 < i6) {
                    i6 = d4;
                }
            }
            this.f47375d = i4;
            this.f47376e = i7;
            this.f47377f = i5;
            this.f47378g = i8;
            this.f47379h = i6;
            this.f47380i = i9;
            this.f47374c = i10;
        }

        final b.d d() {
            a aVar = a.this;
            int[] iArr = aVar.f47367a;
            int[] iArr2 = aVar.f47368b;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = this.f47372a; i8 <= this.f47373b; i8++) {
                int i9 = iArr[i8];
                int i10 = iArr2[i9];
                i7 += i10;
                i6 += a.f(i9) * i10;
                i5 += a.e(i9) * i10;
                i4 += i10 * a.d(i9);
            }
            float f4 = i7;
            return new b.d(a.a(Math.round(i6 / f4), Math.round(i5 / f4), Math.round(i4 / f4)), i7);
        }

        final int e() {
            return (this.f47373b + 1) - this.f47372a;
        }

        final int f() {
            int i4 = this.f47376e - this.f47375d;
            int i5 = this.f47378g - this.f47377f;
            int i6 = this.f47380i - this.f47379h;
            if (i4 < i5 || i4 < i6) {
                return (i5 < i4 || i5 < i6) ? -1 : -2;
            }
            return -3;
        }

        final int g() {
            return ((this.f47376e - this.f47375d) + 1) * ((this.f47378g - this.f47377f) + 1) * ((this.f47380i - this.f47379h) + 1);
        }

        final b h() {
            if (a()) {
                int b4 = b();
                b bVar = new b(b4 + 1, this.f47373b);
                this.f47373b = b4;
                c();
                return bVar;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int[] iArr, int i4, b.c[] cVarArr) {
        this.f47370d = cVarArr;
        int[] iArr2 = new int[32768];
        this.f47368b = iArr2;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int b4 = b(iArr[i5]);
            iArr[i5] = b4;
            iArr2[b4] = iArr2[b4] + 1;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0 && g(i7)) {
                iArr2[i7] = 0;
            }
            if (iArr2[i7] > 0) {
                i6++;
            }
        }
        int[] iArr3 = new int[i6];
        this.f47367a = iArr3;
        int i8 = 0;
        for (int i9 = 0; i9 < 32768; i9++) {
            if (iArr2[i9] > 0) {
                iArr3[i8] = i9;
                i8++;
            }
        }
        if (i6 <= i4) {
            this.f47369c = new ArrayList();
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = iArr3[i10];
                this.f47369c.add(new b.d(a(i11), iArr2[i11]));
            }
            return;
        }
        this.f47369c = c(i4);
    }

    private static int b(int i4) {
        return b(Color.blue(i4), 8, 5) | (b(Color.red(i4), 8, 5) << 10) | (b(Color.green(i4), 8, 5) << 5);
    }

    private static int b(int i4, int i5, int i6) {
        return (i6 > i5 ? i4 << (i6 - i5) : i4 >> (i5 - i6)) & ((1 << i6) - 1);
    }

    private List<b.d> c(int i4) {
        PriorityQueue<b> priorityQueue = new PriorityQueue<>(i4, f47366f);
        priorityQueue.offer(new b(0, this.f47367a.length - 1));
        a(priorityQueue, i4);
        return a(priorityQueue);
    }

    static int d(int i4) {
        return i4 & 31;
    }

    static int e(int i4) {
        return (i4 >> 5) & 31;
    }

    static int f(int i4) {
        return (i4 >> 10) & 31;
    }

    private boolean g(int i4) {
        int a4 = a(i4);
        com.qq.e.lib.c.a.a(a4, this.f47371e);
        return a(a4, this.f47371e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b.d> a() {
        return this.f47369c;
    }

    private void a(PriorityQueue<b> priorityQueue, int i4) {
        b poll;
        while (priorityQueue.size() < i4 && (poll = priorityQueue.poll()) != null && poll.a()) {
            priorityQueue.offer(poll.h());
            priorityQueue.offer(poll);
        }
    }

    private List<b.d> a(Collection<b> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (b bVar : collection) {
            b.d d4 = bVar.d();
            if (!a(d4)) {
                arrayList.add(d4);
            }
        }
        return arrayList;
    }

    static void a(int[] iArr, int i4, int i5, int i6) {
        if (i4 == -2) {
            while (i5 <= i6) {
                int i7 = iArr[i5];
                iArr[i5] = d(i7) | (e(i7) << 10) | (f(i7) << 5);
                i5++;
            }
        } else if (i4 != -1) {
        } else {
            while (i5 <= i6) {
                int i8 = iArr[i5];
                iArr[i5] = f(i8) | (d(i8) << 10) | (e(i8) << 5);
                i5++;
            }
        }
    }

    private boolean a(b.d dVar) {
        return a(dVar.e(), dVar.c());
    }

    private boolean a(int i4, float[] fArr) {
        b.c[] cVarArr = this.f47370d;
        if (cVarArr != null && cVarArr.length > 0) {
            int length = cVarArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                if (!this.f47370d[i5].a(i4, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int a(int i4, int i5, int i6) {
        return Color.rgb(b(i4, 5, 8), b(i5, 5, 8), b(i6, 5, 8));
    }

    private static int a(int i4) {
        return a(f(i4), e(i4), d(i4));
    }
}
