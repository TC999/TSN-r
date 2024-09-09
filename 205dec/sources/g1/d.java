package g1;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.File;
import java.io.IOException;

/* compiled from: FileSource.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private File f54721a;

    public d(File file) {
        this.f54721a = file;
    }

    @Override // g1.c
    public PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.o(ParcelFileDescriptor.open(this.f54721a, 268435456), str);
    }
}
