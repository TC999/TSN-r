package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: GifRenderingExecutor.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
final class i extends ScheduledThreadPoolExecutor {

    /* compiled from: GifRenderingExecutor.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final i f61855a = new i();

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a() {
        return b.f61855a;
    }

    private i() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
