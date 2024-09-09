package com.bykv.vk.openvk.component.video.c.ux;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: com.bykv.vk.openvk.component.video.c.ux.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0338w {
        void c(Bitmap bitmap);
    }

    public static void c(long j4, String str, InterfaceC0338w interfaceC0338w) {
        new c(interfaceC0338w, j4).c((Object[]) new String[]{str});
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends com.bytedance.sdk.component.gd.sr.w<String, Integer, Bitmap> {

        /* renamed from: w  reason: collision with root package name */
        private InterfaceC0338w f25039w;
        private long xv;

        public c(InterfaceC0338w interfaceC0338w, long j4) {
            this.f25039w = interfaceC0338w;
            this.xv = j4;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public Bitmap doInBackground(String... strArr) {
            Bitmap bitmap = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.xv * 1000, 3);
                mediaMetadataRetriever.release();
                return bitmap;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.f.xv.xv("MediaUtils", "MediaUtils doInBackground : ", th);
                return bitmap;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0338w interfaceC0338w = this.f25039w;
            if (interfaceC0338w != null) {
                interfaceC0338w.c(bitmap);
            }
        }
    }
}
