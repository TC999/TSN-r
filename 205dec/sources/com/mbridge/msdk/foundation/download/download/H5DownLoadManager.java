package com.mbridge.msdk.foundation.download.download;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.a;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.x;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class H5DownLoadManager {
    public static final String SP_ENDING_PAGE_SAVE_TIME = "ending_page_save_time";
    public static final String SP_ENDING_PAGE_SOURCE = "ending_page_source";
    private static final String TAG = "H5DownLoadManager";
    private static H5DownLoadManager sH5Manager;
    private HTMLResourceManager htmlResourceManager;
    private boolean isUseDownloadModule;
    private CopyOnWriteArrayList<String> mResDownloadingList;
    private ConcurrentMap<String, DownLoadH5SourceListener> mResDownloadingMap;
    private ResourceManager resourceManager;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface H5ResDownloadListerInter {
        void onFailed(String str, String str2);

        void onSuccess(String str);
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface IH5SourceDownloadListener extends H5ResDownloadListerInter {
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface IOnDownLoadH5Source {
        void onFailed(String str);

        void onStart();

        void onSuccess(String str, byte[] bArr, String str2);
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface ZipDownloadListener extends H5ResDownloadListerInter {
    }

    private H5DownLoadManager() {
        this.isUseDownloadModule = false;
        try {
            this.resourceManager = ResourceManager.getinstance();
            this.htmlResourceManager = HTMLResourceManager.getInstance();
            this.mResDownloadingList = new CopyOnWriteArrayList<>();
            this.mResDownloadingMap = new ConcurrentHashMap();
            a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 != null) {
                this.isUseDownloadModule = b4.l(1);
            }
        } catch (Throwable th) {
            x.b(TAG, th.getMessage(), th);
        }
    }

    private void downloadHTML(final String str, final H5ResDownloadListerInter h5ResDownloadListerInter) {
        try {
            x.d(TAG, "download url:" + str);
            if (this.mResDownloadingList.contains(str)) {
                return;
            }
            this.mResDownloadingList.add(str);
            DownloadTask.getInstance().runTask(new com.mbridge.msdk.foundation.same.e.a() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.2
                @Override // com.mbridge.msdk.foundation.same.e.a
                public void cancelTask() {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void pauseTask(boolean z3) {
                }

                @Override // com.mbridge.msdk.foundation.same.e.a
                public void runTask() {
                    if (!TextUtils.isEmpty(H5DownLoadManager.this.htmlResourceManager.getHtmlContentFromUrl(str))) {
                        H5DownLoadManager.this.mResDownloadingList.remove(str);
                        H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                        if (h5ResDownloadListerInter2 != null) {
                            h5ResDownloadListerInter2.onSuccess(str);
                            return;
                        }
                        return;
                    }
                    DownLoadUtils.getSourceCodeFromNetUrl(str, new IOnDownLoadH5Source() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.2.1
                        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source
                        public void onFailed(String str2) {
                            try {
                                H5DownLoadManager.this.mResDownloadingList.remove(str);
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                H5ResDownloadListerInter h5ResDownloadListerInter3 = h5ResDownloadListerInter;
                                if (h5ResDownloadListerInter3 != null) {
                                    h5ResDownloadListerInter3.onFailed(str, str2);
                                }
                            } catch (Exception e4) {
                                if (MBridgeConstans.DEBUG) {
                                    e4.printStackTrace();
                                }
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                H5ResDownloadListerInter h5ResDownloadListerInter4 = h5ResDownloadListerInter;
                                if (h5ResDownloadListerInter4 != null) {
                                    h5ResDownloadListerInter4.onFailed(str, str2);
                                }
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source
                        public void onStart() {
                        }

                        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.IOnDownLoadH5Source
                        public void onSuccess(String str2, byte[] bArr, String str3) {
                            try {
                                H5DownLoadManager.this.mResDownloadingList.remove(str3);
                                if (bArr == null || bArr.length <= 0) {
                                    return;
                                }
                                if (H5DownLoadManager.this.htmlResourceManager.saveResHtmlFile(str3, bArr)) {
                                    H5ResDownloadListerInter h5ResDownloadListerInter3 = h5ResDownloadListerInter;
                                    if (h5ResDownloadListerInter3 != null) {
                                        h5ResDownloadListerInter3.onSuccess(str3);
                                        return;
                                    }
                                    return;
                                }
                                H5ResDownloadListerInter h5ResDownloadListerInter4 = h5ResDownloadListerInter;
                                if (h5ResDownloadListerInter4 != null) {
                                    h5ResDownloadListerInter4.onFailed(str3, "save file failed");
                                }
                            } catch (Exception e4) {
                                if (MBridgeConstans.DEBUG) {
                                    e4.printStackTrace();
                                }
                                H5ResDownloadListerInter h5ResDownloadListerInter5 = h5ResDownloadListerInter;
                                if (h5ResDownloadListerInter5 != null) {
                                    h5ResDownloadListerInter5.onFailed(str3, e4.getMessage());
                                }
                            }
                        }
                    }, true);
                }
            });
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    private void downloadHTMLByDownloadModule(final String str, final H5ResDownloadListerInter h5ResDownloadListerInter) {
        if (TextUtils.isEmpty(str)) {
            if (h5ResDownloadListerInter != null) {
                h5ResDownloadListerInter.onFailed("zip url is null", str);
                return;
            }
            return;
        }
        try {
            new URL(str);
            String md5 = SameMD5.getMD5(ai.a(str));
            MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, md5 + ".html", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_HTML)).withReadTimeout(PolicyConfig.mServerBusyRetryBaseInternal).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(e.b(c.MBRIDGE_700_HTML) + TTPathConst.sSeparator).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.3
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onCancelDownload(DownloadMessage downloadMessage) {
                    x.a(H5DownLoadManager.TAG, "\u4e0b\u8f7d\u53d6\u6d88\uff1a ");
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onFailed(str, "task cancel");
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadComplete(DownloadMessage downloadMessage) {
                    x.a(H5DownLoadManager.TAG, "\u4e0b\u8f7d\u7ed3\u675f\uff1a " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType() + " " + downloadMessage.getSaveFilePath());
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onSuccess(str);
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                    x.a(H5DownLoadManager.TAG, "\u4e0b\u8f7d\u7ed3\u675f\u5931\u8d25\uff1a " + downloadError.getException().getMessage());
                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                    if (h5ResDownloadListerInter2 != null) {
                        h5ResDownloadListerInter2.onFailed(str, downloadError.getException().getMessage());
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadStart(DownloadMessage downloadMessage) {
                    x.a(H5DownLoadManager.TAG, "\u5f00\u59cb\u4e0b\u8f7d html\uff1a " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType());
                }
            }).build().start();
        } catch (Exception unused) {
            if (h5ResDownloadListerInter != null) {
                h5ResDownloadListerInter.onFailed("zip url is unlawful", str);
            }
        }
    }

    private void downloadZipByDownloadModule(String str, final ZipDownloadListener zipDownloadListener) {
        if (TextUtils.isEmpty(str)) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "zip url is null");
                return;
            }
            return;
        }
        try {
            new URL(str);
            String b4 = e.b(c.MBRIDGE_700_RES);
            String md5 = SameMD5.getMD5(ai.a(str));
            String str2 = b4 + TTPathConst.sSeparator;
            final String str3 = b4 + TTPathConst.sSeparator + md5;
            MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, md5 + ".zip", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP)).withReadTimeout(PolicyConfig.mServerBusyRetryBaseInternal).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(str2).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.1
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onCancelDownload(DownloadMessage downloadMessage) {
                    x.a(H5DownLoadManager.TAG, "\u4e0b\u8f7d\u53d6\u6d88\uff1a " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType());
                    if (!TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage.getDownloadUrl()))) {
                        ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onSuccess(downloadMessage.getDownloadUrl());
                            return;
                        }
                        return;
                    }
                    ZipDownloadListener zipDownloadListener3 = zipDownloadListener;
                    if (zipDownloadListener3 != null) {
                        zipDownloadListener3.onFailed(downloadMessage.getDownloadUrl(), "task cancel");
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadComplete(DownloadMessage downloadMessage) {
                    x.a(H5DownLoadManager.TAG, "\u4e0b\u8f7d\u7ed3\u675f\uff0c\u5f00\u59cb\u89e3\u538b\u7f29\u6587\u4ef6\uff1a " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType() + " " + downloadMessage.getSaveFilePath());
                    try {
                        if (TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage.getDownloadUrl()))) {
                            MBResourceManager.getInstance().unZip(downloadMessage.getSaveFilePath(), str3);
                        }
                        x.a(H5DownLoadManager.TAG, "\u4e0b\u8f7d\u7ed3\u675f\uff0c\u5f00\u59cb\u89e3\u538b\u7f29\u6587\u4ef6\uff0c\u6587\u4ef6\u89e3\u538b\u6210\u529f\uff1a " + str3);
                        ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onSuccess(downloadMessage.getDownloadUrl());
                        }
                    } catch (IOException e4) {
                        x.a(H5DownLoadManager.TAG, "\u4e0b\u8f7d\u7ed3\u675f\uff0c\u5f00\u59cb\u89e3\u538b\u7f29\u6587\u4ef6\uff0c\u6587\u4ef6\u89e3\u538b\u5931\u8d25\uff1a " + e4.getMessage());
                        ZipDownloadListener zipDownloadListener3 = zipDownloadListener;
                        if (zipDownloadListener3 != null) {
                            zipDownloadListener3.onFailed(downloadMessage.getDownloadUrl(), e4.getMessage());
                        }
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                    x.a(H5DownLoadManager.TAG, "\u4e0b\u8f7d\u9519\u8bef\uff1a " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType() + "  " + downloadError.getException().getMessage());
                    if (!TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage.getDownloadUrl()))) {
                        ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onSuccess(downloadMessage.getDownloadUrl());
                            return;
                        }
                        return;
                    }
                    ZipDownloadListener zipDownloadListener3 = zipDownloadListener;
                    if (zipDownloadListener3 != null) {
                        zipDownloadListener3.onFailed(downloadMessage.getDownloadUrl(), downloadError.getException().getMessage());
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public void onDownloadStart(DownloadMessage downloadMessage) {
                    x.a(H5DownLoadManager.TAG, "\u5f00\u59cb\u4e0b\u8f7d zip\uff1a " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType());
                }
            }).build().start();
        } catch (Exception unused) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "zip url is unlawful");
            }
        }
    }

    private void downloadZipByOldDownloadModule(String str, ZipDownloadListener zipDownloadListener) {
        try {
            if (!TextUtils.isEmpty(this.resourceManager.getResDirFromCampaign(str))) {
                if (zipDownloadListener != null) {
                    zipDownloadListener.onSuccess(str);
                }
            } else if (this.mResDownloadingMap.containsKey(str)) {
                DownLoadH5SourceListener downLoadH5SourceListener = this.mResDownloadingMap.get(str);
                if (downLoadH5SourceListener != null) {
                    downLoadH5SourceListener.setZipDownloadListener(zipDownloadListener);
                }
            } else {
                DownLoadH5SourceListener downLoadH5SourceListener2 = new DownLoadH5SourceListener(this.mResDownloadingMap, this.resourceManager, zipDownloadListener, str);
                this.mResDownloadingMap.put(str, downLoadH5SourceListener2);
                DownLoadUtils.getSourceCodeFromNetUrl(str, downLoadH5SourceListener2, true);
            }
        } catch (Exception e4) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "downloadzip failed");
            }
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    private String getHtmlAddress(String str) {
        HTMLResourceManager hTMLResourceManager = this.htmlResourceManager;
        return hTMLResourceManager != null ? hTMLResourceManager.getHtmlPathFromUrl(str) : str;
    }

    public static H5DownLoadManager getInstance() {
        if (sH5Manager == null) {
            synchronized (H5DownLoadManager.class) {
                if (sH5Manager == null) {
                    sH5Manager = new H5DownLoadManager();
                }
            }
        }
        return sH5Manager;
    }

    private long getPreSaveTimeFromSp(String str) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            Object b4 = ae.b(j4, SP_ENDING_PAGE_SAVE_TIME + str, 0L);
            if (b4 != null && (b4 instanceof Long)) {
                return ((Long) b4).longValue();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return 0L;
    }

    private void saveSourceContent(String str, String str2) {
        try {
            x.b(TAG, "sourceContent:" + str);
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j4, SP_ENDING_PAGE_SOURCE + str2, str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void updateEndingPageSaveTime(String str) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            ae.a(j4, SP_ENDING_PAGE_SAVE_TIME + str, Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void download(String str) {
        download(str, null);
    }

    public void downloadH5Res(String str) {
        downloadH5Res(str, null);
    }

    public void downloadZip(String str, ZipDownloadListener zipDownloadListener) {
        if (this.isUseDownloadModule) {
            downloadZipByDownloadModule(str, zipDownloadListener);
        } else {
            downloadZipByOldDownloadModule(str, zipDownloadListener);
        }
    }

    public String getH5ResAddress(String str) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                Uri parse = Uri.parse(str);
                String path = parse.getPath();
                if (TextUtils.isEmpty(path) || !TextUtils.isEmpty(parse.getQueryParameter("urlDebug"))) {
                    return str;
                }
                if (path.toLowerCase().endsWith(".zip")) {
                    return getResAddress(str);
                }
                return getHtmlAddress(str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return str;
    }

    public String getResAddress(String str) {
        ResourceManager resourceManager = this.resourceManager;
        if (resourceManager != null) {
            return resourceManager.getResDirFromCampaign(str);
        }
        return null;
    }

    public String getSourceContentFromSp(String str) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            Object b4 = ae.b(j4, SP_ENDING_PAGE_SOURCE + str, "");
            if (b4 == null || !(b4 instanceof String)) {
                return null;
            }
            String str2 = (String) b4;
            if (ag.b(str2)) {
                return str2;
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void download(String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        if (this.isUseDownloadModule) {
            downloadHTMLByDownloadModule(str, h5ResDownloadListerInter);
        } else {
            downloadHTML(str, h5ResDownloadListerInter);
        }
    }

    public void downloadH5Res(String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                String path = Uri.parse(str).getPath();
                if (!TextUtils.isEmpty(path)) {
                    if (path.toLowerCase().endsWith(".zip")) {
                        downloadZip(str, (ZipDownloadListener) h5ResDownloadListerInter);
                        return;
                    } else {
                        download(str, h5ResDownloadListerInter);
                        return;
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (h5ResDownloadListerInter != null) {
            h5ResDownloadListerInter.onFailed(str, "The URL does not contain a path ");
        }
    }
}
