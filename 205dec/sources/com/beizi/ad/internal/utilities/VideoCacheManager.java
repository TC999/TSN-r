package com.beizi.ad.internal.utilities;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.beizi.ad.lance.a.h;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class VideoCacheManager {
    private static VideoCacheManager instance;
    private ExecutorService executorService = Executors.newFixedThreadPool(4);
    private LruCache<String, String> videoCache = new LruCache<>(1048576);
    private Handler handler = new Handler();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface VideoLoadedListener {
        void onVideoLoadFailed();

        void onVideoLoaded(String str);
    }

    private static VideoCacheManager getInstance() {
        if (instance == null) {
            synchronized (VideoCacheManager.class) {
                if (instance == null) {
                    instance = new VideoCacheManager();
                }
            }
        }
        return instance;
    }

    public static VideoCacheManager with() {
        return getInstance();
    }

    public void getCacheVideo(final Context context, final String str, final VideoLoadedListener videoLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.videoCache.get(str);
        String str3 = null;
        if (!TextUtils.isEmpty(str2)) {
            videoLoadedListener.onVideoLoaded(str2);
            return;
        }
        File file = new File(h.d(context), HashingFunctions.md5(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
        if (file.exists() && file.length() > 0) {
            str3 = file.getAbsolutePath();
        }
        if (!TextUtils.isEmpty(str3)) {
            this.videoCache.put(str, str3);
            videoLoadedListener.onVideoLoaded(str3);
            return;
        }
        this.executorService.submit(new Runnable() { // from class: com.beizi.ad.internal.utilities.VideoCacheManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InputStream inputStream = ((HttpURLConnection) new URL(str).openConnection()).getInputStream();
                    String str4 = str;
                    File file2 = new File(h.d(context), HashingFunctions.md5(str4.substring(str4.lastIndexOf(TTPathConst.sSeparator) + 1)));
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    final String absolutePath = file2.getAbsolutePath();
                    VideoCacheManager.this.handler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.VideoCacheManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            videoLoadedListener.onVideoLoaded(absolutePath);
                        }
                    });
                    VideoCacheManager.this.videoCache.put(str, absolutePath);
                    fileOutputStream.close();
                    inputStream.close();
                    bufferedInputStream.close();
                } catch (Exception unused) {
                    VideoCacheManager.this.handler.post(new Runnable() { // from class: com.beizi.ad.internal.utilities.VideoCacheManager.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            videoLoadedListener.onVideoLoadFailed();
                        }
                    });
                }
                h.e(context);
            }
        });
    }
}
