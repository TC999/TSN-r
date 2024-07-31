package p616l0;

import android.graphics.RectF;
import com.shockwave.pdfium.PdfDocument;

/* renamed from: l0.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class LinkTapEvent {

    /* renamed from: a */
    private float f43471a;

    /* renamed from: b */
    private float f43472b;

    /* renamed from: c */
    private float f43473c;

    /* renamed from: d */
    private float f43474d;

    /* renamed from: e */
    private RectF f43475e;

    /* renamed from: f */
    private PdfDocument.Link f43476f;

    public LinkTapEvent(float f, float f2, float f3, float f4, RectF rectF, PdfDocument.Link link) {
        this.f43471a = f;
        this.f43472b = f2;
        this.f43473c = f3;
        this.f43474d = f4;
        this.f43475e = rectF;
        this.f43476f = link;
    }

    /* renamed from: a */
    public float m3475a() {
        return this.f43473c;
    }

    /* renamed from: b */
    public float m3474b() {
        return this.f43474d;
    }

    /* renamed from: c */
    public PdfDocument.Link m3473c() {
        return this.f43476f;
    }

    /* renamed from: d */
    public RectF m3472d() {
        return this.f43475e;
    }

    /* renamed from: e */
    public float m3471e() {
        return this.f43471a;
    }

    /* renamed from: f */
    public float m3470f() {
        return this.f43472b;
    }
}
