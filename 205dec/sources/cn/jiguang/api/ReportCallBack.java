package cn.jiguang.api;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface ReportCallBack {
    public static final int DELIVERED = 1;
    public static final int ERROR = -2;
    public static final int FAILED = -1;
    public static final int OK = 0;

    void onFinish(int i4);
}
