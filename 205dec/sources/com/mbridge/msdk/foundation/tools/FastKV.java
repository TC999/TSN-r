package com.mbridge.msdk.foundation.tools;

import android.os.Build;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.foundation.tools.c;
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

/* loaded from: E:\TSN-r\205dec\6520572.dex */
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
    private final Map<String, a> encoderMap;
    private j fastBuffer;
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
    private final b logger = k.f39860a;
    private final Map<String, c.b> data = new HashMap();
    private boolean startLoading = false;
    private final ArrayList<c> invalids = new ArrayList<>();
    private boolean autoCommit = true;
    private final Executor executor = new n();

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private a[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    if (!str.endsWith(TTPathConst.sSeparator)) {
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

        public Builder encoder(a[] aVarArr) {
            this.encoders = aVarArr;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a<T> {
        T a(byte[] bArr, int i4, int i5);

        String a();

        byte[] a(T t3);
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void a(String str, Exception exc);

        void a(String str, String str2);

        void b(String str, Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c implements Comparable<c> {

        /* renamed from: a  reason: collision with root package name */
        int f39734a;

        /* renamed from: b  reason: collision with root package name */
        int f39735b;

        c(int i4, int i5) {
            this.f39734a = i4;
            this.f39735b = i5;
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(c cVar) {
            return this.f39734a - cVar.f39734a;
        }
    }

    static {
        int b4 = aj.b();
        PAGE_SIZE = b4;
        int max = Math.max(b4 << 1, 16384);
        DOUBLE_LIMIT = max;
        TRUNCATE_THRESHOLD = max << 1;
    }

    FastKV(String str, String str2, a[] aVarArr, int i4) {
        this.path = str;
        this.name = str2;
        this.writingMode = i4;
        HashMap hashMap = new HashMap();
        hashMap.put("StringSet", af.f39768a);
        if (aVarArr != null && aVarArr.length > 0) {
            for (a aVar : aVarArr) {
                String a4 = aVar.a();
                if (hashMap.containsKey(a4)) {
                    error("duplicate encoder tag:" + a4);
                } else {
                    hashMap.put(a4, aVar);
                }
            }
        }
        this.encoderMap = hashMap;
        synchronized (this.data) {
            k.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.FastKV.1
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

    private void addObject(String str, Object obj, byte[] bArr, byte b4) {
        String str2;
        int length;
        c.b hVar;
        int saveArray = saveArray(str, bArr, b4);
        if (saveArray != 0) {
            String str3 = this.tempExternalName;
            boolean z3 = str3 != null;
            if (z3) {
                this.tempExternalName = null;
                str2 = str3;
                length = 32;
            } else {
                str2 = obj;
                length = bArr.length;
            }
            if (b4 == 6) {
                hVar = new c.i(this.updateStart, saveArray, (String) str2, length, z3);
            } else if (b4 == 7) {
                hVar = new c.a(this.updateStart, saveArray, str2, length, z3);
            } else {
                hVar = new c.h(this.updateStart, saveArray, str2, length, z3);
            }
            this.data.put(str, hVar);
            updateChange();
        }
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, c.j jVar, byte b4) {
        if (jVar == null) {
            addObject(str, obj, bArr, b4);
        } else if (!jVar.f39798e && jVar.f39797d == bArr.length) {
            updateBytes(jVar.f39789a, bArr);
            jVar.f39795b = obj;
        } else {
            updateObject(str, obj, bArr, jVar);
        }
        checkIfCommit();
    }

    private int bytesThreshold() {
        int i4 = this.dataEnd;
        if (i4 <= 16384) {
            return 4096;
        }
        return i4 <= 65536 ? 8192 : 16384;
    }

    private void checkGC() {
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            if (this.invalids.size() < (this.dataEnd < 16384 ? 80 : 160)) {
                return;
            }
        }
        gc(0);
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

    private void checkKeySize(int i4) {
        if (i4 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void checkValueSize(int i4, boolean z3) {
        if (z3) {
            if (i4 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i4 < 0 || i4 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0L;
        clearInvalid();
        this.data.clear();
        j jVar = this.fastBuffer;
        if (jVar != null && jVar.f39857a.length == PAGE_SIZE) {
            jVar.a(0, 0);
            this.fastBuffer.a(4, 0L);
            return;
        }
        this.fastBuffer = new j(PAGE_SIZE);
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private boolean commitToCFile() {
        int i4 = this.writingMode;
        if (i4 == 1) {
            this.executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.FastKV.2
                @Override // java.lang.Runnable
                public final void run() {
                    FastKV.this.writeToCFile();
                }
            });
        } else if (i4 == 2) {
            return writeToCFile();
        }
        return true;
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i4) {
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
            } catch (IOException e4) {
                error(e4);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i4);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void countInvalid(int i4, int i5) {
        this.invalidBytes += i5 - i4;
        this.invalids.add(new c(i4, i5));
    }

    private void deleteCFiles() {
        try {
            String str = this.path;
            aj.c(new File(str, this.name + C_SUFFIX));
            String str2 = this.path;
            aj.c(new File(str2, this.name + ".tmp"));
        } catch (Exception e4) {
            error(e4);
        }
    }

    private void ensureSize(int i4) {
        int length = this.fastBuffer.f39857a.length;
        int i5 = this.dataEnd + i4;
        if (i5 >= length) {
            int i6 = this.invalidBytes;
            if (i6 > i4 && i6 > bytesThreshold()) {
                gc(i4);
                return;
            }
            int newCapacity = getNewCapacity(length, i5);
            byte[] bArr = new byte[newCapacity];
            System.arraycopy(this.fastBuffer.f39857a, 0, bArr, 0, this.dataEnd);
            this.fastBuffer.f39857a = bArr;
            if (this.writingMode == 0) {
                try {
                    long j4 = newCapacity;
                    MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                } catch (IOException e4) {
                    error(new Exception(MAP_FAILED, e4));
                    this.fastBuffer.a(0, this.dataEnd - 12);
                    this.fastBuffer.a(4, this.checksum);
                    toBlockingMode();
                }
            }
        }
    }

    private void error(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.b(this.name, new Exception(str));
        }
    }

    private void fastPutString(String str, String str2, c.i iVar) {
        int b4 = j.b(str2);
        if (iVar == null) {
            int b5 = j.b(str);
            checkKeySize(b5);
            int i4 = b5 + 4;
            this.updateSize = i4 + b4;
            preparePutBytes();
            this.fastBuffer.a((byte) 6);
            putKey(str, b5);
            putStringValue(str2, b4);
            Map<String, c.b> map = this.data;
            int i5 = this.updateStart;
            map.put(str, new c.i(i5, i5 + i4, str2, b4, false));
            updateChange();
        } else {
            int i6 = iVar.f39789a;
            int i7 = i6 - iVar.f39796c;
            int i8 = iVar.f39797d;
            boolean z3 = true;
            if (i8 == b4) {
                this.checksum = this.fastBuffer.b(i6, i8) ^ this.checksum;
                if (b4 == str2.length()) {
                    str2.getBytes(0, b4, this.fastBuffer.f39857a, iVar.f39789a);
                } else {
                    j jVar = this.fastBuffer;
                    jVar.f39858b = iVar.f39789a;
                    jVar.a(str2);
                }
                this.updateStart = iVar.f39789a;
                this.updateSize = b4;
                z3 = false;
            } else {
                this.updateSize = i7 + b4;
                preparePutBytes();
                this.fastBuffer.a((byte) 6);
                int i9 = i7 - 3;
                j jVar2 = this.fastBuffer;
                byte[] bArr = jVar2.f39857a;
                System.arraycopy(bArr, iVar.f39796c + 1, bArr, jVar2.f39858b, i9);
                this.fastBuffer.f39858b += i9;
                putStringValue(str2, b4);
                remove((byte) 6, iVar.f39796c, iVar.f39789a + iVar.f39797d);
                r10 = iVar.f39798e ? (String) iVar.f39795b : null;
                iVar.f39798e = false;
                int i10 = this.updateStart;
                iVar.f39796c = i10;
                iVar.f39789a = i10 + i7;
                iVar.f39797d = b4;
            }
            iVar.f39795b = str2;
            updateChange();
            if (z3) {
                checkGC();
            }
            if (r10 != null) {
                aj.c(new File(this.path + this.name, r10));
            }
        }
        checkIfCommit();
    }

    private byte[] getArrayFromFile(c.a aVar) {
        try {
            byte[] b4 = aj.b(new File(this.path + this.name, (String) aVar.f39795b));
            return b4 != null ? b4 : EMPTY_ARRAY;
        } catch (Exception e4) {
            error(e4);
            return EMPTY_ARRAY;
        }
    }

    private int getNewCapacity(int i4, int i5) {
        if (i5 <= 536870912) {
            int i6 = PAGE_SIZE;
            if (i5 <= i6) {
                return i6;
            }
            while (i4 < i5) {
                int i7 = DOUBLE_LIMIT;
                i4 = i4 <= i7 ? i4 << 1 : i4 + i7;
            }
            return i4;
        }
        throw new IllegalStateException("data size out of limit");
    }

    private Object getObjectFromFile(c.h hVar) {
        String str;
        try {
            byte[] b4 = aj.b(new File(this.path + this.name, (String) hVar.f39795b));
            if (b4 != null) {
                int i4 = b4[0] & 255;
                if (Build.VERSION.SDK_INT >= 19) {
                    str = new String(b4, 1, i4, StandardCharsets.UTF_8);
                } else {
                    str = new String(b4, 1, i4);
                }
                a aVar = this.encoderMap.get(str);
                if (aVar != null) {
                    int i5 = i4 + 1;
                    return aVar.a(b4, i5, b4.length - i5);
                }
                warning(new Exception("No encoder for tag:" + str));
                return null;
            }
            warning(new Exception("Read object data failed"));
            return null;
        } catch (Exception e4) {
            error(e4);
            return null;
        }
    }

    private String getStringFromFile(c.i iVar) {
        try {
            byte[] b4 = aj.b(new File(this.path + this.name, (String) iVar.f39795b));
            if (b4 != null) {
                return Build.VERSION.SDK_INT >= 19 ? b4.length == 0 ? "" : new String(b4, StandardCharsets.UTF_8) : b4.length == 0 ? "" : new String(b4);
            }
        } catch (Exception e4) {
            error(e4);
        }
        return "";
    }

    private void info(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, str);
        }
    }

    private boolean isABFileEqual() {
        j jVar = new j(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(jVar.f39857a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.f39857a;
        byte[] bArr2 = jVar.f39857a;
        for (int i4 = 0; i4 < this.dataEnd; i4++) {
            if (bArr[i4] != bArr2[i4]) {
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
            this.fastBuffer = new j(PAGE_SIZE);
        }
        if (this.logger != null) {
            long nanoTime2 = (System.nanoTime() - nanoTime) / C.MICROS_PER_SECOND;
            info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + nanoTime2 + " ms");
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
        boolean z3 = true;
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
                            } catch (Exception e4) {
                                e = e4;
                                error(e);
                                return z3;
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
        } catch (Exception e5) {
            e = e5;
            z3 = false;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i4 = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i4);
            j jVar = this.fastBuffer;
            if (jVar != null && jVar.f39857a.length == newCapacity) {
                jVar.f39858b = 0;
            } else {
                jVar = new j(new byte[newCapacity]);
                this.fastBuffer = jVar;
            }
            aj.a(file, jVar.f39857a, i4);
            int c4 = jVar.c();
            long d4 = jVar.d();
            this.dataEnd = c4 + 12;
            if (c4 >= 0 && c4 <= i4 - 12 && d4 == jVar.b(12, c4) && parseData() == 0) {
                this.checksum = d4;
                return true;
            }
        }
        return false;
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        c cVar = this.invalids.get(size);
        while (size > 0) {
            size--;
            c cVar2 = this.invalids.get(size);
            if (cVar.f39734a == cVar2.f39735b) {
                cVar2.f39735b = cVar.f39735b;
                this.invalids.remove(size + 1);
            }
            cVar = cVar2;
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
        int i4 = this.dataEnd;
        this.updateStart = i4;
        this.dataEnd = this.updateSize + i4;
        this.fastBuffer.f39858b = i4;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i4) {
        this.fastBuffer.a((byte) i4);
        if (i4 == str.length()) {
            j jVar = this.fastBuffer;
            str.getBytes(0, i4, jVar.f39857a, jVar.f39858b);
            this.fastBuffer.f39858b += i4;
            return;
        }
        this.fastBuffer.a(str);
    }

    private void putStringValue(String str, int i4) {
        this.fastBuffer.a((short) i4);
        if (i4 == str.length()) {
            j jVar = this.fastBuffer;
            str.getBytes(0, i4, jVar.f39857a, jVar.f39858b);
            return;
        }
        this.fastBuffer.a(str);
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        int capacity = mappedByteBuffer.capacity();
        int i4 = PAGE_SIZE;
        if (capacity != i4) {
            FileChannel fileChannel = mappedByteBuffer == this.aBuffer ? this.aChannel : this.bChannel;
            fileChannel.truncate(i4);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i4);
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
        aj.c(new File(this.path + this.name));
    }

    private int saveArray(String str, byte[] bArr, byte b4) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b4);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String a4 = aj.a();
        if (aj.a(new File(this.path + this.name, a4), bArr)) {
            this.tempExternalName = a4;
            byte[] bArr2 = new byte[32];
            a4.getBytes(0, 32, bArr2, 0);
            return wrapArray(str, bArr2, (byte) (b4 | 64));
        }
        error("save large value failed");
        return 0;
    }

    private long shiftCheckSum(long j4, int i4) {
        int i5 = (i4 & 7) << 3;
        return (j4 >>> (64 - i5)) | (j4 << i5);
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i4 = this.removeStart;
        if (i4 != 0) {
            mappedByteBuffer.put(i4, this.fastBuffer.f39857a[i4]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.f39857a, this.updateStart, this.updateSize);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        aj.a(this.aChannel);
        aj.a(this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void truncate(int i4) {
        int i5 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i5, i4 + i5);
        byte[] bArr = this.fastBuffer.f39857a;
        if (newCapacity >= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[newCapacity];
        System.arraycopy(bArr, 0, bArr2, 0, this.dataEnd);
        this.fastBuffer.f39857a = bArr2;
        if (this.writingMode == 0) {
            try {
                long j4 = newCapacity;
                this.aChannel.truncate(j4);
                MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                this.aBuffer = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.bChannel.truncate(j4);
                MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                this.bBuffer = map2;
                map2.order(byteOrder);
            } catch (IOException e4) {
                error(new Exception(MAP_FAILED, e4));
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
        } catch (IOException e4) {
            warning(e4);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e5) {
            warning(e5);
        }
        clearData();
    }

    private void updateBoolean(byte b4, int i4) {
        long shiftCheckSum = this.checksum ^ shiftCheckSum(1L, i4);
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.put(i4, b4);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i4, b4);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.f39857a[i4] = b4;
    }

    private void updateBytes(int i4, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.b(i4, length);
        j jVar = this.fastBuffer;
        jVar.f39858b = i4;
        jVar.a(bArr);
        long b4 = this.checksum ^ this.fastBuffer.b(i4, length);
        this.checksum = b4;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i4);
            this.aBuffer.put(bArr);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i4);
            this.bBuffer.put(bArr);
            return;
        }
        this.fastBuffer.a(4, b4);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.b(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.a(0, this.dataEnd - 12);
            }
            this.fastBuffer.a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void updateInt32(int i4, long j4, int i5) {
        long shiftCheckSum = shiftCheckSum(j4, i5) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putInt(i5, i4);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i5, i4);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.a(i5, i4);
    }

    private void updateInt64(long j4, long j5, int i4) {
        long shiftCheckSum = shiftCheckSum(j5, i4) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putLong(i4, j4);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i4, j4);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.a(i4, j4);
    }

    private void updateObject(String str, Object obj, byte[] bArr, c.j jVar) {
        int saveArray = saveArray(str, bArr, jVar.a());
        if (saveArray != 0) {
            String str2 = jVar.f39798e ? (String) jVar.f39795b : null;
            remove(jVar.a(), jVar.f39796c, jVar.f39789a + jVar.f39797d);
            String str3 = this.tempExternalName;
            boolean z3 = str3 != null;
            jVar.f39796c = this.updateStart;
            jVar.f39789a = saveArray;
            jVar.f39798e = z3;
            if (z3) {
                jVar.f39795b = str3;
                jVar.f39797d = 32;
                this.tempExternalName = null;
            } else {
                jVar.f39795b = obj;
                jVar.f39797d = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                aj.c(new File(this.path + this.name, str2));
            }
        }
    }

    private void updateOffset(int i4, int[] iArr) {
        for (c.b bVar : this.data.values()) {
            int i5 = bVar.f39789a;
            if (i5 > i4) {
                int i6 = 0;
                int length = (iArr.length >> 1) - 1;
                while (true) {
                    if (i6 > length) {
                        break;
                    }
                    int i7 = (i6 + length) >>> 1;
                    int i8 = iArr[i7 << 1];
                    if (i8 >= i5) {
                        if (i8 <= i5) {
                            length = i7;
                            break;
                        }
                        length = i7 - 1;
                    } else {
                        i6 = i7 + 1;
                    }
                }
                int i9 = iArr[(length << 1) + 1];
                bVar.f39789a -= i9;
                if (bVar.a() >= 6) {
                    ((c.j) bVar).f39796c -= i9;
                }
            }
        }
    }

    private void warning(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, exc);
        }
    }

    private int wrapArray(String str, byte[] bArr, byte b4) {
        wrapHeader(str, b4, bArr.length + 2);
        this.fastBuffer.a((short) bArr.length);
        j jVar = this.fastBuffer;
        int i4 = jVar.f39858b;
        jVar.a(bArr);
        return i4;
    }

    private void wrapHeader(String str, byte b4) {
        wrapHeader(str, b4, TYPE_SIZE[b4]);
    }

    private boolean writeToABFile(j jVar) {
        int length = jVar.f39857a.length;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (aj.a(file) && aj.a(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j4 = length;
                randomAccessFile.setLength(j4);
                randomAccessFile2.setLength(j4);
                this.aChannel = randomAccessFile.getChannel();
                this.bChannel = randomAccessFile2.getChannel();
                MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                this.aBuffer = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                this.bBuffer = map2;
                map2.order(byteOrder);
                this.aBuffer.put(jVar.f39857a, 0, this.dataEnd);
                this.bBuffer.put(jVar.f39857a, 0, this.dataEnd);
                return true;
            }
            throw new Exception(OPEN_FILE_FAILED);
        } catch (Exception e4) {
            error(e4);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            String str = this.path;
            File file = new File(str, this.name + ".tmp");
            if (aj.a(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.dataEnd);
                randomAccessFile.write(this.fastBuffer.f39857a, 0, this.dataEnd);
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
        } catch (Exception e4) {
            error(e4);
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

    void gc(int i4) {
        Collections.sort(this.invalids);
        mergeInvalids();
        c cVar = this.invalids.get(0);
        int i5 = cVar.f39734a;
        int i6 = this.dataEnd;
        int i7 = i6 - this.invalidBytes;
        int i8 = i7 - 12;
        int i9 = i7 - i5;
        int i10 = i6 - i5;
        boolean z3 = i8 < i10 + i9;
        if (!z3) {
            this.checksum ^= this.fastBuffer.b(i5, i10);
        }
        int size = this.invalids.size();
        int i11 = size - 1;
        int i12 = this.dataEnd - this.invalids.get(i11).f39735b;
        int[] iArr = new int[(i12 > 0 ? size : i11) << 1];
        int i13 = cVar.f39734a;
        int i14 = cVar.f39735b;
        for (int i15 = 1; i15 < size; i15++) {
            c cVar2 = this.invalids.get(i15);
            int i16 = cVar2.f39734a - i14;
            byte[] bArr = this.fastBuffer.f39857a;
            System.arraycopy(bArr, i14, bArr, i13, i16);
            int i17 = (i15 - 1) << 1;
            iArr[i17] = i14;
            iArr[i17 + 1] = i14 - i13;
            i13 += i16;
            i14 = cVar2.f39735b;
        }
        if (i12 > 0) {
            byte[] bArr2 = this.fastBuffer.f39857a;
            System.arraycopy(bArr2, i14, bArr2, i13, i12);
            int i18 = i11 << 1;
            iArr[i18] = i14;
            iArr[i18 + 1] = i14 - i13;
        }
        clearInvalid();
        if (z3) {
            this.checksum = this.fastBuffer.b(12, i8);
        } else {
            this.checksum ^= this.fastBuffer.b(i5, i9);
        }
        this.dataEnd = i7;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i5);
            this.aBuffer.put(this.fastBuffer.f39857a, i5, i9);
            this.aBuffer.putInt(0, i8);
            this.bBuffer.putInt(0, i8);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i5);
            this.bBuffer.put(this.fastBuffer.f39857a, i5, i9);
        } else {
            this.fastBuffer.a(0, i8);
            this.fastBuffer.a(4, this.checksum);
        }
        updateOffset(i5, iArr);
        int i19 = i7 + i4;
        if (this.fastBuffer.f39857a.length - i19 > TRUNCATE_THRESHOLD) {
            truncate(i19);
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
        for (Map.Entry<String, c.b> entry : this.data.entrySet()) {
            String key = entry.getKey();
            c.b value = entry.getValue();
            Object obj = null;
            switch (value.a()) {
                case 1:
                    valueOf = Boolean.valueOf(((c.C0744c) value).f39790b);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((c.f) value).f39793b);
                    break;
                case 3:
                    valueOf = Float.valueOf(((c.e) value).f39792b);
                    break;
                case 4:
                    valueOf = Long.valueOf(((c.g) value).f39794b);
                    break;
                case 5:
                    valueOf = Double.valueOf(((c.d) value).f39791b);
                    break;
                case 6:
                    c.i iVar = (c.i) value;
                    if (iVar.f39798e) {
                        valueOf = getStringFromFile(iVar);
                        break;
                    } else {
                        valueOf = iVar.f39795b;
                        break;
                    }
                case 7:
                    c.a aVar = (c.a) value;
                    if (aVar.f39798e) {
                        valueOf = getArrayFromFile(aVar);
                        break;
                    } else {
                        valueOf = aVar.f39795b;
                        break;
                    }
                case 8:
                    c.h hVar = (c.h) value;
                    if (hVar.f39798e) {
                        valueOf = getObjectFromFile(hVar);
                        break;
                    } else {
                        valueOf = ((c.h) value).f39795b;
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
        return getDouble(str, 0.0d);
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized long getLong(String str) {
        c.g gVar;
        gVar = (c.g) this.data.get(str);
        return gVar == null ? 0L : gVar.f39794b;
    }

    public synchronized <T> T getObject(String str) {
        c.h hVar = (c.h) this.data.get(str);
        if (hVar != null) {
            return hVar.f39798e ? (T) getObjectFromFile(hVar) : (T) hVar.f39795b;
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
            addOrUpdate(str, bArr, bArr, (c.a) this.data.get(str), (byte) 7);
        }
    }

    public synchronized void putBoolean(String str, boolean z3) {
        checkKey(str);
        c.C0744c c0744c = (c.C0744c) this.data.get(str);
        if (c0744c == null) {
            wrapHeader(str, (byte) 1);
            j jVar = this.fastBuffer;
            int i4 = jVar.f39858b;
            jVar.a((byte) (z3 ? 1 : 0));
            updateChange();
            this.data.put(str, new c.C0744c(i4, z3));
            checkIfCommit();
        } else if (c0744c.f39790b != z3) {
            c0744c.f39790b = z3;
            updateBoolean((byte) (z3 ? 1 : 0), c0744c.f39789a);
            checkIfCommit();
        }
    }

    public synchronized void putDouble(String str, double d4) {
        checkKey(str);
        c.d dVar = (c.d) this.data.get(str);
        if (dVar == null) {
            wrapHeader(str, (byte) 5);
            j jVar = this.fastBuffer;
            int i4 = jVar.f39858b;
            jVar.a(Double.doubleToRawLongBits(d4));
            updateChange();
            this.data.put(str, new c.d(i4, d4));
            checkIfCommit();
        } else if (dVar.f39791b != d4) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d4);
            dVar.f39791b = d4;
            updateInt64(doubleToRawLongBits, Double.doubleToRawLongBits(dVar.f39791b) ^ doubleToRawLongBits, dVar.f39789a);
            checkIfCommit();
        }
    }

    public synchronized void putFloat(String str, float f4) {
        checkKey(str);
        c.e eVar = (c.e) this.data.get(str);
        if (eVar == null) {
            wrapHeader(str, (byte) 3);
            j jVar = this.fastBuffer;
            int i4 = jVar.f39858b;
            jVar.a(Float.floatToRawIntBits(f4));
            updateChange();
            this.data.put(str, new c.e(i4, f4));
            checkIfCommit();
        } else if (eVar.f39792b != f4) {
            int floatToRawIntBits = Float.floatToRawIntBits(f4);
            eVar.f39792b = f4;
            updateInt32(floatToRawIntBits, (Float.floatToRawIntBits(eVar.f39792b) ^ floatToRawIntBits) & 4294967295L, eVar.f39789a);
            checkIfCommit();
        }
    }

    public synchronized void putInt(String str, int i4) {
        checkKey(str);
        c.f fVar = (c.f) this.data.get(str);
        if (fVar == null) {
            wrapHeader(str, (byte) 2);
            j jVar = this.fastBuffer;
            int i5 = jVar.f39858b;
            jVar.a(i4);
            updateChange();
            this.data.put(str, new c.f(i5, i4));
            checkIfCommit();
        } else {
            int i6 = fVar.f39793b;
            if (i6 != i4) {
                fVar.f39793b = i4;
                updateInt32(i4, (i6 ^ i4) & 4294967295L, fVar.f39789a);
                checkIfCommit();
            }
        }
    }

    public synchronized void putLong(String str, long j4) {
        checkKey(str);
        c.g gVar = (c.g) this.data.get(str);
        if (gVar == null) {
            wrapHeader(str, (byte) 4);
            j jVar = this.fastBuffer;
            int i4 = jVar.f39858b;
            jVar.a(j4);
            updateChange();
            this.data.put(str, new c.g(i4, j4));
            checkIfCommit();
        } else {
            long j5 = gVar.f39794b;
            if (j5 != j4) {
                gVar.f39794b = j4;
                updateInt64(j4, j4 ^ j5, gVar.f39789a);
                checkIfCommit();
            }
        }
    }

    public synchronized <T> void putObject(String str, T t3, a<T> aVar) {
        checkKey(str);
        if (aVar != null) {
            String a4 = aVar.a();
            if (a4 != null && !a4.isEmpty() && a4.length() <= 50) {
                if (!this.encoderMap.containsKey(a4)) {
                    throw new IllegalArgumentException("Encoder hasn't been registered");
                }
                if (t3 == null) {
                    remove(str);
                    return;
                }
                byte[] bArr = null;
                try {
                    bArr = aVar.a(t3);
                } catch (Exception e4) {
                    error(e4);
                }
                if (bArr == null) {
                    remove(str);
                    return;
                }
                int b4 = j.b(a4);
                j jVar = new j(b4 + 1 + bArr.length);
                jVar.a((byte) b4);
                jVar.a(a4);
                jVar.a(bArr);
                addOrUpdate(str, t3, jVar.f39857a, (c.h) this.data.get(str), (byte) 8);
                return;
            }
            throw new IllegalArgumentException("Invalid encoder tag:" + a4);
        }
        throw new IllegalArgumentException("Encoder is null");
    }

    public synchronized void putString(String str, String str2) {
        byte[] bytes;
        checkKey(str);
        if (str2 == null) {
            remove(str);
        } else {
            c.i iVar = (c.i) this.data.get(str);
            if (str2.length() * 3 < 2048) {
                fastPutString(str, str2, iVar);
            } else {
                if (Build.VERSION.SDK_INT >= 19) {
                    bytes = str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes(StandardCharsets.UTF_8);
                } else {
                    bytes = str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes();
                }
                addOrUpdate(str, str2, bytes, iVar, (byte) 6);
            }
        }
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            putObject(str, set, af.f39768a);
        }
    }

    public synchronized void remove(String str) {
        c.b bVar = this.data.get(str);
        if (bVar != null) {
            this.data.remove(str);
            byte a4 = bVar.a();
            String str2 = null;
            if (a4 <= 5) {
                int b4 = j.b(str);
                int i4 = bVar.f39789a;
                remove(a4, i4 - (b4 + 2), i4 + TYPE_SIZE[a4]);
            } else {
                c.j jVar = (c.j) bVar;
                remove(a4, jVar.f39796c, jVar.f39789a + jVar.f39797d);
                if (jVar.f39798e) {
                    str2 = (String) jVar.f39795b;
                }
            }
            byte b5 = (byte) (a4 | Byte.MIN_VALUE);
            if (this.writingMode == 0) {
                this.aBuffer.putLong(4, this.checksum);
                this.aBuffer.put(this.removeStart, b5);
                this.bBuffer.putLong(4, this.checksum);
                this.bBuffer.put(this.removeStart, b5);
            } else {
                this.fastBuffer.a(4, this.checksum);
            }
            this.removeStart = 0;
            if (str2 != null) {
                aj.c(new File(this.path + this.name, str2));
            }
            checkGC();
            checkIfCommit();
        }
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }

    private void wrapHeader(String str, byte b4, int i4) {
        int b5 = j.b(str);
        checkKeySize(b5);
        this.updateSize = b5 + 2 + i4;
        preparePutBytes();
        this.fastBuffer.a(b4);
        putKey(str, b5);
    }

    public synchronized byte[] getArray(String str, byte[] bArr) {
        c.a aVar = (c.a) this.data.get(str);
        if (aVar != null) {
            return aVar.f39798e ? getArrayFromFile(aVar) : (byte[]) aVar.f39795b;
        }
        return bArr;
    }

    public synchronized boolean getBoolean(String str, boolean z3) {
        c.C0744c c0744c = (c.C0744c) this.data.get(str);
        if (c0744c != null) {
            z3 = c0744c.f39790b;
        }
        return z3;
    }

    public synchronized double getDouble(String str, double d4) {
        c.d dVar = (c.d) this.data.get(str);
        if (dVar != null) {
            d4 = dVar.f39791b;
        }
        return d4;
    }

    public synchronized float getFloat(String str, float f4) {
        c.e eVar = (c.e) this.data.get(str);
        if (eVar != null) {
            f4 = eVar.f39792b;
        }
        return f4;
    }

    public synchronized int getInt(String str, int i4) {
        c.f fVar = (c.f) this.data.get(str);
        if (fVar != null) {
            i4 = fVar.f39793b;
        }
        return i4;
    }

    public synchronized String getString(String str, String str2) {
        c.i iVar = (c.i) this.data.get(str);
        if (iVar != null) {
            return iVar.f39798e ? getStringFromFile(iVar) : (String) iVar.f39795b;
        }
        return str2;
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, a> map2) {
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
                    a aVar = map2.get(value.getClass());
                    if (aVar != null) {
                        putObject(key, value, aVar);
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
        b bVar = this.logger;
        if (bVar != null) {
            bVar.b(this.name, exc);
        }
    }

    public synchronized long getLong(String str, long j4) {
        c.g gVar = (c.g) this.data.get(str);
        if (gVar != null) {
            j4 = gVar.f39794b;
        }
        return j4;
    }

    private void remove(byte b4, int i4, int i5) {
        countInvalid(i4, i5);
        byte b5 = (byte) (b4 | Byte.MIN_VALUE);
        byte[] bArr = this.fastBuffer.f39857a;
        this.checksum = (((bArr[i4] ^ b5) & 255) << ((i4 & 7) << 3)) ^ this.checksum;
        bArr[i4] = b5;
        this.removeStart = i4;
    }
}
