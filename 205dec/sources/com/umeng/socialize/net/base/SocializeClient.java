package com.umeng.socialize.net.base;

import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.UClient;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocializeClient extends UClient {
    public SocializeReseponse execute(URequest uRequest) {
        if (SocializeConstants.DEBUG_MODE) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e4) {
                SLog.error(e4);
            }
        }
        return (SocializeReseponse) super.execute(uRequest, uRequest.mResponseClz);
    }
}
