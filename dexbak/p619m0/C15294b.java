package p619m0;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* compiled from: ByteArraySource.java */
/* renamed from: m0.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C15294b implements InterfaceC15295c {

    /* renamed from: a */
    private byte[] f43492a;

    public C15294b(byte[] bArr) {
        this.f43492a = bArr;
    }

    @Override // p619m0.InterfaceC15295c
    /* renamed from: a */
    public PdfDocument mo3458a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.m19722q(this.f43492a, str);
    }
}
