package xyz.adscope.common.network.exception;

import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DownloadError extends ReadException {

    /* renamed from: a  reason: collision with root package name */
    public int f64963a;

    /* renamed from: b  reason: collision with root package name */
    public Headers f64964b;

    public DownloadError(int i4, Headers headers, String str) {
        super(str);
        this.f64963a = i4;
        this.f64964b = headers;
    }

    public DownloadError(int i4, Headers headers, Throwable th) {
        super(th);
        this.f64963a = i4;
        this.f64964b = headers;
    }

    public int getCode() {
        return this.f64963a;
    }

    public Headers getHeaders() {
        return this.f64964b;
    }
}
