package com.beizi.fusion.p072g;

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
import com.beizi.fusion.p064b.EventBean;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.UByte;

/* renamed from: com.beizi.fusion.g.au */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class StringUtil {
    /* renamed from: a */
    public static String m48310a(Context context, String str, EventBean eventBean) {
        RequestInfo requestInfo = RequestInfo.getInstance(context);
        if (!requestInfo.isInit) {
            requestInfo.init();
        }
        DevInfo devInfo = requestInfo.getDevInfo();
        EnvInfo envInfo = requestInfo.getEnvInfo();
        if (eventBean != null) {
            try {
                if (!TextUtils.isEmpty(eventBean.m48920b())) {
                    str = str.replace("__SESSIONID__", eventBean.m48920b());
                }
                if (!TextUtils.isEmpty(eventBean.m48918c())) {
                    str = str.replace("__EVENTID__", eventBean.m48918c());
                }
                if (!TextUtils.isEmpty(eventBean.m48916d())) {
                    str = str.replace("__EVENTCODE__", eventBean.m48916d());
                }
                if (!TextUtils.isEmpty(eventBean.m48914e())) {
                    str = str.replace("__ADTYPE__", eventBean.m48914e());
                }
                if (!TextUtils.isEmpty(eventBean.m48912f())) {
                    str = str.replace("__PLATFORMAPPID__", eventBean.m48912f());
                }
                if (!TextUtils.isEmpty(eventBean.m48910g())) {
                    str = str.replace("__PLATFORMPACEID__", eventBean.m48910g());
                }
                if (!TextUtils.isEmpty(eventBean.m48906i())) {
                    str = str.replace("__EVENTTIME__", eventBean.m48906i());
                }
                if (!TextUtils.isEmpty(eventBean.m48908h())) {
                    str = str.replace("__RESERVETIME__", eventBean.m48908h());
                }
                if (!TextUtils.isEmpty(eventBean.m48904j())) {
                    str = str.replace("__ERRINFO__", eventBean.m48904j());
                }
                if (!TextUtils.isEmpty(eventBean.m48896n())) {
                    str = str.replace("__EXTRA__", eventBean.m48896n());
                }
                if (!TextUtils.isEmpty(eventBean.m48894o())) {
                    str = str.replace("__ERRORCODE__", eventBean.m48894o());
                }
                if (!TextUtils.isEmpty(eventBean.m48941N())) {
                    str = str.replace("__BASEID__", eventBean.m48941N());
                }
                if (!TextUtils.isEmpty(String.valueOf(eventBean.m48939O()))) {
                    str = str.replace("__SRCTYPE__", String.valueOf(eventBean.m48939O()));
                }
                if (!TextUtils.isEmpty(eventBean.m48937P())) {
                    str = str.replace("__PRICE__", eventBean.m48937P());
                }
                if (!TextUtils.isEmpty(eventBean.m48935Q())) {
                    str = str.replace("__BIDPRICE__", eventBean.m48935Q());
                }
                if (!TextUtils.isEmpty(eventBean.m48902k())) {
                    str = str.replace("__BUYERID__", eventBean.m48902k());
                }
                if (!TextUtils.isEmpty(eventBean.m48900l())) {
                    str = str.replace("__BUYERAPPID__", eventBean.m48900l());
                }
                if (!TextUtils.isEmpty(eventBean.m48898m())) {
                    str = str.replace("__BUYERSPACEID__", eventBean.m48898m());
                }
                if (!TextUtils.isEmpty(eventBean.m48892p())) {
                    str = str.replace("__FORWARDID__", eventBean.m48892p());
                }
                if (!TextUtils.isEmpty(eventBean.m48890q())) {
                    str = str.replace("__PARENTFORWARDID__", eventBean.m48890q());
                }
                if (!TextUtils.isEmpty(eventBean.m48888r())) {
                    str = str.replace("__FORWARDLEVEL__", eventBean.m48888r());
                }
                if (!TextUtils.isEmpty(eventBean.m48886s())) {
                    str = str.replace("__BUYERSPACEUUID__", eventBean.m48886s());
                }
                if (!TextUtils.isEmpty(eventBean.m48884t())) {
                    str = str.replace("__SKIPTYPE__", eventBean.m48884t());
                }
                if (!TextUtils.isEmpty(eventBean.m48933R())) {
                    str = str.replace("__CLICKTYPE__", eventBean.m48933R());
                }
                if (!TextUtils.isEmpty(eventBean.m48882u())) {
                    str = str.replace("__GDTVERSION__", eventBean.m48882u());
                }
                if (!TextUtils.isEmpty(eventBean.m48880v())) {
                    str = str.replace("__CSJVERSION__", eventBean.m48880v());
                }
                if (!TextUtils.isEmpty(eventBean.m48878w())) {
                    str = str.replace("__KSVERSION__", eventBean.m48878w());
                }
                if (!TextUtils.isEmpty(eventBean.m48876x())) {
                    str = str.replace("__BAIDUVERSION__", eventBean.m48876x());
                }
                if (!TextUtils.isEmpty(eventBean.m48874y())) {
                    str = str.replace("__INMOBIVERSION__", eventBean.m48874y());
                }
                if (!TextUtils.isEmpty(eventBean.m48872z())) {
                    str = str.replace("__GMADVERSION__", eventBean.m48872z());
                }
                if (!TextUtils.isEmpty(eventBean.m48967A())) {
                    str = str.replace("__JADYUNVERSION__", eventBean.m48967A());
                }
                if (!TextUtils.isEmpty(eventBean.m48965B())) {
                    str = str.replace("__MTGVERSION__", eventBean.m48965B());
                }
                if (!TextUtils.isEmpty(eventBean.m48961D())) {
                    str = str.replace("__COMPONENTSSID__", eventBean.m48961D());
                }
                if (!TextUtils.isEmpty(eventBean.m48959E())) {
                    str = str.replace("__BZCOMPONENTSSID__", eventBean.m48959E());
                }
                if (!TextUtils.isEmpty(eventBean.m48963C())) {
                    str = str.replace("__PLATFORMFILTERSSID__", eventBean.m48963C());
                }
                if (!TextUtils.isEmpty(eventBean.m48957F())) {
                    str = str.replace("__CHANNELFILTERSSID__", eventBean.m48957F());
                }
                if (!TextUtils.isEmpty(eventBean.m48955G())) {
                    str = str.replace("__RENDERVIEWSSID__", eventBean.m48955G());
                }
                if (!TextUtils.isEmpty(eventBean.m48953H())) {
                    str = str.replace("__SCROLLCLICKUUID__", eventBean.m48953H());
                }
                if (!TextUtils.isEmpty(eventBean.m48951I())) {
                    str = str.replace("__SHAKEVIEWUUID__", eventBean.m48951I());
                }
                if (!TextUtils.isEmpty(eventBean.m48945L())) {
                    str = str.replace("__REGIONALCLICKUUID__", eventBean.m48945L());
                }
                if (!TextUtils.isEmpty(eventBean.m48947K())) {
                    str = str.replace("__FULLSCREENCLICKUUID__", eventBean.m48947K());
                }
                if (!TextUtils.isEmpty(eventBean.m48949J())) {
                    str = str.replace("__ROLLVIEWUUID__", eventBean.m48949J());
                }
                String m48943M = eventBean.m48943M();
                if (!TextUtils.isEmpty(m48943M)) {
                    str = str.replace("__ZOOMOUTAD__", m48943M);
                }
                if (!TextUtils.isEmpty(eventBean.m48927V())) {
                    str = str.replace("__BACKSTRATEGYUUID__", eventBean.m48927V());
                }
                if (!TextUtils.isEmpty(eventBean.m48926W())) {
                    str = str.replace("__DISLIKEUUID__", eventBean.m48926W());
                }
                if (!TextUtils.isEmpty(eventBean.m48925X())) {
                    str = str.replace("__EULERANGLEUUID__", eventBean.m48925X());
                }
                if (!TextUtils.isEmpty(eventBean.m48924Y())) {
                    String m48916d = eventBean.m48916d();
                    if (!TextUtils.isEmpty(m48916d) && "290.500".equals(m48916d)) {
                        str = str.replace("__COMPLAIN__", eventBean.m48924Y());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("BeiZis", "info:" + e.getMessage());
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

    /* renamed from: b */
    public static String m48307b() {
        return new StringBuilder("BUHDA").reverse().toString();
    }

    /* renamed from: a */
    public static String m48311a(Context context, String str) {
        RequestInfo requestInfo = RequestInfo.getInstance(context);
        if (!requestInfo.isInit) {
            requestInfo.init();
        }
        DevInfo devInfo = requestInfo.getDevInfo();
        EnvInfo envInfo = requestInfo.getEnvInfo();
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("BeiZis", "info:" + e.getMessage());
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    /* renamed from: a */
    public static String m48309a(Context context, String str, EventBean eventBean, String str2) {
        String m48310a = m48310a(context, str, eventBean);
        try {
            return !TextUtils.isEmpty(str2) ? m48310a.replace("__APPLINKS__", str2) : m48310a;
        } catch (Exception e) {
            e.printStackTrace();
            return m48310a;
        }
    }

    /* renamed from: a */
    public static String m48308a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i = b & UByte.f41242c;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m48312a() {
        String uuid = UUID.randomUUID().toString();
        try {
            return m48308a(uuid);
        } catch (Exception e) {
            e.printStackTrace();
            return uuid;
        }
    }
}
