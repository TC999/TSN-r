package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.q0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a  reason: collision with root package name */
    private IPoiSearch f11169a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItem poiItem, int i4);

        void onPoiSearched(PoiResult poiResult, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Query implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        private String f11170a;

        /* renamed from: b  reason: collision with root package name */
        private String f11171b;

        /* renamed from: c  reason: collision with root package name */
        private String f11172c;

        /* renamed from: d  reason: collision with root package name */
        private int f11173d;

        /* renamed from: e  reason: collision with root package name */
        private int f11174e;

        /* renamed from: f  reason: collision with root package name */
        private String f11175f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f11176g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f11177h;

        /* renamed from: i  reason: collision with root package name */
        private String f11178i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f11179j;

        /* renamed from: k  reason: collision with root package name */
        private LatLonPoint f11180k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f11181l;

        /* renamed from: m  reason: collision with root package name */
        private String f11182m;

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
                String str = this.f11171b;
                if (str == null) {
                    if (query.f11171b != null) {
                        return false;
                    }
                } else if (!str.equals(query.f11171b)) {
                    return false;
                }
                String str2 = this.f11172c;
                if (str2 == null) {
                    if (query.f11172c != null) {
                        return false;
                    }
                } else if (!str2.equals(query.f11172c)) {
                    return false;
                }
                String str3 = this.f11175f;
                if (str3 == null) {
                    if (query.f11175f != null) {
                        return false;
                    }
                } else if (!str3.equals(query.f11175f)) {
                    return false;
                }
                if (this.f11173d == query.f11173d && this.f11174e == query.f11174e) {
                    String str4 = this.f11170a;
                    if (str4 == null) {
                        if (query.f11170a != null) {
                            return false;
                        }
                    } else if (!str4.equals(query.f11170a)) {
                        return false;
                    }
                    String str5 = this.f11178i;
                    if (str5 == null) {
                        if (query.f11178i != null) {
                            return false;
                        }
                    } else if (!str5.equals(query.f11178i)) {
                        return false;
                    }
                    if (this.f11176g == query.f11176g && this.f11177h == query.f11177h && this.f11181l == query.f11181l) {
                        String str6 = this.f11182m;
                        if (str6 == null) {
                            if (query.f11182m != null) {
                                return false;
                            }
                        } else if (!str6.equals(query.f11182m)) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public String getBuilding() {
            return this.f11178i;
        }

        public String getCategory() {
            String str = this.f11171b;
            if (str != null && !str.equals("00") && !this.f11171b.equals("00|")) {
                return this.f11171b;
            }
            return a();
        }

        public String getCity() {
            return this.f11172c;
        }

        public boolean getCityLimit() {
            return this.f11176g;
        }

        public String getExtensions() {
            return this.f11182m;
        }

        public LatLonPoint getLocation() {
            return this.f11180k;
        }

        public int getPageNum() {
            return this.f11173d;
        }

        public int getPageSize() {
            return this.f11174e;
        }

        protected String getQueryLanguage() {
            return this.f11175f;
        }

        public String getQueryString() {
            return this.f11170a;
        }

        public int hashCode() {
            String str = this.f11171b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f11172c;
            int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.f11176g ? 1231 : 1237)) * 31) + (this.f11177h ? 1231 : 1237)) * 31;
            String str3 = this.f11175f;
            int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f11173d) * 31) + this.f11174e) * 31;
            String str4 = this.f11170a;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f11178i;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f11179j;
        }

        public boolean isRequireSubPois() {
            return this.f11177h;
        }

        public boolean isSpecial() {
            return this.f11181l;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearch.b(query.f11170a, this.f11170a) && PoiSearch.b(query.f11171b, this.f11171b) && PoiSearch.b(query.f11175f, this.f11175f) && PoiSearch.b(query.f11172c, this.f11172c) && PoiSearch.b(query.f11182m, this.f11182m) && PoiSearch.b(query.f11178i, this.f11178i) && query.f11176g == this.f11176g && query.f11174e == this.f11174e && query.f11179j == this.f11179j && query.f11181l == this.f11181l;
        }

        public void requireSubPois(boolean z3) {
            this.f11177h = z3;
        }

        public void setBuilding(String str) {
            this.f11178i = str;
        }

        public void setCityLimit(boolean z3) {
            this.f11176g = z3;
        }

        public void setDistanceSort(boolean z3) {
            this.f11179j = z3;
        }

        public void setExtensions(String str) {
            this.f11182m = str;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f11180k = latLonPoint;
        }

        public void setPageNum(int i4) {
            if (i4 <= 0) {
                i4 = 1;
            }
            this.f11173d = i4;
        }

        public void setPageSize(int i4) {
            if (i4 <= 0) {
                this.f11174e = 20;
            } else if (i4 > 30) {
                this.f11174e = 30;
            } else {
                this.f11174e = i4;
            }
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f11175f = "en";
            } else {
                this.f11175f = "zh-CN";
            }
        }

        public void setSpecial(boolean z3) {
            this.f11181l = z3;
        }

        public Query(String str, String str2, String str3) {
            this.f11173d = 1;
            this.f11174e = 20;
            this.f11175f = "zh-CN";
            this.f11176g = false;
            this.f11177h = false;
            this.f11179j = true;
            this.f11181l = true;
            this.f11182m = "base";
            this.f11170a = str;
            this.f11171b = str2;
            this.f11172c = str3;
        }

        /* renamed from: clone */
        public Query m36clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f11170a, this.f11171b, this.f11172c);
            query.setPageNum(this.f11173d);
            query.setPageSize(this.f11174e);
            query.setQueryLanguage(this.f11175f);
            query.setCityLimit(this.f11176g);
            query.requireSubPois(this.f11177h);
            query.setBuilding(this.f11178i);
            query.setLocation(this.f11180k);
            query.setDistanceSort(this.f11179j);
            query.setSpecial(this.f11181l);
            query.setExtensions(this.f11182m);
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
        private LatLonPoint f11183a;

        /* renamed from: b  reason: collision with root package name */
        private LatLonPoint f11184b;

        /* renamed from: c  reason: collision with root package name */
        private int f11185c;

        /* renamed from: d  reason: collision with root package name */
        private LatLonPoint f11186d;

        /* renamed from: e  reason: collision with root package name */
        private String f11187e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11188f;

        /* renamed from: g  reason: collision with root package name */
        private List<LatLonPoint> f11189g;

        public SearchBound(LatLonPoint latLonPoint, int i4) {
            this.f11188f = true;
            this.f11187e = "Bound";
            this.f11185c = i4;
            this.f11186d = latLonPoint;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f11183a = latLonPoint;
            this.f11184b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f11184b.getLatitude() || this.f11183a.getLongitude() >= this.f11184b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f11186d = new LatLonPoint((this.f11183a.getLatitude() + this.f11184b.getLatitude()) / 2.0d, (this.f11183a.getLongitude() + this.f11184b.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SearchBound searchBound = (SearchBound) obj;
                LatLonPoint latLonPoint = this.f11186d;
                if (latLonPoint == null) {
                    if (searchBound.f11186d != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(searchBound.f11186d)) {
                    return false;
                }
                if (this.f11188f != searchBound.f11188f) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.f11183a;
                if (latLonPoint2 == null) {
                    if (searchBound.f11183a != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(searchBound.f11183a)) {
                    return false;
                }
                LatLonPoint latLonPoint3 = this.f11184b;
                if (latLonPoint3 == null) {
                    if (searchBound.f11184b != null) {
                        return false;
                    }
                } else if (!latLonPoint3.equals(searchBound.f11184b)) {
                    return false;
                }
                List<LatLonPoint> list = this.f11189g;
                if (list == null) {
                    if (searchBound.f11189g != null) {
                        return false;
                    }
                } else if (!list.equals(searchBound.f11189g)) {
                    return false;
                }
                if (this.f11185c != searchBound.f11185c) {
                    return false;
                }
                String str = this.f11187e;
                if (str == null) {
                    if (searchBound.f11187e != null) {
                        return false;
                    }
                } else if (!str.equals(searchBound.f11187e)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f11186d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f11183a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f11189g;
        }

        public int getRange() {
            return this.f11185c;
        }

        public String getShape() {
            return this.f11187e;
        }

        public LatLonPoint getUpperRight() {
            return this.f11184b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f11186d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f11188f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f11183a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f11184b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f11189g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f11185c) * 31;
            String str = this.f11187e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f11188f;
        }

        /* renamed from: clone */
        public SearchBound m37clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                j4.i(e4, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f11183a, this.f11184b, this.f11185c, this.f11186d, this.f11187e, this.f11189g, this.f11188f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i4, boolean z3) {
            this.f11187e = "Bound";
            this.f11185c = i4;
            this.f11186d = latLonPoint;
            this.f11188f = z3;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f11185c = 1500;
            this.f11188f = true;
            this.f11187e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f11185c = 1500;
            this.f11188f = true;
            this.f11187e = "Polygon";
            this.f11189g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i4, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z3) {
            this.f11183a = latLonPoint;
            this.f11184b = latLonPoint2;
            this.f11185c = i4;
            this.f11186d = latLonPoint3;
            this.f11187e = str;
            this.f11189g = list;
            this.f11188f = z3;
        }
    }

    public PoiSearch(Context context, Query query) throws AMapException {
        this.f11169a = null;
        try {
            this.f11169a = new q0(context, query);
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
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            return iPoiSearch.getBound();
        }
        return null;
    }

    public String getLanguage() {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            return iPoiSearch.getLanguage();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            return iPoiSearch.getQuery();
        }
        return null;
    }

    public PoiResult searchPOI() throws AMapException {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIAsyn();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            iPoiSearch.setBound(searchBound);
        }
    }

    public void setLanguage(String str) {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            iPoiSearch.setLanguage(str);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            iPoiSearch.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearch iPoiSearch = this.f11169a;
        if (iPoiSearch != null) {
            iPoiSearch.setQuery(query);
        }
    }
}
