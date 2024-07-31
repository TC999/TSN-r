package com.mbridge.msdk.foundation.same.net.p483d;

import com.mbridge.msdk.foundation.same.net.AbstractC11354i;
import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.IListener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p485f.HttpUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.UnsupportedEncodingException;

/* renamed from: com.mbridge.msdk.foundation.same.net.d.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class StringRequest extends AbstractC11354i<String> {

    /* renamed from: c */
    private static final String f30743c = StringRequest.class.getSimpleName();

    /* renamed from: d */
    private String f30744d;

    public StringRequest(int i, String str, String str2, IListener<String> iListener) {
        super(i, str, iListener);
        this.f30744d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.foundation.same.net.AbstractC11354i
    /* renamed from: a */
    public final C11356k<String> mo22205a(NetworkResponse networkResponse) {
        try {
            return C11356k.m22175a(new String(networkResponse.f30752b, HttpUtils.m22257a(networkResponse.f30754d)), networkResponse);
        } catch (UnsupportedEncodingException e) {
            SameLogTool.m21733d(f30743c, e.getMessage());
            return C11356k.m22176a(new CommonError(8, networkResponse));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.AbstractC11354i
    /* renamed from: e */
    public final byte[] mo22194e() {
        try {
            String str = this.f30744d;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            String str2 = f30743c;
            SameLogTool.m21733d(str2, "Unsupported Encoding while trying to get the bytes of " + this.f30744d + " using utf-8");
            return null;
        }
    }
}
