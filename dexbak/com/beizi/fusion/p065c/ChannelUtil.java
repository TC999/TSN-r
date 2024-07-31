package com.beizi.fusion.p065c;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import java.util.List;

/* renamed from: com.beizi.fusion.c.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ChannelUtil {

    /* renamed from: a */
    private static int f10972a;

    /* renamed from: a */
    public static AdSpacesBean m48854a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(context);
            if (!responseInfo.isInit()) {
                responseInfo.init();
            }
            Manager manager = responseInfo.getManager();
            if (manager != null) {
                List<AdSpacesBean> adSpaces = manager.getAdSpaces();
                if (adSpaces != null && adSpaces.size() > 0) {
                    for (int i = 0; i < adSpaces.size(); i++) {
                        AdSpacesBean adSpacesBean = adSpaces.get(i);
                        if (str.equals(adSpacesBean.getSpaceId())) {
                            return adSpacesBean;
                        }
                    }
                }
                m48855a(2);
                return null;
            }
            m48855a(1);
        }
        return null;
    }

    /* renamed from: a */
    public static int m48856a() {
        int i = f10972a;
        m48855a(0);
        return i;
    }

    /* renamed from: a */
    public static void m48855a(int i) {
        f10972a = i;
    }
}
