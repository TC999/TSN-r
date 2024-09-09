package io.netty.handler.codec.http;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class CookieDecoder {
    private static final String COMMENT = "Comment";
    private static final String COMMENTURL = "CommentURL";
    private static final String DISCARD = "Discard";
    private static final String PORT = "Port";
    private static final String VERSION = "Version";
    private final InternalLogger logger = InternalLoggerFactory.getInstance(CookieDecoder.class);
    private final boolean strict;
    private static final CookieDecoder STRICT = new CookieDecoder(true);
    private static final CookieDecoder LAX = new CookieDecoder(false);

    private CookieDecoder(boolean z3) {
        this.strict = z3;
    }

    public static Set<Cookie> decode(String str) {
        return decode(str, true);
    }

    private Set<Cookie> doDecode(String str) {
        int i4;
        int i5;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList(8);
        ArrayList arrayList4 = new ArrayList(8);
        extractKeyValuePairs(str, arrayList3, arrayList4);
        if (arrayList3.isEmpty()) {
            return Collections.emptySet();
        }
        if (((String) arrayList3.get(0)).equalsIgnoreCase("Version")) {
            try {
                i4 = Integer.parseInt((String) arrayList4.get(0));
            } catch (NumberFormatException unused) {
                i4 = 0;
            }
            i5 = 1;
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (arrayList3.size() <= i5) {
            return Collections.emptySet();
        }
        TreeSet treeSet = new TreeSet();
        while (i5 < arrayList3.size()) {
            String str2 = (String) arrayList3.get(i5);
            String str3 = (String) arrayList4.get(i5);
            if (str3 == null) {
                str3 = "";
            }
            DefaultCookie initCookie = initCookie(str2, str3);
            if (initCookie == null) {
                break;
            }
            long j4 = Long.MIN_VALUE;
            ArrayList arrayList5 = new ArrayList(2);
            int i6 = i5 + 1;
            String str4 = null;
            TreeSet treeSet2 = treeSet;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            while (true) {
                if (i6 >= arrayList3.size()) {
                    arrayList = arrayList3;
                    arrayList2 = arrayList4;
                    break;
                }
                String str8 = (String) arrayList3.get(i6);
                arrayList = arrayList3;
                String str9 = (String) arrayList4.get(i6);
                arrayList2 = arrayList4;
                if (!"Discard".equalsIgnoreCase(str8)) {
                    if (!"Secure".equalsIgnoreCase(str8)) {
                        if (!"HTTPOnly".equalsIgnoreCase(str8)) {
                            if (!"Comment".equalsIgnoreCase(str8)) {
                                if (!"CommentURL".equalsIgnoreCase(str8)) {
                                    if (!"Domain".equalsIgnoreCase(str8)) {
                                        if (!"Path".equalsIgnoreCase(str8)) {
                                            if ("Expires".equalsIgnoreCase(str8)) {
                                                try {
                                                    long time = HttpHeaderDateFormat.get().parse(str9).getTime() - System.currentTimeMillis();
                                                    j4 = (time / 1000) + (time % 1000 != 0 ? 1 : 0);
                                                } catch (ParseException unused2) {
                                                }
                                            } else if ("Max-Age".equalsIgnoreCase(str8)) {
                                                j4 = Integer.parseInt(str9);
                                            } else if ("Version".equalsIgnoreCase(str8)) {
                                                i4 = Integer.parseInt(str9);
                                            } else if (!"Port".equalsIgnoreCase(str8)) {
                                                break;
                                            } else {
                                                String[] split = str9.split(",");
                                                int length = split.length;
                                                int i7 = 0;
                                                while (i7 < length) {
                                                    String[] strArr = split;
                                                    try {
                                                        arrayList5.add(Integer.valueOf(split[i7]));
                                                    } catch (NumberFormatException unused3) {
                                                    }
                                                    i7++;
                                                    split = strArr;
                                                }
                                            }
                                        } else {
                                            str6 = str9;
                                        }
                                    } else {
                                        str5 = str9;
                                    }
                                } else {
                                    str7 = str9;
                                }
                            } else {
                                str4 = str9;
                            }
                        } else {
                            z4 = true;
                        }
                    } else {
                        z3 = true;
                    }
                } else {
                    z5 = true;
                }
                i6++;
                i5++;
                arrayList4 = arrayList2;
                arrayList3 = arrayList;
            }
            initCookie.setVersion(i4);
            initCookie.setMaxAge(j4);
            initCookie.setPath(str6);
            initCookie.setDomain(str5);
            initCookie.setSecure(z3);
            initCookie.setHttpOnly(z4);
            if (i4 > 0) {
                initCookie.setComment(str4);
            }
            if (i4 > 1) {
                initCookie.setCommentUrl(str7);
                initCookie.setPorts(arrayList5);
                initCookie.setDiscard(z5);
            }
            treeSet2.add(initCookie);
            i5++;
            treeSet = treeSet2;
            arrayList4 = arrayList2;
            arrayList3 = arrayList;
        }
        return treeSet;
    }

    private static void extractKeyValuePairs(String str, List<String> list, List<String> list2) {
        String substring;
        String str2;
        String sb;
        String substring2;
        int length = str.length();
        int i4 = 0;
        while (i4 != length) {
            char charAt = str.charAt(i4);
            if (charAt != ' ' && charAt != ',' && charAt != ';') {
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        while (i4 != length) {
                            if (str.charAt(i4) == '$') {
                                i4++;
                            } else {
                                String str3 = null;
                                if (i4 == length) {
                                    str2 = null;
                                } else {
                                    int i5 = i4;
                                    while (true) {
                                        char charAt2 = str.charAt(i5);
                                        if (charAt2 == ';') {
                                            substring = str.substring(i4, i5);
                                        } else if (charAt2 != '=') {
                                            i5++;
                                            if (i5 == length) {
                                                substring = str.substring(i4);
                                            }
                                        } else {
                                            String substring3 = str.substring(i4, i5);
                                            int i6 = i5 + 1;
                                            if (i6 == length) {
                                                sb = "";
                                            } else {
                                                char charAt3 = str.charAt(i6);
                                                if (charAt3 != '\"' && charAt3 != '\'') {
                                                    i4 = str.indexOf(59, i6);
                                                    if (i4 > 0) {
                                                        substring2 = str.substring(i6, i4);
                                                    } else {
                                                        substring2 = str.substring(i6);
                                                        i4 = length;
                                                    }
                                                    str2 = substring2;
                                                    str3 = substring3;
                                                } else {
                                                    StringBuilder sb2 = new StringBuilder(str.length() - i6);
                                                    i6++;
                                                    while (true) {
                                                        boolean z3 = false;
                                                        while (i6 != length) {
                                                            if (z3) {
                                                                int i7 = i6 + 1;
                                                                char charAt4 = str.charAt(i6);
                                                                if (charAt4 != '\"' && charAt4 != '\'' && charAt4 != '\\') {
                                                                    sb2.append(charAt4);
                                                                } else {
                                                                    sb2.setCharAt(sb2.length() - 1, charAt4);
                                                                }
                                                                i6 = i7;
                                                            } else {
                                                                int i8 = i6 + 1;
                                                                char charAt5 = str.charAt(i6);
                                                                if (charAt5 == charAt3) {
                                                                    str2 = sb2.toString();
                                                                    str3 = substring3;
                                                                    i4 = i8;
                                                                } else {
                                                                    sb2.append(charAt5);
                                                                    if (charAt5 == '\\') {
                                                                        i6 = i8;
                                                                        z3 = true;
                                                                    } else {
                                                                        i6 = i8;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        sb = sb2.toString();
                                                    }
                                                }
                                            }
                                            str2 = sb;
                                            i4 = i6;
                                            str3 = substring3;
                                        }
                                    }
                                    str2 = null;
                                    str3 = substring;
                                    i4 = i5;
                                }
                                list.add(str3);
                                list2.add(str2);
                                continue;
                            }
                        }
                        return;
                }
            }
            i4++;
        }
    }

    private DefaultCookie initCookie(String str, String str2) {
        int firstInvalidCookieValueOctet;
        int firstInvalidCookieNameOctet;
        if (str == null || str.length() == 0) {
            this.logger.debug("Skipping cookie with null name");
            return null;
        } else if (str2 == null) {
            this.logger.debug("Skipping cookie with null value");
            return null;
        } else {
            CharSequence unwrapValue = CookieUtil.unwrapValue(str2);
            if (unwrapValue == null) {
                this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", unwrapValue);
                return null;
            } else if (this.strict && (firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str)) >= 0) {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", str, Character.valueOf(str.charAt(firstInvalidCookieNameOctet)));
                }
                return null;
            } else {
                boolean z3 = unwrapValue.length() != str2.length();
                if (this.strict && (firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue)) >= 0) {
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", unwrapValue, Character.valueOf(unwrapValue.charAt(firstInvalidCookieValueOctet)));
                    }
                    return null;
                }
                DefaultCookie defaultCookie = new DefaultCookie(str, unwrapValue.toString());
                defaultCookie.setWrap(z3);
                return defaultCookie;
            }
        }
    }

    public static Set<Cookie> decode(String str, boolean z3) {
        return (z3 ? STRICT : LAX).doDecode(str);
    }
}
