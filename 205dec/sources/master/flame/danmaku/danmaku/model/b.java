package master.flame.danmaku.danmaku.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbsDisplayer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b<T, F> implements n {
    public abstract void A(boolean z3);

    public abstract void B(float f4);

    public abstract void C(int i4);

    public abstract void D(F f4);

    @Override // master.flame.danmaku.danmaku.model.n
    public boolean isHardwareAccelerated() {
        return false;
    }

    public abstract void u();

    public abstract void v(d dVar, T t3, float f4, float f5, boolean z3);

    public abstract master.flame.danmaku.danmaku.model.android.b w();

    public abstract T x();

    public abstract void y(master.flame.danmaku.danmaku.model.android.b bVar);

    public abstract void z(T t3);
}
