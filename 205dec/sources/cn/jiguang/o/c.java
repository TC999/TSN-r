package cn.jiguang.o;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f3760a = "";

    /* renamed from: b  reason: collision with root package name */
    private Context f3761b;

    public c(Context context) {
        this.f3761b = context;
    }

    public String a() {
        String c4 = b.a(this.f3761b).c();
        return c4 == null ? "" : c4;
    }

    public void a(String str) {
        this.f3760a = str;
    }
}
