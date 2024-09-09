package com.acse.ottn;

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

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b2 {

    /* renamed from: c  reason: collision with root package name */
    public static b2 f5192c;

    /* renamed from: d  reason: collision with root package name */
    public static String f5193d;

    /* renamed from: a  reason: collision with root package name */
    public a f5194a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f5195b;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public Process f5196a;

        /* renamed from: b  reason: collision with root package name */
        public BufferedReader f5197b = null;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5198c = true;

        /* renamed from: d  reason: collision with root package name */
        public String f5199d;

        /* renamed from: e  reason: collision with root package name */
        public String f5200e;

        /* renamed from: f  reason: collision with root package name */
        public FileOutputStream f5201f;

        public a(String str, String str2) {
            this.f5199d = null;
            this.f5201f = null;
            this.f5200e = str;
            try {
                this.f5201f = new FileOutputStream(new File(str2, "log-" + b2.this.a() + ".log"));
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
            }
            this.f5199d = "logcat | grep \"(" + this.f5200e + ")\"";
        }

        public void a() {
            this.f5198c = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            String readLine;
            try {
                try {
                    try {
                        this.f5196a = Runtime.getRuntime().exec(this.f5199d);
                        this.f5197b = new BufferedReader(new InputStreamReader(this.f5196a.getInputStream()), 1024);
                        while (this.f5198c && (readLine = this.f5197b.readLine()) != null && this.f5198c) {
                            if (readLine.length() != 0 && this.f5201f != null && readLine.contains(this.f5200e)) {
                                FileOutputStream fileOutputStream2 = this.f5201f;
                                fileOutputStream2.write((readLine + "\n").getBytes());
                            }
                        }
                        Process process = this.f5196a;
                        if (process != null) {
                            process.destroy();
                            this.f5196a = null;
                        }
                        BufferedReader bufferedReader = this.f5197b;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                this.f5197b = null;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        fileOutputStream = this.f5201f;
                    } catch (Throwable th) {
                        Process process2 = this.f5196a;
                        if (process2 != null) {
                            process2.destroy();
                            this.f5196a = null;
                        }
                        BufferedReader bufferedReader2 = this.f5197b;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                                this.f5197b = null;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        FileOutputStream fileOutputStream3 = this.f5201f;
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            this.f5201f = null;
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e7.printStackTrace();
                    Process process3 = this.f5196a;
                    if (process3 != null) {
                        process3.destroy();
                        this.f5196a = null;
                    }
                    BufferedReader bufferedReader3 = this.f5197b;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                            this.f5197b = null;
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    FileOutputStream fileOutputStream4 = this.f5201f;
                    if (fileOutputStream4 == null) {
                        return;
                    }
                    fileOutputStream4.close();
                }
            } catch (IOException e9) {
                e9.printStackTrace();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.f5201f = null;
            }
        }
    }

    public b2(Context context) {
        b(context);
        this.f5195b = Process.myPid();
    }

    public static b2 a(Context context) {
        if (f5192c == null) {
            f5192c = new b2(context);
        }
        return f5192c;
    }

    public void b(Context context) {
        f5193d = context.getExternalFilesDir("log").getAbsoluteFile().getPath() + "/log";
        File file = new File(f5193d);
        Log.i("codedzh", "\u5b58\u50a8\u4f4d\u7f6e\uff1a" + f5193d);
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.i("codedzh", "\u6587\u4ef6\u662f\u5426\u5b58\u5728\uff1a" + new File(f5193d).exists());
    }

    public void c() {
        a aVar = this.f5194a;
        if (aVar != null) {
            aVar.a();
            this.f5194a = null;
        }
    }

    public String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public void b() {
        if (this.f5194a == null) {
            this.f5194a = new a(String.valueOf(this.f5195b), f5193d);
        }
        this.f5194a.start();
    }
}
