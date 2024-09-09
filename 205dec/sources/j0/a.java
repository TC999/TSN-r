package j0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: DefaultLinkHandler.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f55212b = "a";

    /* renamed from: a  reason: collision with root package name */
    private PDFView f55213a;

    /* renamed from: j0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface InterfaceC1087a {
        void c(Bitmap bitmap);
    }

    public a(PDFView pDFView) {
        this.f55213a = pDFView;
    }

    private void b(int i4) {
        this.f55213a.S(i4);
    }

    private void c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Context context = this.f55213a.getContext();
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return;
        }
        String str2 = f55212b;
        Log.w(str2, "No activity found for URI: " + str);
    }

    @Override // j0.b
    public void a(l0.a aVar) {
        String c4 = aVar.c().c();
        Integer b4 = aVar.c().b();
        if (c4 != null && !c4.isEmpty()) {
            c(c4);
        } else if (b4 != null) {
            b(b4.intValue());
        }
    }
}
