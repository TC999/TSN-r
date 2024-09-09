package xyz.adscope.ad.advertisings;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.model.AdType;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.control.strategy.inter.IStrategy;
import xyz.adscope.ad.control.template.TemplateManager;
import xyz.adscope.ad.init.InitImplement;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.AdModel;
import xyz.adscope.ad.model.http.response.ad.AdResponseModel;
import xyz.adscope.ad.model.http.response.ad.AssetModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.model.http.response.ad.DisplayModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.MediaModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.model.http.response.ad.RenderModel;
import xyz.adscope.ad.model.http.response.ad.ReportModel;
import xyz.adscope.ad.model.http.response.ad.SeatbidModel;
import xyz.adscope.ad.model.http.response.config.ComplainModel;
import xyz.adscope.ad.model.http.response.config.StrategyFrequencyModel;
import xyz.adscope.ad.model.http.response.config.UniteControlModel;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.AesUtil;
import xyz.adscope.common.tool.security.GzipUtil;
import xyz.adscope.common.tool.security.KeyGenerator;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdResponseManager {
    private static final String CMD5_KEY = "cmd5";

    public static boolean checkAdvertisingData(AdResponseModel adResponseModel) {
        String str = Constants.TAG;
        LogUtil.i(str, "checkAdvertisingData : " + adResponseModel);
        if (adResponseModel != null && adResponseModel.getSeatbid() != null && adResponseModel.getSeatbid().size() > 0) {
            int size = adResponseModel.getSeatbid().size();
            for (int i4 = 0; i4 < size; i4++) {
                SeatbidModel seatbidModel = adResponseModel.getSeatbid().get(i4);
                if (seatbidModel.getBid() != null && seatbidModel.getBid().size() > 0) {
                    int size2 = seatbidModel.getBid().size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        if (seatbidModel.getBid().get(i5).getMedia() != null) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    public static BidModel getBidModel(AdResponseModel adResponseModel) {
        List<SeatbidModel> seatbid;
        SeatbidModel seatbidModel;
        if (adResponseModel == null || adResponseModel.getSeatbid() == null || (seatbid = adResponseModel.getSeatbid()) == null || seatbid.size() < 1 || (seatbidModel = seatbid.get(0)) == null || seatbidModel.getBid() == null || seatbidModel.getBid().size() < 1) {
            return null;
        }
        return seatbidModel.getBid().get(0);
    }

    public static List<Map<String, BidModel>> getBidModelListByResponse(AdResponseModel adResponseModel) {
        List<SeatbidModel> seatbid;
        List<BidModel> bid;
        ArrayList arrayList = new ArrayList();
        if (adResponseModel == null || adResponseModel.getSeatbid() == null || (seatbid = adResponseModel.getSeatbid()) == null || seatbid.size() < 1) {
            return null;
        }
        for (SeatbidModel seatbidModel : seatbid) {
            if (seatbidModel != null && seatbidModel.getBid() != null && seatbidModel.getBid().size() > 0 && (bid = seatbidModel.getBid()) != null && bid.size() > 0) {
                for (BidModel bidModel : bid) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(seatbidModel.getExt(), bidModel);
                    arrayList.add(hashMap);
                }
            }
        }
        return arrayList;
    }

    public static String getCreateId(AdResponseModel adResponseModel) {
        return (adResponseModel == null || adResponseModel.getSeatbid() == null || adResponseModel.getSeatbid().size() <= 0 || adResponseModel.getSeatbid().get(0).getBid() == null || adResponseModel.getSeatbid().get(0).getBid().size() <= 0) ? "" : getCreateId(adResponseModel.getSeatbid().get(0).getBid().get(0));
    }

    public static String getDSPId(AdResponseModel adResponseModel) {
        return (adResponseModel == null || adResponseModel.getSeatbid() == null || adResponseModel.getSeatbid().size() <= 0 || adResponseModel.getSeatbid().get(0) == null) ? "" : getDSPId(adResponseModel.getSeatbid().get(0));
    }

    public static DisplayModel getDisplayModel(BidModel bidModel) {
        if (bidModel == null || bidModel.getMedia() == null) {
            return null;
        }
        MediaModel media = bidModel.getMedia();
        if (media.getAd() == null) {
            return null;
        }
        AdModel ad = media.getAd();
        if (ad.getDisplay() == null) {
            return null;
        }
        return ad.getDisplay();
    }

    public static long getExpireTime(AdResponseModel adResponseModel) {
        if (adResponseModel == null || adResponseModel.getSeatbid() == null || adResponseModel.getSeatbid().size() <= 0) {
            return 0L;
        }
        int size = adResponseModel.getSeatbid().size();
        for (int i4 = 0; i4 < size; i4++) {
            SeatbidModel seatbidModel = adResponseModel.getSeatbid().get(i4);
            if (seatbidModel.getBid() != null && seatbidModel.getBid().size() > 0 && seatbidModel.getBid().size() > 0) {
                return seatbidModel.getBid().get(0).getExp();
            }
        }
        return 0L;
    }

    public static String getInteractPlanId(AdResponseModel adResponseModel) {
        return (adResponseModel == null || adResponseModel.getSeatbid() == null || adResponseModel.getSeatbid().size() <= 0 || adResponseModel.getSeatbid().get(0).getBid() == null || adResponseModel.getSeatbid().get(0).getBid().size() <= 0) ? "" : getInteractPlanId(adResponseModel.getSeatbid().get(0).getBid().get(0));
    }

    public static List<InteractionModel> getInteractionTypeFrom(BidModel bidModel, String str) {
        DisplayModel display;
        NativeModel nativeModel;
        if (bidModel.getMedia() == null) {
            return null;
        }
        MediaModel media = bidModel.getMedia();
        if (media.getAd() == null) {
            return null;
        }
        AdModel ad = media.getAd();
        if (ad.getDisplay() == null || (display = ad.getDisplay()) == null || (nativeModel = display.getNativeModel()) == null) {
            return null;
        }
        if (nativeModel.getInteraction() == null || nativeModel.getInteraction().size() < 1) {
            String readLocalInteractionModel = TemplateManager.getInstance().readLocalInteractionModel(str);
            if (!TextUtils.isEmpty(readLocalInteractionModel)) {
                try {
                    JSONObject jSONObject = new JSONObject(readLocalInteractionModel);
                    if (jSONObject.has("interaction")) {
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = jSONObject.getJSONArray("interaction");
                        if (jSONArray.length() > 0) {
                            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                arrayList.add((InteractionModel) new JSONParse().fromJson(jSONArray.getString(i4), InteractionModel.class));
                            }
                            nativeModel.setInteraction(arrayList);
                        }
                    }
                } catch (JSONException e4) {
                    String str2 = Constants.TAG;
                    LogUtil.e(str2, "e : " + e4);
                }
            } else {
                LogUtil.i(Constants.TAG, "interaction template not exist");
            }
        }
        return nativeModel.getInteraction();
    }

    public static String getMaterialId(AdResponseModel adResponseModel) {
        return (adResponseModel == null || adResponseModel.getSeatbid() == null || adResponseModel.getSeatbid().size() <= 0 || adResponseModel.getSeatbid().get(0).getBid() == null || adResponseModel.getSeatbid().get(0).getBid().size() <= 0 || adResponseModel.getSeatbid().get(0).getBid().get(0).getMedia() == null || adResponseModel.getSeatbid().get(0).getBid().get(0).getMedia().getAd() == null) ? "" : getMaterialId(adResponseModel.getSeatbid().get(0).getBid().get(0));
    }

    public static String getMaterialMd5Value(AdResponseModel adResponseModel) {
        return (adResponseModel == null || adResponseModel.getSeatbid() == null || adResponseModel.getSeatbid().size() <= 0 || adResponseModel.getSeatbid().get(0).getBid() == null || adResponseModel.getSeatbid().get(0).getBid().size() <= 0) ? "" : getMaterialMd5Value(adResponseModel.getSeatbid().get(0).getBid().get(0));
    }

    public static NativeModel getNativeModel(BidModel bidModel) {
        if (bidModel == null || bidModel.getMedia() == null) {
            return null;
        }
        MediaModel media = bidModel.getMedia();
        if (media.getAd() == null) {
            return null;
        }
        AdModel ad = media.getAd();
        if (ad.getDisplay() == null) {
            return null;
        }
        DisplayModel display = ad.getDisplay();
        if (display.getNativeModel() == null) {
            return null;
        }
        return display.getNativeModel();
    }

    public static String getOrderId(AdResponseModel adResponseModel) {
        return (adResponseModel == null || adResponseModel.getSeatbid() == null || adResponseModel.getSeatbid().size() <= 0 || adResponseModel.getSeatbid().get(0).getBid() == null || adResponseModel.getSeatbid().get(0).getBid().size() <= 0) ? "" : getOrderId(adResponseModel.getSeatbid().get(0).getBid().get(0));
    }

    public static String getPrice(AdResponseModel adResponseModel) {
        if (adResponseModel == null || adResponseModel.getSeatbid() == null || adResponseModel.getSeatbid().size() <= 0 || adResponseModel.getSeatbid().get(0).getBid() == null || adResponseModel.getSeatbid().get(0).getBid().size() <= 0) {
            return "";
        }
        return adResponseModel.getSeatbid().get(0).getBid().get(0).getPrice() + "";
    }

    public static String getRenderPlanId(AdResponseModel adResponseModel) {
        return (adResponseModel == null || adResponseModel.getSeatbid() == null || adResponseModel.getSeatbid().size() <= 0 || adResponseModel.getSeatbid().get(0).getBid() == null || adResponseModel.getSeatbid().get(0).getBid().size() <= 0) ? "" : getRenderPlanId(adResponseModel.getSeatbid().get(0).getBid().get(0));
    }

    public static List<RenderModel> getRenderTypeFrom(BidModel bidModel, String str) {
        DisplayModel display;
        NativeModel nativeModel;
        JSONException e4;
        List<AssetModel> asset;
        if (bidModel.getMedia() == null) {
            return null;
        }
        MediaModel media = bidModel.getMedia();
        if (media.getAd() == null) {
            return null;
        }
        AdModel ad = media.getAd();
        if (ad.getDisplay() == null || (display = ad.getDisplay()) == null || (nativeModel = display.getNativeModel()) == null) {
            return null;
        }
        List<RenderModel> render = nativeModel.getRender();
        if (render == null || render.size() < 1) {
            String readLocalRenderModel = TemplateManager.getInstance().readLocalRenderModel(str);
            if (!TextUtils.isEmpty(readLocalRenderModel)) {
                try {
                    JSONObject jSONObject = new JSONObject(readLocalRenderModel);
                    if (jSONObject.has("render")) {
                        ArrayList arrayList = new ArrayList();
                        try {
                            JSONArray jSONArray = jSONObject.getJSONArray("render");
                            if (jSONArray.length() > 0) {
                                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                    arrayList.add((RenderModel) new JSONParse().fromJson(jSONArray.getString(i4), RenderModel.class));
                                }
                                nativeModel.setRender(arrayList);
                            }
                            render = arrayList;
                        } catch (JSONException e5) {
                            e4 = e5;
                            render = arrayList;
                            String str2 = Constants.TAG;
                            LogUtil.e(str2, "e : " + e4);
                            asset = nativeModel.getAsset();
                            if (asset != null) {
                            }
                            return null;
                        }
                    }
                } catch (JSONException e6) {
                    e4 = e6;
                }
            } else {
                LogUtil.i(Constants.TAG, "local render template not exist!");
            }
        }
        asset = nativeModel.getAsset();
        if (asset != null || asset.size() < 1) {
            return null;
        }
        for (int i5 = 0; i5 < asset.size(); i5++) {
            AssetModel assetModel = asset.get(i5);
            for (int i6 = 0; i6 < render.size(); i6++) {
                RenderModel renderModel = render.get(i6);
                if (!TextUtils.isEmpty(assetModel.getId()) && assetModel.getId().equals(renderModel.getId())) {
                    if (assetModel.getImage() != null) {
                        renderModel.setImageUrl(assetModel.getImage().getUrl());
                    }
                    if (assetModel.getTitle() != null) {
                        renderModel.setTitle(assetModel.getTitle().getText());
                    }
                    if (assetModel.getImage() != null) {
                        renderModel.setImageModel(assetModel.getImage());
                    }
                    if (assetModel.getVideo() != null) {
                        renderModel.setVideoModel(assetModel.getVideo());
                    }
                }
            }
        }
        return render;
    }

    public static ReportModel getReportModel(BidModel bidModel) {
        if (bidModel == null || bidModel.getMedia() == null) {
            return null;
        }
        MediaModel media = bidModel.getMedia();
        if (media.getAd() == null) {
            return null;
        }
        AdModel ad = media.getAd();
        if (ad.getDisplay() == null) {
            return null;
        }
        DisplayModel display = ad.getDisplay();
        if (display.getReport() == null) {
            return null;
        }
        return display.getReport();
    }

    private static List<StrategyFrequencyModel> getStrategyList(AdScopeCycleModel adScopeCycleModel) {
        if (adScopeCycleModel == null || TextUtils.isEmpty(adScopeCycleModel.getApiKey())) {
            return null;
        }
        AdScopeGlobalModel apiModelWithApiKey = InitImplement.getInstance().getApiModelWithApiKey(adScopeCycleModel.getApiKey());
        if (apiModelWithApiKey == null || apiModelWithApiKey.getConfigureModel() == null || apiModelWithApiKey.getConfigureModel().getStrategy() == null) {
            return null;
        }
        if (AdType.SPLASH.getValue().equals(adScopeCycleModel.getSpaceType())) {
            return apiModelWithApiKey.getConfigureModel().getStrategy().getSplash();
        }
        if (AdType.INTERSTITIAL.getValue().equals(adScopeCycleModel.getSpaceType())) {
            return apiModelWithApiKey.getConfigureModel().getStrategy().getInterstitial();
        }
        if (AdType.NATIVE.getValue().equals(adScopeCycleModel.getSpaceType())) {
            return apiModelWithApiKey.getConfigureModel().getStrategy().getNativeModel();
        }
        if (AdType.BANNER.getValue().equals(adScopeCycleModel.getSpaceType())) {
            return apiModelWithApiKey.getConfigureModel().getStrategy().getBanner();
        }
        return null;
    }

    public static String getVideoUrl(BidModel bidModel) {
        NativeModel nativeModel = getNativeModel(bidModel);
        List<RenderModel> render = nativeModel.getRender();
        List<AssetModel> asset = nativeModel.getAsset();
        if (asset == null || asset.size() < 1) {
            return null;
        }
        for (int i4 = 0; i4 < asset.size(); i4++) {
            AssetModel assetModel = asset.get(i4);
            for (int i5 = 0; i5 < render.size(); i5++) {
                RenderModel renderModel = render.get(i5);
                if (!TextUtils.isEmpty(assetModel.getId()) && assetModel.getId().equals(renderModel.getId()) && assetModel.getVideo() != null) {
                    if (!TextUtils.isEmpty(assetModel.getVideo().getUrl())) {
                        return assetModel.getVideo().getUrl();
                    }
                    if (!TextUtils.isEmpty(assetModel.getVideo().getAdm())) {
                        return assetModel.getVideo().getAdm();
                    }
                    if (!TextUtils.isEmpty(assetModel.getVideo().getCurl())) {
                        return assetModel.getVideo().getCurl();
                    }
                }
            }
        }
        return "";
    }

    public static boolean isComplainAd(AdScopeCycleModel adScopeCycleModel) {
        List<StrategyFrequencyModel> strategyList;
        if (adScopeCycleModel != null && (strategyList = getStrategyList(adScopeCycleModel)) != null && strategyList.size() >= 1) {
            try {
                for (StrategyFrequencyModel strategyFrequencyModel : strategyList) {
                    ComplainModel complain = strategyFrequencyModel.getComplain();
                    if (complain != null) {
                        long duration = complain.getDuration();
                        String spaceType = adScopeCycleModel.getSpaceType();
                        Object obj = AdScopeSpUtil.get(Constants.COMPLAIN_TIMESTAMP_KEY + spaceType + "_" + adScopeCycleModel.getApiKey(), 0L);
                        if (obj instanceof Long) {
                            long longValue = ((Long) obj).longValue();
                            if (longValue != 0 && duration != 0 && duration > System.currentTimeMillis() - longValue) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Exception e4) {
                String str = Constants.TAG;
                LogUtil.i(str, "e : " + e4);
            }
        }
        return false;
    }

    public static boolean isPassUnitControl(AdScopeCycleModel adScopeCycleModel) {
        List<StrategyFrequencyModel> strategyList;
        if (adScopeCycleModel != null && AdType.INTERSTITIAL.getValue().equals(adScopeCycleModel.getSpaceType()) && (strategyList = getStrategyList(adScopeCycleModel)) != null && strategyList.size() >= 1) {
            int uniteRandom = adScopeCycleModel.getUniteRandom();
            try {
                for (StrategyFrequencyModel strategyFrequencyModel : strategyList) {
                    UniteControlModel uniteControl = strategyFrequencyModel.getUniteControl();
                    if (uniteControl != null) {
                        int random = uniteControl.getRandom();
                        long duration = uniteControl.getDuration();
                        long longValue = ((Long) AdScopeSpUtil.get(Constants.UNITE_CONTROL_KEY, 0L)).longValue();
                        long currentTimeMillis = System.currentTimeMillis() - longValue;
                        if (longValue > 0 && duration > 0 && currentTimeMillis < duration && random < uniteRandom && random != 100) {
                            return false;
                        }
                    }
                }
            } catch (Exception e4) {
                String str = Constants.TAG;
                LogUtil.i(str, "e : " + e4);
            }
        }
        return true;
    }

    public static boolean isVideoAd(BidModel bidModel, String str) {
        List<RenderModel> renderTypeFrom = getRenderTypeFrom(bidModel, str);
        if (renderTypeFrom != null && renderTypeFrom.size() > 0) {
            for (int i4 = 0; i4 < renderTypeFrom.size(); i4++) {
                if (IAdView.AD_VIEW_TYPE.VIDEO_VIEW.getValue().equals(renderTypeFrom.get(i4).getControlType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean needSaveEventCodeWithCycleModel(AdScopeCycleModel adScopeCycleModel) {
        List<StrategyFrequencyModel> strategyList = getStrategyList(adScopeCycleModel);
        if (strategyList == null || strategyList.size() < 1) {
            return true;
        }
        for (StrategyFrequencyModel strategyFrequencyModel : strategyList) {
            if (strategyFrequencyModel.getFrequency() != null && strategyFrequencyModel.getFrequency().size() > 0) {
                return true;
            }
        }
        return false;
    }

    public static AdResponseModel parseAdResponse(String str) {
        String decompressForGzip = GzipUtil.decompressForGzip(AesUtil.decrypt(KeyGenerator.generateAesKey(), str));
        String str2 = Constants.TAG;
        LogUtil.i(str2, "requestResult : " + decompressForGzip);
        if (TextUtils.isEmpty(decompressForGzip) || decompressForGzip.equals("null")) {
            return null;
        }
        try {
            return (AdResponseModel) new JSONParse().fromJsonAnnotation(decompressForGzip, AdResponseModel.class);
        } catch (Exception e4) {
            String str3 = Constants.TAG;
            LogUtil.e(str3, "e : " + e4);
            return null;
        }
    }

    public static boolean passStrategyControlWithCycleModel(AdScopeCycleModel adScopeCycleModel, IStrategy iStrategy, IStrategy iStrategy2) {
        List<StrategyFrequencyModel> strategyList = getStrategyList(adScopeCycleModel);
        if (strategyList == null || strategyList.size() < 1) {
            return true;
        }
        for (StrategyFrequencyModel strategyFrequencyModel : strategyList) {
            if (iStrategy.frequencyStrategyControl(strategyFrequencyModel.getMinTime(), adScopeCycleModel) && iStrategy2.qualityStrategyControl(strategyFrequencyModel, adScopeCycleModel)) {
                return true;
            }
        }
        return false;
    }

    public static String getDSPId(SeatbidModel seatbidModel) {
        return getDSPId(seatbidModel.getExt());
    }

    public static String getCreateId(BidModel bidModel) {
        return (bidModel.getMedia() == null || bidModel.getMedia().getAd() == null || bidModel.getMedia().getAd().getDisplay() == null) ? "" : bidModel.getMedia().getAd().getDisplay().getId();
    }

    public static String getInteractPlanId(BidModel bidModel) {
        return (bidModel.getMedia() == null || bidModel.getMedia().getAd() == null || bidModel.getMedia().getAd().getDisplay() == null || bidModel.getMedia().getAd().getDisplay().getNativeModel() == null) ? "" : bidModel.getMedia().getAd().getDisplay().getNativeModel().getInteractionId();
    }

    public static String getMaterialMd5Value(BidModel bidModel) {
        if (bidModel.getMedia() != null && bidModel.getMedia().getAd() != null && bidModel.getMedia().getAd().getDisplay() != null) {
            String ext = bidModel.getMedia().getAd().getDisplay().getExt();
            if (!TextUtils.isEmpty(ext)) {
                try {
                    JSONObject jSONObject = new JSONObject(ext);
                    if (jSONObject.has(CMD5_KEY) && !TextUtils.isEmpty(jSONObject.optString(CMD5_KEY))) {
                        return jSONObject.optString(CMD5_KEY);
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return "";
    }

    public static String getOrderId(BidModel bidModel) {
        return (bidModel.getMedia() == null || bidModel.getMedia().getAd() == null || bidModel.getMedia().getAd().getDisplay() == null || bidModel.getMedia().getAd().getDisplay().getNativeModel() == null) ? "" : bidModel.getMedia().getAd().getId();
    }

    public static String getRenderPlanId(BidModel bidModel) {
        return (bidModel.getMedia() == null || bidModel.getMedia().getAd() == null || bidModel.getMedia().getAd().getDisplay() == null || bidModel.getMedia().getAd().getDisplay().getNativeModel() == null) ? "" : bidModel.getMedia().getAd().getDisplay().getNativeModel().getRenderId();
    }

    public static String getDSPId(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("id")) {
                    return jSONObject.optString("id");
                }
            } catch (JSONException e4) {
                String str2 = Constants.TAG;
                LogUtil.e(str2, "e : " + e4);
            }
        }
        return "";
    }

    public static String getMaterialId(BidModel bidModel) {
        if (bidModel.getMedia() == null || bidModel.getMedia().getAd() == null || bidModel.getMedia().getAd().getDisplay() == null || bidModel.getMedia().getAd().getDisplay().getNativeModel() == null || bidModel.getMedia().getAd().getDisplay().getNativeModel().getAsset() == null || bidModel.getMedia().getAd().getDisplay().getNativeModel().getAsset().size() <= 0) {
            return "";
        }
        List<AssetModel> asset = bidModel.getMedia().getAd().getDisplay().getNativeModel().getAsset();
        StringBuilder sb = new StringBuilder();
        for (AssetModel assetModel : asset) {
            sb.append(assetModel.getId());
            sb.append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
