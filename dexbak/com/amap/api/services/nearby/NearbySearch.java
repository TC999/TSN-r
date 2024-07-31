package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.p047s.NearbySearchCore;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.clj.fastble.BleManager;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NearbySearch {
    public static final int AMAP = 1;
    public static final int GPS = 0;

    /* renamed from: a */
    private static NearbySearch f7425a;

    /* renamed from: b */
    private INearbySearch f7426b;

    /* renamed from: com.amap.api.services.nearby.NearbySearch$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static /* synthetic */ class C23351 {

        /* renamed from: a */
        static final /* synthetic */ int[] f7427a;

        static {
            int[] iArr = new int[NearbySearchFunctionType.values().length];
            f7427a = iArr;
            try {
                iArr[NearbySearchFunctionType.DISTANCE_SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7427a[NearbySearchFunctionType.DRIVING_DISTANCE_SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface NearbyListener {
        void onNearbyInfoSearched(NearbySearchResult nearbySearchResult, int i);

        void onNearbyInfoUploaded(int i);

        void onUserInfoCleared(int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class NearbyQuery {

        /* renamed from: a */
        private LatLonPoint f7428a;

        /* renamed from: b */
        private NearbySearchFunctionType f7429b = NearbySearchFunctionType.DISTANCE_SEARCH;

        /* renamed from: c */
        private int f7430c = 1000;

        /* renamed from: d */
        private int f7431d = 1800;

        /* renamed from: e */
        private int f7432e = 1;

        public LatLonPoint getCenterPoint() {
            return this.f7428a;
        }

        public int getCoordType() {
            return this.f7432e;
        }

        public int getRadius() {
            return this.f7430c;
        }

        public int getTimeRange() {
            return this.f7431d;
        }

        public int getType() {
            int i = C23351.f7427a[this.f7429b.ordinal()];
            return (i == 1 || i != 2) ? 0 : 1;
        }

        public void setCenterPoint(LatLonPoint latLonPoint) {
            this.f7428a = latLonPoint;
        }

        public void setCoordType(int i) {
            if (i != 0 && i != 1) {
                this.f7432e = 1;
            } else {
                this.f7432e = i;
            }
        }

        public void setRadius(int i) {
            if (i > 10000) {
                i = BleManager.f22896l;
            }
            this.f7430c = i;
        }

        public void setTimeRange(int i) {
            if (i < 5) {
                i = 5;
            } else if (i > 86400) {
                i = 86400;
            }
            this.f7431d = i;
        }

        public void setType(NearbySearchFunctionType nearbySearchFunctionType) {
            this.f7429b = nearbySearchFunctionType;
        }
    }

    private NearbySearch(Context context) throws AMapException {
        if (this.f7426b == null) {
            try {
                this.f7426b = new NearbySearchCore(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    /* renamed from: a */
    private void m51867a() {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            iNearbySearch.destroy();
        }
        this.f7426b = null;
    }

    public static synchronized void destroy() {
        synchronized (NearbySearch.class) {
            NearbySearch nearbySearch = f7425a;
            if (nearbySearch != null) {
                nearbySearch.m51867a();
            }
            f7425a = null;
        }
    }

    public static synchronized NearbySearch getInstance(Context context) throws AMapException {
        NearbySearch nearbySearch;
        synchronized (NearbySearch.class) {
            if (f7425a == null) {
                try {
                    f7425a = new NearbySearch(context);
                } catch (AMapException e) {
                    throw e;
                }
            }
            nearbySearch = f7425a;
        }
        return nearbySearch;
    }

    public synchronized void addNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            iNearbySearch.addNearbyListener(nearbyListener);
        }
    }

    public void clearUserInfoAsyn() {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            iNearbySearch.clearUserInfoAsyn();
        }
    }

    public synchronized void removeNearbyListener(NearbyListener nearbyListener) {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            iNearbySearch.removeNearbyListener(nearbyListener);
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbyQuery nearbyQuery) throws AMapException {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            return iNearbySearch.searchNearbyInfo(nearbyQuery);
        }
        return null;
    }

    public void searchNearbyInfoAsyn(NearbyQuery nearbyQuery) {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            iNearbySearch.searchNearbyInfoAsyn(nearbyQuery);
        }
    }

    public void setUserID(String str) {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            iNearbySearch.setUserID(str);
        }
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i) {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            iNearbySearch.startUploadNearbyInfoAuto(uploadInfoCallback, i);
        }
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            iNearbySearch.stopUploadNearbyInfoAuto();
        }
    }

    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        INearbySearch iNearbySearch = this.f7426b;
        if (iNearbySearch != null) {
            iNearbySearch.uploadNearbyInfoAsyn(uploadInfo);
        }
    }
}
