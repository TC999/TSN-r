package com.mbridge.msdk.foundation.download.download;

import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.p478e.CommonTask;
import com.mbridge.msdk.foundation.same.p478e.CommonTaskLoader;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadTask {
    private CommonTaskLoader mLoader;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class DownloadTaskHolder {
        public static DownloadTask instance = new DownloadTask();

        private DownloadTaskHolder() {
        }
    }

    public static DownloadTask getInstance() {
        return DownloadTaskHolder.instance;
    }

    private void init() {
        if (MBSDKContext.m22865f().m22861j() != null) {
            this.mLoader = new CommonTaskLoader(MBSDKContext.m22865f().m22861j());
        }
    }

    public void runTask(CommonTask commonTask) {
        CommonTaskLoader commonTaskLoader = this.mLoader;
        if (commonTaskLoader != null) {
            commonTaskLoader.m22313b(commonTask);
        }
    }

    private DownloadTask() {
        init();
    }
}
