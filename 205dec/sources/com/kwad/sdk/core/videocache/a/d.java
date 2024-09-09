package com.kwad.sdk.core.videocache.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class d {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class a implements Comparator<File> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }

        private static int compareLong(long j4, long j5) {
            if (j4 < j5) {
                return -1;
            }
            return j4 == j5 ? 0 : 1;
        }

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void u(File file) {
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
    public static List<File> v(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new a((byte) 0));
            return asList;
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            x(file);
            if (file.lastModified() < currentTimeMillis) {
                com.kwad.sdk.core.e.c.w("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
            }
        }
    }

    private static void x(File file) {
        long length = file.length();
        if (length == 0) {
            y(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                long j4 = length - 1;
                try {
                    randomAccessFile2.seek(j4);
                    byte readByte = randomAccessFile2.readByte();
                    randomAccessFile2.seek(j4);
                    randomAccessFile2.write(readByte);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
                } catch (IOException e4) {
                    e = e4;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void y(File file) {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
