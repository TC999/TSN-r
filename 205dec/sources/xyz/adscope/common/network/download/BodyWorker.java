package xyz.adscope.common.network.download;

import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.http.Call;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BodyWorker extends BasicWorker<BodyDownload> {

    /* renamed from: f  reason: collision with root package name */
    public Call f64935f;

    public BodyWorker(BodyDownload bodyDownload) {
        super(bodyDownload);
    }

    @Override // xyz.adscope.common.network.download.BasicWorker
    public Response a(BodyDownload bodyDownload) {
        Call call = new Call(bodyDownload);
        this.f64935f = call;
        return call.execute();
    }

    @Override // xyz.adscope.common.network.download.BasicWorker
    public void cancel() {
        Call call = this.f64935f;
        if (call == null || call.isCanceled()) {
            return;
        }
        this.f64935f.asyncCancel();
    }
}
