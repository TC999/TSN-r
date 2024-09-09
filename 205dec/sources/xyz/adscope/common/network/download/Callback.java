package xyz.adscope.common.network.download;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface Callback {
    void onCancel();

    void onEnd();

    void onException(Exception exc);

    void onFinish(String str);

    void onStart();
}
