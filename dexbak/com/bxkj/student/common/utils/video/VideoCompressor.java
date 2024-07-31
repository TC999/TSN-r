package com.bxkj.student.common.utils.video;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.orhanobut.logger.C11792j;
import com.p201hw.videoprocessor.VideoProcessor;
import com.p201hw.videoprocessor.util.VideoProgressListener;
import java.io.File;
import java.util.concurrent.Executors;

/* renamed from: com.bxkj.student.common.utils.video.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VideoCompressor {

    /* renamed from: a */
    private InterfaceC4262b f16261a;

    /* renamed from: b */
    private Handler f16262b = new HandlerC4261a();

    /* compiled from: VideoCompressor.java */
    /* renamed from: com.bxkj.student.common.utils.video.e$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class HandlerC4261a extends Handler {
        HandlerC4261a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i = msg.what;
            if (i == 0) {
                if (VideoCompressor.this.f16261a != null) {
                    VideoCompressor.this.f16261a.onStart();
                }
            } else if (i == 1) {
                if (VideoCompressor.this.f16261a != null) {
                    VideoCompressor.this.f16261a.mo41460a(msg.arg1);
                }
            } else if (i == 2) {
                if (VideoCompressor.this.f16261a != null) {
                    VideoCompressor.this.f16261a.onSuccess(msg.obj.toString());
                }
            } else if (VideoCompressor.this.f16261a != null) {
                VideoCompressor.this.f16261a.onFail();
            }
        }
    }

    /* compiled from: VideoCompressor.java */
    /* renamed from: com.bxkj.student.common.utils.video.e$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC4262b {
        /* renamed from: a */
        void mo41460a(int percent);

        void onFail();

        void onStart();

        void onSuccess(String outputPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m42775e(float f) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = (int) (f * 100.0f);
        this.f16262b.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m42774f(String str, Context context, String str2, File file) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f16262b.sendEmptyMessage(0);
            int i = PredefinedCaptureConfigurations.f24404n;
            int i2 = PredefinedCaptureConfigurations.f24405o;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            if (Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)) > Integer.parseInt(mediaMetadataRetriever.extractMetadata(19))) {
                i = PredefinedCaptureConfigurations.f24405o;
                i2 = PredefinedCaptureConfigurations.f24404n;
            }
            VideoProcessor.m35030f(context).m35001v(str).m34998y(str2).m34999x(i).m35000w(i2).m35007p(600000).m35025A(new VideoProgressListener() { // from class: com.bxkj.student.common.utils.video.c
                @Override // com.p201hw.videoprocessor.util.VideoProgressListener
                /* renamed from: a */
                public final void mo34843a(float f) {
                    VideoCompressor.this.m42775e(f);
                }
            }).m34997z();
            Message message = new Message();
            message.what = 2;
            message.obj = file.getPath();
            this.f16262b.sendMessage(message);
            C11792j.m20470c("本次压缩共耗时" + ((System.currentTimeMillis() - currentTimeMillis) / 1000) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
            this.f16262b.sendEmptyMessage(3);
        }
    }

    /* renamed from: d */
    public void m42776d(final Context mContext, final String inputPath, InterfaceC4262b compressListener) {
        if (!new File(inputPath).exists()) {
            new iOSOneButtonDialog(mContext).setMessage("您选取的该视频文件不存在,请重新选取").show();
        } else if (Build.VERSION.SDK_INT < 21) {
            if (compressListener != null) {
                compressListener.onStart();
            }
            if (compressListener != null) {
                compressListener.onSuccess(inputPath);
            }
        } else {
            this.f16261a = compressListener;
            File file = new File(mContext.getCacheDir(), "video");
            if (!file.exists()) {
                file.mkdirs();
            }
            final File file2 = new File(file, "scale_video.mp4");
            if (file2.exists()) {
                try {
                    file2.delete();
                    file2.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            final String absolutePath = file2.getAbsolutePath();
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bxkj.student.common.utils.video.d
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCompressor.this.m42774f(inputPath, mContext, absolutePath, file2);
                }
            });
        }
    }
}
