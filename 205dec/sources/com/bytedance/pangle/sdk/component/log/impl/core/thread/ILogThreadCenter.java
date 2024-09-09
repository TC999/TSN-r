package com.bytedance.pangle.sdk.component.log.impl.core.thread;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
interface ILogThreadCenter {
    void dispatchEvent(AdLogEventFace adLogEventFace, boolean z3);

    void notifyRunOnce(int i4);
}
