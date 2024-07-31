package p607j0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;
import p616l0.LinkTapEvent;

/* renamed from: j0.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultLinkHandler implements LinkHandler {

    /* renamed from: b */
    private static final String f40775b = "a";

    /* renamed from: a */
    private PDFView f40776a;

    public DefaultLinkHandler(PDFView pDFView) {
        this.f40776a = pDFView;
    }

    /* renamed from: b */
    private void m12669b(int i) {
        this.f40776a.m35484S(i);
    }

    /* renamed from: c */
    private void m12668c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Context context = this.f40776a.getContext();
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return;
        }
        String str2 = f40775b;
        Log.w(str2, "No activity found for URI: " + str);
    }

    @Override // p607j0.LinkHandler
    /* renamed from: a */
    public void mo12667a(LinkTapEvent linkTapEvent) {
        String m19747c = linkTapEvent.m3473c().m19747c();
        Integer m19748b = linkTapEvent.m3473c().m19748b();
        if (m19747c != null && !m19747c.isEmpty()) {
            m12668c(m19747c);
        } else if (m19748b != null) {
            m12669b(m19748b.intValue());
        }
    }
}
