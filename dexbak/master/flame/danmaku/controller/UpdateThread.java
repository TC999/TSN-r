package master.flame.danmaku.controller;

/* renamed from: master.flame.danmaku.controller.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class UpdateThread extends Thread {

    /* renamed from: a */
    volatile boolean f43687a;

    public UpdateThread(String str) {
        super(str);
    }

    /* renamed from: a */
    public boolean m3258a() {
        return this.f43687a;
    }

    /* renamed from: b */
    public void m3257b() {
        this.f43687a = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
    }
}
