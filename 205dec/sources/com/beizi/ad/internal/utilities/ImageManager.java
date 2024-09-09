package com.beizi.ad.internal.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.beizi.ad.lance.a.h;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ImageManager {
    private static ImageManager instance;
    private static Context mContext;
    private ExecutorService executorService = Executors.newFixedThreadPool(4);
    private LruCache<String, Bitmap> imageCache = new LruCache<>(4194304);
    private Handler handler = new Handler();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface BitmapLoadedListener {
        void onBitmapLoadFailed();

        void onBitmapLoaded(Bitmap bitmap);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class RequestCreatorRunnble implements Runnable {
        int errorResId;
        int holderResId;
        ImageView imageView;
        String url;

        public RequestCreatorRunnble(String str) {
            this.url = str;
        }

        private Bitmap getBitmapFile() {
            String str = this.url;
            File file = new File(h.c(ImageManager.mContext), HashingFunctions.md5(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }

        private void showError() {
            ImageManager.this.handler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.ImageManager.RequestCreatorRunnble.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }

        public RequestCreatorRunnble error(int i4) {
            this.errorResId = i4;
            return this;
        }

        public void into(ImageView imageView) {
            this.imageView = imageView;
            if (TextUtils.isEmpty(this.url)) {
                return;
            }
            Bitmap bitmap = (Bitmap) ImageManager.this.imageCache.get(this.url);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap bitmapFile = getBitmapFile();
            if (bitmapFile != null) {
                imageView.setImageBitmap(bitmapFile);
                ImageManager.this.imageCache.put(this.url, bitmapFile);
                return;
            }
            ImageManager.this.executorService.submit(this);
        }

        public RequestCreatorRunnble placeholder(int i4) {
            this.holderResId = i4;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    ImageManager.this.handler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.ImageManager.RequestCreatorRunnble.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestCreatorRunnble.this.imageView.setImageBitmap(decodeStream);
                        }
                    });
                    ImageManager.this.imageCache.put(this.url, decodeStream);
                    String str = this.url;
                    decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(h.c(ImageManager.mContext), HashingFunctions.md5(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)))));
                } else {
                    showError();
                }
            } catch (FileNotFoundException unused) {
            } catch (Exception e4) {
                e4.printStackTrace();
                showError();
            }
        }
    }

    private static ImageManager getInstance() {
        if (instance == null) {
            synchronized (ImageManager.class) {
                if (instance == null) {
                    instance = new ImageManager();
                }
            }
        }
        return instance;
    }

    public static ImageManager with(Context context) {
        if (com.beizi.ad.internal.h.a().f13808j != null) {
            mContext = com.beizi.ad.internal.h.a().f13808j;
        } else {
            mContext = context;
        }
        return getInstance();
    }

    public void getBitmap(final String str, final BitmapLoadedListener bitmapLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.imageCache.get(str);
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            bitmapLoadedListener.onBitmapLoaded(bitmap);
            return;
        }
        File file = new File(h.d(mContext), HashingFunctions.md5(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
        if (file.exists() && file.length() > 0) {
            bitmap2 = BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        if (bitmap2 != null) {
            this.imageCache.put(str, bitmap2);
            bitmapLoadedListener.onBitmapLoaded(bitmap2);
            return;
        }
        this.executorService.submit(new Runnable() { // from class: com.beizi.ad.internal.utilities.ImageManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(2000);
                    if (httpURLConnection.getResponseCode() == 200) {
                        final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                        httpURLConnection.disconnect();
                        ImageManager.this.handler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.ImageManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bitmapLoadedListener.onBitmapLoaded(decodeStream);
                            }
                        });
                        ImageManager.this.imageCache.put(str, decodeStream);
                        String str2 = str;
                        decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(h.d(ImageManager.mContext), HashingFunctions.md5(str2.substring(str2.lastIndexOf(TTPathConst.sSeparator) + 1)))));
                    }
                } catch (Exception unused) {
                    ImageManager.this.handler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.ImageManager.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            bitmapLoadedListener.onBitmapLoadFailed();
                        }
                    });
                }
                h.e(ImageManager.mContext);
            }
        });
    }

    public void getCacheBitmap(final String str, final BitmapLoadedListener bitmapLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.imageCache.get(str);
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            bitmapLoadedListener.onBitmapLoaded(bitmap);
            return;
        }
        File file = new File(h.c(mContext), HashingFunctions.md5(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
        if (file.exists() && file.length() > 0) {
            bitmap2 = BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        if (bitmap2 != null) {
            this.imageCache.put(str, bitmap2);
            bitmapLoadedListener.onBitmapLoaded(bitmap2);
            return;
        }
        this.executorService.submit(new Runnable() { // from class: com.beizi.ad.internal.utilities.ImageManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(2000);
                    if (httpURLConnection.getResponseCode() == 200) {
                        Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                        httpURLConnection.disconnect();
                        ImageManager.this.imageCache.put(str, decodeStream);
                        String str2 = str;
                        decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(h.c(ImageManager.mContext), HashingFunctions.md5(str2.substring(str2.lastIndexOf(TTPathConst.sSeparator) + 1)))));
                    }
                } catch (Exception unused) {
                    ImageManager.this.handler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.ImageManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bitmapLoadedListener.onBitmapLoadFailed();
                        }
                    });
                }
            }
        });
    }

    public RequestCreatorRunnble load(String str) {
        return new RequestCreatorRunnble(str);
    }
}
