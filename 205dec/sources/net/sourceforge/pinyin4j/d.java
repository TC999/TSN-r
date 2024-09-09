package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PinyinFormatter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class d {
    d() {
    }

    private static String a(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.matches("[a-z]*[1-5]?")) {
            if (lowerCase.matches("[a-z]*[1-5]")) {
                int numericValue = Character.getNumericValue(lowerCase.charAt(lowerCase.length() - 1));
                char c4 = 'a';
                int indexOf = lowerCase.indexOf(97);
                int indexOf2 = lowerCase.indexOf(101);
                int indexOf3 = lowerCase.indexOf("ou");
                if (-1 == indexOf) {
                    if (-1 == indexOf2) {
                        if (-1 != indexOf3) {
                            c4 = "ou".charAt(0);
                            indexOf = indexOf3;
                        } else {
                            indexOf = lowerCase.length() - 1;
                            while (true) {
                                if (indexOf < 0) {
                                    c4 = '$';
                                    indexOf = -1;
                                    break;
                                } else if (String.valueOf(lowerCase.charAt(indexOf)).matches("[aeiouv]")) {
                                    c4 = lowerCase.charAt(indexOf);
                                    break;
                                } else {
                                    indexOf--;
                                }
                            }
                        }
                    } else {
                        indexOf = indexOf2;
                        c4 = 'e';
                    }
                }
                if ('$' == c4 || -1 == indexOf) {
                    return lowerCase;
                }
                return lowerCase.substring(0, indexOf).replaceAll("v", "\u00fc") + "\u0101\u00e1\u0103\u00e0a\u0113\u00e9\u0115\u00e8e\u012b\u00ed\u012d\u00eci\u014d\u00f3\u014f\u00f2o\u016b\u00fa\u016d\u00f9u\u01d6\u01d8\u01da\u01dc\u00fc".charAt(("aeiouv".indexOf(c4) * 5) + (numericValue - 1)) + lowerCase.substring(indexOf + 1, lowerCase.length() - 1).replaceAll("v", "\u00fc");
            }
            return lowerCase.replaceAll("v", "\u00fc");
        }
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str, net.sourceforge.pinyin4j.format.b bVar) throws BadHanyuPinyinOutputFormatCombination {
        net.sourceforge.pinyin4j.format.c cVar = net.sourceforge.pinyin4j.format.c.f61537d;
        if (cVar == bVar.b() && (net.sourceforge.pinyin4j.format.d.f61540c == bVar.c() || net.sourceforge.pinyin4j.format.d.f61539b == bVar.c())) {
            throw new BadHanyuPinyinOutputFormatCombination("tone marks cannot be added to v or u:");
        }
        if (net.sourceforge.pinyin4j.format.c.f61536c == bVar.b()) {
            str = str.replaceAll("[1-5]", "");
        } else if (cVar == bVar.b()) {
            str = a(str.replaceAll("u:", "v"));
        }
        if (net.sourceforge.pinyin4j.format.d.f61540c == bVar.c()) {
            str = str.replaceAll("u:", "v");
        } else if (net.sourceforge.pinyin4j.format.d.f61541d == bVar.c()) {
            str = str.replaceAll("u:", "\u00fc");
        }
        return net.sourceforge.pinyin4j.format.a.f61529b == bVar.a() ? str.toUpperCase() : str;
    }
}
