package com.kwad.components.offline.api.core.api;

import java.io.File;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IZipper {
    boolean unZip(InputStream inputStream, String str);

    boolean zip(File file, File file2);

    void zipFile(File file);
}
