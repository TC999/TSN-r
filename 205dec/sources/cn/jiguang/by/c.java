package cn.jiguang.by;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.f.h;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f3164a;

    /* renamed from: b  reason: collision with root package name */
    private static c f3165b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Integer> f3166c = new HashMap();

    private c() {
    }

    public static c a() {
        if (f3165b == null) {
            synchronized (c.class) {
                if (f3165b == null) {
                    f3165b = new c();
                }
            }
        }
        return f3165b;
    }

    public static void a(int i4) {
        if (i4 > 3 || i4 < 0) {
            return;
        }
        f3164a = i4;
    }

    public void a(Context context, int i4) {
        String c4 = h.c(context);
        boolean equals = "wifi".equals(c4);
        String j4 = (equals && cn.jiguang.d.a.l(context)) ? cn.jiguang.f.a.j(context) : "";
        boolean z3 = !TextUtils.isEmpty(j4);
        if (!equals || z3) {
            this.f3166c.put(c4 + j4, Integer.valueOf(i4));
        }
        if (z3) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.h(j4).a((cn.jiguang.g.a<Integer>) Integer.valueOf(i4)));
        }
    }

    public int b(int i4) {
        int i5 = f3164a;
        if (i5 == 2 || i5 == 1) {
            return i5;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                return i5;
            }
            return 2;
        }
        return 1;
    }
}
