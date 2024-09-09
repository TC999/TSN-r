package l0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f60803a;

    /* renamed from: b  reason: collision with root package name */
    private static Resources f60804b;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static Context f60805c;

    private static int a(Context context, String str, String str2) {
        if (f60804b == null) {
            f60804b = context.getResources();
        }
        return f60804b.getIdentifier(str, str2, c(context));
    }

    public static Drawable b(Context context, String str) {
        return context.getResources().getDrawable(d(context, str));
    }

    private static String c(Context context) {
        if (f60803a == null) {
            f60803a = context.getPackageName();
        }
        return f60803a;
    }

    public static int d(Context context, String str) {
        return a(context, str, "drawable");
    }

    public static int e(Context context, String str) {
        return a(context, str, "id");
    }
}
