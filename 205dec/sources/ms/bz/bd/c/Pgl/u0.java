package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.gd.sr.xv;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class u0 {

    /* renamed from: a  reason: collision with root package name */
    private final pblb f61464a;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface pblb {
        void c(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class pgla implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f61465a;

        pgla(Context context) {
            this.f61465a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            w0 w0Var;
            z0 z0Var;
            try {
                if (((String) pblk.a(16777217, 0, 0L, "5fe980", new byte[]{5, 87, 35, 126})).equals(u0.b(u0.this).toUpperCase())) {
                    new t0(this.f61465a).a(u0.this.f61464a);
                } else if (((String) pblk.a(16777217, 0, 0L, "6b93a6", new byte[]{15, 85, 107, 112, 123, 8})).equals(u0.b(u0.this).toUpperCase())) {
                    new v0(this.f61465a).a(u0.this.f61464a);
                } else {
                    if (((String) pblk.a(16777217, 0, 0L, "cf2227", new byte[]{93, 84, 113, 105})).equals(u0.b(u0.this).toUpperCase())) {
                        z0Var = new z0(this.f61465a);
                    } else if (!((String) pblk.a(16777217, 0, 0L, "50adb7", new byte[]{11, 28, 55, 32, 113, 21, 5})).equals(u0.b(u0.this).toUpperCase())) {
                        if (((String) pblk.a(16777217, 0, 0L, "904ea2", new byte[]{18, 6, 98})).equals(u0.b(u0.this).toUpperCase()) || ((String) pblk.a(16777217, 0, 0L, "b51d4a", new byte[]{85, 18, 112, 34, 38, 83, 78, 39})).equals(u0.b(u0.this).toUpperCase()) || u0.this.d() || ((String) pblk.a(16777217, 0, 0L, "e2da42", new byte[]{71, 3, 34, 60})).equals(u0.b(u0.this).toUpperCase()) || u0.this.g() || ((String) pblk.a(16777217, 0, 0L, "8b090c", new byte[]{26, 65, 110, 126, 58, 90, 28})).equals(u0.b(u0.this).toUpperCase())) {
                            return;
                        }
                        if (((String) pblk.a(16777217, 0, 0L, "9579f1", new byte[]{4, 18, 106, 98, 111, 9})).equals(u0.b(u0.this).toUpperCase())) {
                            w0Var = new w0(this.f61465a);
                        } else if (!((String) pblk.a(16777217, 0, 0L, "e2b6cc", new byte[]{89, 31, 37, 109, 112, 91, 84, 50})).equals(u0.b(u0.this).toUpperCase())) {
                            return;
                        } else {
                            w0Var = new w0(this.f61465a);
                        }
                        w0Var.a(u0.this.f61464a);
                        return;
                    } else {
                        z0Var = new z0(this.f61465a);
                    }
                    z0Var.b(u0.this.f61464a);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public u0(pblb pblbVar) {
        this.f61464a = pblbVar;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName((String) pblk.a(16777217, 0, 0L, "1dbe34", new byte[]{33, 104, 21, 3, 3, 42, 54, 11, 60, 38, 110, 85, 8, 2, 24, 38, 63, 117, 33, 58, 48, 99, 3, 5, 5, 38, 33}));
            Method method = cls.getMethod((String) pblk.a(16777217, 0, 0L, "675b2d", new byte[]{32, 48, 82}), String.class, String.class);
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = (String) pblk.a(16777217, 0, 0L, "931591", new byte[]{61, 63, 73, 79, 9, 49, 52});
            return (String) method.invoke(cls, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    static String b(u0 u0Var) {
        u0Var.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }

    private void f(Context context) {
        new xv(new pgla(context), "z/bd/c/Pgl/u0").start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x024b, code lost:
        if (g() != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.u0.c(android.content.Context):void");
    }

    public boolean d() {
        String a4 = a((String) pblk.a(16777217, 0, 0L, "40a911", new byte[]{55, 61, 92, 79, 27, 47, 59, 21, 126, 111, 55, 55, 23, 64, 11, 104, 59, 16, 50, 108, 41}));
        return !TextUtils.isEmpty(a4) && a4.equalsIgnoreCase((String) pblk.a(16777217, 0, 0L, "f5b834", new byte[]{81, 5, 52, 105, 33, 6, 74, 39}));
    }

    public boolean g() {
        String a4 = a((String) pblk.a(16777217, 0, 0L, "a593e9", new byte[]{98, 56, 4, 84, 73, 59, 107, 90, 120, 113, Byte.MAX_VALUE, 51, 95, 68, 78}));
        return (TextUtils.isEmpty(a4) || a4.equalsIgnoreCase((String) pblk.a(16777217, 0, 0L, "08a12a", new byte[]{52, 52, 25, 75, 2, 97, 61}))) ? false : true;
    }
}
