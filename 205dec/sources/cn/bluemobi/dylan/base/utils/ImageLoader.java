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
import cn.bluemobi.dylan.base.utils.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ImageLoader {

    /* renamed from: k  reason: collision with root package name */
    private static ImageLoader f1743k = null;

    /* renamed from: l  reason: collision with root package name */
    private static final int f1744l = 1;

    /* renamed from: m  reason: collision with root package name */
    private static final String f1745m = "ImageLoader";

    /* renamed from: a  reason: collision with root package name */
    private LruCache<String, Bitmap> f1746a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f1747b;

    /* renamed from: d  reason: collision with root package name */
    private LinkedList<Runnable> f1749d;

    /* renamed from: e  reason: collision with root package name */
    private Thread f1750e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f1751f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f1752g;

    /* renamed from: i  reason: collision with root package name */
    private Semaphore f1754i;

    /* renamed from: c  reason: collision with root package name */
    private Type f1748c = Type.LIFO;

    /* renamed from: h  reason: collision with root package name */
    private Semaphore f1753h = new Semaphore(0);

    /* renamed from: j  reason: collision with root package name */
    private boolean f1755j = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public enum Type {
        FIFO,
        LIFO
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends LruCache<String, Bitmap> {
        a(int i4) {
            super(i4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b extends Thread {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ImageLoader.this.f1747b.execute(ImageLoader.this.r());
                try {
                    ImageLoader.this.f1754i.acquire();
                } catch (InterruptedException unused) {
                }
            }
        }

        b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            ImageLoader.this.f1751f = new a();
            ImageLoader.this.f1753h.release();
            Looper.loop();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            Bitmap bitmap = eVar.f1764a;
            ImageView imageView = eVar.f1765b;
            if (imageView.getTag().toString().equals(eVar.f1766c)) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f1760a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImageView f1761b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1762c;

        d(boolean z3, ImageView imageView, String str) {
            this.f1760a = z3;
            this.f1761b = imageView;
            this.f1762c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap v3;
            if (this.f1760a) {
                File o4 = ImageLoader.this.o(this.f1761b.getContext(), ImageLoader.this.w(this.f1762c));
                if (o4.exists()) {
                    Log.e("ImageLoader", "find image :" + this.f1762c + " in disk cache .");
                    v3 = ImageLoader.this.v(o4.getAbsolutePath(), this.f1761b);
                } else if (ImageLoader.this.f1755j) {
                    if (cn.bluemobi.dylan.base.utils.e.c(this.f1762c, o4)) {
                        Log.e("ImageLoader", "download image :" + this.f1762c + " to disk cache . path is " + o4.getAbsolutePath());
                        v3 = ImageLoader.this.v(o4.getAbsolutePath(), this.f1761b);
                    } else {
                        v3 = null;
                    }
                } else {
                    Log.e("ImageLoader", "load image :" + this.f1762c + " to memory.");
                    v3 = cn.bluemobi.dylan.base.utils.e.b(this.f1762c, this.f1761b);
                }
            } else {
                v3 = ImageLoader.this.v(this.f1762c, this.f1761b);
            }
            ImageLoader.this.i(this.f1762c, v3);
            ImageLoader.this.x(this.f1762c, this.f1761b, v3);
            ImageLoader.this.f1754i.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        Bitmap f1764a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f1765b;

        /* renamed from: c  reason: collision with root package name */
        String f1766c;

        private e() {
        }

        /* synthetic */ e(ImageLoader imageLoader, a aVar) {
            this();
        }
    }

    private ImageLoader(int i4, Type type) {
        s(i4, type);
    }

    private synchronized void j(Runnable runnable) {
        this.f1749d.add(runnable);
        try {
            if (this.f1751f == null) {
                this.f1753h.acquire();
            }
        } catch (InterruptedException unused) {
        }
        this.f1751f.sendEmptyMessage(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME);
    }

    private Runnable k(String str, ImageView imageView, boolean z3) {
        return new d(z3, imageView, str);
    }

    private Bitmap n(String str) {
        return this.f1746a.get(str);
    }

    public static ImageLoader p() {
        if (f1743k == null) {
            synchronized (ImageLoader.class) {
                if (f1743k == null) {
                    f1743k = new ImageLoader(1, Type.LIFO);
                }
            }
        }
        return f1743k;
    }

    public static ImageLoader q(int i4, Type type) {
        if (f1743k == null) {
            synchronized (ImageLoader.class) {
                if (f1743k == null) {
                    f1743k = new ImageLoader(i4, type);
                }
            }
        }
        return f1743k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable r() {
        Type type = this.f1748c;
        if (type == Type.FIFO) {
            return this.f1749d.removeFirst();
        }
        if (type == Type.LIFO) {
            return this.f1749d.removeLast();
        }
        return null;
    }

    private void s(int i4, Type type) {
        t();
        this.f1746a = new a(((int) Runtime.getRuntime().maxMemory()) / 8);
        this.f1747b = Executors.newFixedThreadPool(i4);
        this.f1749d = new LinkedList<>();
        this.f1748c = type;
        this.f1754i = new Semaphore(i4);
    }

    private void t() {
        b bVar = new b();
        this.f1750e = bVar;
        bVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap v(String str, ImageView imageView) {
        i.a c4 = i.c(imageView);
        return m(str, c4.f1795a, c4.f1796b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, ImageView imageView, Bitmap bitmap) {
        Message obtain = Message.obtain();
        e eVar = new e(this, null);
        eVar.f1764a = bitmap;
        eVar.f1766c = str;
        eVar.f1765b = imageView;
        obtain.obj = eVar;
        this.f1752g.sendMessage(obtain);
    }

    protected void i(String str, Bitmap bitmap) {
        if (n(str) != null || bitmap == null) {
            return;
        }
        this.f1746a.put(str, bitmap);
    }

    public String l(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    protected Bitmap m(String str, int i4, int i5) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = i.a(options, i4, i5);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public File o(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }

    public void u(String str, ImageView imageView, boolean z3) {
        imageView.setTag(str);
        if (this.f1752g == null) {
            this.f1752g = new c();
        }
        Bitmap n4 = n(str);
        if (n4 != null) {
            x(str, imageView, n4);
        } else {
            j(k(str, imageView, z3));
        }
    }

    public String w(String str) {
        try {
            return l(MessageDigest.getInstance("md5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
