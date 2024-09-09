package com.amap.api.col.s;

import android.text.TextUtils;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
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
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: JSONHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r4 {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f10188a = {"010", "021", "022", "023", "1852", "1853"};

    private static void A(PoiItemV2 poiItemV2, JSONObject jSONObject) throws JSONException {
        poiItemV2.setPhotos(q(jSONObject));
    }

    public static TruckRouteRestult A0(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
                JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
                truckRouteRestult.setStartPos(S(optJSONObject, LiveConfigKey.ORIGIN));
                truckRouteRestult.setTargetPos(S(optJSONObject, "destination"));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        TruckPath truckPath = new TruckPath();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                        truckPath.setDistance(N0(v(jSONObject2, "distance")));
                        truckPath.setDuration(R0(v(jSONObject2, "duration")));
                        truckPath.setStrategy(v(jSONObject2, "strategy"));
                        truckPath.setTolls(N0(v(jSONObject2, "tolls")));
                        truckPath.setTollDistance(N0(v(jSONObject2, "toll_distance")));
                        truckPath.setTotalTrafficlights(L0(v(jSONObject2, "traffic_lights")));
                        truckPath.setRestriction(L0(v(jSONObject2, "restriction")));
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                        if (optJSONArray2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                TruckStep truckStep = new TruckStep();
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i5);
                                if (optJSONObject2 != null) {
                                    truckStep.setInstruction(v(optJSONObject2, "instruction"));
                                    truckStep.setOrientation(v(optJSONObject2, "orientation"));
                                    truckStep.setRoad(v(optJSONObject2, "road"));
                                    truckStep.setDistance(N0(v(optJSONObject2, "distance")));
                                    truckStep.setTolls(N0(v(optJSONObject2, "tolls")));
                                    truckStep.setTollDistance(N0(v(optJSONObject2, "toll_distance")));
                                    truckStep.setTollRoad(v(optJSONObject2, "toll_road"));
                                    truckStep.setDuration(N0(v(optJSONObject2, "duration")));
                                    truckStep.setPolyline(a0(optJSONObject2, "polyline"));
                                    truckStep.setAction(v(optJSONObject2, "action"));
                                    truckStep.setAssistantAction(v(optJSONObject2, "assistant_action"));
                                    G(truckStep, optJSONObject2);
                                    Q(truckStep, optJSONObject2);
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
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseTruckRoute");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static void B(RegeocodeAddress regeocodeAddress) {
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && E0(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    private static BusStationItem B0(JSONObject jSONObject) throws JSONException {
        BusStationItem D0 = D0(jSONObject);
        D0.setAdCode(v(jSONObject, "adcode"));
        D0.setCityCode(v(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            D0.setBusLineItems(arrayList);
            return D0;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(F0(optJSONObject));
            }
        }
        D0.setBusLineItems(arrayList);
        return D0;
    }

    private static void C(Cost cost, JSONObject jSONObject) throws AMapException {
        try {
            cost.setTolls(N0(v(jSONObject, "tolls")));
            cost.setTollDistance(N0(v(jSONObject, "toll_distance")));
            cost.setTollRoad(v(jSONObject, "toll_road"));
            cost.setDuration(N0(v(jSONObject, "duration")));
            cost.setTrafficLights(L0(v(jSONObject, "traffic_lights")));
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseCostDetail");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01a4 A[Catch: all -> 0x021b, JSONException -> 0x021d, TryCatch #3 {JSONException -> 0x021d, all -> 0x021b, blocks: (B:37:0x00cf, B:39:0x00e2, B:40:0x00eb, B:42:0x00fa, B:43:0x0102, B:46:0x010f, B:49:0x0116, B:50:0x011c, B:52:0x0122, B:54:0x012d, B:57:0x0134, B:59:0x0147, B:60:0x014d, B:62:0x0153, B:64:0x015e, B:71:0x0199, B:73:0x01a4, B:74:0x01ac, B:76:0x01b2, B:78:0x01bf, B:80:0x01e2, B:81:0x01e9, B:83:0x01f6, B:84:0x01ff, B:86:0x020e, B:87:0x0217), top: B:104:0x00cf }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.amap.api.services.route.DriveRoutePlanResult C0(java.lang.String r20) throws com.amap.api.services.core.AMapException {
        /*
            Method dump skipped, instructions count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.r4.C0(java.lang.String):com.amap.api.services.route.DriveRoutePlanResult");
    }

    private static void D(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    tmc.setDistance(L0(v(optJSONObject, "distance")));
                    tmc.setStatus(v(optJSONObject, "status"));
                    tmc.setPolyline(a0(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            driveStep.setTMCs(arrayList);
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseTMCs");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static BusStationItem D0(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(v(jSONObject, "id"));
        busStationItem.setLatLonPoint(S(jSONObject, "location"));
        busStationItem.setBusStationName(v(jSONObject, "name"));
        return busStationItem;
    }

    private static void E(Path path, List<WalkStep> list) {
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

    private static boolean E0(String str) {
        if (str != null && str.length() > 0) {
            for (String str2 : f10188a) {
                if (str.trim().equals(str2.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void F(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        district.setDistrictName(v(optJSONObject, "name"));
                        district.setDistrictAdcode(v(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e4) {
                j4.i(e4, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
            }
        }
    }

    private static BusLineItem F0(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(v(jSONObject, "id"));
        busLineItem.setBusLineType(v(jSONObject, "type"));
        busLineItem.setBusLineName(v(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(a0(jSONObject, "polyline"));
        busLineItem.setCityCode(v(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(v(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(v(jSONObject, "end_stop"));
        return busLineItem;
    }

    private static void G(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(v(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(v(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(v(optJSONObject, "adcode"));
                    F(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            truckStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseCrossCity");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static ArrayList<LatLonPoint> G0(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : str.split(";")) {
            arrayList.add(I0(str2));
        }
        return arrayList;
    }

    public static void H(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                crossroad.setId(v(optJSONObject, "id"));
                crossroad.setDirection(v(optJSONObject, "direction"));
                crossroad.setDistance(N0(v(optJSONObject, "distance")));
                crossroad.setCenterPoint(S(optJSONObject, "location"));
                crossroad.setFirstRoadId(v(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(v(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(v(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(v(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    private static BusLineItem H0(JSONObject jSONObject) throws JSONException {
        BusLineItem F0 = F0(jSONObject);
        F0.setFirstBusTime(j4.n(v(jSONObject, "start_time")));
        F0.setLastBusTime(j4.n(v(jSONObject, "end_time")));
        F0.setBusCompany(v(jSONObject, "company"));
        F0.setDistance(N0(v(jSONObject, "distance")));
        F0.setBasicPrice(N0(v(jSONObject, "basic_price")));
        F0.setTotalPrice(N0(v(jSONObject, "total_price")));
        F0.setBounds(a0(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            F0.setBusStations(arrayList);
            return F0;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(D0(optJSONObject));
            }
        }
        F0.setBusStations(arrayList);
        return F0;
    }

    public static void I(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(J0(optJSONObject));
            }
        }
        if (districtItem != null) {
            districtItem.setSubDistrict(arrayList);
        }
    }

    private static LatLonPoint I0(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    public static void J(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setCountry(v(jSONObject, "country"));
        regeocodeAddress.setCountryCode(v(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(v(jSONObject, "province"));
        regeocodeAddress.setCity(v(jSONObject, "city"));
        regeocodeAddress.setCityCode(v(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(v(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(v(jSONObject, "district"));
        regeocodeAddress.setTownship(v(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(v(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(v(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(v(optJSONObject, "street"));
        streetNumber.setNumber(v(optJSONObject, "number"));
        streetNumber.setLatLonPoint(S(optJSONObject, "location"));
        streetNumber.setDirection(v(optJSONObject, "direction"));
        streetNumber.setDistance(N0(v(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(M0(jSONObject));
        regeocodeAddress.setTowncode(v(jSONObject, "towncode"));
        B(regeocodeAddress);
    }

    private static DistrictItem J0(JSONObject jSONObject) throws JSONException {
        String optString;
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(v(jSONObject, "citycode"));
        districtItem.setAdcode(v(jSONObject, "adcode"));
        districtItem.setName(v(jSONObject, "name"));
        districtItem.setLevel(v(jSONObject, "level"));
        districtItem.setCenter(S(jSONObject, AutoScrollViewPager.f4767g));
        if (jSONObject.has("polyline") && (optString = jSONObject.optString("polyline")) != null && optString.length() > 0) {
            districtItem.setDistrictBoundary(optString.split("\\|"));
        }
        I(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    private static int K(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optInt(str);
        }
        return -1;
    }

    private static boolean K0(String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    public static BusRouteResultV2 L(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                BusRouteResultV2 busRouteResultV2 = new BusRouteResultV2();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return busRouteResultV2;
                }
                busRouteResultV2.setStartPos(S(optJSONObject, LiveConfigKey.ORIGIN));
                busRouteResultV2.setTargetPos(S(optJSONObject, "destination"));
                busRouteResultV2.setDistance(N0(v(optJSONObject, "distance")));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                if (optJSONObject2 != null) {
                    busRouteResultV2.setTaxiCost(N0(v(optJSONObject2, "taxi_fee")));
                }
                if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                    busRouteResultV2.setPaths(N(optJSONArray));
                    return busRouteResultV2;
                }
                return busRouteResultV2;
            }
            return null;
        } catch (JSONException unused) {
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static int L0(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e4) {
            j4.i(e4, "JSONHelper", "str2int");
            return 0;
        }
    }

    public static ArrayList<String> M(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            arrayList.add(optJSONArray.optString(i4));
        }
        return arrayList;
    }

    private static List<BusinessArea> M0(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    businessArea.setCenterPoint(S(optJSONObject, "location"));
                    businessArea.setName(v(optJSONObject, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        return arrayList;
    }

    private static List<BusPathV2> N(JSONArray jSONArray) throws JSONException {
        BusStepV2 Q0;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            BusPathV2 busPathV2 = new BusPathV2();
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                if (optJSONObject2 != null) {
                    busPathV2.setDuration(R0(v(optJSONObject2, "duration")));
                    busPathV2.setCost(N0(v(optJSONObject2, "transit_fee")));
                }
                busPathV2.setDistance(N0(v(optJSONObject, "distance")));
                busPathV2.setNightBus(U0(v(optJSONObject, "nightflag")));
                busPathV2.setWalkDistance(N0(v(optJSONObject, "walking_distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f4 = 0.0f;
                    float f5 = 0.0f;
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i5);
                        if (optJSONObject3 != null && (Q0 = Q0(optJSONObject3)) != null) {
                            arrayList2.add(Q0);
                            if (Q0.getWalk() != null) {
                                f5 += Q0.getWalk().getDistance();
                            }
                            if (Q0.getBusLines() != null && Q0.getBusLines().size() > 0) {
                                f4 += Q0.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPathV2.setSteps(arrayList2);
                    busPathV2.setBusDistance(f4);
                    busPathV2.setWalkDistance(f5);
                    arrayList.add(busPathV2);
                }
            }
        }
        return arrayList;
    }

    private static float N0(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e4) {
            j4.i(e4, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    private static void O(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(v(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(v(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(v(optJSONObject, "adcode"));
                    F(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            driveStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseCrossCity");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static BusStep O0(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(S0(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStep.setBusLines(V0(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStep.setEntrance(X0(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStep.setExit(X0(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStep.setRailway(g(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStep.setTaxi(m(optJSONObject6));
        }
        if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
            return null;
        }
        return busStep;
    }

    private static void P(Path path, List<DriveStep> list) {
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

    private static double P0(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e4) {
            j4.i(e4, "JSONHelper", "str2float");
            return 0.0d;
        }
    }

    private static void Q(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    tmc.setDistance(L0(v(optJSONObject, "distance")));
                    tmc.setStatus(v(optJSONObject, "status"));
                    tmc.setPolyline(a0(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            truckStep.setTMCs(arrayList);
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseTMCs");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static BusStepV2 Q0(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStepV2 busStepV2 = new BusStepV2();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStepV2.setWalk(T0(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStepV2.setBusLines(W0(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStepV2.setEntrance(X0(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStepV2.setExit(X0(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStepV2.setRailway(g(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStepV2.setTaxi(n(optJSONObject6));
        }
        if ((busStepV2.getWalk() == null || busStepV2.getWalk().getSteps().size() == 0) && busStepV2.getBusLines().size() == 0 && busStepV2.getRailway() == null && busStepV2.getTaxi() == null) {
            return null;
        }
        return busStepV2;
    }

    public static void R(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                regeocodeRoad.setId(v(optJSONObject, "id"));
                regeocodeRoad.setName(v(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(S(optJSONObject, "location"));
                regeocodeRoad.setDirection(v(optJSONObject, "direction"));
                regeocodeRoad.setDistance(N0(v(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    private static long R0(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e4) {
            j4.i(e4, "JSONHelper", "str2long");
            return 0L;
        }
    }

    private static LatLonPoint S(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return I0(jSONObject.optString(str));
        }
        return null;
    }

    private static RouteBusWalkItem S0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(S(jSONObject, LiveConfigKey.ORIGIN));
        routeBusWalkItem.setDestination(S(jSONObject, "destination"));
        routeBusWalkItem.setDistance(N0(v(jSONObject, "distance")));
        routeBusWalkItem.setDuration(R0(v(jSONObject, "duration")));
        if (jSONObject.has("steps") && (optJSONArray = jSONObject.optJSONArray("steps")) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    arrayList.add(a(optJSONObject));
                }
            }
            routeBusWalkItem.setSteps(arrayList);
            E(routeBusWalkItem, arrayList);
            return routeBusWalkItem;
        }
        return routeBusWalkItem;
    }

    public static DriveRouteResult T(String str) throws AMapException {
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
                driveRouteResult.setStartPos(S(optJSONObject, LiveConfigKey.ORIGIN));
                driveRouteResult.setTargetPos(S(optJSONObject, "destination"));
                driveRouteResult.setTaxiCost(N0(v(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int i4 = 0;
                    while (i4 < optJSONArray.length()) {
                        DrivePath drivePath = new DrivePath();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                        if (optJSONObject2 != null) {
                            drivePath.setDistance(N0(v(optJSONObject2, "distance")));
                            drivePath.setDuration(R0(v(optJSONObject2, "duration")));
                            drivePath.setStrategy(v(optJSONObject2, "strategy"));
                            drivePath.setTolls(N0(v(optJSONObject2, "tolls")));
                            drivePath.setTollDistance(N0(v(optJSONObject2, "toll_distance")));
                            drivePath.setTotalTrafficlights(L0(v(optJSONObject2, "traffic_lights")));
                            drivePath.setRestriction(L0(v(optJSONObject2, "restriction")));
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray2 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                int i5 = 0;
                                while (i5 < optJSONArray2.length()) {
                                    DriveStep driveStep = new DriveStep();
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i5);
                                    if (optJSONObject3 != null) {
                                        jSONArray2 = optJSONArray;
                                        driveStep.setInstruction(v(optJSONObject3, "instruction"));
                                        driveStep.setOrientation(v(optJSONObject3, "orientation"));
                                        driveStep.setRoad(v(optJSONObject3, "road"));
                                        driveStep.setDistance(N0(v(optJSONObject3, "distance")));
                                        driveStep.setTolls(N0(v(optJSONObject3, "tolls")));
                                        driveStep.setTollDistance(N0(v(optJSONObject3, "toll_distance")));
                                        driveStep.setTollRoad(v(optJSONObject3, "toll_road"));
                                        driveStep.setDuration(N0(v(optJSONObject3, "duration")));
                                        driveStep.setPolyline(a0(optJSONObject3, "polyline"));
                                        driveStep.setAction(v(optJSONObject3, "action"));
                                        driveStep.setAssistantAction(v(optJSONObject3, "assistant_action"));
                                        O(driveStep, optJSONObject3);
                                        D(driveStep, optJSONObject3);
                                        arrayList2.add(driveStep);
                                    } else {
                                        jSONArray2 = optJSONArray;
                                    }
                                    i5++;
                                    optJSONArray = jSONArray2;
                                }
                                jSONArray = optJSONArray;
                                drivePath.setSteps(arrayList2);
                                P(drivePath, arrayList2);
                                arrayList.add(drivePath);
                                i4++;
                                optJSONArray = jSONArray;
                            }
                        }
                        jSONArray = optJSONArray;
                        i4++;
                        optJSONArray = jSONArray;
                    }
                    driveRouteResult.setPaths(arrayList);
                    return driveRouteResult;
                }
                return driveRouteResult;
            }
            return null;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseDriveRoute");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        } catch (Throwable th) {
            j4.i(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static RouteBusWalkItem T0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(S(jSONObject, LiveConfigKey.ORIGIN));
        routeBusWalkItem.setDestination(S(jSONObject, "destination"));
        routeBusWalkItem.setDistance(N0(v(jSONObject, "distance")));
        JSONObject optJSONObject = jSONObject.optJSONObject("cost");
        if (optJSONObject != null) {
            routeBusWalkItem.setDuration(R0(v(optJSONObject, "duration")));
        }
        if (jSONObject.has("steps") && (optJSONArray = jSONObject.optJSONArray("steps")) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                if (optJSONObject2 != null) {
                    arrayList.add(b(optJSONObject2));
                }
            }
            routeBusWalkItem.setSteps(arrayList);
            E(routeBusWalkItem, arrayList);
            return routeBusWalkItem;
        }
        return routeBusWalkItem;
    }

    public static ArrayList<PoiItem> U(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("pois")) != null && optJSONArray.length() != 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    arrayList.add(d0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static boolean U0(String str) {
        return (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) ? false : true;
    }

    private static List<ChargeStationInfo> V(JSONArray jSONArray) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                ChargeStationInfo chargeStationInfo = new ChargeStationInfo();
                chargeStationInfo.setName(v(jSONObject, "name"));
                chargeStationInfo.setPoiId(v(jSONObject, "poiid"));
                chargeStationInfo.setBrandName(v(jSONObject, "brand_name"));
                chargeStationInfo.setShowPoint(S(jSONObject, "show_point"));
                chargeStationInfo.setProjectivePoint(S(jSONObject, "projective_point"));
                chargeStationInfo.setMaxPower(K(jSONObject, "max_power"));
                chargeStationInfo.setChargePercent(K(jSONObject, "charge_percent"));
                chargeStationInfo.setChargeTime(K(jSONObject, "charge_time"));
                chargeStationInfo.setRemainingCapacity(K(jSONObject, "remaining_capacity"));
                chargeStationInfo.setVoltage(K(jSONObject, "voltage"));
                chargeStationInfo.setAmperage(K(jSONObject, "amperage"));
                chargeStationInfo.setStepIndex(K(jSONObject, "step_index"));
                arrayList.add(chargeStationInfo);
            }
            return arrayList;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseChargeStationInfo");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static List<RouteBusLineItem> V0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(c(optJSONObject));
            }
        }
        return arrayList;
    }

    private static void W(Path path, List<DriveStepV2> list) {
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

    private static List<RouteBusLineItem> W0(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(d(optJSONObject));
            }
        }
        return arrayList;
    }

    public static void X(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                aoiItem.setId(v(optJSONObject, "id"));
                aoiItem.setName(v(optJSONObject, "name"));
                aoiItem.setAdcode(v(optJSONObject, "adcode"));
                aoiItem.setLocation(S(optJSONObject, "location"));
                aoiItem.setArea(Float.valueOf(N0(v(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    private static Doorway X0(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(v(jSONObject, "name"));
        doorway.setLatLonPoint(S(jSONObject, "location"));
        return doorway;
    }

    public static DriveRouteResultV2 Y(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                DriveRouteResultV2 driveRouteResultV2 = new DriveRouteResultV2();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return driveRouteResultV2;
                }
                driveRouteResultV2.setStartPos(S(optJSONObject, LiveConfigKey.ORIGIN));
                driveRouteResultV2.setTargetPos(S(optJSONObject, "destination"));
                driveRouteResultV2.setTaxiCost(N0(v(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        DrivePathV2 drivePathV2 = new DrivePathV2();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                        if (optJSONObject2 != null) {
                            drivePathV2.setDistance(N0(v(optJSONObject2, "distance")));
                            drivePathV2.setStrategy(v(optJSONObject2, "strategy"));
                            drivePathV2.setRestriction(L0(v(optJSONObject2, "restriction")));
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                            if (optJSONObject3 != null) {
                                Cost cost = new Cost();
                                C(cost, optJSONObject3);
                                drivePathV2.setCost(cost);
                            }
                            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("elec_consume_info");
                            if (optJSONObject4 != null) {
                                drivePathV2.setElecConsumeInfo(o(optJSONObject4));
                            }
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("charge_station_info");
                            if (optJSONArray2 != null) {
                                drivePathV2.setChargeStationInfo(V(optJSONArray2));
                            }
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray3 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                                    DriveStepV2 driveStepV2 = new DriveStepV2();
                                    JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i5);
                                    if (optJSONObject5 != null) {
                                        driveStepV2.setInstruction(v(optJSONObject5, "instruction"));
                                        driveStepV2.setOrientation(v(optJSONObject5, "orientation"));
                                        driveStepV2.setStepDistance(L0(v(optJSONObject5, "step_distance")));
                                        driveStepV2.setRoad(v(optJSONObject5, "road_name"));
                                        driveStepV2.setPolyline(a0(optJSONObject5, "polyline"));
                                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject("cost");
                                        if (optJSONObject6 != null) {
                                            Cost cost2 = new Cost();
                                            C(cost2, optJSONObject6);
                                            driveStepV2.setCostDetail(cost2);
                                        }
                                        JSONObject optJSONObject7 = optJSONObject5.optJSONObject("navi");
                                        if (optJSONObject7 != null) {
                                            driveStepV2.setNavi(p(optJSONObject7));
                                        }
                                        JSONArray optJSONArray4 = optJSONObject5.optJSONArray("cities");
                                        if (optJSONArray4 != null) {
                                            driveStepV2.setRouteSearchCityList(g0(optJSONArray4));
                                        }
                                        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("tmcs");
                                        if (optJSONArray5 != null) {
                                            driveStepV2.setTMCs(b0(optJSONArray5));
                                        }
                                        arrayList2.add(driveStepV2);
                                    }
                                }
                                drivePathV2.setSteps(arrayList2);
                                W(drivePathV2, arrayList2);
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
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseDriveRoute");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        } catch (Throwable th) {
            j4.i(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static ArrayList<PoiItemV2> Z(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    arrayList.add(h0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static WalkStep a(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(v(jSONObject, "instruction"));
        walkStep.setOrientation(v(jSONObject, "orientation"));
        walkStep.setRoad(v(jSONObject, "road"));
        walkStep.setDistance(N0(v(jSONObject, "distance")));
        walkStep.setDuration(N0(v(jSONObject, "duration")));
        walkStep.setPolyline(a0(jSONObject, "polyline"));
        walkStep.setAction(v(jSONObject, "action"));
        walkStep.setAssistantAction(v(jSONObject, "assistant_action"));
        return walkStep;
    }

    private static ArrayList<LatLonPoint> a0(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return G0(jSONObject.optString(str));
        }
        return null;
    }

    private static WalkStep b(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(v(jSONObject, "instruction"));
        walkStep.setOrientation(v(jSONObject, "orientation"));
        walkStep.setRoad(v(jSONObject, "road"));
        walkStep.setDistance(N0(v(jSONObject, "distance")));
        walkStep.setDuration(N0(v(jSONObject, "duration")));
        JSONObject optJSONObject = jSONObject.optJSONObject("polyline");
        if (optJSONObject != null) {
            walkStep.setPolyline(a0(optJSONObject, "polyline"));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("navi");
        if (optJSONObject2 != null) {
            walkStep.setAction(v(optJSONObject2, "action"));
            walkStep.setAssistantAction(v(optJSONObject2, "assistant_action"));
            walkStep.setRoadType(L0(v(optJSONObject2, "walk_type")));
        }
        return walkStep;
    }

    private static List<TMC> b0(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                TMC tmc = new TMC();
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    tmc.setDistance(L0(v(optJSONObject, "tmc_distance")));
                    tmc.setStatus(v(optJSONObject, "tmc_status"));
                    tmc.setPolyline(a0(optJSONObject, "tmc_polyline"));
                    arrayList.add(tmc);
                }
            } catch (JSONException e4) {
                j4.i(e4, "JSONHelper", "parseTMCsV5");
                throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
            }
        }
        return arrayList;
    }

    private static RouteBusLineItem c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(f(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(f(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(v(jSONObject, "name"));
        routeBusLineItem.setBusLineId(v(jSONObject, "id"));
        routeBusLineItem.setBusLineType(v(jSONObject, "type"));
        routeBusLineItem.setDistance(N0(v(jSONObject, "distance")));
        routeBusLineItem.setDuration(N0(v(jSONObject, "duration")));
        routeBusLineItem.setPolyline(a0(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(j4.n(v(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(j4.n(v(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(L0(v(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(e(jSONObject));
        return routeBusLineItem;
    }

    private static void c0(Path path, List<RideStep> list) {
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

    private static RouteBusLineItem d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(f(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(f(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(v(jSONObject, "name"));
        routeBusLineItem.setBusLineId(v(jSONObject, "id"));
        routeBusLineItem.setBusLineType(v(jSONObject, "type"));
        routeBusLineItem.setDistance(N0(v(jSONObject, "distance")));
        JSONObject optJSONObject = jSONObject.optJSONObject("cost");
        if (optJSONObject != null) {
            routeBusLineItem.setDuration(N0(v(optJSONObject, "duration")));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("polyline");
        if (optJSONObject2 != null) {
            routeBusLineItem.setPolyline(a0(optJSONObject2, "polyline"));
        }
        routeBusLineItem.setFirstBusTime(j4.n(v(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(j4.n(v(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(L0(v(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(e(jSONObject));
        return routeBusLineItem;
    }

    public static PoiItem d0(JSONObject jSONObject) throws JSONException {
        PoiItem poiItem = new PoiItem(v(jSONObject, "id"), S(jSONObject, "location"), v(jSONObject, "name"), v(jSONObject, "address"));
        poiItem.setAdCode(v(jSONObject, "adcode"));
        poiItem.setProvinceName(v(jSONObject, "pname"));
        poiItem.setCityName(v(jSONObject, "cityname"));
        poiItem.setAdName(v(jSONObject, "adname"));
        poiItem.setCityCode(v(jSONObject, "citycode"));
        poiItem.setProvinceCode(v(jSONObject, "pcode"));
        poiItem.setDirection(v(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String v3 = v(jSONObject, "distance");
            if (!s0(v3)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(v3));
                } catch (NumberFormatException e4) {
                    j4.i(e4, "JSONHelper", "parseBasePoi");
                } catch (Exception e5) {
                    j4.i(e5, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(v(jSONObject, "tel"));
        poiItem.setTypeDes(v(jSONObject, "type"));
        poiItem.setEnter(S(jSONObject, "entr_location"));
        poiItem.setExit(S(jSONObject, "exit_location"));
        poiItem.setWebsite(v(jSONObject, "website"));
        poiItem.setPostcode(v(jSONObject, "postcode"));
        String v4 = v(jSONObject, "business_area");
        if (s0(v4)) {
            v4 = v(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(v4);
        poiItem.setEmail(v(jSONObject, "email"));
        if (K0(v(jSONObject, "indoor_map"))) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(v(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        arrayList.add(x0(optJSONObject));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        poiItem.setIndoorDate(e0(jSONObject, "indoor_data"));
        poiItem.setPoiExtension(q0(jSONObject, "biz_ext"));
        poiItem.setTypeCode(v(jSONObject, "typecode"));
        poiItem.setShopID(v(jSONObject, "shopid"));
        z(poiItem, jSONObject);
        return poiItem;
    }

    private static List<BusStationItem> e(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(f(optJSONObject));
            }
        }
        return arrayList;
    }

    private static IndoorData e0(JSONObject jSONObject, String str) throws JSONException {
        int i4;
        String str2;
        JSONObject optJSONObject;
        String str3 = "";
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null && optJSONObject.has("cpid") && optJSONObject.has("floor")) {
            str3 = v(optJSONObject, "cpid");
            i4 = L0(v(optJSONObject, "floor"));
            str2 = v(optJSONObject, "truefloor");
        } else {
            i4 = 0;
            str2 = "";
        }
        return new IndoorData(str3, i4, str2);
    }

    private static BusStationItem f(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(v(jSONObject, "name"));
        busStationItem.setBusStationId(v(jSONObject, "id"));
        busStationItem.setLatLonPoint(S(jSONObject, "location"));
        return busStationItem;
    }

    public static WalkRouteResult f0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                WalkRouteResult walkRouteResult = new WalkRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                walkRouteResult.setStartPos(S(optJSONObject, LiveConfigKey.ORIGIN));
                walkRouteResult.setTargetPos(S(optJSONObject, "destination"));
                if (optJSONObject.has("paths")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                    if (optJSONArray == null) {
                        walkRouteResult.setPaths(arrayList);
                        return walkRouteResult;
                    }
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        WalkPath walkPath = new WalkPath();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                        if (optJSONObject2 != null) {
                            walkPath.setDistance(N0(v(optJSONObject2, "distance")));
                            walkPath.setDuration(R0(v(optJSONObject2, "duration")));
                            if (optJSONObject2.has("steps")) {
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                                ArrayList arrayList2 = new ArrayList();
                                if (optJSONArray2 != null) {
                                    for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                        WalkStep walkStep = new WalkStep();
                                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i5);
                                        if (optJSONObject3 != null) {
                                            walkStep.setInstruction(v(optJSONObject3, "instruction"));
                                            walkStep.setOrientation(v(optJSONObject3, "orientation"));
                                            walkStep.setRoad(v(optJSONObject3, "road"));
                                            walkStep.setDistance(N0(v(optJSONObject3, "distance")));
                                            walkStep.setDuration(N0(v(optJSONObject3, "duration")));
                                            walkStep.setPolyline(a0(optJSONObject3, "polyline"));
                                            walkStep.setAction(v(optJSONObject3, "action"));
                                            walkStep.setAssistantAction(v(optJSONObject3, "assistant_action"));
                                            arrayList2.add(walkStep);
                                        }
                                    }
                                    walkPath.setSteps(arrayList2);
                                    E(walkPath, arrayList2);
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
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseWalkRoute");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static RouteRailwayItem g(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("id") && jSONObject.has("name")) {
            RouteRailwayItem routeRailwayItem = new RouteRailwayItem();
            routeRailwayItem.setID(v(jSONObject, "id"));
            routeRailwayItem.setName(v(jSONObject, "name"));
            routeRailwayItem.setTime(v(jSONObject, "time"));
            routeRailwayItem.setTrip(v(jSONObject, "trip"));
            routeRailwayItem.setDistance(N0(v(jSONObject, "distance")));
            routeRailwayItem.setType(v(jSONObject, "type"));
            routeRailwayItem.setDeparturestop(h(jSONObject.optJSONObject("departure_stop")));
            routeRailwayItem.setArrivalstop(h(jSONObject.optJSONObject("arrival_stop")));
            routeRailwayItem.setViastops(i(jSONObject));
            routeRailwayItem.setAlters(j(jSONObject));
            routeRailwayItem.setSpaces(k(jSONObject));
            return routeRailwayItem;
        }
        return null;
    }

    private static List<RouteSearchCity> g0(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(v(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(v(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(v(optJSONObject, "adcode"));
                    F(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
            } catch (JSONException e4) {
                j4.i(e4, "JSONHelper", "parseCrossCity");
                throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
            }
        }
        return arrayList;
    }

    private static RailwayStationItem h(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(v(jSONObject, "id"));
        railwayStationItem.setName(v(jSONObject, "name"));
        railwayStationItem.setLocation(S(jSONObject, "location"));
        railwayStationItem.setAdcode(v(jSONObject, "adcode"));
        railwayStationItem.setTime(v(jSONObject, "time"));
        railwayStationItem.setisStart(U0(v(jSONObject, CampaignEx.JSON_NATIVE_VIDEO_START)));
        railwayStationItem.setisEnd(U0(v(jSONObject, "end")));
        railwayStationItem.setWait(N0(v(jSONObject, "wait")));
        return railwayStationItem;
    }

    public static PoiItemV2 h0(JSONObject jSONObject) throws JSONException {
        PoiItemV2 poiItemV2 = new PoiItemV2(v(jSONObject, "id"), S(jSONObject, "location"), v(jSONObject, "name"), v(jSONObject, "address"));
        poiItemV2.setTypeDes(v(jSONObject, "type"));
        poiItemV2.setTypeCode(v(jSONObject, "typecode"));
        poiItemV2.setProvinceName(v(jSONObject, "pname"));
        poiItemV2.setCityName(v(jSONObject, "cityname"));
        poiItemV2.setAdName(v(jSONObject, "adname"));
        poiItemV2.setProvinceCode(v(jSONObject, "pcode"));
        poiItemV2.setAdCode(v(jSONObject, "adcode"));
        poiItemV2.setCityCode(v(jSONObject, "citycode"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        arrayList.add(z0(optJSONObject));
                    }
                }
            }
            poiItemV2.setSubPois(arrayList);
        }
        poiItemV2.setBusiness(k0(jSONObject, "business"));
        poiItemV2.setIndoorData(i0(jSONObject, "indoor"));
        poiItemV2.setPoiNavi(n0(jSONObject, "navi"));
        A(poiItemV2, jSONObject);
        return poiItemV2;
    }

    private static List<RailwayStationItem> i(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(h(optJSONObject));
            }
        }
        return arrayList;
    }

    private static IndoorDataV2 i0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        int i4;
        JSONObject optJSONObject;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
            i4 = 0;
        } else {
            r2 = L0(v(optJSONObject, "indoor_map")) == 1;
            str3 = v(optJSONObject, "cpid");
            i4 = L0(v(optJSONObject, "floor"));
            str2 = v(optJSONObject, "truefloor");
        }
        return new IndoorDataV2(r2, str3, i4, str2);
    }

    private static List<Railway> j(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("alters")) == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                Railway railway = new Railway();
                railway.setID(v(optJSONObject, "id"));
                railway.setName(v(optJSONObject, "name"));
                arrayList.add(railway);
            }
        }
        return arrayList;
    }

    public static WalkRouteResultV2 j0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                WalkRouteResultV2 walkRouteResultV2 = new WalkRouteResultV2();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                walkRouteResultV2.setStartPos(S(optJSONObject, LiveConfigKey.ORIGIN));
                walkRouteResultV2.setTargetPos(S(optJSONObject, "destination"));
                if (optJSONObject.has("paths")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                    if (optJSONArray == null) {
                        walkRouteResultV2.setPaths(arrayList);
                        return walkRouteResultV2;
                    }
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        WalkPath walkPath = new WalkPath();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                        if (optJSONObject2 != null) {
                            walkPath.setDistance(N0(v(optJSONObject2, "distance")));
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                            if (optJSONObject3 != null) {
                                walkPath.setDuration(R0(v(optJSONObject3, "duration")));
                            }
                            if (optJSONObject2.has("steps")) {
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                                ArrayList arrayList2 = new ArrayList();
                                if (optJSONArray2 != null) {
                                    for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                        WalkStep walkStep = new WalkStep();
                                        JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i5);
                                        if (optJSONObject4 != null) {
                                            walkStep.setInstruction(v(optJSONObject4, "instruction"));
                                            walkStep.setOrientation(v(optJSONObject4, "orientation"));
                                            walkStep.setRoad(v(optJSONObject4, "road_name"));
                                            walkStep.setDistance(N0(v(optJSONObject4, "step_distance")));
                                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("cost");
                                            if (optJSONObject5 != null) {
                                                walkStep.setDuration(N0(v(optJSONObject5, "duration")));
                                            }
                                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("navi");
                                            if (optJSONObject6 != null) {
                                                walkStep.setAction(v(optJSONObject6, "action"));
                                                walkStep.setAssistantAction(v(optJSONObject6, "assistant_action"));
                                                walkStep.setRoadType(L0(v(optJSONObject6, "work_type")));
                                            }
                                            walkStep.setPolyline(a0(optJSONObject4, "polyline"));
                                            arrayList2.add(walkStep);
                                        }
                                    }
                                    walkPath.setSteps(arrayList2);
                                    E(walkPath, arrayList2);
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
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseWalkRoute");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static List<RailwaySpace> k(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("spaces")) == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(l(optJSONObject));
            }
        }
        return arrayList;
    }

    private static Business k0(JSONObject jSONObject, String str) throws JSONException {
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
            String v3 = v(optJSONObject, "business_area");
            String v4 = v(optJSONObject, "opentime_today");
            String v5 = v(optJSONObject, "opentime_week");
            String v6 = v(optJSONObject, "tel");
            String v7 = v(optJSONObject, "tag");
            String v8 = v(optJSONObject, CampaignEx.JSON_KEY_STAR);
            String v9 = v(optJSONObject, "cost");
            str2 = v3;
            str3 = v4;
            str4 = v5;
            str5 = v6;
            str6 = v7;
            str7 = v8;
            str8 = v9;
            str9 = v(optJSONObject, "parking_type");
            str10 = v(optJSONObject, "alias");
            str11 = v(optJSONObject, "cpid");
        }
        Business business = new Business(str2, str3, str4, str5, str6, str7, str8, str9, str10);
        business.setCPID(str11);
        return business;
    }

    private static RailwaySpace l(JSONObject jSONObject) throws JSONException {
        return new RailwaySpace(v(jSONObject, "code"), N0(v(jSONObject, "cost")));
    }

    public static LocalWeatherLive l0(String str) throws AMapException {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("lives")) {
                LocalWeatherLive localWeatherLive = new LocalWeatherLive();
                JSONArray optJSONArray = jSONObject.optJSONArray("lives");
                if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                    return localWeatherLive;
                }
                localWeatherLive.setAdCode(v(optJSONObject, "adcode"));
                localWeatherLive.setProvince(v(optJSONObject, "province"));
                localWeatherLive.setCity(v(optJSONObject, "city"));
                localWeatherLive.setWeather(v(optJSONObject, "weather"));
                localWeatherLive.setTemperature(v(optJSONObject, "temperature"));
                localWeatherLive.setWindDirection(v(optJSONObject, "winddirection"));
                localWeatherLive.setWindPower(v(optJSONObject, "windpower"));
                localWeatherLive.setHumidity(v(optJSONObject, "humidity"));
                localWeatherLive.setReportTime(v(optJSONObject, "reporttime"));
                return localWeatherLive;
            }
            return null;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static TaxiItem m(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItem taxiItem = new TaxiItem();
        taxiItem.setOrigin(S(jSONObject, LiveConfigKey.ORIGIN));
        taxiItem.setDestination(S(jSONObject, "destination"));
        taxiItem.setDistance(N0(v(jSONObject, "distance")));
        taxiItem.setDuration(N0(v(jSONObject, "duration")));
        taxiItem.setSname(v(jSONObject, "sname"));
        taxiItem.setTname(v(jSONObject, "tname"));
        return taxiItem;
    }

    public static ArrayList<BusStationItem> m0(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    arrayList.add(B0(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static TaxiItemV2 n(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItemV2 taxiItemV2 = new TaxiItemV2();
        taxiItemV2.setOrigin(S(jSONObject, "startpoint"));
        taxiItemV2.setDestination(S(jSONObject, "endpoint"));
        taxiItemV2.setDistance(N0(v(jSONObject, "distance")));
        taxiItemV2.setDuration(N0(v(jSONObject, "drivetime")));
        JSONObject optJSONObject = jSONObject.optJSONObject("polyline");
        if (optJSONObject != null) {
            taxiItemV2.setPolyline(a0(optJSONObject, "polyline"));
        }
        taxiItemV2.setSname(v(jSONObject, "startname"));
        taxiItemV2.setTname(v(jSONObject, "endname"));
        return taxiItemV2;
    }

    private static PoiNavi n0(JSONObject jSONObject, String str) throws JSONException {
        LatLonPoint latLonPoint;
        String str2;
        JSONObject optJSONObject;
        LatLonPoint latLonPoint2 = null;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            latLonPoint = null;
            str2 = "";
        } else {
            str3 = v(optJSONObject, "navi_poiid");
            latLonPoint2 = S(optJSONObject, "entr_location");
            latLonPoint = S(optJSONObject, "exit_location");
            str2 = v(optJSONObject, "gridcode");
        }
        return new PoiNavi(str3, latLonPoint2, latLonPoint, str2);
    }

    private static ElecConsumeInfo o(JSONObject jSONObject) throws AMapException {
        try {
            ElecConsumeInfo elecConsumeInfo = new ElecConsumeInfo();
            elecConsumeInfo.setRunOutPoint(S(jSONObject, "runout_point"));
            elecConsumeInfo.setRunOutStepIndex(K(jSONObject, "runout_step_index"));
            elecConsumeInfo.setConsumeEnergy(K(jSONObject, "consume_energy"));
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("left_energy");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    arrayList.add(Integer.valueOf(optJSONArray.optInt(i4)));
                }
            }
            elecConsumeInfo.setLeftEnergy(arrayList);
            return elecConsumeInfo;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseElecConsumeInfo");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static LocalWeatherForecast o0(String str) throws AMapException {
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
                    localWeatherForecast.setCity(v(optJSONObject, "city"));
                    localWeatherForecast.setAdCode(v(optJSONObject, "adcode"));
                    localWeatherForecast.setProvince(v(optJSONObject, "province"));
                    localWeatherForecast.setReportTime(v(optJSONObject, "reporttime"));
                    if (!optJSONObject.has("casts")) {
                        return localWeatherForecast;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                            if (optJSONObject2 != null) {
                                localDayWeatherForecast.setDate(v(optJSONObject2, "date"));
                                localDayWeatherForecast.setWeek(v(optJSONObject2, "week"));
                                localDayWeatherForecast.setDayWeather(v(optJSONObject2, "dayweather"));
                                localDayWeatherForecast.setNightWeather(v(optJSONObject2, "nightweather"));
                                localDayWeatherForecast.setDayTemp(v(optJSONObject2, "daytemp"));
                                localDayWeatherForecast.setNightTemp(v(optJSONObject2, "nighttemp"));
                                localDayWeatherForecast.setDayWindDirection(v(optJSONObject2, "daywind"));
                                localDayWeatherForecast.setNightWindDirection(v(optJSONObject2, "nightwind"));
                                localDayWeatherForecast.setDayWindPower(v(optJSONObject2, "daypower"));
                                localDayWeatherForecast.setNightWindPower(v(optJSONObject2, "nightpower"));
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
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static Navi p(JSONObject jSONObject) throws AMapException {
        try {
            Navi navi = new Navi();
            navi.setAction(v(jSONObject, "action"));
            navi.setAssistantAction(v(jSONObject, "assistant_action"));
            return navi;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseNavi");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static ArrayList<BusLineItem> p0(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(H0(optJSONObject));
            }
        }
        return arrayList;
    }

    private static List<Photo> q(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("photos");
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                Photo photo = new Photo();
                photo.setTitle(v(optJSONObject, "title"));
                photo.setUrl(v(optJSONObject, "url"));
                arrayList.add(photo);
            }
            return arrayList;
        }
        return arrayList;
    }

    private static PoiItemExtension q0(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        JSONObject optJSONObject;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
        } else {
            str3 = v(optJSONObject, "open_time");
            str2 = v(optJSONObject, CampaignEx.JSON_KEY_STAR);
        }
        return new PoiItemExtension(str3, str2);
    }

    private static RoutePOIItem r(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(v(jSONObject, "id"));
        routePOIItem.setTitle(v(jSONObject, "name"));
        routePOIItem.setPoint(S(jSONObject, "location"));
        routePOIItem.setDistance(N0(v(jSONObject, "distance")));
        routePOIItem.setDuration(N0(v(jSONObject, "duration")));
        routePOIItem.setCPID(v(jSONObject, "cpid"));
        return routePOIItem;
    }

    public static ArrayList<GeocodeAddress> r0(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    GeocodeAddress geocodeAddress = new GeocodeAddress();
                    geocodeAddress.setFormatAddress(v(optJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(v(optJSONObject, "province"));
                    geocodeAddress.setCity(v(optJSONObject, "city"));
                    geocodeAddress.setDistrict(v(optJSONObject, "district"));
                    geocodeAddress.setTownship(v(optJSONObject, "township"));
                    geocodeAddress.setNeighborhood(v(optJSONObject.optJSONObject("neighborhood"), "name"));
                    geocodeAddress.setBuilding(v(optJSONObject.optJSONObject("building"), "name"));
                    geocodeAddress.setAdcode(v(optJSONObject, "adcode"));
                    geocodeAddress.setLatLonPoint(S(optJSONObject, "location"));
                    geocodeAddress.setLevel(v(optJSONObject, "level"));
                    geocodeAddress.setCountry(v(optJSONObject, "country"));
                    geocodeAddress.setPostcode(v(optJSONObject, "postcode"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    private static RidePath s(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(N0(v(jSONObject, "distance")));
            ridePath.setDuration(R0(v(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(v(optJSONObject, "instruction"));
                        rideStep.setOrientation(v(optJSONObject, "orientation"));
                        rideStep.setRoad(v(optJSONObject, "road"));
                        rideStep.setDistance(N0(v(optJSONObject, "distance")));
                        rideStep.setDuration(N0(v(optJSONObject, "duration")));
                        rideStep.setPolyline(a0(optJSONObject, "polyline"));
                        rideStep.setAction(v(optJSONObject, "action"));
                        rideStep.setAssistantAction(v(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                c0(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseRidePath");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static boolean s0(String str) {
        return str == null || str.equals("");
    }

    private static RidePath t(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(N0(v(jSONObject, "distance")));
            ridePath.setDuration(R0(v(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(v(optJSONObject, "instruction"));
                        rideStep.setOrientation(v(optJSONObject, "orientation"));
                        rideStep.setRoad(v(optJSONObject, "road_name"));
                        rideStep.setDistance(N0(v(optJSONObject, "step_distance")));
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("cost");
                        if (optJSONObject2 != null) {
                            rideStep.setDuration(N0(v(optJSONObject2, "duration")));
                        }
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("navi");
                        if (optJSONObject3 != null) {
                            rideStep.setAction(v(optJSONObject3, "action"));
                            rideStep.setAssistantAction(v(optJSONObject3, "assistant_action"));
                            rideStep.setRoadType(L0(v(optJSONObject3, "work_type")));
                        }
                        rideStep.setPolyline(a0(optJSONObject, "polyline"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                c0(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseRidePathV2");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static RideRouteResult t0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                RideRouteResult rideRouteResult = new RideRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                rideRouteResult.setStartPos(S(optJSONObject, LiveConfigKey.ORIGIN));
                rideRouteResult.setTargetPos(S(optJSONObject, "destination"));
                ArrayList arrayList = new ArrayList();
                Object opt = optJSONObject.opt("paths");
                if (opt == null) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                if (opt instanceof JSONArray) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        RidePath s3 = s(optJSONArray.optJSONObject(i4));
                        if (s3 != null) {
                            arrayList.add(s3);
                        }
                    }
                } else if (opt instanceof JSONObject) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                    if (!optJSONObject2.has("path")) {
                        rideRouteResult.setPaths(arrayList);
                        return rideRouteResult;
                    }
                    RidePath s4 = s(optJSONObject2.optJSONObject("path"));
                    if (s4 != null) {
                        arrayList.add(s4);
                    }
                }
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            return null;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseRideRoute");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static BusRouteResult u(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                BusRouteResult busRouteResult = new BusRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return busRouteResult;
                }
                busRouteResult.setStartPos(S(optJSONObject, LiveConfigKey.ORIGIN));
                busRouteResult.setTargetPos(S(optJSONObject, "destination"));
                busRouteResult.setTaxiCost(N0(v(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                    busRouteResult.setPaths(y(optJSONArray));
                    return busRouteResult;
                }
                return busRouteResult;
            }
            return null;
        } catch (JSONException unused) {
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static ArrayList<Tip> u0(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                tip.setName(v(optJSONObject, "name"));
                tip.setDistrict(v(optJSONObject, "district"));
                tip.setAdcode(v(optJSONObject, "adcode"));
                tip.setID(v(optJSONObject, "id"));
                tip.setAddress(v(optJSONObject, "address"));
                tip.setTypeCode(v(optJSONObject, "typecode"));
                String v3 = v(optJSONObject, "location");
                if (!TextUtils.isEmpty(v3)) {
                    String[] split = v3.split(",");
                    if (split.length == 2) {
                        tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    public static String v(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || jSONObject.optString(str).equals("[]")) ? "" : jSONObject.optString(str).trim();
    }

    public static RideRouteResultV2 v0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                RideRouteResultV2 rideRouteResultV2 = new RideRouteResultV2();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                rideRouteResultV2.setStartPos(S(optJSONObject, LiveConfigKey.ORIGIN));
                rideRouteResultV2.setTargetPos(S(optJSONObject, "destination"));
                ArrayList arrayList = new ArrayList();
                Object opt = optJSONObject.opt("paths");
                if (opt == null) {
                    rideRouteResultV2.setPaths(arrayList);
                    return rideRouteResultV2;
                }
                if (opt instanceof JSONArray) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        RidePath t3 = t(optJSONArray.optJSONObject(i4));
                        if (t3 != null) {
                            arrayList.add(t3);
                        }
                    }
                }
                rideRouteResultV2.setPaths(arrayList);
                return rideRouteResultV2;
            }
            return null;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseRideRouteV2");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static ArrayList<SuggestionCity> w(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (jSONObject.has("cities") && (optJSONArray = jSONObject.optJSONArray("cities")) != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    arrayList.add(new SuggestionCity(v(optJSONObject, "name"), v(optJSONObject, "citycode"), v(optJSONObject, "adcode"), L0(v(optJSONObject, "num"))));
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static ArrayList<RoutePOIItem> w0(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return arrayList;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    arrayList.add(r(optJSONObject));
                }
            }
        } else if (opt instanceof JSONObject) {
            arrayList.add(r(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> x(org.json.JSONObject r16, boolean r17) throws org.json.JSONException {
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
            java.lang.String r6 = v(r5, r6)
            java.lang.String r7 = "location"
            java.lang.String r7 = v(r5, r7)
            r8 = 0
            if (r7 == 0) goto L4e
            java.lang.String r10 = ","
            java.lang.String[] r7 = r7.split(r10)
            int r10 = r7.length
            r11 = 2
            if (r10 != r11) goto L4e
            r8 = r7[r3]
            double r8 = P0(r8)
            r10 = 1
            r7 = r7[r10]
            double r10 = P0(r7)
            r14 = r8
            r8 = r10
            r10 = r14
            goto L4f
        L4e:
            r10 = r8
        L4f:
            java.lang.String r7 = "distance"
            java.lang.String r7 = v(r5, r7)
            java.lang.String r12 = "updatetime"
            java.lang.String r5 = v(r5, r12)
            long r12 = R0(r5)
            int r5 = L0(r7)
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.r4.x(org.json.JSONObject, boolean):java.util.ArrayList");
    }

    private static SubPoiItem x0(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(v(jSONObject, "id"), S(jSONObject, "location"), v(jSONObject, "name"), v(jSONObject, "address"));
        subPoiItem.setSubName(v(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(v(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String v3 = v(jSONObject, "distance");
            if (!s0(v3)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(v3));
                } catch (NumberFormatException e4) {
                    j4.i(e4, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e5) {
                    j4.i(e5, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    private static List<BusPath> y(JSONArray jSONArray) throws JSONException {
        BusStep O0;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                busPath.setCost(N0(v(optJSONObject, "cost")));
                busPath.setDuration(R0(v(optJSONObject, "duration")));
                busPath.setNightBus(U0(v(optJSONObject, "nightflag")));
                busPath.setWalkDistance(N0(v(optJSONObject, "walking_distance")));
                busPath.setDistance(N0(v(optJSONObject, "distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f4 = 0.0f;
                    float f5 = 0.0f;
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                        if (optJSONObject2 != null && (O0 = O0(optJSONObject2)) != null) {
                            arrayList2.add(O0);
                            if (O0.getWalk() != null) {
                                f5 += O0.getWalk().getDistance();
                            }
                            if (O0.getBusLines() != null && O0.getBusLines().size() > 0) {
                                f4 += O0.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f4);
                    busPath.setWalkDistance(f5);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    public static DistanceResult y0(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("results")) {
                DistanceResult distanceResult = new DistanceResult();
                JSONArray optJSONArray = jSONObject.optJSONArray("results");
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    DistanceItem distanceItem = new DistanceItem();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                    distanceItem.setOriginId(L0(v(jSONObject2, "origin_id")));
                    distanceItem.setDestId(L0(v(jSONObject2, "dest_id")));
                    distanceItem.setDistance(N0(v(jSONObject2, "distance")));
                    distanceItem.setDuration(N0(v(jSONObject2, "duration")));
                    String v3 = v(jSONObject2, "info");
                    if (!TextUtils.isEmpty(v3)) {
                        distanceItem.setErrorInfo(v3);
                        distanceItem.setErrorCode(L0(v(jSONObject2, "code")));
                    }
                    arrayList.add(distanceItem);
                }
                distanceResult.setDistanceResults(arrayList);
                return distanceResult;
            }
            return null;
        } catch (JSONException e4) {
            j4.i(e4, "JSONHelper", "parseRouteDistance");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    private static void z(PoiItem poiItem, JSONObject jSONObject) throws JSONException {
        List<Photo> q3 = q(jSONObject.optJSONObject("deep_info"));
        if (q3.size() == 0) {
            q3 = q(jSONObject);
        }
        poiItem.setPhotos(q3);
    }

    private static SubPoiItemV2 z0(JSONObject jSONObject) throws JSONException {
        SubPoiItemV2 subPoiItemV2 = new SubPoiItemV2(v(jSONObject, "id"), S(jSONObject, "location"), v(jSONObject, "name"), v(jSONObject, "address"));
        subPoiItemV2.setSubTypeDes(v(jSONObject, "subtype"));
        subPoiItemV2.setTypeCode(v(jSONObject, "typecode"));
        return subPoiItemV2;
    }
}
