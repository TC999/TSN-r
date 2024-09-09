package com.github.barteksc.pdfviewer.exception;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class PageRenderingException extends Exception {
    private final int page;

    public PageRenderingException(int i4, Throwable th) {
        super(th);
        this.page = i4;
    }

    public int getPage() {
        return this.page;
    }
}
