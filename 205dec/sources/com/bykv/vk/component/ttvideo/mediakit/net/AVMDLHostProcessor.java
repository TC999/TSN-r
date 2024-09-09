package com.bykv.vk.component.ttvideo.mediakit.net;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVMDLHostProcessor {
    private static final int BACKUP_DNS = 1;
    private static final int MAIN_DNS = 0;
    public static final int STATE_IS_IDLE = 0;
    public static final int STATE_IS_PARSE_END_ERROR = 2;
    public static final int STATE_IS_PARSE_END_SUC = 3;
    public static final int STATE_IS_WAIT_RESULT = 1;
    private static final String TAG = "AVMDLHostProcessor";
    private int mBackUpDelayedTime;
    private int mBackUpType;
    private int mEnableParallel;
    private Handler mHandler;
    public String mHost;
    public HashMap<AVMDLDNSParserListener, Integer> mListeners;
    private int mMainType;
    private int[] mStates = new int[2];
    private BaseDNS[] mParsers = new BaseDNS[2];

    public AVMDLHostProcessor(String str, Handler handler, int i4, int i5, int i6, int i7) {
        this.mMainType = i4;
        this.mBackUpType = i5;
        this.mHandler = handler;
        this.mHost = str;
        this.mBackUpDelayedTime = i6;
        this.mEnableParallel = i7;
        for (int i8 = 0; i8 < 2; i8++) {
            this.mParsers[i8] = null;
        }
        for (int i9 = 0; i9 < 2; i9++) {
            this.mStates[i9] = 0;
        }
        this.mListeners = new HashMap<>();
    }

    @SuppressLint({"CI_DefaultLocale"})
    private BaseDNS createDNSParser(String str, int i4, int i5) {
        CreateConstructor createConstructor;
        try {
            createConstructor = AVMDLDNSManager.getInstance().getCreateConstructor(i4);
        } catch (Exception e4) {
            e4.printStackTrace();
            createConstructor = null;
        }
        if (createConstructor != null) {
            return createConstructor.createDns(str, null, i4, this.mHandler);
        }
        if (i4 == 4 && AVMDLDNSParser.mCustomHttpDNSParser != null) {
            AVMDLLog.d(TAG, String.format("create custom httpdns parser for host:%s type:%d", str, Integer.valueOf(i4)));
            return new CustomHTTPDNS(str, this.mHandler);
        }
        AVMDLLog.d(TAG, String.format("create local dns parser for host:%s type:%d", str, Integer.valueOf(i4)));
        return new LocalDNS(str, this.mHandler);
    }

    private void doParseInternal(int i4, AVMDLDNSInfo aVMDLDNSInfo) {
        AVMDLLog.d(TAG, String.format("----do parse internal what:%d info:%s", Integer.valueOf(i4), aVMDLDNSInfo));
        if (aVMDLDNSInfo == null) {
            return;
        }
        if (i4 == 5 && this.mParsers[0] == null) {
            AVMDLLog.d(TAG, String.format("create main dns type:%d host:%s", Integer.valueOf(this.mMainType), aVMDLDNSInfo.mHost));
            this.mStates[0] = 1;
            this.mParsers[0] = createDNSParser(aVMDLDNSInfo.mHost, this.mMainType, 0);
            this.mParsers[0].start();
            Message message = new Message();
            message.what = 6;
            message.obj = aVMDLDNSInfo;
            if (this.mBackUpDelayedTime > 0 || this.mEnableParallel > 0) {
                AVMDLLog.d(TAG, String.format("BackUpDelayedTime:%d enableparallel:%d send backup delay first", Integer.valueOf(this.mMainType), Integer.valueOf(this.mEnableParallel)));
                this.mHandler.sendMessageDelayed(message, this.mBackUpDelayedTime * 1000);
            }
        } else if (i4 == 6 && this.mParsers[1] == null) {
            AVMDLLog.d(TAG, String.format("create backup dns type:%d host:%s", Integer.valueOf(this.mBackUpType), aVMDLDNSInfo.mHost));
            this.mStates[1] = 1;
            this.mParsers[1] = createDNSParser(aVMDLDNSInfo.mHost, this.mBackUpType, 1);
            this.mParsers[1].start();
        }
        AVMDLLog.d(TAG, String.format("****do parse internal end", new Object[0]));
    }

    public boolean isEnd() {
        for (int i4 = 0; i4 < 2; i4++) {
            if (this.mParsers[i4] != null) {
                int[] iArr = this.mStates;
                if (iArr[i4] != 3 && iArr[i4] != 2) {
                    return false;
                }
            }
        }
        AVMDLLog.d(TAG, "all dns parse is end");
        return true;
    }

    public boolean isValidSourceId(String str) {
        if (TextUtils.isEmpty(str)) {
            AVMDLLog.d(TAG, String.format("id: %s is empty", str));
            return false;
        }
        for (int i4 = 0; i4 < 2; i4++) {
            BaseDNS[] baseDNSArr = this.mParsers;
            if (baseDNSArr[i4] != null && str.equals(baseDNSArr[i4].mId)) {
                AVMDLLog.d(TAG, String.format("id: %s is valid index: %d", str, Integer.valueOf(i4)));
                return true;
            }
        }
        AVMDLLog.d(TAG, String.format("id: %s is valid", str));
        return false;
    }

    public void processMsg(int i4, AVMDLDNSInfo aVMDLDNSInfo) {
        AVMDLLog.d(TAG, String.format("----processor pro msg what:%d host:%s info:%s", Integer.valueOf(i4), aVMDLDNSInfo.mHost, aVMDLDNSInfo));
        if (i4 != 5) {
            if (i4 == 6) {
                int[] iArr = this.mStates;
                if ((iArr[0] == 1 || iArr[0] == 2 || iArr[0] == 3 || this.mEnableParallel > 0) && iArr[1] == 0) {
                    AVMDLLog.d(TAG, String.format("main dns is not end or enable parrallel and backup dns is idle call backup dns", new Object[0]));
                    doParseInternal(i4, aVMDLDNSInfo);
                }
            }
        } else if (this.mStates[0] == 0) {
            AVMDLLog.d(TAG, String.format("main dns is idle call main dns", new Object[0]));
            doParseInternal(i4, aVMDLDNSInfo);
        }
        AVMDLLog.d(TAG, String.format("****end processor pro msg what:%d host:%s info:%s", Integer.valueOf(i4), aVMDLDNSInfo.mHost, aVMDLDNSInfo));
    }

    public void processResult(int i4, AVMDLDNSInfo aVMDLDNSInfo) {
        AVMDLLog.d(TAG, String.format("----process result what:%d id:%s host:%s", Integer.valueOf(i4), aVMDLDNSInfo.mId, aVMDLDNSInfo.mHost));
        String str = (i4 == 2 || i4 == 3) ? aVMDLDNSInfo.mId : null;
        if (TextUtils.isEmpty(str)) {
            AVMDLLog.d(TAG, String.format("****process result err id is empty", new Object[0]));
            return;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                break;
            }
            BaseDNS[] baseDNSArr = this.mParsers;
            if (baseDNSArr[i5] == null || !str.equals(baseDNSArr[i5].mId)) {
                i5++;
            } else {
                this.mParsers[i5].close();
                this.mParsers[i5] = null;
                if (i4 == 3) {
                    this.mStates[i5] = 3;
                } else if (i4 == 2) {
                    this.mStates[i5] = 2;
                }
                AVMDLLog.d(TAG, String.format("****process result parser index:%d is end, be close", Integer.valueOf(i5)));
            }
        }
        if (i5 == 0 && i4 == 2) {
            AVMDLLog.d(TAG, String.format("mian dns parse error, try back up dns", new Object[0]));
            processMsg(6, new AVMDLDNSInfo(this.mBackUpType, aVMDLDNSInfo.mHost, (String) null, 0L, (String) null));
        }
        AVMDLLog.d(TAG, String.format("****end process result what:%d id:%s host:%s", Integer.valueOf(i4), aVMDLDNSInfo.mId, aVMDLDNSInfo.mHost));
    }
}
