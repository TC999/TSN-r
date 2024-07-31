package com.kwai.library.ipneigh;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: com.kwai.library.ipneigh.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C11171a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwai.library.ipneigh.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11173a extends Thread {
        private final InputStream aUw;

        public C11173a(InputStream inputStream) {
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
                        C11171a.closeQuietly(bufferedReader2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        C11171a.closeQuietly(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader.readLine() != null);
                C11171a.closeQuietly(bufferedReader);
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwai.library.ipneigh.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11174b<T> {
        /* renamed from: b */
        T mo23480b(BufferedReader bufferedReader);
    }

    /* renamed from: a */
    private static <T> T m23484a(String str, InterfaceC11174b<T> interfaceC11174b) {
        BufferedReader bufferedReader;
        Process exec;
        C11173a c11173a;
        Process process = null;
        try {
            exec = Runtime.getRuntime().exec(str);
            try {
                c11173a = new C11173a(exec.getErrorStream());
                c11173a.start();
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
            T mo23480b = interfaceC11174b.mo23480b(bufferedReader);
            c11173a.join();
            exec.waitFor();
            exec.destroy();
            closeQuietly(bufferedReader);
            return mo23480b;
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

    /* renamed from: hp */
    public static String m23482hp(String str) {
        try {
            return (String) m23484a(str, new InterfaceC11174b<String>() { // from class: com.kwai.library.ipneigh.a.1
                /* renamed from: a */
                private static String m23481a(BufferedReader bufferedReader) {
                    String readLine = bufferedReader.readLine();
                    do {
                    } while (bufferedReader.readLine() != null);
                    return readLine;
                }

                @Override // com.kwai.library.ipneigh.C11171a.InterfaceC11174b
                /* renamed from: b */
                public final /* synthetic */ String mo23480b(BufferedReader bufferedReader) {
                    return m23481a(bufferedReader);
                }
            });
        } catch (IOException | InterruptedException unused) {
            return null;
        }
    }
}
