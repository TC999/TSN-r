package com.mbridge.msdk.out;

import android.content.Context;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class MBCommonHandler {
    protected Context context;
    protected Map<String, Object> properties;

    public MBCommonHandler() {
    }

    public abstract boolean load();

    public abstract void release();

    public MBCommonHandler(Map<String, Object> map, Context context) {
        this.properties = map;
        this.context = context;
    }
}
