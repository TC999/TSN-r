package com.umeng.socialize.tracker;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface TrackerResultHandler {
    void codeGenerateFailed(Throwable th);

    void codeGenerateSuccess(String str);
}
