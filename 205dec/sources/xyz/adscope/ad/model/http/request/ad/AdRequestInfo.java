package xyz.adscope.ad.model.http.request.ad;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.advertisings.model.AdParameters;
import xyz.adscope.ad.config.AdInitConfig;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.template.TemplateManager;
import xyz.adscope.ad.init.InitImplement;
import xyz.adscope.ad.model.http.request.ad.DeviceModel;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestEnum;
import xyz.adscope.ad.model.http.request.config.ConfigRequestInfo;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.common.info.AppInfo;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.Base64Util;
import xyz.adscope.common.tool.utils.UniqIdUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdRequestInfo {
    private static final int BID_MAX_TIME = 5000;
    private static final int ITEM_EXP_TIME = 1200;
    private static AdRequestInfo mInstance;
    private AdInitConfig adInitConfig;
    private AdParameters adParameters;
    private AdRequestModel adRequestModel;
    private String apiKey;
    private List<AppInstallModel> appInstallList;
    private String LOCAL_RENDER_ID_KEY = "localRenderId";
    private String LOCAL_INTERACTION_ID_KEY = "localInteractionId";
    public boolean isInit = false;

    private AdRequestInfo() {
    }

    private String generateBuyerId() {
        String sdkid = AdScopeSDK.getContext() != null ? DeviceInfo.getInstance(AdScopeSDK.getContext()).getSdkid() : "";
        return Base64Util.encode(sdkid + (new Random().nextInt(100) + 1));
    }

    private String getAdRequestId() {
        return UniqIdUtil.getInstance().getUniqID();
    }

    private ContextModel getContext() {
        AdParameters adParameters;
        ContextModel contextModel = new ContextModel();
        AppModel appModel = new AppModel();
        if (AdScopeSDK.getContext() != null) {
            appModel.setBundle(AppInfo.getPackName(AdScopeSDK.getContext()));
            appModel.setInstall(AppInfo.getInstallDate(AdScopeSDK.getContext()));
            appModel.setUpdate(AppInfo.getLastUpdateTime(AdScopeSDK.getContext()));
            appModel.setName(AppInfo.getAppName(AdScopeSDK.getContext()));
            appModel.setVer(AppInfo.getVerCode(AdScopeSDK.getContext()));
        }
        AdInitConfig adInitConfig = this.adInitConfig;
        if (adInitConfig != null) {
            appModel.setAppId(adInitConfig.getAppId());
        }
        contextModel.setApp(appModel);
        UserModel userModel = new UserModel();
        AdInitConfig adInitConfig2 = this.adInitConfig;
        if (adInitConfig2 != null && !TextUtils.isEmpty(adInitConfig2.getUserId())) {
            userModel.setId(this.adInitConfig.getUserId());
        }
        ArrayList arrayList = new ArrayList();
        AdInitConfig adInitConfig3 = this.adInitConfig;
        if (adInitConfig3 != null && adInitConfig3.getOptionalFields() != null && !this.adInitConfig.getOptionalFields().isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : this.adInitConfig.getOptionalFields().entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", entry.getKey());
                    jSONObject.put("name", entry.getValue());
                    arrayList.add(jSONObject);
                }
            } catch (JSONException e4) {
                String str = Constants.TAG;
                LogUtil.e(str, "e : " + e4);
            }
        }
        userModel.setData(arrayList);
        contextModel.setUser(userModel);
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setType(DeviceModel.DEVICE_TYPE.TYPE_PHONE.getCode());
        AdInitConfig adInitConfig4 = this.adInitConfig;
        if (adInitConfig4 != null ? adInitConfig4.getPersonalRecommend() : true) {
            deviceModel.setLmt(DeviceModel.LMT_TYPE.LMT_NO_LIMIT.getCode());
        } else {
            deviceModel.setLmt(DeviceModel.LMT_TYPE.LMT_LIMIT.getCode());
        }
        DeviceInfo deviceInfo = DeviceInfo.getInstance(AdScopeSDK.getContext());
        if (deviceInfo != null) {
            deviceModel.setUa(deviceInfo.getUserAgent());
            deviceModel.setMake(deviceInfo.getModel());
            deviceModel.setBrand(deviceInfo.getBrand());
            deviceModel.setModel(deviceInfo.getModel());
            if (!TextUtils.isEmpty(deviceInfo.getOs())) {
                deviceModel.setOs(Integer.parseInt(deviceInfo.getOs()));
            }
            deviceModel.setOsv(deviceInfo.getOsVersion());
            deviceModel.setH(deviceInfo.getScreenHeight());
            deviceModel.setW(deviceInfo.getScreenWidth());
            deviceModel.setPpi(((int) deviceInfo.getPpi()) + "");
            deviceModel.setPxratio(deviceInfo.getPxRation() + "");
            deviceModel.setLang(deviceInfo.getLanguage());
            deviceModel.setCarrier(deviceInfo.getCarrier());
            deviceModel.setContype(deviceInfo.getConnectType());
            deviceModel.setHmsCoreVersion(deviceInfo.getHmsCoreVersion());
        }
        JSONObject jSONObject2 = new JSONObject();
        if (deviceInfo != null) {
            try {
                if (!TextUtils.isEmpty(deviceInfo.getAv())) {
                    jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_AV_KEY, Integer.valueOf(deviceInfo.getAv()));
                }
                jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_SDKID_KEY, deviceInfo.getSdkid());
                jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_SAID_KEY, deviceInfo.getSdkid());
                jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_UPDATE_MARK_KEY, deviceInfo.getUpdateMark());
                jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_BOOK_MARK_KEY, deviceInfo.getBootMark());
                jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_FILE_MARK_KEY, deviceInfo.getFileMark());
                AdInitConfig adInitConfig5 = this.adInitConfig;
                if (adInitConfig5 != null && adInitConfig5.getPersonalRecommend()) {
                    jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, deviceInfo.getOaid());
                    jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, deviceInfo.getGaid());
                }
            } catch (JSONException e5) {
                String str2 = Constants.TAG;
                LogUtil.e(str2, "e : " + e5);
            }
        }
        AdInitConfig adInitConfig6 = this.adInitConfig;
        if (adInitConfig6 != null && !TextUtils.isEmpty(adInitConfig6.getCoaid())) {
            jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_COAID_KEY, this.adInitConfig.getCoaid());
        }
        AdInitConfig adInitConfig7 = this.adInitConfig;
        if (adInitConfig7 != null && !TextUtils.isEmpty(adInitConfig7.getCgaid())) {
            jSONObject2.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_CGAID_KEY, this.adInitConfig.getCgaid());
        }
        deviceModel.setExt(jSONObject2);
        contextModel.setDevice(deviceModel);
        RegsModel regsModel = new RegsModel();
        AdInitConfig adInitConfig8 = this.adInitConfig;
        if (adInitConfig8 != null) {
            regsModel.setCcpa(adInitConfig8.CCPA());
            regsModel.setGdpr(this.adInitConfig.GDPR());
            regsModel.setCoppa(this.adInitConfig.coppa());
        }
        contextModel.setRegs(regsModel);
        JSONObject jSONObject3 = new JSONObject();
        List<AppInstallModel> appInstall = getAppInstall();
        if (appInstall != null) {
            try {
            } catch (JSONException e6) {
                String str3 = Constants.TAG;
                LogUtil.e(str3, "e : " + e6);
            }
            if (appInstall.size() >= 1) {
                jSONObject3.put(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_KEY, new JSONArray(appInstall.toString()));
                jSONObject3.put(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_BUYER_ID_KEY, generateBuyerId());
                adParameters = this.adParameters;
                if (adParameters != null && !TextUtils.isEmpty(adParameters.getBidToken())) {
                    jSONObject3.put(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_BID_TOKEN_KEY, this.adParameters.getBidToken());
                }
                contextModel.setExt(jSONObject3);
                return contextModel;
            }
        }
        String string = AdScopeSpUtil.getString(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_KEY + this.apiKey);
        if (!TextUtils.isEmpty(string)) {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() > 0) {
                jSONObject3.put(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_KEY, jSONArray);
            }
        }
        jSONObject3.put(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_BUYER_ID_KEY, generateBuyerId());
        adParameters = this.adParameters;
        if (adParameters != null) {
            jSONObject3.put(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_BID_TOKEN_KEY, this.adParameters.getBidToken());
        }
        contextModel.setExt(jSONObject3);
        return contextModel;
    }

    private List<String> getCurList() {
        ArrayList arrayList = new ArrayList();
        AdInitConfig adInitConfig = this.adInitConfig;
        if (adInitConfig != null && !TextUtils.isEmpty(adInitConfig.getCurrency())) {
            arrayList.add(this.adInitConfig.getCurrency());
        } else {
            arrayList.add(AdRequestEnum.CURRENCY_TYPE.CURRENCY_TYPE_CNY.getType());
        }
        return arrayList;
    }

    public static AdRequestInfo getInstance() {
        if (mInstance == null) {
            synchronized (ConfigRequestInfo.class) {
                if (mInstance == null) {
                    mInstance = new AdRequestInfo();
                }
            }
        }
        return mInstance;
    }

    private List<ItemModel> getItemList() {
        ArrayList arrayList = new ArrayList();
        ItemModel itemModel = new ItemModel();
        itemModel.setExp(1200);
        itemModel.setDlvy(AdRequestEnum.DLVY_TYPE.ITEM_DLVY_REAL_TIME.getCode());
        AdParameters adParameters = this.adParameters;
        if (adParameters != null && adParameters.getAdCount() > 0) {
            itemModel.setQty(this.adParameters.getAdCount());
        }
        SpecModel specModel = new SpecModel();
        AdInitConfig adInitConfig = this.adInitConfig;
        if (adInitConfig != null && !TextUtils.isEmpty(adInitConfig.getApiKey())) {
            specModel.setSdk(this.adInitConfig.getApiKey());
        }
        AdParameters adParameters2 = this.adParameters;
        if (adParameters2 != null && !TextUtils.isEmpty(adParameters2.getAdUnitId())) {
            specModel.setTagid(this.adParameters.getAdUnitId());
        }
        specModel.setSdkver("5.1.0.13");
        SpecExtModel specExtModel = new SpecExtModel();
        specExtModel.setLocalRenderId(TemplateManager.getInstance().readLocalRenderTemplateList(this.adParameters.getAdType()));
        specExtModel.setLocalInteractionId(TemplateManager.getInstance().readLocalInteractionTemplateList(this.adParameters.getAdType()));
        specModel.setExt(specExtModel);
        itemModel.setSpec(specModel);
        arrayList.add(itemModel);
        return arrayList;
    }

    public AdParameters getAdParameters() {
        return this.adParameters;
    }

    public AdRequestModel getAdRequestModel() {
        return this.adRequestModel;
    }

    public List<AppInstallModel> getAppInstall() {
        return this.appInstallList;
    }

    public AdRequestInfo init(String str) {
        this.apiKey = str;
        this.adInitConfig = InitImplement.getInstance().getGlobalAdInitConfig(str);
        AdRequestModel adRequestModel = new AdRequestModel();
        this.adRequestModel = adRequestModel;
        adRequestModel.setId(getAdRequestId());
        this.adRequestModel.setAt(AdRequestEnum.AT_TYPE.AT_FIRST_STAGE_TYPE.getCode());
        AdParameters adParameters = this.adParameters;
        if (adParameters != null) {
            this.adRequestModel.setTest(adParameters.getTestAd());
        } else {
            this.adRequestModel.setTest(AdRequestEnum.TEST_TYPE.TEST_FORMAL_MODEL.getCode());
        }
        this.adRequestModel.setTmax(5000);
        AdParameters adParameters2 = this.adParameters;
        if (adParameters2 != null) {
            this.adRequestModel.setCountry_CN(adParameters2.getCountryCN());
        } else if (AdScopeSDK.getContext() != null) {
            this.adRequestModel.setCountry_CN(DeviceInfo.getInstance(AdScopeSDK.getContext()).getCountry_CN());
        }
        this.adRequestModel.setItem(getItemList());
        this.adRequestModel.setContext(getContext());
        this.adRequestModel.setCur(getCurList());
        return mInstance;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void setAdParameters(AdParameters adParameters) {
        this.adParameters = adParameters;
    }

    public void setAppInstall(List<AppInstallModel> list) {
        this.appInstallList = list;
    }
}
