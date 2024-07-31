package com.kwad.sdk;

import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.AbstractC9505i;
import com.kwad.framework.filedownloader.C9559r;
import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.p351d.C9466d;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11023ap;
import com.kwad.sdk.utils.C11122q;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadTask implements Serializable {
    private static final long serialVersionUID = -7092669850073266500L;
    private int mAllowedNetworkTypes;
    protected transient InterfaceC9427a mBaseDownloadTask;
    private String mDestinationDir;
    private String mDestinationFileName;
    private int mNotificationVisibility;
    private Map<String, String> mRequestHeaders;
    private Serializable mTag;
    private String mUrl;
    private boolean mUserPause;
    private boolean mWakeInstallApk;
    private transient List<AbstractC9667a> mDownloadListeners = new ArrayList();
    private boolean mIsCanceled = false;
    public boolean downloadEnablePause = false;
    private boolean notificationRemoved = false;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class DownloadRequest implements Serializable {
        private static final long serialVersionUID = -3638290207248829674L;
        private int mAllowedNetworkTypes;
        private String mDestinationFileName;
        private String mDownloadUrl;
        private Serializable mTag;
        private final Map<String, String> mRequestHeaders = new HashMap();
        private boolean mInstallAfterDownload = true;
        @Deprecated
        private boolean mIsPhotoAdDownloadRequest = false;
        private int mNotificationVisibility = 0;
        public boolean downloadEnablePause = false;
        private String mDestinationDir = C9774c.m27790xL().m27789xM().getPath();

        public DownloadRequest(String str) {
            this.mAllowedNetworkTypes = 3;
            this.mDownloadUrl = str;
            NetworkInfo m24133cj = C11013ag.m24133cj(C9774c.m27790xL().getContext());
            if (m24133cj != null && m24133cj.getType() == 0) {
                this.mAllowedNetworkTypes = 3;
            } else {
                this.mAllowedNetworkTypes = 2;
            }
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            C11023ap.m24086gH(str);
            if (!str.contains(":")) {
                if (str2 == null) {
                    str2 = "";
                }
                this.mRequestHeaders.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("header may not contain ':'");
        }

        public int getAllowedNetworkTypes() {
            return this.mAllowedNetworkTypes;
        }

        public String getDestinationDir() {
            return this.mDestinationDir;
        }

        public String getDestinationFileName() {
            return this.mDestinationFileName;
        }

        public String getDownloadUrl() {
            return this.mDownloadUrl;
        }

        public Serializable getTag() {
            return this.mTag;
        }

        public boolean isDownloadEnablePause() {
            return this.downloadEnablePause;
        }

        public boolean isPhotoAdDownloadRequest() {
            return this.mIsPhotoAdDownloadRequest;
        }

        public DownloadRequest setAllowedNetworkTypes(int i) {
            this.mAllowedNetworkTypes = i;
            return this;
        }

        public DownloadRequest setDestinationDir(String str) {
            this.mDestinationDir = str;
            return this;
        }

        public DownloadRequest setDestinationFileName(String str) {
            this.mDestinationFileName = str;
            return this;
        }

        public void setDownloadEnablePause(boolean z) {
            this.downloadEnablePause = z;
        }

        public DownloadRequest setInstallAfterDownload(boolean z) {
            this.mInstallAfterDownload = z;
            return this;
        }

        public void setIsPhotoAdDownloadRequest() {
            this.mIsPhotoAdDownloadRequest = true;
        }

        public DownloadRequest setNotificationVisibility(int i) {
            this.mNotificationVisibility = i;
            return this;
        }

        public DownloadRequest setTag(Serializable serializable) {
            this.mTag = serializable;
            return this;
        }
    }

    public DownloadTask(DownloadRequest downloadRequest) {
        initDownloadRequestParams(downloadRequest);
        instantiateDownloadTask();
        initDownloadTaskParams();
    }

    private void initDownloadRequestParams(DownloadRequest downloadRequest) {
        this.mWakeInstallApk = downloadRequest.mInstallAfterDownload;
        this.mUrl = downloadRequest.mDownloadUrl;
        this.mAllowedNetworkTypes = downloadRequest.mAllowedNetworkTypes;
        this.mNotificationVisibility = downloadRequest.mNotificationVisibility;
        this.mDestinationDir = downloadRequest.mDestinationDir;
        this.mDestinationFileName = downloadRequest.mDestinationFileName;
        this.mRequestHeaders = downloadRequest.mRequestHeaders;
        this.mTag = downloadRequest.mTag;
        this.downloadEnablePause = downloadRequest.isDownloadEnablePause();
    }

    private void initDownloadTaskParams() {
        this.mBaseDownloadTask.mo28750e(this.mTag);
        this.mBaseDownloadTask.mo28752bc((this.mAllowedNetworkTypes ^ 2) == 0);
        for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
            this.mBaseDownloadTask.mo28755ba(entry.getKey());
            this.mBaseDownloadTask.mo28749t(entry.getKey(), entry.getValue());
        }
    }

    private void notify(DownloadTask downloadTask, InterfaceC10761a<InterfaceC10750d> interfaceC10761a) {
        InterfaceC10750d m27788xN = C9774c.m27790xL().m27788xN();
        if (m27788xN == null) {
            return;
        }
        if (downloadTask.isCanceled()) {
            m27788xN.mo24934bV(downloadTask.getId());
        } else {
            interfaceC10761a.accept(m27788xN);
        }
    }

    private void notifyDownloadCanceled() {
        InterfaceC10750d m27788xN = C9774c.m27790xL().m27788xN();
        if (m27788xN == null) {
            return;
        }
        m27788xN.mo24934bV(getId());
    }

    private void notifyDownloadCompleted(InterfaceC9427a interfaceC9427a) {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new InterfaceC10761a<InterfaceC10750d>() { // from class: com.kwad.sdk.DownloadTask.3
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.p434g.InterfaceC10761a
                /* renamed from: a */
                public void accept(InterfaceC10750d interfaceC10750d) {
                    interfaceC10750d.mo24930k(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadError(InterfaceC9427a interfaceC9427a) {
        if ((this.mNotificationVisibility & 1) != 0) {
            notify(this, new InterfaceC10761a<InterfaceC10750d>() { // from class: com.kwad.sdk.DownloadTask.5
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.p434g.InterfaceC10761a
                /* renamed from: a */
                public void accept(InterfaceC10750d interfaceC10750d) {
                    interfaceC10750d.mo24931j(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadPending() {
        if ((this.mNotificationVisibility & 2) != 0) {
            notify(this, new InterfaceC10761a<InterfaceC10750d>() { // from class: com.kwad.sdk.DownloadTask.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.p434g.InterfaceC10761a
                /* renamed from: a */
                public void accept(InterfaceC10750d interfaceC10750d) {
                    interfaceC10750d.mo24932i(DownloadTask.this);
                }
            });
        }
    }

    private void notifyDownloadProgress(InterfaceC9427a interfaceC9427a, final boolean z) {
        if ((interfaceC9427a.getSmallFileTotalBytes() == 0 && interfaceC9427a.getSmallFileSoFarBytes() == 0) || TextUtils.isEmpty(interfaceC9427a.getFilename()) || (this.mNotificationVisibility & 1) == 0) {
            return;
        }
        notify(this, new InterfaceC10761a<InterfaceC10750d>() { // from class: com.kwad.sdk.DownloadTask.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: a */
            public void accept(InterfaceC10750d interfaceC10750d) {
                interfaceC10750d.mo24936a(DownloadTask.this, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlockCompleted(InterfaceC9427a interfaceC9427a) {
        try {
            Iterator<AbstractC9667a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onCanceled(InterfaceC9427a interfaceC9427a) {
        try {
            this.mIsCanceled = true;
            for (AbstractC9667a abstractC9667a : this.mDownloadListeners) {
                abstractC9667a.mo26333d(this);
            }
            interfaceC9427a.cancel();
            notifyDownloadCanceled();
            C9559r.m28419uU().m28420n(getId(), this.mBaseDownloadTask.getTargetFilePath());
            releaseDownloadTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted(InterfaceC9427a interfaceC9427a) {
        try {
            for (AbstractC9667a abstractC9667a : this.mDownloadListeners) {
                abstractC9667a.mo26338a(this);
            }
            notifyDownloadCompleted(interfaceC9427a);
            if (this.mWakeInstallApk) {
                installApk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnected(InterfaceC9427a interfaceC9427a, String str, boolean z, int i, int i2) {
        long j;
        long j2 = i2;
        try {
            if (new File(this.mDestinationDir).exists()) {
                j = C10747h.getAvailableBytes(this.mDestinationDir);
            } else {
                j = C10747h.getAvailableBytes(Environment.getExternalStorageDirectory().getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
            j = j2;
        }
        if (j < j2) {
            C9774c.m27790xL().cancel(interfaceC9427a.getId());
            notifyDownloadCanceled();
            onLowStorage(interfaceC9427a);
            return;
        }
        try {
            Iterator<AbstractC9667a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            notifyDownloadProgress(interfaceC9427a, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloading(InterfaceC9427a interfaceC9427a, int i, int i2) {
        try {
            for (AbstractC9667a abstractC9667a : this.mDownloadListeners) {
                abstractC9667a.mo26337a(this, i, i2);
            }
            notifyDownloadProgress(this.mBaseDownloadTask, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(InterfaceC9427a interfaceC9427a, Throwable th) {
        try {
            for (AbstractC9667a abstractC9667a : this.mDownloadListeners) {
                abstractC9667a.mo26336a(this, th);
            }
            notifyDownloadError(interfaceC9427a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onLowStorage(InterfaceC9427a interfaceC9427a) {
        try {
            for (AbstractC9667a abstractC9667a : this.mDownloadListeners) {
                abstractC9667a.mo26331f(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause(InterfaceC9427a interfaceC9427a, int i, int i2) {
        try {
            for (AbstractC9667a abstractC9667a : this.mDownloadListeners) {
                abstractC9667a.mo26334c(this);
            }
            notifyDownloadProgress(interfaceC9427a, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPending(InterfaceC9427a interfaceC9427a, int i, int i2) {
        try {
            Iterator<AbstractC9667a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
            notifyDownloadPending();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onResume(InterfaceC9427a interfaceC9427a, int i, int i2) {
        try {
            for (AbstractC9667a abstractC9667a : this.mDownloadListeners) {
                abstractC9667a.mo26332e(this);
            }
            notifyDownloadProgress(interfaceC9427a, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStarted(InterfaceC9427a interfaceC9427a) {
        try {
            for (AbstractC9667a abstractC9667a : this.mDownloadListeners) {
                abstractC9667a.mo26335b(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWarn(InterfaceC9427a interfaceC9427a) {
        try {
            Iterator<AbstractC9667a> it = this.mDownloadListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.mDownloadListeners = new ArrayList();
    }

    private void releaseDownloadTask() {
        this.mBaseDownloadTask.mo28759a(null);
        clearListener();
    }

    public void addListener(AbstractC9667a abstractC9667a) {
        if (abstractC9667a == null || this.mDownloadListeners.contains(abstractC9667a)) {
            return;
        }
        this.mDownloadListeners.add(abstractC9667a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel() {
        try {
            onCanceled(this.mBaseDownloadTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearListener() {
        this.mDownloadListeners.clear();
    }

    int downLoadProgress() {
        long smallFileTotalBytes = this.mBaseDownloadTask.getSmallFileTotalBytes();
        int smallFileSoFarBytes = smallFileTotalBytes != 0 ? (int) ((this.mBaseDownloadTask.getSmallFileSoFarBytes() * 100.0f) / ((float) smallFileTotalBytes)) : 0;
        if (smallFileSoFarBytes != 100 || C11122q.m23748M(new File(this.mBaseDownloadTask.getTargetFilePath()))) {
            return smallFileSoFarBytes;
        }
        return 0;
    }

    public int getAllowedNetworkTypes() {
        return this.mAllowedNetworkTypes;
    }

    public String getDestinationDir() {
        return this.mDestinationDir;
    }

    public String getFilename() {
        return this.mBaseDownloadTask.getFilename();
    }

    public int getId() {
        return this.mBaseDownloadTask.getId();
    }

    public int getNotificationVisibility() {
        return this.mNotificationVisibility;
    }

    public String getPath() {
        return this.mBaseDownloadTask.getPath();
    }

    public int getSmallFileSoFarBytes() {
        return this.mBaseDownloadTask.getSmallFileSoFarBytes();
    }

    public int getSmallFileTotalBytes() {
        return this.mBaseDownloadTask.getSmallFileTotalBytes();
    }

    public int getSpeed() {
        return this.mBaseDownloadTask.getSpeed();
    }

    public int getStatus() {
        return this.mBaseDownloadTask.mo28739tV();
    }

    public long getStatusUpdateTime() {
        return this.mBaseDownloadTask.getStatusUpdateTime();
    }

    public Object getTag() {
        return this.mBaseDownloadTask.getTag();
    }

    public String getTargetFilePath() {
        return this.mBaseDownloadTask.getTargetFilePath();
    }

    public String getUrl() {
        return this.mUrl;
    }

    void installApk() {
        try {
            C9774c.m27790xL().m27792g(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void instantiateDownloadTask() {
        C9559r.m28419uU();
        this.mBaseDownloadTask = C9559r.m28422bc(this.mUrl).mo28754ba(true).mo28758aX(3).mo28751c(TextUtils.isEmpty(this.mDestinationFileName) ? this.mDestinationDir : new File(this.mDestinationDir, this.mDestinationFileName).getPath(), TextUtils.isEmpty(this.mDestinationFileName)).mo28759a(new AbstractC9505i() { // from class: com.kwad.sdk.DownloadTask.1
            @Override // com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: a */
            public final void mo28099a(InterfaceC9427a interfaceC9427a, String str, boolean z, int i, int i2) {
                DownloadTask.this.onConnected(interfaceC9427a, str, z, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: b */
            public final void mo28097b(InterfaceC9427a interfaceC9427a, int i, int i2) {
                DownloadTask.this.onDownloading(interfaceC9427a, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: c */
            public final void mo25282c(InterfaceC9427a interfaceC9427a) {
                DownloadTask.this.onCompleted(interfaceC9427a);
            }

            @Override // com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: d */
            public final void mo28095d(InterfaceC9427a interfaceC9427a) {
                DownloadTask.this.onWarn(interfaceC9427a);
            }

            @Override // com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: a */
            public final void mo28101a(InterfaceC9427a interfaceC9427a) {
                DownloadTask.this.onStarted(interfaceC9427a);
            }

            @Override // com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: b */
            public final void mo28098b(InterfaceC9427a interfaceC9427a) {
                DownloadTask.this.onBlockCompleted(interfaceC9427a);
            }

            @Override // com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: c */
            public final void mo28096c(InterfaceC9427a interfaceC9427a, int i, int i2) {
                DownloadTask.this.onPause(interfaceC9427a, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: a */
            public final void mo28100a(InterfaceC9427a interfaceC9427a, int i, int i2) {
                DownloadTask.this.onPending(interfaceC9427a, i, i2);
            }

            @Override // com.kwad.framework.filedownloader.AbstractC9505i
            /* renamed from: a */
            public final void mo25283a(InterfaceC9427a interfaceC9427a, Throwable th) {
                DownloadTask.this.onError(interfaceC9427a, th);
            }
        });
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public boolean isCompleted() {
        return this.mBaseDownloadTask.mo28739tV() == -3;
    }

    public boolean isError() {
        return this.mBaseDownloadTask.mo28739tV() == -1;
    }

    public boolean isErrorBecauseWifiRequired() {
        return this.mBaseDownloadTask.mo28732uc() && isError() && (this.mBaseDownloadTask.mo28737tX() instanceof FileDownloadNetworkPolicyException);
    }

    public boolean isInvalid() {
        return this.mBaseDownloadTask.mo28739tV() == 0;
    }

    public boolean isNotificationRemoved() {
        return this.notificationRemoved;
    }

    public boolean isPaused() {
        return this.mBaseDownloadTask.mo28739tV() == -2;
    }

    public boolean isRunning() {
        return this.mBaseDownloadTask.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isUserPause() {
        return this.mUserPause;
    }

    void pause() {
        this.mBaseDownloadTask.pause();
        notifyDownloadProgress(this.mBaseDownloadTask, true);
    }

    public void removeListener(AbstractC9667a abstractC9667a) {
        if (abstractC9667a != null) {
            this.mDownloadListeners.remove(abstractC9667a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume(DownloadRequest downloadRequest) {
        if (C11013ag.isNetworkConnected(C9774c.m27790xL().getContext())) {
            if (downloadRequest != null) {
                initDownloadRequestParams(downloadRequest);
                initDownloadTaskParams();
            }
            this.mUserPause = false;
            if (!this.mBaseDownloadTask.isRunning()) {
                try {
                    if (C9466d.m28676bF(this.mBaseDownloadTask.mo28739tV())) {
                        this.mBaseDownloadTask.mo28747tN();
                    }
                    submit();
                    InterfaceC9427a interfaceC9427a = this.mBaseDownloadTask;
                    onResume(interfaceC9427a, interfaceC9427a.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            InterfaceC9427a interfaceC9427a2 = this.mBaseDownloadTask;
            onResume(interfaceC9427a2, interfaceC9427a2.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
        }
    }

    public void setAllowedNetworkTypes(int i) {
        this.mAllowedNetworkTypes = i;
        this.mBaseDownloadTask.mo28752bc((i ^ 2) == 0);
    }

    public void setNotificationRemoved(boolean z) {
        this.notificationRemoved = z;
    }

    public void submit() {
        try {
            if (this.mBaseDownloadTask.isRunning()) {
                return;
            }
            this.mBaseDownloadTask.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    InterfaceC9427a unwrap() {
        return this.mBaseDownloadTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void userPause() {
        this.mUserPause = true;
        pause();
    }
}
