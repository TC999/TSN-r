package com.beizi.fusion.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.model.Configurator;
import com.beizi.fusion.model.DevInfo;
import com.beizi.fusion.model.EnvInfo;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.Messenger;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StringUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class av {
    public static String a(Context context, String str, com.beizi.fusion.b.b bVar) {
        RequestInfo requestInfo = RequestInfo.getInstance(context);
        if (!requestInfo.isInit) {
            requestInfo.init();
        }
        DevInfo devInfo = requestInfo.getDevInfo();
        EnvInfo envInfo = requestInfo.getEnvInfo();
        if (bVar != null) {
            try {
                if (!TextUtils.isEmpty(bVar.b())) {
                    str = str.replace("__SESSIONID__", bVar.b());
                }
                if (!TextUtils.isEmpty(bVar.c())) {
                    str = str.replace("__EVENTID__", bVar.c());
                }
                if (!TextUtils.isEmpty(bVar.d())) {
                    str = str.replace("__EVENTCODE__", bVar.d());
                }
                if (!TextUtils.isEmpty(bVar.e())) {
                    str = str.replace("__ADTYPE__", bVar.e());
                }
                if (!TextUtils.isEmpty(bVar.f())) {
                    str = str.replace("__PLATFORMAPPID__", bVar.f());
                }
                if (!TextUtils.isEmpty(bVar.g())) {
                    str = str.replace("__PLATFORMPACEID__", bVar.g());
                }
                if (!TextUtils.isEmpty(bVar.i())) {
                    str = str.replace("__EVENTTIME__", bVar.i());
                }
                if (!TextUtils.isEmpty(bVar.h())) {
                    str = str.replace("__RESERVETIME__", bVar.h());
                }
                if (!TextUtils.isEmpty(bVar.j())) {
                    str = str.replace("__ERRINFO__", bVar.j());
                }
                if (!TextUtils.isEmpty(bVar.n())) {
                    str = str.replace("__EXTRA__", bVar.n());
                }
                if (!TextUtils.isEmpty(bVar.o())) {
                    str = str.replace("__ERRORCODE__", bVar.o());
                }
                if (!TextUtils.isEmpty(bVar.N())) {
                    str = str.replace("__BASEID__", bVar.N());
                }
                if (!TextUtils.isEmpty(String.valueOf(bVar.O()))) {
                    str = str.replace("__SRCTYPE__", String.valueOf(bVar.O()));
                }
                if (!TextUtils.isEmpty(bVar.P())) {
                    str = str.replace("__PRICE__", bVar.P());
                }
                if (!TextUtils.isEmpty(bVar.Q())) {
                    str = str.replace("__BIDPRICE__", bVar.Q());
                }
                if (!TextUtils.isEmpty(bVar.k())) {
                    str = str.replace("__BUYERID__", bVar.k());
                }
                if (!TextUtils.isEmpty(bVar.l())) {
                    str = str.replace("__BUYERAPPID__", bVar.l());
                }
                if (!TextUtils.isEmpty(bVar.m())) {
                    str = str.replace("__BUYERSPACEID__", bVar.m());
                }
                if (!TextUtils.isEmpty(bVar.p())) {
                    str = str.replace("__FORWARDID__", bVar.p());
                }
                if (!TextUtils.isEmpty(bVar.q())) {
                    str = str.replace("__PARENTFORWARDID__", bVar.q());
                }
                if (!TextUtils.isEmpty(bVar.r())) {
                    str = str.replace("__FORWARDLEVEL__", bVar.r());
                }
                if (!TextUtils.isEmpty(bVar.s())) {
                    str = str.replace("__BUYERSPACEUUID__", bVar.s());
                }
                if (!TextUtils.isEmpty(bVar.t())) {
                    str = str.replace("__SKIPTYPE__", bVar.t());
                }
                if (!TextUtils.isEmpty(bVar.R())) {
                    str = str.replace("__CLICKTYPE__", bVar.R());
                }
                if (!TextUtils.isEmpty(bVar.u())) {
                    str = str.replace("__GDTVERSION__", bVar.u());
                }
                if (!TextUtils.isEmpty(bVar.v())) {
                    str = str.replace("__CSJVERSION__", bVar.v());
                }
                if (!TextUtils.isEmpty(bVar.w())) {
                    str = str.replace("__KSVERSION__", bVar.w());
                }
                if (!TextUtils.isEmpty(bVar.x())) {
                    str = str.replace("__BAIDUVERSION__", bVar.x());
                }
                if (!TextUtils.isEmpty(bVar.y())) {
                    str = str.replace("__INMOBIVERSION__", bVar.y());
                }
                if (!TextUtils.isEmpty(bVar.z())) {
                    str = str.replace("__GMADVERSION__", bVar.z());
                }
                if (!TextUtils.isEmpty(bVar.A())) {
                    str = str.replace("__JADYUNVERSION__", bVar.A());
                }
                if (!TextUtils.isEmpty(bVar.B())) {
                    str = str.replace("__MTGVERSION__", bVar.B());
                }
                if (!TextUtils.isEmpty(bVar.D())) {
                    str = str.replace("__COMPONENTSSID__", bVar.D());
                }
                if (!TextUtils.isEmpty(bVar.E())) {
                    str = str.replace("__BZCOMPONENTSSID__", bVar.E());
                }
                if (!TextUtils.isEmpty(bVar.C())) {
                    str = str.replace("__PLATFORMFILTERSSID__", bVar.C());
                }
                if (!TextUtils.isEmpty(bVar.F())) {
                    str = str.replace("__CHANNELFILTERSSID__", bVar.F());
                }
                if (!TextUtils.isEmpty(bVar.G())) {
                    str = str.replace("__RENDERVIEWSSID__", bVar.G());
                }
                if (!TextUtils.isEmpty(bVar.H())) {
                    str = str.replace("__SCROLLCLICKUUID__", bVar.H());
                }
                if (!TextUtils.isEmpty(bVar.I())) {
                    str = str.replace("__SHAKEVIEWUUID__", bVar.I());
                }
                if (!TextUtils.isEmpty(bVar.L())) {
                    str = str.replace("__REGIONALCLICKUUID__", bVar.L());
                }
                if (!TextUtils.isEmpty(bVar.K())) {
                    str = str.replace("__FULLSCREENCLICKUUID__", bVar.K());
                }
                if (!TextUtils.isEmpty(bVar.J())) {
                    str = str.replace("__ROLLVIEWUUID__", bVar.J());
                }
                String M = bVar.M();
                if (!TextUtils.isEmpty(M)) {
                    str = str.replace("__ZOOMOUTAD__", M);
                }
                if (!TextUtils.isEmpty(bVar.V())) {
                    str = str.replace("__BACKSTRATEGYUUID__", bVar.V());
                }
                if (!TextUtils.isEmpty(bVar.W())) {
                    str = str.replace("__DISLIKEUUID__", bVar.W());
                }
                if (!TextUtils.isEmpty(bVar.X())) {
                    str = str.replace("__EULERANGLEUUID__", bVar.X());
                }
                if (!TextUtils.isEmpty(bVar.Y())) {
                    String d4 = bVar.d();
                    if (!TextUtils.isEmpty(d4) && "290.500".equals(d4)) {
                        str = str.replace("__COMPLAIN__", bVar.Y());
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                Log.d("BeiZis", "info:" + e4.getMessage());
                return str;
            } catch (Throwable th) {
                th.printStackTrace();
                return str;
            }
        }
        if (!TextUtils.isEmpty(requestInfo.getAppId())) {
            str = str.replace("__APPID__", requestInfo.getAppId());
        }
        if (!TextUtils.isEmpty(requestInfo.getChannelStr())) {
            str = str.replace("__CHANNELSTRING__", requestInfo.getChannelStr());
        }
        if (!TextUtils.isEmpty(requestInfo.getCustomOaid())) {
            str = str.replace("__CUSTOMOAID__", requestInfo.getCustomOaid());
        }
        String configVersion = ResponseInfo.getInstance(context).getConfigVersion();
        if (!TextUtils.isEmpty(configVersion)) {
            str = str.replace("__CONFIGVERSION__", configVersion);
        }
        Configurator configurator = ResponseInfo.getInstance(context).getConfigurator();
        if (configurator != null && !TextUtils.isEmpty(configurator.getVersion())) {
            str = str.replace("__CONFIGURATORCONFIGVERSION__", configurator.getVersion());
        }
        Manager manager = ResponseInfo.getInstance(context).getManager();
        if (manager != null && !TextUtils.isEmpty(manager.getConfigVersion())) {
            str = str.replace("__MANAGERCONFIGVERSION__", manager.getConfigVersion());
        }
        Messenger messenger = ResponseInfo.getInstance(context).getMessenger();
        if (messenger != null && !TextUtils.isEmpty(messenger.getConfigVersion())) {
            str = str.replace("__MESSENGERCONFIGVERSION__", messenger.getConfigVersion());
        }
        if (!TextUtils.isEmpty(devInfo.getPlatform())) {
            str = str.replace("__PLATFORM__", devInfo.getPlatform());
        }
        if (!TextUtils.isEmpty(requestInfo.getPackageName())) {
            str = str.replace("__PACKAGENAME__", requestInfo.getPackageName());
        }
        if (!TextUtils.isEmpty(requestInfo.getInstallTime())) {
            str = str.replace("__INSTALLTIME__", requestInfo.getInstallTime());
        }
        if (!TextUtils.isEmpty(requestInfo.getUpdateTime())) {
            str = str.replace("__UPDATETIME__", requestInfo.getUpdateTime()).replace("__UPLOADTIME__", String.valueOf(System.currentTimeMillis()));
        }
        if (!TextUtils.isEmpty(requestInfo.getAppVersion())) {
            str = str.replace("__APPVERSION__", requestInfo.getAppVersion());
        }
        if (!TextUtils.isEmpty(requestInfo.getAppVersionCode())) {
            str = str.replace("__APPVERSIONCODE__", requestInfo.getAppVersionCode());
        }
        if (!TextUtils.isEmpty(requestInfo.getSdkVersion())) {
            str = str.replace("__SDKVERSION__", requestInfo.getSdkVersion());
        }
        if (!TextUtils.isEmpty(devInfo.getSdkUID())) {
            str = str.replace("__SDKUID__", devInfo.getSdkUID());
        }
        if (!TextUtils.isEmpty(devInfo.getSdkUIDOrig())) {
            str = str.replace("__SDKUIDORIG__", devInfo.getSdkUIDOrig());
        }
        if (!TextUtils.isEmpty(devInfo.getOaid())) {
            str = str.replace("__OAID__", devInfo.getOaid());
        } else if (!TextUtils.isEmpty(requestInfo.getCustomOaid())) {
            str = str.replace("__OAID__", requestInfo.getCustomOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getHonorOaid())) {
            str = str.replace("__HONOROAID__", devInfo.getHonorOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getGaid())) {
            str = str.replace("__GAID__", devInfo.getGaid());
        }
        if (!TextUtils.isEmpty(devInfo.getSmOaid())) {
            str = str.replace("__SMOAID__", devInfo.getSmOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getCnOaid())) {
            str = str.replace("__CNOAID__", devInfo.getCnOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getMsaOaid())) {
            str = str.replace("__MSAOAID__", devInfo.getMsaOaid());
        }
        if (!TextUtils.isEmpty(devInfo.getOs())) {
            str = str.replace("__OS__", devInfo.getOs());
        }
        if (!TextUtils.isEmpty(devInfo.getDevType())) {
            str = str.replace("__DEVTYPE__", devInfo.getDevType());
        }
        if (!TextUtils.isEmpty(devInfo.getBrand())) {
            str = str.replace("__BRAND__", devInfo.getBrand());
        }
        if (!TextUtils.isEmpty(devInfo.getModel())) {
            str = str.replace("__MODEL__", devInfo.getModel());
        }
        if (!TextUtils.isEmpty(devInfo.getResolution())) {
            str = str.replace("__RESOLUTION__", devInfo.getResolution());
        }
        if (!TextUtils.isEmpty(devInfo.getScreenSize())) {
            str = str.replace("__SCREENSIZE__", devInfo.getScreenSize());
        }
        if (!TextUtils.isEmpty(devInfo.getLanguage())) {
            str = str.replace("__LANGUAGE__", devInfo.getLanguage());
        }
        if (!TextUtils.isEmpty(devInfo.getDensity())) {
            str = str.replace("__DENSITY__", devInfo.getDensity());
        }
        if (!TextUtils.isEmpty(devInfo.getRoot())) {
            str = str.replace("__ROOT__", devInfo.getRoot());
        }
        if (!TextUtils.isEmpty(devInfo.getRomVersion())) {
            str = str.replace("__ROMVERSION__", devInfo.getRomVersion());
        }
        if (!TextUtils.isEmpty(envInfo.getUserAgent())) {
            str = str.replace("__USERAGENT__", envInfo.getUserAgent());
        }
        if (!TextUtils.isEmpty(envInfo.getNet())) {
            str = str.replace("__NET__", envInfo.getNet());
        }
        if (!TextUtils.isEmpty(envInfo.getIsp())) {
            str = str.replace("__ISP__", envInfo.getIsp());
        }
        if (!TextUtils.isEmpty(envInfo.isDeveloperMode())) {
            str = str.replace("__DEVELOPERMODE__", envInfo.isDeveloperMode());
        }
        if (!TextUtils.isEmpty(envInfo.isIsDebugApk())) {
            str = str.replace("__ISDEBUGAPK__", envInfo.isIsDebugApk());
        }
        if (!TextUtils.isEmpty(envInfo.isIsDebugConnected())) {
            str = str.replace("__ISDEBUGCONNECTED__", envInfo.isIsDebugConnected());
        }
        if (!TextUtils.isEmpty(envInfo.isIsWifiProxy())) {
            str = str.replace("__ISWIFIPROXY__", envInfo.isIsWifiProxy());
        }
        AppEventId appEventId = AppEventId.getInstance(context);
        if (appEventId != null) {
            if (!TextUtils.isEmpty(appEventId.getAppStart())) {
                str = str.replace("__APPSTART__", appEventId.getAppStart());
            }
            if (!TextUtils.isEmpty(appEventId.getAppSdkInit())) {
                str = str.replace("__APPSDKINIT__", appEventId.getAppSdkInit());
            }
            if (!TextUtils.isEmpty(appEventId.getAppSplashRequest())) {
                str = str.replace("__APPSPLASHREQUEST__", appEventId.getAppSplashRequest());
            }
            if (!TextUtils.isEmpty(appEventId.getAppNativeRequest())) {
                str = str.replace("__APPNATIVEREQUEST__", appEventId.getAppNativeRequest());
            }
            if (!TextUtils.isEmpty(appEventId.getAppRewardedVideoRequest())) {
                str = str.replace("__APPREWARDEDVIDEOREQUEST__", appEventId.getAppRewardedVideoRequest());
            }
            if (!TextUtils.isEmpty(appEventId.getAppFullScreenVideoRequest())) {
                str = str.replace("__APPFULLSCREENVIDEOREQUEST__", appEventId.getAppFullScreenVideoRequest());
            }
            if (!TextUtils.isEmpty(appEventId.getAppBannerRequest())) {
                str = str.replace("__APPBANNERREQUEST__", appEventId.getAppBannerRequest());
            }
        }
        if (!TextUtils.isEmpty(envInfo.isIsLockScreen())) {
            str = str.replace("__ISLOCKSCREEN__", envInfo.isIsLockScreen());
        }
        if (!TextUtils.isEmpty(envInfo.isIsVpn())) {
            str = str.replace("__ISVPN__", envInfo.isIsVpn());
        }
        return !TextUtils.isEmpty(envInfo.isIsSimulator()) ? str.replace("__ISSIMULATOR__", envInfo.isIsSimulator()) : str;
    }

    public static String b() {
        return new StringBuilder("BUHDA").reverse().toString();
    }

    public static String a(Context context, String str, com.beizi.fusion.b.b bVar, String str2) {
        String a4 = a(context, str, bVar);
        try {
            return !TextUtils.isEmpty(str2) ? a4.replace("__APPLINKS__", str2) : a4;
        } catch (Exception e4) {
            e4.printStackTrace();
            return a4;
        }
    }

    public static String a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b4 : digest) {
                int i4 = b4 & 255;
                if (i4 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i4));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            return "";
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static String a() {
        String uuid = UUID.randomUUID().toString();
        try {
            return a(uuid);
        } catch (Exception e4) {
            e4.printStackTrace();
            return uuid;
        }
    }
}
