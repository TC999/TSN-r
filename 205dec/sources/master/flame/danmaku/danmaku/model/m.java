package master.flame.danmaku.danmaku.model;

import java.util.Collection;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IDanmakus.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface m {

    /* renamed from: a  reason: collision with root package name */
    public static final int f61185a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f61186b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f61187c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f61188d = 4;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IDanmakus.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements Comparator<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f61189a;

        public a(boolean z3) {
            b(z3);
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.f61189a && g3.a.g(dVar, dVar2)) {
                return 0;
            }
            return g3.a.d(dVar, dVar2);
        }

        public void b(boolean z3) {
            this.f61189a = z3;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IDanmakus.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class b<Progress, Result> {

        /* renamed from: a  reason: collision with root package name */
        public static final int f61190a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f61191b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f61192c = 2;

        /* renamed from: d  reason: collision with root package name */
        public static final int f61193d = 3;

        public abstract int a(Progress progress);

        public void b() {
        }

        public void c() {
        }

        public Result d() {
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IDanmakus.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class c<Progress> extends b<Progress, Void> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IDanmakus.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d extends a {
        public d(boolean z3) {
            super(z3);
        }

        @Override // master.flame.danmaku.danmaku.model.m.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            return super.compare(dVar, dVar2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IDanmakus.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class e extends a {
        public e(boolean z3) {
            super(z3);
        }

        @Override // master.flame.danmaku.danmaku.model.m.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.f61189a && g3.a.g(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar.l(), dVar2.l());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IDanmakus.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class f extends a {
        public f(boolean z3) {
            super(z3);
        }

        @Override // master.flame.danmaku.danmaku.model.m.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.f61189a && g3.a.g(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar2.l(), dVar.l());
        }
    }

    void a(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    Collection<master.flame.danmaku.danmaku.model.d> b();

    void c(boolean z3);

    void clear();

    m d(long j4, long j5);

    Object e();

    m f(long j4, long j5);

    master.flame.danmaku.danmaku.model.d first();

    boolean g(master.flame.danmaku.danmaku.model.d dVar);

    void h(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    boolean i(master.flame.danmaku.danmaku.model.d dVar);

    boolean isEmpty();

    boolean j(master.flame.danmaku.danmaku.model.d dVar);

    master.flame.danmaku.danmaku.model.d last();

    int size();
}
