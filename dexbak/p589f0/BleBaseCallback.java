package p589f0;

import android.os.Handler;

/* renamed from: f0.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class BleBaseCallback {

    /* renamed from: a */
    private String f40128a;

    /* renamed from: b */
    private Handler f40129b;

    /* renamed from: a */
    public Handler m12780a() {
        return this.f40129b;
    }

    /* renamed from: b */
    public String m12779b() {
        return this.f40128a;
    }

    /* renamed from: c */
    public void m12778c(Handler handler) {
        this.f40129b = handler;
    }

    /* renamed from: d */
    public void m12777d(String str) {
        this.f40128a = str;
    }
}
