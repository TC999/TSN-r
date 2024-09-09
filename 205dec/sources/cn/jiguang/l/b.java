package cn.jiguang.l;

import android.content.Context;
import android.net.Uri;
import cn.jiguang.ah.d;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f3704a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f3705b;

    public b(Context context) {
        this.f3704a = context;
        String f4 = d.f("k97muQEI3n3mlJTZdD9q3lC6tvCVkeY7wPOrf0wd0l4zQtrGyn5uq0enBKOySISr");
        cn.jiguang.w.a.b("NubiaOpenIDHelper", "url: " + f4);
        this.f3705b = Uri.parse(f4);
    }

    public String a() {
        try {
            return a.a(this.f3704a, this.f3705b);
        } catch (Exception e4) {
            cn.jiguang.w.a.f("NubiaOpenIDHelper", "get Ids-oa error: " + e4.getMessage());
            return "";
        }
    }
}
