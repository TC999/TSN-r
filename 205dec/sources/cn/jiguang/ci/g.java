package cn.jiguang.ci;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g extends b {
    public g(Context context) {
        super(context, "NET_TCP_REGISTER");
    }

    public void a(int i4) {
        f();
        if (i4 != 0) {
            c(1);
            d(i4);
        }
    }

    public void a(String str, int i4, String str2) {
        c(str);
        b(i4);
        b(str2);
        e();
    }
}
