package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.p047s.C2082j4;
import com.amap.api.col.p047s.CloudSearchCore;
import com.amap.api.col.p047s.QueryFilterNum;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CloudSearch {

    /* renamed from: a */
    private ICloudSearch f7244a;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i);

        void onCloudSearched(CloudResult cloudResult, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Query implements Cloneable {

        /* renamed from: a */
        private String f7245a;

        /* renamed from: d */
        private String f7248d;

        /* renamed from: e */
        private SearchBound f7249e;

        /* renamed from: f */
        private Sortingrules f7250f;

        /* renamed from: b */
        private int f7246b = 1;

        /* renamed from: c */
        private int f7247c = 20;

        /* renamed from: g */
        private ArrayList<QueryFilterNum> f7251g = new ArrayList<>();

        /* renamed from: h */
        private List<String> f7252h = new ArrayList();

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (!C2082j4.m52824j(str) && searchBound != null) {
                this.f7248d = str;
                this.f7245a = str2;
                this.f7249e = searchBound;
                return;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }

        /* renamed from: a */
        private ArrayList<QueryFilterNum> m51898a() {
            if (this.f7251g == null) {
                return null;
            }
            ArrayList<QueryFilterNum> arrayList = new ArrayList<>();
            arrayList.addAll(this.f7251g);
            return arrayList;
        }

        /* renamed from: b */
        private ArrayList<String> m51895b() {
            if (this.f7252h == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(this.f7252h);
            return arrayList;
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.f7251g.add(new QueryFilterNum(str, str2, str3));
        }

        public void addFilterString(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            List<String> list = this.f7252h;
            list.add(str + str2);
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Query)) {
                if (obj == this) {
                    return true;
                }
                Query query = (Query) obj;
                if (queryEquals(query) && query.f7246b == this.f7246b) {
                    return true;
                }
            }
            return false;
        }

        public SearchBound getBound() {
            return this.f7249e;
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f7251g.size();
                for (int i = 0; i < size; i++) {
                    QueryFilterNum queryFilterNum = this.f7251g.get(i);
                    stringBuffer.append(queryFilterNum.m52930a());
                    stringBuffer.append(">=");
                    stringBuffer.append(queryFilterNum.m52929b());
                    stringBuffer.append("&&");
                    stringBuffer.append(queryFilterNum.m52930a());
                    stringBuffer.append("<=");
                    stringBuffer.append(queryFilterNum.m52928c());
                    if (i != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public String getFilterString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f7252h.size();
                for (int i = 0; i < size; i++) {
                    stringBuffer.append(this.f7252h.get(i));
                    if (i != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public int getPageNum() {
            return this.f7246b;
        }

        public int getPageSize() {
            return this.f7247c;
        }

        public String getQueryString() {
            return this.f7245a;
        }

        public Sortingrules getSortingrules() {
            return this.f7250f;
        }

        public String getTableID() {
            return this.f7248d;
        }

        public int hashCode() {
            ArrayList<QueryFilterNum> arrayList = this.f7251g;
            int hashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
            List<String> list = this.f7252h;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            SearchBound searchBound = this.f7249e;
            int hashCode3 = (((((hashCode2 + (searchBound == null ? 0 : searchBound.hashCode())) * 31) + this.f7246b) * 31) + this.f7247c) * 31;
            String str = this.f7245a;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Sortingrules sortingrules = this.f7250f;
            int hashCode5 = (hashCode4 + (sortingrules == null ? 0 : sortingrules.hashCode())) * 31;
            String str2 = this.f7248d;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return CloudSearch.m51899b(query.f7245a, this.f7245a) && CloudSearch.m51899b(query.getTableID(), getTableID()) && CloudSearch.m51899b(query.getFilterString(), getFilterString()) && CloudSearch.m51899b(query.getFilterNumString(), getFilterNumString()) && query.f7247c == this.f7247c && m51897a(query.getBound(), getBound()) && m51896a(query.getSortingrules(), getSortingrules());
        }

        public void setBound(SearchBound searchBound) {
            this.f7249e = searchBound;
        }

        public void setPageNum(int i) {
            this.f7246b = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.f7247c = 20;
            } else if (i > 100) {
                this.f7247c = 100;
            } else {
                this.f7247c = i;
            }
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f7250f = sortingrules;
        }

        public void setTableID(String str) {
            this.f7248d = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0043 A[RETURN] */
        /* renamed from: clone */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.amap.api.services.cloud.CloudSearch.Query m60112clone() {
            /*
                r6 = this;
                super.clone()     // Catch: java.lang.CloneNotSupportedException -> L4
                goto L8
            L4:
                r0 = move-exception
                r0.printStackTrace()
            L8:
                r0 = 0
                com.amap.api.services.cloud.CloudSearch$Query r1 = new com.amap.api.services.cloud.CloudSearch$Query     // Catch: com.amap.api.services.core.AMapException -> L34
                java.lang.String r2 = r6.f7248d     // Catch: com.amap.api.services.core.AMapException -> L34
                java.lang.String r3 = r6.f7245a     // Catch: com.amap.api.services.core.AMapException -> L34
                com.amap.api.services.cloud.CloudSearch$SearchBound r4 = r6.f7249e     // Catch: com.amap.api.services.core.AMapException -> L34
                r1.<init>(r2, r3, r4)     // Catch: com.amap.api.services.core.AMapException -> L34
                int r0 = r6.f7246b     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setPageNum(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                int r0 = r6.f7247c     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setPageSize(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                com.amap.api.services.cloud.CloudSearch$Sortingrules r0 = r6.getSortingrules()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setSortingrules(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                java.util.ArrayList r0 = r6.m51898a()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.f7251g = r0     // Catch: com.amap.api.services.core.AMapException -> L32
                java.util.ArrayList r0 = r6.m51895b()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.f7252h = r0     // Catch: com.amap.api.services.core.AMapException -> L32
                goto L3b
            L32:
                r0 = move-exception
                goto L38
            L34:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L38:
                r0.printStackTrace()
            L3b:
                if (r1 != 0) goto L43
                com.amap.api.services.cloud.CloudSearch$Query r0 = new com.amap.api.services.cloud.CloudSearch$Query
                r0.<init>()
                return r0
            L43:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.cloud.CloudSearch.Query.m60112clone():com.amap.api.services.cloud.CloudSearch$Query");
        }

        /* renamed from: a */
        private static boolean m51897a(SearchBound searchBound, SearchBound searchBound2) {
            if (searchBound == null && searchBound2 == null) {
                return true;
            }
            if (searchBound == null || searchBound2 == null) {
                return false;
            }
            return searchBound.equals(searchBound2);
        }

        /* renamed from: a */
        private static boolean m51896a(Sortingrules sortingrules, Sortingrules sortingrules2) {
            if (sortingrules == null && sortingrules2 == null) {
                return true;
            }
            if (sortingrules == null || sortingrules2 == null) {
                return false;
            }
            return sortingrules.equals(sortingrules2);
        }

        private Query() {
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a */
        private LatLonPoint f7253a;

        /* renamed from: b */
        private LatLonPoint f7254b;

        /* renamed from: c */
        private int f7255c;

        /* renamed from: d */
        private LatLonPoint f7256d;

        /* renamed from: e */
        private String f7257e;

        /* renamed from: f */
        private List<LatLonPoint> f7258f;

        /* renamed from: g */
        private String f7259g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.f7257e = "Bound";
            this.f7255c = i;
            this.f7256d = latLonPoint;
        }

        /* renamed from: a */
        private boolean m51893a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f7253a = latLonPoint;
            this.f7254b = latLonPoint2;
            return latLonPoint != null && latLonPoint2 != null && latLonPoint.getLatitude() < this.f7254b.getLatitude() && this.f7253a.getLongitude() < this.f7254b.getLongitude();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof SearchBound)) {
                SearchBound searchBound = (SearchBound) obj;
                if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                    return false;
                }
                if (getShape().equals("Bound")) {
                    return searchBound.f7256d.equals(this.f7256d) && searchBound.f7255c == this.f7255c;
                } else if (getShape().equals("Polygon")) {
                    return m51892a(searchBound.f7258f, this.f7258f);
                } else {
                    if (getShape().equals(LOCAL_SHAPE)) {
                        return searchBound.f7259g.equals(this.f7259g);
                    }
                    if (searchBound.f7253a.equals(this.f7253a) && searchBound.f7254b.equals(this.f7254b)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f7256d;
        }

        public String getCity() {
            return this.f7259g;
        }

        public LatLonPoint getLowerLeft() {
            return this.f7253a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f7258f;
        }

        public int getRange() {
            return this.f7255c;
        }

        public String getShape() {
            return this.f7257e;
        }

        public LatLonPoint getUpperRight() {
            return this.f7254b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f7256d;
            int hashCode = ((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint2 = this.f7253a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f7254b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f7258f;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f7255c) * 31;
            String str = this.f7257e;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f7259g;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        /* renamed from: clone */
        public SearchBound m60113clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            if (getShape().equals("Bound")) {
                return new SearchBound(this.f7256d, this.f7255c);
            }
            if (getShape().equals("Polygon")) {
                return new SearchBound(m51894a());
            }
            if (getShape().equals(LOCAL_SHAPE)) {
                return new SearchBound(this.f7259g);
            }
            return new SearchBound(this.f7253a, this.f7254b);
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f7257e = "Rectangle";
            if (m51893a(latLonPoint, latLonPoint2)) {
                return;
            }
            new IllegalArgumentException("invalid rect ").printStackTrace();
        }

        /* renamed from: a */
        private static boolean m51892a(List<LatLonPoint> list, List<LatLonPoint> list2) {
            if (list == null && list2 == null) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!list.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        private List<LatLonPoint> m51894a() {
            if (this.f7258f == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LatLonPoint latLonPoint : this.f7258f) {
                arrayList.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
            }
            return arrayList;
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f7257e = "Polygon";
            this.f7258f = list;
        }

        public SearchBound(String str) {
            this.f7257e = LOCAL_SHAPE;
            this.f7259g = str;
        }
    }

    public CloudSearch(Context context) throws AMapException {
        if (this.f7244a == null) {
            try {
                this.f7244a = new CloudSearchCore(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m51899b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.f7244a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.f7244a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.f7244a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;

        /* renamed from: a */
        private int f7260a;

        /* renamed from: b */
        private String f7261b;

        /* renamed from: c */
        private boolean f7262c;

        public Sortingrules(String str, boolean z) {
            this.f7260a = 0;
            this.f7261b = str;
            this.f7262c = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Sortingrules sortingrules = (Sortingrules) obj;
                if (this.f7262c != sortingrules.f7262c) {
                    return false;
                }
                String str = this.f7261b;
                if (str == null) {
                    if (sortingrules.f7261b != null) {
                        return false;
                    }
                } else if (!str.equals(sortingrules.f7261b)) {
                    return false;
                }
                return this.f7260a == sortingrules.f7260a;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f7262c ? 1231 : 1237) + 31) * 31;
            String str = this.f7261b;
            return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.f7260a;
        }

        public String toString() {
            if (C2082j4.m52824j(this.f7261b)) {
                int i = this.f7260a;
                return i == 0 ? "_weight:desc" : i == 1 ? "_distance:asc" : "";
            } else if (this.f7262c) {
                return this.f7261b + ":asc";
            } else {
                return this.f7261b + ":desc";
            }
        }

        public Sortingrules(int i) {
            this.f7262c = true;
            this.f7260a = i;
        }
    }
}
