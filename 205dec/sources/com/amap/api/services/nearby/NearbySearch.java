package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.s.p0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;

    /* renamed from: a  reason: collision with root package name */
    private static NearbySearch f11119a;

    /* renamed from: b  reason: collision with root package name */
    private INearbySearch f11120b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.amap.api.services.nearby.NearbySearch$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11121a;

        static {
            int[] iArr = new int[NearbySearchFunctionType.values().length];
            f11121a = iArr;
            try {
                iArr[NearbySearchFunctionType.DISTANCE_SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11121a[NearbySearchFunctionType.DRIVING_DISTANCE_SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i4);

        void onNearbyInfoUploaded(int i4);

        void onUserInfoCleared(int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class NearbyQuery {

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f11122a;

        /* renamed from: b  reason: collision with root package name */
        private NearbySearchFunctionType f11123b = NearbySearchFunctionType.DISTANCE_SEARCH;

        /* renamed from: c  reason: collision with root package name */
        private int f11124c = 1000;

        /* renamed from: d  reason: collision with root package name */
        private int f11125d = 1800;

        /* renamed from: e  reason: collision with root package name */
        private int f11126e = 1;

        public LatLonPoint getCenterPoint() {
            return this.f11122a;
        }

        public int getCoordType() {
            return this.f11126e;
        }

        public int getRadius() {
            return this.f11124c;
        }

        public int getTimeRange() {
            return this.f11125d;
        }

        public int getType() {
            int i4 = AnonymousClass1.f11121a[this.f11123b.ordinal()];
            return (i4 == 1 || i4 != 2) ? 0 : 1;
        }

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.f11122a = latLonPoint;
        }

        public void setCoordType(int i4) {
            if (i4 != 0 && i4 != 1) {
                this.f11126e = 1;
            } else {
                this.f11126e = i4;
            }
        }

        public void setRadius(int i4) {
            if (i4 > 10000) {
                i4 = 10000;
            }
            this.f11124c = i4;
        }

        public void setTimeRange(int i4) {
            if (i4 < 5) {
                i4 = 5;
            } else if (i4 > 86400) {
                i4 = 86400;
            }
            this.f11125d = i4;
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.f11123b = nearbySearchFunctionType;
        }
    }

    private NearbySearch(Context context) throws AMapException {
        if (this.f11120b == null) {
            try {
                this.f11120b = new p0(context);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (e4 instanceof AMapException) {
                    throw ((AMapException) e4);
                }
            }
        }
    }

    private void a() {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            iNearbySearch.destroy();
        }
        this.f11120b = null;
    }

    public static synchronized void destroy() {
        synchronized (NearbySearch.class) {
            NearbySearch nearbySearch = f11119a;
            if (nearbySearch != null) {
                nearbySearch.a();
            }
            f11119a = null;
        }
    }

    public static synchronized NearbySearch getInstance(Context context) throws AMapException {
        NearbySearch nearbySearch;
        synchronized (NearbySearch.class) {
            if (f11119a == null) {
                try {
                    f11119a = new NearbySearch(context);
                } catch (AMapException e4) {
                    throw e4;
                }
            }
            nearbySearch = f11119a;
        }
        return nearbySearch;
    }

    public synchronized void addNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            iNearbySearch.addNearbyListener(nearbyListener);
        }
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public synchronized void removeNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            iNearbySearch.removeNearbyListener(nearbyListener);
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i4) {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            iNearbySearch.startUploadNearbyInfoAuto(uploadInfoCallback, i4);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            iNearbySearch.stopUploadNearbyInfoAuto();
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.f11120b;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }
}
