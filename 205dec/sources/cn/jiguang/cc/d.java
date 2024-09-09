package cn.jiguang.cc;

import android.util.SparseArray;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<String> f3268a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f3268a = sparseArray;
        sparseArray.put(0, "OK");
        sparseArray.put(-1001, "Exceed buffer size. Please contact support.");
        sparseArray.put(-1000, "Connection failed. Please check your connection and retry later!");
        sparseArray.put(-998, "Sending failed or timeout. Please Retry later!");
        sparseArray.put(-997, "Receiving failed or timeout. Please Retry later!");
        sparseArray.put(-996, "Connection is closed. Please Retry later!");
        sparseArray.put(-994, "Response timeout. Please Retry later!");
        sparseArray.put(-993, "Invalid socket. Please Retry later!");
        sparseArray.put(11, "Failed to register!");
        sparseArray.put(1005, "Your appKey and android package name are not matched. Please double check them according to Application you created on Portal.");
        sparseArray.put(1006, "You android package name is not exist, Please register your pacakge name in Portal.");
        sparseArray.put(1007, "Invalid Imei, Register again.");
        sparseArray.put(1008, "Invalid appKey, Please get your Appkey from JIGUANG web console!");
        sparseArray.put(1009, "Your appKey is related to a non-Android App.Please use your Android App's appKey, or add an Android app for this appKey.");
        sparseArray.put(10000, "Receiver data parse error");
        sparseArray.put(102, "102 - Incorrect password");
        sparseArray.put(108, "108 - Incorrect uid");
        sparseArray.put(1012, "Server reject this connection, will clear cache and restart connect.");
        sparseArray.put(1000, "Context is null");
        sparseArray.put(1001, "The permission should be defined - " + cn.jiguang.a.a.f2009a);
        sparseArray.put(1002, "The permissoin is required - android.permission.INTERNET and android.permission.ACCESS_NETWORK_STATE");
        sparseArray.put(10001, "JCore appKey - not defined in manifest");
        sparseArray.put(10002, "Appkey not same with meta appkey");
        sparseArray.put(10003, "Appkey is empty");
    }

    public static String a(int i4) {
        SparseArray<String> sparseArray = f3268a;
        if (sparseArray.get(i4) == null) {
            cn.jiguang.bq.d.c("StatusCode", "Unknown error code - " + i4);
            return null;
        }
        return sparseArray.get(i4);
    }
}
