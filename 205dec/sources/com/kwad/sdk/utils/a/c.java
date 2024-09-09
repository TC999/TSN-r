package com.kwad.sdk.utils.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.kwad.sdk.utils.a.a;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] aRp = {0, 1, 4, 4, 8, 8};
    private static final byte[] aRq = new byte[0];
    private static final int aRr;
    private static final int aRs;
    private static final int aRt;
    private final String VM;
    private MappedByteBuffer aRA;
    private MappedByteBuffer aRB;
    private com.kwad.sdk.utils.a.b aRC;
    private int aRD;
    private long aRE;
    private int aRH;
    private int aRI;
    private int aRJ;
    private boolean aRK;
    private String aRL;
    private int aRM;
    private int aRO;
    private final Map<String, b> aRu;
    private FileChannel aRw;
    private FileChannel aRx;
    private RandomAccessFile aRy;
    private RandomAccessFile aRz;
    private final String name;
    private final d aRv = com.kwad.sdk.utils.a.d.aRZ;
    private final Map<String, a.b> aRF = new HashMap();
    private boolean aRG = false;
    private final ArrayList<e> aRN = new ArrayList<>();
    private boolean aRP = true;
    private final Executor aRQ = new f();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        static int aRS = 11;
        static final C0722c aRT = new C0722c(11);
        private final String VM;
        private int aRO = 0;
        private b[] aRU;
        private final String name;

        public a(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    if (!str.endsWith(TTPathConst.sSeparator)) {
                        str = str + '/';
                    }
                    this.VM = str;
                    this.name = str2;
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("path is empty");
        }

        public final c NM() {
            String str = this.VM + this.name;
            c hj = C0722c.hj(str);
            if (hj == null) {
                synchronized (a.class) {
                    hj = C0722c.hj(str);
                    if (hj == null) {
                        hj = new c(this.VM, this.name, this.aRU, this.aRO);
                        C0722c.b(str, hj);
                    }
                }
            }
            Integer num = C0722c.aRY.get(str);
            if (num != null) {
                C0722c.aRY.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0722c.aRY.put(str, 1);
            }
            return hj;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b<T> {
        String NN();

        T g(byte[] bArr, int i4, int i5);

        byte[] m(T t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.kwad.sdk.utils.a.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0722c {
        private static Map<String, c> aRV;
        private static List<String> aRW;
        private static int aRX;
        public static Map<String, Integer> aRY;

        public C0722c(int i4) {
            int size = getSize(i4);
            aRV = new ConcurrentHashMap(size);
            aRY = new HashMap(size);
            aRW = new CopyOnWriteArrayList();
            aRX = i4;
        }

        public static void b(String str, c cVar) {
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
            aRV.put(str, cVar);
            if (aRV.size() > aRX) {
                Integer num = aRY.get(aRW.get(0));
                if (num != null && num.intValue() != 2) {
                    ep(aRX + 1);
                    return;
                }
                c cVar2 = aRV.get(aRW.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                aRV.remove(aRW.get(0));
                aRW.remove(0);
            }
        }

        private static void ep(int i4) {
            d dVar = com.kwad.sdk.utils.a.d.aRZ;
            dVar.i("Ks_UnionKv", "reSize:" + i4);
            aRX = i4;
        }

        private static int getSize(int i4) {
            return (int) ((i4 / 0.75f) + 1.0f);
        }

        public static c hj(String str) {
            if (aRV == null) {
                aRV = new ConcurrentHashMap(getSize(aRX));
            }
            if (aRW == null) {
                aRW = new CopyOnWriteArrayList();
            }
            c cVar = aRV.get(str);
            if (cVar != null) {
                aRW.remove(str);
                aRW.add(str);
                return cVar;
            }
            return null;
        }

        public static void remove(String str) {
            List<String> list = aRW;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = aRV;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class e implements Comparable<e> {
        int end;
        int start;

        e(int i4, int i5) {
            this.start = i4;
            this.end = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int NQ = h.NQ();
        PAGE_SIZE = NQ;
        aRr = NQ - 192;
        int max = Math.max(NQ << 1, 16384);
        aRs = max;
        aRt = max << 1;
    }

    c(String str, String str2, b[] bVarArr, int i4) {
        this.VM = str;
        this.name = str2;
        this.aRO = i4;
        HashMap hashMap = new HashMap();
        g gVar = g.aSg;
        hashMap.put(gVar.NN(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String NN = bVar.NN();
                if (hashMap.containsKey(NN)) {
                    hi("duplicate encoder tag:" + NN);
                } else {
                    hashMap.put(NN, bVar);
                }
            }
        }
        this.aRu = hashMap;
        synchronized (this.aRF) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Nu();
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

    private int E(int i4, int i5) {
        if (i5 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (!com.kwad.library.a.a.md.booleanValue()) {
                u(illegalStateException);
            } else {
                throw illegalStateException;
            }
        }
        int i6 = PAGE_SIZE;
        if (i5 <= i6) {
            return i6;
        }
        while (i4 < i5) {
            int i7 = aRs;
            i4 = i4 <= i7 ? i4 << 1 : i4 + i7;
        }
        return i4;
    }

    private void F(int i4, int i5) {
        this.aRM += i5 - i4;
        ArrayList<e> arrayList = this.aRN;
        if (arrayList != null) {
            arrayList.add(new e(i4, i5));
        }
    }

    private boolean NA() {
        int i4 = this.aRO;
        if (i4 == 1) {
            Executor executor = this.aRQ;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.NB();
                    }
                });
            }
        } else if (i4 == 2) {
            return NB();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean NB() {
        try {
            String str = this.VM;
            File file = new File(str, this.name + ".tmp");
            if (h.ae(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.aRD);
                randomAccessFile.write(this.aRC.aRo, 0, this.aRD);
                randomAccessFile.close();
                String str2 = this.VM;
                File file2 = new File(str2, this.name + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    g(new Exception("rename failed"));
                }
            }
        } catch (Exception e4) {
            u(e4);
        }
        return false;
    }

    private void NC() {
        try {
            String str = this.VM;
            h.h(new File(str, this.name + ".kvc"));
            String str2 = this.VM;
            h.h(new File(str2, this.name + ".tmp"));
        } catch (Exception e4) {
            u(e4);
        }
    }

    private void ND() {
        this.aRO = 1;
        h.closeQuietly(this.aRw);
        h.closeQuietly(this.aRx);
        this.aRw = null;
        this.aRx = null;
        this.aRA = null;
        this.aRB = null;
    }

    private void NE() {
        if (this.aRO == 0) {
            try {
                a(this.aRA);
                a(this.aRB);
            } catch (Throwable unused) {
                ND();
            }
        }
        NF();
        h.h(new File(this.VM + this.name));
    }

    private void NF() {
        this.aRD = 12;
        this.aRE = 0L;
        NL();
        this.aRF.clear();
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null && bVar.aRo.length == PAGE_SIZE) {
            bVar.B(0, 0);
            this.aRC.f(4, 0L);
            return;
        }
        this.aRC = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
    }

    private void NG() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 != null) {
            this.aRE ^= bVar2.D(this.aRH, this.aRI);
        }
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.aRA);
                this.aRA.putInt(0, this.aRD - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.aRK && (bVar = this.aRC) != null) {
                bVar.B(0, this.aRD - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.aRC;
            if (bVar3 != null) {
                bVar3.f(4, this.aRE);
            }
        }
        this.aRK = false;
        this.aRJ = 0;
        this.aRI = 0;
    }

    private int NH() {
        int i4 = this.aRD;
        if (i4 <= 16384) {
            return 4096;
        }
        return i4 <= 65536 ? 8192 : 16384;
    }

    private void NI() {
        em(this.aRI);
        int i4 = this.aRD;
        this.aRH = i4;
        this.aRD = this.aRI + i4;
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            bVar.position = i4;
        }
        this.aRK = true;
    }

    private void NJ() {
        if (this.aRM < (NH() << 1)) {
            if (this.aRN.size() < (this.aRD < 16384 ? 80 : 160)) {
                return;
            }
        }
        en(0);
    }

    private void NK() {
        ArrayList<e> arrayList = this.aRN;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.aRN.get(size);
        while (size > 0) {
            size--;
            e eVar2 = this.aRN.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.aRN.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    private void NL() {
        this.aRM = 0;
        ArrayList<e> arrayList = this.aRN;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Nu() {
        synchronized (this.aRF) {
            this.aRG = true;
            this.aRF.notify();
        }
        long nanoTime = System.nanoTime();
        if (!Nx() && this.aRO == 0) {
            Nv();
        }
        if (this.aRC == null) {
            this.aRC = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        if (this.aRv != null) {
            long nanoTime2 = (System.nanoTime() - nanoTime) / C.MICROS_PER_SECOND;
            info("loading finish, data len:" + this.aRD + ", get keys:" + this.aRF.size() + ", use time:" + nanoTime2 + " ms");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a4 A[Catch: all -> 0x01c6, TryCatch #0 {all -> 0x01c6, blocks: (B:3:0x0038, B:5:0x003e, B:8:0x0046, B:9:0x0070, B:13:0x0081, B:17:0x009e, B:18:0x00a9, B:22:0x00c0, B:23:0x00c4, B:25:0x00e1, B:27:0x00e8, B:29:0x010a, B:31:0x0110, B:37:0x011d, B:39:0x0123, B:41:0x013a, B:43:0x0142, B:45:0x015b, B:46:0x0168, B:48:0x0184, B:50:0x018a, B:53:0x01a4, B:16:0x0099, B:12:0x007e, B:56:0x01ae, B:58:0x01b8), top: B:63:0x0038, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Nv() {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.Nv():void");
    }

    private boolean Nw() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.aRD);
        MappedByteBuffer mappedByteBuffer = this.aRB;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.aRB.get(bVar.aRo, 0, this.aRD);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 != null) {
            byte[] bArr = bVar2.aRo;
            byte[] bArr2 = bVar.aRo;
            for (int i4 = 0; i4 < this.aRD; i4++) {
                if (bArr[i4] != bArr2[i4]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private boolean Nx() {
        String str = this.VM;
        File file = new File(str, this.name + ".kvc");
        String str2 = this.VM;
        File file2 = new File(str2, this.name + ".tmp");
        boolean z3 = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (ad(file)) {
                    if (this.aRO == 0) {
                        if (a(this.aRC)) {
                            info("recover from c file");
                            try {
                                NC();
                                return true;
                            } catch (Exception e4) {
                                e = e4;
                                u(e);
                                return z3;
                            }
                        }
                        this.aRO = 1;
                    }
                } else {
                    NF();
                    NC();
                }
            } else if (this.aRO != 0) {
                String str3 = this.VM;
                File file3 = new File(str3, this.name + ".kva");
                String str4 = this.VM;
                File file4 = new File(str4, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    h(file3, file4);
                }
            }
            return false;
        } catch (Exception e5) {
            e = e5;
            z3 = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x016f, code lost:
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int Ny() {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.Ny():int");
    }

    private void Nz() {
        if (this.aRO == 0 || !this.aRP) {
            return;
        }
        NA();
    }

    private boolean ad(File file) {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i4 = (int) length;
            int E = E(PAGE_SIZE, i4);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null && bVar.aRo.length == E) {
                bVar.position = 0;
            } else {
                bVar = new com.kwad.sdk.utils.a.b(new byte[E]);
                this.aRC = bVar;
            }
            h.a(file, bVar.aRo, i4);
            int i5 = bVar.getInt();
            long j4 = bVar.getLong();
            this.aRD = i5 + 12;
            if (i5 >= 0 && i5 <= i4 - 12 && j4 == bVar.D(12, i5) && Ny() == 0) {
                this.aRE = j4;
                return true;
            }
        }
        return false;
    }

    private static long e(long j4, int i4) {
        int i5 = (i4 & 7) << 3;
        return (j4 >>> (64 - i5)) | (j4 << i5);
    }

    private static void e(int i4, boolean z3) {
        if (z3) {
            if (i4 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i4 < 0 || i4 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private static void el(int i4) {
        if (i4 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void em(int i4) {
        if (this.aRC == null) {
            this.aRC = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.aRC.aRo.length;
        int i5 = this.aRD + i4;
        if (i5 >= length) {
            int i6 = this.aRM;
            if (i6 > i4 && i6 > NH()) {
                en(i4);
                return;
            }
            int E = E(length, i5);
            byte[] bArr = new byte[E];
            System.arraycopy(this.aRC.aRo, 0, bArr, 0, this.aRD);
            this.aRC.aRo = bArr;
            if (this.aRO == 0) {
                try {
                    long j4 = E;
                    MappedByteBuffer map = this.aRw.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                    this.aRA = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.aRx.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                    this.aRB = map2;
                    map2.order(byteOrder);
                } catch (Throwable th) {
                    u(new Exception("map failed", th));
                    this.aRC.B(0, this.aRD - 12);
                    this.aRC.f(4, this.aRE);
                    ND();
                }
            }
        }
    }

    private void en(int i4) {
        int i5;
        ArrayList<e> arrayList = this.aRN;
        if (arrayList == null || this.aRC == null) {
            return;
        }
        Collections.sort(arrayList);
        NK();
        e eVar = this.aRN.get(0);
        int i6 = eVar.start;
        int i7 = this.aRD;
        int i8 = i7 - this.aRM;
        int i9 = i8 - 12;
        int i10 = i8 - i6;
        int i11 = i7 - i6;
        boolean z3 = i9 < i11 + i10;
        if (!z3) {
            this.aRE ^= this.aRC.D(i6, i11);
        }
        int size = this.aRN.size();
        int i12 = size - 1;
        int i13 = this.aRD - this.aRN.get(i12).end;
        int[] iArr = new int[(i13 > 0 ? size : i12) << 1];
        int i14 = eVar.start;
        int i15 = eVar.end;
        for (int i16 = 1; i16 < size; i16++) {
            e eVar2 = this.aRN.get(i16);
            int i17 = eVar2.start - i15;
            byte[] bArr = this.aRC.aRo;
            System.arraycopy(bArr, i15, bArr, i14, i17);
            int i18 = (i16 - 1) << 1;
            iArr[i18] = i15;
            iArr[i18 + 1] = i15 - i14;
            i14 += i17;
            i15 = eVar2.end;
        }
        if (i13 > 0) {
            byte[] bArr2 = this.aRC.aRo;
            System.arraycopy(bArr2, i15, bArr2, i14, i13);
            int i19 = i12 << 1;
            iArr[i19] = i15;
            iArr[i19 + 1] = i15 - i14;
        }
        NL();
        if (z3) {
            this.aRE = this.aRC.D(12, i9);
        } else {
            this.aRE ^= this.aRC.D(i6, i10);
        }
        this.aRD = i8;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                i5 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.aRA.putLong(4, this.aRE);
                this.aRA.position(i6);
                this.aRA.put(this.aRC.aRo, i6, i10);
                this.aRA.putInt(0, i9);
            } else {
                i5 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i5, i9);
                this.aRB.putLong(4, this.aRE);
                this.aRB.position(i6);
                this.aRB.put(this.aRC.aRo, i6, i10);
            }
        } else {
            this.aRC.B(0, i9);
            this.aRC.f(4, this.aRE);
        }
        a(i6, iArr);
        int i20 = i8 + i4;
        if (this.aRC.aRo.length - i20 > aRt) {
            eo(i20);
        }
        info("gc finish");
    }

    private void eo(int i4) {
        int i5 = PAGE_SIZE;
        int E = E(i5, i4 + i5);
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            byte[] bArr = bVar.aRo;
            if (E >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[E];
            System.arraycopy(bArr, 0, bArr2, 0, this.aRD);
            this.aRC.aRo = bArr2;
        }
        if (this.aRO == 0) {
            try {
                long j4 = E;
                this.aRw.truncate(j4);
                MappedByteBuffer map = this.aRw.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                this.aRA = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.aRx.truncate(j4);
                MappedByteBuffer map2 = this.aRx.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                this.aRB = map2;
                map2.order(byteOrder);
            } catch (Throwable th) {
                u(new Exception("map failed", th));
                ND();
            }
        }
        info("truncate finish");
    }

    private void g(Exception exc) {
        d dVar = this.aRv;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void h(File file, File file2) {
        try {
            if (ad(file)) {
                return;
            }
        } catch (IOException e4) {
            g(e4);
        }
        NF();
        try {
            if (ad(file2)) {
                return;
            }
        } catch (Exception e5) {
            g(e5);
        }
        NF();
    }

    private static void hh(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void hi(String str) {
        d dVar = this.aRv;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void info(String str) {
        d dVar = this.aRv;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private synchronized void putDouble(String str, double d4) {
        hh(str);
        a.d dVar = (a.d) this.aRF.get(str);
        if (dVar == null) {
            a(str, (byte) 5);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                int i4 = bVar.position;
                bVar.aH(Double.doubleToRawLongBits(d4));
                NG();
                Map<String, a.b> map = this.aRF;
                if (map != null) {
                    map.put(str, new a.d(i4, d4));
                }
            }
            Nz();
            return;
        }
        if (dVar.value != d4) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d4);
            dVar.value = d4;
            b(doubleToRawLongBits, Double.doubleToRawLongBits(dVar.value) ^ doubleToRawLongBits, dVar.offset);
            Nz();
        }
    }

    private synchronized void putFloat(String str, float f4) {
        hh(str);
        a.e eVar = (a.e) this.aRF.get(str);
        if (eVar == null) {
            a(str, (byte) 3);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                int i4 = bVar.position;
                bVar.ee(Float.floatToRawIntBits(f4));
                NG();
                Map<String, a.b> map = this.aRF;
                if (map != null) {
                    map.put(str, new a.e(i4, f4));
                }
            }
            Nz();
            return;
        }
        if (eVar.value != f4) {
            int floatToRawIntBits = Float.floatToRawIntBits(f4);
            eVar.value = f4;
            a(floatToRawIntBits, (Float.floatToRawIntBits(eVar.value) ^ floatToRawIntBits) & 4294967295L, eVar.offset);
            Nz();
        }
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, (String) set, (b<String>) g.aSg);
        }
    }

    private void u(String str, int i4) {
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i4);
        if (i4 == str.length()) {
            com.kwad.sdk.utils.a.b bVar2 = this.aRC;
            a(str, 0, i4, bVar2.aRo, bVar2.position);
            this.aRC.position += i4;
            return;
        }
        this.aRC.hd(str);
    }

    private void updateBytes(int i4, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            this.aRE ^= bVar.D(i4, length);
            com.kwad.sdk.utils.a.b bVar2 = this.aRC;
            bVar2.position = i4;
            bVar2.n(bArr);
            this.aRE ^= this.aRC.D(i4, length);
        }
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                this.aRA.putLong(4, this.aRE);
                this.aRA.position(i4);
                this.aRA.put(bArr);
                this.aRA.putInt(0, this.aRD - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.position(i4);
                this.aRB.put(bArr);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.b bVar3 = this.aRC;
        if (bVar3 != null) {
            bVar3.f(4, this.aRE);
        }
    }

    private void v(String str, int i4) {
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i4);
        if (i4 == str.length()) {
            com.kwad.sdk.utils.a.b bVar2 = this.aRC;
            a(str, 0, i4, bVar2.aRo, bVar2.position);
            return;
        }
        this.aRC.hd(str);
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
        for (Map.Entry<String, a.b> entry : this.aRF.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            Object obj = null;
            switch (value.Ns()) {
                case 1:
                    valueOf = Boolean.valueOf(((a.c) value).value);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((a.f) value).value);
                    break;
                case 3:
                    valueOf = Float.valueOf(((a.e) value).value);
                    break;
                case 4:
                    valueOf = Long.valueOf(((a.g) value).value);
                    break;
                case 5:
                    valueOf = Double.valueOf(((a.d) value).value);
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    if (iVar.aRm) {
                        valueOf = a(iVar);
                        break;
                    } else {
                        valueOf = iVar.value;
                        break;
                    }
                case 7:
                    a.C0721a c0721a = (a.C0721a) value;
                    if (c0721a.aRm) {
                        valueOf = a(c0721a);
                        break;
                    } else {
                        valueOf = c0721a.value;
                        break;
                    }
                case 8:
                    a.h hVar = (a.h) value;
                    if (hVar.aRm) {
                        valueOf = a(hVar);
                        break;
                    } else {
                        valueOf = ((a.h) value).value;
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

    public final synchronized boolean getBoolean(String str, boolean z3) {
        a.c cVar = (a.c) this.aRF.get(str);
        if (cVar == null) {
            return z3;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i4) {
        a.f fVar = (a.f) this.aRF.get(str);
        if (fVar == null) {
            return i4;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j4) {
        a.g gVar = (a.g) this.aRF.get(str);
        if (gVar == null) {
            return j4;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.aRF.get(str);
        if (iVar != null) {
            if (iVar.aRm) {
                return a(iVar);
            }
            return (String) iVar.value;
        }
        return str2;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z3) {
        hh(str);
        a.c cVar = (a.c) this.aRF.get(str);
        if (cVar == null) {
            a(str, (byte) 1);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                int i4 = bVar.position;
                bVar.e((byte) (z3 ? 1 : 0));
                NG();
                Map<String, a.b> map = this.aRF;
                if (map != null) {
                    map.put(str, new a.c(i4, z3));
                }
            }
            Nz();
            return;
        }
        if (cVar.value != z3) {
            cVar.value = z3;
            a((byte) (z3 ? 1 : 0), cVar.offset);
            Nz();
        }
    }

    public final synchronized void putInt(String str, int i4) {
        hh(str);
        a.f fVar = (a.f) this.aRF.get(str);
        if (fVar == null) {
            a(str, (byte) 2);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                int i5 = bVar.position;
                bVar.ee(i4);
                NG();
                Map<String, a.b> map = this.aRF;
                if (map != null) {
                    map.put(str, new a.f(i5, i4));
                }
            }
            Nz();
            return;
        }
        int i6 = fVar.value;
        if (i6 != i4) {
            fVar.value = i4;
            a(i4, (i6 ^ i4) & 4294967295L, fVar.offset);
            Nz();
        }
    }

    public final synchronized void putLong(String str, long j4) {
        hh(str);
        a.g gVar = (a.g) this.aRF.get(str);
        if (gVar == null) {
            a(str, (byte) 4);
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                int i4 = bVar.position;
                bVar.aH(j4);
                NG();
                Map<String, a.b> map = this.aRF;
                if (map != null) {
                    map.put(str, new a.g(i4, j4));
                }
            }
            Nz();
            return;
        }
        long j5 = gVar.value;
        if (j5 != j4) {
            gVar.value = j4;
            b(j4, j4 ^ j5, gVar.offset);
            Nz();
        }
    }

    public final synchronized void putString(String str, String str2) {
        byte[] hg;
        byte[] bArr;
        byte[] bArr2;
        hh(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.aRF.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (str2.isEmpty()) {
            hg = aRq;
        } else {
            if (iVar == null && str2.length() < 2048) {
                int he = com.kwad.sdk.utils.a.b.he(str2);
                bArr = new byte[he];
                if (he == str2.length()) {
                    a(str2, 0, he, bArr, 0);
                    bArr2 = bArr;
                } else {
                    hg = com.kwad.sdk.utils.a.b.hg(str2);
                }
            } else if (iVar != null && !iVar.aRm) {
                int he2 = com.kwad.sdk.utils.a.b.he(str2);
                bArr = new byte[he2];
                if (he2 == str2.length()) {
                    a(str2, 0, he2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    hg = com.kwad.sdk.utils.a.b.hg(str2);
                }
            } else {
                hg = com.kwad.sdk.utils.a.b.hg(str2);
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        bArr2 = hg;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    public final void release() {
        h.closeQuietly(this.aRy);
        h.closeQuietly(this.aRz);
        h.closeQuietly(this.aRw);
        h.closeQuietly(this.aRx);
        this.aRw = null;
        this.aRx = null;
        this.aRA = null;
        this.aRB = null;
        C0722c c0722c = a.aRT;
        C0722c.remove(this.VM + this.name);
    }

    public final synchronized void remove(String str) {
        a.b bVar = this.aRF.get(str);
        if (bVar != null) {
            this.aRF.remove(str);
            byte Ns = bVar.Ns();
            String str2 = null;
            if (Ns <= 5) {
                int he = com.kwad.sdk.utils.a.b.he(str);
                int i4 = bVar.offset;
                a(Ns, i4 - (he + 2), i4 + aRp[Ns]);
            } else {
                a.j jVar = (a.j) bVar;
                a(Ns, jVar.start, jVar.offset + jVar.aRl);
                if (jVar.aRm) {
                    str2 = (String) jVar.value;
                }
            }
            byte b4 = (byte) (Ns | Byte.MIN_VALUE);
            if (this.aRO == 0) {
                MappedByteBuffer mappedByteBuffer = this.aRA;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.putLong(4, this.aRE);
                    this.aRA.put(this.aRJ, b4);
                }
                MappedByteBuffer mappedByteBuffer2 = this.aRB;
                if (mappedByteBuffer2 != null) {
                    mappedByteBuffer2.putLong(4, this.aRE);
                    this.aRB.put(this.aRJ, b4);
                }
            } else {
                com.kwad.sdk.utils.a.b bVar2 = this.aRC;
                if (bVar2 != null) {
                    bVar2.f(4, this.aRE);
                }
            }
            this.aRJ = 0;
            if (str2 != null) {
                h.h(new File(this.VM + this.name, str2));
            }
            NJ();
            Nz();
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.VM + " name:" + this.name;
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) {
        int length = bVar.aRo.length;
        File file = new File(this.VM, this.name + ".kva");
        File file2 = new File(this.VM, this.name + ".kvb");
        try {
            if (h.ae(file) && h.ae(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j4 = length;
                randomAccessFile.setLength(j4);
                randomAccessFile2.setLength(j4);
                this.aRw = randomAccessFile.getChannel();
                this.aRx = randomAccessFile2.getChannel();
                MappedByteBuffer map = this.aRw.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                this.aRA = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                MappedByteBuffer map2 = this.aRx.map(FileChannel.MapMode.READ_WRITE, 0L, j4);
                this.aRB = map2;
                map2.order(byteOrder);
                this.aRA.put(bVar.aRo, 0, this.aRD);
                this.aRB.put(bVar.aRo, 0, this.aRD);
                return true;
            }
            throw new Exception("open file failed");
        } catch (Exception e4) {
            u(e4);
            return false;
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        hh(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0721a) this.aRF.get(str), (byte) 7);
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.aRK && mappedByteBuffer != this.aRA) {
            mappedByteBuffer.putInt(0, this.aRD - 12);
        }
        mappedByteBuffer.putLong(4, this.aRE);
        int i4 = this.aRJ;
        if (i4 != 0) {
            mappedByteBuffer.put(i4, this.aRC.aRo[i4]);
        }
        if (this.aRI != 0) {
            mappedByteBuffer.position(this.aRH);
            mappedByteBuffer.put(this.aRC.aRo, this.aRH, this.aRI);
        }
    }

    private void u(Throwable th) {
        d dVar = this.aRv;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    private void b(long j4, long j5, int i4) {
        long e4 = e(j5, i4) ^ this.aRE;
        this.aRE = e4;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e4);
                this.aRA.putLong(i4, j4);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.putLong(i4, j4);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                bVar.f(4, e4);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 != null) {
            bVar2.f(i4, j4);
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i4) {
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
            } catch (Exception e4) {
                u(e4);
                ND();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i4);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private int b(String str, byte[] bArr, byte b4) {
        a(str, b4, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            bVar.a((short) bArr.length);
            com.kwad.sdk.utils.a.b bVar2 = this.aRC;
            int i4 = bVar2.position;
            bVar2.n(bArr);
            return i4;
        }
        return 0;
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] af = h.af(new File(this.VM + this.name, (String) iVar.value));
            String str = new String(af);
            return (af == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.j(af, com.kwad.sdk.utils.a.b.he(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e4) {
            u(e4);
        }
        return "";
    }

    private byte[] a(a.C0721a c0721a) {
        try {
            byte[] af = h.af(new File(this.VM + this.name, (String) c0721a.value));
            return af != null ? af : aRq;
        } catch (Exception e4) {
            u(e4);
            return aRq;
        }
    }

    private Object a(a.h hVar) {
        try {
            byte[] af = h.af(new File(this.VM + this.name, (String) hVar.value));
            if (af != null) {
                int i4 = af[0] & 255;
                String str = new String(af, 1, i4, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.aRu.get(str);
                if (bVar != null) {
                    int i5 = i4 + 1;
                    return bVar.g(af, i5, af.length - i5);
                }
                g(new Exception("No encoder for tag:" + str));
                return null;
            }
            g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e4) {
            u(e4);
            return null;
        }
    }

    private synchronized <T> void a(String str, T t3, b<T> bVar) {
        hh(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (!com.kwad.library.a.a.md.booleanValue()) {
                u(illegalArgumentException);
                return;
            }
            throw illegalArgumentException;
        }
        String NN = bVar.NN();
        if (!NN.isEmpty() && NN.length() <= 50) {
            if (!this.aRu.containsKey(NN)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (!com.kwad.library.a.a.md.booleanValue()) {
                    u(illegalArgumentException2);
                    return;
                }
                throw illegalArgumentException2;
            } else if (t3 == null) {
                remove(str);
                return;
            } else {
                byte[] bArr = null;
                try {
                    bArr = bVar.m(t3);
                } catch (Exception e4) {
                    u(e4);
                }
                if (bArr == null) {
                    remove(str);
                    return;
                }
                int he = com.kwad.sdk.utils.a.b.he(NN);
                com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(he + 1 + bArr.length);
                bVar2.e((byte) he);
                bVar2.hd(NN);
                bVar2.n(bArr);
                a(str, t3, bVar2.aRo, (a.h) this.aRF.get(str), (byte) 8);
                return;
            }
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + NN);
        if (!com.kwad.library.a.a.md.booleanValue()) {
            u(illegalArgumentException3);
            return;
        }
        throw illegalArgumentException3;
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
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
                    b(key, (byte[]) value);
                } else {
                    g(new Exception("missing encoders"));
                }
            }
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        int capacity = mappedByteBuffer.capacity();
        int i4 = PAGE_SIZE;
        if (capacity != i4) {
            FileChannel fileChannel = mappedByteBuffer == this.aRA ? this.aRw : this.aRx;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i4);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i4);
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

    private void a(String str, byte b4) {
        a(str, b4, aRp[b4]);
    }

    private void a(String str, byte b4, int i4) {
        int he = com.kwad.sdk.utils.a.b.he(str);
        el(he);
        this.aRI = he + 2 + i4;
        NI();
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null) {
            bVar.e(b4);
        }
        u(str, he);
    }

    private void a(byte b4, int i4) {
        long e4 = this.aRE ^ e(1L, i4);
        this.aRE = e4;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e4);
                this.aRA.put(i4, b4);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.put(i4, b4);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                bVar.f(4, e4);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 != null) {
            bVar2.aRo[i4] = b4;
        }
    }

    private void a(int i4, long j4, int i5) {
        long e4 = e(j4, i5) ^ this.aRE;
        this.aRE = e4;
        if (this.aRO == 0) {
            MappedByteBuffer mappedByteBuffer = this.aRA;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e4);
                this.aRA.putInt(i5, i4);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aRB;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aRE);
                this.aRB.putInt(i5, i4);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                bVar.f(4, e4);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aRC;
        if (bVar2 != null) {
            bVar2.B(i5, i4);
        }
    }

    private static void a(String str, int i4, int i5, byte[] bArr, int i6) {
        int i7;
        if (i5 <= str.length() && i5 >= 0) {
            int i8 = 0;
            while (i8 < i5) {
                int i9 = i8 + 1;
                char charAt = str.charAt(i8);
                if (charAt < '\u0080') {
                    i7 = i6 + 1;
                    bArr[i6] = (byte) (((byte) charAt) ^ 1);
                } else {
                    i7 = i6 + 1;
                    bArr[i6] = (byte) charAt;
                }
                i8 = i9;
                i6 = i7;
            }
        }
    }

    private void a(String str, String str2, a.i iVar) {
        int he = com.kwad.sdk.utils.a.b.he(str2);
        if (iVar == null) {
            int he2 = com.kwad.sdk.utils.a.b.he(str);
            el(he2);
            int i4 = he2 + 4;
            this.aRI = i4 + he;
            NI();
            com.kwad.sdk.utils.a.b bVar = this.aRC;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            u(str, he2);
            v(str2, he);
            Map<String, a.b> map = this.aRF;
            int i5 = this.aRH;
            map.put(str, new a.i(i5, i5 + i4, str2, he, false));
            NG();
        } else {
            int i6 = iVar.offset;
            int i7 = i6 - iVar.start;
            int i8 = iVar.aRl;
            boolean z3 = true;
            if (i8 == he) {
                this.aRE = this.aRC.D(i6, i8) ^ this.aRE;
                if (he == str2.length()) {
                    a(str2, 0, he, this.aRC.aRo, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.aRC;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.hd(str2);
                    }
                }
                this.aRH = iVar.offset;
                this.aRI = he;
                z3 = false;
            } else {
                this.aRI = i7 + he;
                NI();
                com.kwad.sdk.utils.a.b bVar3 = this.aRC;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i9 = i7 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.aRC;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.aRo;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i9);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.aRC;
                if (bVar5 != null) {
                    bVar5.position += i9;
                }
                v(str2, he);
                a((byte) 6, iVar.start, iVar.offset + iVar.aRl);
                r10 = iVar.aRm ? (String) iVar.value : null;
                iVar.aRm = false;
                int i10 = this.aRH;
                iVar.start = i10;
                iVar.offset = i10 + i7;
                iVar.aRl = he;
            }
            iVar.value = str2;
            NG();
            if (z3) {
                NJ();
            }
            if (r10 != null) {
                h.h(new File(this.VM + this.name, r10));
            }
        }
        Nz();
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b4) {
        if (jVar == null) {
            a(str, obj, bArr, b4);
        } else if (!jVar.aRm && jVar.aRl == bArr.length) {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        } else {
            a(str, obj, bArr, jVar);
        }
        Nz();
    }

    private void a(String str, Object obj, byte[] bArr, byte b4) {
        String str2;
        int length;
        a.b hVar;
        int a4 = a(str, bArr, b4);
        if (a4 != 0) {
            String str3 = this.aRL;
            boolean z3 = str3 != null;
            if (z3) {
                this.aRL = null;
                str2 = str3;
                length = 32;
            } else {
                str2 = obj;
                length = bArr.length;
            }
            if (b4 == 6) {
                hVar = new a.i(this.aRH, a4, (String) str2, length, z3);
            } else if (b4 == 7) {
                hVar = new a.C0721a(this.aRH, a4, str2, length, z3);
            } else {
                hVar = new a.h(this.aRH, a4, str2, length, z3);
            }
            this.aRF.put(str, hVar);
            NG();
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull a.j jVar) {
        int a4 = a(str, bArr, jVar.Ns());
        if (a4 != 0) {
            String str2 = jVar.aRm ? (String) jVar.value : null;
            a(jVar.Ns(), jVar.start, jVar.offset + jVar.aRl);
            String str3 = this.aRL;
            boolean z3 = str3 != null;
            jVar.start = this.aRH;
            jVar.offset = a4;
            jVar.aRm = z3;
            if (z3) {
                jVar.value = str3;
                jVar.aRl = 32;
                this.aRL = null;
            } else {
                jVar.value = obj;
                jVar.aRl = bArr.length;
            }
            NG();
            NJ();
            if (str2 != null) {
                h.h(new File(this.VM + this.name, str2));
            }
        }
    }

    private int a(String str, byte[] bArr, byte b4) {
        this.aRL = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b4);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String NP = h.NP();
        if (h.a(new File(this.VM + this.name, NP), bArr)) {
            this.aRL = NP;
            byte[] bArr2 = new byte[32];
            NP.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b4 | 64));
        }
        hi("save large value failed");
        return 0;
    }

    private void a(byte b4, int i4, int i5) {
        byte[] bArr;
        F(i4, i5);
        byte b5 = (byte) (b4 | Byte.MIN_VALUE);
        com.kwad.sdk.utils.a.b bVar = this.aRC;
        if (bVar != null && (bArr = bVar.aRo) != null) {
            this.aRE = (((bArr[i4] ^ b5) & 255) << ((i4 & 7) << 3)) ^ this.aRE;
            bArr[i4] = b5;
        }
        this.aRJ = i4;
    }

    private void a(int i4, int[] iArr) {
        Map<String, a.b> map = this.aRF;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i5 = bVar.offset;
            if (i5 > i4) {
                int i6 = iArr[(h.binarySearch(iArr, i5) << 1) + 1];
                bVar.offset -= i6;
                if (bVar.Ns() >= 6) {
                    ((a.j) bVar).start -= i6;
                }
            }
        }
    }
}
