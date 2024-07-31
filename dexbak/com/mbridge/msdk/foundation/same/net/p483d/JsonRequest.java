package com.mbridge.msdk.foundation.same.net.p483d;

import com.mbridge.msdk.foundation.same.net.AbstractC11354i;
import com.mbridge.msdk.foundation.same.net.IListener;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.UnsupportedEncodingException;

/* renamed from: com.mbridge.msdk.foundation.same.net.d.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class JsonRequest<T> extends AbstractC11354i<T> {

    /* renamed from: c */
    private static final String f30741c = JsonRequest.class.getSimpleName();

    /* renamed from: d */
    private final String f30742d;

    public JsonRequest(int i, String str, String str2, IListener<T> iListener) {
        super(i, str, iListener);
        this.f30742d = str2;
    }

    @Override // com.mbridge.msdk.foundation.same.net.AbstractC11354i
    /* renamed from: e */
    public final byte[] mo22194e() {
        try {
            String str = this.f30742d;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            String str2 = f30741c;
            SameLogTool.m21733d(str2, "Unsupported Encoding while trying to get the bytes of " + this.f30742d + " using utf-8");
            return null;
        }
    }
}
