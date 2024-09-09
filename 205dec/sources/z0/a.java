package z0;

import android.os.Handler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BleBaseCallback.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private String f65074a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f65075b;

    public Handler a() {
        return this.f65075b;
    }

    public String b() {
        return this.f65074a;
    }

    public void c(Handler handler) {
        this.f65075b = handler;
    }

    public void d(String str) {
        this.f65074a = str;
    }
}
