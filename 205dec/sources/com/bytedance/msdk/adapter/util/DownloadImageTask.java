package com.bytedance.msdk.adapter.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private SoftReference<ImageView> f27222a;

    public DownloadImageTask(ImageView imageView) {
        this.f27222a = new SoftReference<>(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            if (this.f27222a.get() != null) {
                this.f27222a.get().setImageBitmap(bitmap);
                return;
            }
            return;
        }
        Log.d("download Image", "Error download Image fail...");
    }
}
