package master.flame.danmaku.controller;

import android.view.View;
import master.flame.danmaku.controller.c;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IDanmakuView.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface f {

    /* renamed from: w0  reason: collision with root package name */
    public static final int f60997w0 = 0;

    /* renamed from: x0  reason: collision with root package name */
    public static final int f60998x0 = 1;

    /* renamed from: y0  reason: collision with root package name */
    public static final int f60999y0 = 2;

    /* renamed from: z0  reason: collision with root package name */
    public static final int f61000z0 = 3;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IDanmakuView.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a {
        boolean a(m mVar);

        boolean b(f fVar);

        boolean c(m mVar);
    }

    void a(master.flame.danmaku.danmaku.model.d dVar);

    void b(master.flame.danmaku.danmaku.model.d dVar, boolean z3);

    void c(boolean z3);

    void d();

    boolean e();

    void f();

    void g(boolean z3);

    DanmakuContext getConfig();

    long getCurrentTime();

    m getCurrentVisibleDanmakus();

    int getHeight();

    a getOnDanmakuClickListener();

    View getView();

    int getWidth();

    float getXOff();

    float getYOff();

    void h(Long l4);

    void i(master.flame.danmaku.danmaku.parser.a aVar, DanmakuContext danmakuContext);

    boolean isHardwareAccelerated();

    boolean isPaused();

    boolean isPrepared();

    boolean isShown();

    long j();

    void k(a aVar, float f4, float f5);

    void m(Long l4);

    void n();

    void p(boolean z3);

    void pause();

    void release();

    void resume();

    void setCallback(c.d dVar);

    void setDrawingThreadType(int i4);

    void setOnDanmakuClickListener(a aVar);

    void setVisibility(int i4);

    void show();

    void start();

    void start(long j4);

    void stop();

    void toggle();
}
