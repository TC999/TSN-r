package io.netty.resolver;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class HostsFileParser {
    private static final String WINDOWS_DEFAULT_SYSTEM_ROOT = "C:\\Windows";
    private static final String WINDOWS_HOSTS_FILE_RELATIVE_PATH = "\\system32\\drivers\\etc\\hosts";
    private static final String X_PLATFORMS_HOSTS_FILE_PATH = "/etc/hosts";
    private static final Pattern WHITESPACES = Pattern.compile("[ \t]+");
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(HostsFileParser.class);

    private HostsFileParser() {
    }

    private static File locateHostsFile() {
        if (PlatformDependent.isWindows()) {
            File file = new File(System.getenv("SystemRoot") + WINDOWS_HOSTS_FILE_RELATIVE_PATH);
            return !file.exists() ? new File("C:\\Windows\\system32\\drivers\\etc\\hosts") : file;
        }
        return new File(X_PLATFORMS_HOSTS_FILE_PATH);
    }

    public static Map<String, InetAddress> parse() throws IOException {
        return parse(locateHostsFile());
    }

    public static Map<String, InetAddress> parseSilently() {
        File locateHostsFile = locateHostsFile();
        try {
            return parse(locateHostsFile);
        } catch (IOException e) {
            InternalLogger internalLogger = logger;
            internalLogger.warn("Failed to load and parse hosts file at " + locateHostsFile.getPath(), (Throwable) e);
            return Collections.emptyMap();
        }
    }

    public static Map<String, InetAddress> parse(File file) throws IOException {
        ObjectUtil.checkNotNull(file, IDataSource.f43973c);
        if (file.exists() && file.isFile()) {
            return parse(new BufferedReader(new FileReader(file)));
        }
        return Collections.emptyMap();
    }

    public static Map<String, InetAddress> parse(Reader reader) throws IOException {
        String[] split;
        byte[] createByteArrayFromIpAddressString;
        ObjectUtil.checkNotNull(reader, "reader");
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            HashMap hashMap = new HashMap();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    int indexOf = readLine.indexOf(35);
                    if (indexOf != -1) {
                        readLine = readLine.substring(0, indexOf);
                    }
                    String trim = readLine.trim();
                    if (!trim.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (String str : WHITESPACES.split(trim)) {
                            if (!str.isEmpty()) {
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.size() >= 2 && (createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString((String) arrayList.get(0))) != null) {
                            for (int i = 1; i < arrayList.size(); i++) {
                                String str2 = (String) arrayList.get(i);
                                String lowerCase = str2.toLowerCase(Locale.ENGLISH);
                                if (!hashMap.containsKey(lowerCase)) {
                                    hashMap.put(lowerCase, InetAddress.getByAddress(str2, createByteArrayFromIpAddressString));
                                }
                            }
                        }
                    }
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                    }
                }
            }
            return hashMap;
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                logger.warn("Failed to close a reader", (Throwable) e2);
            }
        }
    }
}
