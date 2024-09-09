package com.mbridge.msdk.foundation.download;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum DownloadResourceType {
    DOWNLOAD_RESOURCE_TYPE_VIDEO(0),
    DOWNLOAD_RESOURCE_TYPE_ZIP(1),
    DOWNLOAD_RESOURCE_TYPE_IMAGE(2),
    DOWNLOAD_RESOURCE_TYPE_HTML(3),
    DOWNLOAD_RESOURCE_TYPE_OTHER(4),
    DOWNLOAD_RESOURCE_TYPE_APK(5);
    
    public int resourceType;

    DownloadResourceType(int i4) {
        this.resourceType = i4;
    }

    public static DownloadResourceType getDownloadResourceType(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                return null;
                            }
                            return DOWNLOAD_RESOURCE_TYPE_APK;
                        }
                        return DOWNLOAD_RESOURCE_TYPE_OTHER;
                    }
                    return DOWNLOAD_RESOURCE_TYPE_HTML;
                }
                return DOWNLOAD_RESOURCE_TYPE_IMAGE;
            }
            return DOWNLOAD_RESOURCE_TYPE_ZIP;
        }
        return DOWNLOAD_RESOURCE_TYPE_VIDEO;
    }
}
