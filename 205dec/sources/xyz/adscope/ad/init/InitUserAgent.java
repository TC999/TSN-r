package xyz.adscope.ad.init;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.ad.tool.thread.AdScopeThreadPool;
import xyz.adscope.ad.tool.widget.AdscopeWebView;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InitUserAgent {
    public static final int USER_AGENT_MESSAGE = 1;
    private ScheduledExecutorService executor;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.ad.init.InitUserAgent.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 1) {
                return;
            }
            try {
                AdScopeSDK.userAgent = new AdscopeWebView(InitUserAgent.this.mContext).getSettings().getUserAgentString();
                AdScopeSpUtil.putString(CommonConstants.USER_AGENT_KEY, AdScopeSDK.userAgent);
                InitUserAgent.this.stopSchedulerTask();
            } catch (Exception e4) {
                String str = Constants.TAG;
                LogUtil.i(str, "e : " + e4);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void stopSchedulerTask() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public void getUserAgent(Context context) {
        ScheduledExecutorService scheduledExecutorService = AdScopeThreadPool.getScheduledExecutorService();
        this.executor = scheduledExecutorService;
        this.mContext = context;
        scheduledExecutorService.schedule(new Runnable() { // from class: xyz.adscope.ad.init.InitUserAgent.2
            @Override // java.lang.Runnable
            public void run() {
                InitUserAgent.this.mHandler.sendEmptyMessage(1);
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }
}
