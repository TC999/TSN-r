package com.bytedance.c.w.ux;

import com.bytedance.c.w.b;
import com.bytedance.sdk.component.gd.sr.xv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class e {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class a extends xv {

        /* renamed from: a  reason: collision with root package name */
        private InputStream f26613a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f26614b;

        a(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.f26613a = inputStream;
            this.f26614b = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f26613a));
            int i4 = 32768;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.startsWith("---------")) {
                        i4 -= readLine.getBytes("UTF-8").length;
                        if (i4 < 0) {
                            break;
                        }
                        this.f26614b.add(readLine);
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    b.g.a(bufferedReader);
                    throw th;
                }
            }
            b.g.a(bufferedReader);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class b extends xv {

        /* renamed from: a  reason: collision with root package name */
        private Process f26615a;

        /* renamed from: b  reason: collision with root package name */
        private long f26616b;

        public b(Process process, long j4) {
            super("LogcatDump$TimerThread");
            this.f26615a = process;
            this.f26616b = j4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.f26616b);
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
            Process process = this.f26615a;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String a(int i4) {
        return (i4 < 0 || i4 >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i4];
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005f, code lost:
        if (r4 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> b(int r4, int r5) {
        /*
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r1 = 4
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = 0
            java.lang.String r3 = "logcat"
            r1[r2] = r3
            r2 = 1
            java.lang.String r3 = "-t"
            r1[r2] = r3
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r2 = 2
            r1[r2] = r4
            java.lang.String r4 = a(r5)
            r5 = 3
            r1[r5] = r4
            r4 = 0
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L5b
            java.lang.Process r4 = r5.exec(r1)     // Catch: java.lang.Throwable -> L5b
            com.bytedance.c.w.ux.e$a r5 = new com.bytedance.c.w.ux.e$a     // Catch: java.lang.Throwable -> L5b
            java.io.InputStream r1 = r4.getInputStream()     // Catch: java.lang.Throwable -> L5b
            r5.<init>(r1, r0)     // Catch: java.lang.Throwable -> L5b
            r5.start()     // Catch: java.lang.Throwable -> L5b
            com.bytedance.c.w.ux.e$a r5 = new com.bytedance.c.w.ux.e$a     // Catch: java.lang.Throwable -> L5b
            java.io.InputStream r1 = r4.getErrorStream()     // Catch: java.lang.Throwable -> L5b
            r5.<init>(r1, r0)     // Catch: java.lang.Throwable -> L5b
            r5.start()     // Catch: java.lang.Throwable -> L5b
            com.bytedance.c.w.ux.e$b r5 = new com.bytedance.c.w.ux.e$b     // Catch: java.lang.Throwable -> L5b
            r1 = 3000(0xbb8, double:1.482E-320)
            r5.<init>(r4, r1)     // Catch: java.lang.Throwable -> L5b
            r5.start()     // Catch: java.lang.Throwable -> L5b
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L5b
            r3 = 26
            if (r5 < r3) goto L57
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L5b
            r4.waitFor(r1, r5)     // Catch: java.lang.Throwable -> L5b
            goto L61
        L57:
            r4.waitFor()     // Catch: java.lang.Throwable -> L5b
            goto L61
        L5b:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L65
            if (r4 == 0) goto L64
        L61:
            r4.destroy()
        L64:
            return r0
        L65:
            r5 = move-exception
            if (r4 == 0) goto L6b
            r4.destroy()
        L6b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.c.w.ux.e.b(int, int):java.util.List");
    }
}
