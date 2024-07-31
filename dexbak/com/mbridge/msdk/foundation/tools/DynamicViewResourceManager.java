package com.mbridge.msdk.foundation.tools;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.tools.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DynamicViewResourceManager {

    /* renamed from: a */
    static final List<String> f31076a;

    /* compiled from: DynamicViewResourceManager.java */
    /* renamed from: com.mbridge.msdk.foundation.tools.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11418a {
        /* renamed from: a */
        void m21865a(String str, DownloadError downloadError);

        /* renamed from: a */
        void m21864a(String str, String str2, String str3);
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        f31076a = arrayList;
        arrayList.add("mbridge_splash_native_template_v_v1.xml");
        arrayList.add("mbridge_splash_native_template_h_v1.xml");
    }

    /* renamed from: a */
    public static void m21869a(int i, String str, final String str2, final InterfaceC11418a interfaceC11418a) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            str3 = m21867b(i, str, str2);
        } catch (Exception unused) {
            str3 = "";
        }
        final String m22347b = MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_XML);
        File file = null;
        try {
            if (!TextUtils.isEmpty(str3)) {
                file = new File(m22347b, str3);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            String replace = str3.replace(".xml", "");
            file = new File(m22347b + File.separator + replace, str3);
        }
        try {
            if (file.exists() && file.isFile()) {
                str4 = file.getPath();
                if (!TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                    String path = new URL(str2).getPath();
                    final String substring = path.substring(path.lastIndexOf(47) + 1);
                    final String replace2 = substring.replace(".zip", "");
                    MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str2, substring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(30000L).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(m22347b).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.i.1
                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onCancelDownload(DownloadMessage downloadMessage) {
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadComplete(DownloadMessage downloadMessage) {
                            try {
                                String str5 = m22347b;
                                MBResourceManager.getInstance().unZip(m22347b + File.separator + substring, str5);
                                InterfaceC11418a interfaceC11418a2 = interfaceC11418a;
                                if (interfaceC11418a2 != null) {
                                    try {
                                        interfaceC11418a2.m21864a(str2, str5, replace2);
                                    } catch (Exception e) {
                                        SameLogTool.m21733d("DynamicViewResourceManager", e.getMessage());
                                    }
                                }
                            } catch (Exception unused3) {
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                            InterfaceC11418a interfaceC11418a2 = interfaceC11418a;
                            if (interfaceC11418a2 != null) {
                                try {
                                    interfaceC11418a2.m21865a(str2, downloadError);
                                } catch (Exception e) {
                                    SameLogTool.m21733d("DynamicViewResourceManager", e.getMessage());
                                }
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadStart(DownloadMessage downloadMessage) {
                        }
                    }).build().start();
                    return;
                } else if (interfaceC11418a != null) {
                    try {
                        interfaceC11418a.m21864a(str2, str4, str3);
                        return;
                    } catch (Exception e) {
                        SameLogTool.m21733d("DynamicViewResourceManager", e.getMessage());
                        return;
                    }
                } else {
                    return;
                }
            }
            String path2 = new URL(str2).getPath();
            final String substring2 = path2.substring(path2.lastIndexOf(47) + 1);
            final String replace22 = substring2.replace(".zip", "");
            MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str2, substring2, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(30000L).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(m22347b).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.i.1
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onCancelDownload(DownloadMessage downloadMessage) {
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadComplete(DownloadMessage downloadMessage) {
                    try {
                        String str5 = m22347b;
                        MBResourceManager.getInstance().unZip(m22347b + File.separator + substring2, str5);
                        InterfaceC11418a interfaceC11418a2 = interfaceC11418a;
                        if (interfaceC11418a2 != null) {
                            try {
                                interfaceC11418a2.m21864a(str2, str5, replace22);
                            } catch (Exception e2) {
                                SameLogTool.m21733d("DynamicViewResourceManager", e2.getMessage());
                            }
                        }
                    } catch (Exception unused3) {
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                    InterfaceC11418a interfaceC11418a2 = interfaceC11418a;
                    if (interfaceC11418a2 != null) {
                        try {
                            interfaceC11418a2.m21865a(str2, downloadError);
                        } catch (Exception e2) {
                            SameLogTool.m21733d("DynamicViewResourceManager", e2.getMessage());
                        }
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadStart(DownloadMessage downloadMessage) {
                }
            }).build().start();
            return;
        } catch (Exception e2) {
            SameLogTool.m21733d("DynamicViewResourceManager", e2.getMessage());
            return;
        }
        str4 = "";
        if (TextUtils.isEmpty(str4)) {
        }
    }

    /* renamed from: b */
    private static String m21866b(String str) {
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
            List<String> list = f31076a;
            return list != null ? !list.contains(replace) ? replace : "" : "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: b */
    private static String m21867b(int i, String str, String str2) {
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

    /* renamed from: a */
    public static String m21870a(int i, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            str3 = m21867b(i, str, str2);
        } catch (Exception unused) {
            str3 = "";
        }
        File file = null;
        String m22347b = MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_XML);
        try {
            if (!TextUtils.isEmpty(str3)) {
                file = new File(m22347b, str3);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            String replace = str3.replace(".xml", "");
            file = new File(m22347b + File.separator + replace, str3);
        }
        return file.getPath();
    }

    /* renamed from: a */
    public static String m21868a(String str) {
        String str2;
        File file;
        MBridgeDir mBridgeDir;
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
            str2 = m21866b(str);
        } catch (Exception unused2) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            mBridgeDir = MBridgeDir.MBRIDGE_700_XML;
            file = new File(MBridgeDirManager.m22349a(mBridgeDir), str2);
        } catch (Exception unused3) {
        }
        if (file.isFile() && file.exists()) {
            return file.getPath();
        }
        final String m22347b = MBridgeDirManager.m22347b(mBridgeDir);
        String path = new URL(str).getPath();
        final String substring = path.substring(path.lastIndexOf(47) + 1);
        MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, substring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(30000L).withConnectTimeout(20000L).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(m22347b).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.i.2
            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onCancelDownload(DownloadMessage downloadMessage) {
            }

            @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
            public final void onDownloadComplete(DownloadMessage downloadMessage) {
                try {
                    MBResourceManager.getInstance().unZip(m22347b + File.separator + substring, m22347b);
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
