package io.netty.handler.codec.http;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class QueryStringDecoder {
    private static final int DEFAULT_MAX_PARAMS = 1024;
    private final Charset charset;
    private final boolean hasPath;
    private final int maxParams;
    private int nParams;
    private Map<String, List<String>> params;
    private String path;
    private final String uri;

    public QueryStringDecoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    private boolean addParam(Map<String, List<String>> map, String str, String str2) {
        if (this.nParams >= this.maxParams) {
            return false;
        }
        List<String> list = map.get(str);
        if (list == null) {
            list = new ArrayList<>(1);
            map.put(str, list);
        }
        list.add(str2);
        this.nParams++;
        return true;
    }

    public static String decodeComponent(String str) {
        return decodeComponent(str, HttpConstants.DEFAULT_CHARSET);
    }

    private static char decodeHexNibble(char c4) {
        int i4;
        if ('0' > c4 || c4 > '9') {
            char c5 = 'a';
            if ('a' > c4 || c4 > 'f') {
                c5 = 'A';
                if ('A' > c4 || c4 > 'F') {
                    return '\uffff';
                }
            }
            i4 = (c4 - c5) + 10;
        } else {
            i4 = c4 - '0';
        }
        return (char) i4;
    }

    private void decodeParams(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.params = linkedHashMap;
        int i4 = 0;
        this.nParams = 0;
        String str2 = null;
        int i5 = 0;
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            if (charAt == '=' && str2 == null) {
                if (i5 != i4) {
                    str2 = decodeComponent(str.substring(i5, i4), this.charset);
                }
            } else if (charAt != '&' && charAt != ';') {
                i4++;
            } else if (str2 != null || i5 == i4) {
                if (str2 != null) {
                    if (!addParam(linkedHashMap, str2, decodeComponent(str.substring(i5, i4), this.charset))) {
                        return;
                    }
                    str2 = null;
                }
            } else if (!addParam(linkedHashMap, decodeComponent(str.substring(i5, i4), this.charset), "")) {
                return;
            }
            i5 = i4 + 1;
            i4++;
        }
        if (i5 == i4) {
            if (str2 != null) {
                addParam(linkedHashMap, str2, "");
            }
        } else if (str2 == null) {
            addParam(linkedHashMap, decodeComponent(str.substring(i5, i4), this.charset), "");
        } else {
            addParam(linkedHashMap, str2, decodeComponent(str.substring(i5, i4), this.charset));
        }
    }

    public Map<String, List<String>> parameters() {
        if (this.params == null) {
            if (this.hasPath) {
                int indexOf = this.uri.indexOf(63);
                if (indexOf >= 0 && indexOf < this.uri.length() - 1) {
                    decodeParams(this.uri.substring(indexOf + 1));
                } else {
                    this.params = Collections.emptyMap();
                }
            } else if (this.uri.isEmpty()) {
                this.params = Collections.emptyMap();
            } else {
                decodeParams(this.uri);
            }
        }
        return this.params;
    }

    public String path() {
        if (this.path == null) {
            if (!this.hasPath) {
                this.path = "";
            } else {
                int indexOf = this.uri.indexOf(63);
                this.path = decodeComponent(indexOf < 0 ? this.uri : this.uri.substring(0, indexOf), this.charset);
            }
        }
        return this.path;
    }

    public String uri() {
        return this.uri;
    }

    public QueryStringDecoder(String str, boolean z3) {
        this(str, HttpConstants.DEFAULT_CHARSET, z3);
    }

    public static String decodeComponent(String str, Charset charset) {
        boolean z3;
        int i4;
        if (str == null) {
            return "";
        }
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt == '%' || charAt == '+') {
                z3 = true;
                break;
            }
        }
        z3 = false;
        if (z3) {
            byte[] bArr = new byte[length];
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                char charAt2 = str.charAt(i6);
                if (charAt2 != '%') {
                    if (charAt2 == '+') {
                        i4 = i7 + 1;
                        bArr[i7] = 32;
                        i7 = i4;
                    }
                    bArr[i7] = (byte) charAt2;
                    i7++;
                } else {
                    int i8 = length - 1;
                    if (i6 != i8) {
                        i6++;
                        char charAt3 = str.charAt(i6);
                        if (charAt3 == '%') {
                            i4 = i7 + 1;
                            bArr[i7] = 37;
                            i7 = i4;
                        } else if (i6 != i8) {
                            char decodeHexNibble = decodeHexNibble(charAt3);
                            i6++;
                            char decodeHexNibble2 = decodeHexNibble(str.charAt(i6));
                            if (decodeHexNibble != '\uffff' && decodeHexNibble2 != '\uffff') {
                                charAt2 = (char) ((decodeHexNibble * 16) + decodeHexNibble2);
                                bArr[i7] = (byte) charAt2;
                                i7++;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("invalid escape sequence `%");
                                sb.append(str.charAt(i6 - 1));
                                sb.append(str.charAt(i6));
                                sb.append("' at index ");
                                sb.append(i6 - 2);
                                sb.append(" of: ");
                                sb.append(str);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        } else {
                            throw new IllegalArgumentException("partial escape sequence at end of string: " + str);
                        }
                    } else {
                        throw new IllegalArgumentException("unterminated escape sequence at end of string: " + str);
                    }
                }
                i6++;
            }
            return new String(bArr, 0, i7, charset);
        }
        return str;
    }

    public QueryStringDecoder(String str, Charset charset) {
        this(str, charset, true);
    }

    public QueryStringDecoder(String str, Charset charset, boolean z3) {
        this(str, charset, z3, 1024);
    }

    public QueryStringDecoder(String str, Charset charset, boolean z3, int i4) {
        if (str == null) {
            throw new NullPointerException("getUri");
        }
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        if (i4 > 0) {
            this.uri = str;
            this.charset = charset;
            this.maxParams = i4;
            this.hasPath = z3;
            return;
        }
        throw new IllegalArgumentException("maxParams: " + i4 + " (expected: a positive integer)");
    }

    public QueryStringDecoder(URI uri) {
        this(uri, HttpConstants.DEFAULT_CHARSET);
    }

    public QueryStringDecoder(URI uri, Charset charset) {
        this(uri, charset, 1024);
    }

    public QueryStringDecoder(URI uri, Charset charset, int i4) {
        if (uri == null) {
            throw new NullPointerException("getUri");
        }
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        if (i4 > 0) {
            String rawPath = uri.getRawPath();
            String str = "";
            if (rawPath != null) {
                this.hasPath = true;
            } else {
                this.hasPath = false;
                rawPath = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(rawPath);
            if (uri.getRawQuery() != null) {
                str = '?' + uri.getRawQuery();
            }
            sb.append(str);
            this.uri = sb.toString();
            this.charset = charset;
            this.maxParams = i4;
            return;
        }
        throw new IllegalArgumentException("maxParams: " + i4 + " (expected: a positive integer)");
    }
}
