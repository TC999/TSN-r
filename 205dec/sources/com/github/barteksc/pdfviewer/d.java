package com.github.barteksc.pdfviewer;

import android.os.AsyncTask;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: DecodingAsyncTask.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class d extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f37216a = false;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<PDFView> f37217b;

    /* renamed from: c  reason: collision with root package name */
    private PdfiumCore f37218c;

    /* renamed from: d  reason: collision with root package name */
    private String f37219d;

    /* renamed from: e  reason: collision with root package name */
    private g1.c f37220e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f37221f;

    /* renamed from: g  reason: collision with root package name */
    private g f37222g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(g1.c cVar, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.f37220e = cVar;
        this.f37221f = iArr;
        this.f37217b = new WeakReference<>(pDFView);
        this.f37219d = str;
        this.f37218c = pdfiumCore;
    }

    private Size b(PDFView pDFView) {
        return new Size(pDFView.getWidth(), pDFView.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Throwable doInBackground(Void... voidArr) {
        try {
            PDFView pDFView = this.f37217b.get();
            if (pDFView != null) {
                this.f37222g = new g(this.f37218c, this.f37220e.a(pDFView.getContext(), this.f37218c, this.f37219d), pDFView.getPageFitPolicy(), b(pDFView), this.f37221f, pDFView.Q(), pDFView.getSpacingPx(), pDFView.I(), pDFView.L());
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
        PDFView pDFView = this.f37217b.get();
        if (pDFView != null) {
            if (th != null) {
                pDFView.X(th);
            } else if (this.f37216a) {
            } else {
                pDFView.W(this.f37222g);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.f37216a = true;
    }
}
