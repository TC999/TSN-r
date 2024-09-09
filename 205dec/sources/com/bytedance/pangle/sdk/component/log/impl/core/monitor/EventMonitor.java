package com.bytedance.pangle.sdk.component.log.impl.core.monitor;

import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.ILogNetDepend;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class EventMonitor {
    public static final String AD_EXTRA_DATA = "ad_extra_data";
    public static final String AD_STAGING_FLAG = "_ad_staging_flag";
    public static final String ALL_STAGING_ADLOG = "all";
    public static final String DID_SAVE_COUNT = "did_save_count";
    public static final String DID_SEND_COUNT = "did_send_count";
    public static final String EVENT_EXTRA = "event_extra";
    public static final String HAVE_SEND_RESULT_COUNT = "have_send_result_count";
    public static final String KEY_SDK_EVENT_INDEX = "sdk_event_index";
    public static final String KEY_SDK_EVENT_VALID_INDEX = "sdk_event_valid_index";
    public static final String KEY_SDK_SESSION_ID = "sdk_session_id";
    public static final String REQUEST_COUNT = "request_count";
    public static final String REQUEST_FAIL_COUNT = "request_fail_count";
    public static final String REQUEST_SUCCESS_COUNT = "request_success_count";
    public static final String SAVE_FAIL_COUNT = "save_fail_count";
    public static final String SAVE_SUCCESS_COUNT = "save_success_count";
    public static final String SAVE_SUCCESS_LABELS = "save_success_labels";
    public static final String SDK_EVENT_SELF_COUNT = "sdk_event_self_count";
    public static final String SDK_SEND_SUCCESS_COUNT = "sdk_send_success_count";
    public static final String SEND_FAIL_COUNT = "send_fail_count";
    public static final String SEND_SUCCESS_INVALID_COUNT = "send_success_invalid_count";
    public static final String SEND_SUCCESS_VALID_COUNT = "send_success_valid_count";
    public static final String SEND_SUCCESS_VALID_LABELS = "send_success_valid_labels";
    public static final int STAGING_FLAG_V1 = 1;
    public static final int STAGING_FLAG_V3 = 3;
    public static final String STATS_INDEX = "stats_index";
    public static final String V1_LABEL = "label";
    public static final String V1_STAGING_ADLOG = "v1";
    public static final String V3_EVENT = "event";
    public static final String V3_PARAMS = "params";
    public static final String V3_STAGING_ADLOG = "v3";
    public static final String WILL_SAVE_COUNT = "will_save_count";
    public static final String WILL_SAVE_LABELS = "will_save_labels";
    public static final String WILL_SEND_COUNT = "will_send_count";
    public static final String WILL_SEND_LABELS = "will_send_labels";
    private AtomicLong create_save_cost_ts = new AtomicLong(0);
    private AtomicLong save_success_count = new AtomicLong(0);
    private AtomicLong save_upload_cost_ts = new AtomicLong(0);
    private AtomicLong will_send_count = new AtomicLong(0);
    private AtomicLong all_delete_count = new AtomicLong(0);
    private AtomicLong success_delete_count = new AtomicLong(0);
    private AtomicLong invalid_delete_count = new AtomicLong(0);
    private AtomicLong send_fail_count = new AtomicLong(0);
    private AtomicLong will_save_count = new AtomicLong(0);
    private AtomicLong did_send_count = new AtomicLong(0);
    private AtomicLong send_success_valid_count = new AtomicLong(0);
    private AtomicLong sdk_send_success_count = new AtomicLong(0);
    private AtomicLong send_success_invalid_count = new AtomicLong(0);
    private AtomicLong request_count = new AtomicLong(0);
    private AtomicLong request_success_count = new AtomicLong(0);
    private AtomicLong request_fail_count = new AtomicLong(0);
    private AtomicLong success_request_cost_ts = new AtomicLong(0);
    private AtomicLong fail_request_cost_ts = new AtomicLong(0);
    private AtomicLong before_save_count = new AtomicLong(0);
    private AtomicLong block_times = new AtomicLong(0);
    private AtomicLong threadmessage_count = new AtomicLong(0);
    private AtomicLong success_threadmessage = new AtomicLong(0);
    private AtomicLong queue_timeout_threadmessage = new AtomicLong(0);
    private AtomicLong after_upload_threadmsssage = new AtomicLong(0);
    private AtomicLong net_retry_threadmessage = new AtomicLong(0);
    private AtomicLong init_threadmessage = new AtomicLong(0);
    private AtomicLong quit_threadmessage = new AtomicLong(0);
    private AtomicLong memory_available_count = new AtomicLong(0);
    private AtomicLong db_available_count = new AtomicLong(0);
    private AtomicLong high_times = new AtomicLong(0);
    private AtomicLong adevent_times = new AtomicLong(0);
    private AtomicLong stats_times = new AtomicLong(0);
    private AtomicLong batch_times = new AtomicLong(0);
    private AtomicLong high_counts = new AtomicLong(0);
    private AtomicLong adevent_counts = new AtomicLong(0);
    private AtomicLong stats_counts = new AtomicLong(0);
    private AtomicLong batch_counts = new AtomicLong(0);
    private AtomicLong high_m_counts = new AtomicLong(0);
    private AtomicLong adevent_m_counts = new AtomicLong(0);
    private AtomicLong stats_m_counts = new AtomicLong(0);
    private AtomicLong batch_m_counts = new AtomicLong(0);
    private AtomicLong high_db_avi = new AtomicLong(0);
    private AtomicLong adevent_db_avi = new AtomicLong(0);
    private AtomicLong stats_db_avi = new AtomicLong(0);
    private AtomicLong batch_db_avi = new AtomicLong(0);
    private AtomicLong stop_counts = new AtomicLong(0);
    private AtomicLong check_return = new AtomicLong(0);
    private AtomicLong check_result = new AtomicLong(0);
    private AtomicLong dispatch_event_count = new AtomicLong(0);
    private AtomicLong time_out_count = new AtomicLong(0);
    private AtomicLong server_net_error = new AtomicLong(0);
    private AtomicLong message_count = new AtomicLong(0);
    private AtomicLong after_count = new AtomicLong(0);
    private AtomicLong after_init_count = new AtomicLong(0);
    private AtomicLong dispatch_init_count = new AtomicLong(0);
    private AtomicLong notify_init_count = new AtomicLong(0);
    private AtomicLong run_false_count = new AtomicLong(0);
    private AtomicLong all_after_count = new AtomicLong(0);
    private AtomicLong enter_count = new AtomicLong(0);

    public JSONObject createEventMonitorJson(long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j5 = getSave_success_count().get();
            long j6 = 1;
            jSONObject.put("create_save_cost_ts_avg", (((float) getCreate_save_cost_ts().get()) * 1.0f) / ((float) (j5 == 0 ? 1L : j5)));
            jSONObject.put(SAVE_SUCCESS_COUNT, j5);
            long j7 = getWill_send_count().get();
            jSONObject.put("save_upload_cost_ts_avg", (((float) getSave_upload_cost_ts().get()) * 1.0f) / ((float) (j7 == 0 ? 1L : j7)));
            jSONObject.put(WILL_SEND_COUNT, j7);
            jSONObject.put(KEY_SDK_EVENT_INDEX, j4);
            jSONObject.put(SDK_SEND_SUCCESS_COUNT, this.sdk_send_success_count.get());
            jSONObject.put("all_delete_count", getAll_delete_count().get());
            jSONObject.put("success_delete_count", getSuccess_delete_count().get());
            jSONObject.put("invalid_delete_count", getInvalid_delete_count().get());
            jSONObject.put(WILL_SAVE_COUNT, getWill_save_count().get());
            jSONObject.put(DID_SEND_COUNT, getDid_send_count().get());
            jSONObject.put(SEND_SUCCESS_VALID_COUNT, getSend_success_valid_count().get());
            long j8 = getSend_fail_count().get();
            jSONObject.put(SEND_SUCCESS_INVALID_COUNT, getSend_success_invalid_count().get());
            jSONObject.put(SEND_FAIL_COUNT, j8);
            jSONObject.put("before_save_count", getBefore_save_count().get());
            jSONObject.put("block_out_times", getBlock_times().get());
            jSONObject.put("tm_count", getThreadmessage_count().get());
            jSONObject.put("success_tm", getSuccess_threadmessage().get());
            jSONObject.put("queue_timeout_tm", getQueue_timeout_threadmessage().get());
            jSONObject.put("after_upload_tm", getAfter_upload_threadmsssage().get());
            jSONObject.put("net_retry_tm", getNet_retry_threadmessage().get());
            jSONObject.put("init_tm", getInit_threadmessage().get());
            jSONObject.put("quit_tm", getQuit_threadmessage().get());
            long j9 = getRequest_success_count().get();
            long j10 = getRequest_fail_count().get();
            jSONObject.put("success_request_cost_ts_avg", (((float) getSuccess_request_cost_ts().get()) * 1.0f) / ((float) (j9 == 0 ? 1L : j9)));
            float f4 = ((float) getFail_request_cost_ts().get()) * 1.0f;
            if (j10 != 0) {
                j6 = j10;
            }
            jSONObject.put("fail_request_cost_ts_avg", f4 / ((float) j6));
            jSONObject.put(REQUEST_COUNT, getRequest_count().get());
            jSONObject.put(REQUEST_SUCCESS_COUNT, j9);
            jSONObject.put(REQUEST_FAIL_COUNT, j10);
            jSONObject.put("is_multi_process", LogInternalManager.getInstance().isSupportMultiProcess());
            jSONObject.put("stop_counts", getStop_counts().get());
            jSONObject.put("check_return", getCheck_return().get());
            jSONObject.put("check_result", getCheck_result().get());
            jSONObject.put("dispatch_event_count", getDispatch_event_count().get());
            jSONObject.put("time_out_count", getTime_out_count().get());
            jSONObject.put("server_net_error", getServer_net_error().get());
            jSONObject.put("message_count", getMessage_count().get());
            jSONObject.put("after_count", getAfter_count().get());
            jSONObject.put("queue_size", LogThreadCenter.instance.getQueue().size());
            jSONObject.put("after_init_count", getAfter_init_count().get());
            jSONObject.put("dispatch_init_count", getDispatch_init_count().get());
            jSONObject.put("notify_init_count", getNotify_init_count().get());
            jSONObject.put("run_false_count", getRun_false_count().get());
            jSONObject.put("all_after_count", getAll_after_count().get());
            jSONObject.put("app_start_time", LogThreadCenter.START_TIME);
            jSONObject.put("app_first_time", LogThreadCenter.FIRST_EVENT_TIME);
            jSONObject.put("enter_count", getEnter_count().get());
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend != null) {
                jSONObject.put("is_debug", adLogDepend.isDebug());
                ILogNetDepend logNetDepend = adLogDepend.getLogNetDepend();
                if (logNetDepend != null) {
                    jSONObject.put("is_plugin", logNetDepend.isPlugin());
                }
                if (adLogDepend.isUploadDebugMessage()) {
                    jSONObject.put("memory_available_count", getMemory_available_count().get());
                    jSONObject.put("db_available_count", getDb_available_count().get());
                    jSONObject.put("high_times", getHigh_times().get());
                    jSONObject.put("adevent_times", getAdevent_times().get());
                    jSONObject.put("stats_times", getStats_times().get());
                    jSONObject.put("batch_times", getBatch_times().get());
                    jSONObject.put("high_counts", getHigh_counts().get());
                    jSONObject.put("adevent_counts", getAdevent_counts().get());
                    jSONObject.put("stats_counts", getStats_counts().get());
                    jSONObject.put("batch_counts", getBatch_counts().get());
                    jSONObject.put("high_m_counts", getHigh_m_counts().get());
                    jSONObject.put("adevent_m_counts", getAdevent_m_counts().get());
                    jSONObject.put("stats_m_counts", getStats_m_counts().get());
                    jSONObject.put("batch_m_counts", getBatch_m_counts().get());
                    jSONObject.put("high_db_avi", getHigh_db_avi().get());
                    jSONObject.put("adevent_db_avi", getAdevent_db_avi().get());
                    jSONObject.put("stats_db_avi", getStats_db_avi().get());
                    jSONObject.put("batch_db_avi", getBatch_db_avi().get());
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public AtomicLong getAdevent_counts() {
        return this.adevent_counts;
    }

    public AtomicLong getAdevent_db_avi() {
        return this.adevent_db_avi;
    }

    public AtomicLong getAdevent_m_counts() {
        return this.adevent_m_counts;
    }

    public AtomicLong getAdevent_times() {
        return this.adevent_times;
    }

    public AtomicLong getAfter_count() {
        return this.after_count;
    }

    public AtomicLong getAfter_init_count() {
        return this.after_init_count;
    }

    public AtomicLong getAfter_upload_threadmsssage() {
        return this.after_upload_threadmsssage;
    }

    public AtomicLong getAll_after_count() {
        return this.all_after_count;
    }

    public AtomicLong getAll_delete_count() {
        return this.all_delete_count;
    }

    public AtomicLong getBatch_counts() {
        return this.batch_counts;
    }

    public AtomicLong getBatch_db_avi() {
        return this.batch_db_avi;
    }

    public AtomicLong getBatch_m_counts() {
        return this.batch_m_counts;
    }

    public AtomicLong getBatch_times() {
        return this.batch_times;
    }

    public AtomicLong getBefore_save_count() {
        return this.before_save_count;
    }

    public AtomicLong getBlock_times() {
        return this.block_times;
    }

    public AtomicLong getCheck_result() {
        return this.check_result;
    }

    public AtomicLong getCheck_return() {
        return this.check_return;
    }

    public AtomicLong getCreate_save_cost_ts() {
        return this.create_save_cost_ts;
    }

    public AtomicLong getDb_available_count() {
        return this.db_available_count;
    }

    public AtomicLong getDid_send_count() {
        return this.did_send_count;
    }

    public AtomicLong getDispatch_event_count() {
        return this.dispatch_event_count;
    }

    public AtomicLong getDispatch_init_count() {
        return this.dispatch_init_count;
    }

    public AtomicLong getEnter_count() {
        return this.enter_count;
    }

    public AtomicLong getFail_request_cost_ts() {
        return this.fail_request_cost_ts;
    }

    public AtomicLong getHigh_counts() {
        return this.high_counts;
    }

    public AtomicLong getHigh_db_avi() {
        return this.high_db_avi;
    }

    public AtomicLong getHigh_m_counts() {
        return this.high_m_counts;
    }

    public AtomicLong getHigh_times() {
        return this.high_times;
    }

    public AtomicLong getInit_threadmessage() {
        return this.init_threadmessage;
    }

    public AtomicLong getInvalid_delete_count() {
        return this.invalid_delete_count;
    }

    public AtomicLong getMemory_available_count() {
        return this.memory_available_count;
    }

    public AtomicLong getMessage_count() {
        return this.message_count;
    }

    public AtomicLong getNet_retry_threadmessage() {
        return this.net_retry_threadmessage;
    }

    public AtomicLong getNotify_init_count() {
        return this.notify_init_count;
    }

    public AtomicLong getQueue_timeout_threadmessage() {
        return this.queue_timeout_threadmessage;
    }

    public AtomicLong getQuit_threadmessage() {
        return this.quit_threadmessage;
    }

    public AtomicLong getRequest_count() {
        return this.request_count;
    }

    public AtomicLong getRequest_fail_count() {
        return this.request_fail_count;
    }

    public AtomicLong getRequest_success_count() {
        return this.request_success_count;
    }

    public AtomicLong getRun_false_count() {
        return this.run_false_count;
    }

    public AtomicLong getSave_success_count() {
        return this.save_success_count;
    }

    public AtomicLong getSave_upload_cost_ts() {
        return this.save_upload_cost_ts;
    }

    public AtomicLong getSdk_send_success_count() {
        return this.sdk_send_success_count;
    }

    public AtomicLong getSend_fail_count() {
        return this.send_fail_count;
    }

    public AtomicLong getSend_success_invalid_count() {
        return this.send_success_invalid_count;
    }

    public AtomicLong getSend_success_valid_count() {
        return this.send_success_valid_count;
    }

    public AtomicLong getServer_net_error() {
        return this.server_net_error;
    }

    public AtomicLong getStats_counts() {
        return this.stats_counts;
    }

    public AtomicLong getStats_db_avi() {
        return this.stats_db_avi;
    }

    public AtomicLong getStats_m_counts() {
        return this.stats_m_counts;
    }

    public AtomicLong getStats_times() {
        return this.stats_times;
    }

    public AtomicLong getStop_counts() {
        return this.stop_counts;
    }

    public AtomicLong getSuccess_delete_count() {
        return this.success_delete_count;
    }

    public AtomicLong getSuccess_request_cost_ts() {
        return this.success_request_cost_ts;
    }

    public AtomicLong getSuccess_threadmessage() {
        return this.success_threadmessage;
    }

    public AtomicLong getThreadmessage_count() {
        return this.threadmessage_count;
    }

    public AtomicLong getTime_out_count() {
        return this.time_out_count;
    }

    public AtomicLong getWill_save_count() {
        return this.will_save_count;
    }

    public AtomicLong getWill_send_count() {
        return this.will_send_count;
    }

    public synchronized void resetEventMonitor() {
        getSave_upload_cost_ts().set(0L);
        getRequest_success_count().set(0L);
        getRequest_fail_count().set(0L);
        getRequest_count().set(0L);
        getFail_request_cost_ts().set(0L);
        getSuccess_request_cost_ts().set(0L);
        getSend_success_invalid_count().set(0L);
        getSend_success_valid_count().set(0L);
        getInvalid_delete_count().set(0L);
        getCreate_save_cost_ts().set(0L);
        getAll_delete_count().set(0L);
        getWill_save_count().set(0L);
        getSuccess_delete_count().set(0L);
        getDid_send_count().set(0L);
        getWill_send_count().set(0L);
        getSave_success_count().set(0L);
        getSend_fail_count().set(0L);
        getBefore_save_count().set(0L);
        getBlock_times().set(0L);
        getThreadmessage_count().set(0L);
        getSuccess_threadmessage().set(0L);
        getQueue_timeout_threadmessage().set(0L);
        getAfter_upload_threadmsssage().set(0L);
        getNet_retry_threadmessage().set(0L);
        getInit_threadmessage().set(0L);
        getQuit_threadmessage().set(0L);
        getMemory_available_count().set(0L);
        getDb_available_count().set(0L);
        getHigh_times().set(0L);
        getAdevent_times().set(0L);
        getStats_times().set(0L);
        getBatch_times().set(0L);
        getHigh_counts().set(0L);
        getAdevent_counts().set(0L);
        getStats_counts().set(0L);
        getBatch_counts().set(0L);
        getStop_counts().set(0L);
        getHigh_m_counts().set(0L);
        getAdevent_m_counts().set(0L);
        getStats_m_counts().set(0L);
        getBatch_m_counts().set(0L);
        getHigh_db_avi().set(0L);
        getAdevent_db_avi().set(0L);
        getStats_db_avi().set(0L);
        getBatch_db_avi().set(0L);
        getCheck_result().set(0L);
        getCheck_return().set(0L);
        getTime_out_count().set(0L);
        getServer_net_error().set(0L);
        getDispatch_event_count().set(0L);
        getMessage_count().set(0L);
        getAfter_count().set(0L);
        getAfter_init_count().set(0L);
        getNotify_init_count().set(0L);
        getDispatch_init_count().set(0L);
        getRun_false_count().set(0L);
        getAll_after_count().set(0L);
        getEnter_count().set(0L);
    }

    public synchronized void setCreateSave(long j4) {
        this.create_save_cost_ts.getAndAdd(j4);
        this.save_success_count.incrementAndGet();
    }
}
