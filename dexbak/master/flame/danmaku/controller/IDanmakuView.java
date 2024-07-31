package master.flame.danmaku.controller;

import android.view.View;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;

/* renamed from: master.flame.danmaku.controller.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface IDanmakuView {

    /* renamed from: v0 */
    public static final int f43681v0 = 0;

    /* renamed from: w0 */
    public static final int f43682w0 = 1;

    /* renamed from: x0 */
    public static final int f43683x0 = 2;

    /* renamed from: y0 */
    public static final int f43684y0 = 3;

    /* compiled from: IDanmakuView.java */
    /* renamed from: master.flame.danmaku.controller.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15340a {
        /* renamed from: a */
        boolean m3279a(IDanmakus iDanmakus);

        /* renamed from: b */
        boolean m3278b(IDanmakuView iDanmakuView);

        /* renamed from: c */
        boolean m3277c(IDanmakus iDanmakus);
    }

    /* renamed from: a */
    void mo2932a(BaseDanmaku baseDanmaku);

    /* renamed from: b */
    void mo2931b(BaseDanmaku baseDanmaku, boolean z);

    /* renamed from: c */
    void mo2930c(boolean z);

    /* renamed from: d */
    void mo2929d();

    /* renamed from: e */
    boolean mo2928e();

    /* renamed from: f */
    void mo2927f();

    /* renamed from: g */
    void mo2926g(boolean z);

    DanmakuContext getConfig();

    long getCurrentTime();

    IDanmakus getCurrentVisibleDanmakus();

    int getHeight();

    InterfaceC15340a getOnDanmakuClickListener();

    View getView();

    int getWidth();

    float getXOff();

    float getYOff();

    /* renamed from: h */
    void mo2925h(Long l);

    /* renamed from: i */
    void mo2924i(BaseDanmakuParser baseDanmakuParser, DanmakuContext danmakuContext);

    boolean isHardwareAccelerated();

    boolean isPaused();

    boolean isPrepared();

    boolean isShown();

    /* renamed from: j */
    long mo2923j();

    /* renamed from: k */
    void mo2922k(InterfaceC15340a interfaceC15340a, float f, float f2);

    /* renamed from: m */
    void mo2920m(Long l);

    /* renamed from: n */
    void mo2919n();

    /* renamed from: p */
    void mo2917p(boolean z);

    void pause();

    void release();

    void resume();

    void setCallback(DrawHandler.InterfaceC15331d interfaceC15331d);

    void setDrawingThreadType(int i);

    void setOnDanmakuClickListener(InterfaceC15340a interfaceC15340a);

    void setVisibility(int i);

    void show();

    void start();

    void start(long j);

    void stop();

    void toggle();
}
