package xyz.adscope.amps.tool.persistent.sp;

import android.content.Context;
import java.util.Map;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.common.sp.CommonSpUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSSpUtil {
    private static final String FILE_NAME = "amps_share_preference_config";

    public static void clear(Context context) {
        CommonSpUtil.clear(AMPSSDKManager.getInstance().getContext());
    }

    public static boolean contains(String str) {
        return CommonSpUtil.contains(AMPSSDKManager.getInstance().getContext(), str);
    }

    public static Object get(String str, Object obj) {
        return CommonSpUtil.get(AMPSSDKManager.getInstance().getContext(), FILE_NAME, str, obj);
    }

    public static Map<String, ?> getAll() {
        return CommonSpUtil.getAll(AMPSSDKManager.getInstance().getContext());
    }

    public static String getString(String str) {
        return CommonSpUtil.getString(AMPSSDKManager.getInstance().getContext(), FILE_NAME, str);
    }

    public static void put(String str, Object obj) {
        CommonSpUtil.putCommit(AMPSSDKManager.getInstance().getContext(), FILE_NAME, str, obj);
    }

    public static void putString(String str, String str2) {
        CommonSpUtil.putString(AMPSSDKManager.getInstance().getContext(), FILE_NAME, str, str2);
    }

    public static void remove(String str) {
        CommonSpUtil.remove(AMPSSDKManager.getInstance().getContext(), str);
    }
}
