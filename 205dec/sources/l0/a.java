package l0;

import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import com.shockwave.pdfium.PdfDocument;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: LinkTapEvent.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private float f60788a;

    /* renamed from: b  reason: collision with root package name */
    private float f60789b;

    /* renamed from: c  reason: collision with root package name */
    private float f60790c;

    /* renamed from: d  reason: collision with root package name */
    private float f60791d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f60792e;

    /* renamed from: f  reason: collision with root package name */
    private PdfDocument.Link f60793f;

    /* renamed from: l0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class C1228a {

        /* renamed from: a  reason: collision with root package name */
        public GradientDrawable.Orientation f60794a;

        /* renamed from: b  reason: collision with root package name */
        public int[] f60795b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f60796c;
    }

    public a(float f4, float f5, float f6, float f7, RectF rectF, PdfDocument.Link link) {
        this.f60788a = f4;
        this.f60789b = f5;
        this.f60790c = f6;
        this.f60791d = f7;
        this.f60792e = rectF;
        this.f60793f = link;
    }

    public float a() {
        return this.f60790c;
    }

    public float b() {
        return this.f60791d;
    }

    public PdfDocument.Link c() {
        return this.f60793f;
    }

    public RectF d() {
        return this.f60792e;
    }

    public float e() {
        return this.f60788a;
    }

    public float f() {
        return this.f60789b;
    }
}
