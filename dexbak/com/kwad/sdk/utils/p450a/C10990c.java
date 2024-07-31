package com.kwad.sdk.utils.p450a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.p354a.C9585a;
import com.kwad.sdk.utils.p450a.C10978a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.UByte;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.kwad.sdk.utils.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10990c {
    private static final int PAGE_SIZE;
    private static final int[] aRp = {0, 1, 4, 4, 8, 8};
    private static final byte[] aRq = new byte[0];
    private static final int aRr;
    private static final int aRs;
    private static final int aRt;

    /* renamed from: VM */
    private final String f29673VM;
    private MappedByteBuffer aRA;
    private MappedByteBuffer aRB;
    private C10989b aRC;
    private int aRD;
    private long aRE;
    private int aRH;
    private int aRI;
    private int aRJ;
    private boolean aRK;
    private String aRL;
    private int aRM;
    private int aRO;
    private final Map<String, InterfaceC10994b> aRu;
    private FileChannel aRw;
    private FileChannel aRx;
    private RandomAccessFile aRy;
    private RandomAccessFile aRz;
    private final String name;
    private final InterfaceC10996d aRv = C10998d.aRZ;
    private final Map<String, C10978a.AbstractC10980b> aRF = new HashMap();
    private boolean aRG = false;
    private final ArrayList<C10997e> aRN = new ArrayList<>();
    private boolean aRP = true;
    private final Executor aRQ = new ExecutorC11001f();

    /* renamed from: com.kwad.sdk.utils.a.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10993a {
        static int aRS = 11;
        static final C10995c aRT = new C10995c(11);

        /* renamed from: VM */
        private final String f29674VM;
        private int aRO = 0;
        private InterfaceC10994b[] aRU;
        private final String name;

        public C10993a(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    if (!str.endsWith("/")) {
                        str = str + '/';
                    }
                    this.f29674VM = str;
                    this.name = str2;
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("path is empty");
        }

        /* renamed from: NM */
        public final C10990c m24183NM() {
            String str = this.f29674VM + this.name;
            C10990c m24180hj = C10995c.m24180hj(str);
            if (m24180hj == null) {
                synchronized (C10993a.class) {
                    m24180hj = C10995c.m24180hj(str);
                    if (m24180hj == null) {
                        m24180hj = new C10990c(this.f29674VM, this.name, this.aRU, this.aRO);
                        C10995c.m24182b(str, m24180hj);
                    }
                }
            }
            Integer num = C10995c.aRY.get(str);
            if (num != null) {
                C10995c.aRY.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C10995c.aRY.put(str, 1);
            }
            return m24180hj;
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10994b<T> {
        /* renamed from: NN */
        String mo24170NN();

        /* renamed from: g */
        T mo24168g(byte[] bArr, int i, int i2);

        /* renamed from: m */
        byte[] mo24166m(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.utils.a.c$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10995c {
        private static Map<String, C10990c> aRV;
        private static List<String> aRW;
        private static int aRX;
        public static Map<String, Integer> aRY;

        public C10995c(int i) {
            int size = getSize(i);
            aRV = new ConcurrentHashMap(size);
            aRY = new HashMap(size);
            aRW = new CopyOnWriteArrayList();
            aRX = i;
        }

        /* renamed from: b */
        public static void m24182b(String str, C10990c c10990c) {
            if (aRV == null) {
                aRV = new ConcurrentHashMap(getSize(aRX));
            }
            if (aRW == null) {
                aRW = new CopyOnWriteArrayList();
            }
            if (aRV.containsKey(str)) {
                aRW.remove(str);
                aRW.add(str);
            } else {
                aRW.add(str);
            }
            aRV.put(str, c10990c);
            if (aRV.size() > aRX) {
                Integer num = aRY.get(aRW.get(0));
                if (num != null && num.intValue() != 2) {
                    m24181ep(aRX + 1);
                    return;
                }
                C10990c c10990c2 = aRV.get(aRW.get(0));
                if (c10990c2 != null) {
                    c10990c2.release();
                }
                aRV.remove(aRW.get(0));
                aRW.remove(0);
            }
        }

        /* renamed from: ep */
        private static void m24181ep(int i) {
            InterfaceC10996d interfaceC10996d = C10998d.aRZ;
            interfaceC10996d.mo24173i("Ks_UnionKv", "reSize:" + i);
            aRX = i;
        }

        private static int getSize(int i) {
            return (int) ((i / 0.75f) + 1.0f);
        }

        /* renamed from: hj */
        public static C10990c m24180hj(String str) {
            if (aRV == null) {
                aRV = new ConcurrentHashMap(getSize(aRX));
            }
            if (aRW == null) {
                aRW = new CopyOnWriteArrayList();
            }
            C10990c c10990c = aRV.get(str);
            if (c10990c != null) {
                aRW.remove(str);
                aRW.add(str);
                return c10990c;
            }
            return null;
        }

        public static void remove(String str) {
            List<String> list = aRW;
            if (list != null) {
                list.remove(str);
            }
            Map<String, C10990c> map = aRV;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    /* renamed from: com.kwad.sdk.utils.a.c$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10996d {
        /* renamed from: a */
        void mo24175a(String str, Exception exc);

        /* renamed from: e */
        void mo24174e(String str, Throwable th);

        /* renamed from: i */
        void mo24173i(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.utils.a.c$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10997e implements Comparable<C10997e> {
        int end;
        int start;

        C10997e(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C10997e c10997e) {
            return this.start - c10997e.start;
        }
    }

    static {
        int m24164NQ = C11004h.m24164NQ();
        PAGE_SIZE = m24164NQ;
        aRr = m24164NQ - 192;
        int max = Math.max(m24164NQ << 1, 16384);
        aRs = max;
        aRt = max << 1;
    }

    C10990c(String str, String str2, InterfaceC10994b[] interfaceC10994bArr, int i) {
        this.f29673VM = str;
        this.name = str2;
        this.aRO = i;
        HashMap hashMap = new HashMap();
        C11003g c11003g = C11003g.aSg;
        hashMap.put(c11003g.mo24170NN(), c11003g);
        if (interfaceC10994bArr != null && interfaceC10994bArr.length > 0) {
            for (InterfaceC10994b interfaceC10994b : interfaceC10994bArr) {
                String mo24170NN = interfaceC10994b.mo24170NN();
                if (hashMap.containsKey(mo24170NN)) {
                    m24187hi("duplicate encoder tag:" + mo24170NN);
                } else {
                    hashMap.put(mo24170NN, interfaceC10994b);
                }
            }
        }
        this.aRu = hashMap;
        synchronized (this.aRF) {
            C10998d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    C10990c.this.m24229Nu();
                }
            });
            while (!this.aRG) {
                try {
                    this.aRF.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* renamed from: E */
    private int m24243E(int i, int i2) {
        if (i2 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (!C9585a.f29487md.booleanValue()) {
                m24185u(illegalStateException);
            } else {
                throw illegalStateException;
            }
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = aRs;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    /* renamed from: F */
    private void m24242F(int i, int i2) {
        this.aRM += i2 - i;
        ArrayList<C10997e> arrayList = this.aRN;
        if (arrayList != null) {
            arrayList.add(new C10997e(i, i2));
        }
    }

    /* renamed from: NA */
    private boolean m24241NA() {
        int i = this.aRO;
        if (i == 1) {
            Executor executor = this.aRQ;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C10990c.this.m24240NB();
                    }
                });
            }
        } else if (i == 2) {
            return m24240NB();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NB */
    public synchronized boolean m24240NB() {
        try {
            String str = this.f29673VM;
            File file = new File(str, this.name + ".tmp");
            if (C11004h.m24161ae(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.aRD);
                randomAccessFile.write(this.aRC.aRo, 0, this.aRD);
                randomAccessFile.close();
                String str2 = this.f29673VM;
                File file2 = new File(str2, this.name + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    m24190g(new Exception("rename failed"));
                }
            }
        } catch (Exception e) {
            m24185u(e);
        }
        return false;
    }

    /* renamed from: NC */
    private void m24239NC() {
        try {
            String str = this.f29673VM;
            C11004h.m24158h(new File(str, this.name + ".kvc"));
            String str2 = this.f29673VM;
            C11004h.m24158h(new File(str2, this.name + ".tmp"));
        } catch (Exception e) {
            m24185u(e);
        }
    }

    /* renamed from: ND */
    private void m24238ND() {
        this.aRO = 1;
        C11004h.closeQuietly(this.aRw);
        C11004h.closeQuietly(this.aRx);
        this.aRw = null;
        this.aRx = null;
        this.aRA = null;
        this.aRB = null;
    }

    /* renamed from: NE */
    private void m24237NE() {
        if (this.aRO == 0) {
            try {
                m24205a(this.aRA);
                m24205a(this.aRB);
            } catch (Throwable unused) {
                m24238ND();
            }
        }
        m24236NF();
        C11004h.m24158h(new File(this.f29673VM + this.name));
    }

    /* renamed from: NF */
    private void m24236NF() {
        this.aRD = 12;
        this.aRE = 0L;
        m24230NL();
        this.aRF.clear();
        C10989b c10989b = this.aRC;
        if (c10989b != null && c10989b.aRo.length == PAGE_SIZE) {
            c10989b.m24264B(0, 0);
            this.aRC.m24250f(4, 0L);
            return;
        }
        this.aRC = new C10989b(PAGE_SIZE);
    }

    /* renamed from: NG */
    private void m24235NG() {
        C10989b c10989b;
        C10989b c10989b2 = this.aRC;
        if (c10989b2 != null) {
            this.aRE ^= c10989b2.m24262D(this.aRH, this.aRI);
        }
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                m24197b(this.aRA);
                this.aRA.putInt(0, this.aRD - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                m24197b(mappedByteBuffer2);
            }
        } else {
            if (this.aRK && (c10989b = this.aRC) != null) {
                c10989b.m24264B(0, this.aRD - 12);
            }
            C10989b c10989b3 = this.aRC;
            if (c10989b3 != null) {
                c10989b3.m24250f(4, this.aRE);
            }
        }
        this.aRK = false;
        this.aRJ = 0;
        this.aRI = 0;
    }

    /* renamed from: NH */
    private int m24234NH() {
        int i = this.aRD;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    /* renamed from: NI */
    private void m24233NI() {
        m24193em(this.aRI);
        int i = this.aRD;
        this.aRH = i;
        this.aRD = this.aRI + i;
        C10989b c10989b = this.aRC;
        if (c10989b != null) {
            c10989b.position = i;
        }
        this.aRK = true;
    }

    /* renamed from: NJ */
    private void m24232NJ() {
        if (this.aRM < (m24234NH() << 1)) {
            if (this.aRN.size() < (this.aRD < 16384 ? 80 : 160)) {
                return;
            }
        }
        m24192en(0);
    }

    /* renamed from: NK */
    private void m24231NK() {
        ArrayList<C10997e> arrayList = this.aRN;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        C10997e c10997e = this.aRN.get(size);
        while (size > 0) {
            size--;
            C10997e c10997e2 = this.aRN.get(size);
            if (c10997e.start == c10997e2.end) {
                c10997e2.end = c10997e.end;
                this.aRN.remove(size + 1);
            }
            c10997e = c10997e2;
        }
    }

    /* renamed from: NL */
    private void m24230NL() {
        this.aRM = 0;
        ArrayList<C10997e> arrayList = this.aRN;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Nu */
    public synchronized void m24229Nu() {
        synchronized (this.aRF) {
            this.aRG = true;
            this.aRF.notify();
        }
        long nanoTime = System.nanoTime();
        if (!m24226Nx() && this.aRO == 0) {
            m24228Nv();
        }
        if (this.aRC == null) {
            this.aRC = new C10989b(PAGE_SIZE);
        }
        if (this.aRv != null) {
            info("loading finish, data len:" + this.aRD + ", get keys:" + this.aRF.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a4 A[Catch: all -> 0x01c6, TryCatch #0 {all -> 0x01c6, blocks: (B:3:0x0038, B:5:0x003e, B:8:0x0046, B:9:0x0070, B:13:0x0081, B:17:0x009e, B:18:0x00a9, B:22:0x00c0, B:23:0x00c4, B:25:0x00e1, B:27:0x00e8, B:29:0x010a, B:31:0x0110, B:37:0x011d, B:39:0x0123, B:41:0x013a, B:43:0x0142, B:45:0x015b, B:46:0x0168, B:48:0x0184, B:50:0x018a, B:53:0x01a4, B:16:0x0099, B:12:0x007e, B:56:0x01ae, B:58:0x01b8), top: B:63:0x0038, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* renamed from: Nv */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m24228Nv() {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.p450a.C10990c.m24228Nv():void");
    }

    /* renamed from: Nw */
    private boolean m24227Nw() {
        C10989b c10989b = new C10989b(this.aRD);
        MappedByteBuffer mappedByteBuffer = this.aRB;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.aRB.get(c10989b.aRo, 0, this.aRD);
        }
        C10989b c10989b2 = this.aRC;
        if (c10989b2 != null) {
            byte[] bArr = c10989b2.aRo;
            byte[] bArr2 = c10989b.aRo;
            for (int i = 0; i < this.aRD; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    /* renamed from: Nx */
    private boolean m24226Nx() {
        String str = this.f29673VM;
        File file = new File(str, this.name + ".kvc");
        String str2 = this.f29673VM;
        File file2 = new File(str2, this.name + ".tmp");
        boolean z = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (m24202ad(file)) {
                    if (this.aRO == 0) {
                        if (m24216a(this.aRC)) {
                            info("recover from c file");
                            try {
                                m24239NC();
                                return true;
                            } catch (Exception e) {
                                e = e;
                                m24185u(e);
                                return z;
                            }
                        }
                        this.aRO = 1;
                    }
                } else {
                    m24236NF();
                    m24239NC();
                }
            } else if (this.aRO != 0) {
                String str3 = this.f29673VM;
                File file3 = new File(str3, this.name + ".kva");
                String str4 = this.f29673VM;
                File file4 = new File(str4, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    m24189h(file3, file4);
                }
            }
            return false;
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x016f, code lost:
        throw new java.lang.Exception("parse dara failed");
     */
    /* renamed from: Ny */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m24225Ny() {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.p450a.C10990c.m24225Ny():int");
    }

    /* renamed from: Nz */
    private void m24224Nz() {
        if (this.aRO == 0 || !this.aRP) {
            return;
        }
        m24241NA();
    }

    /* renamed from: ad */
    private boolean m24202ad(File file) {
        long length = file.length();
        if (length != 0 && length <= IjkMediaMeta.AV_CH_STEREO_LEFT) {
            int i = (int) length;
            int m24243E = m24243E(PAGE_SIZE, i);
            C10989b c10989b = this.aRC;
            if (c10989b != null && c10989b.aRo.length == m24243E) {
                c10989b.position = 0;
            } else {
                c10989b = new C10989b(new byte[m24243E]);
                this.aRC = c10989b;
            }
            C11004h.m24162a(file, c10989b.aRo, i);
            int i2 = c10989b.getInt();
            long j = c10989b.getLong();
            this.aRD = i2 + 12;
            if (i2 >= 0 && i2 <= i - 12 && j == c10989b.m24262D(12, i2) && m24225Ny() == 0) {
                this.aRE = j;
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private static long m24195e(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    /* renamed from: e */
    private static void m24196e(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    /* renamed from: el */
    private static void m24194el(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    /* renamed from: em */
    private void m24193em(int i) {
        if (this.aRC == null) {
            this.aRC = new C10989b(PAGE_SIZE);
        }
        int length = this.aRC.aRo.length;
        int i2 = this.aRD + i;
        if (i2 >= length) {
            int i3 = this.aRM;
            if (i3 > i && i3 > m24234NH()) {
                m24192en(i);
                return;
            }
            int m24243E = m24243E(length, i2);
            byte[] bArr = new byte[m24243E];
            System.arraycopy(this.aRC.aRo, 0, bArr, 0, this.aRD);
            this.aRC.aRo = bArr;
            if (this.aRO == 0) {
                try {
                    long j = m24243E;
                    MappedByteBuffer map = this.aRw.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aRA = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.aRx.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aRB = map2;
                    map2.order(byteOrder);
                } catch (Throwable th) {
                    m24185u(new Exception("map failed", th));
                    this.aRC.m24264B(0, this.aRD - 12);
                    this.aRC.m24250f(4, this.aRE);
                    m24238ND();
                }
            }
        }
    }

    /* renamed from: en */
    private void m24192en(int i) {
        int i2;
        ArrayList<C10997e> arrayList = this.aRN;
        if (arrayList == null || this.aRC == null) {
            return;
        }
        Collections.sort(arrayList);
        m24231NK();
        C10997e c10997e = this.aRN.get(0);
        int i3 = c10997e.start;
        int i4 = this.aRD;
        int i5 = i4 - this.aRM;
        int i6 = i5 - 12;
        int i7 = i5 - i3;
        int i8 = i4 - i3;
        boolean z = i6 < i8 + i7;
        if (!z) {
            this.aRE ^= this.aRC.m24262D(i3, i8);
        }
        int size = this.aRN.size();
        int i9 = size - 1;
        int i10 = this.aRD - this.aRN.get(i9).end;
        int[] iArr = new int[(i10 > 0 ? size : i9) << 1];
        int i11 = c10997e.start;
        int i12 = c10997e.end;
        for (int i13 = 1; i13 < size; i13++) {
            C10997e c10997e2 = this.aRN.get(i13);
            int i14 = c10997e2.start - i12;
            byte[] bArr = this.aRC.aRo;
            System.arraycopy(bArr, i12, bArr, i11, i14);
            int i15 = (i13 - 1) << 1;
            iArr[i15] = i12;
            iArr[i15 + 1] = i12 - i11;
            i11 += i14;
            i12 = c10997e2.end;
        }
        if (i10 > 0) {
            byte[] bArr2 = this.aRC.aRo;
            System.arraycopy(bArr2, i12, bArr2, i11, i10);
            int i16 = i9 << 1;
            iArr[i16] = i12;
            iArr[i16 + 1] = i12 - i11;
        }
        m24230NL();
        if (z) {
            this.aRE = this.aRC.m24262D(12, i6);
        } else {
            this.aRE ^= this.aRC.m24262D(i3, i7);
        }
        this.aRD = i5;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                i2 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.aRA.putLong(4, this.aRE);
                this.aRA.position(i3);
                this.aRA.put(this.aRC.aRo, i3, i7);
                this.aRA.putInt(0, i6);
            } else {
                i2 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i2, i6);
                this.aRB.putLong(4, this.aRE);
                this.aRB.position(i3);
                this.aRB.put(this.aRC.aRo, i3, i7);
            }
        } else {
            this.aRC.m24264B(0, i6);
            this.aRC.m24250f(4, this.aRE);
        }
        m24220a(i3, iArr);
        int i17 = i5 + i;
        if (this.aRC.aRo.length - i17 > aRt) {
            m24191eo(i17);
        }
        info("gc finish");
    }

    /* renamed from: eo */
    private void m24191eo(int i) {
        int i2 = PAGE_SIZE;
        int m24243E = m24243E(i2, i + i2);
        C10989b c10989b = this.aRC;
        if (c10989b != null) {
            byte[] bArr = c10989b.aRo;
            if (m24243E >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[m24243E];
            System.arraycopy(bArr, 0, bArr2, 0, this.aRD);
            this.aRC.aRo = bArr2;
        }
        if (this.aRO == 0) {
            try {
                long j = m24243E;
                this.aRw.truncate(j);
                MappedByteBuffer map = this.aRw.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aRA = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.aRx.truncate(j);
                MappedByteBuffer map2 = this.aRx.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aRB = map2;
                map2.order(byteOrder);
            } catch (Throwable th) {
                m24185u(new Exception("map failed", th));
                m24238ND();
            }
        }
        info("truncate finish");
    }

    /* renamed from: g */
    private void m24190g(Exception exc) {
        InterfaceC10996d interfaceC10996d = this.aRv;
        if (interfaceC10996d != null) {
            interfaceC10996d.mo24175a(this.name, exc);
        }
    }

    /* renamed from: h */
    private void m24189h(File file, File file2) {
        try {
            if (m24202ad(file)) {
                return;
            }
        } catch (IOException e) {
            m24190g(e);
        }
        m24236NF();
        try {
            if (m24202ad(file2)) {
                return;
            }
        } catch (Exception e2) {
            m24190g(e2);
        }
        m24236NF();
    }

    /* renamed from: hh */
    private static void m24188hh(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    /* renamed from: hi */
    private void m24187hi(String str) {
        InterfaceC10996d interfaceC10996d = this.aRv;
        if (interfaceC10996d != null) {
            interfaceC10996d.mo24174e(this.name, new Exception(str));
        }
    }

    private void info(String str) {
        InterfaceC10996d interfaceC10996d = this.aRv;
        if (interfaceC10996d != null) {
            interfaceC10996d.mo24173i(this.name, str);
        }
    }

    private synchronized void putDouble(String str, double d) {
        m24188hh(str);
        C10978a.C10982d c10982d = (C10978a.C10982d) this.aRF.get(str);
        if (c10982d == null) {
            m24214a(str, (byte) 5);
            C10989b c10989b = this.aRC;
            if (c10989b != null) {
                int i = c10989b.position;
                c10989b.m24259aH(Double.doubleToRawLongBits(d));
                m24235NG();
                Map<String, C10978a.AbstractC10980b> map = this.aRF;
                if (map != null) {
                    map.put(str, new C10978a.C10982d(i, d));
                }
            }
            m24224Nz();
            return;
        }
        if (c10982d.value != d) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d);
            c10982d.value = d;
            m24201b(doubleToRawLongBits, Double.doubleToRawLongBits(c10982d.value) ^ doubleToRawLongBits, c10982d.offset);
            m24224Nz();
        }
    }

    private synchronized void putFloat(String str, float f) {
        m24188hh(str);
        C10978a.C10983e c10983e = (C10978a.C10983e) this.aRF.get(str);
        if (c10983e == null) {
            m24214a(str, (byte) 3);
            C10989b c10989b = this.aRC;
            if (c10989b != null) {
                int i = c10989b.position;
                c10989b.m24257ee(Float.floatToRawIntBits(f));
                m24235NG();
                Map<String, C10978a.AbstractC10980b> map = this.aRF;
                if (map != null) {
                    map.put(str, new C10978a.C10983e(i, f));
                }
            }
            m24224Nz();
            return;
        }
        if (c10983e.value != f) {
            int floatToRawIntBits = Float.floatToRawIntBits(f);
            c10983e.value = f;
            m24221a(floatToRawIntBits, (Float.floatToRawIntBits(c10983e.value) ^ floatToRawIntBits) & 4294967295L, c10983e.offset);
            m24224Nz();
        }
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            m24211a(str, (String) set, (InterfaceC10994b<String>) C11003g.aSg);
        }
    }

    /* renamed from: u */
    private void m24186u(String str, int i) {
        C10989b c10989b = this.aRC;
        if (c10989b == null) {
            return;
        }
        c10989b.m24258e((byte) i);
        if (i == str.length()) {
            C10989b c10989b2 = this.aRC;
            m24212a(str, 0, i, c10989b2.aRo, c10989b2.position);
            this.aRC.position += i;
            return;
        }
        this.aRC.m24249hd(str);
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        C10989b c10989b = this.aRC;
        if (c10989b != null) {
            this.aRE ^= c10989b.m24262D(i, length);
            C10989b c10989b2 = this.aRC;
            c10989b2.position = i;
            c10989b2.m24244n(bArr);
            this.aRE ^= this.aRC.m24262D(i, length);
        }
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                this.aRA.putLong(4, this.aRE);
                this.aRA.position(i);
                this.aRA.put(bArr);
                this.aRA.putInt(0, this.aRD - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.position(i);
                this.aRB.put(bArr);
                return;
            }
            return;
        }
        C10989b c10989b3 = this.aRC;
        if (c10989b3 != null) {
            c10989b3.m24250f(4, this.aRE);
        }
    }

    /* renamed from: v */
    private void m24184v(String str, int i) {
        C10989b c10989b = this.aRC;
        if (c10989b == null) {
            return;
        }
        c10989b.m24260a((short) i);
        if (i == str.length()) {
            C10989b c10989b2 = this.aRC;
            m24212a(str, 0, i, c10989b2.aRo, c10989b2.position);
            return;
        }
        this.aRC.m24249hd(str);
    }

    public final synchronized boolean contains(String str) {
        return this.aRF.containsKey(str);
    }

    public final synchronized Map<String, Object> getAll() {
        Object valueOf;
        int size = this.aRF.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, C10978a.AbstractC10980b> entry : this.aRF.entrySet()) {
            String key = entry.getKey();
            C10978a.AbstractC10980b value = entry.getValue();
            Object obj = null;
            switch (value.mo24265Ns()) {
                case 1:
                    valueOf = Boolean.valueOf(((C10978a.C10981c) value).value);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((C10978a.C10984f) value).value);
                    break;
                case 3:
                    valueOf = Float.valueOf(((C10978a.C10983e) value).value);
                    break;
                case 4:
                    valueOf = Long.valueOf(((C10978a.C10985g) value).value);
                    break;
                case 5:
                    valueOf = Double.valueOf(((C10978a.C10982d) value).value);
                    break;
                case 6:
                    C10978a.C10987i c10987i = (C10978a.C10987i) value;
                    if (c10987i.aRm) {
                        valueOf = m24217a(c10987i);
                        break;
                    } else {
                        valueOf = c10987i.value;
                        break;
                    }
                case 7:
                    C10978a.C10979a c10979a = (C10978a.C10979a) value;
                    if (c10979a.aRm) {
                        valueOf = m24219a(c10979a);
                        break;
                    } else {
                        valueOf = c10979a.value;
                        break;
                    }
                case 8:
                    C10978a.C10986h c10986h = (C10978a.C10986h) value;
                    if (c10986h.aRm) {
                        valueOf = m24218a(c10986h);
                        break;
                    } else {
                        valueOf = ((C10978a.C10986h) value).value;
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

    public final synchronized boolean getBoolean(String str, boolean z) {
        C10978a.C10981c c10981c = (C10978a.C10981c) this.aRF.get(str);
        if (c10981c == null) {
            return z;
        }
        return c10981c.value;
    }

    public final synchronized int getInt(String str, int i) {
        C10978a.C10984f c10984f = (C10978a.C10984f) this.aRF.get(str);
        if (c10984f == null) {
            return i;
        }
        return c10984f.value;
    }

    public final synchronized long getLong(String str, long j) {
        C10978a.C10985g c10985g = (C10978a.C10985g) this.aRF.get(str);
        if (c10985g == null) {
            return j;
        }
        return c10985g.value;
    }

    public final synchronized String getString(String str, String str2) {
        C10978a.C10987i c10987i = (C10978a.C10987i) this.aRF.get(str);
        if (c10987i != null) {
            if (c10987i.aRm) {
                return m24217a(c10987i);
            }
            return (String) c10987i.value;
        }
        return str2;
    }

    public final void putAll(Map<String, Object> map) {
        m24203a(map, (Map<Class, InterfaceC10994b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z) {
        m24188hh(str);
        C10978a.C10981c c10981c = (C10978a.C10981c) this.aRF.get(str);
        if (c10981c == null) {
            m24214a(str, (byte) 1);
            C10989b c10989b = this.aRC;
            if (c10989b != null) {
                int i = c10989b.position;
                c10989b.m24258e((byte) (z ? 1 : 0));
                m24235NG();
                Map<String, C10978a.AbstractC10980b> map = this.aRF;
                if (map != null) {
                    map.put(str, new C10978a.C10981c(i, z));
                }
            }
            m24224Nz();
            return;
        }
        if (c10981c.value != z) {
            c10981c.value = z;
            m24223a((byte) (z ? 1 : 0), c10981c.offset);
            m24224Nz();
        }
    }

    public final synchronized void putInt(String str, int i) {
        m24188hh(str);
        C10978a.C10984f c10984f = (C10978a.C10984f) this.aRF.get(str);
        if (c10984f == null) {
            m24214a(str, (byte) 2);
            C10989b c10989b = this.aRC;
            if (c10989b != null) {
                int i2 = c10989b.position;
                c10989b.m24257ee(i);
                m24235NG();
                Map<String, C10978a.AbstractC10980b> map = this.aRF;
                if (map != null) {
                    map.put(str, new C10978a.C10984f(i2, i));
                }
            }
            m24224Nz();
            return;
        }
        int i3 = c10984f.value;
        if (i3 != i) {
            c10984f.value = i;
            m24221a(i, (i3 ^ i) & 4294967295L, c10984f.offset);
            m24224Nz();
        }
    }

    public final synchronized void putLong(String str, long j) {
        m24188hh(str);
        C10978a.C10985g c10985g = (C10978a.C10985g) this.aRF.get(str);
        if (c10985g == null) {
            m24214a(str, (byte) 4);
            C10989b c10989b = this.aRC;
            if (c10989b != null) {
                int i = c10989b.position;
                c10989b.m24259aH(j);
                m24235NG();
                Map<String, C10978a.AbstractC10980b> map = this.aRF;
                if (map != null) {
                    map.put(str, new C10978a.C10985g(i, j));
                }
            }
            m24224Nz();
            return;
        }
        long j2 = c10985g.value;
        if (j2 != j) {
            c10985g.value = j;
            m24201b(j, j ^ j2, c10985g.offset);
            m24224Nz();
        }
    }

    public final synchronized void putString(String str, String str2) {
        byte[] m24246hg;
        byte[] bArr;
        byte[] bArr2;
        m24188hh(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        C10978a.C10987i c10987i = (C10978a.C10987i) this.aRF.get(str);
        if (str2.length() * 3 < 2048) {
            m24207a(str, str2, c10987i);
            return;
        }
        if (str2.isEmpty()) {
            m24246hg = aRq;
        } else {
            if (c10987i == null && str2.length() < 2048) {
                int m24248he = C10989b.m24248he(str2);
                bArr = new byte[m24248he];
                if (m24248he == str2.length()) {
                    m24212a(str2, 0, m24248he, bArr, 0);
                    bArr2 = bArr;
                } else {
                    m24246hg = C10989b.m24246hg(str2);
                }
            } else if (c10987i != null && !c10987i.aRm) {
                int m24248he2 = C10989b.m24248he(str2);
                bArr = new byte[m24248he2];
                if (m24248he2 == str2.length()) {
                    m24212a(str2, 0, m24248he2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    m24246hg = C10989b.m24246hg(str2);
                }
            } else {
                m24246hg = C10989b.m24246hg(str2);
            }
            m24208a(str, str2, bArr2, c10987i, (byte) 6);
        }
        bArr2 = m24246hg;
        m24208a(str, str2, bArr2, c10987i, (byte) 6);
    }

    public final void release() {
        C11004h.closeQuietly(this.aRy);
        C11004h.closeQuietly(this.aRz);
        C11004h.closeQuietly(this.aRw);
        C11004h.closeQuietly(this.aRx);
        this.aRw = null;
        this.aRx = null;
        this.aRA = null;
        this.aRB = null;
        C10995c c10995c = C10993a.aRT;
        C10995c.remove(this.f29673VM + this.name);
    }

    public final synchronized void remove(String str) {
        C10978a.AbstractC10980b abstractC10980b = this.aRF.get(str);
        if (abstractC10980b != null) {
            this.aRF.remove(str);
            byte mo24265Ns = abstractC10980b.mo24265Ns();
            String str2 = null;
            if (mo24265Ns <= 5) {
                int m24248he = C10989b.m24248he(str);
                int i = abstractC10980b.offset;
                m24222a(mo24265Ns, i - (m24248he + 2), i + aRp[mo24265Ns]);
            } else {
                C10978a.AbstractC10988j abstractC10988j = (C10978a.AbstractC10988j) abstractC10980b;
                m24222a(mo24265Ns, abstractC10988j.start, abstractC10988j.offset + abstractC10988j.aRl);
                if (abstractC10988j.aRm) {
                    str2 = (String) abstractC10988j.value;
                }
            }
            byte b = (byte) (mo24265Ns | Byte.MIN_VALUE);
            if (this.aRO == 0) {
                MappedByteBuffer mappedByteBuffer = this.aRA;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.putLong(4, this.aRE);
                    this.aRA.put(this.aRJ, b);
                }
                MappedByteBuffer mappedByteBuffer2 = this.aRB;
                if (mappedByteBuffer2 != null) {
                    mappedByteBuffer2.putLong(4, this.aRE);
                    this.aRB.put(this.aRJ, b);
                }
            } else {
                C10989b c10989b = this.aRC;
                if (c10989b != null) {
                    c10989b.m24250f(4, this.aRE);
                }
            }
            this.aRJ = 0;
            if (str2 != null) {
                C11004h.m24158h(new File(this.f29673VM + this.name, str2));
            }
            m24232NJ();
            m24224Nz();
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.f29673VM + " name:" + this.name;
    }

    /* renamed from: a */
    private boolean m24216a(C10989b c10989b) {
        int length = c10989b.aRo.length;
        File file = new File(this.f29673VM, this.name + ".kva");
        File file2 = new File(this.f29673VM, this.name + ".kvb");
        try {
            if (C11004h.m24161ae(file) && C11004h.m24161ae(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j = length;
                randomAccessFile.setLength(j);
                randomAccessFile2.setLength(j);
                this.aRw = randomAccessFile.getChannel();
                this.aRx = randomAccessFile2.getChannel();
                MappedByteBuffer map = this.aRw.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aRA = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                MappedByteBuffer map2 = this.aRx.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aRB = map2;
                map2.order(byteOrder);
                this.aRA.put(c10989b.aRo, 0, this.aRD);
                this.aRB.put(c10989b.aRo, 0, this.aRD);
                return true;
            }
            throw new Exception("open file failed");
        } catch (Exception e) {
            m24185u(e);
            return false;
        }
    }

    /* renamed from: b */
    private synchronized void m24199b(String str, byte[] bArr) {
        m24188hh(str);
        if (bArr == null) {
            remove(str);
        } else {
            m24208a(str, bArr, bArr, (C10978a.C10979a) this.aRF.get(str), (byte) 7);
        }
    }

    /* renamed from: b */
    private void m24197b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.aRK && mappedByteBuffer != this.aRA) {
            mappedByteBuffer.putInt(0, this.aRD - 12);
        }
        mappedByteBuffer.putLong(4, this.aRE);
        int i = this.aRJ;
        if (i != 0) {
            mappedByteBuffer.put(i, this.aRC.aRo[i]);
        }
        if (this.aRI != 0) {
            mappedByteBuffer.position(this.aRH);
            mappedByteBuffer.put(this.aRC.aRo, this.aRH, this.aRI);
        }
    }

    /* renamed from: u */
    private void m24185u(Throwable th) {
        InterfaceC10996d interfaceC10996d = this.aRv;
        if (interfaceC10996d != null) {
            interfaceC10996d.mo24174e(this.name, th);
        }
    }

    /* renamed from: b */
    private void m24201b(long j, long j2, int i) {
        long m24195e = m24195e(j2, i) ^ this.aRE;
        this.aRE = m24195e;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, m24195e);
                this.aRA.putLong(i, j);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.putLong(i, j);
            }
        } else {
            C10989b c10989b = this.aRC;
            if (c10989b != null) {
                c10989b.m24250f(4, m24195e);
            }
        }
        C10989b c10989b2 = this.aRC;
        if (c10989b2 != null) {
            c10989b2.m24250f(i, j);
        }
    }

    /* renamed from: a */
    private void m24204a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.aRB ? this.aRx : this.aRw).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.aRB) {
                    this.aRB = map;
                } else {
                    this.aRA = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e) {
                m24185u(e);
                m24238ND();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    /* renamed from: b */
    private int m24198b(String str, byte[] bArr, byte b) {
        m24213a(str, b, bArr.length + 2);
        C10989b c10989b = this.aRC;
        if (c10989b != null) {
            c10989b.m24260a((short) bArr.length);
            C10989b c10989b2 = this.aRC;
            int i = c10989b2.position;
            c10989b2.m24244n(bArr);
            return i;
        }
        return 0;
    }

    /* renamed from: a */
    private String m24217a(C10978a.C10987i c10987i) {
        byte[] bytes;
        try {
            byte[] m24160af = C11004h.m24160af(new File(this.f29673VM + this.name, (String) c10987i.value));
            String str = new String(m24160af);
            return (m24160af == null || TextUtils.isEmpty(str) || (bytes = C10989b.m24245j(m24160af, C10989b.m24248he(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, C10989b.UTF_8);
        } catch (Exception e) {
            m24185u(e);
        }
        return "";
    }

    /* renamed from: a */
    private byte[] m24219a(C10978a.C10979a c10979a) {
        try {
            byte[] m24160af = C11004h.m24160af(new File(this.f29673VM + this.name, (String) c10979a.value));
            return m24160af != null ? m24160af : aRq;
        } catch (Exception e) {
            m24185u(e);
            return aRq;
        }
    }

    /* renamed from: a */
    private Object m24218a(C10978a.C10986h c10986h) {
        try {
            byte[] m24160af = C11004h.m24160af(new File(this.f29673VM + this.name, (String) c10986h.value));
            if (m24160af != null) {
                int i = m24160af[0] & UByte.f41242c;
                String str = new String(m24160af, 1, i, C10989b.UTF_8);
                InterfaceC10994b interfaceC10994b = this.aRu.get(str);
                if (interfaceC10994b != null) {
                    int i2 = i + 1;
                    return interfaceC10994b.mo24168g(m24160af, i2, m24160af.length - i2);
                }
                m24190g(new Exception("No encoder for tag:" + str));
                return null;
            }
            m24190g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e) {
            m24185u(e);
            return null;
        }
    }

    /* renamed from: a */
    private synchronized <T> void m24211a(String str, T t, InterfaceC10994b<T> interfaceC10994b) {
        m24188hh(str);
        if (interfaceC10994b == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (!C9585a.f29487md.booleanValue()) {
                m24185u(illegalArgumentException);
                return;
            }
            throw illegalArgumentException;
        }
        String mo24170NN = interfaceC10994b.mo24170NN();
        if (!mo24170NN.isEmpty() && mo24170NN.length() <= 50) {
            if (!this.aRu.containsKey(mo24170NN)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (!C9585a.f29487md.booleanValue()) {
                    m24185u(illegalArgumentException2);
                    return;
                }
                throw illegalArgumentException2;
            } else if (t == null) {
                remove(str);
                return;
            } else {
                byte[] bArr = null;
                try {
                    bArr = interfaceC10994b.mo24166m(t);
                } catch (Exception e) {
                    m24185u(e);
                }
                if (bArr == null) {
                    remove(str);
                    return;
                }
                int m24248he = C10989b.m24248he(mo24170NN);
                C10989b c10989b = new C10989b(m24248he + 1 + bArr.length);
                c10989b.m24258e((byte) m24248he);
                c10989b.m24249hd(mo24170NN);
                c10989b.m24244n(bArr);
                m24208a(str, t, c10989b.aRo, (C10978a.C10986h) this.aRF.get(str), (byte) 8);
                return;
            }
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + mo24170NN);
        if (!C9585a.f29487md.booleanValue()) {
            m24185u(illegalArgumentException3);
            return;
        }
        throw illegalArgumentException3;
    }

    /* renamed from: a */
    private synchronized void m24203a(Map<String, Object> map, Map<Class, InterfaceC10994b> map2) {
        if (map == null) {
            return;
        }
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
                    m24199b(key, (byte[]) value);
                } else {
                    m24190g(new Exception("missing encoders"));
                }
            }
        }
    }

    /* renamed from: a */
    private void m24205a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        int capacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (capacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.aRA ? this.aRw : this.aRx;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aRA) {
                this.aRA = map;
            } else {
                this.aRB = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    /* renamed from: a */
    private void m24214a(String str, byte b) {
        m24213a(str, b, aRp[b]);
    }

    /* renamed from: a */
    private void m24213a(String str, byte b, int i) {
        int m24248he = C10989b.m24248he(str);
        m24194el(m24248he);
        this.aRI = m24248he + 2 + i;
        m24233NI();
        C10989b c10989b = this.aRC;
        if (c10989b != null) {
            c10989b.m24258e(b);
        }
        m24186u(str, m24248he);
    }

    /* renamed from: a */
    private void m24223a(byte b, int i) {
        long m24195e = this.aRE ^ m24195e(1L, i);
        this.aRE = m24195e;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, m24195e);
                this.aRA.put(i, b);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.put(i, b);
            }
        } else {
            C10989b c10989b = this.aRC;
            if (c10989b != null) {
                c10989b.m24250f(4, m24195e);
            }
        }
        C10989b c10989b2 = this.aRC;
        if (c10989b2 != null) {
            c10989b2.aRo[i] = b;
        }
    }

    /* renamed from: a */
    private void m24221a(int i, long j, int i2) {
        long m24195e = m24195e(j, i2) ^ this.aRE;
        this.aRE = m24195e;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, m24195e);
                this.aRA.putInt(i2, i);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.putInt(i2, i);
            }
        } else {
            C10989b c10989b = this.aRC;
            if (c10989b != null) {
                c10989b.m24250f(4, m24195e);
            }
        }
        C10989b c10989b2 = this.aRC;
        if (c10989b2 != null) {
            c10989b2.m24264B(i2, i);
        }
    }

    /* renamed from: a */
    private static void m24212a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 <= str.length() && i2 >= 0) {
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i5 + 1;
                char charAt = str.charAt(i5);
                if (charAt < 128) {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) (((byte) charAt) ^ 1);
                } else {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                }
                i5 = i6;
                i3 = i4;
            }
        }
    }

    /* renamed from: a */
    private void m24207a(String str, String str2, C10978a.C10987i c10987i) {
        int m24248he = C10989b.m24248he(str2);
        if (c10987i == null) {
            int m24248he2 = C10989b.m24248he(str);
            m24194el(m24248he2);
            int i = m24248he2 + 4;
            this.aRI = i + m24248he;
            m24233NI();
            C10989b c10989b = this.aRC;
            if (c10989b != null) {
                c10989b.m24258e((byte) 6);
            }
            m24186u(str, m24248he2);
            m24184v(str2, m24248he);
            Map<String, C10978a.AbstractC10980b> map = this.aRF;
            int i2 = this.aRH;
            map.put(str, new C10978a.C10987i(i2, i2 + i, str2, m24248he, false));
            m24235NG();
        } else {
            int i3 = c10987i.offset;
            int i4 = i3 - c10987i.start;
            int i5 = c10987i.aRl;
            boolean z = true;
            if (i5 == m24248he) {
                this.aRE = this.aRC.m24262D(i3, i5) ^ this.aRE;
                if (m24248he == str2.length()) {
                    m24212a(str2, 0, m24248he, this.aRC.aRo, c10987i.offset);
                } else {
                    C10989b c10989b2 = this.aRC;
                    if (c10989b2 != null) {
                        c10989b2.position = c10987i.offset;
                        c10989b2.m24249hd(str2);
                    }
                }
                this.aRH = c10987i.offset;
                this.aRI = m24248he;
                z = false;
            } else {
                this.aRI = i4 + m24248he;
                m24233NI();
                C10989b c10989b3 = this.aRC;
                if (c10989b3 != null) {
                    c10989b3.m24258e((byte) 6);
                }
                int i6 = i4 - 3;
                C10989b c10989b4 = this.aRC;
                if (c10989b4 != null) {
                    byte[] bArr = c10989b4.aRo;
                    System.arraycopy(bArr, c10987i.start + 1, bArr, c10989b4.position, i6);
                }
                C10989b c10989b5 = this.aRC;
                if (c10989b5 != null) {
                    c10989b5.position += i6;
                }
                m24184v(str2, m24248he);
                m24222a((byte) 6, c10987i.start, c10987i.offset + c10987i.aRl);
                r10 = c10987i.aRm ? (String) c10987i.value : null;
                c10987i.aRm = false;
                int i7 = this.aRH;
                c10987i.start = i7;
                c10987i.offset = i7 + i4;
                c10987i.aRl = m24248he;
            }
            c10987i.value = str2;
            m24235NG();
            if (z) {
                m24232NJ();
            }
            if (r10 != null) {
                C11004h.m24158h(new File(this.f29673VM + this.name, r10));
            }
        }
        m24224Nz();
    }

    /* renamed from: a */
    private void m24208a(String str, Object obj, byte[] bArr, C10978a.AbstractC10988j abstractC10988j, byte b) {
        if (abstractC10988j == null) {
            m24210a(str, obj, bArr, b);
        } else if (!abstractC10988j.aRm && abstractC10988j.aRl == bArr.length) {
            updateBytes(abstractC10988j.offset, bArr);
            abstractC10988j.value = obj;
        } else {
            m24209a(str, obj, bArr, abstractC10988j);
        }
        m24224Nz();
    }

    /* renamed from: a */
    private void m24210a(String str, Object obj, byte[] bArr, byte b) {
        String str2;
        int length;
        C10978a.AbstractC10980b c10986h;
        int m24206a = m24206a(str, bArr, b);
        if (m24206a != 0) {
            String str3 = this.aRL;
            boolean z = str3 != null;
            if (z) {
                this.aRL = null;
                str2 = str3;
                length = 32;
            } else {
                str2 = obj;
                length = bArr.length;
            }
            if (b == 6) {
                c10986h = new C10978a.C10987i(this.aRH, m24206a, (String) str2, length, z);
            } else if (b == 7) {
                c10986h = new C10978a.C10979a(this.aRH, m24206a, str2, length, z);
            } else {
                c10986h = new C10978a.C10986h(this.aRH, m24206a, str2, length, z);
            }
            this.aRF.put(str, c10986h);
            m24235NG();
        }
    }

    /* renamed from: a */
    private void m24209a(String str, Object obj, byte[] bArr, @NonNull C10978a.AbstractC10988j abstractC10988j) {
        int m24206a = m24206a(str, bArr, abstractC10988j.mo24265Ns());
        if (m24206a != 0) {
            String str2 = abstractC10988j.aRm ? (String) abstractC10988j.value : null;
            m24222a(abstractC10988j.mo24265Ns(), abstractC10988j.start, abstractC10988j.offset + abstractC10988j.aRl);
            String str3 = this.aRL;
            boolean z = str3 != null;
            abstractC10988j.start = this.aRH;
            abstractC10988j.offset = m24206a;
            abstractC10988j.aRm = z;
            if (z) {
                abstractC10988j.value = str3;
                abstractC10988j.aRl = 32;
                this.aRL = null;
            } else {
                abstractC10988j.value = obj;
                abstractC10988j.aRl = bArr.length;
            }
            m24235NG();
            m24232NJ();
            if (str2 != null) {
                C11004h.m24158h(new File(this.f29673VM + this.name, str2));
            }
        }
    }

    /* renamed from: a */
    private int m24206a(String str, byte[] bArr, byte b) {
        this.aRL = null;
        if (bArr.length < 2048) {
            return m24198b(str, bArr, b);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String m24165NP = C11004h.m24165NP();
        if (C11004h.m24163a(new File(this.f29673VM + this.name, m24165NP), bArr)) {
            this.aRL = m24165NP;
            byte[] bArr2 = new byte[32];
            m24165NP.getBytes(0, 32, bArr2, 0);
            return m24198b(str, bArr2, (byte) (b | 64));
        }
        m24187hi("save large value failed");
        return 0;
    }

    /* renamed from: a */
    private void m24222a(byte b, int i, int i2) {
        byte[] bArr;
        m24242F(i, i2);
        byte b2 = (byte) (b | Byte.MIN_VALUE);
        C10989b c10989b = this.aRC;
        if (c10989b != null && (bArr = c10989b.aRo) != null) {
            this.aRE = (((bArr[i] ^ b2) & 255) << ((i & 7) << 3)) ^ this.aRE;
            bArr[i] = b2;
        }
        this.aRJ = i;
    }

    /* renamed from: a */
    private void m24220a(int i, int[] iArr) {
        Map<String, C10978a.AbstractC10980b> map = this.aRF;
        if (map == null) {
            return;
        }
        for (C10978a.AbstractC10980b abstractC10980b : map.values()) {
            int i2 = abstractC10980b.offset;
            if (i2 > i) {
                int i3 = iArr[(C11004h.binarySearch(iArr, i2) << 1) + 1];
                abstractC10980b.offset -= i3;
                if (abstractC10980b.mo24265Ns() >= 6) {
                    ((C10978a.AbstractC10988j) abstractC10980b).start -= i3;
                }
            }
        }
    }
}
