package com.bytedance.sdk.component.xv.w;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ev {

    /* renamed from: a  reason: collision with root package name */
    public static final ev f30973a;
    public static final ev ab;
    public static final ev al;
    public static final ev au;

    /* renamed from: b  reason: collision with root package name */
    public static final ev f30974b;
    public static final ev ba;
    public static final ev be;
    public static final ev bj;
    public static final ev bk;
    public static final ev bm;
    public static final ev bs;
    public static final ev bw;

    /* renamed from: c  reason: collision with root package name */
    static final Comparator<String> f30975c;
    public static final ev cf;
    public static final ev ck;

    /* renamed from: d  reason: collision with root package name */
    public static final ev f30976d;
    public static final ev db;
    public static final ev dk;

    /* renamed from: e  reason: collision with root package name */
    public static final ev f30977e;
    public static final ev eb;
    public static final ev eq;
    public static final ev eu;
    public static final ev ev;

    /* renamed from: f  reason: collision with root package name */
    public static final ev f30978f;
    public static final ev fm;
    private static final Map<String, ev> fn;
    public static final ev fp;
    public static final ev fz;

    /* renamed from: g  reason: collision with root package name */
    public static final ev f30979g;
    public static final ev gb;
    public static final ev gd;
    public static final ev ge;
    public static final ev gp;
    public static final ev gw;

    /* renamed from: h  reason: collision with root package name */
    public static final ev f30980h;

    /* renamed from: i  reason: collision with root package name */
    public static final ev f30981i;
    public static final ev ia;
    public static final ev iw;
    public static final ev ix;

    /* renamed from: j  reason: collision with root package name */
    public static final ev f30982j;
    public static final ev jd;
    public static final ev jr;
    public static final ev ju;
    public static final ev jv;

    /* renamed from: k  reason: collision with root package name */
    public static final ev f30983k;
    public static final ev kk;
    public static final ev kn;
    public static final ev kr;
    public static final ev ky;

    /* renamed from: l  reason: collision with root package name */
    public static final ev f30984l;
    public static final ev lf;
    public static final ev lp;
    public static final ev ls;
    public static final ev lw;

    /* renamed from: m  reason: collision with root package name */
    public static final ev f30985m;
    public static final ev me;
    public static final ev mk;
    public static final ev mt;
    public static final ev mu;

    /* renamed from: n  reason: collision with root package name */
    public static final ev f30986n;
    public static final ev nc;
    public static final ev nd;
    public static final ev ng;
    public static final ev ny;

    /* renamed from: o  reason: collision with root package name */
    public static final ev f30987o;
    public static final ev oh;
    public static final ev ok;
    public static final ev oo;
    public static final ev ox;

    /* renamed from: p  reason: collision with root package name */
    public static final ev f30988p;
    public static final ev pb;
    public static final ev pr;
    public static final ev pu;

    /* renamed from: q  reason: collision with root package name */
    public static final ev f30989q;
    public static final ev qu;
    public static final ev qy;

    /* renamed from: r  reason: collision with root package name */
    public static final ev f30990r;
    public static final ev rd;
    public static final ev rh;

    /* renamed from: s  reason: collision with root package name */
    public static final ev f30991s;
    public static final ev sr;

    /* renamed from: t  reason: collision with root package name */
    public static final ev f30992t;
    public static final ev ta;
    public static final ev te;
    public static final ev tl;
    public static final ev tx;
    public static final ev tz;

    /* renamed from: u  reason: collision with root package name */
    public static final ev f30993u;
    public static final ev uj;
    public static final ev up;
    public static final ev ux;

    /* renamed from: v  reason: collision with root package name */
    public static final ev f30994v;
    public static final ev vc;

    /* renamed from: w  reason: collision with root package name */
    public static final ev f30995w;
    public static final ev wo;
    public static final ev wt;
    public static final ev wv;
    public static final ev wx;

    /* renamed from: x  reason: collision with root package name */
    public static final ev f30996x;
    public static final ev xg;
    public static final ev xk;
    public static final ev xq;
    public static final ev xu;
    public static final ev xv;

    /* renamed from: y  reason: collision with root package name */
    public static final ev f30997y;
    public static final ev yh;
    public static final ev yn;
    public static final ev ys;
    public static final ev yu;

    /* renamed from: z  reason: collision with root package name */
    public static final ev f30998z;
    public static final ev zb;
    public static final ev zg;
    public static final ev zr;
    public static final ev zt;
    final String vj;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.bytedance.sdk.component.xv.w.ev.1
            @Override // java.util.Comparator
            /* renamed from: c */
            public int compare(String str, String str2) {
                int min = Math.min(str.length(), str2.length());
                for (int i4 = 4; i4 < min; i4++) {
                    char charAt = str.charAt(i4);
                    char charAt2 = str2.charAt(i4);
                    if (charAt != charAt2) {
                        return charAt < charAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        f30975c = comparator;
        fn = new TreeMap(comparator);
        f30995w = c("SSL_RSA_WITH_NULL_MD5", 1);
        xv = c("SSL_RSA_WITH_NULL_SHA", 2);
        sr = c("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        ux = c("SSL_RSA_WITH_RC4_128_MD5", 4);
        f30978f = c("SSL_RSA_WITH_RC4_128_SHA", 5);
        f30990r = c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        ev = c("SSL_RSA_WITH_DES_CBC_SHA", 9);
        gd = c("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        f30988p = c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        f30983k = c("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        f30973a = c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        bk = c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        f30992t = c("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        ys = c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        fp = c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        ia = c("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        f30991s = c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        fz = c("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        f30993u = c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        f30981i = c("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        f30989q = c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        f30982j = c("TLS_KRB5_WITH_RC4_128_SHA", 32);
        ls = c("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        gb = c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        f30986n = c("TLS_KRB5_WITH_RC4_128_MD5", 36);
        ck = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        f30998z = c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        ba = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        f30997y = c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        eq = c("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        me = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        wv = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        xk = c("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        yu = c("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        wx = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        pr = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        bw = c("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        f30996x = c("TLS_RSA_WITH_NULL_SHA256", 59);
        f30985m = c("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        gw = c("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        vc = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        up = c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        mt = c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        oo = c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        au = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        bj = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        bm = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        f30974b = c("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        wo = c("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        ox = c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        xu = c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        ng = c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        ok = c("TLS_PSK_WITH_RC4_128_SHA", 138);
        f30980h = c("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        oh = c("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        fm = c("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        te = c("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        ge = c("TLS_RSA_WITH_AES_128_GCM_SHA256", MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME);
        ta = c("TLS_RSA_WITH_AES_256_GCM_SHA384", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME);
        eu = c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        be = c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        f30979g = c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        bs = c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        lf = c("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        xg = c("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        mu = c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        f30977e = c("TLS_FALLBACK_SCSV", 22016);
        tl = c("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        kk = c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        zr = c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        zt = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        eb = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        rh = c("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        lw = c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        kn = c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        qy = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        iw = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        gp = c("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        zg = c("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        f30987o = c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        rd = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        jv = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        mk = c("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        yn = c("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        yh = c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f30994v = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        kr = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        pu = c("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        pb = c("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        jd = c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        f30984l = c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        nc = c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        ky = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        db = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        nd = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        ny = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        tx = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        ju = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        dk = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        jr = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        ix = c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f30976d = c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        qu = c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        cf = c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        ab = c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        xq = c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        zb = c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        wt = c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        uj = c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        tz = c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        lp = c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        al = c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    private ev(String str) {
        str.getClass();
        this.vj = str;
    }

    public static synchronized ev c(String str) {
        ev evVar;
        synchronized (ev.class) {
            Map<String, ev> map = fn;
            evVar = map.get(str);
            if (evVar == null) {
                evVar = new ev(str);
                map.put(str, evVar);
            }
        }
        return evVar;
    }

    public String toString() {
        return this.vj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ev> c(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(c(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static ev c(String str, int i4) {
        return c(str);
    }

    public String c() {
        return this.vj;
    }
}
