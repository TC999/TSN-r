package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class CipherSuiteConverter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(CipherSuiteConverter.class);
    private static final Pattern JAVA_CIPHERSUITE_PATTERN = Pattern.compile("^(?:TLS|SSL)_((?:(?!_WITH_).)+)_WITH_(.*)_(.*)$");
    private static final Pattern OPENSSL_CIPHERSUITE_PATTERN = Pattern.compile("^(?:((?:(?:EXP-)?(?:(?:DHE|EDH|ECDH|ECDHE|SRP)-(?:DSS|RSA|ECDSA)|(?:ADH|AECDH|KRB5|PSK|SRP)))|EXP)-)?(.*)-(.*)$");
    private static final Pattern JAVA_AES_CBC_PATTERN = Pattern.compile("^(AES)_([0-9]+)_CBC$");
    private static final Pattern JAVA_AES_PATTERN = Pattern.compile("^(AES)_([0-9]+)_(.*)$");
    private static final Pattern OPENSSL_AES_CBC_PATTERN = Pattern.compile("^(AES)([0-9]+)$");
    private static final Pattern OPENSSL_AES_PATTERN = Pattern.compile("^(AES)([0-9]+)-(.*)$");
    private static final ConcurrentMap<String, String> j2o = PlatformDependent.newConcurrentHashMap();
    private static final ConcurrentMap<String, Map<String, String>> o2j = PlatformDependent.newConcurrentHashMap();

    private CipherSuiteConverter() {
    }

    private static String cacheFromJava(String str) {
        String openSslUncached = toOpenSslUncached(str);
        if (openSslUncached == null) {
            return null;
        }
        j2o.putIfAbsent(str, openSslUncached);
        String substring = str.substring(4);
        HashMap hashMap = new HashMap(4);
        hashMap.put("", substring);
        hashMap.put("SSL", "SSL_" + substring);
        hashMap.put("TLS", "TLS_" + substring);
        o2j.put(openSslUncached, hashMap);
        logger.debug("Cipher suite mapping: {} => {}", str, openSslUncached);
        return openSslUncached;
    }

    private static Map<String, String> cacheFromOpenSsl(String str) {
        String javaUncached = toJavaUncached(str);
        if (javaUncached == null) {
            return null;
        }
        String str2 = "SSL_" + javaUncached;
        String str3 = "TLS_" + javaUncached;
        HashMap hashMap = new HashMap(4);
        hashMap.put("", javaUncached);
        hashMap.put("SSL", str2);
        hashMap.put("TLS", str3);
        o2j.putIfAbsent(str, hashMap);
        ConcurrentMap<String, String> concurrentMap = j2o;
        concurrentMap.putIfAbsent(str3, str);
        concurrentMap.putIfAbsent(str2, str);
        InternalLogger internalLogger = logger;
        internalLogger.debug("Cipher suite mapping: {} => {}", str3, str);
        internalLogger.debug("Cipher suite mapping: {} => {}", str2, str);
        return hashMap;
    }

    static void clearCache() {
        j2o.clear();
        o2j.clear();
    }

    static boolean isJ2OCached(String str, String str2) {
        return str2.equals(j2o.get(str));
    }

    static boolean isO2JCached(String str, String str2, String str3) {
        Map<String, String> map = o2j.get(str);
        if (map == null) {
            return false;
        }
        return str3.equals(map.get(str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toJava(String str, String str2) {
        Map<String, String> map = o2j.get(str);
        if (map == null) {
            map = cacheFromOpenSsl(str);
        }
        String str3 = map.get(str2);
        if (str3 == null) {
            return str2 + '_' + map.get("");
        }
        return str3;
    }

    private static String toJavaBulkCipher(String str, boolean z) {
        if (str.startsWith("AES")) {
            Matcher matcher = OPENSSL_AES_CBC_PATTERN.matcher(str);
            if (matcher.matches()) {
                return matcher.replaceFirst("$1_$2_CBC");
            }
            Matcher matcher2 = OPENSSL_AES_PATTERN.matcher(str);
            if (matcher2.matches()) {
                return matcher2.replaceFirst("$1_$2_$3");
            }
        }
        if ("DES-CBC3".equals(str)) {
            return "3DES_EDE_CBC";
        }
        if ("RC4".equals(str)) {
            return z ? "RC4_40" : "RC4_128";
        } else if ("DES-CBC".equals(str)) {
            return z ? "DES_CBC_40" : "DES_CBC";
        } else if ("RC2-CBC".equals(str)) {
            return z ? "RC2_CBC_40" : "RC2_CBC";
        } else {
            return str.replace('-', '_');
        }
    }

    private static String toJavaHandshakeAlgo(String str, boolean z) {
        if (str.length() == 0) {
            str = "RSA";
        } else if ("ADH".equals(str)) {
            str = "DH_anon";
        } else if ("AECDH".equals(str)) {
            str = "ECDH_anon";
        }
        String replace = str.replace('-', '_');
        if (z) {
            return replace + "_EXPORT";
        }
        return replace;
    }

    private static String toJavaHmacAlgo(String str) {
        return str;
    }

    static String toJavaUncached(String str) {
        Matcher matcher = OPENSSL_CIPHERSUITE_PATTERN.matcher(str);
        if (matcher.matches()) {
            boolean z = true;
            String group = matcher.group(1);
            if (group != null) {
                if (group.startsWith("EXP-")) {
                    group = group.substring(4);
                } else if ("EXP".equals(group)) {
                    group = "";
                }
                String javaHandshakeAlgo = toJavaHandshakeAlgo(group, z);
                String javaBulkCipher = toJavaBulkCipher(matcher.group(2), z);
                String javaHmacAlgo = toJavaHmacAlgo(matcher.group(3));
                return javaHandshakeAlgo + "_WITH_" + javaBulkCipher + '_' + javaHmacAlgo;
            }
            group = "";
            z = false;
            String javaHandshakeAlgo2 = toJavaHandshakeAlgo(group, z);
            String javaBulkCipher2 = toJavaBulkCipher(matcher.group(2), z);
            String javaHmacAlgo2 = toJavaHmacAlgo(matcher.group(3));
            return javaHandshakeAlgo2 + "_WITH_" + javaBulkCipher2 + '_' + javaHmacAlgo2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toOpenSsl(Iterable<String> iterable) {
        String next;
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            String openSsl = toOpenSsl(next);
            if (openSsl != null) {
                next = openSsl;
            }
            sb.append(next);
            sb.append(':');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
        return "";
    }

    private static String toOpenSslBulkCipher(String str) {
        if (str.startsWith("AES_")) {
            Matcher matcher = JAVA_AES_CBC_PATTERN.matcher(str);
            if (matcher.matches()) {
                return matcher.replaceFirst("$1$2");
            }
            Matcher matcher2 = JAVA_AES_PATTERN.matcher(str);
            if (matcher2.matches()) {
                return matcher2.replaceFirst("$1$2-$3");
            }
        }
        return "3DES_EDE_CBC".equals(str) ? "DES-CBC3" : ("RC4_128".equals(str) || "RC4_40".equals(str)) ? "RC4" : ("DES40_CBC".equals(str) || "DES_CBC_40".equals(str)) ? "DES-CBC" : "RC2_CBC_40".equals(str) ? "RC2-CBC" : str.replace('_', '-');
    }

    private static String toOpenSslHandshakeAlgo(String str) {
        boolean endsWith = str.endsWith("_EXPORT");
        if (endsWith) {
            str = str.substring(0, str.length() - 7);
        }
        if ("RSA".equals(str)) {
            str = "";
        } else if (str.endsWith("_anon")) {
            str = 'A' + str.substring(0, str.length() - 5);
        }
        if (endsWith) {
            if (str.length() == 0) {
                str = "EXP";
            } else {
                str = "EXP-" + str;
            }
        }
        return str.replace('_', '-');
    }

    private static String toOpenSslHmacAlgo(String str) {
        return str;
    }

    static String toOpenSslUncached(String str) {
        Matcher matcher = JAVA_CIPHERSUITE_PATTERN.matcher(str);
        if (matcher.matches()) {
            String openSslHandshakeAlgo = toOpenSslHandshakeAlgo(matcher.group(1));
            String openSslBulkCipher = toOpenSslBulkCipher(matcher.group(2));
            String openSslHmacAlgo = toOpenSslHmacAlgo(matcher.group(3));
            if (openSslHandshakeAlgo.length() == 0) {
                return openSslBulkCipher + '-' + openSslHmacAlgo;
            }
            return openSslHandshakeAlgo + '-' + openSslBulkCipher + '-' + openSslHmacAlgo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toOpenSsl(String str) {
        String str2 = j2o.get(str);
        return str2 != null ? str2 : cacheFromJava(str);
    }
}
