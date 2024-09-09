package f0;

import android.os.Handler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: BleBaseCallback.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private String f54659a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f54660b;

    public Handler a() {
        return this.f54660b;
    }

    public String b() {
        return this.f54659a;
    }

    public void c(Handler handler) {
        this.f54660b = handler;
    }

    public void d(String str) {
        this.f54659a = str;
    }
}
