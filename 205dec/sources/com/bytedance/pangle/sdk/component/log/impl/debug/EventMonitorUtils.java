package com.bytedance.pangle.sdk.component.log.impl.debug;

import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class EventMonitorUtils {
    public static void add(AtomicLong atomicLong, int i4) {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null || !adLogDepend.isOpenMonitor() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i4);
    }
}
