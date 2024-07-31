package com.mbridge.msdk.foundation.download;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public enum DownloadResourceType {
    DOWNLOAD_RESOURCE_TYPE_VIDEO(0),
    DOWNLOAD_RESOURCE_TYPE_ZIP(1),
    DOWNLOAD_RESOURCE_TYPE_IMAGE(2),
    DOWNLOAD_RESOURCE_TYPE_HTML(3),
    DOWNLOAD_RESOURCE_TYPE_OTHER(4),
    DOWNLOAD_RESOURCE_TYPE_APK(5);
    
    public int resourceType;

    DownloadResourceType(int i) {
        this.resourceType = i;
    }

    public static DownloadResourceType getDownloadResourceType(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
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
