package p637r;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

/* renamed from: r.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class Cn2Spell {

    /* renamed from: a */
    public static StringBuffer f44597a = new StringBuffer();

    /* renamed from: a */
    public static String m2136a(String str) {
        f44597a.setLength(0);
        char[] charArray = str.toCharArray();
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.m2833e(HanyuPinyinCaseType.f44116c);
        hanyuPinyinOutputFormat.m2832f(HanyuPinyinToneType.f44122c);
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 128) {
                try {
                    f44597a.append(PinyinHelper.m2848h(charArray[i], hanyuPinyinOutputFormat)[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                f44597a.append(charArray[i]);
            }
        }
        return f44597a.toString();
    }

    /* renamed from: b */
    public static String m2135b(String str) {
        f44597a.setLength(0);
        char charAt = str.charAt(0);
        String[] m2849g = PinyinHelper.m2849g(charAt);
        if (m2849g != null) {
            f44597a.append(m2849g[0].charAt(0));
        } else {
            f44597a.append(charAt);
        }
        return f44597a.toString();
    }

    /* renamed from: c */
    public static String m2134c(String str) {
        f44597a.setLength(0);
        char[] charArray = str.toCharArray();
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.m2833e(HanyuPinyinCaseType.f44116c);
        hanyuPinyinOutputFormat.m2832f(HanyuPinyinToneType.f44122c);
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 128) {
                try {
                    f44597a.append(PinyinHelper.m2848h(charArray[i], hanyuPinyinOutputFormat)[0].charAt(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                f44597a.append(charArray[i]);
            }
        }
        return f44597a.toString();
    }
}
