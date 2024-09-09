package com.kwad.components.offline.api.core.api;

import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IEncrypt {
    String getFileMD5(File file);

    byte[] getFileMD5Digest(File file);

    String getFileSha256(File file);

    String getMD5(String str);

    String getResponseData(String str);

    String getSha256(String str);
}
