package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import org.apache.tomcat.Apr;
import org.apache.tomcat.jni.Buffer;
import org.apache.tomcat.jni.Library;
import org.apache.tomcat.jni.SSL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class OpenSsl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Set<String> AVAILABLE_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_JAVA_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_OPENSSL_CIPHER_SUITES;
    private static final String LINUX = "linux";
    static final String PROTOCOL_SSL_V2 = "SSLv2";
    static final String PROTOCOL_SSL_V2_HELLO = "SSLv2Hello";
    static final String PROTOCOL_SSL_V3 = "SSLv3";
    static final String PROTOCOL_TLS_V1 = "TLSv1";
    static final String PROTOCOL_TLS_V1_1 = "TLSv1.1";
    static final String PROTOCOL_TLS_V1_2 = "TLSv1.2";
    private static final String[] SUPPORTED_PROTOCOLS;
    static final Set<String> SUPPORTED_PROTOCOLS_SET;
    private static final boolean SUPPORTS_KEYMANAGER_FACTORY;
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final String UNKNOWN = "unknown";
    private static final boolean USE_KEYMANAGER_FACTORY;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(OpenSsl.class);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0176 A[Catch: all -> 0x017d, TRY_LEAVE, TryCatch #12 {all -> 0x017d, blocks: (B:49:0x016f, B:51:0x0176), top: B:116:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c4 A[LOOP:1: B:78:0x01be->B:80:0x01c4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01fd A[LOOP:2: B:82:0x01f7->B:84:0x01fd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0213 A[LOOP:3: B:86:0x020d->B:88:0x0213, LOOP_END] */
    static {
        /*
            Method dump skipped, instructions count: 575
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSsl.<clinit>():void");
    }

    private OpenSsl() {
    }

    @Deprecated
    public static Set<String> availableCipherSuites() {
        return availableOpenSslCipherSuites();
    }

    public static Set<String> availableJavaCipherSuites() {
        return AVAILABLE_JAVA_CIPHER_SUITES;
    }

    public static Set<String> availableOpenSslCipherSuites() {
        return AVAILABLE_OPENSSL_CIPHER_SUITES;
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    private static void initializeTcNative() throws Exception {
        Library.initialize("provided");
        SSL.initialize((String) null);
    }

    public static boolean isAlpnSupported() {
        return ((long) version()) >= 268443648;
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static boolean isCipherSuiteAvailable(String str) {
        String openSsl = CipherSuiteConverter.toOpenSsl(str);
        if (openSsl != null) {
            str = openSsl;
        }
        return AVAILABLE_OPENSSL_CIPHER_SUITES.contains(str);
    }

    static boolean isError(long j4) {
        return j4 != 0;
    }

    private static boolean isNettyTcnative() {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: io.netty.handler.ssl.OpenSsl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                InputStream inputStream = null;
                try {
                    try {
                        inputStream = Apr.class.getResourceAsStream("/org/apache/tomcat/apr.properties");
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        String property = properties.getProperty("tcn.info");
                        Boolean valueOf = Boolean.valueOf(property != null && property.startsWith("netty-tcnative"));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return valueOf;
                    } catch (Throwable unused2) {
                        Boolean bool = Boolean.FALSE;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return bool;
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
        })).booleanValue();
    }

    private static void loadTcNative() throws Exception {
        String normalizeOs = normalizeOs(SystemPropertyUtil.get("os.name", ""));
        String normalizeArch = normalizeArch(SystemPropertyUtil.get("os.arch", ""));
        LinkedHashSet linkedHashSet = new LinkedHashSet(3);
        linkedHashSet.add("netty-tcnative-" + normalizeOs + '-' + normalizeArch);
        if (LINUX.equalsIgnoreCase(normalizeOs)) {
            linkedHashSet.add("netty-tcnative-" + normalizeOs + '-' + normalizeArch + "-fedora");
        }
        linkedHashSet.add("netty-tcnative");
        NativeLibraryLoader.loadFirstAvailable(SSL.class.getClassLoader(), (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long memoryAddress(ByteBuf byteBuf) {
        return byteBuf.hasMemoryAddress() ? byteBuf.memoryAddress() : Buffer.address(byteBuf.nioBuffer());
    }

    private static String normalize(String str) {
        return str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    private static String normalizeArch(String str) {
        String normalize = normalize(str);
        return normalize.matches("^(x8664|amd64|ia32e|em64t|x64)$") ? "x86_64" : normalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$") ? "x86_32" : normalize.matches("^(ia64|itanium64)$") ? "itanium_64" : normalize.matches("^(sparc|sparc32)$") ? "sparc_32" : normalize.matches("^(sparcv9|sparc64)$") ? "sparc_64" : normalize.matches("^(arm|arm32)$") ? "arm_32" : "aarch64".equals(normalize) ? "aarch_64" : normalize.matches("^(ppc|ppc32)$") ? "ppc_32" : "ppc64".equals(normalize) ? "ppc_64" : "ppc64le".equals(normalize) ? "ppcle_64" : "s390".equals(normalize) ? "s390_32" : "s390x".equals(normalize) ? "s390_64" : "unknown";
    }

    private static String normalizeOs(String str) {
        String normalize = normalize(str);
        if (normalize.startsWith("aix")) {
            return "aix";
        }
        if (normalize.startsWith("hpux")) {
            return "hpux";
        }
        if (!normalize.startsWith("os400") || (normalize.length() > 5 && Character.isDigit(normalize.charAt(5)))) {
            if (normalize.startsWith(LINUX)) {
                return LINUX;
            }
            String str2 = "osx";
            if (!normalize.startsWith("macosx") && !normalize.startsWith("osx")) {
                if (normalize.startsWith("freebsd")) {
                    return "freebsd";
                }
                if (normalize.startsWith("openbsd")) {
                    return "openbsd";
                }
                if (normalize.startsWith("netbsd")) {
                    return "netbsd";
                }
                str2 = "sunos";
                if (!normalize.startsWith("solaris") && !normalize.startsWith("sunos")) {
                    return normalize.startsWith("windows") ? "windows" : "unknown";
                }
            }
            return str2;
        }
        return "os400";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void releaseIfNeeded(ReferenceCounted referenceCounted) {
        if (referenceCounted.refCnt() > 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
    }

    public static boolean supportsKeyManagerFactory() {
        return SUPPORTS_KEYMANAGER_FACTORY;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean useKeyManagerFactory() {
        return USE_KEYMANAGER_FACTORY;
    }

    public static int version() {
        if (isAvailable()) {
            return SSL.version();
        }
        return -1;
    }

    public static String versionString() {
        if (isAvailable()) {
            return SSL.versionString();
        }
        return null;
    }
}
