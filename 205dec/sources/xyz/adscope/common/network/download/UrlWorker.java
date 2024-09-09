package xyz.adscope.common.network.download;

import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.http.Call;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UrlWorker extends BasicWorker<UrlDownload> {

    /* renamed from: f  reason: collision with root package name */
    public Call f64960f;

    public UrlWorker(UrlDownload urlDownload) {
        super(urlDownload);
    }

    @Override // xyz.adscope.common.network.download.BasicWorker
    public Response a(UrlDownload urlDownload) {
        Call call = new Call(urlDownload);
        this.f64960f = call;
        return call.execute();
    }

    @Override // xyz.adscope.common.network.download.BasicWorker
    public void cancel() {
        Call call = this.f64960f;
        if (call == null || call.isCanceled()) {
            return;
        }
        this.f64960f.asyncCancel();
    }
}
