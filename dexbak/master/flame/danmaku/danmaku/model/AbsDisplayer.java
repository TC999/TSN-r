package master.flame.danmaku.danmaku.model;

import master.flame.danmaku.danmaku.model.android.BaseCacheStuffer;

/* renamed from: master.flame.danmaku.danmaku.model.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbsDisplayer<T, F> implements IDisplayer {
    /* renamed from: A */
    public abstract void mo3106A(boolean z);

    /* renamed from: B */
    public abstract void mo3105B(float f);

    /* renamed from: C */
    public abstract void mo3104C(int i);

    /* renamed from: D */
    public abstract void mo3103D(F f);

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    public boolean isHardwareAccelerated() {
        return false;
    }

    /* renamed from: u */
    public abstract void mo3102u();

    /* renamed from: v */
    public abstract void mo3101v(BaseDanmaku baseDanmaku, T t, float f, float f2, boolean z);

    /* renamed from: w */
    public abstract BaseCacheStuffer mo3100w();

    /* renamed from: x */
    public abstract T mo3099x();

    /* renamed from: y */
    public abstract void mo3098y(BaseCacheStuffer baseCacheStuffer);

    /* renamed from: z */
    public abstract void mo3097z(T t);
}
