package com.autonavi.base.p048ae.gmap;

/* renamed from: com.autonavi.base.ae.gmap.AbstractMapMessage */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractMapMessage {
    public static final int GESTURE_STATE_BEGIN = 100;
    public static final int GESTURE_STATE_CHANGE = 101;
    public static final int GESTURE_STATE_END = 102;
    public static final int MSGTYPE_NAVIOVERLAY_STATE = 13;

    public abstract int getType();
}
