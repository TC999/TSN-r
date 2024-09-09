package com.sun.activation.registries;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: MailcapTokenizer.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: h  reason: collision with root package name */
    public static final int f50245h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f50246i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f50247j = 2;

    /* renamed from: k  reason: collision with root package name */
    public static final int f50248k = 5;

    /* renamed from: l  reason: collision with root package name */
    public static final int f50249l = 47;

    /* renamed from: m  reason: collision with root package name */
    public static final int f50250m = 59;

    /* renamed from: n  reason: collision with root package name */
    public static final int f50251n = 61;

    /* renamed from: a  reason: collision with root package name */
    private String f50252a;

    /* renamed from: c  reason: collision with root package name */
    private int f50254c;

    /* renamed from: b  reason: collision with root package name */
    private int f50253b = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f50255d = 1;

    /* renamed from: e  reason: collision with root package name */
    private String f50256e = "";

    /* renamed from: f  reason: collision with root package name */
    private boolean f50257f = false;

    /* renamed from: g  reason: collision with root package name */
    private char f50258g = ';';

    public d(String str) {
        this.f50252a = str;
        this.f50254c = str.length();
    }

    private static String a(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        int i4 = 0;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            if (charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (i4 < length - 1) {
                i4++;
                stringBuffer.append(str.charAt(i4));
            } else {
                stringBuffer.append(charAt);
            }
            i4++;
        }
        return stringBuffer.toString();
    }

    private static boolean d(char c4) {
        return Character.isISOControl(c4);
    }

    private static boolean e(char c4) {
        if (c4 != '\"' && c4 != ',' && c4 != '/' && c4 != '(' && c4 != ')') {
            switch (c4) {
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                    break;
                default:
                    switch (c4) {
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

    private static boolean f(char c4) {
        return (e(c4) || d(c4) || g(c4)) ? false : true;
    }

    private static boolean g(char c4) {
        return Character.isWhitespace(c4);
    }

    public static String h(int i4) {
        return i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 5 ? i4 != 47 ? i4 != 59 ? i4 != 61 ? "really unknown" : "'='" : "';'" : "'/'" : "EOI" : "string" : CampaignEx.JSON_NATIVE_VIDEO_START : "unknown";
    }

    private void j() {
        int i4;
        int i5 = this.f50253b;
        boolean z3 = false;
        while (true) {
            i4 = this.f50253b;
            if (i4 >= this.f50254c || z3) {
                break;
            } else if (this.f50252a.charAt(i4) != this.f50258g) {
                this.f50253b++;
            } else {
                z3 = true;
            }
        }
        this.f50255d = 2;
        this.f50256e = a(this.f50252a.substring(i5, i4));
    }

    private void k() {
        int i4 = this.f50253b;
        while (true) {
            int i5 = this.f50253b;
            if (i5 >= this.f50254c || !f(this.f50252a.charAt(i5))) {
                break;
            }
            this.f50253b++;
        }
        this.f50255d = 2;
        this.f50256e = this.f50252a.substring(i4, this.f50253b);
    }

    public int b() {
        return this.f50255d;
    }

    public String c() {
        return this.f50256e;
    }

    public int i() {
        if (this.f50253b < this.f50254c) {
            while (true) {
                int i4 = this.f50253b;
                if (i4 >= this.f50254c || !g(this.f50252a.charAt(i4))) {
                    break;
                }
                this.f50253b++;
            }
            int i5 = this.f50253b;
            if (i5 < this.f50254c) {
                char charAt = this.f50252a.charAt(i5);
                if (this.f50257f) {
                    if (charAt != ';' && charAt != '=') {
                        j();
                    } else {
                        this.f50255d = charAt;
                        this.f50256e = new Character(charAt).toString();
                        this.f50253b++;
                    }
                } else if (f(charAt)) {
                    k();
                } else if (charAt != '/' && charAt != ';' && charAt != '=') {
                    this.f50255d = 0;
                    this.f50256e = new Character(charAt).toString();
                    this.f50253b++;
                } else {
                    this.f50255d = charAt;
                    this.f50256e = new Character(charAt).toString();
                    this.f50253b++;
                }
            } else {
                this.f50255d = 5;
                this.f50256e = null;
            }
        } else {
            this.f50255d = 5;
            this.f50256e = null;
        }
        return this.f50255d;
    }

    public void l(boolean z3) {
        this.f50257f = z3;
    }
}
