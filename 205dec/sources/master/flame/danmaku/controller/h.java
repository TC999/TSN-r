package master.flame.danmaku.controller;

import f3.a;
import master.flame.danmaku.danmaku.model.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IDrawTask.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface h {

    /* renamed from: a  reason: collision with root package name */
    public static final int f61001a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f61002b = 2;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IDrawTask.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a {
        void a(master.flame.danmaku.danmaku.model.d dVar);

        void b(master.flame.danmaku.danmaku.model.d dVar);

        void c();

        void d();

        void e();
    }

    void a(master.flame.danmaku.danmaku.model.d dVar);

    void b(master.flame.danmaku.danmaku.model.d dVar, boolean z3);

    void c(boolean z3);

    void d();

    m e(long j4);

    void f();

    void g(master.flame.danmaku.danmaku.parser.a aVar);

    void h();

    void i();

    a.c j(master.flame.danmaku.danmaku.model.b bVar);

    void k(long j4);

    void l();

    void m(long j4, long j5, long j6);

    void onPlayStateChanged(int i4);

    void prepare();

    void reset();

    void seek(long j4);

    void start();
}
