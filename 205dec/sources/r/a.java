package r;

import net.sourceforge.pinyin4j.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Cn2Spell.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static StringBuffer f62031a = new StringBuffer();

    public static String a(String str) {
        f62031a.setLength(0);
        char[] charArray = str.toCharArray();
        net.sourceforge.pinyin4j.format.b bVar = new net.sourceforge.pinyin4j.format.b();
        bVar.e(net.sourceforge.pinyin4j.format.a.f61530c);
        bVar.f(net.sourceforge.pinyin4j.format.c.f61536c);
        for (int i4 = 0; i4 < charArray.length; i4++) {
            if (charArray[i4] > '\u0080') {
                try {
                    f62031a.append(e.h(charArray[i4], bVar)[0]);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } else {
                f62031a.append(charArray[i4]);
            }
        }
        return f62031a.toString();
    }

    public static String b(String str) {
        f62031a.setLength(0);
        char charAt = str.charAt(0);
        String[] g4 = e.g(charAt);
        if (g4 != null) {
            f62031a.append(g4[0].charAt(0));
        } else {
            f62031a.append(charAt);
        }
        return f62031a.toString();
    }

    public static String c(String str) {
        f62031a.setLength(0);
        char[] charArray = str.toCharArray();
        net.sourceforge.pinyin4j.format.b bVar = new net.sourceforge.pinyin4j.format.b();
        bVar.e(net.sourceforge.pinyin4j.format.a.f61530c);
        bVar.f(net.sourceforge.pinyin4j.format.c.f61536c);
        for (int i4 = 0; i4 < charArray.length; i4++) {
            if (charArray[i4] > '\u0080') {
                try {
                    f62031a.append(e.h(charArray[i4], bVar)[0].charAt(0));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } else {
                f62031a.append(charArray[i4]);
            }
        }
        return f62031a.toString();
    }
}
