package xyz.adscope.ad.tool.crash;

import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;
import xyz.adscope.ad.tool.crash.inter.ICrashRouter;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CrashRouter implements ICrashRouter {
    @Override // xyz.adscope.ad.tool.crash.inter.ICrashRouter
    public boolean lastLaunchCrashedBecauseOfSDK() {
        return ((Boolean) AdScopeSpUtil.get(AdRequestConstant.CRASH_REASON_ADSCOPE_KEY, Boolean.FALSE)).booleanValue();
    }
}
