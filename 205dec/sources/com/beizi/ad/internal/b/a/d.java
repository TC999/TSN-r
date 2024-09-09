package com.beizi.ad.internal.b.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Files.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class d {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Files.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static final class a implements Comparator<File> {
        private a() {
        }

        private int a(long j4, long j5) {
            if (j4 < j5) {
                return -1;
            }
            return j4 == j5 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) throws IOException {
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
    public static List<File> b(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new a());
            return asList;
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            d(file);
            if (file.lastModified() >= currentTimeMillis) {
                return;
            }
            throw new IOException("Error set last modified date to " + file);
        }
    }

    static void d(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            e(file);
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

    private static void e(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
