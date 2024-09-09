package io.netty.channel;

import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.MacAddressUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadLocalRandom;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class DefaultChannelId implements ChannelId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] MACHINE_ID;
    private static final int MACHINE_ID_LEN = 8;
    private static final int MAX_PROCESS_ID = 4194304;
    private static final int PROCESS_ID;
    private static final int PROCESS_ID_LEN = 4;
    private static final int RANDOM_LEN = 4;
    private static final int SEQUENCE_LEN = 4;
    private static final int TIMESTAMP_LEN = 8;
    private static final long serialVersionUID = 3884076183504074063L;
    private final byte[] data = new byte[28];
    private int hashCode;
    private transient String longValue;
    private transient String shortValue;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelId.class);
    private static final Pattern MACHINE_ID_PATTERN = Pattern.compile("^(?:[0-9a-fA-F][:-]?){6,8}$");
    private static final AtomicInteger nextSequence = new AtomicInteger();

    static {
        int i4;
        String str = SystemPropertyUtil.get("io.netty.processId");
        int i5 = -1;
        if (str != null) {
            try {
                i4 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i4 = -1;
            }
            if (i4 >= 0 && i4 <= 4194304) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("-Dio.netty.processId: {} (user-set)", Integer.valueOf(i4));
                }
                i5 = i4;
            } else {
                logger.warn("-Dio.netty.processId: {} (malformed)", str);
            }
        }
        if (i5 < 0) {
            i5 = defaultProcessId();
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(i5));
            }
        }
        PROCESS_ID = i5;
        byte[] bArr = null;
        String str2 = SystemPropertyUtil.get("io.netty.machineId");
        if (str2 != null) {
            if (MACHINE_ID_PATTERN.matcher(str2).matches()) {
                bArr = parseMachineId(str2);
                logger.debug("-Dio.netty.machineId: {} (user-set)", str2);
            } else {
                logger.warn("-Dio.netty.machineId: {} (malformed)", str2);
            }
        }
        if (bArr == null) {
            bArr = defaultMachineId();
            InternalLogger internalLogger3 = logger;
            if (internalLogger3.isDebugEnabled()) {
                internalLogger3.debug("-Dio.netty.machineId: {} (auto-detected)", MacAddressUtil.formatAddress(bArr));
            }
        }
        MACHINE_ID = bArr;
    }

    private DefaultChannelId() {
    }

    private int appendHexDumpField(StringBuilder sb, int i4, int i5) {
        sb.append(ByteBufUtil.hexDump(this.data, i4, i5));
        sb.append('-');
        return i4 + i5;
    }

    private static byte[] defaultMachineId() {
        byte[] bestAvailableMac = MacAddressUtil.bestAvailableMac();
        if (bestAvailableMac == null) {
            byte[] bArr = new byte[8];
            ThreadLocalRandom.current().nextBytes(bArr);
            logger.warn("Failed to find a usable hardware address from the network interfaces; using random bytes: {}", MacAddressUtil.formatAddress(bArr));
            return bArr;
        }
        return bestAvailableMac;
    }

    private static int defaultProcessId() {
        String str;
        int i4;
        ClassLoader classLoader = PlatformDependent.getClassLoader(DefaultChannelId.class);
        try {
            Class<?> cls = Class.forName("java.lang.management.ManagementFactory", true, classLoader);
            Class<?> cls2 = Class.forName("java.lang.management.RuntimeMXBean", true, classLoader);
            Class<?>[] clsArr = EmptyArrays.EMPTY_CLASSES;
            Method method = cls.getMethod("getRuntimeMXBean", clsArr);
            Object[] objArr = EmptyArrays.EMPTY_OBJECTS;
            str = (String) cls2.getMethod("getName", clsArr).invoke(method.invoke(null, objArr), objArr);
        } catch (Exception e4) {
            logger.debug("Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?", (Throwable) e4);
            try {
                str = Class.forName("android.os.Process", true, classLoader).getMethod("myPid", EmptyArrays.EMPTY_CLASSES).invoke(null, EmptyArrays.EMPTY_OBJECTS).toString();
            } catch (Exception e5) {
                logger.debug("Could not invoke Process.myPid(); not Android?", (Throwable) e5);
                str = "";
            }
        }
        int indexOf = str.indexOf(64);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        try {
            i4 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            i4 = -1;
        }
        if (i4 < 0 || i4 > 4194304) {
            int nextInt = ThreadLocalRandom.current().nextInt(4194305);
            logger.warn("Failed to find the current process ID from '{}'; using a random value: {}", str, Integer.valueOf(nextInt));
            return nextInt;
        }
        return i4;
    }

    private void init() {
        System.arraycopy(MACHINE_ID, 0, this.data, 0, 8);
        int writeLong = writeLong(writeInt(writeInt(8, PROCESS_ID), nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis());
        int nextInt = ThreadLocalRandom.current().nextInt();
        this.hashCode = nextInt;
        writeInt(writeLong, nextInt);
    }

    public static DefaultChannelId newInstance() {
        DefaultChannelId defaultChannelId = new DefaultChannelId();
        defaultChannelId.init();
        return defaultChannelId;
    }

    private String newLongValue() {
        StringBuilder sb = new StringBuilder((this.data.length * 2) + 5);
        appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, 0, 8), 4), 4), 8), 4);
        return sb.substring(0, sb.length() - 1);
    }

    private static byte[] parseMachineId(String str) {
        String replaceAll = str.replaceAll("[:-]", "");
        byte[] bArr = new byte[8];
        int i4 = 0;
        while (i4 < replaceAll.length()) {
            int i5 = i4 + 2;
            bArr[i4] = (byte) Integer.parseInt(replaceAll.substring(i4, i5), 16);
            i4 = i5;
        }
        return bArr;
    }

    private int writeInt(int i4, int i5) {
        byte[] bArr = this.data;
        int i6 = i4 + 1;
        bArr[i4] = (byte) (i5 >>> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i5 >>> 16);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (i5 >>> 8);
        int i9 = i8 + 1;
        bArr[i8] = (byte) i5;
        return i9;
    }

    private int writeLong(int i4, long j4) {
        byte[] bArr = this.data;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j4 >>> 56);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j4 >>> 48);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j4 >>> 40);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j4 >>> 32);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (j4 >>> 24);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (j4 >>> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (j4 >>> 8);
        int i12 = i11 + 1;
        bArr[i11] = (byte) j4;
        return i12;
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        String str = this.longValue;
        if (str == null) {
            String newLongValue = newLongValue();
            this.longValue = newLongValue;
            return newLongValue;
        }
        return str;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        String str = this.shortValue;
        if (str == null) {
            String hexDump = ByteBufUtil.hexDump(this.data, 24, 4);
            this.shortValue = hexDump;
            return hexDump;
        }
        return str;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DefaultChannelId) {
            return Arrays.equals(this.data, ((DefaultChannelId) obj).data);
        }
        return false;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return asShortText();
    }
}
