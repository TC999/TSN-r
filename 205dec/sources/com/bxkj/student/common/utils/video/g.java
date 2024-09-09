package com.bxkj.student.common.utils.video;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import androidx.fragment.app.FragmentActivity;
import com.jmolsmobile.landscapevideocapture.VideoCaptureActivity;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.File;
import m.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: VideoRecorder.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class g {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VideoRecorder.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface a {
        void a(String outputPath, Bitmap thumbnailBitmap);
    }

    private CaptureConfiguration b(int maxDuration) {
        CaptureConfiguration.b bVar = new CaptureConfiguration.b(PredefinedCaptureConfigurations.CaptureResolution.RES_720P, PredefinedCaptureConfigurations.CaptureQuality.HIGH);
        bVar.f();
        bVar.c(maxDuration);
        return bVar.a();
    }

    private Bitmap c(String filename) {
        if (filename == null) {
            return null;
        }
        return ThumbnailUtils.createVideoThumbnail(filename, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(a aVar, int i4, Intent intent) {
        if (i4 == -1) {
            String stringExtra = intent.getStringExtra("com.jmolsmobile.extraoutputfilename");
            Bitmap c4 = c(stringExtra);
            if (aVar != null) {
                aVar.a(stringExtra, c4);
            }
        }
    }

    public void e(FragmentActivity activity, int maxDuration, final a recordListener) {
        CaptureConfiguration b4 = b(maxDuration);
        File file = new File(activity.getCacheDir(), "video");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "record_video.mp4");
        if (file2.exists()) {
            try {
                file2.delete();
                file2.createNewFile();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        Intent intent = new Intent(activity, VideoCaptureActivity.class);
        intent.putExtra("com.jmolsmobile.extracaptureconfiguration", b4);
        intent.putExtra("com.jmolsmobile.extraoutputfilename", file2.getPath());
        new m.b(activity).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.student.common.utils.video.f
            @Override // m.b.a
            public final void a(int i4, Intent intent2) {
                g.this.d(recordListener, i4, intent2);
            }
        });
    }
}
