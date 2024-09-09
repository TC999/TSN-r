package cn.jpush.android.w;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public String f4479a;

    public a(String str) {
        this.f4479a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        Logger.d("DefaultHostVerifier", "host:" + str + ",checkHost:" + this.f4479a);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f4479a, str);
    }
}
