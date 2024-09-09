package xyz.adscope.common.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
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
import javax.net.ssl.HttpsURLConnection;
import xyz.adscope.common.cache.CacheManager;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.imageloader.inter.IImageLoaderCallback;
import xyz.adscope.common.network.ssl.TLSSocketFactory;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ImageUtils {

    /* renamed from: d  reason: collision with root package name */
    public static ImageUtils f64599d;

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f64600a = Executors.newFixedThreadPool(4);

    /* renamed from: b  reason: collision with root package name */
    public LruCache<String, Bitmap> f64601b = new LruCache<>(4194304);

    /* renamed from: c  reason: collision with root package name */
    public Handler f64602c = new Handler();

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface BitmapLoadedListener {
        void onBitmapLoadFailed();

        void onBitmapLoaded(Bitmap bitmap);
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class RequestCreatorRunnble implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public String f64615a;

        /* renamed from: b  reason: collision with root package name */
        public int f64616b;

        /* renamed from: c  reason: collision with root package name */
        public int f64617c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f64618d;

        /* renamed from: e  reason: collision with root package name */
        public IImageLoaderCallback f64619e;

        public RequestCreatorRunnble(String str) {
            this.f64615a = str;
        }

        public final Bitmap a(Context context) {
            String str = this.f64615a;
            File file = new File(StorageUtils.getCacheDirectory(context), ImageUtils.b(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
            LogUtil.d("BeiZiImageUtils", "BeiZiImageUtils getBitmapFile file == " + file);
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }

        public final void a() {
            ImageUtils.this.f64602c.post(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.RequestCreatorRunnble.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }

        public RequestCreatorRunnble callback(IImageLoaderCallback iImageLoaderCallback) {
            this.f64619e = iImageLoaderCallback;
            return this;
        }

        public RequestCreatorRunnble error(int i4) {
            this.f64617c = i4;
            return this;
        }

        public void into(ImageView imageView) {
            this.f64618d = imageView;
            if (TextUtils.isEmpty(this.f64615a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) ImageUtils.this.f64601b.get(this.f64615a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                IImageLoaderCallback iImageLoaderCallback = this.f64619e;
                if (iImageLoaderCallback != null) {
                    iImageLoaderCallback.successCallback(bitmap);
                    return;
                }
                return;
            }
            Bitmap a4 = a(imageView.getContext());
            if (a4 == null) {
                ImageUtils.this.f64600a.submit(this);
                return;
            }
            imageView.setImageBitmap(a4);
            ImageUtils.this.f64601b.put(this.f64615a, a4);
            IImageLoaderCallback iImageLoaderCallback2 = this.f64619e;
            if (iImageLoaderCallback2 != null) {
                iImageLoaderCallback2.successCallback(a4);
            }
        }

        public RequestCreatorRunnble placeholder(int i4) {
            this.f64616b = i4;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection c4 = ImageUtils.this.c(this.f64615a);
                if (c4.getResponseCode() == 200) {
                    final Bitmap decodeStream = BitmapFactory.decodeStream(c4.getInputStream());
                    ImageUtils.this.f64602c.post(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.RequestCreatorRunnble.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestCreatorRunnble.this.f64618d.setImageBitmap(decodeStream);
                        }
                    });
                    ImageUtils.this.f64601b.put(this.f64615a, decodeStream);
                    String str = this.f64615a;
                    File file = new File(StorageUtils.getCacheDirectory(this.f64618d.getContext()), ImageUtils.b(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
                    LogUtil.d("BeiZiImageUtils", "BeiZiImageUtils run file == " + file);
                    decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
                    IImageLoaderCallback iImageLoaderCallback = this.f64619e;
                    if (iImageLoaderCallback != null) {
                        iImageLoaderCallback.successCallback(decodeStream);
                    }
                } else {
                    a();
                    IImageLoaderCallback iImageLoaderCallback2 = this.f64619e;
                    if (iImageLoaderCallback2 != null) {
                        iImageLoaderCallback2.failCallback("net error");
                    }
                }
            } catch (FileNotFoundException e4) {
                IImageLoaderCallback iImageLoaderCallback3 = this.f64619e;
                if (iImageLoaderCallback3 != null) {
                    iImageLoaderCallback3.failCallback("fileNotFound " + e4.toString());
                }
            } catch (Exception e5) {
                LogUtil.e("BeiZiImageUtils", "e : " + e5);
                a();
                IImageLoaderCallback iImageLoaderCallback4 = this.f64619e;
                if (iImageLoaderCallback4 != null) {
                    iImageLoaderCallback4.failCallback("exception " + e5.toString());
                }
            }
        }
    }

    public static String a(byte[] bArr) {
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

    public static ImageUtils a() {
        if (f64599d == null) {
            synchronized (ImageUtils.class) {
                if (f64599d == null) {
                    f64599d = new ImageUtils();
                }
            }
        }
        return f64599d;
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static ImageUtils with() {
        return a();
    }

    public final HttpURLConnection c(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            if (str.startsWith(CommonConstants.HTTPS_PREFIX)) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new TLSSocketFactory());
            }
            return httpURLConnection;
        } catch (Exception e4) {
            LogUtil.e("BeiZiImageUtils", "Exception e : " + e4);
            return null;
        }
    }

    public void getBitmap(Context context, String str, BitmapLoadedListener bitmapLoadedListener) {
        getBitmap(context, str, true, bitmapLoadedListener);
    }

    public void getBitmap(final Context context, final String str, final boolean z3, final BitmapLoadedListener bitmapLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f64601b.get(str);
        if (bitmap != null) {
            bitmapLoadedListener.onBitmapLoaded(bitmap);
            return;
        }
        Bitmap bitmapByFileName = CacheManager.getInstance(context).getBitmapByFileName(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1), z3);
        if (bitmapByFileName == null) {
            this.f64600a.submit(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection c4 = ImageUtils.this.c(str);
                        if (c4.getResponseCode() == 200) {
                            final Bitmap decodeStream = BitmapFactory.decodeStream(c4.getInputStream());
                            c4.disconnect();
                            ImageUtils.this.f64602c.post(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bitmapLoadedListener.onBitmapLoaded(decodeStream);
                                }
                            });
                            ImageUtils.this.f64601b.put(str, decodeStream);
                            String str2 = str;
                            CacheManager.getInstance(context).saveImage(str2.substring(str2.lastIndexOf(TTPathConst.sSeparator) + 1), decodeStream, z3);
                        }
                    } catch (Exception unused) {
                        ImageUtils.this.f64602c.post(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                bitmapLoadedListener.onBitmapLoadFailed();
                            }
                        });
                    }
                }
            });
            return;
        }
        this.f64601b.put(str, bitmapByFileName);
        bitmapLoadedListener.onBitmapLoaded(bitmapByFileName);
    }

    public void getCacheBitmap(final Context context, final String str, final boolean z3, BitmapLoadedListener bitmapLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.f64601b.get(str);
        if (bitmap != null) {
            bitmapLoadedListener.onBitmapLoaded(bitmap);
            return;
        }
        Bitmap bitmapByFileName = CacheManager.getInstance(context).getBitmapByFileName(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1), z3);
        if (bitmapByFileName == null) {
            this.f64600a.submit(new Runnable() { // from class: xyz.adscope.common.imageloader.ImageUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection c4 = ImageUtils.this.c(str);
                        if (c4.getResponseCode() == 200) {
                            Bitmap decodeStream = BitmapFactory.decodeStream(c4.getInputStream());
                            c4.disconnect();
                            ImageUtils.this.f64601b.put(str, decodeStream);
                            String str2 = str;
                            CacheManager.getInstance(context).saveImage(str2.substring(str2.lastIndexOf(TTPathConst.sSeparator) + 1), decodeStream, z3);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
            return;
        }
        this.f64601b.put(str, bitmapByFileName);
        bitmapLoadedListener.onBitmapLoaded(bitmapByFileName);
    }

    public RequestCreatorRunnble load(String str) {
        return new RequestCreatorRunnble(str);
    }
}
