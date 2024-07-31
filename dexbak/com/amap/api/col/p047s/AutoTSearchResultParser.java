package com.amap.api.col.p047s;

import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.Classify;
import com.amap.api.services.auto.ListData;
import com.amap.api.services.auto.Lqii;
import com.amap.api.services.auto.Meta;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.b1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AutoTSearchResultParser {
    /* renamed from: a */
    public static AutoTChargeStationResult m53242a(JSONObject jSONObject) {
        AutoTChargeStationResult autoTChargeStationResult = new AutoTChargeStationResult();
        try {
            autoTChargeStationResult.code = jSONObject.optInt("code");
            autoTChargeStationResult.message = jSONObject.optString("message");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                autoTChargeStationResult.classify = m53240c(optJSONObject.optJSONObject("classify"));
                autoTChargeStationResult.listData = m53231l(optJSONObject.optJSONObject("list_data"));
                autoTChargeStationResult.lqii = m53227p(optJSONObject.optJSONObject("lqii"));
                autoTChargeStationResult.meta = m53226q(optJSONObject.optJSONObject(TTDownloadField.TT_META));
                autoTChargeStationResult.originJson = optJSONObject.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autoTChargeStationResult;
    }

    /* renamed from: b */
    private static List<Classify.CheckedNode> m53241b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                Classify.CheckedNode checkedNode = new Classify.CheckedNode();
                checkedNode.f7183id = optJSONObject.optString("id");
                checkedNode.value = optJSONObject.optString(DomainCampaignEx.LOOPBACK_VALUE);
                checkedNode.name = optJSONObject.optString("name");
                arrayList.add(checkedNode);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private static Classify m53240c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Classify classify = new Classify();
        classify.itermData = m53238e(jSONObject.optJSONObject("item_data"));
        classify.retainState = m53232k(jSONObject.optJSONObject("retain_state"));
        return classify;
    }

    /* renamed from: d */
    private static List<Classify.Data> m53239d(JSONArray jSONArray) {
        Classify.DataCategory m53234i;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Classify.Data data = new Classify.Data();
                JSONArray optJSONArray = optJSONObject.optJSONArray("category");
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null && (m53234i = m53234i(optJSONObject2)) != null) {
                            arrayList2.add(m53234i);
                        }
                    }
                }
                data.categories = arrayList2;
                data.checked = optJSONObject.optInt("checked");
                data.classifyItemType = optJSONObject.optString("classify_item_type");
                data.isCancelDefaultSelect = optJSONObject.optInt("is_cancel_default_select");
                data.isNoBtn = optJSONObject.optInt("is_no_btn");
                data.name = optJSONObject.optString("name");
                data.params = optJSONObject.optString("params");
                data.separator = optJSONObject.optString("separator");
                data.type = optJSONObject.optString("type");
                data.useCommonlyUsedConfig = optJSONObject.optInt("use_commonly_used_config");
                data.useLocalConfig = optJSONObject.optInt("use_local_config");
                data.useRemoteConfig = optJSONObject.optInt("use_remote_config");
                data.multiSelect = optJSONObject.optInt("multi_select");
                arrayList.add(data);
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    private static Classify.ItermData m53238e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Classify.ItermData itermData = new Classify.ItermData();
        itermData.checkedNodes = m53241b(jSONObject.optJSONArray("checked_nodes"));
        itermData.checkedValue = m53236g(jSONObject.optJSONObject("checked_value"));
        itermData.datas = m53239d(jSONObject.optJSONArray("data"));
        itermData.defaultPositionDatas = m53239d(jSONObject.optJSONArray("default_position_data"));
        itermData.level2Datas = m53239d(jSONObject.optJSONArray("level2_data"));
        return itermData;
    }

    /* renamed from: f */
    private static List<ListData.ChargeInfo> m53237f(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                ListData.ChargeInfo chargeInfo = new ListData.ChargeInfo();
                JSONArray optJSONArray = optJSONObject.optJSONArray("plugs_info");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            ListData.PlugsInfo plugsInfo = new ListData.PlugsInfo();
                            plugsInfo.brandDesc = optJSONObject2.optString("brand_desc");
                            plugsInfo.fastcur = optJSONObject2.optString("fastcur");
                            plugsInfo.fastpower = optJSONObject2.optString("fastpower");
                            plugsInfo.fastvol = optJSONObject2.optString("fastvol");
                            arrayList2.add(plugsInfo);
                        }
                    }
                    chargeInfo.plugsInfos = arrayList2;
                    chargeInfo.plugsType = optJSONObject.optString("plugstype");
                    arrayList.add(chargeInfo);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    private static Classify.CheckedValue m53236g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Classify.CheckedValue checkedValue = new Classify.CheckedValue();
        checkedValue.classifyV2Data = jSONObject.optString("classify_v2_data");
        checkedValue.classifyV2Level2Data = jSONObject.optString("classify_v2_level2_data");
        checkedValue.classifyV2Level3Data = jSONObject.optString("classify_v2_level3_data");
        return checkedValue;
    }

    /* renamed from: h */
    private static ListData.PriceChargingPark m53235h(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ListData.PriceChargingPark priceChargingPark = new ListData.PriceChargingPark();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                ListData.Park park = new ListData.Park();
                park.srcType = optJSONObject.optString(Constants.JumpUrlConstants.URL_KEY_SRC);
                JSONArray optJSONArray = optJSONObject.optJSONArray("price_charging");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            ListData.PriceCharging priceCharging = new ListData.PriceCharging();
                            priceCharging.elePrice = optJSONObject2.optString("ele_price");
                            priceCharging.serPrice = optJSONObject2.optString("ser_price");
                            priceCharging.time = optJSONObject2.optString(RtspHeaders.Values.TIME);
                            priceCharging.updatetime = optJSONObject2.optInt("updatetime");
                            arrayList2.add(priceCharging);
                        }
                    }
                    park.priceChargings = arrayList2;
                }
                arrayList.add(park);
            }
        }
        priceChargingPark.parks = arrayList;
        return priceChargingPark;
    }

    /* renamed from: i */
    private static Classify.DataCategory m53234i(JSONObject jSONObject) {
        Classify.Category m53233j;
        if (jSONObject == null) {
            return null;
        }
        Classify.DataCategory dataCategory = new Classify.DataCategory();
        JSONArray optJSONArray = jSONObject.optJSONArray("category");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null && (m53233j = m53233j(optJSONObject)) != null) {
                    arrayList.add(m53233j);
                }
            }
        }
        dataCategory.categories = arrayList;
        dataCategory.checked = jSONObject.optInt("checked");
        dataCategory.defaultValue = jSONObject.optInt("default");
        dataCategory.componentType = jSONObject.optString("component_type");
        dataCategory.name = jSONObject.optString("name");
        dataCategory.params = jSONObject.optString("params");
        dataCategory.areaSubwayMark = jSONObject.optInt("area_subway_mark");
        dataCategory.hideTitle = jSONObject.optInt("hide_title");
        dataCategory.maxShowNum = jSONObject.optInt("max_show_num");
        dataCategory.maxShowNumRow = jSONObject.optInt("max_show_num_row");
        dataCategory.multiSelect = jSONObject.optInt("multi_select");
        dataCategory.img = jSONObject.optString(SocialConstants.PARAM_IMG_URL);
        dataCategory.showType = jSONObject.optString("show_type");
        dataCategory.value = jSONObject.optString(DomainCampaignEx.LOOPBACK_VALUE);
        dataCategory.classifyItemType = jSONObject.optString("classify_item_type");
        return dataCategory;
    }

    /* renamed from: j */
    private static Classify.Category m53233j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Classify.Category category = new Classify.Category();
        category.checked = jSONObject.optInt("checked");
        category.componentType = jSONObject.optString("component_type");
        category.defaultValue = jSONObject.optInt("default");
        category.name = jSONObject.optString("name");
        category.value = jSONObject.optString(DomainCampaignEx.LOOPBACK_VALUE);
        category.classifyItemType = jSONObject.optString("classify_item_type");
        category.img = jSONObject.optString(SocialConstants.PARAM_IMG_URL);
        category.showType = jSONObject.optString("show_type");
        category.params = jSONObject.optString("params");
        return category;
    }

    /* renamed from: k */
    private static Classify.RetainState m53232k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Classify.RetainState retainState = new Classify.RetainState();
        retainState.classifyBusinessType = jSONObject.optString("classify_business_type");
        retainState.classifyConf = jSONObject.optString("classify_conf");
        retainState.classifyRetainLevel2 = jSONObject.optString("classify_retain_level2");
        retainState.level2All = jSONObject.optString("level2_all");
        retainState.newClassifyCityadcode = jSONObject.optString("new_classify_cityadcode");
        retainState.newClassifyFlag = jSONObject.optString("new_classify_flag");
        return retainState;
    }

    /* renamed from: l */
    private static ListData m53231l(JSONObject jSONObject) {
        ListData.Content m53230m;
        if (jSONObject == null) {
            return null;
        }
        ListData listData = new ListData();
        JSONArray optJSONArray = jSONObject.optJSONArray("content");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && (m53230m = m53230m(optJSONObject)) != null) {
                arrayList.add(m53230m);
            }
        }
        listData.content = arrayList;
        return listData;
    }

    /* renamed from: m */
    private static ListData.Content m53230m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ListData.Content content = new ListData.Content();
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            ListData.Data data = new ListData.Data();
            data.basicInfo = m53229n(optJSONObject.optJSONObject("basic_info"));
            data.chargingInfo = m53228o(optJSONObject.optJSONObject("charging_info"));
            content.data = data;
        }
        content.itemType = jSONObject.optString("item_type");
        return content;
    }

    /* renamed from: n */
    private static ListData.BasicInfo m53229n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ListData.BasicInfo basicInfo = new ListData.BasicInfo();
        basicInfo.adcode = jSONObject.optString("adcode");
        basicInfo.address = jSONObject.optString("address");
        basicInfo.averagecost = jSONObject.optString("averagecost");
        basicInfo.buildingStatus = jSONObject.optString("building_status");
        basicInfo.businessArea = jSONObject.optString("business_area");
        basicInfo.childShortname = jSONObject.optString("child_shortname");
        basicInfo.childShortnameEn = jSONObject.optString("child_shortname_en");
        basicInfo.childtype = jSONObject.optString("childtype");
        basicInfo.citycode = jSONObject.optString("citycode");
        basicInfo.cname = jSONObject.optString("cname");
        basicInfo.dispName = jSONObject.optString("disp_name");
        basicInfo.distance = jSONObject.optString("distance");
        basicInfo.dname = jSONObject.optString("dname");
        basicInfo.eaddress = jSONObject.optString("eaddress");
        basicInfo.endPoiExtension = jSONObject.optString("end_poi_extension");
        basicInfo.fNona = jSONObject.optString("f_nona");
        basicInfo.hisMark = jSONObject.optString("his_mark");
        basicInfo.hotText = jSONObject.optString("hot_text");
        basicInfo.f7184id = jSONObject.optString("id");
        basicInfo.industry = jSONObject.optString("industry");
        basicInfo.latitude = jSONObject.optString("latitude");
        basicInfo.longitude = jSONObject.optString("longitude");
        basicInfo.name = jSONObject.optString("name");
        basicInfo.category = jSONObject.optString("category");
        ListData.NaviVisited naviVisited = new ListData.NaviVisited();
        JSONObject optJSONObject = jSONObject.optJSONObject("navi_visited");
        if (optJSONObject != null) {
            naviVisited.randUnionMonthUv = optJSONObject.optString("rand_union_month_uv");
        }
        basicInfo.naviVisited = naviVisited;
        basicInfo.numSpaceW = jSONObject.optString("num_space_w");
        basicInfo.numSpaceWF = jSONObject.optString("num_space_w_f");
        basicInfo.opentime2 = jSONObject.optString("opentime2");
        basicInfo.opentimeText = jSONObject.optString("opentime_text");
        basicInfo.parent = jSONObject.optString("parent");
        basicInfo.parentName = jSONObject.optString("parent_name");
        basicInfo.picInfo = jSONObject.optString("pic_info");
        basicInfo.rating = jSONObject.optString(CampaignEx.JSON_KEY_STAR);
        basicInfo.recommendFlag = jSONObject.optString("recommend_flag");
        basicInfo.reviewTotal = jSONObject.optString("review_total");
        basicInfo.sell = jSONObject.optString("sell");
        ListData.ShortReview shortReview = new ListData.ShortReview();
        if (jSONObject.optJSONObject("short_review") != null) {
            basicInfo.shortReview = shortReview;
        }
        basicInfo.tel = jSONObject.optString("tel");
        basicInfo.towardsAngle = jSONObject.optString("towards_angle");
        basicInfo.typeCode = jSONObject.optString("typecode");
        basicInfo.updateFlag = jSONObject.optString("update_flag");
        basicInfo.xEntr = jSONObject.optString("x_entr");
        basicInfo.yEntr = jSONObject.optString("y_entr");
        return basicInfo;
    }

    /* renamed from: o */
    private static ListData.ChargingInfo m53228o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ListData.ChargingInfo chargingInfo = new ListData.ChargingInfo();
        chargingInfo.brandDesc = jSONObject.optString("brand_desc");
        chargingInfo.chargeInfo = m53237f(jSONObject.optJSONArray("charge_info"));
        chargingInfo.chargingRatingFlagTerm = jSONObject.optString("charging_rating_flag_term");
        chargingInfo.creditZhima = jSONObject.optString("credit_zhima");
        chargingInfo.cscf = jSONObject.optString("cscf");
        chargingInfo.currentElePrice = jSONObject.optString("current_ele_price");
        chargingInfo.currentSerPrice = jSONObject.optString("current_ser_price");
        chargingInfo.deepRightsTag = jSONObject.optString("deep_rights_tag");
        chargingInfo.latestCharge = jSONObject.optString("latest_charge");
        chargingInfo.numFast = jSONObject.optString("num_fast");
        chargingInfo.numSlow = jSONObject.optString("num_slow");
        chargingInfo.parkCategory = jSONObject.optString("park_category");
        chargingInfo.priceChargingPark = m53235h(jSONObject.optJSONArray("price_charging_pack"));
        chargingInfo.priceParkingStd = jSONObject.optString("price_parking_std");
        JSONObject optJSONObject = jSONObject.optJSONObject("iddictionary");
        if (optJSONObject != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
            chargingInfo.idDictionary = hashMap;
        }
        return chargingInfo;
    }

    /* renamed from: p */
    private static Lqii m53227p(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Lqii lqii = new Lqii();
        lqii.categoryBrandRecognitionResult = jSONObject.optString("category_brand_recognition_result");
        lqii.changeQueryTip = jSONObject.optString("change_query_tip");
        lqii.expandRangeTip = jSONObject.optString("change_query_tip");
        lqii.isCurrentCity = jSONObject.optString("is_current_city");
        lqii.isUserCity = jSONObject.optString("is_user_city");
        lqii.queryCateResult = jSONObject.optString("query_cate_result");
        lqii.suggestContent = jSONObject.optString("suggestcontent");
        lqii.targetViewCity = jSONObject.optString("target_view_city");
        lqii.totalhits = jSONObject.optString("totalhits");
        lqii.viewRegion = jSONObject.optString("view_region");
        return lqii;
    }

    /* renamed from: q */
    private static Meta m53226q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Meta meta = new Meta();
        meta.listBizType = jSONObject.optString("list_biz_type");
        return meta;
    }
}
