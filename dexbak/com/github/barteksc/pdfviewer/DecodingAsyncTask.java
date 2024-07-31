package com.github.barteksc.pdfviewer;

import android.os.AsyncTask;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.lang.ref.WeakReference;
import p619m0.InterfaceC15295c;

/* renamed from: com.github.barteksc.pdfviewer.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
class DecodingAsyncTask extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: a */
    private boolean f23647a = false;

    /* renamed from: b */
    private WeakReference<PDFView> f23648b;

    /* renamed from: c */
    private PdfiumCore f23649c;

    /* renamed from: d */
    private String f23650d;

    /* renamed from: e */
    private InterfaceC15295c f23651e;

    /* renamed from: f */
    private int[] f23652f;

    /* renamed from: g */
    private PdfFile f23653g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodingAsyncTask(InterfaceC15295c interfaceC15295c, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.f23651e = interfaceC15295c;
        this.f23652f = iArr;
        this.f23648b = new WeakReference<>(pDFView);
        this.f23650d = str;
        this.f23649c = pdfiumCore;
    }

    /* renamed from: b */
    private Size m35372b(PDFView pDFView) {
        return new Size(pDFView.getWidth(), pDFView.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Throwable doInBackground(Void... voidArr) {
        try {
            PDFView pDFView = this.f23648b.get();
            if (pDFView != null) {
                this.f23653g = new PdfFile(this.f23649c, this.f23651e.mo3458a(pDFView.getContext(), this.f23649c, this.f23650d), pDFView.getPageFitPolicy(), m35372b(pDFView), this.f23652f, pDFView.m35486Q(), pDFView.getSpacingPx(), pDFView.m35494I(), pDFView.m35491L());
                return null;
            }
            return new NullPointerException("pdfView == null");
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(Throwable th) {
        PDFView pDFView = this.f23648b.get();
        if (pDFView != null) {
            if (th != null) {
                pDFView.m35479X(th);
            } else if (this.f23647a) {
            } else {
                pDFView.m35480W(this.f23653g);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.f23647a = true;
    }
}
