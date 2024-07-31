package com.tencent.p562mm.opensdk.modelbiz;

import android.os.Bundle;

/* renamed from: com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface IWXChannelJumpInfo {
    public static final int WX_CHANNEL_JUMP_TYPE_MINI_PROGRAM = 1;
    public static final int WX_CHANNEL_JUMP_TYPE_UNKNOWN = 0;
    public static final int WX_CHANNEL_JUMP_TYPE_URL = 2;

    boolean checkArgs();

    void serialize(Bundle bundle);

    int type();

    void unserialize(Bundle bundle);
}
