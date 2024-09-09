package cn.jiguang.net;

import android.text.TextUtils;
import cn.jiguang.bq.d;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DefaultHostVerifier implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public String f3716a;

    public DefaultHostVerifier(String str) {
        this.f3716a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        d.c("DefaultHostVerifier", "host:" + str + ",checkHost:" + this.f3716a);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f3716a, str);
    }
}
