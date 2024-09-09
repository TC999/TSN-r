package com.amap.api.col.s;

import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.Classify;
import com.amap.api.services.auto.ListData;
import com.amap.api.services.auto.Lqii;
import com.amap.api.services.auto.Meta;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AutoTSearchResultParser.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b1 {
    public static AutoTChargeStationResult a(JSONObject jSONObject) {
        AutoTChargeStationResult autoTChargeStationResult = new AutoTChargeStationResult();
        try {
            autoTChargeStationResult.code = jSONObject.optInt("code");
            autoTChargeStationResult.message = jSONObject.optString("message");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                autoTChargeStationResult.classify = c(optJSONObject.optJSONObject("classify"));
                autoTChargeStationResult.listData = l(optJSONObject.optJSONObject("list_data"));
                autoTChargeStationResult.lqii = p(optJSONObject.optJSONObject("lqii"));
                autoTChargeStationResult.meta = q(optJSONObject.optJSONObject("meta"));
                autoTChargeStationResult.originJson = optJSONObject.toString();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return autoTChargeStationResult;
    }

    private static List<Classify.CheckedNode> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                Classify.CheckedNode checkedNode = new Classify.CheckedNode();
                checkedNode.id = optJSONObject.optString("id");
                checkedNode.value = optJSONObject.optString("value");
                checkedNode.name = optJSONObject.optString("name");
                arrayList.add(checkedNode);
            }
        }
        return arrayList;
    }

    private static Classify c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Classify classify = new Classify();
        classify.itermData = e(jSONObject.optJSONObject("item_data"));
        classify.retainState = k(jSONObject.optJSONObject("retain_state"));
        return classify;
    }

    private static List<Classify.Data> d(JSONArray jSONArray) {
        Classify.DataCategory i4;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i5);
            if (optJSONObject != null) {
                Classify.Data data = new Classify.Data();
                JSONArray optJSONArray = optJSONObject.optJSONArray("category");
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray != null) {
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                        if (optJSONObject2 != null && (i4 = i(optJSONObject2)) != null) {
                            arrayList2.add(i4);
                        }
                    }
                }
                data.categories = arrayList2;
                data.checked = optJSONObject.optInt("checked");
                data.classifyItemType = optJSONObject.optString("classify_item_type");
                data.isCancelDefaultSelect = optJSONObject.optInt("is_cancel_default_select");
                data.isNoBtn = optJSONObject.optInt("is_no_btn");
                data.name = optJSONObject.optString("name");
                data.params = optJSONObject.optString(EventMonitor.V3_PARAMS);
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

    private static Classify.ItermData e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Classify.ItermData itermData = new Classify.ItermData();
        itermData.checkedNodes = b(jSONObject.optJSONArray("checked_nodes"));
        itermData.checkedValue = g(jSONObject.optJSONObject("checked_value"));
        itermData.datas = d(jSONObject.optJSONArray("data"));
        itermData.defaultPositionDatas = d(jSONObject.optJSONArray("default_position_data"));
        itermData.level2Datas = d(jSONObject.optJSONArray("level2_data"));
        return itermData;
    }

    private static List<ListData.ChargeInfo> f(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                ListData.ChargeInfo chargeInfo = new ListData.ChargeInfo();
                JSONArray optJSONArray = optJSONObject.optJSONArray("plugs_info");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
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

    private static Classify.CheckedValue g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Classify.CheckedValue checkedValue = new Classify.CheckedValue();
        checkedValue.classifyV2Data = jSONObject.optString("classify_v2_data");
        checkedValue.classifyV2Level2Data = jSONObject.optString("classify_v2_level2_data");
        checkedValue.classifyV2Level3Data = jSONObject.optString("classify_v2_level3_data");
        return checkedValue;
    }

    private static ListData.PriceChargingPark h(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ListData.PriceChargingPark priceChargingPark = new ListData.PriceChargingPark();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                ListData.Park park = new ListData.Park();
                park.srcType = optJSONObject.optString("src_type");
                JSONArray optJSONArray = optJSONObject.optJSONArray("price_charging");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                        if (optJSONObject2 != null) {
                            ListData.PriceCharging priceCharging = new ListData.PriceCharging();
                            priceCharging.elePrice = optJSONObject2.optString("ele_price");
                            priceCharging.serPrice = optJSONObject2.optString("ser_price");
                            priceCharging.time = optJSONObject2.optString("time");
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

    private static Classify.DataCategory i(JSONObject jSONObject) {
        Classify.Category j4;
        if (jSONObject == null) {
            return null;
        }
        Classify.DataCategory dataCategory = new Classify.DataCategory();
        JSONArray optJSONArray = jSONObject.optJSONArray("category");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null && (j4 = j(optJSONObject)) != null) {
                    arrayList.add(j4);
                }
            }
        }
        dataCategory.categories = arrayList;
        dataCategory.checked = jSONObject.optInt("checked");
        dataCategory.defaultValue = jSONObject.optInt("default");
        dataCategory.componentType = jSONObject.optString("component_type");
        dataCategory.name = jSONObject.optString("name");
        dataCategory.params = jSONObject.optString(EventMonitor.V3_PARAMS);
        dataCategory.areaSubwayMark = jSONObject.optInt("area_subway_mark");
        dataCategory.hideTitle = jSONObject.optInt("hide_title");
        dataCategory.maxShowNum = jSONObject.optInt("max_show_num");
        dataCategory.maxShowNumRow = jSONObject.optInt("max_show_num_row");
        dataCategory.multiSelect = jSONObject.optInt("multi_select");
        dataCategory.img = jSONObject.optString("img");
        dataCategory.showType = jSONObject.optString("show_type");
        dataCategory.value = jSONObject.optString("value");
        dataCategory.classifyItemType = jSONObject.optString("classify_item_type");
        return dataCategory;
    }

    private static Classify.Category j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Classify.Category category = new Classify.Category();
        category.checked = jSONObject.optInt("checked");
        category.componentType = jSONObject.optString("component_type");
        category.defaultValue = jSONObject.optInt("default");
        category.name = jSONObject.optString("name");
        category.value = jSONObject.optString("value");
        category.classifyItemType = jSONObject.optString("classify_item_type");
        category.img = jSONObject.optString("img");
        category.showType = jSONObject.optString("show_type");
        category.params = jSONObject.optString(EventMonitor.V3_PARAMS);
        return category;
    }

    private static Classify.RetainState k(JSONObject jSONObject) {
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

    private static ListData l(JSONObject jSONObject) {
        ListData.Content m4;
        if (jSONObject == null) {
            return null;
        }
        ListData listData = new ListData();
        JSONArray optJSONArray = jSONObject.optJSONArray("content");
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null && (m4 = m(optJSONObject)) != null) {
                arrayList.add(m4);
            }
        }
        listData.content = arrayList;
        return listData;
    }

    private static ListData.Content m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ListData.Content content = new ListData.Content();
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            ListData.Data data = new ListData.Data();
            data.basicInfo = n(optJSONObject.optJSONObject("basic_info"));
            data.chargingInfo = o(optJSONObject.optJSONObject("charging_info"));
            content.data = data;
        }
        content.itemType = jSONObject.optString("item_type");
        return content;
    }

    private static ListData.BasicInfo n(JSONObject jSONObject) {
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
        basicInfo.id = jSONObject.optString("id");
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

    private static ListData.ChargingInfo o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ListData.ChargingInfo chargingInfo = new ListData.ChargingInfo();
        chargingInfo.brandDesc = jSONObject.optString("brand_desc");
        chargingInfo.chargeInfo = f(jSONObject.optJSONArray("charge_info"));
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
        chargingInfo.priceChargingPark = h(jSONObject.optJSONArray("price_charging_pack"));
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

    private static Lqii p(JSONObject jSONObject) {
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

    private static Meta q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Meta meta = new Meta();
        meta.listBizType = jSONObject.optString("list_biz_type");
        return meta;
    }
}
