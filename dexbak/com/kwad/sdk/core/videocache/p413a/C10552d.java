package com.kwad.sdk.core.videocache.p413a;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.kwad.sdk.core.videocache.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C10552d {

    /* renamed from: com.kwad.sdk.core.videocache.a.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C10553a implements Comparator<File> {
        private C10553a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }

        private static int compareLong(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        /* synthetic */ C10553a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public static void m25485u(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " is not directory!");
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public static List<File> m25484v(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new C10553a((byte) 0));
            return asList;
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public static void m25483w(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            m25482x(file);
            if (file.lastModified() < currentTimeMillis) {
                C10331c.m26246w("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
            }
        }
    }

    /* renamed from: x */
    private static void m25482x(File file) {
        long length = file.length();
        if (length == 0) {
            m25481y(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                long j = length - 1;
                try {
                    randomAccessFile2.seek(j);
                    byte readByte = randomAccessFile2.readByte();
                    randomAccessFile2.seek(j);
                    randomAccessFile2.write(readByte);
                    C10738b.closeQuietly(randomAccessFile2);
                } catch (IOException e) {
                    e = e;
                    randomAccessFile = randomAccessFile2;
                    C10331c.printStackTraceOnly(e);
                    C10738b.closeQuietly(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    C10738b.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: y */
    private static void m25481y(File file) {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
