package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.s.i;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.k0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CloudSearch {

    /* renamed from: a  reason: collision with root package name */
    private ICloudSearch f10940a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i4);

        void onCloudSearched(CloudResult cloudResult, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Query implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        private String f10941a;

        /* renamed from: d  reason: collision with root package name */
        private String f10944d;

        /* renamed from: e  reason: collision with root package name */
        private SearchBound f10945e;

        /* renamed from: f  reason: collision with root package name */
        private Sortingrules f10946f;

        /* renamed from: b  reason: collision with root package name */
        private int f10942b = 1;

        /* renamed from: c  reason: collision with root package name */
        private int f10943c = 20;

        /* renamed from: g  reason: collision with root package name */
        private ArrayList<i> f10947g = new ArrayList<>();

        /* renamed from: h  reason: collision with root package name */
        private List<String> f10948h = new ArrayList();

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (!j4.j(str) && searchBound != null) {
                this.f10944d = str;
                this.f10941a = str2;
                this.f10945e = searchBound;
                return;
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        }

        private ArrayList<i> a() {
            if (this.f10947g == null) {
                return null;
            }
            ArrayList<i> arrayList = new ArrayList<>();
            arrayList.addAll(this.f10947g);
            return arrayList;
        }

        private ArrayList<String> b() {
            if (this.f10948h == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(this.f10948h);
            return arrayList;
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.f10947g.add(new i(str, str2, str3));
        }

        public void addFilterString(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            List<String> list = this.f10948h;
            list.add(str + str2);
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Query)) {
                if (obj == this) {
                    return true;
                }
                Query query = (Query) obj;
                if (queryEquals(query) && query.f10942b == this.f10942b) {
                    return true;
                }
            }
            return false;
        }

        public SearchBound getBound() {
            return this.f10945e;
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f10947g.size();
                for (int i4 = 0; i4 < size; i4++) {
                    i iVar = this.f10947g.get(i4);
                    stringBuffer.append(iVar.a());
                    stringBuffer.append(">=");
                    stringBuffer.append(iVar.b());
                    stringBuffer.append("&&");
                    stringBuffer.append(iVar.a());
                    stringBuffer.append("<=");
                    stringBuffer.append(iVar.c());
                    if (i4 != size - 1) {
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
                int size = this.f10948h.size();
                for (int i4 = 0; i4 < size; i4++) {
                    stringBuffer.append(this.f10948h.get(i4));
                    if (i4 != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public int getPageNum() {
            return this.f10942b;
        }

        public int getPageSize() {
            return this.f10943c;
        }

        public String getQueryString() {
            return this.f10941a;
        }

        public Sortingrules getSortingrules() {
            return this.f10946f;
        }

        public String getTableID() {
            return this.f10944d;
        }

        public int hashCode() {
            ArrayList<i> arrayList = this.f10947g;
            int hashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
            List<String> list = this.f10948h;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            SearchBound searchBound = this.f10945e;
            int hashCode3 = (((((hashCode2 + (searchBound == null ? 0 : searchBound.hashCode())) * 31) + this.f10942b) * 31) + this.f10943c) * 31;
            String str = this.f10941a;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Sortingrules sortingrules = this.f10946f;
            int hashCode5 = (hashCode4 + (sortingrules == null ? 0 : sortingrules.hashCode())) * 31;
            String str2 = this.f10944d;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return CloudSearch.b(query.f10941a, this.f10941a) && CloudSearch.b(query.getTableID(), getTableID()) && CloudSearch.b(query.getFilterString(), getFilterString()) && CloudSearch.b(query.getFilterNumString(), getFilterNumString()) && query.f10943c == this.f10943c && a(query.getBound(), getBound()) && a(query.getSortingrules(), getSortingrules());
        }

        public void setBound(SearchBound searchBound) {
            this.f10945e = searchBound;
        }

        public void setPageNum(int i4) {
            this.f10942b = i4;
        }

        public void setPageSize(int i4) {
            if (i4 <= 0) {
                this.f10943c = 20;
            } else if (i4 > 100) {
                this.f10943c = 100;
            } else {
                this.f10943c = i4;
            }
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f10946f = sortingrules;
        }

        public void setTableID(String str) {
            this.f10944d = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0043 A[RETURN] */
        /* renamed from: clone */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.amap.api.services.cloud.CloudSearch.Query m33clone() {
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
                java.lang.String r2 = r6.f10944d     // Catch: com.amap.api.services.core.AMapException -> L34
                java.lang.String r3 = r6.f10941a     // Catch: com.amap.api.services.core.AMapException -> L34
                com.amap.api.services.cloud.CloudSearch$SearchBound r4 = r6.f10945e     // Catch: com.amap.api.services.core.AMapException -> L34
                r1.<init>(r2, r3, r4)     // Catch: com.amap.api.services.core.AMapException -> L34
                int r0 = r6.f10942b     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setPageNum(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                int r0 = r6.f10943c     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setPageSize(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                com.amap.api.services.cloud.CloudSearch$Sortingrules r0 = r6.getSortingrules()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setSortingrules(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                java.util.ArrayList r0 = r6.a()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.f10947g = r0     // Catch: com.amap.api.services.core.AMapException -> L32
                java.util.ArrayList r0 = r6.b()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.f10948h = r0     // Catch: com.amap.api.services.core.AMapException -> L32
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
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.cloud.CloudSearch.Query.m33clone():com.amap.api.services.cloud.CloudSearch$Query");
        }

        private static boolean a(SearchBound searchBound, SearchBound searchBound2) {
            if (searchBound == null && searchBound2 == null) {
                return true;
            }
            if (searchBound == null || searchBound2 == null) {
                return false;
            }
            return searchBound.equals(searchBound2);
        }

        private static boolean a(Sortingrules sortingrules, Sortingrules sortingrules2) {
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f10949a;

        /* renamed from: b  reason: collision with root package name */
        private LatLonPoint f10950b;

        /* renamed from: c  reason: collision with root package name */
        private int f10951c;

        /* renamed from: d  reason: collision with root package name */
        private LatLonPoint f10952d;

        /* renamed from: e  reason: collision with root package name */
        private String f10953e;

        /* renamed from: f  reason: collision with root package name */
        private List<LatLonPoint> f10954f;

        /* renamed from: g  reason: collision with root package name */
        private String f10955g;

        public SearchBound(LatLonPoint latLonPoint, int i4) {
            this.f10953e = "Bound";
            this.f10951c = i4;
            this.f10952d = latLonPoint;
        }

        private boolean a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f10949a = latLonPoint;
            this.f10950b = latLonPoint2;
            return latLonPoint != null && latLonPoint2 != null && latLonPoint.getLatitude() < this.f10950b.getLatitude() && this.f10949a.getLongitude() < this.f10950b.getLongitude();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof SearchBound)) {
                SearchBound searchBound = (SearchBound) obj;
                if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                    return false;
                }
                if (getShape().equals("Bound")) {
                    return searchBound.f10952d.equals(this.f10952d) && searchBound.f10951c == this.f10951c;
                } else if (getShape().equals("Polygon")) {
                    return a(searchBound.f10954f, this.f10954f);
                } else {
                    if (getShape().equals("Local")) {
                        return searchBound.f10955g.equals(this.f10955g);
                    }
                    if (searchBound.f10949a.equals(this.f10949a) && searchBound.f10950b.equals(this.f10950b)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public LatLonPoint getCenter() {
            return this.f10952d;
        }

        public String getCity() {
            return this.f10955g;
        }

        public LatLonPoint getLowerLeft() {
            return this.f10949a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f10954f;
        }

        public int getRange() {
            return this.f10951c;
        }

        public String getShape() {
            return this.f10953e;
        }

        public LatLonPoint getUpperRight() {
            return this.f10950b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f10952d;
            int hashCode = ((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint2 = this.f10949a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f10950b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f10954f;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f10951c) * 31;
            String str = this.f10953e;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f10955g;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        /* renamed from: clone */
        public SearchBound m34clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e4) {
                e4.printStackTrace();
            }
            if (getShape().equals("Bound")) {
                return new SearchBound(this.f10952d, this.f10951c);
            }
            if (getShape().equals("Polygon")) {
                return new SearchBound(a());
            }
            if (getShape().equals("Local")) {
                return new SearchBound(this.f10955g);
            }
            return new SearchBound(this.f10949a, this.f10950b);
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f10953e = "Rectangle";
            if (a(latLonPoint, latLonPoint2)) {
                return;
            }
            new IllegalArgumentException("invalid rect ").printStackTrace();
        }

        private static boolean a(List<LatLonPoint> list, List<LatLonPoint> list2) {
            if (list == null && list2 == null) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!list.get(i4).equals(list2.get(i4))) {
                    return false;
                }
            }
            return true;
        }

        private List<LatLonPoint> a() {
            if (this.f10954f == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LatLonPoint latLonPoint : this.f10954f) {
                arrayList.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
            }
            return arrayList;
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f10953e = "Polygon";
            this.f10954f = list;
        }

        public SearchBound(String str) {
            this.f10953e = "Local";
            this.f10955g = str;
        }
    }

    public CloudSearch(Context context) throws AMapException {
        if (this.f10940a == null) {
            try {
                this.f10940a = new k0(context);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (e4 instanceof AMapException) {
                    throw ((AMapException) e4);
                }
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

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.f10940a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.f10940a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.f10940a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;

        /* renamed from: a  reason: collision with root package name */
        private int f10956a;

        /* renamed from: b  reason: collision with root package name */
        private String f10957b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10958c;

        public Sortingrules(String str, boolean z3) {
            this.f10956a = 0;
            this.f10957b = str;
            this.f10958c = z3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Sortingrules sortingrules = (Sortingrules) obj;
                if (this.f10958c != sortingrules.f10958c) {
                    return false;
                }
                String str = this.f10957b;
                if (str == null) {
                    if (sortingrules.f10957b != null) {
                        return false;
                    }
                } else if (!str.equals(sortingrules.f10957b)) {
                    return false;
                }
                return this.f10956a == sortingrules.f10956a;
            }
            return false;
        }

        public int hashCode() {
            int i4 = ((this.f10958c ? 1231 : 1237) + 31) * 31;
            String str = this.f10957b;
            return ((i4 + (str == null ? 0 : str.hashCode())) * 31) + this.f10956a;
        }

        public String toString() {
            if (j4.j(this.f10957b)) {
                int i4 = this.f10956a;
                return i4 == 0 ? "_weight:desc" : i4 == 1 ? "_distance:asc" : "";
            } else if (this.f10958c) {
                return this.f10957b + ":asc";
            } else {
                return this.f10957b + ":desc";
            }
        }

        public Sortingrules(int i4) {
            this.f10958c = true;
            this.f10956a = i4;
        }
    }
}
