package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13053c {

    /* renamed from: c */
    private static String f37414c;

    /* renamed from: a */
    private String f37415a;

    /* renamed from: b */
    private InterfaceC13056d f37416b;

    /* renamed from: d */
    private long f37417d;

    /* renamed from: e */
    private Handler f37418e;

    /* renamed from: f */
    private WeakReference<Activity> f37419f;

    /* renamed from: g */
    private Runnable f37420g = new Runnable() { // from class: com.tencent.open.utils.c.2
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            SLog.m15123v("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + C13071m.m14924g(C13053c.this.f37415a) + ".jpg";
            String str2 = C13053c.f37414c + str;
            File file = new File(str2);
            Message obtainMessage = C13053c.this.f37418e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                SLog.m15123v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - C13053c.this.f37417d));
            } else {
                Bitmap m15044a = C13053c.m15044a(C13053c.this.f37415a);
                if (m15044a != null) {
                    z = C13053c.this.m15046a(m15044a, str);
                } else {
                    SLog.m15123v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                SLog.m15123v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - C13053c.this.f37417d));
            }
            C13053c.this.f37418e.sendMessage(obtainMessage);
        }
    };

    public C13053c(Activity activity) {
        this.f37419f = new WeakReference<>(activity);
        this.f37418e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                SLog.m15123v("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    C13053c.this.f37416b.mo15039a(message.arg1, (String) message.obj);
                } else {
                    C13053c.this.f37416b.mo15039a(message.arg1, (String) null);
                }
            }
        };
    }

    /* renamed from: a */
    public void m15043a(String str, InterfaceC13056d interfaceC13056d) {
        SLog.m15123v("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!C13071m.m14971a()) {
                interfaceC13056d.mo15039a(2, (String) null);
                return;
            }
            if (this.f37419f.get() != null) {
                Activity activity = this.f37419f.get();
                File m14923h = C13071m.m14923h(activity, "Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (m14923h == null) {
                    SLog.m15129e("AsynLoadImg", "externalImageFile is null");
                    interfaceC13056d.mo15039a(2, (String) null);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(C13066k.m14982d(activity) ? m14923h.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                sb.append("/tmp/");
                f37414c = sb.toString();
            }
            this.f37417d = System.currentTimeMillis();
            this.f37415a = str;
            this.f37416b = interfaceC13056d;
            new Thread(this.f37420g).start();
            return;
        }
        interfaceC13056d.mo15039a(1, (String) null);
    }

    /* renamed from: a */
    public boolean m15046a(Bitmap bitmap, String str) {
        String str2 = f37414c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                SLog.m15123v("AsynLoadImg", "saveFile:" + str);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    SLog.m15128e("AsynLoadImg", "saveFile bmp fail---", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    /* renamed from: a */
    public static Bitmap m15044a(String str) {
        SLog.m15123v("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            SLog.m15123v("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            SLog.m15123v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            SLog.m15123v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
