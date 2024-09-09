package xyz.adscope.common.network.download;

import xyz.adscope.common.network.BodyRequest;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.download.Download;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BodyDownload extends BodyRequest implements Download {

    /* renamed from: l  reason: collision with root package name */
    public final String f64927l;

    /* renamed from: m  reason: collision with root package name */
    public final String f64928m;

    /* renamed from: n  reason: collision with root package name */
    public final Download.ProgressBar f64929n;

    /* renamed from: o  reason: collision with root package name */
    public final Download.Policy f64930o;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Api extends BodyRequest.Api<Api> {

        /* renamed from: l  reason: collision with root package name */
        public String f64931l;

        /* renamed from: m  reason: collision with root package name */
        public String f64932m;

        /* renamed from: n  reason: collision with root package name */
        public Download.ProgressBar f64933n;

        /* renamed from: o  reason: collision with root package name */
        public Download.Policy f64934o;

        public Api(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public Api directory(String str) {
            this.f64931l = str;
            return this;
        }

        public Api fileName(String str) {
            this.f64932m = str;
            return this;
        }

        public Api onProgress(Download.ProgressBar progressBar) {
            this.f64933n = progressBar;
            return this;
        }

        public String perform() {
            return new BodyWorker(new BodyDownload(this)).call();
        }

        public Canceller perform(Callback callback) {
            return DownloadManager.getInstance().perform(new BodyDownload(this), callback);
        }

        public Api policy(Download.Policy policy) {
            this.f64934o = policy;
            return this;
        }
    }

    public BodyDownload(Api api) {
        super(api);
        this.f64927l = api.f64931l;
        this.f64928m = api.f64932m;
        this.f64929n = api.f64933n == null ? Download.ProgressBar.DEFAULT : api.f64933n;
        this.f64930o = api.f64934o == null ? Download.Policy.DEFAULT : api.f64934o;
    }

    public static Api newApi(Url url, RequestMethod requestMethod) {
        return new Api(url, requestMethod);
    }

    @Override // xyz.adscope.common.network.download.Download
    public String directory() {
        return this.f64927l;
    }

    @Override // xyz.adscope.common.network.download.Download
    public String fileName() {
        return this.f64928m;
    }

    @Override // xyz.adscope.common.network.download.Download
    public Download.Policy policy() {
        return this.f64930o;
    }

    @Override // xyz.adscope.common.network.download.Download
    public Download.ProgressBar progressBar() {
        return this.f64929n;
    }
}
