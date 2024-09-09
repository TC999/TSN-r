package cn.jiguang.common.n;

import android.os.Build;
import cn.jiguang.common.m.h;
import cn.jiguang.common.m.i;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends b {

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f3542e = new File("/dev/cpuctl/tasks").exists();

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f3543f = Pattern.compile("^([A-Za-z]{1}[A-Za-z0-9_]*[\\.|:])*[A-Za-z][A-Za-z0-9_]*$");

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3544a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3545b;

    /* renamed from: cn.jiguang.common.n.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class C0061a extends Exception {
        public C0061a(int i4) {
            super(String.format("The process %d does not belong to any application", Integer.valueOf(i4)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int i4) {
        super(i4);
        int a4;
        boolean z3;
        String substring;
        String str = this.f3546c;
        if (str == null || !f3543f.matcher(str).matches() || !new File("/data/data", a()).exists()) {
            throw new C0061a(i4);
        }
        if (f3542e) {
            cn.jiguang.common.m.a b4 = b();
            cn.jiguang.common.m.b a5 = b4.a("cpuacct");
            cn.jiguang.common.m.b a6 = b4.a("cpu");
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (a6 == null || a5 == null || !a5.f3487c.contains("pid_")) {
                        throw new C0061a(i4);
                    }
                    int i5 = !a6.f3487c.contains("bg_non_interactive");
                    substring = a5.f3487c.split(TTPathConst.sSeparator)[1].replace("uid_", "");
                    i4 = i5;
                } else if (a6 == null || a5 == null || !a6.f3487c.contains("apps")) {
                    throw new C0061a(i4);
                } else {
                    int i6 = !a6.f3487c.contains("bg_non_interactive");
                    String str2 = a5.f3487c;
                    substring = str2.substring(str2.lastIndexOf(TTPathConst.sSeparator) + 1);
                    i4 = i6;
                }
                a4 = Integer.parseInt(substring);
                z3 = i4;
            } catch (Throwable unused) {
                a4 = g().a();
                z3 = i4;
            }
        } else {
            h f4 = f();
            i g4 = g();
            boolean z4 = f4.m() == 0;
            a4 = g4.a();
            z3 = z4;
        }
        this.f3544a = z3;
        this.f3545b = a4;
    }

    public String a() {
        return this.f3546c.split(":")[0];
    }
}
