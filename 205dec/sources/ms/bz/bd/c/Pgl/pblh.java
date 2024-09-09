package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.Map;
import ms.bz.bd.c.Pgl.pblb;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class pblh extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        String str2;
        Context c4 = pgla.a().c();
        ApplicationInfo applicationInfo = c4.getPackageManager().getApplicationInfo(c4.getPackageName(), 0);
        String str3 = applicationInfo.sourceDir;
        if (str3 == null) {
            str3 = applicationInfo.publicSourceDir;
        }
        Map<Integer, String> a4 = pblx.a(str3);
        String str4 = "";
        String str5 = (a4 == null || !a4.containsKey(1903654775)) ? "" : a4.get(1903654775);
        if (str5 != null && str5.length() > 0) {
            JSONObject jSONObject = new JSONObject(str5);
            try {
                str2 = jSONObject.getString((String) pblk.a(16777217, 0, 0L, "0dfcde", new byte[]{44, 99, 1, 22, 100, 103, 62, 64, 57, 52, 30, 101, 29, 22, 85, 124, 54, 73}));
            } catch (JSONException unused) {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append((String) pblk.a(16777217, 0, 0L, "d06417", new byte[]{46}));
            try {
                str4 = jSONObject.getString((String) pblk.a(16777217, 0, 0L, "2d85fb", new byte[]{49, 99, 71, 68, 88, 102, 52, 122, 107, 112, 42, 106, 79}));
            } catch (JSONException unused2) {
            }
            sb.append(str4);
            str4 = sb.toString();
        }
        return str4.length() == 0 ? (String) pblk.a(16777217, 0, 0L, "1b91d1", new byte[]{14, 111, 68, 64}) : str4;
    }
}
