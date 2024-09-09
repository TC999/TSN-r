package cn.jiguang.ao;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h {

    /* renamed from: e  reason: collision with root package name */
    private static h f2341e = new h();

    /* renamed from: a  reason: collision with root package name */
    private String f2342a;

    /* renamed from: b  reason: collision with root package name */
    private String f2343b;

    /* renamed from: c  reason: collision with root package name */
    private String f2344c;

    /* renamed from: d  reason: collision with root package name */
    private String f2345d;

    private h() {
    }

    public static h a() {
        return f2341e;
    }

    public String a(Context context) {
        if (cn.jiguang.ar.a.a().f(2009)) {
            if (TextUtils.isEmpty(this.f2342a)) {
                String str = (String) cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.b());
                this.f2342a = str;
                if (TextUtils.isEmpty(str)) {
                    if (cn.jiguang.ar.a.a().e(2009)) {
                        this.f2342a = String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
                        cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.b().a(this.f2342a));
                        return this.f2342a;
                    }
                    return "";
                }
                return this.f2342a;
            }
            return this.f2342a;
        }
        return "";
    }

    public void a(Context context, String str) {
        this.f2343b = str;
        cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.e().a(str));
    }

    public String b(Context context) {
        if (cn.jiguang.ar.a.a().f(2008)) {
            if (TextUtils.isEmpty(this.f2344c)) {
                String str = (String) cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.c());
                this.f2344c = str;
                if (TextUtils.isEmpty(str)) {
                    if (cn.jiguang.ar.a.a().e(2008)) {
                        this.f2344c = String.format(Locale.ENGLISH, Build.MANUFACTURER, new Object[0]);
                        cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.c().a(this.f2344c));
                        return this.f2344c;
                    }
                    return "";
                }
                return this.f2344c;
            }
            return this.f2344c;
        }
        return "";
    }

    public String c(Context context) {
        if (cn.jiguang.ar.a.a().f(2011)) {
            if (TextUtils.isEmpty(this.f2343b)) {
                String str = (String) cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.e());
                this.f2343b = str;
                if (TextUtils.isEmpty(str)) {
                    if (cn.jiguang.ar.a.a().e(2011)) {
                        this.f2343b = Integer.toString(Build.VERSION.SDK_INT);
                        cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.e().a(this.f2343b));
                        return this.f2343b;
                    }
                    return "";
                }
                return this.f2343b;
            }
            return this.f2343b;
        }
        return "";
    }

    public String d(Context context) {
        if (cn.jiguang.ar.a.a().f(1019)) {
            if (TextUtils.isEmpty(this.f2345d)) {
                String str = (String) cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.d());
                this.f2345d = str;
                if (TextUtils.isEmpty(str)) {
                    if (cn.jiguang.ar.a.a().e(1019)) {
                        this.f2345d = cn.jiguang.bb.e.a(context);
                        cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.d().a(this.f2345d));
                        return this.f2345d;
                    }
                    return "";
                }
                return this.f2345d;
            }
            return this.f2345d;
        }
        return "";
    }
}
