package ms.bz.bd.c.Pgl;

import java.util.Locale;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class k0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pgla.a().c().getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            StringBuilder sb = new StringBuilder();
            sb.append(language);
            sb.append((String) pblk.a(16777217, 0, 0L, "a3277a", new byte[]{79}));
            sb.append(country);
            str2 = sb.toString();
        } catch (Throwable unused) {
            str2 = null;
        }
        return n1.a(str2);
    }
}
