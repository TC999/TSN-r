package com.acse.ottn.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class sa {

    /* renamed from: a  reason: collision with root package name */
    private static sa f6870a;

    /* renamed from: b  reason: collision with root package name */
    private static String f6871b;

    /* renamed from: c  reason: collision with root package name */
    private a f6872c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f6873d;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Process f6874a;

        /* renamed from: b  reason: collision with root package name */
        private BufferedReader f6875b = null;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6876c = true;

        /* renamed from: d  reason: collision with root package name */
        String f6877d;

        /* renamed from: e  reason: collision with root package name */
        private String f6878e;

        /* renamed from: f  reason: collision with root package name */
        private FileOutputStream f6879f;

        public a(String str, String str2) {
            this.f6877d = null;
            this.f6879f = null;
            this.f6878e = str;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("log-");
                sb.append(sa.this.a());
                sb.append(".log");
                this.f6879f = new FileOutputStream(new File(str2, sb.toString()));
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
            }
            this.f6877d = "logcat | grep \"(" + this.f6878e + ")\"";
        }

        public void a() {
            this.f6876c = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            String readLine;
            try {
                try {
                    this.f6874a = Runtime.getRuntime().exec(this.f6877d);
                    this.f6875b = new BufferedReader(new InputStreamReader(this.f6874a.getInputStream()), 1024);
                    while (this.f6876c && (readLine = this.f6875b.readLine()) != null && this.f6876c) {
                        if (readLine.length() != 0 && this.f6879f != null && readLine.contains(this.f6878e)) {
                            FileOutputStream fileOutputStream2 = this.f6879f;
                            StringBuilder sb = new StringBuilder();
                            sb.append(readLine);
                            sb.append("\n");
                            fileOutputStream2.write(sb.toString().getBytes());
                        }
                    }
                    Process process = this.f6874a;
                    if (process != null) {
                        process.destroy();
                        this.f6874a = null;
                    }
                    BufferedReader bufferedReader = this.f6875b;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            this.f6875b = null;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    fileOutputStream = this.f6879f;
                    if (fileOutputStream == null) {
                        return;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                    Process process2 = this.f6874a;
                    if (process2 != null) {
                        process2.destroy();
                        this.f6874a = null;
                    }
                    BufferedReader bufferedReader2 = this.f6875b;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            this.f6875b = null;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    fileOutputStream = this.f6879f;
                    if (fileOutputStream == null) {
                        return;
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                this.f6879f = null;
            } catch (Throwable th) {
                Process process3 = this.f6874a;
                if (process3 != null) {
                    process3.destroy();
                    this.f6874a = null;
                }
                BufferedReader bufferedReader3 = this.f6875b;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        this.f6875b = null;
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                FileOutputStream fileOutputStream3 = this.f6879f;
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                    this.f6879f = null;
                }
                throw th;
            }
        }
    }

    private sa(Context context) {
        b(context);
        this.f6873d = Process.myPid();
    }

    public static sa a(Context context) {
        if (f6870a == null) {
            f6870a = new sa(context);
        }
        return f6870a;
    }

    public String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public void b() {
        if (this.f6872c == null) {
            this.f6872c = new a(String.valueOf(this.f6873d), f6871b);
        }
        this.f6872c.start();
    }

    public void b(Context context) {
        f6871b = context.getExternalFilesDir("log").getAbsoluteFile().getPath() + "/log";
        File file = new File(f6871b);
        Log.i("codedzh", "\u5b58\u50a8\u4f4d\u7f6e\uff1a" + f6871b);
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.i("codedzh", "\u6587\u4ef6\u662f\u5426\u5b58\u5728\uff1a" + new File(f6871b).exists());
    }

    public void c() {
        a aVar = this.f6872c;
        if (aVar != null) {
            aVar.a();
            this.f6872c = null;
        }
    }
}
