package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.aq;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PromoteInstallManager {
    private PromoteInstallListener promoteInstallListener;
    private aq promoteInstallProd;

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface PromoteInstallListener {
        void onFail(String str);

        void onSuccess();
    }

    public PromoteInstallManager(Context context, PromoteInstallListener promoteInstallListener) {
        this.promoteInstallListener = promoteInstallListener;
        if (context != null) {
            this.promoteInstallProd = aq.a(context, promoteInstallListener);
        } else if (promoteInstallListener != null) {
            promoteInstallListener.onFail("context\u4e3a\u7a7a \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    public IPromoteInstallAdInfo getPromoteInstallAdInfo() {
        aq aqVar = this.promoteInstallProd;
        if (aqVar != null && aqVar.a() && this.promoteInstallProd.b() == 1) {
            return this.promoteInstallProd.a(false);
        }
        PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener != null) {
            promoteInstallListener.onFail("\u529f\u80fd\u672a\u52a0\u767d\uff0c\u8bf7\u8054\u7cfb\u5bf9\u5e94\u7684\u5546\u52a1\u540c\u5b66");
        }
        return null;
    }

    public void showPromoteInstallDialog() {
        aq aqVar = this.promoteInstallProd;
        if (aqVar != null && aqVar.a() && this.promoteInstallProd.b() == 0) {
            this.promoteInstallProd.a(true);
            return;
        }
        PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener != null) {
            promoteInstallListener.onFail("\u529f\u80fd\u672a\u52a0\u767d\uff0c\u8bf7\u8054\u7cfb\u5bf9\u5e94\u7684\u5546\u52a1\u540c\u5b66");
        }
    }
}
