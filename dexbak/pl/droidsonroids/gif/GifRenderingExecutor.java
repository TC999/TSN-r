package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: pl.droidsonroids.gif.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class GifRenderingExecutor extends ScheduledThreadPoolExecutor {

    /* compiled from: GifRenderingExecutor.java */
    /* renamed from: pl.droidsonroids.gif.i$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C15445b {

        /* renamed from: a */
        private static final GifRenderingExecutor f44442a = new GifRenderingExecutor();

        private C15445b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static GifRenderingExecutor m2391a() {
        return C15445b.f44442a;
    }

    private GifRenderingExecutor() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
