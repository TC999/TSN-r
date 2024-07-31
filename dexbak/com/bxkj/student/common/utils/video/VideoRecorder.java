package com.bxkj.student.common.utils.video;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import androidx.fragment.app.FragmentActivity;
import com.jmolsmobile.landscapevideocapture.VideoCaptureActivity;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.File;
import p618m.StartActivityForResult;

/* renamed from: com.bxkj.student.common.utils.video.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VideoRecorder {

    /* compiled from: VideoRecorder.java */
    /* renamed from: com.bxkj.student.common.utils.video.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC4264a {
        /* renamed from: a */
        void mo41441a(String outputPath, Bitmap thumbnailBitmap);
    }

    /* renamed from: b */
    private CaptureConfiguration m42772b(int maxDuration) {
        CaptureConfiguration.C7139b c7139b = new CaptureConfiguration.C7139b(PredefinedCaptureConfigurations.CaptureResolution.RES_720P, PredefinedCaptureConfigurations.CaptureQuality.HIGH);
        c7139b.m34485f();
        c7139b.m34488c(maxDuration);
        return c7139b.m34490a();
    }

    /* renamed from: c */
    private Bitmap m42771c(String filename) {
        if (filename == null) {
            return null;
        }
        return ThumbnailUtils.createVideoThumbnail(filename, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m42770d(InterfaceC4264a interfaceC4264a, int i, Intent intent) {
        if (i == -1) {
            String stringExtra = intent.getStringExtra(VideoCaptureActivity.f24324i);
            Bitmap m42771c = m42771c(stringExtra);
            if (interfaceC4264a != null) {
                interfaceC4264a.mo41441a(stringExtra, m42771c);
            }
        }
    }

    /* renamed from: e */
    public void m42769e(FragmentActivity activity, int maxDuration, final InterfaceC4264a recordListener) {
        CaptureConfiguration m42772b = m42772b(maxDuration);
        File file = new File(activity.getCacheDir(), "video");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "record_video.mp4");
        if (file2.exists()) {
            try {
                file2.delete();
                file2.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(activity, VideoCaptureActivity.class);
        intent.putExtra(VideoCaptureActivity.f24325j, m42772b);
        intent.putExtra(VideoCaptureActivity.f24324i, file2.getPath());
        new StartActivityForResult(activity).startActivityForResult(intent).m3460c(new StartActivityForResult.InterfaceC15293a() { // from class: com.bxkj.student.common.utils.video.f
            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public final void mo3459a(int i, Intent intent2) {
                VideoRecorder.this.m42770d(recordListener, i, intent2);
            }
        });
    }
}
