package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.p047s.C2082j4;
import com.amap.api.col.p047s.PoiSearchCore;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a */
    private IPoiSearch f7475a;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItem poiItem, int i);

        void onPoiSearched(PoiResult poiResult, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Query implements Cloneable {

        /* renamed from: a */
        private String f7476a;

        /* renamed from: b */
        private String f7477b;

        /* renamed from: c */
        private String f7478c;

        /* renamed from: d */
        private int f7479d;

        /* renamed from: e */
        private int f7480e;

        /* renamed from: f */
        private String f7481f;

        /* renamed from: g */
        private boolean f7482g;

        /* renamed from: h */
        private boolean f7483h;

        /* renamed from: i */
        private String f7484i;

        /* renamed from: j */
        private boolean f7485j;

        /* renamed from: k */
        private LatLonPoint f7486k;

        /* renamed from: l */
        private boolean f7487l;

        /* renamed from: m */
        private String f7488m;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        /* renamed from: a */
        private static String m51853a() {
            return "";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Query query = (Query) obj;
                String str = this.f7477b;
                if (str == null) {
                    if (query.f7477b != null) {
                        return false;
                    }
                } else if (!str.equals(query.f7477b)) {
                    return false;
                }
                String str2 = this.f7478c;
                if (str2 == null) {
                    if (query.f7478c != null) {
                        return false;
                    }
                } else if (!str2.equals(query.f7478c)) {
                    return false;
                }
                String str3 = this.f7481f;
                if (str3 == null) {
                    if (query.f7481f != null) {
                        return false;
                    }
                } else if (!str3.equals(query.f7481f)) {
                    return false;
                }
                if (this.f7479d == query.f7479d && this.f7480e == query.f7480e) {
                    String str4 = this.f7476a;
                    if (str4 == null) {
                        if (query.f7476a != null) {
                            return false;
                        }
                    } else if (!str4.equals(query.f7476a)) {
                        return false;
                    }
                    String str5 = this.f7484i;
                    if (str5 == null) {
                        if (query.f7484i != null) {
                            return false;
                        }
                    } else if (!str5.equals(query.f7484i)) {
                        return false;
                    }
                    if (this.f7482g == query.f7482g && this.f7483h == query.f7483h && this.f7487l == query.f7487l) {
                        String str6 = this.f7488m;
                        if (str6 == null) {
                            if (query.f7488m != null) {
                                return false;
                            }
                        } else if (!str6.equals(query.f7488m)) {
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
            return this.f7484i;
        }

        public String getCategory() {
            String str = this.f7477b;
            if (str != null && !str.equals("00") && !this.f7477b.equals("00|")) {
                return this.f7477b;
            }
            return m51853a();
        }

        public String getCity() {
            return this.f7478c;
        }

        public boolean getCityLimit() {
            return this.f7482g;
        }

        public String getExtensions() {
            return this.f7488m;
        }

        public LatLonPoint getLocation() {
            return this.f7486k;
        }

        public int getPageNum() {
            return this.f7479d;
        }

        public int getPageSize() {
            return this.f7480e;
        }

        protected String getQueryLanguage() {
            return this.f7481f;
        }

        public String getQueryString() {
            return this.f7476a;
        }

        public int hashCode() {
            String str = this.f7477b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f7478c;
            int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.f7482g ? 1231 : 1237)) * 31) + (this.f7483h ? 1231 : 1237)) * 31;
            String str3 = this.f7481f;
            int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f7479d) * 31) + this.f7480e) * 31;
            String str4 = this.f7476a;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f7484i;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f7485j;
        }

        public boolean isRequireSubPois() {
            return this.f7483h;
        }

        public boolean isSpecial() {
            return this.f7487l;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearch.m51854b(query.f7476a, this.f7476a) && PoiSearch.m51854b(query.f7477b, this.f7477b) && PoiSearch.m51854b(query.f7481f, this.f7481f) && PoiSearch.m51854b(query.f7478c, this.f7478c) && PoiSearch.m51854b(query.f7488m, this.f7488m) && PoiSearch.m51854b(query.f7484i, this.f7484i) && query.f7482g == this.f7482g && query.f7480e == this.f7480e && query.f7485j == this.f7485j && query.f7487l == this.f7487l;
        }

        public void requireSubPois(boolean z) {
            this.f7483h = z;
        }

        public void setBuilding(String str) {
            this.f7484i = str;
        }

        public void setCityLimit(boolean z) {
            this.f7482g = z;
        }

        public void setDistanceSort(boolean z) {
            this.f7485j = z;
        }

        public void setExtensions(String str) {
            this.f7488m = str;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f7486k = latLonPoint;
        }

        public void setPageNum(int i) {
            if (i <= 0) {
                i = 1;
            }
            this.f7479d = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.f7480e = 20;
            } else if (i > 30) {
                this.f7480e = 30;
            } else {
                this.f7480e = i;
            }
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f7481f = "en";
            } else {
                this.f7481f = "zh-CN";
            }
        }

        public void setSpecial(boolean z) {
            this.f7487l = z;
        }

        public Query(String str, String str2, String str3) {
            this.f7479d = 1;
            this.f7480e = 20;
            this.f7481f = "zh-CN";
            this.f7482g = false;
            this.f7483h = false;
            this.f7485j = true;
            this.f7487l = true;
            this.f7488m = "base";
            this.f7476a = str;
            this.f7477b = str2;
            this.f7478c = str3;
        }

        /* renamed from: clone */
        public Query m60115clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f7476a, this.f7477b, this.f7478c);
            query.setPageNum(this.f7479d);
            query.setPageSize(this.f7480e);
            query.setQueryLanguage(this.f7481f);
            query.setCityLimit(this.f7482g);
            query.requireSubPois(this.f7483h);
            query.setBuilding(this.f7484i);
            query.setLocation(this.f7486k);
            query.setDistanceSort(this.f7485j);
            query.setSpecial(this.f7487l);
            query.setExtensions(this.f7488m);
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
        private LatLonPoint f7489a;

        /* renamed from: b */
        private LatLonPoint f7490b;

        /* renamed from: c */
        private int f7491c;

        /* renamed from: d */
        private LatLonPoint f7492d;

        /* renamed from: e */
        private String f7493e;

        /* renamed from: f */
        private boolean f7494f;

        /* renamed from: g */
        private List<LatLonPoint> f7495g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.f7494f = true;
            this.f7493e = "Bound";
            this.f7491c = i;
            this.f7492d = latLonPoint;
        }

        /* renamed from: a */
        private void m51852a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f7489a = latLonPoint;
            this.f7490b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f7490b.getLatitude() || this.f7489a.getLongitude() >= this.f7490b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f7492d = new LatLonPoint((this.f7489a.getLatitude() + this.f7490b.getLatitude()) / 2.0d, (this.f7489a.getLongitude() + this.f7490b.getLongitude()) / 2.0d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SearchBound searchBound = (SearchBound) obj;
                LatLonPoint latLonPoint = this.f7492d;
                if (latLonPoint == null) {
                    if (searchBound.f7492d != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(searchBound.f7492d)) {
                    return false;
                }
                if (this.f7494f != searchBound.f7494f) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.f7489a;
                if (latLonPoint2 == null) {
                    if (searchBound.f7489a != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(searchBound.f7489a)) {
                    return false;
                }
                LatLonPoint latLonPoint3 = this.f7490b;
                if (latLonPoint3 == null) {
                    if (searchBound.f7490b != null) {
                        return false;
                    }
                } else if (!latLonPoint3.equals(searchBound.f7490b)) {
                    return false;
                }
                List<LatLonPoint> list = this.f7495g;
                if (list == null) {
                    if (searchBound.f7495g != null) {
                        return false;
                    }
                } else if (!list.equals(searchBound.f7495g)) {
                    return false;
                }
                if (this.f7491c != searchBound.f7491c) {
                    return false;
                }
                String str = this.f7493e;
                if (str == null) {
                    if (searchBound.f7493e != null) {
                        return false;
                    }
                } else if (!str.equals(searchBound.f7493e)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f7492d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f7489a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f7495g;
        }

        public int getRange() {
            return this.f7491c;
        }

        public String getShape() {
            return this.f7493e;
        }

        public LatLonPoint getUpperRight() {
            return this.f7490b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f7492d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f7494f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f7489a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f7490b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f7495g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f7491c) * 31;
            String str = this.f7493e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f7494f;
        }

        /* renamed from: clone */
        public SearchBound m60116clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                C2082j4.m52825i(e, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f7489a, this.f7490b, this.f7491c, this.f7492d, this.f7493e, this.f7495g, this.f7494f);
        }

        public SearchBound(LatLonPoint latLonPoint, int i, boolean z) {
            this.f7493e = "Bound";
            this.f7491c = i;
            this.f7492d = latLonPoint;
            this.f7494f = z;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f7491c = TTAdConstant.STYLE_SIZE_RADIO_3_2;
            this.f7494f = true;
            this.f7493e = "Rectangle";
            m51852a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f7491c = TTAdConstant.STYLE_SIZE_RADIO_3_2;
            this.f7494f = true;
            this.f7493e = "Polygon";
            this.f7495g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z) {
            this.f7489a = latLonPoint;
            this.f7490b = latLonPoint2;
            this.f7491c = i;
            this.f7492d = latLonPoint3;
            this.f7493e = str;
            this.f7495g = list;
            this.f7494f = z;
        }
    }

    public PoiSearch(Context context, Query query) throws AMapException {
        this.f7475a = null;
        try {
            this.f7475a = new PoiSearchCore(context, query);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof AMapException) {
                throw ((AMapException) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m51854b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public SearchBound getBound() {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            return iPoiSearch.getBound();
        }
        return null;
    }

    public String getLanguage() {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            return iPoiSearch.getLanguage();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            return iPoiSearch.getQuery();
        }
        return null;
    }

    public PoiResult searchPOI() throws AMapException {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIAsyn();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            iPoiSearch.setBound(searchBound);
        }
    }

    public void setLanguage(String str) {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            iPoiSearch.setLanguage(str);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            iPoiSearch.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearch iPoiSearch = this.f7475a;
        if (iPoiSearch != null) {
            iPoiSearch.setQuery(query);
        }
    }
}
