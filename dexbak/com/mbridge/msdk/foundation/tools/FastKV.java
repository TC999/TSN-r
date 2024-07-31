package com.mbridge.msdk.foundation.tools;

import android.os.Build;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.foundation.tools.Container;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.UByte;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FastKV {
    static final int ASYNC_BLOCKING = 1;
    private static final String A_SUFFIX = ".kva";
    private static final int BASE_GC_BYTES_THRESHOLD = 4096;
    private static final int BASE_GC_KEYS_THRESHOLD = 80;
    private static final String BOTH_FILES_ERROR = "both files error";
    private static final String B_SUFFIX = ".kvb";
    private static final String C_SUFFIX = ".kvc";
    private static final int DATA_SIZE_LIMIT = 536870912;
    private static final int DATA_START = 12;
    private static final int DOUBLE_LIMIT;
    static final String GC_FINISH = "gc finish";
    private static final int INTERNAL_LIMIT = 2048;
    private static final String MAP_FAILED = "map failed";
    static final int NON_BLOCKING = 0;
    private static final String OPEN_FILE_FAILED = "open file failed";
    private static final int PAGE_SIZE;
    private static final String PARSE_DATA_FAILED = "parse dara failed";
    static final int SYNC_BLOCKING = 2;
    private static final String TEMP_SUFFIX = ".tmp";
    static final String TRUNCATE_FINISH = "truncate finish";
    private static final int TRUNCATE_THRESHOLD;
    private MappedByteBuffer aBuffer;
    private FileChannel aChannel;
    private MappedByteBuffer bBuffer;
    private FileChannel bChannel;
    private long checksum;
    private int dataEnd;
    private final Map<String, InterfaceC11395a> encoderMap;
    private FastBuffer fastBuffer;
    private int invalidBytes;
    private final String name;
    private final String path;
    private int removeStart;
    private boolean sizeChanged;
    private String tempExternalName;
    private int updateSize;
    private int updateStart;
    private int writingMode;
    private static final int[] TYPE_SIZE = {0, 1, 4, 4, 8, 8};
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private final InterfaceC11396b logger = FastKVConfig.f31087a;
    private final Map<String, Container.AbstractC11404b> data = new HashMap();
    private boolean startLoading = false;
    private final ArrayList<C11397c> invalids = new ArrayList<>();
    private boolean autoCommit = true;
    private final Executor executor = new LimitExecutor();

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private InterfaceC11395a[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    if (!str.endsWith("/")) {
                        str = str + '/';
                    }
                    this.path = str;
                    this.name = str2;
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("path is empty");
        }

        public Builder asyncBlocking() {
            this.writingMode = 1;
            return this;
        }

        public Builder blocking() {
            this.writingMode = 2;
            return this;
        }

        public FastKV build() {
            String str = this.path + this.name;
            Map<String, FastKV> map = INSTANCE_MAP;
            FastKV fastKV = map.get(str);
            if (fastKV == null) {
                synchronized (Builder.class) {
                    fastKV = map.get(str);
                    if (fastKV == null) {
                        fastKV = new FastKV(this.path, this.name, this.encoders, this.writingMode);
                        map.put(str, fastKV);
                    }
                }
            }
            return fastKV;
        }

        public Builder encoder(InterfaceC11395a[] interfaceC11395aArr) {
            this.encoders = interfaceC11395aArr;
            return this;
        }
    }

    /* renamed from: com.mbridge.msdk.foundation.tools.FastKV$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11395a<T> {
        /* renamed from: a */
        T mo21958a(byte[] bArr, int i, int i2);

        /* renamed from: a */
        String mo21960a();

        /* renamed from: a */
        byte[] mo21959a(T t);
    }

    /* renamed from: com.mbridge.msdk.foundation.tools.FastKV$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11396b {
        /* renamed from: a */
        void m22047a(String str, Exception exc);

        /* renamed from: a */
        void m22046a(String str, String str2);

        /* renamed from: b */
        void m22045b(String str, Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mbridge.msdk.foundation.tools.FastKV$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11397c implements Comparable<C11397c> {

        /* renamed from: a */
        int f30961a;

        /* renamed from: b */
        int f30962b;

        C11397c(int i, int i2) {
            this.f30961a = i;
            this.f30962b = i2;
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(C11397c c11397c) {
            return this.f30961a - c11397c.f30961a;
        }
    }

    static {
        int m21942b = C11401aj.m21942b();
        PAGE_SIZE = m21942b;
        int max = Math.max(m21942b << 1, 16384);
        DOUBLE_LIMIT = max;
        TRUNCATE_THRESHOLD = max << 1;
    }

    FastKV(String str, String str2, InterfaceC11395a[] interfaceC11395aArr, int i) {
        this.path = str;
        this.name = str2;
        this.writingMode = i;
        HashMap hashMap = new HashMap();
        hashMap.put("StringSet", StringSetEncoder.f30995a);
        if (interfaceC11395aArr != null && interfaceC11395aArr.length > 0) {
            for (InterfaceC11395a interfaceC11395a : interfaceC11395aArr) {
                String mo21960a = interfaceC11395a.mo21960a();
                if (hashMap.containsKey(mo21960a)) {
                    error("duplicate encoder tag:" + mo21960a);
                } else {
                    hashMap.put(mo21960a, interfaceC11395a);
                }
            }
        }
        this.encoderMap = hashMap;
        synchronized (this.data) {
            FastKVConfig.m21847a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.FastKV.1
                @Override // java.lang.Runnable
                public final void run() {
                    FastKV.this.loadData();
                }
            });
            while (!this.startLoading) {
                try {
                    this.data.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private void addObject(String str, Object obj, byte[] bArr, byte b) {
        String str2;
        int length;
        Container.AbstractC11404b c11410h;
        int saveArray = saveArray(str, bArr, b);
        if (saveArray != 0) {
            String str3 = this.tempExternalName;
            boolean z = str3 != null;
            if (z) {
                this.tempExternalName = null;
                str2 = str3;
                length = 32;
            } else {
                str2 = obj;
                length = bArr.length;
            }
            if (b == 6) {
                c11410h = new Container.C11411i(this.updateStart, saveArray, (String) str2, length, z);
            } else if (b == 7) {
                c11410h = new Container.C11403a(this.updateStart, saveArray, str2, length, z);
            } else {
                c11410h = new Container.C11410h(this.updateStart, saveArray, str2, length, z);
            }
            this.data.put(str, c11410h);
            updateChange();
        }
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, Container.AbstractC11412j abstractC11412j, byte b) {
        if (abstractC11412j == null) {
            addObject(str, obj, bArr, b);
        } else if (!abstractC11412j.f31025e && abstractC11412j.f31024d == bArr.length) {
            updateBytes(abstractC11412j.f31016a, bArr);
            abstractC11412j.f31022b = obj;
        } else {
            updateObject(str, obj, bArr, abstractC11412j);
        }
        checkIfCommit();
    }

    private int bytesThreshold() {
        int i = this.dataEnd;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void checkGC() {
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            if (this.invalids.size() < (this.dataEnd < 16384 ? 80 : 160)) {
                return;
            }
        }
        m22048gc(0);
    }

    private void checkIfCommit() {
        if (this.writingMode == 0 || !this.autoCommit) {
            return;
        }
        commitToCFile();
    }

    private void checkKey(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void checkKeySize(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void checkValueSize(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0L;
        clearInvalid();
        this.data.clear();
        FastBuffer fastBuffer = this.fastBuffer;
        if (fastBuffer != null && fastBuffer.f31084a.length == PAGE_SIZE) {
            fastBuffer.m21860a(0, 0);
            this.fastBuffer.m21859a(4, 0L);
            return;
        }
        this.fastBuffer = new FastBuffer(PAGE_SIZE);
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private boolean commitToCFile() {
        int i = this.writingMode;
        if (i == 1) {
            this.executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.FastKV.2
                @Override // java.lang.Runnable
                public final void run() {
                    FastKV.this.writeToCFile();
                }
            });
        } else if (i == 2) {
            return writeToCFile();
        }
        return true;
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bBuffer ? this.bChannel : this.aChannel).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bBuffer) {
                    this.bBuffer = map;
                } else {
                    this.aBuffer = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e) {
                error(e);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void countInvalid(int i, int i2) {
        this.invalidBytes += i2 - i;
        this.invalids.add(new C11397c(i, i2));
    }

    private void deleteCFiles() {
        try {
            String str = this.path;
            C11401aj.m21940c(new File(str, this.name + C_SUFFIX));
            String str2 = this.path;
            C11401aj.m21940c(new File(str2, this.name + ".tmp"));
        } catch (Exception e) {
            error(e);
        }
    }

    private void ensureSize(int i) {
        int length = this.fastBuffer.f31084a.length;
        int i2 = this.dataEnd + i;
        if (i2 >= length) {
            int i3 = this.invalidBytes;
            if (i3 > i && i3 > bytesThreshold()) {
                m22048gc(i);
                return;
            }
            int newCapacity = getNewCapacity(length, i2);
            byte[] bArr = new byte[newCapacity];
            System.arraycopy(this.fastBuffer.f31084a, 0, bArr, 0, this.dataEnd);
            this.fastBuffer.f31084a = bArr;
            if (this.writingMode == 0) {
                try {
                    long j = newCapacity;
                    MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                } catch (IOException e) {
                    error(new Exception(MAP_FAILED, e));
                    this.fastBuffer.m21860a(0, this.dataEnd - 12);
                    this.fastBuffer.m21859a(4, this.checksum);
                    toBlockingMode();
                }
            }
        }
    }

    private void error(String str) {
        InterfaceC11396b interfaceC11396b = this.logger;
        if (interfaceC11396b != null) {
            interfaceC11396b.m22045b(this.name, new Exception(str));
        }
    }

    private void fastPutString(String str, String str2, Container.C11411i c11411i) {
        int m21851b = FastBuffer.m21851b(str2);
        if (c11411i == null) {
            int m21851b2 = FastBuffer.m21851b(str);
            checkKeySize(m21851b2);
            int i = m21851b2 + 4;
            this.updateSize = i + m21851b;
            preparePutBytes();
            this.fastBuffer.m21862a((byte) 6);
            putKey(str, m21851b2);
            putStringValue(str2, m21851b);
            Map<String, Container.AbstractC11404b> map = this.data;
            int i2 = this.updateStart;
            map.put(str, new Container.C11411i(i2, i2 + i, str2, m21851b, false));
            updateChange();
        } else {
            int i3 = c11411i.f31016a;
            int i4 = i3 - c11411i.f31023c;
            int i5 = c11411i.f31024d;
            boolean z = true;
            if (i5 == m21851b) {
                this.checksum = this.fastBuffer.m21852b(i3, i5) ^ this.checksum;
                if (m21851b == str2.length()) {
                    str2.getBytes(0, m21851b, this.fastBuffer.f31084a, c11411i.f31016a);
                } else {
                    FastBuffer fastBuffer = this.fastBuffer;
                    fastBuffer.f31085b = c11411i.f31016a;
                    fastBuffer.m21857a(str2);
                }
                this.updateStart = c11411i.f31016a;
                this.updateSize = m21851b;
                z = false;
            } else {
                this.updateSize = i4 + m21851b;
                preparePutBytes();
                this.fastBuffer.m21862a((byte) 6);
                int i6 = i4 - 3;
                FastBuffer fastBuffer2 = this.fastBuffer;
                byte[] bArr = fastBuffer2.f31084a;
                System.arraycopy(bArr, c11411i.f31023c + 1, bArr, fastBuffer2.f31085b, i6);
                this.fastBuffer.f31085b += i6;
                putStringValue(str2, m21851b);
                remove((byte) 6, c11411i.f31023c, c11411i.f31016a + c11411i.f31024d);
                r10 = c11411i.f31025e ? (String) c11411i.f31022b : null;
                c11411i.f31025e = false;
                int i7 = this.updateStart;
                c11411i.f31023c = i7;
                c11411i.f31016a = i7 + i4;
                c11411i.f31024d = m21851b;
            }
            c11411i.f31022b = str2;
            updateChange();
            if (z) {
                checkGC();
            }
            if (r10 != null) {
                C11401aj.m21940c(new File(this.path + this.name, r10));
            }
        }
        checkIfCommit();
    }

    private byte[] getArrayFromFile(Container.C11403a c11403a) {
        try {
            byte[] m21941b = C11401aj.m21941b(new File(this.path + this.name, (String) c11403a.f31022b));
            return m21941b != null ? m21941b : EMPTY_ARRAY;
        } catch (Exception e) {
            error(e);
            return EMPTY_ARRAY;
        }
    }

    private int getNewCapacity(int i, int i2) {
        if (i2 <= 536870912) {
            int i3 = PAGE_SIZE;
            if (i2 <= i3) {
                return i3;
            }
            while (i < i2) {
                int i4 = DOUBLE_LIMIT;
                i = i <= i4 ? i << 1 : i + i4;
            }
            return i;
        }
        throw new IllegalStateException("data size out of limit");
    }

    private Object getObjectFromFile(Container.C11410h c11410h) {
        String str;
        try {
            byte[] m21941b = C11401aj.m21941b(new File(this.path + this.name, (String) c11410h.f31022b));
            if (m21941b != null) {
                int i = m21941b[0] & UByte.f41242c;
                if (Build.VERSION.SDK_INT >= 19) {
                    str = new String(m21941b, 1, i, StandardCharsets.UTF_8);
                } else {
                    str = new String(m21941b, 1, i);
                }
                InterfaceC11395a interfaceC11395a = this.encoderMap.get(str);
                if (interfaceC11395a != null) {
                    int i2 = i + 1;
                    return interfaceC11395a.mo21958a(m21941b, i2, m21941b.length - i2);
                }
                warning(new Exception("No encoder for tag:" + str));
                return null;
            }
            warning(new Exception("Read object data failed"));
            return null;
        } catch (Exception e) {
            error(e);
            return null;
        }
    }

    private String getStringFromFile(Container.C11411i c11411i) {
        try {
            byte[] m21941b = C11401aj.m21941b(new File(this.path + this.name, (String) c11411i.f31022b));
            if (m21941b != null) {
                return Build.VERSION.SDK_INT >= 19 ? m21941b.length == 0 ? "" : new String(m21941b, StandardCharsets.UTF_8) : m21941b.length == 0 ? "" : new String(m21941b);
            }
        } catch (Exception e) {
            error(e);
        }
        return "";
    }

    private void info(String str) {
        InterfaceC11396b interfaceC11396b = this.logger;
        if (interfaceC11396b != null) {
            interfaceC11396b.m22046a(this.name, str);
        }
    }

    private boolean isABFileEqual() {
        FastBuffer fastBuffer = new FastBuffer(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(fastBuffer.f31084a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.f31084a;
        byte[] bArr2 = fastBuffer.f31084a;
        for (int i = 0; i < this.dataEnd; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void loadData() {
        synchronized (this.data) {
            this.startLoading = true;
            this.data.notify();
        }
        long nanoTime = System.nanoTime();
        if (!loadFromCFile() && this.writingMode == 0) {
            loadFromABFile();
        }
        if (this.fastBuffer == null) {
            this.fastBuffer = new FastBuffer(PAGE_SIZE);
        }
        if (this.logger != null) {
            info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0196 A[Catch: Exception -> 0x01b8, TryCatch #0 {Exception -> 0x01b8, blocks: (B:3:0x0038, B:5:0x003e, B:8:0x0046, B:9:0x0064, B:13:0x0075, B:17:0x0090, B:18:0x0099, B:22:0x00b2, B:23:0x00b6, B:25:0x00d3, B:27:0x00da, B:29:0x00fc, B:31:0x0102, B:37:0x010f, B:39:0x0115, B:41:0x012c, B:43:0x0134, B:45:0x014d, B:46:0x015a, B:48:0x0176, B:50:0x017c, B:53:0x0196, B:16:0x008c, B:12:0x0072, B:55:0x01a0, B:57:0x01aa), top: B:62:0x0038, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadFromABFile() {
        /*
            Method dump skipped, instructions count: 451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.loadFromABFile():void");
    }

    private boolean loadFromCFile() {
        String str = this.path;
        File file = new File(str, this.name + C_SUFFIX);
        String str2 = this.path;
        File file2 = new File(str2, this.name + ".tmp");
        boolean z = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (loadWithBlockingIO(file)) {
                    if (this.writingMode == 0) {
                        if (writeToABFile(this.fastBuffer)) {
                            info("recover from c file");
                            try {
                                deleteCFiles();
                                return true;
                            } catch (Exception e) {
                                e = e;
                                error(e);
                                return z;
                            }
                        }
                        this.writingMode = 1;
                    }
                } else {
                    clearData();
                    deleteCFiles();
                }
            } else if (this.writingMode != 0) {
                String str3 = this.path;
                File file3 = new File(str3, this.name + A_SUFFIX);
                String str4 = this.path;
                File file4 = new File(str4, this.name + B_SUFFIX);
                if (file3.exists() && file4.exists()) {
                    tryBlockingIO(file3, file4);
                }
            }
            return false;
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        long length = file.length();
        if (length != 0 && length <= IjkMediaMeta.AV_CH_STEREO_LEFT) {
            int i = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i);
            FastBuffer fastBuffer = this.fastBuffer;
            if (fastBuffer != null && fastBuffer.f31084a.length == newCapacity) {
                fastBuffer.f31085b = 0;
            } else {
                fastBuffer = new FastBuffer(new byte[newCapacity]);
                this.fastBuffer = fastBuffer;
            }
            C11401aj.m21943a(file, fastBuffer.f31084a, i);
            int m21850c = fastBuffer.m21850c();
            long m21848d = fastBuffer.m21848d();
            this.dataEnd = m21850c + 12;
            if (m21850c >= 0 && m21850c <= i - 12 && m21848d == fastBuffer.m21852b(12, m21850c) && parseData() == 0) {
                this.checksum = m21848d;
                return true;
            }
        }
        return false;
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        C11397c c11397c = this.invalids.get(size);
        while (size > 0) {
            size--;
            C11397c c11397c2 = this.invalids.get(size);
            if (c11397c.f30961a == c11397c2.f30962b) {
                c11397c2.f30962b = c11397c.f30962b;
                this.invalids.remove(size + 1);
            }
            c11397c = c11397c2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x017c, code lost:
        throw new java.lang.Exception(com.mbridge.msdk.foundation.tools.FastKV.PARSE_DATA_FAILED);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parseData() {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.parseData():int");
    }

    private void preparePutBytes() {
        ensureSize(this.updateSize);
        int i = this.dataEnd;
        this.updateStart = i;
        this.dataEnd = this.updateSize + i;
        this.fastBuffer.f31085b = i;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i) {
        this.fastBuffer.m21862a((byte) i);
        if (i == str.length()) {
            FastBuffer fastBuffer = this.fastBuffer;
            str.getBytes(0, i, fastBuffer.f31084a, fastBuffer.f31085b);
            this.fastBuffer.f31085b += i;
            return;
        }
        this.fastBuffer.m21857a(str);
    }

    private void putStringValue(String str, int i) {
        this.fastBuffer.m21856a((short) i);
        if (i == str.length()) {
            FastBuffer fastBuffer = this.fastBuffer;
            str.getBytes(0, i, fastBuffer.f31084a, fastBuffer.f31085b);
            return;
        }
        this.fastBuffer.m21857a(str);
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        int capacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (capacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.aBuffer ? this.aChannel : this.bChannel;
            fileChannel.truncate(i);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aBuffer) {
                this.aBuffer = map;
            } else {
                this.bBuffer = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void resetData() {
        if (this.writingMode == 0) {
            try {
                resetBuffer(this.aBuffer);
                resetBuffer(this.bBuffer);
            } catch (IOException unused) {
                toBlockingMode();
            }
        }
        clearData();
        C11401aj.m21940c(new File(this.path + this.name));
    }

    private int saveArray(String str, byte[] bArr, byte b) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String m21947a = C11401aj.m21947a();
        if (C11401aj.m21944a(new File(this.path + this.name, m21947a), bArr)) {
            this.tempExternalName = m21947a;
            byte[] bArr2 = new byte[32];
            m21947a.getBytes(0, 32, bArr2, 0);
            return wrapArray(str, bArr2, (byte) (b | 64));
        }
        error("save large value failed");
        return 0;
    }

    private long shiftCheckSum(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i = this.removeStart;
        if (i != 0) {
            mappedByteBuffer.put(i, this.fastBuffer.f31084a[i]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.f31084a, this.updateStart, this.updateSize);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        C11401aj.m21946a(this.aChannel);
        C11401aj.m21946a(this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void truncate(int i) {
        int i2 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i2, i + i2);
        byte[] bArr = this.fastBuffer.f31084a;
        if (newCapacity >= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[newCapacity];
        System.arraycopy(bArr, 0, bArr2, 0, this.dataEnd);
        this.fastBuffer.f31084a = bArr2;
        if (this.writingMode == 0) {
            try {
                long j = newCapacity;
                this.aChannel.truncate(j);
                MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aBuffer = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.bChannel.truncate(j);
                MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.bBuffer = map2;
                map2.order(byteOrder);
            } catch (IOException e) {
                error(new Exception(MAP_FAILED, e));
                toBlockingMode();
            }
        }
        info(TRUNCATE_FINISH);
    }

    private void tryBlockingIO(File file, File file2) {
        try {
            if (loadWithBlockingIO(file)) {
                return;
            }
        } catch (IOException e) {
            warning(e);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e2) {
            warning(e2);
        }
        clearData();
    }

    private void updateBoolean(byte b, int i) {
        long shiftCheckSum = this.checksum ^ shiftCheckSum(1L, i);
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.put(i, b);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i, b);
        } else {
            this.fastBuffer.m21859a(4, shiftCheckSum);
        }
        this.fastBuffer.f31084a[i] = b;
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.m21852b(i, length);
        FastBuffer fastBuffer = this.fastBuffer;
        fastBuffer.f31085b = i;
        fastBuffer.m21855a(bArr);
        long m21852b = this.checksum ^ this.fastBuffer.m21852b(i, length);
        this.checksum = m21852b;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i);
            this.aBuffer.put(bArr);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i);
            this.bBuffer.put(bArr);
            return;
        }
        this.fastBuffer.m21859a(4, m21852b);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.m21852b(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.m21860a(0, this.dataEnd - 12);
            }
            this.fastBuffer.m21859a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void updateInt32(int i, long j, int i2) {
        long shiftCheckSum = shiftCheckSum(j, i2) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putInt(i2, i);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i2, i);
        } else {
            this.fastBuffer.m21859a(4, shiftCheckSum);
        }
        this.fastBuffer.m21860a(i2, i);
    }

    private void updateInt64(long j, long j2, int i) {
        long shiftCheckSum = shiftCheckSum(j2, i) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putLong(i, j);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i, j);
        } else {
            this.fastBuffer.m21859a(4, shiftCheckSum);
        }
        this.fastBuffer.m21859a(i, j);
    }

    private void updateObject(String str, Object obj, byte[] bArr, Container.AbstractC11412j abstractC11412j) {
        int saveArray = saveArray(str, bArr, abstractC11412j.mo21925a());
        if (saveArray != 0) {
            String str2 = abstractC11412j.f31025e ? (String) abstractC11412j.f31022b : null;
            remove(abstractC11412j.mo21925a(), abstractC11412j.f31023c, abstractC11412j.f31016a + abstractC11412j.f31024d);
            String str3 = this.tempExternalName;
            boolean z = str3 != null;
            abstractC11412j.f31023c = this.updateStart;
            abstractC11412j.f31016a = saveArray;
            abstractC11412j.f31025e = z;
            if (z) {
                abstractC11412j.f31022b = str3;
                abstractC11412j.f31024d = 32;
                this.tempExternalName = null;
            } else {
                abstractC11412j.f31022b = obj;
                abstractC11412j.f31024d = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                C11401aj.m21940c(new File(this.path + this.name, str2));
            }
        }
    }

    private void updateOffset(int i, int[] iArr) {
        for (Container.AbstractC11404b abstractC11404b : this.data.values()) {
            int i2 = abstractC11404b.f31016a;
            if (i2 > i) {
                int i3 = 0;
                int length = (iArr.length >> 1) - 1;
                while (true) {
                    if (i3 > length) {
                        break;
                    }
                    int i4 = (i3 + length) >>> 1;
                    int i5 = iArr[i4 << 1];
                    if (i5 >= i2) {
                        if (i5 <= i2) {
                            length = i4;
                            break;
                        }
                        length = i4 - 1;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                int i6 = iArr[(length << 1) + 1];
                abstractC11404b.f31016a -= i6;
                if (abstractC11404b.mo21925a() >= 6) {
                    ((Container.AbstractC11412j) abstractC11404b).f31023c -= i6;
                }
            }
        }
    }

    private void warning(Exception exc) {
        InterfaceC11396b interfaceC11396b = this.logger;
        if (interfaceC11396b != null) {
            interfaceC11396b.m22047a(this.name, exc);
        }
    }

    private int wrapArray(String str, byte[] bArr, byte b) {
        wrapHeader(str, b, bArr.length + 2);
        this.fastBuffer.m21856a((short) bArr.length);
        FastBuffer fastBuffer = this.fastBuffer;
        int i = fastBuffer.f31085b;
        fastBuffer.m21855a(bArr);
        return i;
    }

    private void wrapHeader(String str, byte b) {
        wrapHeader(str, b, TYPE_SIZE[b]);
    }

    private boolean writeToABFile(FastBuffer fastBuffer) {
        int length = fastBuffer.f31084a.length;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (C11401aj.m21945a(file) && C11401aj.m21945a(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j = length;
                randomAccessFile.setLength(j);
                randomAccessFile2.setLength(j);
                this.aChannel = randomAccessFile.getChannel();
                this.bChannel = randomAccessFile2.getChannel();
                MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aBuffer = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.bBuffer = map2;
                map2.order(byteOrder);
                this.aBuffer.put(fastBuffer.f31084a, 0, this.dataEnd);
                this.bBuffer.put(fastBuffer.f31084a, 0, this.dataEnd);
                return true;
            }
            throw new Exception(OPEN_FILE_FAILED);
        } catch (Exception e) {
            error(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            String str = this.path;
            File file = new File(str, this.name + ".tmp");
            if (C11401aj.m21945a(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.dataEnd);
                randomAccessFile.write(this.fastBuffer.f31084a, 0, this.dataEnd);
                randomAccessFile.close();
                String str2 = this.path;
                File file2 = new File(str2, this.name + C_SUFFIX);
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    warning(new Exception("rename failed"));
                }
            }
        } catch (Exception e) {
            error(e);
        }
        return false;
    }

    public synchronized void clear() {
        resetData();
        if (this.writingMode != 0) {
            deleteCFiles();
        }
    }

    public synchronized boolean commit() {
        this.autoCommit = true;
        return commitToCFile();
    }

    public synchronized boolean contains(String str) {
        return this.data.containsKey(str);
    }

    public synchronized void disableAutoCommit() {
        this.autoCommit = false;
    }

    public synchronized void force() {
        if (this.writingMode == 0) {
            this.aBuffer.force();
            this.bBuffer.force();
        }
    }

    /* renamed from: gc */
    void m22048gc(int i) {
        Collections.sort(this.invalids);
        mergeInvalids();
        C11397c c11397c = this.invalids.get(0);
        int i2 = c11397c.f30961a;
        int i3 = this.dataEnd;
        int i4 = i3 - this.invalidBytes;
        int i5 = i4 - 12;
        int i6 = i4 - i2;
        int i7 = i3 - i2;
        boolean z = i5 < i7 + i6;
        if (!z) {
            this.checksum ^= this.fastBuffer.m21852b(i2, i7);
        }
        int size = this.invalids.size();
        int i8 = size - 1;
        int i9 = this.dataEnd - this.invalids.get(i8).f30962b;
        int[] iArr = new int[(i9 > 0 ? size : i8) << 1];
        int i10 = c11397c.f30961a;
        int i11 = c11397c.f30962b;
        for (int i12 = 1; i12 < size; i12++) {
            C11397c c11397c2 = this.invalids.get(i12);
            int i13 = c11397c2.f30961a - i11;
            byte[] bArr = this.fastBuffer.f31084a;
            System.arraycopy(bArr, i11, bArr, i10, i13);
            int i14 = (i12 - 1) << 1;
            iArr[i14] = i11;
            iArr[i14 + 1] = i11 - i10;
            i10 += i13;
            i11 = c11397c2.f30962b;
        }
        if (i9 > 0) {
            byte[] bArr2 = this.fastBuffer.f31084a;
            System.arraycopy(bArr2, i11, bArr2, i10, i9);
            int i15 = i8 << 1;
            iArr[i15] = i11;
            iArr[i15 + 1] = i11 - i10;
        }
        clearInvalid();
        if (z) {
            this.checksum = this.fastBuffer.m21852b(12, i5);
        } else {
            this.checksum ^= this.fastBuffer.m21852b(i2, i6);
        }
        this.dataEnd = i4;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i2);
            this.aBuffer.put(this.fastBuffer.f31084a, i2, i6);
            this.aBuffer.putInt(0, i5);
            this.bBuffer.putInt(0, i5);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i2);
            this.bBuffer.put(this.fastBuffer.f31084a, i2, i6);
        } else {
            this.fastBuffer.m21860a(0, i5);
            this.fastBuffer.m21859a(4, this.checksum);
        }
        updateOffset(i2, iArr);
        int i16 = i4 + i;
        if (this.fastBuffer.f31084a.length - i16 > TRUNCATE_THRESHOLD) {
            truncate(i16);
        }
        info(GC_FINISH);
    }

    public synchronized Map<String, Object> getAll() {
        Object valueOf;
        int size = this.data.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, Container.AbstractC11404b> entry : this.data.entrySet()) {
            String key = entry.getKey();
            Container.AbstractC11404b value = entry.getValue();
            Object obj = null;
            switch (value.mo21925a()) {
                case 1:
                    valueOf = Boolean.valueOf(((Container.C11405c) value).f31017b);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((Container.C11408f) value).f31020b);
                    break;
                case 3:
                    valueOf = Float.valueOf(((Container.C11407e) value).f31019b);
                    break;
                case 4:
                    valueOf = Long.valueOf(((Container.C11409g) value).f31021b);
                    break;
                case 5:
                    valueOf = Double.valueOf(((Container.C11406d) value).f31018b);
                    break;
                case 6:
                    Container.C11411i c11411i = (Container.C11411i) value;
                    if (c11411i.f31025e) {
                        valueOf = getStringFromFile(c11411i);
                        break;
                    } else {
                        valueOf = c11411i.f31022b;
                        break;
                    }
                case 7:
                    Container.C11403a c11403a = (Container.C11403a) value;
                    if (c11403a.f31025e) {
                        valueOf = getArrayFromFile(c11403a);
                        break;
                    } else {
                        valueOf = c11403a.f31022b;
                        break;
                    }
                case 8:
                    Container.C11410h c11410h = (Container.C11410h) value;
                    if (c11410h.f31025e) {
                        valueOf = getObjectFromFile(c11410h);
                        break;
                    } else {
                        valueOf = ((Container.C11410h) value).f31022b;
                        break;
                    }
                default:
                    continue;
                    hashMap.put(key, obj);
            }
            obj = valueOf;
            hashMap.put(key, obj);
        }
        return hashMap;
    }

    public byte[] getArray(String str) {
        return getArray(str, EMPTY_ARRAY);
    }

    public synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public double getDouble(String str) {
        return getDouble(str, Utils.DOUBLE_EPSILON);
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized long getLong(String str) {
        Container.C11409g c11409g;
        c11409g = (Container.C11409g) this.data.get(str);
        return c11409g == null ? 0L : c11409g.f31021b;
    }

    public synchronized <T> T getObject(String str) {
        Container.C11410h c11410h = (Container.C11410h) this.data.get(str);
        if (c11410h != null) {
            return c11410h.f31025e ? (T) getObjectFromFile(c11410h) : (T) c11410h.f31022b;
        }
        return null;
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public synchronized Set<String> getStringSet(String str) {
        return (Set) getObject(str);
    }

    public void putAll(Map<String, Object> map) {
        putAll(map, null);
    }

    public synchronized void putArray(String str, byte[] bArr) {
        checkKey(str);
        if (bArr == null) {
            remove(str);
        } else {
            addOrUpdate(str, bArr, bArr, (Container.C11403a) this.data.get(str), (byte) 7);
        }
    }

    public synchronized void putBoolean(String str, boolean z) {
        checkKey(str);
        Container.C11405c c11405c = (Container.C11405c) this.data.get(str);
        if (c11405c == null) {
            wrapHeader(str, (byte) 1);
            FastBuffer fastBuffer = this.fastBuffer;
            int i = fastBuffer.f31085b;
            fastBuffer.m21862a((byte) (z ? 1 : 0));
            updateChange();
            this.data.put(str, new Container.C11405c(i, z));
            checkIfCommit();
        } else if (c11405c.f31017b != z) {
            c11405c.f31017b = z;
            updateBoolean((byte) (z ? 1 : 0), c11405c.f31016a);
            checkIfCommit();
        }
    }

    public synchronized void putDouble(String str, double d) {
        checkKey(str);
        Container.C11406d c11406d = (Container.C11406d) this.data.get(str);
        if (c11406d == null) {
            wrapHeader(str, (byte) 5);
            FastBuffer fastBuffer = this.fastBuffer;
            int i = fastBuffer.f31085b;
            fastBuffer.m21858a(Double.doubleToRawLongBits(d));
            updateChange();
            this.data.put(str, new Container.C11406d(i, d));
            checkIfCommit();
        } else if (c11406d.f31018b != d) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d);
            c11406d.f31018b = d;
            updateInt64(doubleToRawLongBits, Double.doubleToRawLongBits(c11406d.f31018b) ^ doubleToRawLongBits, c11406d.f31016a);
            checkIfCommit();
        }
    }

    public synchronized void putFloat(String str, float f) {
        checkKey(str);
        Container.C11407e c11407e = (Container.C11407e) this.data.get(str);
        if (c11407e == null) {
            wrapHeader(str, (byte) 3);
            FastBuffer fastBuffer = this.fastBuffer;
            int i = fastBuffer.f31085b;
            fastBuffer.m21861a(Float.floatToRawIntBits(f));
            updateChange();
            this.data.put(str, new Container.C11407e(i, f));
            checkIfCommit();
        } else if (c11407e.f31019b != f) {
            int floatToRawIntBits = Float.floatToRawIntBits(f);
            c11407e.f31019b = f;
            updateInt32(floatToRawIntBits, (Float.floatToRawIntBits(c11407e.f31019b) ^ floatToRawIntBits) & 4294967295L, c11407e.f31016a);
            checkIfCommit();
        }
    }

    public synchronized void putInt(String str, int i) {
        checkKey(str);
        Container.C11408f c11408f = (Container.C11408f) this.data.get(str);
        if (c11408f == null) {
            wrapHeader(str, (byte) 2);
            FastBuffer fastBuffer = this.fastBuffer;
            int i2 = fastBuffer.f31085b;
            fastBuffer.m21861a(i);
            updateChange();
            this.data.put(str, new Container.C11408f(i2, i));
            checkIfCommit();
        } else {
            int i3 = c11408f.f31020b;
            if (i3 != i) {
                c11408f.f31020b = i;
                updateInt32(i, (i3 ^ i) & 4294967295L, c11408f.f31016a);
                checkIfCommit();
            }
        }
    }

    public synchronized void putLong(String str, long j) {
        checkKey(str);
        Container.C11409g c11409g = (Container.C11409g) this.data.get(str);
        if (c11409g == null) {
            wrapHeader(str, (byte) 4);
            FastBuffer fastBuffer = this.fastBuffer;
            int i = fastBuffer.f31085b;
            fastBuffer.m21858a(j);
            updateChange();
            this.data.put(str, new Container.C11409g(i, j));
            checkIfCommit();
        } else {
            long j2 = c11409g.f31021b;
            if (j2 != j) {
                c11409g.f31021b = j;
                updateInt64(j, j ^ j2, c11409g.f31016a);
                checkIfCommit();
            }
        }
    }

    public synchronized <T> void putObject(String str, T t, InterfaceC11395a<T> interfaceC11395a) {
        checkKey(str);
        if (interfaceC11395a != null) {
            String mo21960a = interfaceC11395a.mo21960a();
            if (mo21960a != null && !mo21960a.isEmpty() && mo21960a.length() <= 50) {
                if (!this.encoderMap.containsKey(mo21960a)) {
                    throw new IllegalArgumentException("Encoder hasn't been registered");
                }
                if (t == null) {
                    remove(str);
                    return;
                }
                byte[] bArr = null;
                try {
                    bArr = interfaceC11395a.mo21959a(t);
                } catch (Exception e) {
                    error(e);
                }
                if (bArr == null) {
                    remove(str);
                    return;
                }
                int m21851b = FastBuffer.m21851b(mo21960a);
                FastBuffer fastBuffer = new FastBuffer(m21851b + 1 + bArr.length);
                fastBuffer.m21862a((byte) m21851b);
                fastBuffer.m21857a(mo21960a);
                fastBuffer.m21855a(bArr);
                addOrUpdate(str, t, fastBuffer.f31084a, (Container.C11410h) this.data.get(str), (byte) 8);
                return;
            }
            throw new IllegalArgumentException("Invalid encoder tag:" + mo21960a);
        }
        throw new IllegalArgumentException("Encoder is null");
    }

    public synchronized void putString(String str, String str2) {
        byte[] bytes;
        checkKey(str);
        if (str2 == null) {
            remove(str);
        } else {
            Container.C11411i c11411i = (Container.C11411i) this.data.get(str);
            if (str2.length() * 3 < 2048) {
                fastPutString(str, str2, c11411i);
            } else {
                if (Build.VERSION.SDK_INT >= 19) {
                    bytes = str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes(StandardCharsets.UTF_8);
                } else {
                    bytes = str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes();
                }
                addOrUpdate(str, str2, bytes, c11411i, (byte) 6);
            }
        }
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            putObject(str, set, StringSetEncoder.f30995a);
        }
    }

    public synchronized void remove(String str) {
        Container.AbstractC11404b abstractC11404b = this.data.get(str);
        if (abstractC11404b != null) {
            this.data.remove(str);
            byte mo21925a = abstractC11404b.mo21925a();
            String str2 = null;
            if (mo21925a <= 5) {
                int m21851b = FastBuffer.m21851b(str);
                int i = abstractC11404b.f31016a;
                remove(mo21925a, i - (m21851b + 2), i + TYPE_SIZE[mo21925a]);
            } else {
                Container.AbstractC11412j abstractC11412j = (Container.AbstractC11412j) abstractC11404b;
                remove(mo21925a, abstractC11412j.f31023c, abstractC11412j.f31016a + abstractC11412j.f31024d);
                if (abstractC11412j.f31025e) {
                    str2 = (String) abstractC11412j.f31022b;
                }
            }
            byte b = (byte) (mo21925a | Byte.MIN_VALUE);
            if (this.writingMode == 0) {
                this.aBuffer.putLong(4, this.checksum);
                this.aBuffer.put(this.removeStart, b);
                this.bBuffer.putLong(4, this.checksum);
                this.bBuffer.put(this.removeStart, b);
            } else {
                this.fastBuffer.m21859a(4, this.checksum);
            }
            this.removeStart = 0;
            if (str2 != null) {
                C11401aj.m21940c(new File(this.path + this.name, str2));
            }
            checkGC();
            checkIfCommit();
        }
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }

    private void wrapHeader(String str, byte b, int i) {
        int m21851b = FastBuffer.m21851b(str);
        checkKeySize(m21851b);
        this.updateSize = m21851b + 2 + i;
        preparePutBytes();
        this.fastBuffer.m21862a(b);
        putKey(str, m21851b);
    }

    public synchronized byte[] getArray(String str, byte[] bArr) {
        Container.C11403a c11403a = (Container.C11403a) this.data.get(str);
        if (c11403a != null) {
            return c11403a.f31025e ? getArrayFromFile(c11403a) : (byte[]) c11403a.f31022b;
        }
        return bArr;
    }

    public synchronized boolean getBoolean(String str, boolean z) {
        Container.C11405c c11405c = (Container.C11405c) this.data.get(str);
        if (c11405c != null) {
            z = c11405c.f31017b;
        }
        return z;
    }

    public synchronized double getDouble(String str, double d) {
        Container.C11406d c11406d = (Container.C11406d) this.data.get(str);
        if (c11406d != null) {
            d = c11406d.f31018b;
        }
        return d;
    }

    public synchronized float getFloat(String str, float f) {
        Container.C11407e c11407e = (Container.C11407e) this.data.get(str);
        if (c11407e != null) {
            f = c11407e.f31019b;
        }
        return f;
    }

    public synchronized int getInt(String str, int i) {
        Container.C11408f c11408f = (Container.C11408f) this.data.get(str);
        if (c11408f != null) {
            i = c11408f.f31020b;
        }
        return i;
    }

    public synchronized String getString(String str, String str2) {
        Container.C11411i c11411i = (Container.C11411i) this.data.get(str);
        if (c11411i != null) {
            return c11411i.f31025e ? getStringFromFile(c11411i) : (String) c11411i.f31022b;
        }
        return str2;
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, InterfaceC11395a> map2) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    putArray(key, (byte[]) value);
                } else if (map2 != null) {
                    InterfaceC11395a interfaceC11395a = map2.get(value.getClass());
                    if (interfaceC11395a != null) {
                        putObject(key, value, interfaceC11395a);
                    } else {
                        warning(new Exception("missing encoder for type:" + value.getClass()));
                    }
                } else {
                    warning(new Exception("missing encoders"));
                }
            }
        }
    }

    private void error(Exception exc) {
        InterfaceC11396b interfaceC11396b = this.logger;
        if (interfaceC11396b != null) {
            interfaceC11396b.m22045b(this.name, exc);
        }
    }

    public synchronized long getLong(String str, long j) {
        Container.C11409g c11409g = (Container.C11409g) this.data.get(str);
        if (c11409g != null) {
            j = c11409g.f31021b;
        }
        return j;
    }

    private void remove(byte b, int i, int i2) {
        countInvalid(i, i2);
        byte b2 = (byte) (b | Byte.MIN_VALUE);
        byte[] bArr = this.fastBuffer.f31084a;
        this.checksum = (((bArr[i] ^ b2) & 255) << ((i & 7) << 3)) ^ this.checksum;
        bArr[i] = b2;
        this.removeStart = i;
    }
}
