package g1;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* compiled from: ByteArraySource.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f54720a;

    public b(byte[] bArr) {
        this.f54720a = bArr;
    }

    @Override // g1.c
    public PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.q(this.f54720a, str);
    }
}
