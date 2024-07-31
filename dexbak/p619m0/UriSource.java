package p619m0;

import android.content.Context;
import android.net.Uri;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* renamed from: m0.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UriSource implements InterfaceC15295c {

    /* renamed from: a */
    private Uri f43495a;

    public UriSource(Uri uri) {
        this.f43495a = uri;
    }

    @Override // p619m0.InterfaceC15295c
    /* renamed from: a */
    public PdfDocument mo3458a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.m19724o(context.getContentResolver().openFileDescriptor(this.f43495a, "r"), str);
    }
}
