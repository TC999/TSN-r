package com.bytedance.sdk.component.xv.w.c.f;

import com.bytedance.sdk.component.xv.c.a;
import com.bytedance.sdk.component.xv.c.fz;
import com.bytedance.sdk.component.xv.c.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface c {

    /* renamed from: c  reason: collision with root package name */
    public static final c f30776c = new c() { // from class: com.bytedance.sdk.component.xv.w.c.f.c.1
        @Override // com.bytedance.sdk.component.xv.w.c.f.c
        public fz c(File file) throws FileNotFoundException {
            return a.c(file);
        }

        @Override // com.bytedance.sdk.component.xv.w.c.f.c
        public void delete(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // com.bytedance.sdk.component.xv.w.c.f.c
        public void f(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        f(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }

        @Override // com.bytedance.sdk.component.xv.w.c.f.c
        public boolean sr(File file) {
            return file.exists();
        }

        @Override // com.bytedance.sdk.component.xv.w.c.f.c
        public long ux(File file) {
            return file.length();
        }

        @Override // com.bytedance.sdk.component.xv.w.c.f.c
        public s w(File file) throws FileNotFoundException {
            try {
                return a.w(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return a.w(file);
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.f.c
        public s xv(File file) throws FileNotFoundException {
            try {
                return a.xv(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return a.xv(file);
            }
        }

        @Override // com.bytedance.sdk.component.xv.w.c.f.c
        public void c(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    fz c(File file) throws FileNotFoundException;

    void c(File file, File file2) throws IOException;

    void delete(File file) throws IOException;

    void f(File file) throws IOException;

    boolean sr(File file);

    long ux(File file);

    s w(File file) throws FileNotFoundException;

    s xv(File file) throws FileNotFoundException;
}
