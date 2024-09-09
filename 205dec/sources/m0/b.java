package m0;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: ByteArraySource.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f60827a;

    public b(byte[] bArr) {
        this.f60827a = bArr;
    }

    @Override // m0.c
    public PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.q(this.f60827a, str);
    }
}
