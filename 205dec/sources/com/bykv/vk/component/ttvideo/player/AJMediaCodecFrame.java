package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import java.nio.ByteBuffer;

@Keep
@TargetApi(16)
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AJMediaCodecFrame implements Cloneable {
    @Keep
    public ByteBuffer data;
    @Keep
    public int flags;
    @Keep
    public int index;
    @Keep
    public long pts = -269488145;
    @Keep
    public int size;

    /* renamed from: clone */
    public AJMediaCodecFrame m85clone() {
        try {
            return (AJMediaCodecFrame) super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
