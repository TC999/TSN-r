package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.r0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PoiSearchV2 {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";

    /* renamed from: a  reason: collision with root package name */
    private IPoiSearchV2 f11190a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItemV2 poiItemV2, int i4);

        void onPoiSearched(PoiResultV2 poiResultV2, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum PremiumType {
        DEFAULT(""),
        ENTIRETY("entirety_poi");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f11192a;

        PremiumType(String str) {
            this.f11192a = str;
        }

        final String a() {
            return this.f11192a;
        }

        static PremiumType a(String str) {
            PremiumType premiumType = DEFAULT;
            if (str.equals(premiumType.a())) {
                return premiumType;
            }
            PremiumType premiumType2 = ENTIRETY;
            return str.equals(premiumType2.a()) ? premiumType2 : premiumType;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Query implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        private String f11193a;

        /* renamed from: b  reason: collision with root package name */
        private String f11194b;

        /* renamed from: c  reason: collision with root package name */
        private String f11195c;

        /* renamed from: d  reason: collision with root package name */
        private int f11196d;

        /* renamed from: e  reason: collision with root package name */
        private int f11197e;

        /* renamed from: f  reason: collision with root package name */
        private String f11198f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f11199g;

        /* renamed from: h  reason: collision with root package name */
        private String f11200h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f11201i;

        /* renamed from: j  reason: collision with root package name */
        private LatLonPoint f11202j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f11203k;

        /* renamed from: l  reason: collision with root package name */
        private String f11204l;

        /* renamed from: m  reason: collision with root package name */
        private String f11205m;

        /* renamed from: n  reason: collision with root package name */
        private ShowFields f11206n;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        private static String a() {
            return "";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Query query = (Query) obj;
                String str = this.f11194b;
                if (str == null) {
                    if (query.f11194b != null) {
                        return false;
                    }
                } else if (!str.equals(query.f11194b)) {
                    return false;
                }
                String str2 = this.f11195c;
                if (str2 == null) {
                    if (query.f11195c != null) {
                        return false;
                    }
                } else if (!str2.equals(query.f11195c)) {
                    return false;
                }
                String str3 = this.f11198f;
                if (str3 == null) {
                    if (query.f11198f != null) {
                        return false;
                    }
                } else if (!str3.equals(query.f11198f)) {
                    return false;
                }
                if (this.f11196d == query.f11196d && this.f11197e == query.f11197e) {
                    String str4 = this.f11193a;
                    if (str4 == null) {
                        if (query.f11193a != null) {
                            return false;
                        }
                    } else if (!str4.equals(query.f11193a)) {
                        return false;
                    }
                    String str5 = this.f11204l;
                    if (str5 == null) {
                        if (query.f11204l != null) {
                            return false;
                        }
                    } else if (!str5.equals(query.f11204l)) {
                        return false;
                    }
                    String str6 = this.f11205m;
                    if (str6 == null) {
                        if (query.f11205m != null) {
                            return false;
                        }
                    } else if (!str6.equals(query.f11205m)) {
                        return false;
                    }
                    String str7 = this.f11200h;
                    if (str7 == null) {
                        if (query.f11200h != null) {
                            return false;
                        }
                    } else if (!str7.equals(query.f11200h)) {
                        return false;
                    }
                    if (this.f11199g == query.f11199g && this.f11203k == query.f11203k) {
                        int i4 = this.f11206n.value;
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public String getBuilding() {
            return this.f11200h;
        }

        public String getCategory() {
            String str = this.f11194b;
            if (str != null && !str.equals("00") && !this.f11194b.equals("00|")) {
                return this.f11194b;
            }
            return a();
        }

        public String getChannel() {
            return this.f11204l;
        }

        public String getCity() {
            return this.f11195c;
        }

        public boolean getCityLimit() {
            return this.f11199g;
        }

        public LatLonPoint getLocation() {
            return this.f11202j;
        }

        public int getPageNum() {
            return this.f11196d;
        }

        public int getPageSize() {
            return this.f11197e;
        }

        public String getPremium() {
            return this.f11205m;
        }

        protected String getQueryLanguage() {
            return this.f11198f;
        }

        public String getQueryString() {
            return this.f11193a;
        }

        public ShowFields getShowFields() {
            return this.f11206n;
        }

        public int hashCode() {
            String str = this.f11194b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f11204l;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f11205m;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f11195c;
            int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + (this.f11199g ? 1231 : 1237)) * 31;
            String str5 = this.f11198f;
            int hashCode5 = (((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f11196d) * 31) + this.f11197e) * 31;
            String str6 = this.f11193a;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.f11200h;
            return ((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + (this.f11206n.value % 1024);
        }

        public boolean isDistanceSort() {
            return this.f11201i;
        }

        public boolean isSpecial() {
            return this.f11203k;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearchV2.b(query.f11193a, this.f11193a) && PoiSearchV2.b(query.f11194b, this.f11194b) && PoiSearchV2.b(query.f11198f, this.f11198f) && PoiSearchV2.b(query.f11195c, this.f11195c) && PoiSearchV2.b(query.f11200h, this.f11200h) && PoiSearchV2.b(query.f11204l, this.f11204l) && PoiSearchV2.b(query.f11205m, this.f11205m) && query.f11199g == this.f11199g && query.f11197e == this.f11197e && query.f11201i == this.f11201i && query.f11203k == this.f11203k && query.f11206n.value == this.f11206n.value;
        }

        public void setBuilding(String str) {
            this.f11200h = str;
        }

        public void setChannel(String str) {
            this.f11204l = str;
        }

        public void setCityLimit(boolean z3) {
            this.f11199g = z3;
        }

        public void setDistanceSort(boolean z3) {
            this.f11201i = z3;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f11202j = latLonPoint;
        }

        public void setPageNum(int i4) {
            if (i4 <= 0) {
                i4 = 1;
            }
            this.f11196d = i4;
        }

        public void setPageSize(int i4) {
            if (i4 <= 0) {
                this.f11197e = 20;
            } else if (i4 > 30) {
                this.f11197e = 30;
            } else {
                this.f11197e = i4;
            }
        }

        public void setPremium(PremiumType premiumType) {
            if (premiumType == null) {
                return;
            }
            this.f11205m = premiumType.a();
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f11198f = "en";
            } else {
                this.f11198f = "zh-CN";
            }
        }

        public void setShowFields(ShowFields showFields) {
            if (showFields == null) {
                this.f11206n = new ShowFields();
            } else {
                this.f11206n = showFields;
            }
        }

        public void setSpecial(boolean z3) {
            this.f11203k = z3;
        }

        public Query(String str, String str2, String str3) {
            this.f11196d = 1;
            this.f11197e = 20;
            this.f11198f = "zh-CN";
            this.f11199g = false;
            this.f11201i = true;
            this.f11203k = true;
            this.f11205m = PremiumType.DEFAULT.a();
            this.f11206n = new ShowFields();
            this.f11193a = str;
            this.f11194b = str2;
            this.f11195c = str3;
        }

        /* renamed from: clone */
        public Query m38clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f11193a, this.f11194b, this.f11195c);
            query.setPageNum(this.f11196d);
            query.setPageSize(this.f11197e);
            query.setQueryLanguage(this.f11198f);
            query.setCityLimit(this.f11199g);
            query.setBuilding(this.f11200h);
            query.setLocation(this.f11202j);
            query.setDistanceSort(this.f11201i);
            query.setSpecial(this.f11203k);
            query.setChannel(this.f11204l);
            query.setPremium(PremiumType.a(this.f11205m));
            query.setShowFields(new ShowFields(this.f11206n.value));
            return query;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f11207a;

        /* renamed from: b  reason: collision with root package name */
        private LatLonPoint f11208b;

        /* renamed from: c  reason: collision with root package name */
        private int f11209c;

        /* renamed from: d  reason: collision with root package name */
        private LatLonPoint f11210d;

        /* renamed from: e  reason: collision with root package name */
        private String f11211e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11212f;

        /* renamed from: g  reason: collision with root package name */
        private List<LatLonPoint> f11213g;

        public SearchBound(LatLonPoint latLonPoint, int i4) {
            this.f11212f = true;
            this.f11211e = "Bound";
            this.f11209c = i4;
            this.f11210d = latLonPoint;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f11207a = latLonPoint;
            this.f11208b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f11208b.getLatitude() || this.f11207a.getLongitude() >= this.f11208b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f11210d = new LatLonPoint((this.f11207a.getLatitude() + this.f11208b.getLatitude()) / 2.0d, (this.f11207a.getLongitude() + this.f11208b.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SearchBound searchBound = (SearchBound) obj;
                LatLonPoint latLonPoint = this.f11210d;
                if (latLonPoint == null) {
                    if (searchBound.f11210d != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(searchBound.f11210d)) {
                    return false;
                }
                if (this.f11212f != searchBound.f11212f) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.f11207a;
                if (latLonPoint2 == null) {
                    if (searchBound.f11207a != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(searchBound.f11207a)) {
                    return false;
                }
                LatLonPoint latLonPoint3 = this.f11208b;
                if (latLonPoint3 == null) {
                    if (searchBound.f11208b != null) {
                        return false;
                    }
                } else if (!latLonPoint3.equals(searchBound.f11208b)) {
                    return false;
                }
                List<LatLonPoint> list = this.f11213g;
                if (list == null) {
                    if (searchBound.f11213g != null) {
                        return false;
                    }
                } else if (!list.equals(searchBound.f11213g)) {
                    return false;
                }
                if (this.f11209c != searchBound.f11209c) {
                    return false;
                }
                String str = this.f11211e;
                if (str == null) {
                    if (searchBound.f11211e != null) {
                        return false;
                    }
                } else if (!str.equals(searchBound.f11211e)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f11210d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f11207a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f11213g;
        }

        public int getRange() {
            return this.f11209c;
        }

        public String getShape() {
            return this.f11211e;
        }

        public LatLonPoint getUpperRight() {
            return this.f11208b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f11210d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f11212f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f11207a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f11208b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f11213g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f11209c) * 31;
            String str = this.f11211e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f11212f;
        }

        /* renamed from: clone */
        public SearchBound m39clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f11207a, this.f11208b, this.f11209c, this.f11210d, this.f11211e, this.f11213g, this.f11212f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i4, boolean z3) {
            this.f11211e = "Bound";
            this.f11209c = i4;
            this.f11210d = latLonPoint;
            this.f11212f = z3;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f11209c = 1500;
            this.f11212f = true;
            this.f11211e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f11209c = 1500;
            this.f11212f = true;
            this.f11211e = "Polygon";
            this.f11213g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i4, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z3) {
            this.f11207a = latLonPoint;
            this.f11208b = latLonPoint2;
            this.f11209c = i4;
            this.f11210d = latLonPoint3;
            this.f11211e = str;
            this.f11213g = list;
            this.f11212f = z3;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
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

        public void setValue(int i4) {
            this.value = i4;
        }

        public ShowFields(int i4) {
            this.value = i4;
        }
    }

    public PoiSearchV2(Context context, Query query) throws AMapException {
        this.f11190a = null;
        try {
            this.f11190a = new r0(context, query);
        } catch (Exception e4) {
            e4.printStackTrace();
            if (e4 instanceof AMapException) {
                throw ((AMapException) e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public SearchBound getBound() {
        IPoiSearchV2 iPoiSearchV2 = this.f11190a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getBound();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearchV2 iPoiSearchV2 = this.f11190a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getQuery();
        }
        return null;
    }

    public PoiResultV2 searchPOI() throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f11190a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearchV2 iPoiSearchV2 = this.f11190a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIAsyn();
        }
    }

    public PoiItemV2 searchPOIId(String str) throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f11190a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearchV2 iPoiSearchV2 = this.f11190a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearchV2 iPoiSearchV2 = this.f11190a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setBound(searchBound);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearchV2 iPoiSearchV2 = this.f11190a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearchV2 iPoiSearchV2 = this.f11190a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setQuery(query);
        }
    }
}
