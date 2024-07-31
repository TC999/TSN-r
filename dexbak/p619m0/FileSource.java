package p619m0;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.File;
import java.io.IOException;

/* renamed from: m0.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FileSource implements InterfaceC15295c {

    /* renamed from: a */
    private File f43493a;

    public FileSource(File file) {
        this.f43493a = file;
    }

    @Override // p619m0.InterfaceC15295c
    /* renamed from: a */
    public PdfDocument mo3458a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.m19724o(ParcelFileDescriptor.open(this.f43493a, 268435456), str);
    }
}
