package cn.jpush.android.f;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f4194a;

    /* renamed from: b  reason: collision with root package name */
    private long f4195b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f4196c;

    public d(String str, long j4, JSONObject jSONObject) {
        this.f4194a = str;
        this.f4195b = j4;
        this.f4196c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f4194a, this.f4195b, this.f4196c);
    }
}
