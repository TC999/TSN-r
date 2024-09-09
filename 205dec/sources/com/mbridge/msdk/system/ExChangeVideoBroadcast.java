package com.mbridge.msdk.system;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.aidl.VideoBinderInterface;
import com.mbridge.msdk.foundation.aidl.VideoBinderListener;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.same.f.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ExChangeVideoBroadcast extends BroadcastReceiver {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class ExChangeVideoRunnable implements Runnable {
        private String pn;
        private VideoBinderInterface videoBinderInterface;

        public ExChangeVideoRunnable(String str) {
            this.pn = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<DownloadModel> list;
            if (com.mbridge.msdk.foundation.controller.a.f().j() == null || TextUtils.isEmpty(this.pn)) {
                return;
            }
            try {
                list = GlobalComponent.getInstance().getDatabaseHelper().findAll();
            } catch (Exception unused) {
                list = null;
            }
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            if (list != null && list.size() > 0) {
                for (DownloadModel downloadModel : list) {
                    if (downloadModel != null && downloadModel.getDownloadedBytes() == downloadModel.getTotalBytes()) {
                        arrayList.add(downloadModel);
                        arrayList2.add(downloadModel.getResourceUrl());
                    }
                }
            }
            Intent intent = new Intent("com.mbridge.msdk.foundation.aidl.VideoRequestService");
            intent.setClassName(this.pn, "com.mbridge.msdk.foundation.aidl.VideoRequestService");
            com.mbridge.msdk.foundation.controller.a.f().j().bindService(intent, new ServiceConnection() { // from class: com.mbridge.msdk.system.ExChangeVideoBroadcast.ExChangeVideoRunnable.1
                @Override // android.content.ServiceConnection
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    if (iBinder != null) {
                        try {
                            ExChangeVideoRunnable.this.videoBinderInterface = VideoBinderInterface.Stub.asInterface(iBinder);
                        } catch (Exception unused2) {
                        }
                    }
                    if (ExChangeVideoRunnable.this.videoBinderInterface != null) {
                        try {
                            ExChangeVideoRunnable.this.videoBinderInterface.registerListener(new VideoBinderListener.a() { // from class: com.mbridge.msdk.system.ExChangeVideoBroadcast.ExChangeVideoRunnable.1.1
                                @Override // com.mbridge.msdk.foundation.aidl.VideoBinderListener
                                public final void onVideo(final String str, final long j4, final String str2, final String str3, final String str4, final ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                                    b.a().execute(new Runnable() { // from class: com.mbridge.msdk.system.ExChangeVideoBroadcast.ExChangeVideoRunnable.1.1.1
                                        /* JADX WARN: Removed duplicated region for block: B:49:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                        /* JADX WARN: Removed duplicated region for block: B:57:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                        /* JADX WARN: Removed duplicated region for block: B:67:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                        @Override // java.lang.Runnable
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                                        */
                                        public final void run() {
                                            /*
                                                r20 = this;
                                                r1 = r20
                                                r2 = 0
                                                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                r0.<init>()     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                com.mbridge.msdk.foundation.same.b.c r3 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                java.lang.String r3 = com.mbridge.msdk.foundation.same.b.e.b(r3)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                r0.append(r3)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                r0.append(r3)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                java.lang.String r8 = r0.toString()     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                android.os.ParcelFileDescriptor r0 = r2     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                java.io.FileDescriptor r0 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                r3.<init>(r0)     // Catch: java.lang.Throwable -> L9e java.io.IOException -> Lb7
                                                java.io.FileOutputStream r15 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L97 java.io.IOException -> Lb7
                                                java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L97 java.io.IOException -> Lb7
                                                java.lang.String r4 = r3     // Catch: java.lang.Throwable -> L97 java.io.IOException -> Lb7
                                                r0.<init>(r8, r4)     // Catch: java.lang.Throwable -> L97 java.io.IOException -> Lb7
                                                r15.<init>(r0)     // Catch: java.lang.Throwable -> L97 java.io.IOException -> Lb7
                                                java.io.ByteArrayOutputStream r14 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L91 java.io.IOException -> Lb7
                                                r14.<init>()     // Catch: java.lang.Throwable -> L91 java.io.IOException -> Lb7
                                                r0 = 4096(0x1000, float:5.74E-42)
                                                byte[] r2 = new byte[r0]     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                            L3a:
                                                r4 = 0
                                                int r5 = r3.read(r2, r4, r0)     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                r6 = -1
                                                if (r5 == r6) goto L4d
                                                r14.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> Lb7
                                                goto L3a
                                            L46:
                                                r0 = move-exception
                                                r2 = r3
                                                r18 = r14
                                                r19 = r15
                                                goto La3
                                            L4d:
                                                byte[] r0 = r14.toByteArray()     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                r15.write(r0)     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                r15.flush()     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                java.lang.String r4 = r4     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                java.lang.String r6 = r5     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                java.lang.String r7 = r6     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                java.lang.String r9 = r3     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                long r12 = r7     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                r0 = 100
                                                r2 = 0
                                                com.mbridge.msdk.foundation.download.DownloadResourceType r16 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO     // Catch: java.lang.Throwable -> L8b java.io.IOException -> Lb7
                                                r17 = 1
                                                r5 = r6
                                                r10 = r12
                                                r18 = r14
                                                r14 = r0
                                                r19 = r15
                                                r15 = r2
                                                com.mbridge.msdk.foundation.download.database.DownloadModel r0 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> Lb7
                                                com.mbridge.msdk.foundation.download.core.GlobalComponent r2 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()     // Catch: java.lang.Throwable -> L89 java.io.IOException -> Lb7
                                                com.mbridge.msdk.foundation.download.database.IDatabaseHelper r2 = r2.getDatabaseHelper()     // Catch: java.lang.Throwable -> L89 java.io.IOException -> Lb7
                                                r2.insert(r0)     // Catch: java.lang.Throwable -> L89 java.io.IOException -> Lb7
                                                r3.close()     // Catch: java.io.IOException -> L82
                                            L82:
                                                r19.close()     // Catch: java.io.IOException -> L85
                                            L85:
                                                r18.close()     // Catch: java.io.IOException -> Lb7
                                                goto Lb7
                                            L89:
                                                r0 = move-exception
                                                goto L9c
                                            L8b:
                                                r0 = move-exception
                                                r18 = r14
                                                r19 = r15
                                                goto L9c
                                            L91:
                                                r0 = move-exception
                                                r19 = r15
                                                r18 = r2
                                                goto L9c
                                            L97:
                                                r0 = move-exception
                                                r18 = r2
                                                r19 = r18
                                            L9c:
                                                r2 = r3
                                                goto La3
                                            L9e:
                                                r0 = move-exception
                                                r18 = r2
                                                r19 = r18
                                            La3:
                                                if (r2 == 0) goto Laa
                                                r2.close()     // Catch: java.io.IOException -> La9
                                                goto Laa
                                            La9:
                                            Laa:
                                                if (r19 == 0) goto Lb1
                                                r19.close()     // Catch: java.io.IOException -> Lb0
                                                goto Lb1
                                            Lb0:
                                            Lb1:
                                                if (r18 == 0) goto Lb6
                                                r18.close()     // Catch: java.io.IOException -> Lb6
                                            Lb6:
                                                throw r0
                                            Lb7:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.system.ExChangeVideoBroadcast.ExChangeVideoRunnable.AnonymousClass1.BinderC07651.RunnableC07661.run():void");
                                        }
                                    });
                                }
                            });
                            List list2 = arrayList2;
                            try {
                                if (list2 != null && list2.size() > 0) {
                                    String[] strArr = new String[arrayList2.size()];
                                    for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                                        strArr[i4] = (String) arrayList2.get(i4);
                                    }
                                    ExChangeVideoRunnable.this.videoBinderInterface.requestVideo(strArr);
                                } else {
                                    ExChangeVideoRunnable.this.videoBinderInterface.requestVideo(null);
                                }
                            } catch (RemoteException unused3) {
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public final void onServiceDisconnected(ComponentName componentName) {
                }
            }, 1);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (context == null || intent == null) {
            return;
        }
        String str2 = null;
        try {
            str = intent.getAction();
        } catch (Exception unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, "mbridge_action_exchange_pm_receiver")) {
            return;
        }
        try {
            str2 = intent.getExtras().getString("pm-receiver");
        } catch (Exception unused2) {
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, context.getPackageName())) {
            return;
        }
        try {
            abortBroadcast();
        } catch (Exception unused3) {
        }
        b.a().execute(new ExChangeVideoRunnable(str2));
    }
}
