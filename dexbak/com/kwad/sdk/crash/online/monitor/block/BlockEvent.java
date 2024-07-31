package com.kwad.sdk.crash.online.monitor.block;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.util.ArrayList;
import java.util.List;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BlockEvent extends C10482a {
    public long blockTimeThreshold;
    public long blockDuration = 0;
    public long blockLoopInterval = 100;
    public long calcBlockOverhead = 0;
    public String currentActivity = "";
    public String processName = "";
    public List<C10699a> stackTraceSample = new ArrayList();

    @KsJson
    /* renamed from: com.kwad.sdk.crash.online.monitor.block.BlockEvent$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10699a extends C10482a {
        public String aGA;
        public long aGB;
        public long aGy;
        public boolean aGz = false;
        public int repeatCount;
    }
}
