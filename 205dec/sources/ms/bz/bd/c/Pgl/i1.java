package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i1 {

    /* renamed from: a  reason: collision with root package name */
    private static int f61404a;

    public static String a(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                f61404a = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return "" + f61404a;
    }
}
