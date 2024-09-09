package master.flame.danmaku.controller;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UpdateThread.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i extends Thread {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f61003a;

    public i(String str) {
        super(str);
    }

    public boolean a() {
        return this.f61003a;
    }

    public void b() {
        this.f61003a = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
    }
}
