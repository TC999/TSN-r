package cn.jpush.android.asus;

import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.api.JThirdPlatFormInterface;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends JThirdPlatFormInterface {
    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void clearAllNotification(Context context) {
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void clearNotification(Context context, int i4) {
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getAppId(Context context) {
        return a.f(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getAppkey(Context context) {
        return a.e(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getRomName() {
        return a.f4056a;
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public byte getRomType(Context context) {
        return a.d(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getToken(Context context) {
        return a.g(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void init(Context context) {
        a.b(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public boolean isNeedClearToken(Context context) {
        return a.h(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public boolean isSupport(Context context) {
        return a.a(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void register(Context context, Bundle bundle) {
        a.c(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void resumePush(Context context) {
        cn.jpush.android.c.b.b(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void stopPush(Context context) {
        cn.jpush.android.c.b.c(context);
    }
}
