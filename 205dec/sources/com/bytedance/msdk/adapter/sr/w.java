package com.bytedance.msdk.adapter.sr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.component.gd.sr.w<String, Void, Bitmap> {

    /* renamed from: w  reason: collision with root package name */
    private SoftReference<ImageView> f27215w;

    public w(ImageView imageView) {
        this.f27215w = new SoftReference<>(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
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
    /* renamed from: c */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            if (this.f27215w.get() != null) {
                this.f27215w.get().setImageBitmap(bitmap);
                return;
            }
            return;
        }
        xv.c("download Image", "Error download Image fail...");
    }
}
