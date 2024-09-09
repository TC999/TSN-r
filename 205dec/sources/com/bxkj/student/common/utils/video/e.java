package com.bxkj.student.common.utils.video;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.hw.videoprocessor.util.k;
import com.orhanobut.logger.j;
import java.io.File;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: VideoCompressor.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private b f19663a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f19664b = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VideoCompressor.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i4 = msg.what;
            if (i4 == 0) {
                if (e.this.f19663a != null) {
                    e.this.f19663a.onStart();
                }
            } else if (i4 == 1) {
                if (e.this.f19663a != null) {
                    e.this.f19663a.a(msg.arg1);
                }
            } else if (i4 == 2) {
                if (e.this.f19663a != null) {
                    e.this.f19663a.onSuccess(msg.obj.toString());
                }
            } else if (e.this.f19663a != null) {
                e.this.f19663a.onFail();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VideoCompressor.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface b {
        void a(int percent);

        void onFail();

        void onStart();

        void onSuccess(String outputPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(float f4) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = (int) (f4 * 100.0f);
        this.f19664b.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str, Context context, String str2, File file) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f19664b.sendEmptyMessage(0);
            int i4 = 720;
            int i5 = 1280;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            if (Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)) > Integer.parseInt(mediaMetadataRetriever.extractMetadata(19))) {
                i4 = 1280;
                i5 = 720;
            }
            com.hw.videoprocessor.h.f(context).v(str).y(str2).x(i4).w(i5).p(600000).A(new k() { // from class: com.bxkj.student.common.utils.video.c
                @Override // com.hw.videoprocessor.util.k
                public final void a(float f4) {
                    e.this.e(f4);
                }
            }).z();
            Message message = new Message();
            message.what = 2;
            message.obj = file.getPath();
            this.f19664b.sendMessage(message);
            j.c("\u672c\u6b21\u538b\u7f29\u5171\u8017\u65f6" + ((System.currentTimeMillis() - currentTimeMillis) / 1000) + "\u79d2");
        } catch (Exception e4) {
            e4.printStackTrace();
            this.f19664b.sendEmptyMessage(3);
        }
    }

    public void d(final Context mContext, final String inputPath, b compressListener) {
        if (!new File(inputPath).exists()) {
            new iOSOneButtonDialog(mContext).setMessage("\u60a8\u9009\u53d6\u7684\u8be5\u89c6\u9891\u6587\u4ef6\u4e0d\u5b58\u5728,\u8bf7\u91cd\u65b0\u9009\u53d6").show();
        } else if (Build.VERSION.SDK_INT < 21) {
            if (compressListener != null) {
                compressListener.onStart();
            }
            if (compressListener != null) {
                compressListener.onSuccess(inputPath);
            }
        } else {
            this.f19663a = compressListener;
            File file = new File(mContext.getCacheDir(), "video");
            if (!file.exists()) {
                file.mkdirs();
            }
            final File file2 = new File(file, "scale_video.mp4");
            if (file2.exists()) {
                try {
                    file2.delete();
                    file2.createNewFile();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            final String absolutePath = file2.getAbsolutePath();
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bxkj.student.common.utils.video.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.f(inputPath, mContext, absolutePath, file2);
                }
            });
        }
    }
}
