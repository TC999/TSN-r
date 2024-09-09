package xyz.adscope.common.network.download;

import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.UrlRequest;
import xyz.adscope.common.network.download.Download;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UrlDownload extends UrlRequest implements Download {

    /* renamed from: j  reason: collision with root package name */
    public final String f64952j;

    /* renamed from: k  reason: collision with root package name */
    public final String f64953k;

    /* renamed from: l  reason: collision with root package name */
    public final Download.ProgressBar f64954l;

    /* renamed from: m  reason: collision with root package name */
    public final Download.Policy f64955m;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Api extends UrlRequest.Api<Api> {

        /* renamed from: j  reason: collision with root package name */
        public String f64956j;

        /* renamed from: k  reason: collision with root package name */
        public String f64957k;

        /* renamed from: l  reason: collision with root package name */
        public Download.ProgressBar f64958l;

        /* renamed from: m  reason: collision with root package name */
        public Download.Policy f64959m;

        public Api(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public Api directory(String str) {
            this.f64956j = str;
            return this;
        }

        public Api fileName(String str) {
            this.f64957k = str;
            return this;
        }

        public Api onProgress(Download.ProgressBar progressBar) {
            this.f64958l = progressBar;
            return this;
        }

        public String perform() {
            return new UrlWorker(new UrlDownload(this)).call();
        }

        public Canceller perform(Callback callback) {
            return DownloadManager.getInstance().perform(new UrlDownload(this), callback);
        }

        public Api policy(Download.Policy policy) {
            this.f64959m = policy;
            return this;
        }
    }

    public UrlDownload(Api api) {
        super(api);
        this.f64952j = api.f64956j;
        this.f64953k = api.f64957k;
        this.f64954l = api.f64958l == null ? Download.ProgressBar.DEFAULT : api.f64958l;
        this.f64955m = api.f64959m == null ? Download.Policy.DEFAULT : api.f64959m;
    }

    public static Api newApi(Url url, RequestMethod requestMethod) {
        return new Api(url, requestMethod);
    }

    @Override // xyz.adscope.common.network.download.Download
    public String directory() {
        return this.f64952j;
    }

    @Override // xyz.adscope.common.network.download.Download
    public String fileName() {
        return this.f64953k;
    }

    @Override // xyz.adscope.common.network.download.Download
    public Download.Policy policy() {
        return this.f64955m;
    }

    @Override // xyz.adscope.common.network.download.Download
    public Download.ProgressBar progressBar() {
        return this.f64954l;
    }
}
