package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import androidx.collection.LruCache;
import cn.bluemobi.dylan.base.utils.ImageSizeUtil;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ImageLoader {

    /* renamed from: k */
    private static ImageLoader f1757k = null;

    /* renamed from: l */
    private static final int f1758l = 1;

    /* renamed from: m */
    private static final String f1759m = "ImageLoader";

    /* renamed from: a */
    private LruCache<String, Bitmap> f1760a;

    /* renamed from: b */
    private ExecutorService f1761b;

    /* renamed from: d */
    private LinkedList<Runnable> f1763d;

    /* renamed from: e */
    private Thread f1764e;

    /* renamed from: f */
    private Handler f1765f;

    /* renamed from: g */
    private Handler f1766g;

    /* renamed from: i */
    private Semaphore f1768i;

    /* renamed from: c */
    private Type f1762c = Type.LIFO;

    /* renamed from: h */
    private Semaphore f1767h = new Semaphore(0);

    /* renamed from: j */
    private boolean f1769j = true;

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum Type {
        FIFO,
        LIFO
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bluemobi.dylan.base.utils.ImageLoader$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1130a extends LruCache<String, Bitmap> {
        C1130a(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bluemobi.dylan.base.utils.ImageLoader$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1131b extends Thread {

        /* renamed from: cn.bluemobi.dylan.base.utils.ImageLoader$b$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        class HandlerC1132a extends Handler {
            HandlerC1132a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ImageLoader.this.f1761b.execute(ImageLoader.this.m57800r());
                try {
                    ImageLoader.this.f1768i.acquire();
                } catch (InterruptedException unused) {
                }
            }
        }

        C1131b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            ImageLoader.this.f1765f = new HandlerC1132a();
            ImageLoader.this.f1767h.release();
            Looper.loop();
        }
    }

    /* renamed from: cn.bluemobi.dylan.base.utils.ImageLoader$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class HandlerC1133c extends Handler {
        HandlerC1133c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1135e c1135e = (C1135e) message.obj;
            Bitmap bitmap = c1135e.f1778a;
            ImageView imageView = c1135e.f1779b;
            if (imageView.getTag().toString().equals(c1135e.f1780c)) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bluemobi.dylan.base.utils.ImageLoader$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC1134d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f1774a;

        /* renamed from: b */
        final /* synthetic */ ImageView f1775b;

        /* renamed from: c */
        final /* synthetic */ String f1776c;

        RunnableC1134d(boolean z, ImageView imageView, String str) {
            this.f1774a = z;
            this.f1775b = imageView;
            this.f1776c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap m57796v;
            if (this.f1774a) {
                File m57803o = ImageLoader.this.m57803o(this.f1775b.getContext(), ImageLoader.this.m57795w(this.f1776c));
                if (m57803o.exists()) {
                    Log.e("ImageLoader", "find image :" + this.f1776c + " in disk cache .");
                    m57796v = ImageLoader.this.m57796v(m57803o.getAbsolutePath(), this.f1775b);
                } else if (ImageLoader.this.f1769j) {
                    if (DownloadImgUtils.m57754c(this.f1776c, m57803o)) {
                        Log.e("ImageLoader", "download image :" + this.f1776c + " to disk cache . path is " + m57803o.getAbsolutePath());
                        m57796v = ImageLoader.this.m57796v(m57803o.getAbsolutePath(), this.f1775b);
                    } else {
                        m57796v = null;
                    }
                } else {
                    Log.e("ImageLoader", "load image :" + this.f1776c + " to memory.");
                    m57796v = DownloadImgUtils.m57755b(this.f1776c, this.f1775b);
                }
            } else {
                m57796v = ImageLoader.this.m57796v(this.f1776c, this.f1775b);
            }
            ImageLoader.this.m57809i(this.f1776c, m57796v);
            ImageLoader.this.m57794x(this.f1776c, this.f1775b, m57796v);
            ImageLoader.this.f1768i.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.bluemobi.dylan.base.utils.ImageLoader$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1135e {

        /* renamed from: a */
        Bitmap f1778a;

        /* renamed from: b */
        ImageView f1779b;

        /* renamed from: c */
        String f1780c;

        private C1135e() {
        }

        /* synthetic */ C1135e(ImageLoader imageLoader, C1130a c1130a) {
            this();
        }
    }

    private ImageLoader(int i, Type type) {
        m57799s(i, type);
    }

    /* renamed from: j */
    private synchronized void m57808j(Runnable runnable) {
        this.f1763d.add(runnable);
        try {
            if (this.f1765f == null) {
                this.f1767h.acquire();
            }
        } catch (InterruptedException unused) {
        }
        this.f1765f.sendEmptyMessage(272);
    }

    /* renamed from: k */
    private Runnable m57807k(String str, ImageView imageView, boolean z) {
        return new RunnableC1134d(z, imageView, str);
    }

    /* renamed from: n */
    private Bitmap m57804n(String str) {
        return this.f1760a.get(str);
    }

    /* renamed from: p */
    public static ImageLoader m57802p() {
        if (f1757k == null) {
            synchronized (ImageLoader.class) {
                if (f1757k == null) {
                    f1757k = new ImageLoader(1, Type.LIFO);
                }
            }
        }
        return f1757k;
    }

    /* renamed from: q */
    public static ImageLoader m57801q(int i, Type type) {
        if (f1757k == null) {
            synchronized (ImageLoader.class) {
                if (f1757k == null) {
                    f1757k = new ImageLoader(i, type);
                }
            }
        }
        return f1757k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public Runnable m57800r() {
        Type type = this.f1762c;
        if (type == Type.FIFO) {
            return this.f1763d.removeFirst();
        }
        if (type == Type.LIFO) {
            return this.f1763d.removeLast();
        }
        return null;
    }

    /* renamed from: s */
    private void m57799s(int i, Type type) {
        m57798t();
        this.f1760a = new C1130a(((int) Runtime.getRuntime().maxMemory()) / 8);
        this.f1761b = Executors.newFixedThreadPool(i);
        this.f1763d = new LinkedList<>();
        this.f1762c = type;
        this.f1768i = new Semaphore(i);
    }

    /* renamed from: t */
    private void m57798t() {
        C1131b c1131b = new C1131b();
        this.f1764e = c1131b;
        c1131b.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public Bitmap m57796v(String str, ImageView imageView) {
        ImageSizeUtil.C1139a m57738c = ImageSizeUtil.m57738c(imageView);
        return m57805m(str, m57738c.f1809a, m57738c.f1810b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m57794x(String str, ImageView imageView, Bitmap bitmap) {
        Message obtain = Message.obtain();
        C1135e c1135e = new C1135e(this, null);
        c1135e.f1778a = bitmap;
        c1135e.f1780c = str;
        c1135e.f1779b = imageView;
        obtain.obj = c1135e;
        this.f1766g.sendMessage(obtain);
    }

    /* renamed from: i */
    protected void m57809i(String str, Bitmap bitmap) {
        if (m57804n(str) != null || bitmap == null) {
            return;
        }
        this.f1760a.put(str, bitmap);
    }

    /* renamed from: l */
    public String m57806l(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.f41242c);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: m */
    protected Bitmap m57805m(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = ImageSizeUtil.m57740a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    /* renamed from: o */
    public File m57803o(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }

    /* renamed from: u */
    public void m57797u(String str, ImageView imageView, boolean z) {
        imageView.setTag(str);
        if (this.f1766g == null) {
            this.f1766g = new HandlerC1133c();
        }
        Bitmap m57804n = m57804n(str);
        if (m57804n != null) {
            m57794x(str, imageView, m57804n);
        } else {
            m57808j(m57807k(str, imageView, z));
        }
    }

    /* renamed from: w */
    public String m57795w(String str) {
        try {
            return m57806l(MessageDigest.getInstance("md5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
