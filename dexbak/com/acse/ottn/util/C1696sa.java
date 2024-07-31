package com.acse.ottn.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.acse.ottn.util.sa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1696sa {

    /* renamed from: a */
    private static C1696sa f3360a;

    /* renamed from: b */
    private static String f3361b;

    /* renamed from: c */
    private C1697a f3362c = null;

    /* renamed from: d */
    private int f3363d;

    /* renamed from: com.acse.ottn.util.sa$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1697a extends Thread {

        /* renamed from: a */
        private Process f3364a;

        /* renamed from: b */
        private BufferedReader f3365b = null;

        /* renamed from: c */
        private boolean f3366c = true;

        /* renamed from: d */
        String f3367d;

        /* renamed from: e */
        private String f3368e;

        /* renamed from: f */
        private FileOutputStream f3369f;

        public C1697a(String str, String str2) {
            this.f3367d = null;
            this.f3369f = null;
            this.f3368e = str;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("log-");
                sb.append(C1696sa.this.m55912a());
                sb.append(".log");
                this.f3369f = new FileOutputStream(new File(str2, sb.toString()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.f3367d = "logcat | grep \"(" + this.f3368e + ")\"";
        }

        /* renamed from: a */
        public void m55907a() {
            this.f3366c = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            String readLine;
            try {
                try {
                    this.f3364a = Runtime.getRuntime().exec(this.f3367d);
                    this.f3365b = new BufferedReader(new InputStreamReader(this.f3364a.getInputStream()), 1024);
                    while (this.f3366c && (readLine = this.f3365b.readLine()) != null && this.f3366c) {
                        if (readLine.length() != 0 && this.f3369f != null && readLine.contains(this.f3368e)) {
                            FileOutputStream fileOutputStream2 = this.f3369f;
                            StringBuilder sb = new StringBuilder();
                            sb.append(readLine);
                            sb.append(ShellAdbUtils.f33810d);
                            fileOutputStream2.write(sb.toString().getBytes());
                        }
                    }
                    Process process = this.f3364a;
                    if (process != null) {
                        process.destroy();
                        this.f3364a = null;
                    }
                    BufferedReader bufferedReader = this.f3365b;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            this.f3365b = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    fileOutputStream = this.f3369f;
                    if (fileOutputStream == null) {
                        return;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    Process process2 = this.f3364a;
                    if (process2 != null) {
                        process2.destroy();
                        this.f3364a = null;
                    }
                    BufferedReader bufferedReader2 = this.f3365b;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            this.f3365b = null;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    fileOutputStream = this.f3369f;
                    if (fileOutputStream == null) {
                        return;
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                this.f3369f = null;
            } catch (Throwable th) {
                Process process3 = this.f3364a;
                if (process3 != null) {
                    process3.destroy();
                    this.f3364a = null;
                }
                BufferedReader bufferedReader3 = this.f3365b;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        this.f3365b = null;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                FileOutputStream fileOutputStream3 = this.f3369f;
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    this.f3369f = null;
                }
                throw th;
            }
        }
    }

    private C1696sa(Context context) {
        m55909b(context);
        this.f3363d = Process.myPid();
    }

    /* renamed from: a */
    public static C1696sa m55911a(Context context) {
        if (f3360a == null) {
            f3360a = new C1696sa(context);
        }
        return f3360a;
    }

    /* renamed from: a */
    public String m55912a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: b */
    public void m55910b() {
        if (this.f3362c == null) {
            this.f3362c = new C1697a(String.valueOf(this.f3363d), f3361b);
        }
        this.f3362c.start();
    }

    /* renamed from: b */
    public void m55909b(Context context) {
        f3361b = context.getExternalFilesDir("log").getAbsoluteFile().getPath() + "/log";
        File file = new File(f3361b);
        Log.i("codedzh", "存储位置：" + f3361b);
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.i("codedzh", "文件是否存在：" + new File(f3361b).exists());
    }

    /* renamed from: c */
    public void m55908c() {
        C1697a c1697a = this.f3362c;
        if (c1697a != null) {
            c1697a.m55907a();
            this.f3362c = null;
        }
    }
}
