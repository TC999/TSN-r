package top.zibin.luban;

import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: OnCompressListener.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public interface d {
    void onError(Throwable th);

    void onStart();

    void onSuccess(File file);
}
