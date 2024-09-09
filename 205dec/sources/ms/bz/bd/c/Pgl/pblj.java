package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class pblj {
    public static void a() {
        pblb.c(65537, new pblc());
        pblb.c(65538, new pbld());
        pblb.c(65539, new pble());
        pblb.c(65540, new pblf());
        pblb.c(65541, new pblg());
        pblb.c(65542, new pblh());
        pblb.c(65543, new pbli());
        pblp pblpVar = new pblp();
        pblb.c(196609, pblpVar);
        pblb.c(196610, pblpVar);
        pblb.c(196611, pblpVar);
        pblm pblnVar = pblx.d() ? new pbln() : new pbll();
        pblm.f(pblnVar);
        pblb.c(131073, pblnVar);
        pblb.c(131074, pblnVar);
        String str = (String) pblk.a(16777217, 0, 0L, "0fa1dd", new byte[]{36, 114, 23, 75, 79, 95, 60, 64, 29, 96, 47, 101, 21, 64, 73, 51, 48, 75, 49, 114, 50, 36, 27, 86, 27});
        pblnVar.getClass().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                new File(str2).mkdirs();
                for (String str3 : list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append((String) pblk.a(16777217, 0, 0L, "edd5e2", new byte[]{59}));
                    sb.append(str3);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append((String) pblk.a(16777217, 0, 0L, "73a367", new byte[]{105}));
                    sb3.append(str3);
                    c(context, sb2, sb3.toString());
                }
                return true;
            }
            throw null;
        } catch (Exception unused) {
            String str4 = (String) pblk.a(16777217, 0, 0L, "85abbc", new byte[]{42, 54, 20});
            return false;
        }
    }
}
