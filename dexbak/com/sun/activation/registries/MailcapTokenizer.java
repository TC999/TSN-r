package com.sun.activation.registries;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* renamed from: com.sun.activation.registries.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MailcapTokenizer {

    /* renamed from: h */
    public static final int f35824h = 0;

    /* renamed from: i */
    public static final int f35825i = 1;

    /* renamed from: j */
    public static final int f35826j = 2;

    /* renamed from: k */
    public static final int f35827k = 5;

    /* renamed from: l */
    public static final int f35828l = 47;

    /* renamed from: m */
    public static final int f35829m = 59;

    /* renamed from: n */
    public static final int f35830n = 61;

    /* renamed from: a */
    private String f35831a;

    /* renamed from: c */
    private int f35833c;

    /* renamed from: b */
    private int f35832b = 0;

    /* renamed from: d */
    private int f35834d = 1;

    /* renamed from: e */
    private String f35835e = "";

    /* renamed from: f */
    private boolean f35836f = false;

    /* renamed from: g */
    private char f35837g = ';';

    public MailcapTokenizer(String str) {
        this.f35831a = str;
        this.f35833c = str.length();
    }

    /* renamed from: a */
    private static String m16463a(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (i < length - 1) {
                i++;
                stringBuffer.append(str.charAt(i));
            } else {
                stringBuffer.append(charAt);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: d */
    private static boolean m16460d(char c) {
        return Character.isISOControl(c);
    }

    /* renamed from: e */
    private static boolean m16459e(char c) {
        if (c != '\"' && c != ',' && c != '/' && c != '(' && c != ')') {
            switch (c) {
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                    break;
                default:
                    switch (c) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    /* renamed from: f */
    private static boolean m16458f(char c) {
        return (m16459e(c) || m16460d(c) || m16457g(c)) ? false : true;
    }

    /* renamed from: g */
    private static boolean m16457g(char c) {
        return Character.isWhitespace(c);
    }

    /* renamed from: h */
    public static String m16456h(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 5 ? i != 47 ? i != 59 ? i != 61 ? "really unknown" : "'='" : "';'" : "'/'" : "EOI" : "string" : CampaignEx.JSON_NATIVE_VIDEO_START : "unknown";
    }

    /* renamed from: j */
    private void m16454j() {
        int i;
        int i2 = this.f35832b;
        boolean z = false;
        while (true) {
            i = this.f35832b;
            if (i >= this.f35833c || z) {
                break;
            } else if (this.f35831a.charAt(i) != this.f35837g) {
                this.f35832b++;
            } else {
                z = true;
            }
        }
        this.f35834d = 2;
        this.f35835e = m16463a(this.f35831a.substring(i2, i));
    }

    /* renamed from: k */
    private void m16453k() {
        int i = this.f35832b;
        while (true) {
            int i2 = this.f35832b;
            if (i2 >= this.f35833c || !m16458f(this.f35831a.charAt(i2))) {
                break;
            }
            this.f35832b++;
        }
        this.f35834d = 2;
        this.f35835e = this.f35831a.substring(i, this.f35832b);
    }

    /* renamed from: b */
    public int m16462b() {
        return this.f35834d;
    }

    /* renamed from: c */
    public String m16461c() {
        return this.f35835e;
    }

    /* renamed from: i */
    public int m16455i() {
        if (this.f35832b < this.f35833c) {
            while (true) {
                int i = this.f35832b;
                if (i >= this.f35833c || !m16457g(this.f35831a.charAt(i))) {
                    break;
                }
                this.f35832b++;
            }
            int i2 = this.f35832b;
            if (i2 < this.f35833c) {
                char charAt = this.f35831a.charAt(i2);
                if (this.f35836f) {
                    if (charAt != ';' && charAt != '=') {
                        m16454j();
                    } else {
                        this.f35834d = charAt;
                        this.f35835e = new Character(charAt).toString();
                        this.f35832b++;
                    }
                } else if (m16458f(charAt)) {
                    m16453k();
                } else if (charAt != '/' && charAt != ';' && charAt != '=') {
                    this.f35834d = 0;
                    this.f35835e = new Character(charAt).toString();
                    this.f35832b++;
                } else {
                    this.f35834d = charAt;
                    this.f35835e = new Character(charAt).toString();
                    this.f35832b++;
                }
            } else {
                this.f35834d = 5;
                this.f35835e = null;
            }
        } else {
            this.f35834d = 5;
            this.f35835e = null;
        }
        return this.f35834d;
    }

    /* renamed from: l */
    public void m16452l(boolean z) {
        this.f35836f = z;
    }
}
