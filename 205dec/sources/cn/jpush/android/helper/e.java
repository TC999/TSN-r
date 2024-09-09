package cn.jpush.android.helper;

import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<Long, String> f4224a;

    static {
        HashMap<Long, String> hashMap = new HashMap<>();
        f4224a = hashMap;
        hashMap.put(1060L, "need not show notification by foreground");
        hashMap.put(1061L, "need not show notification by isNeedShowNotification return false");
        hashMap.put(1032L, "MSG already cancle");
        hashMap.put(1033L, "overide msg already cancle");
        hashMap.put(1034L, "MSG already end");
        hashMap.put(1035L, "msg delay show");
        hashMap.put(1036L, "notification disabled");
        hashMap.put(1037L, "notification channel disabled");
        hashMap.put(972L, "Deep link set small icon failed");
        hashMap.put(973L, "Deep link set large icon failed");
        hashMap.put(976L, "Deep link jump success");
        hashMap.put(977L, "Deep link jump failed");
        hashMap.put(978L, "Fail Deep link jump success");
        hashMap.put(979L, "Fail Deep link jump failed");
        hashMap.put(993L, "target app uninstall,not found target app small icon");
        hashMap.put(986L, "Message is not in push time");
        hashMap.put(988L, "Deep link target app uninstalled");
        hashMap.put(995L, "Message JSON parsing succeed");
        hashMap.put(996L, "Message JSON parsing failed");
        hashMap.put(1000L, "User clicked and opened the Message");
        hashMap.put(1028L, "User clicked and opened the Message from JPushInterface.reportNotificationOpened");
        hashMap.put(1068L, "User clear the JPush Notification from JPushReportHelper.reportMsgResult");
        hashMap.put(1069L, "User clear the OS Push Notification from JPushReportHelper.reportThirdSDKMsgActionResult");
        hashMap.put(1006L, "User clicked 'Cancel'");
        hashMap.put(1100L, "Invalid param or unexpected result.");
        hashMap.put(1014L, "Failed to preload required resource");
        hashMap.put(1016L, "User clicked the webview's url");
        hashMap.put(1018L, "The Message show in the status bar");
        hashMap.put(1020L, "Down image failed");
        hashMap.put(1021L, "Down html failed");
        hashMap.put(1075L, "Open WX miniprogram failed");
        hashMap.put(1080L, "show notification make unknown error");
        hashMap.put(1106L, "the custom message show");
    }

    private static long a(byte b4) {
        switch (b4) {
            case 1:
                return 11000000L;
            case 2:
                return 12000000L;
            case 3:
                return 13000000L;
            case 4:
                return 14000000L;
            case 5:
                return 15000000L;
            case 6:
                return 16000000L;
            case 7:
                return 17000000L;
            case 8:
                return 18000000L;
            default:
                return 10000000L;
        }
    }

    public static long a(byte b4, int i4, long j4) {
        return a(b4) + a(i4) + j4;
    }

    private static long a(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return i4 != 3 ? i4 != 4 ? -1L : 130000L : PolicyConfig.THREAD_BLOCK_TIMEOUT;
            }
            return 110000L;
        }
        return 100000L;
    }

    public static long a(int i4, long j4) {
        return a((byte) 0, i4, j4);
    }

    public static String a(long j4) {
        HashMap<Long, String> hashMap = f4224a;
        if (hashMap.get(Long.valueOf(j4)) == null) {
            Logger.d("StatusCode", "Unknown report code - " + j4);
            return "";
        }
        return hashMap.get(Long.valueOf(j4));
    }
}
