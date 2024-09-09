package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import ms.bz.bd.c.Pgl.u0;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class s0 {

    /* renamed from: c  reason: collision with root package name */
    private static volatile s0 f61456c;

    /* renamed from: a  reason: collision with root package name */
    private u0 f61457a;

    /* renamed from: b  reason: collision with root package name */
    private String f61458b = null;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class pgla implements u0.pblb {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.u0.pblb
        public void c(String str) {
            s0.this.f61458b = str;
        }
    }

    private s0(Context context) {
        this.f61457a = null;
        try {
            u0 u0Var = new u0(new pgla());
            this.f61457a = u0Var;
            if (Build.VERSION.SDK_INT <= 32) {
                u0Var.c(context);
            }
        } catch (Throwable unused) {
            String str = (String) pblk.a(16777217, 0, 0L, "596baa", new byte[]{43, 46, 70});
        }
    }

    public static s0 c(Context context) {
        if (f61456c == null) {
            synchronized (s0.class) {
                if (f61456c == null) {
                    f61456c = new s0(context);
                }
            }
        }
        return f61456c;
    }

    public String a() {
        return this.f61458b;
    }
}
