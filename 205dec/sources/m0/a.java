package m0;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: AssetSource.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f60826a;

    /* renamed from: m0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface InterfaceC1229a {
        void c(int i4);
    }

    public a(String str) {
        this.f60826a = str;
    }

    @Override // m0.c
    public PdfDocument a(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.o(ParcelFileDescriptor.open(com.github.barteksc.pdfviewer.util.c.b(context, this.f60826a), 268435456), str);
    }
}
