package xyz.adscope.ad.control.action.download;

import android.text.TextUtils;
import xyz.adscope.ad.model.http.response.ad.DwinfoModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DownloadUtil {
    public static String getAppIntroContent(DwinfoModel dwinfoModel) {
        return !TextUtils.isEmpty(dwinfoModel.getAppintro()) ? dwinfoModel.getAppintro() : "";
    }

    public static String getPermissionContent(DwinfoModel dwinfoModel) {
        if (!TextUtils.isEmpty(dwinfoModel.getPermissionUrl())) {
            return dwinfoModel.getPermissionUrl();
        }
        StringBuilder sb = new StringBuilder();
        if (dwinfoModel.getPermission() == null || dwinfoModel.getPermission().size() <= 0) {
            return "";
        }
        for (int i4 = 0; i4 < dwinfoModel.getPermission().size(); i4++) {
            String title = dwinfoModel.getPermission().get(i4).getTitle();
            String describe = dwinfoModel.getPermission().get(i4).getDescribe();
            if (i4 == 0) {
                sb.append(title);
                sb.append(":");
                sb.append(describe);
            } else {
                sb.append("\n");
                sb.append(title);
                sb.append(":");
                sb.append(describe);
            }
        }
        return sb.toString();
    }

    public static String getPolicyContent(DwinfoModel dwinfoModel) {
        if (TextUtils.isEmpty(dwinfoModel.getPolicyUrl())) {
            return !TextUtils.isEmpty(dwinfoModel.getPolicy()) ? dwinfoModel.getPolicy() : "";
        }
        return dwinfoModel.getPolicyUrl();
    }
}
