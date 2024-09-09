package g1;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamSource.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f54722a;

    public e(InputStream inputStream) {
        this.f54722a = inputStream;
    }

    @Override // g1.c
    public PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.q(com.github.barteksc.pdfviewer.util.f.b(this.f54722a), str);
    }
}
