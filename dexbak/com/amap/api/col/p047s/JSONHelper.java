package com.amap.api.col.p047s;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.poisearch.SubPoiItemV2;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusPathV2;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.BusStepV2;
import com.amap.api.services.route.ChargeStationInfo;
import com.amap.api.services.route.Cost;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePathV2;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.DriveStepV2;
import com.amap.api.services.route.ElecConsumeInfo;
import com.amap.api.services.route.Navi;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TaxiItemV2;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UContent;
import com.umeng.ccg.CcgConstant;
import com.umeng.socialize.common.SocializeConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.r4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class JSONHelper {

    /* renamed from: a */
    private static String[] f6460a = {"010", "021", "022", "023", "1852", "1853"};

    /* renamed from: A */
    private static void m52576A(PoiItemV2 poiItemV2, JSONObject jSONObject) throws JSONException {
        poiItemV2.setPhotos(m52494q(jSONObject));
    }

    /* renamed from: A0 */
    public static TruckRouteRestult m52575A0(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
                JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
                truckRouteRestult.setStartPos(m52540S(optJSONObject, "origin"));
                truckRouteRestult.setTargetPos(m52540S(optJSONObject, RtspHeaders.Values.DESTINATION));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        TruckPath truckPath = new TruckPath();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        truckPath.setDistance(m52549N0(m52484v(jSONObject2, "distance")));
                        truckPath.setDuration(m52541R0(m52484v(jSONObject2, "duration")));
                        truckPath.setStrategy(m52484v(jSONObject2, "strategy"));
                        truckPath.setTolls(m52549N0(m52484v(jSONObject2, "tolls")));
                        truckPath.setTollDistance(m52549N0(m52484v(jSONObject2, "toll_distance")));
                        truckPath.setTotalTrafficlights(m52553L0(m52484v(jSONObject2, "traffic_lights")));
                        truckPath.setRestriction(m52553L0(m52484v(jSONObject2, "restriction")));
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                        if (optJSONArray2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                TruckStep truckStep = new TruckStep();
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    truckStep.setInstruction(m52484v(optJSONObject2, "instruction"));
                                    truckStep.setOrientation(m52484v(optJSONObject2, "orientation"));
                                    truckStep.setRoad(m52484v(optJSONObject2, "road"));
                                    truckStep.setDistance(m52549N0(m52484v(optJSONObject2, "distance")));
                                    truckStep.setTolls(m52549N0(m52484v(optJSONObject2, "tolls")));
                                    truckStep.setTollDistance(m52549N0(m52484v(optJSONObject2, "toll_distance")));
                                    truckStep.setTollRoad(m52484v(optJSONObject2, "toll_road"));
                                    truckStep.setDuration(m52549N0(m52484v(optJSONObject2, "duration")));
                                    truckStep.setPolyline(m52525a0(optJSONObject2, "polyline"));
                                    truckStep.setAction(m52484v(optJSONObject2, CcgConstant.f38549t));
                                    truckStep.setAssistantAction(m52484v(optJSONObject2, "assistant_action"));
                                    m52564G(truckStep, optJSONObject2);
                                    m52544Q(truckStep, optJSONObject2);
                                    arrayList2.add(truckStep);
                                }
                            }
                            truckPath.setSteps(arrayList2);
                            arrayList.add(truckPath);
                        }
                    }
                    truckRouteRestult.setPaths(arrayList);
                    return truckRouteRestult;
                }
                return truckRouteRestult;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseTruckRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: B */
    private static void m52574B(RegeocodeAddress regeocodeAddress) {
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && m52567E0(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    /* renamed from: B0 */
    private static BusStationItem m52573B0(JSONObject jSONObject) throws JSONException {
        BusStationItem m52569D0 = m52569D0(jSONObject);
        m52569D0.setAdCode(m52484v(jSONObject, "adcode"));
        m52569D0.setCityCode(m52484v(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            m52569D0.setBusLineItems(arrayList);
            return m52569D0;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m52565F0(optJSONObject));
            }
        }
        m52569D0.setBusLineItems(arrayList);
        return m52569D0;
    }

    /* renamed from: C */
    private static void m52572C(Cost cost, JSONObject jSONObject) throws AMapException {
        try {
            cost.setTolls(m52549N0(m52484v(jSONObject, "tolls")));
            cost.setTollDistance(m52549N0(m52484v(jSONObject, "toll_distance")));
            cost.setTollRoad(m52484v(jSONObject, "toll_road"));
            cost.setDuration(m52549N0(m52484v(jSONObject, "duration")));
            cost.setTrafficLights(m52553L0(m52484v(jSONObject, "traffic_lights")));
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseCostDetail");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01a4 A[Catch: all -> 0x021b, JSONException -> 0x021d, TryCatch #3 {JSONException -> 0x021d, all -> 0x021b, blocks: (B:37:0x00cf, B:39:0x00e2, B:40:0x00eb, B:42:0x00fa, B:43:0x0102, B:46:0x010f, B:49:0x0116, B:50:0x011c, B:52:0x0122, B:54:0x012d, B:57:0x0134, B:59:0x0147, B:60:0x014d, B:62:0x0153, B:64:0x015e, B:71:0x0199, B:73:0x01a4, B:74:0x01ac, B:76:0x01b2, B:78:0x01bf, B:80:0x01e2, B:81:0x01e9, B:83:0x01f6, B:84:0x01ff, B:86:0x020e, B:87:0x0217), top: B:104:0x00cf }] */
    /* renamed from: C0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.amap.api.services.route.DriveRoutePlanResult m52571C0(java.lang.String r20) throws com.amap.api.services.core.AMapException {
        /*
            Method dump skipped, instructions count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.JSONHelper.m52571C0(java.lang.String):com.amap.api.services.route.DriveRoutePlanResult");
    }

    /* renamed from: D */
    private static void m52570D(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    tmc.setDistance(m52553L0(m52484v(optJSONObject, "distance")));
                    tmc.setStatus(m52484v(optJSONObject, "status"));
                    tmc.setPolyline(m52525a0(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            driveStep.setTMCs(arrayList);
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: D0 */
    private static BusStationItem m52569D0(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(m52484v(jSONObject, "id"));
        busStationItem.setLatLonPoint(m52540S(jSONObject, SocializeConstants.KEY_LOCATION));
        busStationItem.setBusStationName(m52484v(jSONObject, "name"));
        return busStationItem;
    }

    /* renamed from: E */
    private static void m52568E(Path path, List<WalkStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (WalkStep walkStep : list) {
            if (walkStep != null && walkStep.getPolyline() != null) {
                polyline.addAll(walkStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    /* renamed from: E0 */
    private static boolean m52567E0(String str) {
        if (str != null && str.length() > 0) {
            for (String str2 : f6460a) {
                if (str.trim().equals(str2.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: F */
    private static void m52566F(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        district.setDistrictName(m52484v(optJSONObject, "name"));
                        district.setDistrictAdcode(m52484v(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e) {
                C2082j4.m52825i(e, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    /* renamed from: F0 */
    private static BusLineItem m52565F0(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(m52484v(jSONObject, "id"));
        busLineItem.setBusLineType(m52484v(jSONObject, "type"));
        busLineItem.setBusLineName(m52484v(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(m52525a0(jSONObject, "polyline"));
        busLineItem.setCityCode(m52484v(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(m52484v(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(m52484v(jSONObject, "end_stop"));
        return busLineItem;
    }

    /* renamed from: G */
    private static void m52564G(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(m52484v(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(m52484v(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(m52484v(optJSONObject, "adcode"));
                    m52566F(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            truckStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: G0 */
    private static ArrayList<LatLonPoint> m52563G0(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : str.split(";")) {
            arrayList.add(m52559I0(str2));
        }
        return arrayList;
    }

    /* renamed from: H */
    public static void m52562H(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                crossroad.setId(m52484v(optJSONObject, "id"));
                crossroad.setDirection(m52484v(optJSONObject, "direction"));
                crossroad.setDistance(m52549N0(m52484v(optJSONObject, "distance")));
                crossroad.setCenterPoint(m52540S(optJSONObject, SocializeConstants.KEY_LOCATION));
                crossroad.setFirstRoadId(m52484v(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(m52484v(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(m52484v(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(m52484v(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    /* renamed from: H0 */
    private static BusLineItem m52561H0(JSONObject jSONObject) throws JSONException {
        BusLineItem m52565F0 = m52565F0(jSONObject);
        m52565F0.setFirstBusTime(C2082j4.m52820n(m52484v(jSONObject, UContent.f38151p)));
        m52565F0.setLastBusTime(C2082j4.m52820n(m52484v(jSONObject, UContent.f38152q)));
        m52565F0.setBusCompany(m52484v(jSONObject, "company"));
        m52565F0.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        m52565F0.setBasicPrice(m52549N0(m52484v(jSONObject, "basic_price")));
        m52565F0.setTotalPrice(m52549N0(m52484v(jSONObject, "total_price")));
        m52565F0.setBounds(m52525a0(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            m52565F0.setBusStations(arrayList);
            return m52565F0;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m52569D0(optJSONObject));
            }
        }
        m52565F0.setBusStations(arrayList);
        return m52565F0;
    }

    /* renamed from: I */
    public static void m52560I(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m52557J0(optJSONObject));
            }
        }
        if (districtItem != null) {
            districtItem.setSubDistrict(arrayList);
        }
    }

    /* renamed from: I0 */
    private static LatLonPoint m52559I0(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    /* renamed from: J */
    public static void m52558J(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setCountry(m52484v(jSONObject, "country"));
        regeocodeAddress.setCountryCode(m52484v(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(m52484v(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(m52484v(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(m52484v(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(m52484v(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(m52484v(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(m52484v(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(m52484v(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(m52484v(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(m52484v(optJSONObject, "street"));
        streetNumber.setNumber(m52484v(optJSONObject, "number"));
        streetNumber.setLatLonPoint(m52540S(optJSONObject, SocializeConstants.KEY_LOCATION));
        streetNumber.setDirection(m52484v(optJSONObject, "direction"));
        streetNumber.setDistance(m52549N0(m52484v(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(m52551M0(jSONObject));
        regeocodeAddress.setTowncode(m52484v(jSONObject, "towncode"));
        m52574B(regeocodeAddress);
    }

    /* renamed from: J0 */
    private static DistrictItem m52557J0(JSONObject jSONObject) throws JSONException {
        String optString;
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(m52484v(jSONObject, "citycode"));
        districtItem.setAdcode(m52484v(jSONObject, "adcode"));
        districtItem.setName(m52484v(jSONObject, "name"));
        districtItem.setLevel(m52484v(jSONObject, "level"));
        districtItem.setCenter(m52540S(jSONObject, "center"));
        if (jSONObject.has("polyline") && (optString = jSONObject.optString("polyline")) != null && optString.length() > 0) {
            districtItem.setDistrictBoundary(optString.split("\\|"));
        }
        m52560I(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    /* renamed from: K */
    private static int m52556K(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optInt(str);
        }
        return -1;
    }

    /* renamed from: K0 */
    private static boolean m52555K0(String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    /* renamed from: L */
    public static BusRouteResultV2 m52554L(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                BusRouteResultV2 busRouteResultV2 = new BusRouteResultV2();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return busRouteResultV2;
                }
                busRouteResultV2.setStartPos(m52540S(optJSONObject, "origin"));
                busRouteResultV2.setTargetPos(m52540S(optJSONObject, RtspHeaders.Values.DESTINATION));
                busRouteResultV2.setDistance(m52549N0(m52484v(optJSONObject, "distance")));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                if (optJSONObject2 != null) {
                    busRouteResultV2.setTaxiCost(m52549N0(m52484v(optJSONObject2, "taxi_fee")));
                }
                if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                    busRouteResultV2.setPaths(m52550N(optJSONArray));
                    return busRouteResultV2;
                }
                return busRouteResultV2;
            }
            return null;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: L0 */
    private static int m52553L0(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C2082j4.m52825i(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    /* renamed from: M */
    public static ArrayList<String> m52552M(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        return arrayList;
    }

    /* renamed from: M0 */
    private static List<BusinessArea> m52551M0(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    businessArea.setCenterPoint(m52540S(optJSONObject, SocializeConstants.KEY_LOCATION));
                    businessArea.setName(m52484v(optJSONObject, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: N */
    private static List<BusPathV2> m52550N(JSONArray jSONArray) throws JSONException {
        BusStepV2 m52543Q0;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPathV2 busPathV2 = new BusPathV2();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                if (optJSONObject2 != null) {
                    busPathV2.setDuration(m52541R0(m52484v(optJSONObject2, "duration")));
                    busPathV2.setCost(m52549N0(m52484v(optJSONObject2, "transit_fee")));
                }
                busPathV2.setDistance(m52549N0(m52484v(optJSONObject, "distance")));
                busPathV2.setNightBus(m52535U0(m52484v(optJSONObject, "nightflag")));
                busPathV2.setWalkDistance(m52549N0(m52484v(optJSONObject, "walking_distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject3 != null && (m52543Q0 = m52543Q0(optJSONObject3)) != null) {
                            arrayList2.add(m52543Q0);
                            if (m52543Q0.getWalk() != null) {
                                f2 += m52543Q0.getWalk().getDistance();
                            }
                            if (m52543Q0.getBusLines() != null && m52543Q0.getBusLines().size() > 0) {
                                f += m52543Q0.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPathV2.setSteps(arrayList2);
                    busPathV2.setBusDistance(f);
                    busPathV2.setWalkDistance(f2);
                    arrayList.add(busPathV2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: N0 */
    private static float m52549N0(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            C2082j4.m52825i(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    /* renamed from: O */
    private static void m52548O(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(m52484v(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(m52484v(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(m52484v(optJSONObject, "adcode"));
                    m52566F(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            driveStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: O0 */
    private static BusStep m52547O0(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(m52539S0(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStep.setBusLines(m52533V0(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStep.setEntrance(m52529X0(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStep.setExit(m52529X0(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStep.setRailway(m52514g(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStep.setTaxi(m52502m(optJSONObject6));
        }
        if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
            return null;
        }
        return busStep;
    }

    /* renamed from: P */
    private static void m52546P(Path path, List<DriveStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStep driveStep : list) {
            if (driveStep != null && driveStep.getPolyline() != null) {
                polyline.addAll(driveStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    /* renamed from: P0 */
    private static double m52545P0(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return Utils.DOUBLE_EPSILON;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            C2082j4.m52825i(e, "JSONHelper", "str2float");
            return Utils.DOUBLE_EPSILON;
        }
    }

    /* renamed from: Q */
    private static void m52544Q(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    tmc.setDistance(m52553L0(m52484v(optJSONObject, "distance")));
                    tmc.setStatus(m52484v(optJSONObject, "status"));
                    tmc.setPolyline(m52525a0(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            truckStep.setTMCs(arrayList);
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: Q0 */
    private static BusStepV2 m52543Q0(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStepV2 busStepV2 = new BusStepV2();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStepV2.setWalk(m52537T0(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStepV2.setBusLines(m52531W0(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStepV2.setEntrance(m52529X0(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStepV2.setExit(m52529X0(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStepV2.setRailway(m52514g(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStepV2.setTaxi(m52500n(optJSONObject6));
        }
        if ((busStepV2.getWalk() == null || busStepV2.getWalk().getSteps().size() == 0) && busStepV2.getBusLines().size() == 0 && busStepV2.getRailway() == null && busStepV2.getTaxi() == null) {
            return null;
        }
        return busStepV2;
    }

    /* renamed from: R */
    public static void m52542R(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                regeocodeRoad.setId(m52484v(optJSONObject, "id"));
                regeocodeRoad.setName(m52484v(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(m52540S(optJSONObject, SocializeConstants.KEY_LOCATION));
                regeocodeRoad.setDirection(m52484v(optJSONObject, "direction"));
                regeocodeRoad.setDistance(m52549N0(m52484v(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    /* renamed from: R0 */
    private static long m52541R0(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            C2082j4.m52825i(e, "JSONHelper", "str2long");
            return 0L;
        }
    }

    /* renamed from: S */
    private static LatLonPoint m52540S(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return m52559I0(jSONObject.optString(str));
        }
        return null;
    }

    /* renamed from: S0 */
    private static RouteBusWalkItem m52539S0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(m52540S(jSONObject, "origin"));
        routeBusWalkItem.setDestination(m52540S(jSONObject, RtspHeaders.Values.DESTINATION));
        routeBusWalkItem.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        routeBusWalkItem.setDuration(m52541R0(m52484v(jSONObject, "duration")));
        if (jSONObject.has("steps") && (optJSONArray = jSONObject.optJSONArray("steps")) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(m52526a(optJSONObject));
                }
            }
            routeBusWalkItem.setSteps(arrayList);
            m52568E(routeBusWalkItem, arrayList);
            return routeBusWalkItem;
        }
        return routeBusWalkItem;
    }

    /* renamed from: T */
    public static DriveRouteResult m52538T(String str) throws AMapException {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                DriveRouteResult driveRouteResult = new DriveRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return driveRouteResult;
                }
                driveRouteResult.setStartPos(m52540S(optJSONObject, "origin"));
                driveRouteResult.setTargetPos(m52540S(optJSONObject, RtspHeaders.Values.DESTINATION));
                driveRouteResult.setTaxiCost(m52549N0(m52484v(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < optJSONArray.length()) {
                        DrivePath drivePath = new DrivePath();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            drivePath.setDistance(m52549N0(m52484v(optJSONObject2, "distance")));
                            drivePath.setDuration(m52541R0(m52484v(optJSONObject2, "duration")));
                            drivePath.setStrategy(m52484v(optJSONObject2, "strategy"));
                            drivePath.setTolls(m52549N0(m52484v(optJSONObject2, "tolls")));
                            drivePath.setTollDistance(m52549N0(m52484v(optJSONObject2, "toll_distance")));
                            drivePath.setTotalTrafficlights(m52553L0(m52484v(optJSONObject2, "traffic_lights")));
                            drivePath.setRestriction(m52553L0(m52484v(optJSONObject2, "restriction")));
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray2 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                int i2 = 0;
                                while (i2 < optJSONArray2.length()) {
                                    DriveStep driveStep = new DriveStep();
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                    if (optJSONObject3 != null) {
                                        jSONArray2 = optJSONArray;
                                        driveStep.setInstruction(m52484v(optJSONObject3, "instruction"));
                                        driveStep.setOrientation(m52484v(optJSONObject3, "orientation"));
                                        driveStep.setRoad(m52484v(optJSONObject3, "road"));
                                        driveStep.setDistance(m52549N0(m52484v(optJSONObject3, "distance")));
                                        driveStep.setTolls(m52549N0(m52484v(optJSONObject3, "tolls")));
                                        driveStep.setTollDistance(m52549N0(m52484v(optJSONObject3, "toll_distance")));
                                        driveStep.setTollRoad(m52484v(optJSONObject3, "toll_road"));
                                        driveStep.setDuration(m52549N0(m52484v(optJSONObject3, "duration")));
                                        driveStep.setPolyline(m52525a0(optJSONObject3, "polyline"));
                                        driveStep.setAction(m52484v(optJSONObject3, CcgConstant.f38549t));
                                        driveStep.setAssistantAction(m52484v(optJSONObject3, "assistant_action"));
                                        m52548O(driveStep, optJSONObject3);
                                        m52570D(driveStep, optJSONObject3);
                                        arrayList2.add(driveStep);
                                    } else {
                                        jSONArray2 = optJSONArray;
                                    }
                                    i2++;
                                    optJSONArray = jSONArray2;
                                }
                                jSONArray = optJSONArray;
                                drivePath.setSteps(arrayList2);
                                m52546P(drivePath, arrayList2);
                                arrayList.add(drivePath);
                                i++;
                                optJSONArray = jSONArray;
                            }
                        }
                        jSONArray = optJSONArray;
                        i++;
                        optJSONArray = jSONArray;
                    }
                    driveRouteResult.setPaths(arrayList);
                    return driveRouteResult;
                }
                return driveRouteResult;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            C2082j4.m52825i(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: T0 */
    private static RouteBusWalkItem m52537T0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(m52540S(jSONObject, "origin"));
        routeBusWalkItem.setDestination(m52540S(jSONObject, RtspHeaders.Values.DESTINATION));
        routeBusWalkItem.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        JSONObject optJSONObject = jSONObject.optJSONObject("cost");
        if (optJSONObject != null) {
            routeBusWalkItem.setDuration(m52541R0(m52484v(optJSONObject, "duration")));
        }
        if (jSONObject.has("steps") && (optJSONArray = jSONObject.optJSONArray("steps")) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    arrayList.add(m52524b(optJSONObject2));
                }
            }
            routeBusWalkItem.setSteps(arrayList);
            m52568E(routeBusWalkItem, arrayList);
            return routeBusWalkItem;
        }
        return routeBusWalkItem;
    }

    /* renamed from: U */
    public static ArrayList<PoiItem> m52536U(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("pois")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(m52519d0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: U0 */
    private static boolean m52535U0(String str) {
        return (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) || str.equals("0") || !str.equals("1")) ? false : true;
    }

    /* renamed from: V */
    private static List<ChargeStationInfo> m52534V(JSONArray jSONArray) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                ChargeStationInfo chargeStationInfo = new ChargeStationInfo();
                chargeStationInfo.setName(m52484v(jSONObject, "name"));
                chargeStationInfo.setPoiId(m52484v(jSONObject, "poiid"));
                chargeStationInfo.setBrandName(m52484v(jSONObject, "brand_name"));
                chargeStationInfo.setShowPoint(m52540S(jSONObject, "show_point"));
                chargeStationInfo.setProjectivePoint(m52540S(jSONObject, "projective_point"));
                chargeStationInfo.setMaxPower(m52556K(jSONObject, "max_power"));
                chargeStationInfo.setChargePercent(m52556K(jSONObject, "charge_percent"));
                chargeStationInfo.setChargeTime(m52556K(jSONObject, "charge_time"));
                chargeStationInfo.setRemainingCapacity(m52556K(jSONObject, "remaining_capacity"));
                chargeStationInfo.setVoltage(m52556K(jSONObject, "voltage"));
                chargeStationInfo.setAmperage(m52556K(jSONObject, "amperage"));
                chargeStationInfo.setStepIndex(m52556K(jSONObject, "step_index"));
                arrayList.add(chargeStationInfo);
            }
            return arrayList;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseChargeStationInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: V0 */
    private static List<RouteBusLineItem> m52533V0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m52522c(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: W */
    private static void m52532W(Path path, List<DriveStepV2> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStepV2 driveStepV2 : list) {
            if (driveStepV2 != null && driveStepV2.getPolyline() != null) {
                polyline.addAll(driveStepV2.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    /* renamed from: W0 */
    private static List<RouteBusLineItem> m52531W0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m52520d(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: X */
    public static void m52530X(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                aoiItem.setId(m52484v(optJSONObject, "id"));
                aoiItem.setName(m52484v(optJSONObject, "name"));
                aoiItem.setAdcode(m52484v(optJSONObject, "adcode"));
                aoiItem.setLocation(m52540S(optJSONObject, SocializeConstants.KEY_LOCATION));
                aoiItem.setArea(Float.valueOf(m52549N0(m52484v(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    /* renamed from: X0 */
    private static Doorway m52529X0(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(m52484v(jSONObject, "name"));
        doorway.setLatLonPoint(m52540S(jSONObject, SocializeConstants.KEY_LOCATION));
        return doorway;
    }

    /* renamed from: Y */
    public static DriveRouteResultV2 m52528Y(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                DriveRouteResultV2 driveRouteResultV2 = new DriveRouteResultV2();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return driveRouteResultV2;
                }
                driveRouteResultV2.setStartPos(m52540S(optJSONObject, "origin"));
                driveRouteResultV2.setTargetPos(m52540S(optJSONObject, RtspHeaders.Values.DESTINATION));
                driveRouteResultV2.setTaxiCost(m52549N0(m52484v(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        DrivePathV2 drivePathV2 = new DrivePathV2();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            drivePathV2.setDistance(m52549N0(m52484v(optJSONObject2, "distance")));
                            drivePathV2.setStrategy(m52484v(optJSONObject2, "strategy"));
                            drivePathV2.setRestriction(m52553L0(m52484v(optJSONObject2, "restriction")));
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                            if (optJSONObject3 != null) {
                                Cost cost = new Cost();
                                m52572C(cost, optJSONObject3);
                                drivePathV2.setCost(cost);
                            }
                            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("elec_consume_info");
                            if (optJSONObject4 != null) {
                                drivePathV2.setElecConsumeInfo(m52498o(optJSONObject4));
                            }
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("charge_station_info");
                            if (optJSONArray2 != null) {
                                drivePathV2.setChargeStationInfo(m52534V(optJSONArray2));
                            }
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray3 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                                    DriveStepV2 driveStepV2 = new DriveStepV2();
                                    JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i2);
                                    if (optJSONObject5 != null) {
                                        driveStepV2.setInstruction(m52484v(optJSONObject5, "instruction"));
                                        driveStepV2.setOrientation(m52484v(optJSONObject5, "orientation"));
                                        driveStepV2.setStepDistance(m52553L0(m52484v(optJSONObject5, "step_distance")));
                                        driveStepV2.setRoad(m52484v(optJSONObject5, "road_name"));
                                        driveStepV2.setPolyline(m52525a0(optJSONObject5, "polyline"));
                                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject("cost");
                                        if (optJSONObject6 != null) {
                                            Cost cost2 = new Cost();
                                            m52572C(cost2, optJSONObject6);
                                            driveStepV2.setCostDetail(cost2);
                                        }
                                        JSONObject optJSONObject7 = optJSONObject5.optJSONObject("navi");
                                        if (optJSONObject7 != null) {
                                            driveStepV2.setNavi(m52496p(optJSONObject7));
                                        }
                                        JSONArray optJSONArray4 = optJSONObject5.optJSONArray("cities");
                                        if (optJSONArray4 != null) {
                                            driveStepV2.setRouteSearchCityList(m52513g0(optJSONArray4));
                                        }
                                        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("tmcs");
                                        if (optJSONArray5 != null) {
                                            driveStepV2.setTMCs(m52523b0(optJSONArray5));
                                        }
                                        arrayList2.add(driveStepV2);
                                    }
                                }
                                drivePathV2.setSteps(arrayList2);
                                m52532W(drivePathV2, arrayList2);
                                arrayList.add(drivePathV2);
                            }
                        }
                    }
                    driveRouteResultV2.setPaths(arrayList);
                    return driveRouteResultV2;
                }
                return driveRouteResultV2;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            C2082j4.m52825i(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: Z */
    public static ArrayList<PoiItemV2> m52527Z(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(m52511h0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static WalkStep m52526a(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(m52484v(jSONObject, "instruction"));
        walkStep.setOrientation(m52484v(jSONObject, "orientation"));
        walkStep.setRoad(m52484v(jSONObject, "road"));
        walkStep.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        walkStep.setDuration(m52549N0(m52484v(jSONObject, "duration")));
        walkStep.setPolyline(m52525a0(jSONObject, "polyline"));
        walkStep.setAction(m52484v(jSONObject, CcgConstant.f38549t));
        walkStep.setAssistantAction(m52484v(jSONObject, "assistant_action"));
        return walkStep;
    }

    /* renamed from: a0 */
    private static ArrayList<LatLonPoint> m52525a0(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return m52563G0(jSONObject.optString(str));
        }
        return null;
    }

    /* renamed from: b */
    private static WalkStep m52524b(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(m52484v(jSONObject, "instruction"));
        walkStep.setOrientation(m52484v(jSONObject, "orientation"));
        walkStep.setRoad(m52484v(jSONObject, "road"));
        walkStep.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        walkStep.setDuration(m52549N0(m52484v(jSONObject, "duration")));
        JSONObject optJSONObject = jSONObject.optJSONObject("polyline");
        if (optJSONObject != null) {
            walkStep.setPolyline(m52525a0(optJSONObject, "polyline"));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("navi");
        if (optJSONObject2 != null) {
            walkStep.setAction(m52484v(optJSONObject2, CcgConstant.f38549t));
            walkStep.setAssistantAction(m52484v(optJSONObject2, "assistant_action"));
            walkStep.setRoadType(m52553L0(m52484v(optJSONObject2, "walk_type")));
        }
        return walkStep;
    }

    /* renamed from: b0 */
    private static List<TMC> m52523b0(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                TMC tmc = new TMC();
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    tmc.setDistance(m52553L0(m52484v(optJSONObject, "tmc_distance")));
                    tmc.setStatus(m52484v(optJSONObject, "tmc_status"));
                    tmc.setPolyline(m52525a0(optJSONObject, "tmc_polyline"));
                    arrayList.add(tmc);
                }
            } catch (JSONException e) {
                C2082j4.m52825i(e, "JSONHelper", "parseTMCsV5");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private static RouteBusLineItem m52522c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(m52516f(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(m52516f(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(m52484v(jSONObject, "name"));
        routeBusLineItem.setBusLineId(m52484v(jSONObject, "id"));
        routeBusLineItem.setBusLineType(m52484v(jSONObject, "type"));
        routeBusLineItem.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        routeBusLineItem.setDuration(m52549N0(m52484v(jSONObject, "duration")));
        routeBusLineItem.setPolyline(m52525a0(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(C2082j4.m52820n(m52484v(jSONObject, UContent.f38151p)));
        routeBusLineItem.setLastBusTime(C2082j4.m52820n(m52484v(jSONObject, UContent.f38152q)));
        routeBusLineItem.setPassStationNum(m52553L0(m52484v(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(m52518e(jSONObject));
        return routeBusLineItem;
    }

    /* renamed from: c0 */
    private static void m52521c0(Path path, List<RideStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (RideStep rideStep : list) {
            if (rideStep != null && rideStep.getPolyline() != null) {
                polyline.addAll(rideStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    /* renamed from: d */
    private static RouteBusLineItem m52520d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(m52516f(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(m52516f(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(m52484v(jSONObject, "name"));
        routeBusLineItem.setBusLineId(m52484v(jSONObject, "id"));
        routeBusLineItem.setBusLineType(m52484v(jSONObject, "type"));
        routeBusLineItem.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        JSONObject optJSONObject = jSONObject.optJSONObject("cost");
        if (optJSONObject != null) {
            routeBusLineItem.setDuration(m52549N0(m52484v(optJSONObject, "duration")));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("polyline");
        if (optJSONObject2 != null) {
            routeBusLineItem.setPolyline(m52525a0(optJSONObject2, "polyline"));
        }
        routeBusLineItem.setFirstBusTime(C2082j4.m52820n(m52484v(jSONObject, UContent.f38151p)));
        routeBusLineItem.setLastBusTime(C2082j4.m52820n(m52484v(jSONObject, UContent.f38152q)));
        routeBusLineItem.setPassStationNum(m52553L0(m52484v(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(m52518e(jSONObject));
        return routeBusLineItem;
    }

    /* renamed from: d0 */
    public static PoiItem m52519d0(JSONObject jSONObject) throws JSONException {
        PoiItem poiItem = new PoiItem(m52484v(jSONObject, "id"), m52540S(jSONObject, SocializeConstants.KEY_LOCATION), m52484v(jSONObject, "name"), m52484v(jSONObject, "address"));
        poiItem.setAdCode(m52484v(jSONObject, "adcode"));
        poiItem.setProvinceName(m52484v(jSONObject, "pname"));
        poiItem.setCityName(m52484v(jSONObject, "cityname"));
        poiItem.setAdName(m52484v(jSONObject, "adname"));
        poiItem.setCityCode(m52484v(jSONObject, "citycode"));
        poiItem.setProvinceCode(m52484v(jSONObject, "pcode"));
        poiItem.setDirection(m52484v(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String m52484v = m52484v(jSONObject, "distance");
            if (!m52489s0(m52484v)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(m52484v));
                } catch (NumberFormatException e) {
                    C2082j4.m52825i(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e2) {
                    C2082j4.m52825i(e2, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(m52484v(jSONObject, "tel"));
        poiItem.setTypeDes(m52484v(jSONObject, "type"));
        poiItem.setEnter(m52540S(jSONObject, "entr_location"));
        poiItem.setExit(m52540S(jSONObject, "exit_location"));
        poiItem.setWebsite(m52484v(jSONObject, "website"));
        poiItem.setPostcode(m52484v(jSONObject, "postcode"));
        String m52484v2 = m52484v(jSONObject, "business_area");
        if (m52489s0(m52484v2)) {
            m52484v2 = m52484v(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(m52484v2);
        poiItem.setEmail(m52484v(jSONObject, NotificationCompat.CATEGORY_EMAIL));
        if (m52555K0(m52484v(jSONObject, "indoor_map"))) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(m52484v(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(m52479x0(optJSONObject));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        poiItem.setIndoorDate(m52517e0(jSONObject, "indoor_data"));
        poiItem.setPoiExtension(m52493q0(jSONObject, "biz_ext"));
        poiItem.setTypeCode(m52484v(jSONObject, "typecode"));
        poiItem.setShopID(m52484v(jSONObject, "shopid"));
        m52476z(poiItem, jSONObject);
        return poiItem;
    }

    /* renamed from: e */
    private static List<BusStationItem> m52518e(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m52516f(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: e0 */
    private static IndoorData m52517e0(JSONObject jSONObject, String str) throws JSONException {
        int i;
        String str2;
        JSONObject optJSONObject;
        String str3 = "";
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null && optJSONObject.has("cpid") && optJSONObject.has("floor")) {
            str3 = m52484v(optJSONObject, "cpid");
            i = m52553L0(m52484v(optJSONObject, "floor"));
            str2 = m52484v(optJSONObject, "truefloor");
        } else {
            i = 0;
            str2 = "";
        }
        return new IndoorData(str3, i, str2);
    }

    /* renamed from: f */
    private static BusStationItem m52516f(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(m52484v(jSONObject, "name"));
        busStationItem.setBusStationId(m52484v(jSONObject, "id"));
        busStationItem.setLatLonPoint(m52540S(jSONObject, SocializeConstants.KEY_LOCATION));
        return busStationItem;
    }

    /* renamed from: f0 */
    public static WalkRouteResult m52515f0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                WalkRouteResult walkRouteResult = new WalkRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                walkRouteResult.setStartPos(m52540S(optJSONObject, "origin"));
                walkRouteResult.setTargetPos(m52540S(optJSONObject, RtspHeaders.Values.DESTINATION));
                if (optJSONObject.has("paths")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                    if (optJSONArray == null) {
                        walkRouteResult.setPaths(arrayList);
                        return walkRouteResult;
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        WalkPath walkPath = new WalkPath();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            walkPath.setDistance(m52549N0(m52484v(optJSONObject2, "distance")));
                            walkPath.setDuration(m52541R0(m52484v(optJSONObject2, "duration")));
                            if (optJSONObject2.has("steps")) {
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                                ArrayList arrayList2 = new ArrayList();
                                if (optJSONArray2 != null) {
                                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                        WalkStep walkStep = new WalkStep();
                                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                        if (optJSONObject3 != null) {
                                            walkStep.setInstruction(m52484v(optJSONObject3, "instruction"));
                                            walkStep.setOrientation(m52484v(optJSONObject3, "orientation"));
                                            walkStep.setRoad(m52484v(optJSONObject3, "road"));
                                            walkStep.setDistance(m52549N0(m52484v(optJSONObject3, "distance")));
                                            walkStep.setDuration(m52549N0(m52484v(optJSONObject3, "duration")));
                                            walkStep.setPolyline(m52525a0(optJSONObject3, "polyline"));
                                            walkStep.setAction(m52484v(optJSONObject3, CcgConstant.f38549t));
                                            walkStep.setAssistantAction(m52484v(optJSONObject3, "assistant_action"));
                                            arrayList2.add(walkStep);
                                        }
                                    }
                                    walkPath.setSteps(arrayList2);
                                    m52568E(walkPath, arrayList2);
                                }
                            }
                            arrayList.add(walkPath);
                        }
                    }
                    walkRouteResult.setPaths(arrayList);
                    return walkRouteResult;
                }
                return walkRouteResult;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: g */
    private static RouteRailwayItem m52514g(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("id") && jSONObject.has("name")) {
            RouteRailwayItem routeRailwayItem = new RouteRailwayItem();
            routeRailwayItem.setID(m52484v(jSONObject, "id"));
            routeRailwayItem.setName(m52484v(jSONObject, "name"));
            routeRailwayItem.setTime(m52484v(jSONObject, RtspHeaders.Values.TIME));
            routeRailwayItem.setTrip(m52484v(jSONObject, "trip"));
            routeRailwayItem.setDistance(m52549N0(m52484v(jSONObject, "distance")));
            routeRailwayItem.setType(m52484v(jSONObject, "type"));
            routeRailwayItem.setDeparturestop(m52512h(jSONObject.optJSONObject("departure_stop")));
            routeRailwayItem.setArrivalstop(m52512h(jSONObject.optJSONObject("arrival_stop")));
            routeRailwayItem.setViastops(m52510i(jSONObject));
            routeRailwayItem.setAlters(m52508j(jSONObject));
            routeRailwayItem.setSpaces(m52506k(jSONObject));
            return routeRailwayItem;
        }
        return null;
    }

    /* renamed from: g0 */
    private static List<RouteSearchCity> m52513g0(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(m52484v(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(m52484v(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(m52484v(optJSONObject, "adcode"));
                    m52566F(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            } catch (JSONException e) {
                C2082j4.m52825i(e, "JSONHelper", "parseCrossCity");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    private static RailwayStationItem m52512h(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(m52484v(jSONObject, "id"));
        railwayStationItem.setName(m52484v(jSONObject, "name"));
        railwayStationItem.setLocation(m52540S(jSONObject, SocializeConstants.KEY_LOCATION));
        railwayStationItem.setAdcode(m52484v(jSONObject, "adcode"));
        railwayStationItem.setTime(m52484v(jSONObject, RtspHeaders.Values.TIME));
        railwayStationItem.setisStart(m52535U0(m52484v(jSONObject, CampaignEx.JSON_NATIVE_VIDEO_START)));
        railwayStationItem.setisEnd(m52535U0(m52484v(jSONObject, "end")));
        railwayStationItem.setWait(m52549N0(m52484v(jSONObject, "wait")));
        return railwayStationItem;
    }

    /* renamed from: h0 */
    public static PoiItemV2 m52511h0(JSONObject jSONObject) throws JSONException {
        PoiItemV2 poiItemV2 = new PoiItemV2(m52484v(jSONObject, "id"), m52540S(jSONObject, SocializeConstants.KEY_LOCATION), m52484v(jSONObject, "name"), m52484v(jSONObject, "address"));
        poiItemV2.setTypeDes(m52484v(jSONObject, "type"));
        poiItemV2.setTypeCode(m52484v(jSONObject, "typecode"));
        poiItemV2.setProvinceName(m52484v(jSONObject, "pname"));
        poiItemV2.setCityName(m52484v(jSONObject, "cityname"));
        poiItemV2.setAdName(m52484v(jSONObject, "adname"));
        poiItemV2.setProvinceCode(m52484v(jSONObject, "pcode"));
        poiItemV2.setAdCode(m52484v(jSONObject, "adcode"));
        poiItemV2.setCityCode(m52484v(jSONObject, "citycode"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(m52475z0(optJSONObject));
                    }
                }
            }
            poiItemV2.setSubPois(arrayList);
        }
        poiItemV2.setBusiness(m52505k0(jSONObject, "business"));
        poiItemV2.setIndoorData(m52509i0(jSONObject, "indoor"));
        poiItemV2.setPoiNavi(m52499n0(jSONObject, "navi"));
        m52576A(poiItemV2, jSONObject);
        return poiItemV2;
    }

    /* renamed from: i */
    private static List<RailwayStationItem> m52510i(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m52512h(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: i0 */
    private static IndoorDataV2 m52509i0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        int i;
        JSONObject optJSONObject;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
            i = 0;
        } else {
            r2 = m52553L0(m52484v(optJSONObject, "indoor_map")) == 1;
            str3 = m52484v(optJSONObject, "cpid");
            i = m52553L0(m52484v(optJSONObject, "floor"));
            str2 = m52484v(optJSONObject, "truefloor");
        }
        return new IndoorDataV2(r2, str3, i, str2);
    }

    /* renamed from: j */
    private static List<Railway> m52508j(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("alters")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Railway railway = new Railway();
                railway.setID(m52484v(optJSONObject, "id"));
                railway.setName(m52484v(optJSONObject, "name"));
                arrayList.add(railway);
            }
        }
        return arrayList;
    }

    /* renamed from: j0 */
    public static WalkRouteResultV2 m52507j0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                WalkRouteResultV2 walkRouteResultV2 = new WalkRouteResultV2();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                walkRouteResultV2.setStartPos(m52540S(optJSONObject, "origin"));
                walkRouteResultV2.setTargetPos(m52540S(optJSONObject, RtspHeaders.Values.DESTINATION));
                if (optJSONObject.has("paths")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                    if (optJSONArray == null) {
                        walkRouteResultV2.setPaths(arrayList);
                        return walkRouteResultV2;
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        WalkPath walkPath = new WalkPath();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            walkPath.setDistance(m52549N0(m52484v(optJSONObject2, "distance")));
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                            if (optJSONObject3 != null) {
                                walkPath.setDuration(m52541R0(m52484v(optJSONObject3, "duration")));
                            }
                            if (optJSONObject2.has("steps")) {
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                                ArrayList arrayList2 = new ArrayList();
                                if (optJSONArray2 != null) {
                                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                        WalkStep walkStep = new WalkStep();
                                        JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i2);
                                        if (optJSONObject4 != null) {
                                            walkStep.setInstruction(m52484v(optJSONObject4, "instruction"));
                                            walkStep.setOrientation(m52484v(optJSONObject4, "orientation"));
                                            walkStep.setRoad(m52484v(optJSONObject4, "road_name"));
                                            walkStep.setDistance(m52549N0(m52484v(optJSONObject4, "step_distance")));
                                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("cost");
                                            if (optJSONObject5 != null) {
                                                walkStep.setDuration(m52549N0(m52484v(optJSONObject5, "duration")));
                                            }
                                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("navi");
                                            if (optJSONObject6 != null) {
                                                walkStep.setAction(m52484v(optJSONObject6, CcgConstant.f38549t));
                                                walkStep.setAssistantAction(m52484v(optJSONObject6, "assistant_action"));
                                                walkStep.setRoadType(m52553L0(m52484v(optJSONObject6, "work_type")));
                                            }
                                            walkStep.setPolyline(m52525a0(optJSONObject4, "polyline"));
                                            arrayList2.add(walkStep);
                                        }
                                    }
                                    walkPath.setSteps(arrayList2);
                                    m52568E(walkPath, arrayList2);
                                }
                            }
                            arrayList.add(walkPath);
                        }
                    }
                    walkRouteResultV2.setPaths(arrayList);
                    return walkRouteResultV2;
                }
                return walkRouteResultV2;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: k */
    private static List<RailwaySpace> m52506k(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("spaces")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m52504l(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: k0 */
    private static Business m52505k0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        JSONObject optJSONObject;
        String str11 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
            str10 = str9;
        } else {
            String m52484v = m52484v(optJSONObject, "business_area");
            String m52484v2 = m52484v(optJSONObject, "opentime_today");
            String m52484v3 = m52484v(optJSONObject, "opentime_week");
            String m52484v4 = m52484v(optJSONObject, "tel");
            String m52484v5 = m52484v(optJSONObject, "tag");
            String m52484v6 = m52484v(optJSONObject, CampaignEx.JSON_KEY_STAR);
            String m52484v7 = m52484v(optJSONObject, "cost");
            str2 = m52484v;
            str3 = m52484v2;
            str4 = m52484v3;
            str5 = m52484v4;
            str6 = m52484v5;
            str7 = m52484v6;
            str8 = m52484v7;
            str9 = m52484v(optJSONObject, "parking_type");
            str10 = m52484v(optJSONObject, "alias");
            str11 = m52484v(optJSONObject, "cpid");
        }
        Business business = new Business(str2, str3, str4, str5, str6, str7, str8, str9, str10);
        business.setCPID(str11);
        return business;
    }

    /* renamed from: l */
    private static RailwaySpace m52504l(JSONObject jSONObject) throws JSONException {
        return new RailwaySpace(m52484v(jSONObject, "code"), m52549N0(m52484v(jSONObject, "cost")));
    }

    /* renamed from: l0 */
    public static LocalWeatherLive m52503l0(String str) throws AMapException {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("lives")) {
                LocalWeatherLive localWeatherLive = new LocalWeatherLive();
                JSONArray optJSONArray = jSONObject.optJSONArray("lives");
                if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                    return localWeatherLive;
                }
                localWeatherLive.setAdCode(m52484v(optJSONObject, "adcode"));
                localWeatherLive.setProvince(m52484v(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                localWeatherLive.setCity(m52484v(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                localWeatherLive.setWeather(m52484v(optJSONObject, "weather"));
                localWeatherLive.setTemperature(m52484v(optJSONObject, "temperature"));
                localWeatherLive.setWindDirection(m52484v(optJSONObject, "winddirection"));
                localWeatherLive.setWindPower(m52484v(optJSONObject, "windpower"));
                localWeatherLive.setHumidity(m52484v(optJSONObject, "humidity"));
                localWeatherLive.setReportTime(m52484v(optJSONObject, "reporttime"));
                return localWeatherLive;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: m */
    private static TaxiItem m52502m(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItem taxiItem = new TaxiItem();
        taxiItem.setOrigin(m52540S(jSONObject, "origin"));
        taxiItem.setDestination(m52540S(jSONObject, RtspHeaders.Values.DESTINATION));
        taxiItem.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        taxiItem.setDuration(m52549N0(m52484v(jSONObject, "duration")));
        taxiItem.setSname(m52484v(jSONObject, "sname"));
        taxiItem.setTname(m52484v(jSONObject, "tname"));
        return taxiItem;
    }

    /* renamed from: m0 */
    public static ArrayList<BusStationItem> m52501m0(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(m52573B0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: n */
    private static TaxiItemV2 m52500n(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItemV2 taxiItemV2 = new TaxiItemV2();
        taxiItemV2.setOrigin(m52540S(jSONObject, "startpoint"));
        taxiItemV2.setDestination(m52540S(jSONObject, "endpoint"));
        taxiItemV2.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        taxiItemV2.setDuration(m52549N0(m52484v(jSONObject, "drivetime")));
        JSONObject optJSONObject = jSONObject.optJSONObject("polyline");
        if (optJSONObject != null) {
            taxiItemV2.setPolyline(m52525a0(optJSONObject, "polyline"));
        }
        taxiItemV2.setSname(m52484v(jSONObject, "startname"));
        taxiItemV2.setTname(m52484v(jSONObject, "endname"));
        return taxiItemV2;
    }

    /* renamed from: n0 */
    private static PoiNavi m52499n0(JSONObject jSONObject, String str) throws JSONException {
        LatLonPoint latLonPoint;
        String str2;
        JSONObject optJSONObject;
        LatLonPoint latLonPoint2 = null;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            latLonPoint = null;
            str2 = "";
        } else {
            str3 = m52484v(optJSONObject, "navi_poiid");
            latLonPoint2 = m52540S(optJSONObject, "entr_location");
            latLonPoint = m52540S(optJSONObject, "exit_location");
            str2 = m52484v(optJSONObject, "gridcode");
        }
        return new PoiNavi(str3, latLonPoint2, latLonPoint, str2);
    }

    /* renamed from: o */
    private static ElecConsumeInfo m52498o(JSONObject jSONObject) throws AMapException {
        try {
            ElecConsumeInfo elecConsumeInfo = new ElecConsumeInfo();
            elecConsumeInfo.setRunOutPoint(m52540S(jSONObject, "runout_point"));
            elecConsumeInfo.setRunOutStepIndex(m52556K(jSONObject, "runout_step_index"));
            elecConsumeInfo.setConsumeEnergy(m52556K(jSONObject, "consume_energy"));
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("left_energy");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(Integer.valueOf(optJSONArray.optInt(i)));
                }
            }
            elecConsumeInfo.setLeftEnergy(arrayList);
            return elecConsumeInfo;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseElecConsumeInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: o0 */
    public static LocalWeatherForecast m52497o0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("forecasts")) {
                LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
                JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
                if (jSONArray != null && jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherForecast;
                    }
                    localWeatherForecast.setCity(m52484v(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    localWeatherForecast.setAdCode(m52484v(optJSONObject, "adcode"));
                    localWeatherForecast.setProvince(m52484v(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    localWeatherForecast.setReportTime(m52484v(optJSONObject, "reporttime"));
                    if (!optJSONObject.has("casts")) {
                        return localWeatherForecast;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            if (optJSONObject2 != null) {
                                localDayWeatherForecast.setDate(m52484v(optJSONObject2, "date"));
                                localDayWeatherForecast.setWeek(m52484v(optJSONObject2, "week"));
                                localDayWeatherForecast.setDayWeather(m52484v(optJSONObject2, "dayweather"));
                                localDayWeatherForecast.setNightWeather(m52484v(optJSONObject2, "nightweather"));
                                localDayWeatherForecast.setDayTemp(m52484v(optJSONObject2, "daytemp"));
                                localDayWeatherForecast.setNightTemp(m52484v(optJSONObject2, "nighttemp"));
                                localDayWeatherForecast.setDayWindDirection(m52484v(optJSONObject2, "daywind"));
                                localDayWeatherForecast.setNightWindDirection(m52484v(optJSONObject2, "nightwind"));
                                localDayWeatherForecast.setDayWindPower(m52484v(optJSONObject2, "daypower"));
                                localDayWeatherForecast.setNightWindPower(m52484v(optJSONObject2, "nightpower"));
                                arrayList.add(localDayWeatherForecast);
                            }
                        }
                        localWeatherForecast.setWeatherForecast(arrayList);
                        return localWeatherForecast;
                    }
                    localWeatherForecast.setWeatherForecast(arrayList);
                }
                return localWeatherForecast;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: p */
    private static Navi m52496p(JSONObject jSONObject) throws AMapException {
        try {
            Navi navi = new Navi();
            navi.setAction(m52484v(jSONObject, CcgConstant.f38549t));
            navi.setAssistantAction(m52484v(jSONObject, "assistant_action"));
            return navi;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseNavi");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: p0 */
    public static ArrayList<BusLineItem> m52495p0(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m52561H0(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: q */
    private static List<Photo> m52494q(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("photos");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                Photo photo = new Photo();
                photo.setTitle(m52484v(optJSONObject, "title"));
                photo.setUrl(m52484v(optJSONObject, "url"));
                arrayList.add(photo);
            }
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: q0 */
    private static PoiItemExtension m52493q0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        JSONObject optJSONObject;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
        } else {
            str3 = m52484v(optJSONObject, "open_time");
            str2 = m52484v(optJSONObject, CampaignEx.JSON_KEY_STAR);
        }
        return new PoiItemExtension(str3, str2);
    }

    /* renamed from: r */
    private static RoutePOIItem m52492r(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(m52484v(jSONObject, "id"));
        routePOIItem.setTitle(m52484v(jSONObject, "name"));
        routePOIItem.setPoint(m52540S(jSONObject, SocializeConstants.KEY_LOCATION));
        routePOIItem.setDistance(m52549N0(m52484v(jSONObject, "distance")));
        routePOIItem.setDuration(m52549N0(m52484v(jSONObject, "duration")));
        routePOIItem.setCPID(m52484v(jSONObject, "cpid"));
        return routePOIItem;
    }

    /* renamed from: r0 */
    public static ArrayList<GeocodeAddress> m52491r0(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    GeocodeAddress geocodeAddress = new GeocodeAddress();
                    geocodeAddress.setFormatAddress(m52484v(optJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(m52484v(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    geocodeAddress.setCity(m52484v(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    geocodeAddress.setDistrict(m52484v(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                    geocodeAddress.setTownship(m52484v(optJSONObject, "township"));
                    geocodeAddress.setNeighborhood(m52484v(optJSONObject.optJSONObject("neighborhood"), "name"));
                    geocodeAddress.setBuilding(m52484v(optJSONObject.optJSONObject("building"), "name"));
                    geocodeAddress.setAdcode(m52484v(optJSONObject, "adcode"));
                    geocodeAddress.setLatLonPoint(m52540S(optJSONObject, SocializeConstants.KEY_LOCATION));
                    geocodeAddress.setLevel(m52484v(optJSONObject, "level"));
                    geocodeAddress.setCountry(m52484v(optJSONObject, "country"));
                    geocodeAddress.setPostcode(m52484v(optJSONObject, "postcode"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: s */
    private static RidePath m52490s(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(m52549N0(m52484v(jSONObject, "distance")));
            ridePath.setDuration(m52541R0(m52484v(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(m52484v(optJSONObject, "instruction"));
                        rideStep.setOrientation(m52484v(optJSONObject, "orientation"));
                        rideStep.setRoad(m52484v(optJSONObject, "road"));
                        rideStep.setDistance(m52549N0(m52484v(optJSONObject, "distance")));
                        rideStep.setDuration(m52549N0(m52484v(optJSONObject, "duration")));
                        rideStep.setPolyline(m52525a0(optJSONObject, "polyline"));
                        rideStep.setAction(m52484v(optJSONObject, CcgConstant.f38549t));
                        rideStep.setAssistantAction(m52484v(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                m52521c0(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: s0 */
    public static boolean m52489s0(String str) {
        return str == null || str.equals("");
    }

    /* renamed from: t */
    private static RidePath m52488t(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(m52549N0(m52484v(jSONObject, "distance")));
            ridePath.setDuration(m52541R0(m52484v(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(m52484v(optJSONObject, "instruction"));
                        rideStep.setOrientation(m52484v(optJSONObject, "orientation"));
                        rideStep.setRoad(m52484v(optJSONObject, "road_name"));
                        rideStep.setDistance(m52549N0(m52484v(optJSONObject, "step_distance")));
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                        if (optJSONObject2 != null) {
                            rideStep.setDuration(m52549N0(m52484v(optJSONObject2, "duration")));
                        }
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("navi");
                        if (optJSONObject3 != null) {
                            rideStep.setAction(m52484v(optJSONObject3, CcgConstant.f38549t));
                            rideStep.setAssistantAction(m52484v(optJSONObject3, "assistant_action"));
                            rideStep.setRoadType(m52553L0(m52484v(optJSONObject3, "work_type")));
                        }
                        rideStep.setPolyline(m52525a0(optJSONObject, "polyline"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                m52521c0(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseRidePathV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: t0 */
    public static RideRouteResult m52487t0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                RideRouteResult rideRouteResult = new RideRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                rideRouteResult.setStartPos(m52540S(optJSONObject, "origin"));
                rideRouteResult.setTargetPos(m52540S(optJSONObject, RtspHeaders.Values.DESTINATION));
                ArrayList arrayList = new ArrayList();
                Object opt = optJSONObject.opt("paths");
                if (opt == null) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                if (opt instanceof JSONArray) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        RidePath m52490s = m52490s(optJSONArray.optJSONObject(i));
                        if (m52490s != null) {
                            arrayList.add(m52490s);
                        }
                    }
                } else if (opt instanceof JSONObject) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                    if (!optJSONObject2.has("path")) {
                        rideRouteResult.setPaths(arrayList);
                        return rideRouteResult;
                    }
                    RidePath m52490s2 = m52490s(optJSONObject2.optJSONObject("path"));
                    if (m52490s2 != null) {
                        arrayList.add(m52490s2);
                    }
                }
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: u */
    public static BusRouteResult m52486u(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                BusRouteResult busRouteResult = new BusRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return busRouteResult;
                }
                busRouteResult.setStartPos(m52540S(optJSONObject, "origin"));
                busRouteResult.setTargetPos(m52540S(optJSONObject, RtspHeaders.Values.DESTINATION));
                busRouteResult.setTaxiCost(m52549N0(m52484v(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                    busRouteResult.setPaths(m52478y(optJSONArray));
                    return busRouteResult;
                }
                return busRouteResult;
            }
            return null;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: u0 */
    public static ArrayList<Tip> m52485u0(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                tip.setName(m52484v(optJSONObject, "name"));
                tip.setDistrict(m52484v(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                tip.setAdcode(m52484v(optJSONObject, "adcode"));
                tip.setID(m52484v(optJSONObject, "id"));
                tip.setAddress(m52484v(optJSONObject, "address"));
                tip.setTypeCode(m52484v(optJSONObject, "typecode"));
                String m52484v = m52484v(optJSONObject, SocializeConstants.KEY_LOCATION);
                if (!TextUtils.isEmpty(m52484v)) {
                    String[] split = m52484v.split(",");
                    if (split.length == 2) {
                        tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    /* renamed from: v */
    public static String m52484v(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || jSONObject.optString(str).equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) ? "" : jSONObject.optString(str).trim();
    }

    /* renamed from: v0 */
    public static RideRouteResultV2 m52483v0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                RideRouteResultV2 rideRouteResultV2 = new RideRouteResultV2();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                rideRouteResultV2.setStartPos(m52540S(optJSONObject, "origin"));
                rideRouteResultV2.setTargetPos(m52540S(optJSONObject, RtspHeaders.Values.DESTINATION));
                ArrayList arrayList = new ArrayList();
                Object opt = optJSONObject.opt("paths");
                if (opt == null) {
                    rideRouteResultV2.setPaths(arrayList);
                    return rideRouteResultV2;
                }
                if (opt instanceof JSONArray) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        RidePath m52488t = m52488t(optJSONArray.optJSONObject(i));
                        if (m52488t != null) {
                            arrayList.add(m52488t);
                        }
                    }
                }
                rideRouteResultV2.setPaths(arrayList);
                return rideRouteResultV2;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseRideRouteV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: w */
    public static ArrayList<SuggestionCity> m52482w(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (jSONObject.has("cities") && (optJSONArray = jSONObject.optJSONArray("cities")) != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new SuggestionCity(m52484v(optJSONObject, "name"), m52484v(optJSONObject, "citycode"), m52484v(optJSONObject, "adcode"), m52553L0(m52484v(optJSONObject, "num"))));
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: w0 */
    public static ArrayList<RoutePOIItem> m52481w0(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(m52492r(optJSONObject));
                }
            }
        } else if (opt instanceof JSONObject) {
            arrayList.add(m52492r(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> m52480x(org.json.JSONObject r16, boolean r17) throws org.json.JSONException {
        /*
            java.lang.String r0 = "datas"
            r1 = r16
            org.json.JSONArray r0 = r1.optJSONArray(r0)
            if (r0 == 0) goto L86
            int r1 = r0.length()
            if (r1 != 0) goto L12
            goto L86
        L12:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.length()
            r3 = 0
            r4 = 0
        L1d:
            if (r4 >= r2) goto L85
            org.json.JSONObject r5 = r0.optJSONObject(r4)
            java.lang.String r6 = "userid"
            java.lang.String r6 = m52484v(r5, r6)
            java.lang.String r7 = "location"
            java.lang.String r7 = m52484v(r5, r7)
            r8 = 0
            if (r7 == 0) goto L4e
            java.lang.String r10 = ","
            java.lang.String[] r7 = r7.split(r10)
            int r10 = r7.length
            r11 = 2
            if (r10 != r11) goto L4e
            r8 = r7[r3]
            double r8 = m52545P0(r8)
            r10 = 1
            r7 = r7[r10]
            double r10 = m52545P0(r7)
            r14 = r8
            r8 = r10
            r10 = r14
            goto L4f
        L4e:
            r10 = r8
        L4f:
            java.lang.String r7 = "distance"
            java.lang.String r7 = m52484v(r5, r7)
            java.lang.String r12 = "updatetime"
            java.lang.String r5 = m52484v(r5, r12)
            long r12 = m52541R0(r5)
            int r5 = m52553L0(r7)
            com.amap.api.services.core.LatLonPoint r7 = new com.amap.api.services.core.LatLonPoint
            r7.<init>(r8, r10)
            com.amap.api.services.nearby.NearbyInfo r8 = new com.amap.api.services.nearby.NearbyInfo
            r8.<init>()
            r8.setUserID(r6)
            r8.setTimeStamp(r12)
            r8.setPoint(r7)
            if (r17 == 0) goto L7c
            r8.setDrivingDistance(r5)
            goto L7f
        L7c:
            r8.setDistance(r5)
        L7f:
            r1.add(r8)
            int r4 = r4 + 1
            goto L1d
        L85:
            return r1
        L86:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.JSONHelper.m52480x(org.json.JSONObject, boolean):java.util.ArrayList");
    }

    /* renamed from: x0 */
    private static SubPoiItem m52479x0(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(m52484v(jSONObject, "id"), m52540S(jSONObject, SocializeConstants.KEY_LOCATION), m52484v(jSONObject, "name"), m52484v(jSONObject, "address"));
        subPoiItem.setSubName(m52484v(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(m52484v(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String m52484v = m52484v(jSONObject, "distance");
            if (!m52489s0(m52484v)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(m52484v));
                } catch (NumberFormatException e) {
                    C2082j4.m52825i(e, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e2) {
                    C2082j4.m52825i(e2, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    /* renamed from: y */
    private static List<BusPath> m52478y(JSONArray jSONArray) throws JSONException {
        BusStep m52547O0;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                busPath.setCost(m52549N0(m52484v(optJSONObject, "cost")));
                busPath.setDuration(m52541R0(m52484v(optJSONObject, "duration")));
                busPath.setNightBus(m52535U0(m52484v(optJSONObject, "nightflag")));
                busPath.setWalkDistance(m52549N0(m52484v(optJSONObject, "walking_distance")));
                busPath.setDistance(m52549N0(m52484v(optJSONObject, "distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null && (m52547O0 = m52547O0(optJSONObject2)) != null) {
                            arrayList2.add(m52547O0);
                            if (m52547O0.getWalk() != null) {
                                f2 += m52547O0.getWalk().getDistance();
                            }
                            if (m52547O0.getBusLines() != null && m52547O0.getBusLines().size() > 0) {
                                f += m52547O0.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f);
                    busPath.setWalkDistance(f2);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: y0 */
    public static DistanceResult m52477y0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("results")) {
                DistanceResult distanceResult = new DistanceResult();
                JSONArray optJSONArray = jSONObject.optJSONArray("results");
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    DistanceItem distanceItem = new DistanceItem();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    distanceItem.setOriginId(m52553L0(m52484v(jSONObject2, "origin_id")));
                    distanceItem.setDestId(m52553L0(m52484v(jSONObject2, "dest_id")));
                    distanceItem.setDistance(m52549N0(m52484v(jSONObject2, "distance")));
                    distanceItem.setDuration(m52549N0(m52484v(jSONObject2, "duration")));
                    String m52484v = m52484v(jSONObject2, "info");
                    if (!TextUtils.isEmpty(m52484v)) {
                        distanceItem.setErrorInfo(m52484v);
                        distanceItem.setErrorCode(m52553L0(m52484v(jSONObject2, "code")));
                    }
                    arrayList.add(distanceItem);
                }
                distanceResult.setDistanceResults(arrayList);
                return distanceResult;
            }
            return null;
        } catch (JSONException e) {
            C2082j4.m52825i(e, "JSONHelper", "parseRouteDistance");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: z */
    private static void m52476z(PoiItem poiItem, JSONObject jSONObject) throws JSONException {
        List<Photo> m52494q = m52494q(jSONObject.optJSONObject("deep_info"));
        if (m52494q.size() == 0) {
            m52494q = m52494q(jSONObject);
        }
        poiItem.setPhotos(m52494q);
    }

    /* renamed from: z0 */
    private static SubPoiItemV2 m52475z0(JSONObject jSONObject) throws JSONException {
        SubPoiItemV2 subPoiItemV2 = new SubPoiItemV2(m52484v(jSONObject, "id"), m52540S(jSONObject, SocializeConstants.KEY_LOCATION), m52484v(jSONObject, "name"), m52484v(jSONObject, "address"));
        subPoiItemV2.setSubTypeDes(m52484v(jSONObject, "subtype"));
        subPoiItemV2.setTypeCode(m52484v(jSONObject, "typecode"));
        return subPoiItemV2;
    }
}
