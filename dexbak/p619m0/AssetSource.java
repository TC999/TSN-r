package p619m0;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.github.barteksc.pdfviewer.util.C6666c;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* renamed from: m0.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AssetSource implements InterfaceC15295c {

    /* renamed from: a */
    private final String f43491a;

    public AssetSource(String str) {
        this.f43491a = str;
    }

    @Override // p619m0.InterfaceC15295c
    /* renamed from: a */
    public PdfDocument mo3458a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.m19724o(ParcelFileDescriptor.open(C6666c.m35310b(context, this.f43491a), 268435456), str);
    }
}
