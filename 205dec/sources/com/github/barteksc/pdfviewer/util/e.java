package com.github.barteksc.pdfviewer.util;

import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: PageSizeCalculator.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private FitPolicy f37314a;

    /* renamed from: b  reason: collision with root package name */
    private final Size f37315b;

    /* renamed from: c  reason: collision with root package name */
    private final Size f37316c;

    /* renamed from: d  reason: collision with root package name */
    private final Size f37317d;

    /* renamed from: e  reason: collision with root package name */
    private SizeF f37318e;

    /* renamed from: f  reason: collision with root package name */
    private SizeF f37319f;

    /* renamed from: g  reason: collision with root package name */
    private float f37320g;

    /* renamed from: h  reason: collision with root package name */
    private float f37321h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f37322i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: PageSizeCalculator.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37323a;

        static {
            int[] iArr = new int[FitPolicy.values().length];
            f37323a = iArr;
            try {
                iArr[FitPolicy.HEIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37323a[FitPolicy.BOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public e(FitPolicy fitPolicy, Size size, Size size2, Size size3, boolean z3) {
        this.f37314a = fitPolicy;
        this.f37315b = size;
        this.f37316c = size2;
        this.f37317d = size3;
        this.f37322i = z3;
        b();
    }

    private void b() {
        int i4 = a.f37323a[this.f37314a.ordinal()];
        if (i4 == 1) {
            SizeF d4 = d(this.f37316c, this.f37317d.a());
            this.f37319f = d4;
            this.f37321h = d4.a() / this.f37316c.a();
            Size size = this.f37315b;
            this.f37318e = d(size, size.a() * this.f37321h);
        } else if (i4 != 2) {
            SizeF e4 = e(this.f37315b, this.f37317d.b());
            this.f37318e = e4;
            this.f37320g = e4.b() / this.f37315b.b();
            Size size2 = this.f37316c;
            this.f37319f = e(size2, size2.b() * this.f37320g);
        } else {
            float b4 = c(this.f37315b, this.f37317d.b(), this.f37317d.a()).b() / this.f37315b.b();
            Size size3 = this.f37316c;
            SizeF c4 = c(size3, size3.b() * b4, this.f37317d.a());
            this.f37319f = c4;
            this.f37321h = c4.a() / this.f37316c.a();
            SizeF c5 = c(this.f37315b, this.f37317d.b(), this.f37315b.a() * this.f37321h);
            this.f37318e = c5;
            this.f37320g = c5.b() / this.f37315b.b();
        }
    }

    private SizeF c(Size size, float f4, float f5) {
        float b4 = size.b() / size.a();
        float floor = (float) Math.floor(f4 / b4);
        if (floor > f5) {
            f4 = (float) Math.floor(b4 * f5);
        } else {
            f5 = floor;
        }
        return new SizeF(f4, f5);
    }

    private SizeF d(Size size, float f4) {
        return new SizeF((float) Math.floor(f4 / (size.a() / size.b())), f4);
    }

    private SizeF e(Size size, float f4) {
        return new SizeF(f4, (float) Math.floor(f4 / (size.b() / size.a())));
    }

    public SizeF a(Size size) {
        if (size.b() > 0 && size.a() > 0) {
            float b4 = this.f37322i ? this.f37317d.b() : size.b() * this.f37320g;
            float a4 = this.f37322i ? this.f37317d.a() : size.a() * this.f37321h;
            int i4 = a.f37323a[this.f37314a.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    return e(size, b4);
                }
                return c(size, b4, a4);
            }
            return d(size, a4);
        }
        return new SizeF(0.0f, 0.0f);
    }

    public SizeF f() {
        return this.f37319f;
    }

    public SizeF g() {
        return this.f37318e;
    }
}
