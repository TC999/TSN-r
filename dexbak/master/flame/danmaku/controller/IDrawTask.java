package master.flame.danmaku.controller;

import master.flame.danmaku.danmaku.model.AbsDisplayer;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import p014a2.IRenderer;

/* renamed from: master.flame.danmaku.controller.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface IDrawTask {

    /* renamed from: a */
    public static final int f43685a = 1;

    /* renamed from: b */
    public static final int f43686b = 2;

    /* compiled from: IDrawTask.java */
    /* renamed from: master.flame.danmaku.controller.h$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15341a {
        /* renamed from: a */
        void mo3263a(BaseDanmaku baseDanmaku);

        /* renamed from: b */
        void mo3262b(BaseDanmaku baseDanmaku);

        /* renamed from: c */
        void mo3261c();

        /* renamed from: d */
        void mo3260d();

        /* renamed from: e */
        void mo3259e();
    }

    /* renamed from: a */
    void mo3276a(BaseDanmaku baseDanmaku);

    /* renamed from: b */
    void mo3275b(BaseDanmaku baseDanmaku, boolean z);

    /* renamed from: c */
    void mo3274c(boolean z);

    /* renamed from: d */
    void mo3273d();

    /* renamed from: e */
    IDanmakus mo3272e(long j);

    /* renamed from: f */
    void mo3271f();

    /* renamed from: g */
    void mo3270g(BaseDanmakuParser baseDanmakuParser);

    /* renamed from: h */
    void mo3269h();

    /* renamed from: i */
    void mo3268i();

    /* renamed from: j */
    IRenderer.C0025c mo3267j(AbsDisplayer absDisplayer);

    /* renamed from: k */
    void mo3266k(long j);

    /* renamed from: l */
    void mo3265l();

    /* renamed from: m */
    void mo3264m(long j, long j2, long j3);

    void onPlayStateChanged(int i);

    void prepare();

    void reset();

    void seek(long j);

    void start();
}
