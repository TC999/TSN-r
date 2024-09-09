package com.mbridge.msdk.foundation.tools;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DynamicViewResourceManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    static final List<String> f39849a;

    /* compiled from: DynamicViewResourceManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(String str, DownloadError downloadError);

        void a(String str, String str2, String str3);
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        f39849a = arrayList;
        arrayList.add("mbridge_splash_native_template_v_v1.xml");
        arrayList.add("mbridge_splash_native_template_h_v1.xml");
    }

    public static void a(int i4, String str, final String str2, final a aVar) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            str3 = b(i4, str, str2);
        } catch (Exception unused) {
            str3 = "";
        }
        final String b4 = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML);
        File file = null;
        try {
            if (!TextUtils.isEmpty(str3)) {
                file = new File(b4, str3);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            String replace = str3.replace(".xml", "");
            file = new File(b4 + File.separator + replace, str3);
        }
        try {
            if (file.exists() && file.isFile()) {
                str4 = file.getPath();
                if (!TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                    String path = new URL(str2).getPath();
                    final String substring = path.substring(path.lastIndexOf(47) + 1);
                    final String replace2 = substring.replace(".zip", "");
                    MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str2, substring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(PolicyConfig.mServerBusyRetryBaseInternal).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(b4).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.i.1
                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onCancelDownload(DownloadMessage downloadMessage) {
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadComplete(DownloadMessage downloadMessage) {
                            try {
                                String str5 = b4;
                                MBResourceManager.getInstance().unZip(b4 + File.separator + substring, str5);
                                a aVar2 = aVar;
                                if (aVar2 != null) {
                                    try {
                                        aVar2.a(str2, str5, replace2);
                                    } catch (Exception e4) {
                                        x.d("DynamicViewResourceManager", e4.getMessage());
                                    }
                                }
                            } catch (Exception unused3) {
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                try {
                                    aVar2.a(str2, downloadError);
                                } catch (Exception e4) {
                                    x.d("DynamicViewResourceManager", e4.getMessage());
                                }
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadStart(DownloadMessage downloadMessage) {
                        }
                    }).build().start();
                    return;
                } else if (aVar != null) {
                    try {
                        aVar.a(str2, str4, str3);
                        return;
                    } catch (Exception e4) {
                        x.d("DynamicViewResourceManager", e4.getMessage());
                        return;
                    }
                } else {
                    return;
                }
            }
            String path2 = new URL(str2).getPath();
            final String substring2 = path2.substring(path2.lastIndexOf(47) + 1);
            final String replace22 = substring2.replace(".zip", "");
            MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str2, substring2, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(PolicyConfig.mServerBusyRetryBaseInternal).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(b4).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.i.1
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onCancelDownload(DownloadMessage downloadMessage) {
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadComplete(DownloadMessage downloadMessage) {
                    try {
                        String str5 = b4;
                        MBResourceManager.getInstance().unZip(b4 + File.separator + substring2, str5);
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            try {
                                aVar2.a(str2, str5, replace22);
                            } catch (Exception e42) {
                                x.d("DynamicViewResourceManager", e42.getMessage());
                            }
                        }
                    } catch (Exception unused3) {
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        try {
                            aVar2.a(str2, downloadError);
                        } catch (Exception e42) {
                            x.d("DynamicViewResourceManager", e42.getMessage());
                        }
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadStart(DownloadMessage downloadMessage) {
                }
            }).build().start();
            return;
        } catch (Exception e5) {
            x.d("DynamicViewResourceManager", e5.getMessage());
            return;
        }
        str4 = "";
        if (TextUtils.isEmpty(str4)) {
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            String substring = path.substring(path.lastIndexOf(47) + 1);
            if (TextUtils.isEmpty(substring)) {
                return "";
            }
            String replace = substring.replace(".zip", "");
            List<String> list = f39849a;
            return list != null ? !list.contains(replace) ? replace : "" : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String b(int i4, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            String path = new URL(str2).getPath();
            String substring = path.substring(path.lastIndexOf(47) + 1);
            return !TextUtils.isEmpty(substring) ? substring.replace(".zip", "") : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(int i4, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            str3 = b(i4, str, str2);
        } catch (Exception unused) {
            str3 = "";
        }
        File file = null;
        String b4 = com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML);
        try {
            if (!TextUtils.isEmpty(str3)) {
                file = new File(b4, str3);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            String replace = str3.replace(".xml", "");
            file = new File(b4 + File.separator + replace, str3);
        }
        return file.getPath();
    }

    public static String a(String str) {
        String str2;
        File file;
        com.mbridge.msdk.foundation.same.b.c cVar;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_NATMP);
            if (!TextUtils.isEmpty(queryParameter)) {
                if (!queryParameter.equals("1")) {
                    return "";
                }
            }
        } catch (Throwable unused) {
        }
        try {
            str2 = b(str);
        } catch (Exception unused2) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            cVar = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML;
            file = new File(com.mbridge.msdk.foundation.same.b.e.a(cVar), str2);
        } catch (Exception unused3) {
        }
        if (file.isFile() && file.exists()) {
            return file.getPath();
        }
        final String b4 = com.mbridge.msdk.foundation.same.b.e.b(cVar);
        String path = new URL(str).getPath();
        final String substring = path.substring(path.lastIndexOf(47) + 1);
        MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, substring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(PolicyConfig.mServerBusyRetryBaseInternal).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(b4).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.i.2
            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onCancelDownload(DownloadMessage downloadMessage) {
            }

            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onDownloadComplete(DownloadMessage downloadMessage) {
                try {
                    MBResourceManager.getInstance().unZip(b4 + File.separator + substring, b4);
                } catch (Exception unused4) {
                }
            }

            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            }

            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onDownloadStart(DownloadMessage downloadMessage) {
            }
        }).build().start();
        return "";
    }
}
