package net.sourceforge.pinyin4j;

import kotlin.text.Typography;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: net.sourceforge.pinyin4j.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class PinyinFormatter {
    PinyinFormatter() {
    }

    /* renamed from: a */
    private static String m2857a(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.matches("[a-z]*[1-5]?")) {
            if (lowerCase.matches("[a-z]*[1-5]")) {
                int numericValue = Character.getNumericValue(lowerCase.charAt(lowerCase.length() - 1));
                char c = 'a';
                int indexOf = lowerCase.indexOf(97);
                int indexOf2 = lowerCase.indexOf(101);
                int indexOf3 = lowerCase.indexOf("ou");
                if (-1 == indexOf) {
                    if (-1 == indexOf2) {
                        if (-1 != indexOf3) {
                            c = "ou".charAt(0);
                            indexOf = indexOf3;
                        } else {
                            indexOf = lowerCase.length() - 1;
                            while (true) {
                                if (indexOf < 0) {
                                    c = Typography.f41566b;
                                    indexOf = -1;
                                    break;
                                } else if (String.valueOf(lowerCase.charAt(indexOf)).matches("[aeiouv]")) {
                                    c = lowerCase.charAt(indexOf);
                                    break;
                                } else {
                                    indexOf--;
                                }
                            }
                        }
                    } else {
                        indexOf = indexOf2;
                        c = 'e';
                    }
                }
                if ('$' == c || -1 == indexOf) {
                    return lowerCase;
                }
                return lowerCase.substring(0, indexOf).replaceAll("v", "ü") + "āáăàaēéĕèeīíĭìiōóŏòoūúŭùuǖǘǚǜü".charAt(("aeiouv".indexOf(c) * 5) + (numericValue - 1)) + lowerCase.substring(indexOf + 1, lowerCase.length() - 1).replaceAll("v", "ü");
            }
            return lowerCase.replaceAll("v", "ü");
        }
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m2856b(String str, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinToneType hanyuPinyinToneType = HanyuPinyinToneType.f44123d;
        if (hanyuPinyinToneType == hanyuPinyinOutputFormat.m2836b() && (HanyuPinyinVCharType.f44126c == hanyuPinyinOutputFormat.m2835c() || HanyuPinyinVCharType.f44125b == hanyuPinyinOutputFormat.m2835c())) {
            throw new BadHanyuPinyinOutputFormatCombination("tone marks cannot be added to v or u:");
        }
        if (HanyuPinyinToneType.f44122c == hanyuPinyinOutputFormat.m2836b()) {
            str = str.replaceAll("[1-5]", "");
        } else if (hanyuPinyinToneType == hanyuPinyinOutputFormat.m2836b()) {
            str = m2857a(str.replaceAll("u:", "v"));
        }
        if (HanyuPinyinVCharType.f44126c == hanyuPinyinOutputFormat.m2835c()) {
            str = str.replaceAll("u:", "v");
        } else if (HanyuPinyinVCharType.f44127d == hanyuPinyinOutputFormat.m2835c()) {
            str = str.replaceAll("u:", "ü");
        }
        return HanyuPinyinCaseType.f44115b == hanyuPinyinOutputFormat.m2837a() ? str.toUpperCase() : str;
    }
}
