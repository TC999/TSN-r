package g1;

import android.content.Context;
import android.net.Uri;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* compiled from: UriSource.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f implements c {

    /* renamed from: a  reason: collision with root package name */
    private Uri f54723a;

    public f(Uri uri) {
        this.f54723a = uri;
    }

    @Override // g1.c
    public PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.o(context.getContentResolver().openFileDescriptor(this.f54723a, "r"), str);
    }
}
