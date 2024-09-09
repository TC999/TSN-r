package com.kwad.components.offline.api.core.api;

import androidx.annotation.WorkerThread;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IDownloader {
    @WorkerThread
    boolean downloadSync(File file, String str);
}
