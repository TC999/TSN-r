package com.mbridge.msdk.foundation.aidl;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.mbridge.msdk.foundation.aidl.VideoBinderInterface;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoRequestService extends Service {

    /* renamed from: a */
    private volatile VideoBinderListener f30206a = null;

    /* renamed from: b */
    private volatile VideoBinderInterface f30207b = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.f30207b != null) {
            try {
                return (IBinder) this.f30207b;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f30207b = new VideoBinderInterface.Stub() { // from class: com.mbridge.msdk.foundation.aidl.VideoRequestService.1
            @Override // com.mbridge.msdk.foundation.aidl.VideoBinderInterface
            public final void registerListener(VideoBinderListener videoBinderListener) throws RemoteException {
                VideoRequestService.this.f30206a = videoBinderListener;
            }

            @Override // com.mbridge.msdk.foundation.aidl.VideoBinderInterface
            public final void requestVideo(final String[] strArr) throws RemoteException {
                if (VideoRequestService.this.f30206a != null) {
                    ThreadPoolUtils.m22309a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.aidl.VideoRequestService.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            List<DownloadModel> findAll = GlobalComponent.getInstance().getDatabaseHelper().findAll();
                            List arrayList = new ArrayList();
                            String[] strArr2 = strArr;
                            if (strArr2 != null && strArr2.length > 0) {
                                arrayList = Arrays.asList(strArr2);
                            }
                            if (findAll == null || findAll.size() <= 0) {
                                return;
                            }
                            for (DownloadModel downloadModel : findAll) {
                                if (downloadModel != null && downloadModel.getDownloadedBytes() == downloadModel.getTotalBytes() && !arrayList.contains(downloadModel.getDownloadUrl())) {
                                    try {
                                        File file = new File(downloadModel.getSaveDirectorPath(), downloadModel.getSaveFileName());
                                        if (file.isFile() && file.exists()) {
                                            FileInputStream fileInputStream = new FileInputStream(file);
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            byte[] bArr = new byte[4096];
                                            while (true) {
                                                int read = fileInputStream.read(bArr, 0, 4096);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr, 0, read);
                                            }
                                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                                            MemoryFile memoryFile = new MemoryFile(downloadModel.getSaveFileName(), byteArray.length);
                                            memoryFile.writeBytes(byteArray, 0, 0, byteArray.length);
                                            ParcelFileDescriptor dup = ParcelFileDescriptor.dup(MemoryFileManager.m22937a(memoryFile));
                                            if (VideoRequestService.this.f30206a != null) {
                                                VideoRequestService.this.f30206a.onVideo(downloadModel.getResourceUrl(), downloadModel.getTotalBytes(), downloadModel.getDownloadId(), downloadModel.getEtag(), downloadModel.getSaveFileName(), dup);
                                            }
                                        }
                                    } catch (Exception unused) {
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }
                        }
                    });
                }
            }
        };
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        super.unbindService(serviceConnection);
        this.f30207b = null;
        this.f30206a = null;
    }
}
