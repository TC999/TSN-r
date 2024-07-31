package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* renamed from: com.mbridge.msdk.foundation.db.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CampaignReportDao extends CampaignDao {

    /* renamed from: a */
    private static final String f30353a = "com.mbridge.msdk.foundation.db.g";

    /* renamed from: b */
    private static CampaignReportDao f30354b;

    private CampaignReportDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: b */
    public static CampaignReportDao m22726b(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30354b == null) {
            synchronized (CampaignReportDao.class) {
                if (f30354b == null) {
                    f30354b = new CampaignReportDao(commonAbsDBHelper);
                }
            }
        }
        return f30354b;
    }

    /* renamed from: a */
    public final synchronized long m22727a(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", campaignEx.getId());
            contentValues.put("unitid", campaignEx.getCampaignUnitId());
            contentValues.put("tab", Integer.valueOf(campaignEx.getTab()));
            contentValues.put("package_name", campaignEx.getPackageName());
            contentValues.put("app_name", campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK, Integer.valueOf(campaignEx.getWtick()));
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("cpti", Integer.valueOf(campaignEx.getPreClickInterval()));
            contentValues.put("preclick", Boolean.valueOf(campaignEx.isPreClick()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Integer.valueOf(campaignEx.getVideoSize()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, Integer.valueOf(campaignEx.getVideoLength()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
            contentValues.put(CampaignEx.JSON_KEY_ENDCARD_CLICK, Integer.valueOf(campaignEx.getEndcard_click_result()));
            contentValues.put(CampaignEx.JSON_KEY_WATCH_MILE, Integer.valueOf(campaignEx.getWatchMile()));
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME, Integer.valueOf(campaignEx.getVideoCompleteTime()));
            contentValues.put("advImp", campaignEx.getAdvImp());
            contentValues.put("bty", Integer.valueOf(campaignEx.getBty()));
            contentValues.put(CampaignEx.JSON_KEY_T_IMP, Integer.valueOf(campaignEx.getTImp()));
            contentValues.put(CampaignEx.JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
            contentValues.put(CampaignEx.JSON_KEY_OFFER_TYPE, Integer.valueOf(campaignEx.getOfferType()));
            contentValues.put("html_url", campaignEx.getHtmlUrl());
            contentValues.put("end_screen_url", campaignEx.getEndScreenUrl());
            contentValues.put("reward_amount", Integer.valueOf(campaignEx.getRewardAmount()));
            contentValues.put("reward_name", campaignEx.getRewardName());
            contentValues.put("reward_play_status", Integer.valueOf(campaignEx.getRewardPlayStatus()));
            contentValues.put(DomainCampaignEx.JSON_KEY_ADV_ID, campaignEx.getAdvId());
            contentValues.put(DomainCampaignEx.JSON_KEY_TTC_CT2, Integer.valueOf(campaignEx.getTtc_ct2() * 1000));
            contentValues.put(DomainCampaignEx.JSON_KEY_TTC_TYPE, Integer.valueOf(campaignEx.getTtc_type()));
            contentValues.put("retarget", Integer.valueOf(campaignEx.getRetarget_offer()));
            contentValues.put("native_ad_tracking", campaignEx.getNativeVideoTrackingString());
            contentValues.put(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO, Integer.valueOf(campaignEx.getPlayable_ads_without_video()));
            contentValues.put(CampaignEx.ENDCARD_URL, campaignEx.getendcard_url());
            contentValues.put(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
            contentValues.put(DomainCampaignEx.LOOPBACK, campaignEx.getLoopbackString());
            contentValues.put(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
            contentValues.put(CampaignEx.JSON_KEY_NV_T2, Integer.valueOf(campaignEx.getNvT2()));
            contentValues.put(CampaignEx.JSON_KEY_GIF_URL, campaignEx.getGifUrl());
            if (campaignEx.getRewardTemplateMode() != null) {
                contentValues.put("reward_teamplate", campaignEx.getRewardTemplateMode().m22641a());
            }
            contentValues.put("c_coi", Integer.valueOf(campaignEx.getClickTimeOutInterval()));
            contentValues.put(CampaignEx.JSON_KEY_C_UA, Integer.valueOf(campaignEx.getcUA()));
            contentValues.put(CampaignEx.JSON_KEY_IMP_UA, Integer.valueOf(campaignEx.getImpUA()));
            contentValues.put(DomainCampaignEx.KEY_GH_ID, campaignEx.getGhId());
            contentValues.put(DomainCampaignEx.KEY_GH_PATH, campaignEx.getGhPath());
            contentValues.put(DomainCampaignEx.KEY_BIND_ID, campaignEx.getBindId());
            contentValues.put(CampaignEx.JSON_KEY_FLB, Integer.valueOf(campaignEx.getFlb()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD, Integer.valueOf(campaignEx.getCbd()));
            contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST, Integer.valueOf(campaignEx.getVst()));
            contentValues.put(CampaignEx.JSON_KEY_FLB_SKIP_TIME, Integer.valueOf(campaignEx.getFlbSkipTime()));
            return getWritableDatabase().insert("report_campaign", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v129 */
    /* JADX WARN: Type inference failed for: r4v130 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.mbridge.msdk.foundation.entity.CampaignEx] */
    /* renamed from: h */
    public final CampaignEx m22725h(String str) {
        CampaignEx campaignEx;
        CampaignEx campaignEx2 = 0;
        try {
            try {
                Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM report_campaign where package_name ='" + str + "'", null);
                if (rawQuery != null) {
                    try {
                        try {
                            if (rawQuery.getCount() > 0 && rawQuery.moveToNext()) {
                                campaignEx = new CampaignEx();
                                try {
                                    campaignEx.setId(rawQuery.getString(rawQuery.getColumnIndex("id")));
                                    campaignEx.setTab(rawQuery.getInt(rawQuery.getColumnIndex("tab")));
                                    campaignEx.setPackageName(rawQuery.getString(rawQuery.getColumnIndex("package_name")));
                                    campaignEx.setAppName(rawQuery.getString(rawQuery.getColumnIndex("app_name")));
                                    campaignEx.setAppDesc(rawQuery.getString(rawQuery.getColumnIndex("app_desc")));
                                    campaignEx.setSize(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_APP_SIZE)));
                                    campaignEx.setImageSize(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_SIZE)));
                                    campaignEx.setIconUrl(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_ICON_URL)));
                                    campaignEx.setImageUrl(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_IMAGE_URL)));
                                    campaignEx.setImpressionURL(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_IMPRESSION_URL)));
                                    campaignEx.setNoticeUrl(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_NOTICE_URL)));
                                    campaignEx.setClickURL(rawQuery.getString(rawQuery.getColumnIndex(DownloadModel.DOWNLOAD_URL)));
                                    campaignEx.setWtick(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_WITHOUT_INSTALL_CHECK)));
                                    campaignEx.setOnlyImpressionURL(rawQuery.getString(rawQuery.getColumnIndex("only_impression")));
                                    boolean z = true;
                                    if (rawQuery.getInt(rawQuery.getColumnIndex("preclick")) != 1) {
                                        z = false;
                                    }
                                    campaignEx.setPreClick(z);
                                    campaignEx.setTemplate(rawQuery.getInt(rawQuery.getColumnIndex("template")));
                                    campaignEx.setLandingType(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_LANDING_TYPE)));
                                    campaignEx.setLinkType(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_LINK_TYPE)));
                                    campaignEx.setClick_mode(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_CLICK_MODE)));
                                    campaignEx.setRating(Double.parseDouble(rawQuery.getString(rawQuery.getColumnIndex("star"))));
                                    campaignEx.setNumberRating(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_NUMBER_RATING)));
                                    campaignEx.setClickInterval(rawQuery.getInt(rawQuery.getColumnIndex("cti")));
                                    campaignEx.setPreClickInterval(rawQuery.getInt(rawQuery.getColumnIndex("cpti")));
                                    campaignEx.setTimestamp(rawQuery.getLong(rawQuery.getColumnIndex("ts")));
                                    campaignEx.setCacheLevel(rawQuery.getInt(rawQuery.getColumnIndex("level")));
                                    campaignEx.setAdCall(rawQuery.getString(rawQuery.getColumnIndex("ad_call")));
                                    campaignEx.setFca(rawQuery.getInt(rawQuery.getColumnIndex("fc_a")));
                                    campaignEx.setAd_url_list(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_AD_URL_LIST)));
                                    campaignEx.setVideoLength(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_LENGTHL)));
                                    campaignEx.setVideoSize(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_SIZE)));
                                    campaignEx.setVideoResolution(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_RESOLUTION)));
                                    campaignEx.setEndcard_click_result(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_ENDCARD_CLICK)));
                                    campaignEx.setVideoUrlEncode(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_URL)));
                                    campaignEx.setWatchMile(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_WATCH_MILE)));
                                    campaignEx.setVideoCompleteTime(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_COMPLETE_TIME)));
                                    campaignEx.setTImp(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_T_IMP)));
                                    campaignEx.setBty(rawQuery.getInt(rawQuery.getColumnIndex("bty")));
                                    campaignEx.setAdvImp(rawQuery.getString(rawQuery.getColumnIndex("advImp")));
                                    campaignEx.setGuidelines(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
                                    campaignEx.setOfferType(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_OFFER_TYPE)));
                                    campaignEx.setHtmlUrl(rawQuery.getString(rawQuery.getColumnIndex("html_url")));
                                    campaignEx.setGuidelines(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_GUIDELINES)));
                                    campaignEx.setHtmlUrl(rawQuery.getString(rawQuery.getColumnIndex("html_url")));
                                    campaignEx.setEndScreenUrl(rawQuery.getString(rawQuery.getColumnIndex("end_screen_url")));
                                    campaignEx.setRewardName(rawQuery.getString(rawQuery.getColumnIndex("reward_name")));
                                    campaignEx.setRewardAmount(rawQuery.getInt(rawQuery.getColumnIndex("reward_amount")));
                                    campaignEx.setRewardPlayStatus(rawQuery.getInt(rawQuery.getColumnIndex("reward_play_status")));
                                    campaignEx.setAdvId(rawQuery.getString(rawQuery.getColumnIndex(DomainCampaignEx.JSON_KEY_ADV_ID)));
                                    campaignEx.setTtc_ct2(rawQuery.getInt(rawQuery.getColumnIndex(DomainCampaignEx.JSON_KEY_TTC_CT2)));
                                    campaignEx.setTtc_type(rawQuery.getInt(rawQuery.getColumnIndex(DomainCampaignEx.JSON_KEY_TTC_TYPE)));
                                    campaignEx.setRetarget_offer(rawQuery.getInt(rawQuery.getColumnIndex("retarget")));
                                    campaignEx.setCampaignUnitId(rawQuery.getString(rawQuery.getColumnIndex("unitid")));
                                    campaignEx.setNativeVideoTracking(CampaignEx.TrackingStr2Object(rawQuery.getString(rawQuery.getColumnIndex("native_ad_tracking"))));
                                    campaignEx.setNativeVideoTrackingString(rawQuery.getString(rawQuery.getColumnIndex("native_ad_tracking")));
                                    campaignEx.setVideo_end_type(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.VIDEO_END_TYPE)));
                                    campaignEx.setendcard_url(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.ENDCARD_URL)));
                                    campaignEx.setPlayable_ads_without_video(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.PLAYABLE_ADS_WITHOUT_VIDEO)));
                                    campaignEx.setLoopbackString(rawQuery.getString(rawQuery.getColumnIndex(DomainCampaignEx.LOOPBACK)));
                                    campaignEx.setLoopbackMap(DomainCampaignEx.loopbackStrToMap(rawQuery.getString(rawQuery.getColumnIndex(DomainCampaignEx.LOOPBACK))));
                                    campaignEx.setRewardTemplateMode(CampaignEx.C11317c.m22639a(rawQuery.getString(rawQuery.getColumnIndex("reward_teamplate"))));
                                    campaignEx.setVideoMD5Value(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_REWARD_VIDEO_MD5)));
                                    campaignEx.setGifUrl(rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_GIF_URL)));
                                    campaignEx.setNvT2(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_NV_T2)));
                                    campaignEx.setClickTimeOutInterval(rawQuery.getInt(rawQuery.getColumnIndex("c_coi")));
                                    campaignEx.setcUA(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_C_UA)));
                                    campaignEx.setImpUA(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_IMP_UA)));
                                    campaignEx.setGhId(rawQuery.getString(rawQuery.getColumnIndex(DomainCampaignEx.KEY_GH_ID)));
                                    campaignEx.setGhPath(rawQuery.getString(rawQuery.getColumnIndex(DomainCampaignEx.KEY_GH_PATH)));
                                    campaignEx.setBindId(rawQuery.getString(rawQuery.getColumnIndex(DomainCampaignEx.KEY_BIND_ID)));
                                    campaignEx.setFlb(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_FLB)));
                                    campaignEx.setCbd(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD)));
                                    campaignEx.setVst(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_VST)));
                                    campaignEx.setAdSpaceT(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T)));
                                    campaignEx.setFlbSkipTime(rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_FLB_SKIP_TIME)));
                                    campaignEx2 = campaignEx;
                                } catch (Exception e) {
                                    e = e;
                                    campaignEx2 = rawQuery;
                                    e.printStackTrace();
                                    if (campaignEx2 != null) {
                                        try {
                                            campaignEx2.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    campaignEx2 = campaignEx;
                                    return campaignEx2;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            campaignEx = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        campaignEx2 = rawQuery;
                        if (campaignEx2 != null) {
                            try {
                                campaignEx2.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                campaignEx = null;
            }
            return campaignEx2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: i */
    public final synchronized void m22724i(String str) {
        String str2;
        try {
            str2 = "package_name = '" + str + "'";
        } catch (Exception unused) {
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("report_campaign", str2, null);
    }
}
