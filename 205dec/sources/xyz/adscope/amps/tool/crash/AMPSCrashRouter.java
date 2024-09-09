package xyz.adscope.amps.tool.crash;

import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.crash.inter.ICrashRouter;
import xyz.adscope.amps.tool.persistent.sp.AMPSSpUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSCrashRouter implements ICrashRouter {
    @Override // xyz.adscope.amps.tool.crash.inter.ICrashRouter
    public boolean lastLaunchCrashedBecauseOfSDK() {
        return ((Boolean) AMPSSpUtil.get(AMPSConstants.AMPS_CRASH_REASON_KEY, Boolean.FALSE)).booleanValue();
    }
}
