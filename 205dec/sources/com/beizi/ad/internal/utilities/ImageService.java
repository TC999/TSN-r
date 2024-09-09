package com.beizi.ad.internal.utilities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ImageService {
    static final int TIMEOUT = 10000;
    ImageServiceListener imageServiceListener;
    HashMap<ImageReceiver, String> imageUrls = new HashMap<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class ImageDownloader extends AsyncTask<Void, Void, Bitmap> {
        WeakReference<ImageService> caller;
        WeakReference<ImageReceiver> imageReceiver;
        String url;

        ImageDownloader(ImageReceiver imageReceiver, String str, ImageService imageService) {
            this.caller = new WeakReference<>(imageService);
            this.imageReceiver = new WeakReference<>(imageReceiver);
            this.url = str;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            this.imageReceiver.clear();
            this.caller.clear();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            if (isCancelled()) {
                return null;
            }
            try {
                URLConnection openConnection = new URL(this.url).openConnection();
                openConnection.setReadTimeout(10000);
                InputStream inputStream = (InputStream) openConnection.getContent();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                return decodeStream;
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            ImageReceiver imageReceiver = this.imageReceiver.get();
            ImageService imageService = this.caller.get();
            if (imageReceiver != null) {
                if (bitmap == null) {
                    imageReceiver.onFail();
                } else {
                    imageReceiver.onReceiveImage(bitmap);
                }
            }
            if (imageService != null) {
                imageService.finishDownload(imageReceiver);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface ImageReceiver {
        void onFail();

        void onReceiveImage(Bitmap bitmap);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface ImageServiceListener {
        void onAllImageDownloadsFinish();
    }

    private void finish() {
        this.imageUrls = null;
        this.imageServiceListener = null;
    }

    public void execute() {
        if (this.imageServiceListener == null) {
            finish();
            return;
        }
        HashMap<ImageReceiver, String> hashMap = this.imageUrls;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<ImageReceiver, String> entry : this.imageUrls.entrySet()) {
                ImageDownloader imageDownloader = new ImageDownloader(entry.getKey(), entry.getValue(), this);
                String str = HaoboLog.baseLogTag;
                HaoboLog.d(str, "Downloading image failFrom url: " + ((Object) entry.getValue()));
                imageDownloader.execute(new Void[0]);
            }
            return;
        }
        this.imageServiceListener.onAllImageDownloadsFinish();
        finish();
    }

    public void finishDownload(ImageReceiver imageReceiver) {
        HashMap<ImageReceiver, String> hashMap = this.imageUrls;
        if (hashMap == null || !hashMap.containsKey(imageReceiver)) {
            return;
        }
        this.imageUrls.remove(imageReceiver);
        if (this.imageUrls.size() == 0) {
            this.imageServiceListener.onAllImageDownloadsFinish();
            HaoboLog.d(HaoboLog.baseLogTag, "Images downloading finished.");
            finish();
        }
    }

    public void registerImageReceiver(ImageReceiver imageReceiver, String str) {
        if (StringUtil.isEmpty(str) || imageReceiver == null) {
            return;
        }
        this.imageUrls.put(imageReceiver, str);
    }

    public void registerNotification(ImageServiceListener imageServiceListener) {
        this.imageServiceListener = imageServiceListener;
    }
}
