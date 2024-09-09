package xyz.adscope.common.cache.video;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import xyz.adscope.common.tool.security.MD5Util;
import xyz.adscope.common.tool.utils.FileUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class VideoCacheManager {

    /* renamed from: d  reason: collision with root package name */
    public static VideoCacheManager f64573d;

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f64574a = Executors.newFixedThreadPool(4);

    /* renamed from: b  reason: collision with root package name */
    public LruCache<String, String> f64575b = new LruCache<>(1048576);

    /* renamed from: c  reason: collision with root package name */
    public Handler f64576c = new Handler();

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface VideoLoadedListener {
        void onVideoLoadFailed();

        void onVideoLoaded(String str);
    }

    public static VideoCacheManager a() {
        if (f64573d == null) {
            synchronized (VideoCacheManager.class) {
                if (f64573d == null) {
                    f64573d = new VideoCacheManager();
                }
            }
        }
        return f64573d;
    }

    public static VideoCacheManager with() {
        return a();
    }

    public void getCacheVideo(final Context context, final String str, final VideoLoadedListener videoLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.f64575b.get(str);
        String str3 = null;
        if (!TextUtils.isEmpty(str2)) {
            videoLoadedListener.onVideoLoaded(str2);
            return;
        }
        File file = new File(FileUtils.getResourceCacheDirectory(context), MD5Util.md5(str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1)));
        if (file.exists() && file.length() > 0) {
            str3 = file.getAbsolutePath();
        }
        if (TextUtils.isEmpty(str3)) {
            this.f64574a.submit(new Runnable() { // from class: xyz.adscope.common.cache.video.VideoCacheManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InputStream inputStream = ((HttpURLConnection) new URL(str).openConnection()).getInputStream();
                        String str4 = str;
                        File file2 = new File(FileUtils.getResourceCacheDirectory(context), MD5Util.md5(str4.substring(str4.lastIndexOf(TTPathConst.sSeparator) + 1)));
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
                        VideoCacheManager.this.f64576c.post(new Runnable() { // from class: xyz.adscope.common.cache.video.VideoCacheManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                videoLoadedListener.onVideoLoaded(absolutePath);
                            }
                        });
                        VideoCacheManager.this.f64575b.put(str, absolutePath);
                        fileOutputStream.close();
                        inputStream.close();
                        bufferedInputStream.close();
                    } catch (Exception unused) {
                        VideoCacheManager.this.f64576c.post(new Runnable() { // from class: xyz.adscope.common.cache.video.VideoCacheManager.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                videoLoadedListener.onVideoLoadFailed();
                            }
                        });
                    }
                    FileUtils.deleteOldFiles(context);
                }
            });
            return;
        }
        this.f64575b.put(str, str3);
        videoLoadedListener.onVideoLoaded(str3);
    }
}
