package com.beizi.fusion.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiImageUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static Context f14921a;

    /* renamed from: e  reason: collision with root package name */
    private static i f14922e;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f14923b = Executors.newFixedThreadPool(4);

    /* renamed from: c  reason: collision with root package name */
    private LruCache<String, Bitmap> f14924c = new LruCache<>(4194304);

    /* renamed from: d  reason: collision with root package name */
    private Handler f14925d = new Handler();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BeiZiImageUtils.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static i a(Context context) {
        if (context == null) {
            aw.b("Illegal Argument: context is null");
        } else {
            f14921a = context;
        }
        return b();
    }

    private static i b() {
        if (f14922e == null) {
            synchronized (i.class) {
                if (f14922e == null) {
                    f14922e = new i();
                }
            }
        }
        return f14922e;
    }

    public b a(String str) {
        return new b(str);
    }

    public void a(final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f14924c.get(str);
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            aVar.a(bitmap);
            return;
        }
        File file = new File(j.b(f14921a), c(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
        if (file.exists() && file.length() > 0) {
            bitmap2 = BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        if (bitmap2 != null) {
            this.f14924c.put(str, bitmap2);
            aVar.a(bitmap2);
            return;
        }
        this.f14923b.submit(new Runnable() { // from class: com.beizi.fusion.g.i.1
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
                        i.this.f14925d.post(new Runnable() { // from class: com.beizi.fusion.g.i.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a(decodeStream);
                            }
                        });
                        i.this.f14924c.put(str, decodeStream);
                        String str2 = str;
                        decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(j.b(i.f14921a), i.c(str2.substring(str2.lastIndexOf(TTPathConst.sSeparator) + 1)))));
                    }
                } catch (Exception unused) {
                    i.this.f14925d.post(new Runnable() { // from class: com.beizi.fusion.g.i.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BeiZiImageUtils.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f14936a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f14937b;

        public b(String str) {
            this.f14936a = str;
        }

        private void b() {
            i.this.f14925d.post(new Runnable() { // from class: com.beizi.fusion.g.i.b.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }

        public void a(ImageView imageView) {
            this.f14937b = imageView;
            if (TextUtils.isEmpty(this.f14936a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) i.this.f14924c.get(this.f14936a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap a4 = a();
            if (a4 == null) {
                i.this.f14923b.submit(this);
                return;
            }
            imageView.setImageBitmap(a4);
            i.this.f14924c.put(this.f14936a, a4);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f14936a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() == 200) {
                    final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    i.this.f14925d.post(new Runnable() { // from class: com.beizi.fusion.g.i.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.f14937b.setImageBitmap(decodeStream);
                        }
                    });
                    i.this.f14924c.put(this.f14936a, decodeStream);
                    String str = this.f14936a;
                    File file = new File(j.b(i.f14921a), i.c(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
                    af.a("BeiZis", "BeiZiImageUtils run file == " + file);
                    decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
                } else {
                    b();
                }
            } catch (FileNotFoundException unused) {
            } catch (Exception e4) {
                e4.printStackTrace();
                b();
            }
        }

        private Bitmap a() {
            String str = this.f14936a;
            File file = new File(j.b(i.f14921a), i.c(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
            af.a("BeiZis", "BeiZiImageUtils getBitmapFile file == " + file);
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
    }

    public void b(final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f14924c.get(str);
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            aVar.a(bitmap);
            return;
        }
        File file = new File(j.b(f14921a), c(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
        if (file.exists() && file.length() > 0) {
            bitmap2 = BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        if (bitmap2 != null) {
            this.f14924c.put(str, bitmap2);
            aVar.a(bitmap2);
            return;
        }
        this.f14923b.submit(new Runnable() { // from class: com.beizi.fusion.g.i.2
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
                        i.this.f14924c.put(str, decodeStream);
                        String str2 = str;
                        decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(j.b(i.f14921a), i.c(str2.substring(str2.lastIndexOf(TTPathConst.sSeparator) + 1)))));
                    }
                } catch (Exception unused) {
                    i.this.f14925d.post(new Runnable() { // from class: com.beizi.fusion.g.i.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            }
        });
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b4 : bArr) {
            int i4 = (b4 >>> 4) & 15;
            int i5 = 0;
            while (true) {
                sb.append((char) ((i4 < 0 || i4 > 9) ? (i4 - 10) + 97 : i4 + 48));
                i4 = b4 & 15;
                int i6 = i5 + 1;
                if (i5 >= 1) {
                    break;
                }
                i5 = i6;
            }
        }
        return sb.toString();
    }
}
