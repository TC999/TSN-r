package com.kwai.library.ipneigh;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.kwai.library.ipneigh.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0726a extends Thread {
        private final InputStream aUw;

        public C0726a(InputStream inputStream) {
            super("NoopStreamConsumer");
            this.aUw = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            BufferedReader bufferedReader;
            Throwable th;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.aUw));
                do {
                    try {
                    } catch (IOException unused) {
                        bufferedReader2 = bufferedReader;
                        a.closeQuietly(bufferedReader2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        a.closeQuietly(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader.readLine() != null);
                a.closeQuietly(bufferedReader);
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b<T> {
        T b(BufferedReader bufferedReader);
    }

    private static <T> T a(String str, b<T> bVar) {
        BufferedReader bufferedReader;
        Process exec;
        C0726a c0726a;
        Process process = null;
        try {
            exec = Runtime.getRuntime().exec(str);
            try {
                c0726a = new C0726a(exec.getErrorStream());
                c0726a.start();
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            T b4 = bVar.b(bufferedReader);
            c0726a.join();
            exec.waitFor();
            exec.destroy();
            closeQuietly(bufferedReader);
            return b4;
        } catch (Throwable th3) {
            th = th3;
            process = exec;
            if (process != null) {
                process.destroy();
            }
            closeQuietly(bufferedReader);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String hp(String str) {
        try {
            return (String) a(str, new b<String>() { // from class: com.kwai.library.ipneigh.a.1
                private static String a(BufferedReader bufferedReader) {
                    String readLine = bufferedReader.readLine();
                    do {
                    } while (bufferedReader.readLine() != null);
                    return readLine;
                }

                @Override // com.kwai.library.ipneigh.a.b
                public final /* synthetic */ String b(BufferedReader bufferedReader) {
                    return a(bufferedReader);
                }
            });
        } catch (IOException | InterruptedException unused) {
            return null;
        }
    }
}
