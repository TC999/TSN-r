package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Version {
    private static final String PROP_BUILD_DATE = ".buildDate";
    private static final String PROP_COMMIT_DATE = ".commitDate";
    private static final String PROP_LONG_COMMIT_HASH = ".longCommitHash";
    private static final String PROP_REPO_STATUS = ".repoStatus";
    private static final String PROP_SHORT_COMMIT_HASH = ".shortCommitHash";
    private static final String PROP_VERSION = ".version";
    private final String artifactId;
    private final String artifactVersion;
    private final long buildTimeMillis;
    private final long commitTimeMillis;
    private final String longCommitHash;
    private final String repositoryStatus;
    private final String shortCommitHash;

    private Version(String str, String str2, long j4, long j5, String str3, String str4, String str5) {
        this.artifactId = str;
        this.artifactVersion = str2;
        this.buildTimeMillis = j4;
        this.commitTimeMillis = j5;
        this.shortCommitHash = str3;
        this.longCommitHash = str4;
        this.repositoryStatus = str5;
    }

    public static Map<String, Version> identify() {
        return identify(null);
    }

    public static void main(String[] strArr) {
        for (Version version : identify().values()) {
            System.err.println(version);
        }
    }

    private static long parseIso8601(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(str).getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public String artifactId() {
        return this.artifactId;
    }

    public String artifactVersion() {
        return this.artifactVersion;
    }

    public long buildTimeMillis() {
        return this.buildTimeMillis;
    }

    public long commitTimeMillis() {
        return this.commitTimeMillis;
    }

    public String longCommitHash() {
        return this.longCommitHash;
    }

    public String repositoryStatus() {
        return this.repositoryStatus;
    }

    public String shortCommitHash() {
        return this.shortCommitHash;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.artifactId);
        sb.append('-');
        sb.append(this.artifactVersion);
        sb.append('.');
        sb.append(this.shortCommitHash);
        if ("clean".equals(this.repositoryStatus)) {
            str = "";
        } else {
            str = " (repository: " + this.repositoryStatus + ')';
        }
        sb.append(str);
        return sb.toString();
    }

    public static Map<String, Version> identify(ClassLoader classLoader) {
        ClassLoader contextClassLoader = classLoader == null ? PlatformDependent.getContextClassLoader() : classLoader;
        Properties properties = new Properties();
        try {
            Enumeration<URL> resources = contextClassLoader.getResources("META-INF/io.netty.versions.properties");
            while (resources.hasMoreElements()) {
                InputStream openStream = resources.nextElement().openStream();
                properties.load(openStream);
                try {
                    openStream.close();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
        HashSet hashSet = new HashSet();
        for (String str : properties.keySet()) {
            int indexOf = str.indexOf(46);
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                if (properties.containsKey(substring + ".version")) {
                    if (properties.containsKey(substring + ".buildDate")) {
                        if (properties.containsKey(substring + ".commitDate")) {
                            if (properties.containsKey(substring + ".shortCommitHash")) {
                                if (properties.containsKey(substring + ".longCommitHash")) {
                                    if (properties.containsKey(substring + ".repoStatus")) {
                                        hashSet.add(substring);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        TreeMap treeMap = new TreeMap();
        for (Iterator it = hashSet.iterator(); it.hasNext(); it = it) {
            String str2 = (String) it.next();
            String property = properties.getProperty(str2 + ".version");
            long parseIso8601 = parseIso8601(properties.getProperty(str2 + ".buildDate"));
            long parseIso86012 = parseIso8601(properties.getProperty(str2 + ".commitDate"));
            String property2 = properties.getProperty(str2 + ".shortCommitHash");
            String property3 = properties.getProperty(str2 + ".longCommitHash");
            treeMap.put(str2, new Version(str2, property, parseIso8601, parseIso86012, property2, property3, properties.getProperty(str2 + ".repoStatus")));
        }
        return treeMap;
    }
}
