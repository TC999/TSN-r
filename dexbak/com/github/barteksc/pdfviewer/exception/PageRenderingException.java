package com.github.barteksc.pdfviewer.exception;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PageRenderingException extends Exception {
    private final int page;

    public PageRenderingException(int i, Throwable th) {
        super(th);
        this.page = i;
    }

    public int getPage() {
        return this.page;
    }
}
