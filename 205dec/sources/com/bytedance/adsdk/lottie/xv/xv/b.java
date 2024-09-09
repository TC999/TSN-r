package com.bytedance.adsdk.lottie.xv.xv;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.c.c.o;
import com.bytedance.adsdk.lottie.c.w.q;
import com.bytedance.adsdk.lottie.xv.c.m;
import com.bytedance.adsdk.lottie.xv.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b extends com.bytedance.adsdk.lottie.xv.xv.a {
    private final StringBuilder D;
    private final RectF E;
    private final Matrix F;
    private final Paint G;
    private final Paint H;
    private final Map<com.bytedance.adsdk.lottie.xv.d, List<o>> I;
    private final LongSparseArray<String> J;
    private final List<d> K;

    /* renamed from: L  reason: collision with root package name */
    private final q f25943L;
    private final com.bytedance.adsdk.lottie.d M;
    private final com.bytedance.adsdk.lottie.e N;
    private com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> O;
    private com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> P;
    private com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> Q;
    private com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> R;
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> S;
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> T;
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> U;
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> V;
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> W;
    private com.bytedance.adsdk.lottie.c.w.c<Typeface, Typeface> X;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class a extends Paint {
        a(int i4) {
            super(i4);
            setStyle(Paint.Style.FILL);
        }
    }

    /* renamed from: com.bytedance.adsdk.lottie.xv.xv.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class C0355b extends Paint {
        C0355b(int i4) {
            super(i4);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25946a;

        static {
            int[] iArr = new int[w.c.values().length];
            f25946a = iArr;
            try {
                iArr[w.c.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25946a[w.c.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25946a[w.c.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.bytedance.adsdk.lottie.d dVar, sr srVar) {
        super(dVar, srVar);
        m mVar;
        m mVar2;
        com.bytedance.adsdk.lottie.xv.c.c cVar;
        com.bytedance.adsdk.lottie.xv.c.c cVar2;
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        this.G = new a(1);
        this.H = new C0355b(1);
        this.I = new HashMap();
        this.J = new LongSparseArray<>();
        this.K = new ArrayList();
        this.M = dVar;
        this.N = srVar.c();
        q c4 = srVar.h().c();
        this.f25943L = c4;
        c4.f(this);
        l(c4);
        com.bytedance.adsdk.lottie.xv.c.g u3 = srVar.u();
        if (u3 != null && (cVar2 = u3.f25770a) != null) {
            com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> c5 = cVar2.c();
            this.O = c5;
            c5.f(this);
            l(this.O);
        }
        if (u3 != null && (cVar = u3.f25771b) != null) {
            com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> c6 = cVar.c();
            this.Q = c6;
            c6.f(this);
            l(this.Q);
        }
        if (u3 != null && (mVar2 = u3.f25772c) != null) {
            com.bytedance.adsdk.lottie.c.w.c<Float, Float> c7 = mVar2.c();
            this.S = c7;
            c7.f(this);
            l(this.S);
        }
        if (u3 == null || (mVar = u3.f25773d) == null) {
            return;
        }
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c8 = mVar.c();
        this.U = c8;
        c8.f(this);
        l(this.U);
    }

    private Typeface K(com.bytedance.adsdk.lottie.xv.f fVar) {
        Typeface j4;
        com.bytedance.adsdk.lottie.c.w.c<Typeface, Typeface> cVar = this.X;
        if (cVar == null || (j4 = cVar.j()) == null) {
            Typeface e4 = this.M.e(fVar);
            return e4 != null ? e4 : fVar.c();
        }
        return j4;
    }

    private d L(int i4) {
        for (int size = this.K.size(); size < i4; size++) {
            this.K.add(new d(null));
        }
        return this.K.get(i4 - 1);
    }

    private String M(String str, int i4) {
        int codePointAt = str.codePointAt(i4);
        int charCount = Character.charCount(codePointAt) + i4;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!a0(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j4 = codePointAt;
        if (this.J.indexOfKey(j4) >= 0) {
            return this.J.get(j4);
        }
        this.D.setLength(0);
        while (i4 < charCount) {
            int codePointAt3 = str.codePointAt(i4);
            this.D.appendCodePoint(codePointAt3);
            i4 += Character.charCount(codePointAt3);
        }
        String sb = this.D.toString();
        this.J.put(j4, sb);
        return sb;
    }

    private List<o> N(com.bytedance.adsdk.lottie.xv.d dVar) {
        if (this.I.containsKey(dVar)) {
            return this.I.get(dVar);
        }
        List<com.bytedance.adsdk.lottie.xv.w.e> b4 = dVar.b();
        int size = b4.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(new o(this.M, this, b4.get(i4), this.N));
        }
        this.I.put(dVar, arrayList);
        return arrayList;
    }

    private List<String> O(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private List<d> P(String str, float f4, com.bytedance.adsdk.lottie.xv.f fVar, float f5, float f6, boolean z3) {
        float measureText;
        float f7 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        boolean z4 = false;
        float f8 = 0.0f;
        int i6 = 0;
        float f9 = 0.0f;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char charAt = str.charAt(i7);
            if (z3) {
                com.bytedance.adsdk.lottie.xv.d dVar = this.N.n().get(com.bytedance.adsdk.lottie.xv.d.a(charAt, fVar.a(), fVar.e()));
                if (dVar != null) {
                    measureText = ((float) dVar.c()) * f5 * com.bytedance.adsdk.lottie.f.b.a();
                }
            } else {
                measureText = this.G.measureText(str.substring(i7, i7 + 1));
            }
            float f10 = measureText + f6;
            if (charAt == ' ') {
                z4 = true;
                f9 = f10;
            } else if (z4) {
                i6 = i7;
                f8 = f10;
                z4 = false;
            } else {
                f8 += f10;
            }
            f7 += f10;
            if (f4 > 0.0f && f7 >= f4 && charAt != ' ') {
                i4++;
                d L2 = L(i4);
                if (i6 == i5) {
                    String substring = str.substring(i5, i7);
                    String trim = substring.trim();
                    L2.b(trim, (f7 - f10) - ((trim.length() - substring.length()) * f9));
                    i5 = i7;
                    i6 = i5;
                    f7 = f10;
                    f8 = f7;
                } else {
                    String substring2 = str.substring(i5, i6 - 1);
                    String trim2 = substring2.trim();
                    L2.b(trim2, ((f7 - f8) - ((substring2.length() - trim2.length()) * f9)) - f9);
                    f7 = f8;
                    i5 = i6;
                }
            }
        }
        if (f7 > 0.0f) {
            i4++;
            L(i4).b(str.substring(i5), f7);
        }
        return this.K.subList(0, i4);
    }

    private void Q(Canvas canvas, w wVar, int i4, float f4) {
        PointF pointF = wVar.f25800l;
        PointF pointF2 = wVar.f25801m;
        float a4 = com.bytedance.adsdk.lottie.f.b.a();
        float f5 = (i4 * wVar.f25794f * a4) + (pointF == null ? 0.0f : (wVar.f25794f * 0.6f * a4) + pointF.y);
        float f6 = pointF == null ? 0.0f : pointF.x;
        float f7 = pointF2 != null ? pointF2.x : 0.0f;
        int i5 = c.f25946a[wVar.f25792d.ordinal()];
        if (i5 == 1) {
            canvas.translate(f6, f5);
        } else if (i5 == 2) {
            canvas.translate((f6 + f7) - f4, f5);
        } else if (i5 != 3) {
        } else {
            canvas.translate((f6 + (f7 / 2.0f)) - (f4 / 2.0f), f5);
        }
    }

    private void R(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void S(com.bytedance.adsdk.lottie.xv.d dVar, float f4, w wVar, Canvas canvas) {
        List<o> N = N(dVar);
        for (int i4 = 0; i4 < N.size(); i4++) {
            Path sr = N.get(i4).sr();
            sr.computeBounds(this.E, false);
            this.F.reset();
            this.F.preTranslate(0.0f, (-wVar.f25795g) * com.bytedance.adsdk.lottie.f.b.a());
            this.F.preScale(f4, f4);
            sr.transform(this.F);
            if (wVar.f25799k) {
                R(sr, this.G, canvas);
                R(sr, this.H, canvas);
            } else {
                R(sr, this.H, canvas);
                R(sr, this.G, canvas);
            }
        }
    }

    private void T(w wVar, Matrix matrix) {
        com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar = this.P;
        if (cVar != null) {
            this.G.setColor(cVar.j().intValue());
        } else {
            com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar2 = this.O;
            if (cVar2 != null) {
                this.G.setColor(cVar2.j().intValue());
            } else {
                this.G.setColor(wVar.f25796h);
            }
        }
        com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar3 = this.R;
        if (cVar3 != null) {
            this.H.setColor(cVar3.j().intValue());
        } else {
            com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar4 = this.Q;
            if (cVar4 != null) {
                this.H.setColor(cVar4.j().intValue());
            } else {
                this.H.setColor(wVar.f25797i);
            }
        }
        int intValue = ((this.f25937x.a() == null ? 100 : this.f25937x.a().j().intValue()) * 255) / 100;
        this.G.setAlpha(intValue);
        this.H.setAlpha(intValue);
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> cVar5 = this.T;
        if (cVar5 != null) {
            this.H.setStrokeWidth(cVar5.j().floatValue());
            return;
        }
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> cVar6 = this.S;
        if (cVar6 != null) {
            this.H.setStrokeWidth(cVar6.j().floatValue());
        } else {
            this.H.setStrokeWidth(wVar.f25798j * com.bytedance.adsdk.lottie.f.b.a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void U(com.bytedance.adsdk.lottie.xv.w r21, android.graphics.Matrix r22, com.bytedance.adsdk.lottie.xv.f r23, android.graphics.Canvas r24) {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            com.bytedance.adsdk.lottie.c.w.c<java.lang.Float, java.lang.Float> r0 = r8.W
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.j()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r9.f25791c
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r0 / r1
            float r11 = com.bytedance.adsdk.lottie.f.b.c(r22)
            java.lang.String r0 = r9.f25789a
            java.util.List r12 = r8.O(r0)
            int r13 = r12.size()
            int r0 = r9.f25793e
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            com.bytedance.adsdk.lottie.c.w.c<java.lang.Float, java.lang.Float> r1 = r8.V
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r1.j()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
            goto L4c
        L3d:
            com.bytedance.adsdk.lottie.c.w.c<java.lang.Float, java.lang.Float> r1 = r8.U
            if (r1 == 0) goto L4c
            java.lang.Object r1 = r1.j()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4c:
            r14 = r0
            r0 = -1
            r15 = 0
            r6 = 0
            r7 = -1
        L51:
            if (r6 >= r13) goto Lb2
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r9.f25801m
            if (r0 != 0) goto L61
            r0 = 0
            r2 = 0
            goto L64
        L61:
            float r0 = r0.x
            r2 = r0
        L64:
            r16 = 1
            r0 = r20
            r3 = r23
            r4 = r10
            r5 = r14
            r17 = r6
            r6 = r16
            java.util.List r6 = r0.P(r1, r2, r3, r4, r5, r6)
            r5 = 0
        L75:
            int r0 = r6.size()
            if (r5 >= r0) goto Laf
            java.lang.Object r0 = r6.get(r5)
            com.bytedance.adsdk.lottie.xv.xv.b$d r0 = (com.bytedance.adsdk.lottie.xv.xv.b.d) r0
            int r7 = r7 + 1
            r24.save()
            float r1 = com.bytedance.adsdk.lottie.xv.xv.b.d.a(r0)
            r4 = r24
            r8.Q(r4, r9, r7, r1)
            java.lang.String r1 = com.bytedance.adsdk.lottie.xv.xv.b.d.c(r0)
            r0 = r20
            r2 = r21
            r3 = r23
            r16 = r5
            r5 = r11
            r18 = r6
            r6 = r10
            r19 = r7
            r7 = r14
            r0.Z(r1, r2, r3, r4, r5, r6, r7)
            r24.restore()
            int r5 = r16 + 1
            r6 = r18
            r7 = r19
            goto L75
        Laf:
            int r6 = r17 + 1
            goto L51
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.xv.xv.b.U(com.bytedance.adsdk.lottie.xv.w, android.graphics.Matrix, com.bytedance.adsdk.lottie.xv.f, android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void V(com.bytedance.adsdk.lottie.xv.w r19, com.bytedance.adsdk.lottie.xv.f r20, android.graphics.Canvas r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            android.graphics.Typeface r0 = r7.K(r9)
            if (r0 != 0) goto Lf
            return
        Lf:
            java.lang.String r1 = r8.f25789a
            com.bytedance.adsdk.lottie.d r2 = r7.M
            com.bytedance.adsdk.lottie.m r2 = r2.d0()
            if (r2 == 0) goto L21
            java.lang.String r3 = r18.x()
            java.lang.String r1 = r2.e(r3, r1)
        L21:
            android.graphics.Paint r2 = r7.G
            r2.setTypeface(r0)
            com.bytedance.adsdk.lottie.c.w.c<java.lang.Float, java.lang.Float> r0 = r7.W
            if (r0 == 0) goto L35
            java.lang.Object r0 = r0.j()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L37
        L35:
            float r0 = r8.f25791c
        L37:
            android.graphics.Paint r2 = r7.G
            float r3 = com.bytedance.adsdk.lottie.f.b.a()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r7.H
            android.graphics.Paint r3 = r7.G
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r7.H
            android.graphics.Paint r3 = r7.G
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r8.f25793e
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            com.bytedance.adsdk.lottie.c.w.c<java.lang.Float, java.lang.Float> r3 = r7.V
            if (r3 == 0) goto L6e
            java.lang.Object r3 = r3.j()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L6c:
            float r2 = r2 + r3
            goto L7d
        L6e:
            com.bytedance.adsdk.lottie.c.w.c<java.lang.Float, java.lang.Float> r3 = r7.U
            if (r3 == 0) goto L7d
            java.lang.Object r3 = r3.j()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L6c
        L7d:
            float r3 = com.bytedance.adsdk.lottie.f.b.a()
            float r2 = r2 * r3
            float r2 = r2 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r11 = r2 / r0
            java.util.List r12 = r7.O(r1)
            int r13 = r12.size()
            r0 = -1
            r14 = 0
            r6 = 0
            r15 = -1
        L95:
            if (r6 >= r13) goto Le1
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r8.f25801m
            if (r0 != 0) goto La5
            r0 = 0
            r2 = 0
            goto La8
        La5:
            float r0 = r0.x
            r2 = r0
        La8:
            r4 = 0
            r16 = 0
            r0 = r18
            r3 = r20
            r5 = r11
            r17 = r6
            r6 = r16
            java.util.List r0 = r0.P(r1, r2, r3, r4, r5, r6)
            r1 = 0
        Lb9:
            int r2 = r0.size()
            if (r1 >= r2) goto Lde
            java.lang.Object r2 = r0.get(r1)
            com.bytedance.adsdk.lottie.xv.xv.b$d r2 = (com.bytedance.adsdk.lottie.xv.xv.b.d) r2
            int r15 = r15 + 1
            r21.save()
            float r3 = com.bytedance.adsdk.lottie.xv.xv.b.d.a(r2)
            r7.Q(r10, r8, r15, r3)
            java.lang.String r2 = com.bytedance.adsdk.lottie.xv.xv.b.d.c(r2)
            r7.Y(r2, r8, r10, r11)
            r21.restore()
            int r1 = r1 + 1
            goto Lb9
        Lde:
            int r6 = r17 + 1
            goto L95
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.xv.xv.b.V(com.bytedance.adsdk.lottie.xv.w, com.bytedance.adsdk.lottie.xv.f, android.graphics.Canvas):void");
    }

    private void W(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void X(String str, w wVar, Canvas canvas) {
        if (wVar.f25799k) {
            W(str, this.G, canvas);
            W(str, this.H, canvas);
            return;
        }
        W(str, this.H, canvas);
        W(str, this.G, canvas);
    }

    private void Y(String str, w wVar, Canvas canvas, float f4) {
        int i4 = 0;
        while (i4 < str.length()) {
            String M = M(str, i4);
            i4 += M.length();
            X(M, wVar, canvas);
            canvas.translate(this.G.measureText(M) + f4, 0.0f);
        }
    }

    private void Z(String str, w wVar, com.bytedance.adsdk.lottie.xv.f fVar, Canvas canvas, float f4, float f5, float f6) {
        for (int i4 = 0; i4 < str.length(); i4++) {
            com.bytedance.adsdk.lottie.xv.d dVar = this.N.n().get(com.bytedance.adsdk.lottie.xv.d.a(str.charAt(i4), fVar.a(), fVar.e()));
            if (dVar != null) {
                S(dVar, f5, wVar, canvas);
                canvas.translate((((float) dVar.c()) * f5 * com.bytedance.adsdk.lottie.f.b.a()) + f6, 0.0f);
            }
        }
    }

    private boolean a0(int i4) {
        return Character.getType(i4) == 16 || Character.getType(i4) == 27 || Character.getType(i4) == 6 || Character.getType(i4) == 28 || Character.getType(i4) == 8 || Character.getType(i4) == 19;
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a
    void B(Canvas canvas, Matrix matrix, int i4) {
        w j4 = this.f25943L.j();
        com.bytedance.adsdk.lottie.xv.f fVar = this.N.m().get(j4.f25790b);
        if (fVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        T(j4, matrix);
        if (this.M.K()) {
            U(j4, matrix, fVar, canvas);
        } else {
            V(j4, fVar, canvas);
        }
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a, com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        super.b(rectF, matrix, z3);
        rectF.set(0.0f, 0.0f, this.N.p().width(), this.N.p().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private String f25947a;

        /* renamed from: b  reason: collision with root package name */
        private float f25948b;

        private d() {
            this.f25947a = "";
            this.f25948b = 0.0f;
        }

        void b(String str, float f4) {
            this.f25947a = str;
            this.f25948b = f4;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }
}
