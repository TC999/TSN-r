package io.netty.handler.codec.http;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.C14356p;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    private static char decodeHexNibble(char c) {
        int i;
        if ('0' > c || c > '9') {
            char c2 = 'a';
            if ('a' > c || c > 'f') {
                c2 = 'A';
                if ('A' > c || c > 'F') {
                    return C14356p.f41165b;
                }
            }
            i = (c - c2) + 10;
        } else {
            i = c - '0';
        }
        return (char) i;
    }

    private void decodeParams(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.params = linkedHashMap;
        int i = 0;
        this.nParams = 0;
        String str2 = null;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '=' && str2 == null) {
                if (i2 != i) {
                    str2 = decodeComponent(str.substring(i2, i), this.charset);
                }
            } else if (charAt != '&' && charAt != ';') {
                i++;
            } else if (str2 != null || i2 == i) {
                if (str2 != null) {
                    if (!addParam(linkedHashMap, str2, decodeComponent(str.substring(i2, i), this.charset))) {
                        return;
                    }
                    str2 = null;
                }
            } else if (!addParam(linkedHashMap, decodeComponent(str.substring(i2, i), this.charset), "")) {
                return;
            }
            i2 = i + 1;
            i++;
        }
        if (i2 == i) {
            if (str2 != null) {
                addParam(linkedHashMap, str2, "");
            }
        } else if (str2 == null) {
            addParam(linkedHashMap, decodeComponent(str.substring(i2, i), this.charset), "");
        } else {
            addParam(linkedHashMap, str2, decodeComponent(str.substring(i2, i), this.charset));
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

    public QueryStringDecoder(String str, boolean z) {
        this(str, HttpConstants.DEFAULT_CHARSET, z);
    }

    public static String decodeComponent(String str, Charset charset) {
        boolean z;
        int i;
        if (str == null) {
            return "";
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '%' || charAt == '+') {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            byte[] bArr = new byte[length];
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                char charAt2 = str.charAt(i3);
                if (charAt2 != '%') {
                    if (charAt2 == '+') {
                        i = i4 + 1;
                        bArr[i4] = 32;
                        i4 = i;
                    }
                    bArr[i4] = (byte) charAt2;
                    i4++;
                } else {
                    int i5 = length - 1;
                    if (i3 != i5) {
                        i3++;
                        char charAt3 = str.charAt(i3);
                        if (charAt3 == '%') {
                            i = i4 + 1;
                            bArr[i4] = 37;
                            i4 = i;
                        } else if (i3 != i5) {
                            char decodeHexNibble = decodeHexNibble(charAt3);
                            i3++;
                            char decodeHexNibble2 = decodeHexNibble(str.charAt(i3));
                            if (decodeHexNibble != 65535 && decodeHexNibble2 != 65535) {
                                charAt2 = (char) ((decodeHexNibble * 16) + decodeHexNibble2);
                                bArr[i4] = (byte) charAt2;
                                i4++;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("invalid escape sequence `%");
                                sb.append(str.charAt(i3 - 1));
                                sb.append(str.charAt(i3));
                                sb.append("' at index ");
                                sb.append(i3 - 2);
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
                i3++;
            }
            return new String(bArr, 0, i4, charset);
        }
        return str;
    }

    public QueryStringDecoder(String str, Charset charset) {
        this(str, charset, true);
    }

    public QueryStringDecoder(String str, Charset charset, boolean z) {
        this(str, charset, z, 1024);
    }

    public QueryStringDecoder(String str, Charset charset, boolean z, int i) {
        if (str == null) {
            throw new NullPointerException("getUri");
        }
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        if (i > 0) {
            this.uri = str;
            this.charset = charset;
            this.maxParams = i;
            this.hasPath = z;
            return;
        }
        throw new IllegalArgumentException("maxParams: " + i + " (expected: a positive integer)");
    }

    public QueryStringDecoder(URI uri) {
        this(uri, HttpConstants.DEFAULT_CHARSET);
    }

    public QueryStringDecoder(URI uri, Charset charset) {
        this(uri, charset, 1024);
    }

    public QueryStringDecoder(URI uri, Charset charset, int i) {
        if (uri == null) {
            throw new NullPointerException("getUri");
        }
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        if (i > 0) {
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
            this.maxParams = i;
            return;
        }
        throw new IllegalArgumentException("maxParams: " + i + " (expected: a positive integer)");
    }
}
