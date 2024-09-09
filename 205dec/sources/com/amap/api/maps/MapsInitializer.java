package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.c;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.q6;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    public static String TERRAIN_LOCAL_DEM_SOURCE_PATH = null;
    private static boolean closeTileOverlay = false;
    private static ExceptionLogger exceptionLogger = null;
    private static boolean isContourLineEnable = false;
    private static boolean isLoadWorldGridMap = false;
    private static boolean isNeedDownloadCoordinateConvertLibrary = true;
    private static boolean isNetWorkEnable = true;
    private static boolean isPolyline2Enable = true;
    private static boolean isSupportRecycleView = true;
    private static boolean isTerrainEnable = false;
    private static boolean isTextureDestroyedRender = false;
    private static boolean isTextureSizeChangedInvoked = false;
    private static boolean isTextureViewDestorySync = true;
    private static boolean isloadWorldVectorMap = true;
    private static int mProtocol = 1;
    private static String mWorldVectorOfflineMapStyleAssetsPath = "";
    private static String mWorldVectorOfflineMapStyleFilePath = "";
    public static String sdcardDir = "";

    public static void disableCachedMapDataUpdate(boolean z3) {
    }

    public static String getDeviceId(Context context) {
        return i4.a0(context);
    }

    public static ExceptionLogger getExceptionLogger() {
        return exceptionLogger;
    }

    public static boolean getNetWorkEnable() {
        return isNetWorkEnable;
    }

    public static boolean getPolyline2Enable() {
        return true;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static boolean getTextureDestroyRender() {
        return isTextureDestroyedRender;
    }

    public static boolean getTextureSizeChangedInvoked() {
        return isTextureSizeChangedInvoked;
    }

    public static boolean getTextureViewDestorySync() {
        return isTextureViewDestorySync;
    }

    public static String getVersion() {
        return "10.0.600";
    }

    public static String getWorldVectorOfflineMapStyleAssetsPath() {
        return mWorldVectorOfflineMapStyleAssetsPath;
    }

    public static String getWorldVectorOfflineMapStyleFilePath() {
        return mWorldVectorOfflineMapStyleFilePath;
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            c.f7290f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        } else {
            Log.w("MapsInitializer", "the context is null");
        }
    }

    public static boolean isContourLineEnable() {
        return isContourLineEnable;
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return isNeedDownloadCoordinateConvertLibrary;
    }

    public static boolean isLoadWorldGridMap() {
        return isLoadWorldGridMap;
    }

    public static boolean isLoadWorldVectorMap() {
        return isloadWorldVectorMap;
    }

    public static boolean isSupportRecycleView() {
        return isSupportRecycleView;
    }

    public static boolean isTerrainEnable() {
        return isTerrainEnable;
    }

    public static void loadWorldVectorMap(boolean z3) {
        isloadWorldVectorMap = z3;
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        g4.l(c.f7290f, str);
    }

    public static void setBuildingHeight(int i4) {
    }

    public static void setContourLIneEnable(boolean z3) {
        isContourLineEnable = z3;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z3) {
        isNeedDownloadCoordinateConvertLibrary = z3;
    }

    public static void setExceptionLogger(ExceptionLogger exceptionLogger2) {
        exceptionLogger = exceptionLogger2;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            q6.f8834a = -1;
            q6.f8835b = "";
            return;
        }
        q6.f8834a = 1;
        q6.f8835b = str;
    }

    public static void setNetWorkEnable(boolean z3) {
        isNetWorkEnable = z3;
    }

    public static void setPolyline2Enable(boolean z3) {
    }

    public static void setProtocol(int i4) {
        mProtocol = i4;
    }

    public static void setSupportRecycleView(boolean z3) {
        isSupportRecycleView = z3;
    }

    public static void setTerrainEnable(boolean z3) {
        isTerrainEnable = z3;
    }

    public static void setTextureDestroyedRender(boolean z3) {
        isTextureDestroyedRender = z3;
    }

    public static void setTextureSizeChangedInvoked(boolean z3) {
        isTextureSizeChangedInvoked = z3;
    }

    public static void setTextureViewDestorySync(boolean z3) {
        isTextureViewDestorySync = z3;
    }

    public static void setWorldVectorOfflineMapStyleAssetsPath(String str) {
        mWorldVectorOfflineMapStyleAssetsPath = str;
    }

    public static void setWorldVectorOfflineMapStyleFilePath(String str) {
        mWorldVectorOfflineMapStyleFilePath = str;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z3) {
        synchronized (MapsInitializer.class) {
            ft.i(context, z3, a3.s());
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z3, boolean z4) {
        synchronized (MapsInitializer.class) {
            ft.j(context, z3, z4, a3.s());
        }
    }
}
