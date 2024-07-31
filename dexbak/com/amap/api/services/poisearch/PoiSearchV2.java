package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.p047s.C2082j4;
import com.amap.api.col.p047s.PoiSearchCoreV2;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PoiSearchV2 {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";

    /* renamed from: a */
    private IPoiSearchV2 f7496a;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItemV2 poiItemV2, int i);

        void onPoiSearched(PoiResultV2 poiResultV2, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum PremiumType {
        DEFAULT(""),
        ENTIRETY("entirety_poi");
        

        /* renamed from: a */
        private final String f7498a;

        PremiumType(String str) {
            this.f7498a = str;
        }

        /* renamed from: a */
        final String m51849a() {
            return this.f7498a;
        }

        /* renamed from: a */
        static PremiumType m51848a(String str) {
            PremiumType premiumType = DEFAULT;
            if (str.equals(premiumType.m51849a())) {
                return premiumType;
            }
            PremiumType premiumType2 = ENTIRETY;
            return str.equals(premiumType2.m51849a()) ? premiumType2 : premiumType;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Query implements Cloneable {

        /* renamed from: a */
        private String f7499a;

        /* renamed from: b */
        private String f7500b;

        /* renamed from: c */
        private String f7501c;

        /* renamed from: d */
        private int f7502d;

        /* renamed from: e */
        private int f7503e;

        /* renamed from: f */
        private String f7504f;

        /* renamed from: g */
        private boolean f7505g;

        /* renamed from: h */
        private String f7506h;

        /* renamed from: i */
        private boolean f7507i;

        /* renamed from: j */
        private LatLonPoint f7508j;

        /* renamed from: k */
        private boolean f7509k;

        /* renamed from: l */
        private String f7510l;

        /* renamed from: m */
        private String f7511m;

        /* renamed from: n */
        private ShowFields f7512n;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        /* renamed from: a */
        private static String m51847a() {
            return "";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Query query = (Query) obj;
                String str = this.f7500b;
                if (str == null) {
                    if (query.f7500b != null) {
                        return false;
                    }
                } else if (!str.equals(query.f7500b)) {
                    return false;
                }
                String str2 = this.f7501c;
                if (str2 == null) {
                    if (query.f7501c != null) {
                        return false;
                    }
                } else if (!str2.equals(query.f7501c)) {
                    return false;
                }
                String str3 = this.f7504f;
                if (str3 == null) {
                    if (query.f7504f != null) {
                        return false;
                    }
                } else if (!str3.equals(query.f7504f)) {
                    return false;
                }
                if (this.f7502d == query.f7502d && this.f7503e == query.f7503e) {
                    String str4 = this.f7499a;
                    if (str4 == null) {
                        if (query.f7499a != null) {
                            return false;
                        }
                    } else if (!str4.equals(query.f7499a)) {
                        return false;
                    }
                    String str5 = this.f7510l;
                    if (str5 == null) {
                        if (query.f7510l != null) {
                            return false;
                        }
                    } else if (!str5.equals(query.f7510l)) {
                        return false;
                    }
                    String str6 = this.f7511m;
                    if (str6 == null) {
                        if (query.f7511m != null) {
                            return false;
                        }
                    } else if (!str6.equals(query.f7511m)) {
                        return false;
                    }
                    String str7 = this.f7506h;
                    if (str7 == null) {
                        if (query.f7506h != null) {
                            return false;
                        }
                    } else if (!str7.equals(query.f7506h)) {
                        return false;
                    }
                    if (this.f7505g == query.f7505g && this.f7509k == query.f7509k) {
                        int i = this.f7512n.value;
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public String getBuilding() {
            return this.f7506h;
        }

        public String getCategory() {
            String str = this.f7500b;
            if (str != null && !str.equals("00") && !this.f7500b.equals("00|")) {
                return this.f7500b;
            }
            return m51847a();
        }

        public String getChannel() {
            return this.f7510l;
        }

        public String getCity() {
            return this.f7501c;
        }

        public boolean getCityLimit() {
            return this.f7505g;
        }

        public LatLonPoint getLocation() {
            return this.f7508j;
        }

        public int getPageNum() {
            return this.f7502d;
        }

        public int getPageSize() {
            return this.f7503e;
        }

        public String getPremium() {
            return this.f7511m;
        }

        protected String getQueryLanguage() {
            return this.f7504f;
        }

        public String getQueryString() {
            return this.f7499a;
        }

        public ShowFields getShowFields() {
            return this.f7512n;
        }

        public int hashCode() {
            String str = this.f7500b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f7510l;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f7511m;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f7501c;
            int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + (this.f7505g ? 1231 : 1237)) * 31;
            String str5 = this.f7504f;
            int hashCode5 = (((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f7502d) * 31) + this.f7503e) * 31;
            String str6 = this.f7499a;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.f7506h;
            return ((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + (this.f7512n.value % 1024);
        }

        public boolean isDistanceSort() {
            return this.f7507i;
        }

        public boolean isSpecial() {
            return this.f7509k;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearchV2.m51850b(query.f7499a, this.f7499a) && PoiSearchV2.m51850b(query.f7500b, this.f7500b) && PoiSearchV2.m51850b(query.f7504f, this.f7504f) && PoiSearchV2.m51850b(query.f7501c, this.f7501c) && PoiSearchV2.m51850b(query.f7506h, this.f7506h) && PoiSearchV2.m51850b(query.f7510l, this.f7510l) && PoiSearchV2.m51850b(query.f7511m, this.f7511m) && query.f7505g == this.f7505g && query.f7503e == this.f7503e && query.f7507i == this.f7507i && query.f7509k == this.f7509k && query.f7512n.value == this.f7512n.value;
        }

        public void setBuilding(String str) {
            this.f7506h = str;
        }

        public void setChannel(String str) {
            this.f7510l = str;
        }

        public void setCityLimit(boolean z) {
            this.f7505g = z;
        }

        public void setDistanceSort(boolean z) {
            this.f7507i = z;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f7508j = latLonPoint;
        }

        public void setPageNum(int i) {
            if (i <= 0) {
                i = 1;
            }
            this.f7502d = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.f7503e = 20;
            } else if (i > 30) {
                this.f7503e = 30;
            } else {
                this.f7503e = i;
            }
        }

        public void setPremium(PremiumType premiumType) {
            if (premiumType == null) {
                return;
            }
            this.f7511m = premiumType.m51849a();
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f7504f = "en";
            } else {
                this.f7504f = "zh-CN";
            }
        }

        public void setShowFields(ShowFields showFields) {
            if (showFields == null) {
                this.f7512n = new ShowFields();
            } else {
                this.f7512n = showFields;
            }
        }

        public void setSpecial(boolean z) {
            this.f7509k = z;
        }

        public Query(String str, String str2, String str3) {
            this.f7502d = 1;
            this.f7503e = 20;
            this.f7504f = "zh-CN";
            this.f7505g = false;
            this.f7507i = true;
            this.f7509k = true;
            this.f7511m = PremiumType.DEFAULT.m51849a();
            this.f7512n = new ShowFields();
            this.f7499a = str;
            this.f7500b = str2;
            this.f7501c = str3;
        }

        /* renamed from: clone */
        public Query m60117clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f7499a, this.f7500b, this.f7501c);
            query.setPageNum(this.f7502d);
            query.setPageSize(this.f7503e);
            query.setQueryLanguage(this.f7504f);
            query.setCityLimit(this.f7505g);
            query.setBuilding(this.f7506h);
            query.setLocation(this.f7508j);
            query.setDistanceSort(this.f7507i);
            query.setSpecial(this.f7509k);
            query.setChannel(this.f7510l);
            query.setPremium(PremiumType.m51848a(this.f7511m));
            query.setShowFields(new ShowFields(this.f7512n.value));
            return query;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a */
        private LatLonPoint f7513a;

        /* renamed from: b */
        private LatLonPoint f7514b;

        /* renamed from: c */
        private int f7515c;

        /* renamed from: d */
        private LatLonPoint f7516d;

        /* renamed from: e */
        private String f7517e;

        /* renamed from: f */
        private boolean f7518f;

        /* renamed from: g */
        private List<LatLonPoint> f7519g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.f7518f = true;
            this.f7517e = "Bound";
            this.f7515c = i;
            this.f7516d = latLonPoint;
        }

        /* renamed from: a */
        private void m51846a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f7513a = latLonPoint;
            this.f7514b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f7514b.getLatitude() || this.f7513a.getLongitude() >= this.f7514b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f7516d = new LatLonPoint((this.f7513a.getLatitude() + this.f7514b.getLatitude()) / 2.0d, (this.f7513a.getLongitude() + this.f7514b.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SearchBound searchBound = (SearchBound) obj;
                LatLonPoint latLonPoint = this.f7516d;
                if (latLonPoint == null) {
                    if (searchBound.f7516d != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(searchBound.f7516d)) {
                    return false;
                }
                if (this.f7518f != searchBound.f7518f) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.f7513a;
                if (latLonPoint2 == null) {
                    if (searchBound.f7513a != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(searchBound.f7513a)) {
                    return false;
                }
                LatLonPoint latLonPoint3 = this.f7514b;
                if (latLonPoint3 == null) {
                    if (searchBound.f7514b != null) {
                        return false;
                    }
                } else if (!latLonPoint3.equals(searchBound.f7514b)) {
                    return false;
                }
                List<LatLonPoint> list = this.f7519g;
                if (list == null) {
                    if (searchBound.f7519g != null) {
                        return false;
                    }
                } else if (!list.equals(searchBound.f7519g)) {
                    return false;
                }
                if (this.f7515c != searchBound.f7515c) {
                    return false;
                }
                String str = this.f7517e;
                if (str == null) {
                    if (searchBound.f7517e != null) {
                        return false;
                    }
                } else if (!str.equals(searchBound.f7517e)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f7516d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f7513a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f7519g;
        }

        public int getRange() {
            return this.f7515c;
        }

        public String getShape() {
            return this.f7517e;
        }

        public LatLonPoint getUpperRight() {
            return this.f7514b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f7516d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f7518f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f7513a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f7514b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f7519g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f7515c) * 31;
            String str = this.f7517e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f7518f;
        }

        /* renamed from: clone */
        public SearchBound m60118clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f7513a, this.f7514b, this.f7515c, this.f7516d, this.f7517e, this.f7519g, this.f7518f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i, boolean z) {
            this.f7517e = "Bound";
            this.f7515c = i;
            this.f7516d = latLonPoint;
            this.f7518f = z;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f7515c = TTAdConstant.STYLE_SIZE_RADIO_3_2;
            this.f7518f = true;
            this.f7517e = "Rectangle";
            m51846a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f7515c = TTAdConstant.STYLE_SIZE_RADIO_3_2;
            this.f7518f = true;
            this.f7517e = "Polygon";
            this.f7519g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z) {
            this.f7513a = latLonPoint;
            this.f7514b = latLonPoint2;
            this.f7515c = i;
            this.f7516d = latLonPoint3;
            this.f7517e = str;
            this.f7519g = list;
            this.f7518f = z;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ShowFields {
        public static final int ALL = -1;
        public static final int BUSINESS = 2;
        public static final int CHILDREN = 1;
        public static final int DEFAULT = 0;
        public static final int INDOOR = 4;
        public static final int NAVI = 8;
        public static final int PHOTOS = 16;
        public int value;

        ShowFields() {
            this.value = 0;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i) {
            this.value = i;
        }

        public ShowFields(int i) {
            this.value = i;
        }
    }

    public PoiSearchV2(Context context, Query query) throws AMapException {
        this.f7496a = null;
        try {
            this.f7496a = new PoiSearchCoreV2(context, query);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof AMapException) {
                throw ((AMapException) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m51850b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public SearchBound getBound() {
        IPoiSearchV2 iPoiSearchV2 = this.f7496a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getBound();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearchV2 iPoiSearchV2 = this.f7496a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getQuery();
        }
        return null;
    }

    public PoiResultV2 searchPOI() throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f7496a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearchV2 iPoiSearchV2 = this.f7496a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIAsyn();
        }
    }

    public PoiItemV2 searchPOIId(String str) throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f7496a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearchV2 iPoiSearchV2 = this.f7496a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearchV2 iPoiSearchV2 = this.f7496a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setBound(searchBound);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearchV2 iPoiSearchV2 = this.f7496a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearchV2 iPoiSearchV2 = this.f7496a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setQuery(query);
        }
    }
}
