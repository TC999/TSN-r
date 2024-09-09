package xyz.adscope.common.network;

import java.io.OutputStream;
import java.util.concurrent.Executor;
import xyz.adscope.common.network.Content;
import xyz.adscope.common.network.util.ProgressOutputStream;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class BaseContent<T extends Content> implements Content {

    /* renamed from: a  reason: collision with root package name */
    public ProgressBar<T> f64758a;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AsyncProgressBar<T extends Content> implements ProgressBar<T> {

        /* renamed from: a  reason: collision with root package name */
        public final ProgressBar<T> f64759a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f64760b = Kalle.getConfig().getMainExecutor();

        public AsyncProgressBar(ProgressBar<T> progressBar) {
            this.f64759a = progressBar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xyz.adscope.common.network.ProgressBar
        public /* bridge */ /* synthetic */ void progress(Object obj, int i4) {
            progress((AsyncProgressBar<T>) ((Content) obj), i4);
        }

        public void progress(final T t3, final int i4) {
            this.f64760b.execute(new Runnable() { // from class: xyz.adscope.common.network.BaseContent.AsyncProgressBar.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncProgressBar.this.f64759a.progress(t3, i4);
                }
            });
        }
    }

    public abstract void a(OutputStream outputStream);

    public void onProgress(ProgressBar<T> progressBar) {
        this.f64758a = new AsyncProgressBar(progressBar);
    }

    @Override // xyz.adscope.common.network.Content
    public final void writeTo(OutputStream outputStream) {
        if (this.f64758a != null) {
            a(new ProgressOutputStream(outputStream, this, this.f64758a));
        } else {
            a(outputStream);
        }
    }
}
