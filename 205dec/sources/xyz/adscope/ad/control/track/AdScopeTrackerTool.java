package xyz.adscope.ad.control.track;

import android.text.TextUtils;
import android.view.View;
import xyz.adscope.ad.control.render.model.AdScopeRenderCustomTrackerModel;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeTrackerTool {
    public static final String absAdDownX = "__ABS_AD_DOWN_X__";
    public static final String absAdDownY = "__ABS_AD_DOWN_Y__";
    public static final String absAdUpX = "__ABS_AD_UP_X__";
    public static final String absAdUpY = "__ABS_AD_UP_Y__";
    public static final String absAdx = "__ABS_ADX__";
    public static final String absAdy = "__ABS_ADY__";
    public static final String absHeight = "__ABS_HEIGHT__";
    public static final String absMatDownX = "__ABS_MAT_DOWN_X__";
    public static final String absMatDownY = "__ABS_MAT_DOWN_Y__";
    public static final String absMatUpX = "__ABS_MAT_UP_X__";
    public static final String absMatUpY = "__ABS_MAT_UP_Y__";
    public static final String absSrcDownX = "__ABS_SRC_DOWN_X__";
    public static final String absSrcDownY = "__ABS_SRC_DOWN_Y__";
    public static final String absSrcUpX = "__ABS_SRC_UP_X__";
    public static final String absSrcUpY = "__ABS_SRC_UP_Y__";
    public static final String absWidth = "__ABS_WIDTH__";
    public static final String action = "__ACTION__";
    public static final String adDownX = "__AD_DOWN_X__";
    public static final String adDownY = "__AD_DOWN_Y__";
    public static final String adUpX = "__AD_UP_X__";
    public static final String adUpY = "__AD_UP_Y__";
    public static final String adx = "__ADX__";
    public static final String ady = "__ADY__";
    public static final String downTs = "__DOWN_TS__";
    public static final String height = "__HEIGHT__";
    public static final String interactive = "__INTERACTIVE__";
    public static final String matDownX = "__MAT_DOWN_X__";
    public static final String matDownY = "__MAT_DOWN_Y__";
    public static final String matUpX = "__MAT_UP_X__";
    public static final String matUpY = "__MAT_UP_Y__";
    public static final String requestUUID = "__REQUESTUUID__";
    public static final String srcDownX = "__SRC_DOWN_X__";
    public static final String srcDownY = "__SRC_DOWN_Y__";
    public static final String srcUpX = "__SRC_UP_X__";
    public static final String srcUpY = "__SRC_UP_Y__";
    public static final String ts = "__TS__";
    public static final String upTs = "__UP_TS__";
    public static final String width = "__WIDTH__";

    public static AdScopeCycleModel convertAdClickPointWithView(View view, AdScopeCycleModel adScopeCycleModel) {
        AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel = adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
        if (adScopeRenderCustomTrackerModel == null) {
            return adScopeCycleModel;
        }
        adScopeRenderCustomTrackerModel.setAdView(view);
        adScopeRenderCustomTrackerModel.setAdx(view.getX() + "");
        adScopeRenderCustomTrackerModel.setAdy(view.getY() + "");
        adScopeRenderCustomTrackerModel.setWidth(view.getMeasuredWidth() + "");
        adScopeRenderCustomTrackerModel.setHeight(view.getMeasuredHeight() + "");
        if (!adScopeRenderCustomTrackerModel.getClickDownX().equals("-999") && !adScopeRenderCustomTrackerModel.getClickDownY().equals("-999") && !adScopeRenderCustomTrackerModel.getClickUpX().equals("-999") && !adScopeRenderCustomTrackerModel.getClickUpY().equals("-999")) {
            float x3 = view.getX();
            float y3 = view.getY();
            adScopeRenderCustomTrackerModel.setAdDownX((Float.parseFloat(adScopeRenderCustomTrackerModel.getSrcDownX()) - x3) + "");
            adScopeRenderCustomTrackerModel.setAdDownY((Float.parseFloat(adScopeRenderCustomTrackerModel.getSrcDownY()) - y3) + "");
            float parseFloat = Float.parseFloat(adScopeRenderCustomTrackerModel.getSrcUpX()) - x3;
            float parseFloat2 = Float.parseFloat(adScopeRenderCustomTrackerModel.getSrcUpY()) - y3;
            adScopeRenderCustomTrackerModel.setAdUpX(parseFloat + "");
            adScopeRenderCustomTrackerModel.setAdUpY(parseFloat2 + "");
        } else {
            adScopeRenderCustomTrackerModel.setAdDownX("-999");
            adScopeRenderCustomTrackerModel.setAdDownY("-999");
            adScopeRenderCustomTrackerModel.setAdUpX("-999");
            adScopeRenderCustomTrackerModel.setAdUpY("-999");
            adScopeRenderCustomTrackerModel.setSrcDownX("-999");
            adScopeRenderCustomTrackerModel.setSrcDownY("-999");
            adScopeRenderCustomTrackerModel.setSrcUpX("-999");
            adScopeRenderCustomTrackerModel.setSrcUpY("-999");
        }
        adScopeCycleModel.setAdScopeRenderCustomTrackerModel(adScopeRenderCustomTrackerModel);
        return adScopeCycleModel;
    }

    public static AdScopeCycleModel convertAdViewPointWithView(View view, AdScopeCycleModel adScopeCycleModel) {
        AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel = adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
        if (adScopeRenderCustomTrackerModel != null) {
            adScopeRenderCustomTrackerModel.setAdView(view);
            adScopeRenderCustomTrackerModel.setAdx(view.getX() + "");
            adScopeRenderCustomTrackerModel.setAdy(view.getY() + "");
            adScopeRenderCustomTrackerModel.setWidth(view.getMeasuredWidth() + "");
            adScopeRenderCustomTrackerModel.setHeight(view.getMeasuredHeight() + "");
            adScopeCycleModel.setAdScopeRenderCustomTrackerModel(adScopeRenderCustomTrackerModel);
        }
        return adScopeCycleModel;
    }

    public static String replaceM(String str, AdScopeCycleModel adScopeCycleModel, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str.replace(action, str2);
        }
        if (adScopeCycleModel == null || adScopeCycleModel.getAdScopeRenderCustomTrackerModel() == null) {
            return "";
        }
        AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel = adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
        if (!TextUtils.isEmpty(adScopeCycleModel.getSessionId())) {
            str = str.replace(requestUUID, adScopeCycleModel.getSessionId());
        }
        if (!TextUtils.isEmpty(DeviceInfoUtil.getTimeStamp() + "")) {
            str = str.replace(ts, DeviceInfoUtil.getTimeStamp() + "");
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdx())) {
            str = str.replace(adx, adScopeRenderCustomTrackerModel.getAdx());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdy())) {
            str = str.replace(ady, adScopeRenderCustomTrackerModel.getAdy());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getWidth())) {
            str = str.replace(width, adScopeRenderCustomTrackerModel.getWidth());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getHeight())) {
            str = str.replace(height, adScopeRenderCustomTrackerModel.getHeight());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getDownTS() + "")) {
            str = str.replace(downTs, adScopeRenderCustomTrackerModel.getDownTS() + "");
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getUpTS() + "")) {
            str = str.replace(upTs, adScopeRenderCustomTrackerModel.getUpTS() + "");
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getSrcDownX())) {
            str = str.replace(srcDownX, adScopeRenderCustomTrackerModel.getSrcDownX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getSrcDownY())) {
            str = str.replace(srcDownY, adScopeRenderCustomTrackerModel.getSrcDownY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getSrcUpX())) {
            str = str.replace(srcUpX, adScopeRenderCustomTrackerModel.getSrcUpX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getSrcUpY())) {
            str = str.replace(srcUpY, adScopeRenderCustomTrackerModel.getSrcUpY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdDownX())) {
            str = str.replace(adDownX, adScopeRenderCustomTrackerModel.getAdDownX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdDownY())) {
            str = str.replace(adDownY, adScopeRenderCustomTrackerModel.getAdDownY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdUpX())) {
            str = str.replace(adUpX, adScopeRenderCustomTrackerModel.getAdUpX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdUpY())) {
            str = str.replace(adUpY, adScopeRenderCustomTrackerModel.getAdUpY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getClickDownX())) {
            str = str.replace(matDownX, adScopeRenderCustomTrackerModel.getClickDownX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getClickDownY())) {
            str = str.replace(matDownY, adScopeRenderCustomTrackerModel.getClickDownY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getClickUpX())) {
            str = str.replace(matUpX, adScopeRenderCustomTrackerModel.getClickUpX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getClickUpY())) {
            str = str.replace(matUpY, adScopeRenderCustomTrackerModel.getClickUpY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getClickType() + "")) {
            str = str.replace(interactive, adScopeRenderCustomTrackerModel.getClickType() + "");
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdx())) {
            str = str.replace(absAdx, adScopeRenderCustomTrackerModel.getAdx());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdy())) {
            str = str.replace(absAdy, adScopeRenderCustomTrackerModel.getAdy());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getWidth())) {
            str = str.replace(absWidth, adScopeRenderCustomTrackerModel.getWidth());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getHeight())) {
            str = str.replace(absHeight, adScopeRenderCustomTrackerModel.getHeight());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getSrcDownX())) {
            str = str.replace(absSrcDownX, adScopeRenderCustomTrackerModel.getSrcDownX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getSrcDownY())) {
            str = str.replace(absSrcDownY, adScopeRenderCustomTrackerModel.getSrcDownY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getSrcUpX())) {
            str = str.replace(absSrcUpX, adScopeRenderCustomTrackerModel.getSrcUpX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getSrcUpY())) {
            str = str.replace(absSrcUpY, adScopeRenderCustomTrackerModel.getSrcUpY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdDownX())) {
            str = str.replace(absAdDownX, adScopeRenderCustomTrackerModel.getAdDownX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdDownY())) {
            str = str.replace(absAdDownY, adScopeRenderCustomTrackerModel.getAdDownY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdUpX())) {
            str = str.replace(absAdUpX, adScopeRenderCustomTrackerModel.getAdUpX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getAdUpY())) {
            str = str.replace(absAdUpY, adScopeRenderCustomTrackerModel.getAdUpY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getClickDownX())) {
            str = str.replace(absMatDownX, adScopeRenderCustomTrackerModel.getClickDownX());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getClickDownY())) {
            str = str.replace(absMatDownY, adScopeRenderCustomTrackerModel.getClickDownY());
        }
        if (!TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getClickUpX())) {
            str = str.replace(absMatUpX, adScopeRenderCustomTrackerModel.getClickUpX());
        }
        return !TextUtils.isEmpty(adScopeRenderCustomTrackerModel.getClickUpY()) ? str.replace(absMatUpY, adScopeRenderCustomTrackerModel.getClickUpY()) : str;
    }
}
