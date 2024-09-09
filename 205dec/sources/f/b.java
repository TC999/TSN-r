package f;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ReportByEmail.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b {
    public static boolean a(String str, String str2) {
        a aVar = new a("dylanandroid2dev@163.com", "dylanandroid2dev");
        aVar.v("smtp.163.com");
        aVar.y("25");
        aVar.t(true);
        String[] E = cn.bluemobi.dylan.uncaughtexception.a.E();
        if (E != null && E.length > 0) {
            aVar.B(E);
            aVar.u("dylanandroid2dev@163.com");
            aVar.A("\u3010" + str + "\u3011\u5f02\u5e38\u5d29\u6e83");
            aVar.q(str2.toString());
            try {
                if (aVar.p()) {
                    Log.i(str, "\u90ae\u4ef6\u53d1\u9001\u6210\u529f");
                    return true;
                }
                Log.i(str, "\u90ae\u4ef6\u53d1\u9001\u5931\u8d25");
                return false;
            } catch (Exception e4) {
                Log.e(str, "\u90ae\u4ef6\u53d1\u9001\u5f02\u5e38", e4);
            }
        }
        return false;
    }
}
