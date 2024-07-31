package p619m0;

import android.content.Context;
import com.github.barteksc.pdfviewer.util.C6668f;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: m0.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class InputStreamSource implements InterfaceC15295c {

    /* renamed from: a */
    private InputStream f43494a;

    public InputStreamSource(InputStream inputStream) {
        this.f43494a = inputStream;
    }

    @Override // p619m0.InterfaceC15295c
    /* renamed from: a */
    public PdfDocument mo3458a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.m19722q(C6668f.m35293b(this.f43494a), str);
    }
}
