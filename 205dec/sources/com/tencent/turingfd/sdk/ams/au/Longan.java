package com.tencent.turingfd.sdk.ams.au;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Longan {

    /* renamed from: a  reason: collision with root package name */
    public final Object f52124a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f52125b;

    /* renamed from: c  reason: collision with root package name */
    public Process f52126c;

    /* renamed from: d  reason: collision with root package name */
    public DataOutputStream f52127d;

    /* renamed from: e  reason: collision with root package name */
    public Cdo f52128e;

    /* renamed from: f  reason: collision with root package name */
    public Cdo f52129f;

    /* renamed from: g  reason: collision with root package name */
    public ByteArrayOutputStream f52130g;

    /* renamed from: h  reason: collision with root package name */
    public ByteArrayOutputStream f52131h;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Longan$for  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cfor {

        /* renamed from: a  reason: collision with root package name */
        public final String f52135a;

        /* renamed from: b  reason: collision with root package name */
        public final String f52136b;

        /* renamed from: c  reason: collision with root package name */
        public final long f52137c;

        public Cfor(String str, String str2, long j4) {
            this.f52135a = str;
            this.f52136b = str2;
            this.f52137c = j4;
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Longan$if  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cif {

        /* renamed from: a  reason: collision with root package name */
        public final String f52138a;

        /* renamed from: b  reason: collision with root package name */
        public final String f52139b;

        public Cif(String str, Integer num, String str2, String str3) {
            this.f52138a = str2;
            this.f52139b = str3;
        }
    }

    public Longan(String str) throws IllegalArgumentException, FileNotFoundException, IOException, InterruptedException {
        boolean z3;
        Object obj = new Object();
        this.f52124a = obj;
        this.f52125b = new Object();
        this.f52130g = new ByteArrayOutputStream();
        this.f52131h = new ByteArrayOutputStream();
        if (str != null && str.length() != 0) {
            if (str.startsWith(TTPathConst.sSeparator) && !new File(str).exists()) {
                throw new FileNotFoundException();
            }
            this.f52126c = Runtime.getRuntime().exec(str);
            synchronized (obj) {
                obj.wait(10L);
            }
            try {
                this.f52126c.exitValue();
                z3 = true;
            } catch (Exception unused) {
                z3 = false;
            }
            if (!z3) {
                this.f52127d = new DataOutputStream(this.f52126c.getOutputStream());
                this.f52128e = new Cdo("s", this.f52126c.getInputStream(), this.f52130g);
                this.f52129f = new Cdo("e", this.f52126c.getErrorStream(), this.f52131h);
                synchronized (this.f52124a) {
                    this.f52124a.wait(10L);
                }
                this.f52128e.start();
                this.f52129f.start();
                return;
            }
            throw new IOException();
        }
        throw new IllegalArgumentException();
    }

    public final Cif a(Cfor cfor, long j4) throws InterruptedException {
        boolean z3;
        synchronized (this.f52124a) {
            synchronized (this.f52125b) {
                int i4 = 1;
                z3 = new String(this.f52130g.toByteArray()).lastIndexOf(":RET=") == -1;
            }
            if (z3) {
                this.f52124a.wait(j4);
            }
        }
        synchronized (this.f52125b) {
            byte[] byteArray = this.f52130g.toByteArray();
            byte[] byteArray2 = this.f52131h.toByteArray();
            String str = new String(byteArray);
            String str2 = new String(byteArray2);
            if (str.lastIndexOf(":RET=") != -1) {
                this.f52130g.reset();
                this.f52131h.reset();
                if (str.lastIndexOf(":RET=0") != -1) {
                    return new Cif(cfor.f52135a, 0, str.substring(0, str.lastIndexOf(":RET=")), str2);
                }
                return new Cif(cfor.f52135a, Integer.valueOf((str.lastIndexOf(":RET=EOF") == -1 && str2.lastIndexOf(":RET=EOF") == -1) ? 2 : 2), str.substring(0, str.lastIndexOf(":RET=")), str2);
            }
            return null;
        }
    }

    public void finalize() throws Throwable {
        try {
            a();
        } catch (Throwable unused) {
        }
        super.finalize();
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Longan$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo extends Thread {

        /* renamed from: c  reason: collision with root package name */
        public InputStream f52132c;

        /* renamed from: d  reason: collision with root package name */
        public ByteArrayOutputStream f52133d;

        public Cdo(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            this.f52132c = inputStream;
            this.f52133d = byteArrayOutputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = this.f52132c.read(bArr);
                    if (read < 0) {
                        synchronized (Longan.this.f52125b) {
                            this.f52133d.write(":RET=EOF".getBytes());
                            this.f52133d.flush();
                        }
                        synchronized (Longan.this.f52124a) {
                            Longan.this.f52124a.notifyAll();
                        }
                        return;
                    } else if (read > 0) {
                        synchronized (Longan.this.f52125b) {
                            this.f52133d.write(bArr, 0, read);
                            this.f52133d.flush();
                        }
                        synchronized (Longan.this.f52124a) {
                            Longan.this.f52124a.notifyAll();
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a() {
        try {
            this.f52127d.write("exit\n".getBytes());
            this.f52127d.flush();
            this.f52126c.wait(100L);
        } catch (Exception unused) {
        }
        Cdo cdo = this.f52128e;
        if (cdo != null) {
            cdo.interrupt();
            this.f52128e = null;
        }
        Cdo cdo2 = this.f52129f;
        if (cdo2 != null) {
            cdo2.interrupt();
            this.f52129f = null;
        }
        Process process = this.f52126c;
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable unused2) {
            }
            this.f52126c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0028 A[Catch: all -> 0x0099, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000d, B:10:0x0011, B:16:0x001d, B:18:0x0025, B:19:0x0027, B:22:0x0033, B:23:0x0056, B:26:0x005f, B:27:0x0070, B:29:0x0076, B:32:0x0086, B:33:0x008d, B:34:0x008e, B:44:0x009c, B:45:0x00a3, B:24:0x0057, B:25:0x005e, B:20:0x0028, B:21:0x0032), top: B:51:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.tencent.turingfd.sdk.ams.au.Longan.Cif a(com.tencent.turingfd.sdk.ams.au.Longan.Cfor r11) throws java.lang.IllegalArgumentException, java.io.IOException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r10 = this;
            monitor-enter(r10)
            if (r11 == 0) goto L9c
            java.lang.String r0 = r11.f52135a     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto L1a
            int r0 = r0.length()     // Catch: java.lang.Throwable -> La4
            if (r0 <= 0) goto L1a
            java.lang.String r0 = r11.f52136b     // Catch: java.lang.Throwable -> La4
            if (r0 == 0) goto L1a
            int r0 = r0.length()     // Catch: java.lang.Throwable -> La4
            if (r0 > 0) goto L18
            goto L1a
        L18:
            r0 = 0
            goto L1b
        L1a:
            r0 = 1
        L1b:
            if (r0 != 0) goto L9c
            long r0 = r11.f52137c     // Catch: java.lang.Throwable -> La4
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L9c
            java.lang.Object r0 = r10.f52125b     // Catch: java.lang.Throwable -> La4
            monitor-enter(r0)     // Catch: java.lang.Throwable -> La4
            java.io.ByteArrayOutputStream r1 = r10.f52130g     // Catch: java.lang.Throwable -> L99
            r1.reset()     // Catch: java.lang.Throwable -> L99
            java.io.ByteArrayOutputStream r1 = r10.f52131h     // Catch: java.lang.Throwable -> L99
            r1.reset()     // Catch: java.lang.Throwable -> L99
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
            r0.<init>()     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = r11.f52136b     // Catch: java.lang.Throwable -> La4
            r0.append(r1)     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = "\n"
            r0.append(r1)     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La4
            java.io.DataOutputStream r1 = r10.f52127d     // Catch: java.lang.Throwable -> La4
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> La4
            r1.write(r0)     // Catch: java.lang.Throwable -> La4
            java.io.DataOutputStream r0 = r10.f52127d     // Catch: java.lang.Throwable -> La4
            r0.flush()     // Catch: java.lang.Throwable -> La4
            java.lang.Object r0 = r10.f52124a     // Catch: java.lang.Throwable -> La4
            monitor-enter(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.Object r1 = r10.f52124a     // Catch: java.lang.Throwable -> L96
            r4 = 10
            r1.wait(r4)     // Catch: java.lang.Throwable -> L96
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            java.io.DataOutputStream r0 = r10.f52127d     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = "echo :RET=$?\n"
            r0.writeBytes(r1)     // Catch: java.lang.Throwable -> La4
            java.io.DataOutputStream r0 = r10.f52127d     // Catch: java.lang.Throwable -> La4
            r0.flush()     // Catch: java.lang.Throwable -> La4
            long r0 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> La4
            r4 = r2
        L70:
            long r6 = r11.f52137c     // Catch: java.lang.Throwable -> La4
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 == 0) goto L8e
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> La4
            long r4 = r4 - r0
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 / r8
            long r4 = r6 - r4
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L86
            goto L8e
        L86:
            java.util.concurrent.TimeoutException r11 = new java.util.concurrent.TimeoutException     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = "t"
            r11.<init>(r0)     // Catch: java.lang.Throwable -> La4
            throw r11     // Catch: java.lang.Throwable -> La4
        L8e:
            com.tencent.turingfd.sdk.ams.au.Longan$if r6 = r10.a(r11, r4)     // Catch: java.lang.Throwable -> La4
            if (r6 == 0) goto L70
            monitor-exit(r10)
            return r6
        L96:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            throw r11     // Catch: java.lang.Throwable -> La4
        L99:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            throw r11     // Catch: java.lang.Throwable -> La4
        L9c:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = "v"
            r11.<init>(r0)     // Catch: java.lang.Throwable -> La4
            throw r11     // Catch: java.lang.Throwable -> La4
        La4:
            r11 = move-exception
            monitor-exit(r10)
            goto La8
        La7:
            throw r11
        La8:
            goto La7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Longan.a(com.tencent.turingfd.sdk.ams.au.Longan$for):com.tencent.turingfd.sdk.ams.au.Longan$if");
    }
}
