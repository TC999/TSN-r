package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.SharedPreferences;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class s extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        Context c4 = pgla.a().c();
        String[] split = str.split((String) pblk.a(16777217, 0, 0L, "779703", new byte[]{26, 41}));
        String str2 = split[0];
        String str3 = split[1];
        SharedPreferences.Editor edit = com.bytedance.sdk.openadsdk.api.plugin.w.w(c4, str2, 0).edit();
        edit.putString(str3, (String) obj);
        edit.commit();
        return null;
    }
}
