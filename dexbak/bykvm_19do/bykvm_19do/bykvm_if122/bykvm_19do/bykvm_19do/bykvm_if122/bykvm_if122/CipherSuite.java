package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import com.alibaba.fastjson.asm.Opcodes;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CipherSuite {

    /* renamed from: b */
    static final Comparator<String> f1291b;

    /* renamed from: c */
    private static final Map<String, CipherSuite> f1292c;

    /* renamed from: d */
    public static final CipherSuite f1293d;

    /* renamed from: e */
    public static final CipherSuite f1294e;

    /* renamed from: f */
    public static final CipherSuite f1295f;

    /* renamed from: g */
    public static final CipherSuite f1296g;

    /* renamed from: h */
    public static final CipherSuite f1297h;

    /* renamed from: i */
    public static final CipherSuite f1298i;

    /* renamed from: j */
    public static final CipherSuite f1299j;

    /* renamed from: k */
    public static final CipherSuite f1300k;

    /* renamed from: l */
    public static final CipherSuite f1301l;

    /* renamed from: m */
    public static final CipherSuite f1302m;

    /* renamed from: n */
    public static final CipherSuite f1303n;

    /* renamed from: o */
    public static final CipherSuite f1304o;

    /* renamed from: p */
    public static final CipherSuite f1305p;

    /* renamed from: q */
    public static final CipherSuite f1306q;

    /* renamed from: r */
    public static final CipherSuite f1307r;

    /* renamed from: a */
    final String f1308a;

    /* compiled from: CipherSuite.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.h$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1068a implements Comparator<String> {
        C1068a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            for (int i = 4; i < min; i++) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
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
    }

    static {
        C1068a c1068a = new C1068a();
        f1291b = c1068a;
        f1292c = new TreeMap(c1068a);
        m58413a("SSL_RSA_WITH_NULL_MD5", 1);
        m58413a("SSL_RSA_WITH_NULL_SHA", 2);
        m58413a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        m58413a("SSL_RSA_WITH_RC4_128_MD5", 4);
        m58413a("SSL_RSA_WITH_RC4_128_SHA", 5);
        m58413a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        m58413a("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f1293d = m58413a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        m58413a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        m58413a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        m58413a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        m58413a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        m58413a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        m58413a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        m58413a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        m58413a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        m58413a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        m58413a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        m58413a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        m58413a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        m58413a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        m58413a("TLS_KRB5_WITH_RC4_128_SHA", 32);
        m58413a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        m58413a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        m58413a("TLS_KRB5_WITH_RC4_128_MD5", 36);
        m58413a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        m58413a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        m58413a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        m58413a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f1294e = m58413a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        m58413a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        m58413a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        m58413a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f1295f = m58413a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        m58413a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        m58413a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        m58413a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        m58413a("TLS_RSA_WITH_NULL_SHA256", 59);
        m58413a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        m58413a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        m58413a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        m58413a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        m58413a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        m58413a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        m58413a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        m58413a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        m58413a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        m58413a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        m58413a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        m58413a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID);
        m58413a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA);
        m58413a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME);
        m58413a("TLS_PSK_WITH_RC4_128_SHA", TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK);
        m58413a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL);
        m58413a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        m58413a("TLS_PSK_WITH_AES_256_CBC_SHA", TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS);
        m58413a("TLS_RSA_WITH_SEED_CBC_SHA", TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME);
        f1296g = m58413a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f1297h = m58413a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        m58413a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", Opcodes.IFLE);
        m58413a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPEQ);
        m58413a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", Opcodes.IF_ICMPGE);
        m58413a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", Opcodes.IF_ICMPGT);
        m58413a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        m58413a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", Opcodes.GOTO);
        m58413a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        m58413a("TLS_FALLBACK_SCSV", 22016);
        m58413a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        m58413a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        m58413a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        m58413a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        m58413a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        m58413a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        m58413a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        m58413a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        f1298i = m58413a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        f1299j = m58413a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        m58413a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        m58413a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        m58413a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        m58413a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        m58413a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        m58413a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        m58413a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        m58413a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f1300k = m58413a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f1301l = m58413a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        m58413a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        m58413a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        m58413a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        m58413a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        m58413a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        m58413a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        m58413a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        m58413a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        m58413a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        m58413a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        m58413a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        m58413a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        m58413a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f1302m = m58413a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f1303n = m58413a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        m58413a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        m58413a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        f1304o = m58413a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f1305p = m58413a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        m58413a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        m58413a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        m58413a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        m58413a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        f1306q = m58413a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        f1307r = m58413a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    private CipherSuite(String str) {
        str.getClass();
        this.f1308a = str;
    }

    /* renamed from: a */
    public static synchronized CipherSuite m58414a(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            Map<String, CipherSuite> map = f1292c;
            cipherSuite = map.get(str);
            if (cipherSuite == null) {
                cipherSuite = new CipherSuite(str);
                map.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    public String toString() {
        return this.f1308a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static List<CipherSuite> m58412a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m58414a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private static CipherSuite m58413a(String str, int i) {
        return m58414a(str);
    }
}
