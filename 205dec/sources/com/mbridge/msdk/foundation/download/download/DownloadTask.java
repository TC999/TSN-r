package com.mbridge.msdk.foundation.download.download;

import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.same.e.b;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DownloadTask {
    private b mLoader;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class DownloadTaskHolder {
        public static DownloadTask instance = new DownloadTask();

        private DownloadTaskHolder() {
        }
    }

    public static DownloadTask getInstance() {
        return DownloadTaskHolder.instance;
    }

    private void init() {
        if (a.f().j() != null) {
            this.mLoader = new b(a.f().j());
        }
    }

    public void runTask(com.mbridge.msdk.foundation.same.e.a aVar) {
        b bVar = this.mLoader;
        if (bVar != null) {
            bVar.b(aVar);
        }
    }

    private DownloadTask() {
        init();
    }
}
