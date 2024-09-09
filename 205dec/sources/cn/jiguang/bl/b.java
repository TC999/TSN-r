package cn.jiguang.bl;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.bq.d;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static Object a(Context context, String str, Bundle bundle, Object... objArr) {
        char c4 = '\uffff';
        try {
            switch (str.hashCode()) {
                case -2013563336:
                    if (str.equals("sp_read")) {
                        c4 = 20;
                        break;
                    }
                    break;
                case -1927222506:
                    if (str.equals("getPluginPlatformType")) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case -1813271621:
                    if (str.equals("isOnlyVerifiSDK")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -1070001513:
                    if (str.equals("dealCommandInternalDebug")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1055370707:
                    if (str.equals("isForeGround")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -896248204:
                    if (str.equals("sp_get")) {
                        c4 = 18;
                        break;
                    }
                    break;
                case -896236672:
                    if (str.equals("sp_set")) {
                        c4 = 16;
                        break;
                    }
                    break;
                case -641851682:
                    if (str.equals("getSdkVersionByRegProperty")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case -533027929:
                    if (str.equals("isPluginJPush")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case -357369928:
                    if (str.equals("isPluginVerification")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case -291103231:
                    if (str.equals("sp_getWithNull")) {
                        c4 = 19;
                        break;
                    }
                    break;
                case 378894569:
                    if (str.equals("httpResponse")) {
                        c4 = 22;
                        break;
                    }
                    break;
                case 383192179:
                    if (str.equals("getPluginPlatformRegId")) {
                        c4 = '\n';
                        break;
                    }
                    break;
                case 386432111:
                    if (str.equals("getRegBussiness")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 422259680:
                    if (str.equals("isSDKInit")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 826647026:
                    if (str.equals("configShareProcess")) {
                        c4 = 14;
                        break;
                    }
                    break;
                case 866478881:
                    if (str.equals("isIsPluginJOperate")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 881933408:
                    if (str.equals("sp_sync_set")) {
                        c4 = 17;
                        break;
                    }
                    break;
                case 931175290:
                    if (str.equals("uncaughtException")) {
                        c4 = 15;
                        break;
                    }
                    break;
                case 1186364269:
                    if (str.equals("getAppVersion")) {
                        c4 = '\r';
                        break;
                    }
                    break;
                case 1374456824:
                    if (str.equals("loadPInfo")) {
                        c4 = '\f';
                        break;
                    }
                    break;
                case 1990405611:
                    if (str.equals("sp_clear")) {
                        c4 = 21;
                        break;
                    }
                    break;
                case 2046458677:
                    if (str.equals("getSdkDataByCmd")) {
                        c4 = 11;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    c.a(context, (JSONObject) objArr[0]);
                    return null;
                case 1:
                    return Boolean.valueOf(c.a());
                case 2:
                    return Boolean.valueOf(c.b());
                case 3:
                    cn.jiguang.bk.c.a();
                    return Boolean.valueOf(cn.jiguang.bk.c.b());
                case 4:
                    return Boolean.valueOf(cn.jiguang.bk.c.a().e());
                case 5:
                    return Boolean.valueOf(cn.jiguang.bk.c.a().h());
                case 6:
                    return Boolean.valueOf(cn.jiguang.bk.c.a().g());
                case 7:
                    return Long.valueOf(c.c());
                case '\b':
                    return c.a(bundle.getInt("regProperty"));
                case '\t':
                    return Byte.valueOf(c.a(context));
                case '\n':
                    return c.b(context);
                case 11:
                    return c.a(context, bundle.getString("sdkType"), bundle.getInt("cmd"));
                case '\f':
                    return c.d();
                case '\r':
                    return c.c(context);
                case 14:
                    c.b(context, (JSONObject) objArr[0]);
                    return null;
                case 15:
                    c.a((Thread) objArr[0], (Throwable) objArr[1]);
                    return null;
                case 16:
                    c.a(context, objArr);
                    return null;
                case 17:
                    c.b(context, objArr);
                    return null;
                case 18:
                    return c.a(context, bundle, objArr);
                case 19:
                    return c.b(context, bundle, objArr);
                case 20:
                    c.c(context, objArr);
                    return null;
                case 21:
                    c.a(context, bundle);
                    return null;
                case 22:
                    return c.c(context, bundle, objArr);
                default:
                    return null;
            }
        } catch (Throwable th) {
            d.i("JPortraitToJCore", "onEvent:" + th);
            return null;
        }
    }
}
