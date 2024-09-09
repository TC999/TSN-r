package m0;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: FileSource.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private File f60828a;

    public d(File file) {
        this.f60828a = file;
    }

    @Override // m0.c
    public PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.o(ParcelFileDescriptor.open(this.f60828a, 268435456), str);
    }
}
