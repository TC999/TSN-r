package top.zibin.luban;

import java.io.File;

/* renamed from: top.zibin.luban.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface OnCompressListener {
    void onError(Throwable th);

    void onStart();

    void onSuccess(File file);
}
