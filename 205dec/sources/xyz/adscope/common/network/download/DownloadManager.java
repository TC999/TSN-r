package xyz.adscope.common.network.download;

import java.util.concurrent.Executor;
import xyz.adscope.common.network.CancelerManager;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.Kalle;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DownloadManager {

    /* renamed from: c  reason: collision with root package name */
    public static DownloadManager f64936c;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f64937a = Kalle.getConfig().getWorkExecutor();

    /* renamed from: b  reason: collision with root package name */
    public final CancelerManager f64938b = new CancelerManager();

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AsyncCallback implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final Callback f64943a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f64944b = Kalle.getConfig().getMainExecutor();

        public AsyncCallback(Callback callback) {
            this.f64943a = callback;
        }

        @Override // xyz.adscope.common.network.download.Callback
        public void onCancel() {
            if (this.f64943a == null) {
                return;
            }
            this.f64944b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.4
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64943a.onCancel();
                }
            });
        }

        @Override // xyz.adscope.common.network.download.Callback
        public void onEnd() {
            if (this.f64943a == null) {
                return;
            }
            this.f64944b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.5
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64943a.onEnd();
                }
            });
        }

        @Override // xyz.adscope.common.network.download.Callback
        public void onException(final Exception exc) {
            if (this.f64943a == null) {
                return;
            }
            this.f64944b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64943a.onException(exc);
                }
            });
        }

        @Override // xyz.adscope.common.network.download.Callback
        public void onFinish(final String str) {
            if (this.f64943a == null) {
                return;
            }
            this.f64944b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64943a.onFinish(str);
                }
            });
        }

        @Override // xyz.adscope.common.network.download.Callback
        public void onStart() {
            if (this.f64943a == null) {
                return;
            }
            this.f64944b.execute(new Runnable() { // from class: xyz.adscope.common.network.download.DownloadManager.AsyncCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncCallback.this.f64943a.onStart();
                }
            });
        }
    }

    public static DownloadManager getInstance() {
        if (f64936c == null) {
            synchronized (DownloadManager.class) {
                if (f64936c == null) {
                    f64936c = new DownloadManager();
                }
            }
        }
        return f64936c;
    }

    public void cancel(Object obj) {
        this.f64938b.cancel(obj);
    }

    public String perform(BodyDownload bodyDownload) {
        return new BodyWorker(bodyDownload).call();
    }

    public String perform(UrlDownload urlDownload) {
        return new UrlWorker(urlDownload).call();
    }

    public Canceller perform(final BodyDownload bodyDownload, Callback callback) {
        Work work = new Work(new BodyWorker(bodyDownload), new AsyncCallback(callback) { // from class: xyz.adscope.common.network.download.DownloadManager.2
            @Override // xyz.adscope.common.network.download.DownloadManager.AsyncCallback, xyz.adscope.common.network.download.Callback
            public void onEnd() {
                super.onEnd();
                DownloadManager.this.f64938b.removeCancel(bodyDownload);
            }
        });
        this.f64938b.addCancel(bodyDownload, work);
        this.f64937a.execute(work);
        return work;
    }

    public Canceller perform(final UrlDownload urlDownload, Callback callback) {
        Work work = new Work(new UrlWorker(urlDownload), new AsyncCallback(callback) { // from class: xyz.adscope.common.network.download.DownloadManager.1
            @Override // xyz.adscope.common.network.download.DownloadManager.AsyncCallback, xyz.adscope.common.network.download.Callback
            public void onEnd() {
                super.onEnd();
                DownloadManager.this.f64938b.removeCancel(urlDownload);
            }
        });
        this.f64938b.addCancel(urlDownload, work);
        this.f64937a.execute(work);
        return work;
    }
}
