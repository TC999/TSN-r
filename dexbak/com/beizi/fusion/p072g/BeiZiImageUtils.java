package com.beizi.fusion.p072g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.beizi.fusion.g.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiImageUtils {

    /* renamed from: a */
    private static Context f11366a;

    /* renamed from: e */
    private static BeiZiImageUtils f11367e;

    /* renamed from: b */
    private ExecutorService f11368b = Executors.newFixedThreadPool(4);

    /* renamed from: c */
    private LruCache<String, Bitmap> f11369c = new LruCache<>(4194304);

    /* renamed from: d */
    private Handler f11370d = new Handler();

    /* compiled from: BeiZiImageUtils.java */
    /* renamed from: com.beizi.fusion.g.i$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3151a {
        /* renamed from: a */
        void mo47232a();

        /* renamed from: a */
        void mo47231a(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static String m48248c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return m48254a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static BeiZiImageUtils m48258a(Context context) {
        if (context == null) {
            C3138av.m48297b("Illegal Argument: context is null");
        } else {
            f11366a = context;
        }
        return m48253b();
    }

    /* renamed from: b */
    private static BeiZiImageUtils m48253b() {
        if (f11367e == null) {
            synchronized (BeiZiImageUtils.class) {
                if (f11367e == null) {
                    f11367e = new BeiZiImageUtils();
                }
            }
        }
        return f11367e;
    }

    /* renamed from: a */
    public RunnableC3152b m48256a(String str) {
        return new RunnableC3152b(str);
    }

    /* renamed from: a */
    public void m48255a(final String str, final InterfaceC3151a interfaceC3151a) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f11369c.get(str);
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            interfaceC3151a.mo47231a(bitmap);
            return;
        }
        File file = new File(BeiZiStorageUtils.m48243b(f11366a), m48248c(str.substring(str.lastIndexOf("/") + 1)));
        if (file.exists() && file.length() > 0) {
            bitmap2 = BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        if (bitmap2 != null) {
            this.f11369c.put(str, bitmap2);
            interfaceC3151a.mo47231a(bitmap2);
            return;
        }
        this.f11368b.submit(new Runnable() { // from class: com.beizi.fusion.g.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    if (httpURLConnection.getResponseCode() == 200) {
                        final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                        httpURLConnection.disconnect();
                        BeiZiImageUtils.this.f11370d.post(new Runnable() { // from class: com.beizi.fusion.g.i.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                interfaceC3151a.mo47231a(decodeStream);
                            }
                        });
                        BeiZiImageUtils.this.f11369c.put(str, decodeStream);
                        String str2 = str;
                        decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(BeiZiStorageUtils.m48243b(BeiZiImageUtils.f11366a), BeiZiImageUtils.m48248c(str2.substring(str2.lastIndexOf("/") + 1)))));
                    }
                } catch (Exception unused) {
                    BeiZiImageUtils.this.f11370d.post(new Runnable() { // from class: com.beizi.fusion.g.i.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            interfaceC3151a.mo47232a();
                        }
                    });
                }
            }
        });
    }

    /* compiled from: BeiZiImageUtils.java */
    /* renamed from: com.beizi.fusion.g.i$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC3152b implements Runnable {

        /* renamed from: a */
        String f11381a;

        /* renamed from: b */
        ImageView f11382b;

        public RunnableC3152b(String str) {
            this.f11381a = str;
        }

        /* renamed from: b */
        private void m48245b() {
            BeiZiImageUtils.this.f11370d.post(new Runnable() { // from class: com.beizi.fusion.g.i.b.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }

        /* renamed from: a */
        public void m48246a(ImageView imageView) {
            this.f11382b = imageView;
            if (TextUtils.isEmpty(this.f11381a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) BeiZiImageUtils.this.f11369c.get(this.f11381a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap m48247a = m48247a();
            if (m48247a == null) {
                BeiZiImageUtils.this.f11368b.submit(this);
                return;
            }
            imageView.setImageBitmap(m48247a);
            BeiZiImageUtils.this.f11369c.put(this.f11381a, m48247a);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f11381a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() == 200) {
                    final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    BeiZiImageUtils.this.f11370d.post(new Runnable() { // from class: com.beizi.fusion.g.i.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RunnableC3152b.this.f11382b.setImageBitmap(decodeStream);
                        }
                    });
                    BeiZiImageUtils.this.f11369c.put(this.f11381a, decodeStream);
                    String str = this.f11381a;
                    File file = new File(BeiZiStorageUtils.m48243b(BeiZiImageUtils.f11366a), BeiZiImageUtils.m48248c(str.substring(str.lastIndexOf("/") + 1)));
                    C3116af.m48496a("BeiZis", "BeiZiImageUtils run file == " + file);
                    decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
                } else {
                    m48245b();
                }
            } catch (FileNotFoundException unused) {
            } catch (Exception e) {
                e.printStackTrace();
                m48245b();
            }
        }

        /* renamed from: a */
        private Bitmap m48247a() {
            String str = this.f11381a;
            File file = new File(BeiZiStorageUtils.m48243b(BeiZiImageUtils.f11366a), BeiZiImageUtils.m48248c(str.substring(str.lastIndexOf("/") + 1)));
            C3116af.m48496a("BeiZis", "BeiZiImageUtils getBitmapFile file == " + file);
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
    }

    /* renamed from: b */
    public void m48250b(final String str, final InterfaceC3151a interfaceC3151a) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f11369c.get(str);
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            interfaceC3151a.mo47231a(bitmap);
            return;
        }
        File file = new File(BeiZiStorageUtils.m48243b(f11366a), m48248c(str.substring(str.lastIndexOf("/") + 1)));
        if (file.exists() && file.length() > 0) {
            bitmap2 = BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        if (bitmap2 != null) {
            this.f11369c.put(str, bitmap2);
            interfaceC3151a.mo47231a(bitmap2);
            return;
        }
        this.f11368b.submit(new Runnable() { // from class: com.beizi.fusion.g.i.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    if (httpURLConnection.getResponseCode() == 200) {
                        Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                        httpURLConnection.disconnect();
                        BeiZiImageUtils.this.f11369c.put(str, decodeStream);
                        String str2 = str;
                        decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(BeiZiStorageUtils.m48243b(BeiZiImageUtils.f11366a), BeiZiImageUtils.m48248c(str2.substring(str2.lastIndexOf("/") + 1)))));
                    }
                } catch (Exception unused) {
                    BeiZiImageUtils.this.f11370d.post(new Runnable() { // from class: com.beizi.fusion.g.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            interfaceC3151a.mo47232a();
                        }
                    });
                }
            }
        });
    }

    /* renamed from: a */
    private static String m48254a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            int i = (b >>> 4) & 15;
            int i2 = 0;
            while (true) {
                sb.append((char) ((i < 0 || i > 9) ? (i - 10) + 97 : i + 48));
                i = b & 15;
                int i3 = i2 + 1;
                if (i2 >= 1) {
                    break;
                }
                i2 = i3;
            }
        }
        return sb.toString();
    }
}
