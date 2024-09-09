package com.danikula.videocache.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: Files.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final org.slf4j.c f36740a = org.slf4j.d.j("Files");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: Files.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static final class b implements Comparator<File> {
        private b() {
        }

        private int b(long j4, long j5) {
            if (j4 < j5) {
                return -1;
            }
            return j4 == j5 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return b(file.lastModified(), file2.lastModified());
        }
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<File> a(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new b());
            return asList;
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " is not directory!");
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    static void c(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            d(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j4 = length - 1;
        randomAccessFile.seek(j4);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(j4);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    private static void d(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            c(file);
            if (file.lastModified() < currentTimeMillis) {
                f36740a.warn("Last modified date {} is not set for file {}", new Date(file.lastModified()), file.getAbsolutePath());
            }
        }
    }
}
