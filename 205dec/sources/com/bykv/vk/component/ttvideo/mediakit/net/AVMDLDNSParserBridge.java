package com.bykv.vk.component.ttvideo.mediakit.net;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLDNSParserBridge implements AVMDLDNSParserListener {
    private static final String TAG = "AVMDLDNSParserBridge";
    private static boolean v2Usable = true;
    public String host;
    String ipList = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyParserResult(long j4, String str, String str2, long j5, String str3);

    private static native void _notifyParserResultV2(long j4, String str, String str2, long j5, String str3, int i4);

    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parserResult(long r17, java.lang.String r19, int r20) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.parserResult(long, java.lang.String, int):int");
    }

    public String getBackUp(String str) {
        AVMDLDNSInfo backUpIp;
        String str2 = (AVMDLDNSParser.getIntValue(5) != 1 || (backUpIp = IPCache.getInstance().getBackUpIp(str)) == null) ? null : backUpIp.mIpList;
        AVMDLLog.d(TAG, "****get backup ip result:" + str2);
        return str2;
    }

    public String getResult() {
        this.lock.lock();
        try {
            String str = this.ipList;
            this.lock.unlock();
            AVMDLLog.d(TAG, "****get result:" + str);
            return str;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    boolean isFinish() {
        return this.isFinish;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserListener
    public void onCompletion(int i4, String str, String str2, long j4, String str3, int i5) {
        if (!this.isFinish && v2Usable) {
            parserResult(i4, str, str2, j4, str3, i5, 2);
        }
        if (this.isFinish) {
            return;
        }
        parserResult(i4, str, str2, j4, str3, i5, 1);
    }

    public void release() {
        AVMDLLog.d(TAG, String.format("----start release:%s", this));
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            AVMDLLog.d(TAG, String.format("remove host:%s", this.host));
            AVMDLDNSParser.getInstance().removeHost(this.host, this);
            AVMDLLog.d(TAG, String.format("****end call release:%s", this));
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public int start(long j4, String str) {
        int parserResult = v2Usable ? parserResult(j4, str, 2) : 0;
        return parserResult <= 0 ? parserResult(j4, str, 1) : parserResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parserResult(int r18, java.lang.String r19, java.lang.String r20, long r21, java.lang.String r23, int r24, int r25) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "AVMDLDNSParserBridge"
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.lock()
            r3 = 0
            boolean r0 = r1.isFinish     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r4 = 3
            r5 = 2
            r6 = 1
            if (r0 != 0) goto L9d
            java.util.Locale r0 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.String r7 = "receive completion code:%d result:%s type:%d"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.Integer r8 = java.lang.Integer.valueOf(r18)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r4[r3] = r8     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            boolean r8 = android.text.TextUtils.isEmpty(r20)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            if (r8 == 0) goto L26
            java.lang.String r8 = "null"
            goto L28
        L26:
            r8 = r20
        L28:
            r4[r6] = r8     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.Integer r8 = java.lang.Integer.valueOf(r24)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r4[r5] = r8     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.String r4 = java.lang.String.format(r0, r7, r4)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog.d(r2, r4)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            boolean r4 = android.text.TextUtils.isEmpty(r20)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r7 = 0
            if (r4 == 0) goto L73
            r4 = 5
            int r4 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser.getIntValue(r4)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            if (r4 != r6) goto L73
            java.lang.String r4 = "pare result is null, try get backupip"
            com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog.d(r2, r4)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            com.bykv.vk.component.ttvideo.mediakit.net.IPCache r4 = com.bykv.vk.component.ttvideo.mediakit.net.IPCache.getInstance()     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r11 = r19
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSInfo r4 = r4.getBackUpIp(r11)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            if (r4 == 0) goto L75
            java.lang.String r9 = r4.mIpList     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            int r4 = r4.mType     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.String r10 = "get backup ip, result:%s type:%d"
            java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r12[r3] = r9     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.Integer r13 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r12[r6] = r13     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.String r0 = java.lang.String.format(r0, r10, r12)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog.d(r2, r0)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r16 = r4
            r13 = r7
            r12 = r9
            goto L7b
        L73:
            r11 = r19
        L75:
            r12 = r20
            r13 = r21
            r16 = r24
        L7b:
            r1.ipList = r12     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r1.isFinish = r6     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            long r9 = r1.handle     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 == 0) goto Lcb
            r0 = r25
            if (r0 != r5) goto L93
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r6     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r11 = r19
            r15 = r23
            _notifyParserResultV2(r9, r11, r12, r13, r15, r16)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            goto Lcb
        L93:
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r3     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r11 = r19
            r15 = r23
            _notifyParserResult(r9, r11, r12, r13, r15)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            goto Lcb
        L9d:
            java.util.Locale r0 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.String r7 = "has finished not nedd cur completion code:%d result:%s expiredTime:%d"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.Integer r8 = java.lang.Integer.valueOf(r18)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r4[r3] = r8     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r4[r6] = r20     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.Long r6 = java.lang.Long.valueOf(r21)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            r4[r5] = r6     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            java.lang.String r0 = java.lang.String.format(r0, r7, r4)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog.d(r2, r0)     // Catch: java.lang.Throwable -> Lb9 java.lang.UnsatisfiedLinkError -> Lbb
            goto Lcb
        Lb9:
            r0 = move-exception
            goto Ld1
        Lbb:
            r0 = move-exception
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lb9
            com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog.d(r2, r0)     // Catch: java.lang.Throwable -> Lb9
            boolean r0 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable     // Catch: java.lang.Throwable -> Lb9
            if (r0 == 0) goto Lc9
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r3     // Catch: java.lang.Throwable -> Lb9
        Lc9:
            r1.isFinish = r3     // Catch: java.lang.Throwable -> Lb9
        Lcb:
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.unlock()
            return
        Ld1:
            java.util.concurrent.locks.Lock r2 = r1.lock
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.parserResult(int, java.lang.String, java.lang.String, long, java.lang.String, int, int):void");
    }
}
