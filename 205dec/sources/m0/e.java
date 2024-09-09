package m0;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: InputStreamSource.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f60829a;

    public e(InputStream inputStream) {
        this.f60829a = inputStream;
    }

    @Override // m0.c
    public PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.q(com.github.barteksc.pdfviewer.util.f.b(this.f60829a), str);
    }
}
