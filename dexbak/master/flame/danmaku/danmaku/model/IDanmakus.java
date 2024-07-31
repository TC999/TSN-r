package master.flame.danmaku.danmaku.model;

import java.util.Collection;
import java.util.Comparator;
import p025b2.DanmakuUtils;

/* renamed from: master.flame.danmaku.danmaku.model.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface IDanmakus {

    /* renamed from: a */
    public static final int f43902a = 0;

    /* renamed from: b */
    public static final int f43903b = 1;

    /* renamed from: c */
    public static final int f43904c = 2;

    /* renamed from: d */
    public static final int f43905d = 4;

    /* compiled from: IDanmakus.java */
    /* renamed from: master.flame.danmaku.danmaku.model.m$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15348a implements Comparator<BaseDanmaku> {

        /* renamed from: a */
        protected boolean f43906a;

        public C15348a(boolean z) {
            m3047b(z);
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            if (this.f43906a && DanmakuUtils.m59959g(baseDanmaku, baseDanmaku2)) {
                return 0;
            }
            return DanmakuUtils.m59962d(baseDanmaku, baseDanmaku2);
        }

        /* renamed from: b */
        public void m3047b(boolean z) {
            this.f43906a = z;
        }
    }

    /* compiled from: IDanmakus.java */
    /* renamed from: master.flame.danmaku.danmaku.model.m$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15349b<Progress, Result> {

        /* renamed from: a */
        public static final int f43907a = 0;

        /* renamed from: b */
        public static final int f43908b = 1;

        /* renamed from: c */
        public static final int f43909c = 2;

        /* renamed from: d */
        public static final int f43910d = 3;

        /* renamed from: a */
        public abstract int mo2892a(Progress progress);

        /* renamed from: b */
        public void mo2963b() {
        }

        /* renamed from: c */
        public void mo2955c() {
        }

        /* renamed from: d */
        public Result mo2954d() {
            return null;
        }
    }

    /* compiled from: IDanmakus.java */
    /* renamed from: master.flame.danmaku.danmaku.model.m$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15350c<Progress> extends AbstractC15349b<Progress, Void> {
    }

    /* compiled from: IDanmakus.java */
    /* renamed from: master.flame.danmaku.danmaku.model.m$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15351d extends C15348a {
        public C15351d(boolean z) {
            super(z);
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.C15348a, java.util.Comparator
        /* renamed from: a */
        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            return super.compare(baseDanmaku, baseDanmaku2);
        }
    }

    /* compiled from: IDanmakus.java */
    /* renamed from: master.flame.danmaku.danmaku.model.m$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15352e extends C15348a {
        public C15352e(boolean z) {
            super(z);
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.C15348a, java.util.Comparator
        /* renamed from: a */
        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            if (this.f43906a && DanmakuUtils.m59959g(baseDanmaku, baseDanmaku2)) {
                return 0;
            }
            return Float.compare(baseDanmaku.mo2996l(), baseDanmaku2.mo2996l());
        }
    }

    /* compiled from: IDanmakus.java */
    /* renamed from: master.flame.danmaku.danmaku.model.m$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15353f extends C15348a {
        public C15353f(boolean z) {
            super(z);
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.C15348a, java.util.Comparator
        /* renamed from: a */
        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            if (this.f43906a && DanmakuUtils.m59959g(baseDanmaku, baseDanmaku2)) {
                return 0;
            }
            return Float.compare(baseDanmaku2.mo2996l(), baseDanmaku.mo2996l());
        }
    }

    /* renamed from: a */
    void mo3057a(AbstractC15349b<? super BaseDanmaku, ?> abstractC15349b);

    /* renamed from: b */
    Collection<BaseDanmaku> mo3056b();

    /* renamed from: c */
    void mo3055c(boolean z);

    void clear();

    /* renamed from: d */
    IDanmakus mo3054d(long j, long j2);

    /* renamed from: e */
    Object mo3053e();

    /* renamed from: f */
    IDanmakus mo3052f(long j, long j2);

    BaseDanmaku first();

    /* renamed from: g */
    boolean mo3051g(BaseDanmaku baseDanmaku);

    /* renamed from: h */
    void mo3050h(AbstractC15349b<? super BaseDanmaku, ?> abstractC15349b);

    /* renamed from: i */
    boolean mo3049i(BaseDanmaku baseDanmaku);

    boolean isEmpty();

    /* renamed from: j */
    boolean mo3048j(BaseDanmaku baseDanmaku);

    BaseDanmaku last();

    int size();
}
