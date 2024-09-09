package xyz.adscope.amps.manager;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.model.config.response.FrequencyModel;
import xyz.adscope.amps.model.frequency.AMPSFrequencyEventModel;
import xyz.adscope.amps.tool.persistent.db.AMPSDataBaseManager;
import xyz.adscope.amps.tool.util.AMPSDateUtil;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSFrequencyManager {
    static final String KEY_TABLE_NAME = "amps_frequency_event_table";
    private static AMPSFrequencyManager instance;
    private AMPSDataBaseManager mAmpsDataBaseManager;
    private static Map<String, List<AMPSFrequencyEventModel>> mMediationFrequencyData = new HashMap();
    private static Map<String, List<AMPSFrequencyEventModel>> mAdSourceFrequencyData = new HashMap();
    private static Comparator<AMPSFrequencyEventModel> mComparator = new Comparator<AMPSFrequencyEventModel>() { // from class: xyz.adscope.amps.manager.AMPSFrequencyManager.1
        @Override // java.util.Comparator
        public int compare(AMPSFrequencyEventModel aMPSFrequencyEventModel, AMPSFrequencyEventModel aMPSFrequencyEventModel2) {
            return aMPSFrequencyEventModel2.getEventTime().compareTo(aMPSFrequencyEventModel.getEventTime());
        }
    };

    public static synchronized AMPSFrequencyManager getInstance() {
        AMPSFrequencyManager aMPSFrequencyManager;
        synchronized (AMPSFrequencyManager.class) {
            if (instance == null) {
                synchronized (AMPSFrequencyManager.class) {
                    instance = new AMPSFrequencyManager();
                }
            }
            aMPSFrequencyManager = instance;
        }
        return aMPSFrequencyManager;
    }

    private void putAdsourceFrequencyData(AMPSFrequencyEventModel aMPSFrequencyEventModel) {
        if (aMPSFrequencyEventModel == null) {
            return;
        }
        try {
            String adSourceSpaceId = aMPSFrequencyEventModel.getAdSourceSpaceId();
            if (TextUtils.isEmpty(adSourceSpaceId)) {
                return;
            }
            List<AMPSFrequencyEventModel> list = mAdSourceFrequencyData.containsKey(adSourceSpaceId) ? mAdSourceFrequencyData.get(adSourceSpaceId) : null;
            if (list == null || list.size() == 0) {
                list = new ArrayList<>();
            }
            list.add(aMPSFrequencyEventModel);
            Collections.sort(list, mComparator);
            mAdSourceFrequencyData.put(adSourceSpaceId, list);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void putMediationFrequencyData(AMPSFrequencyEventModel aMPSFrequencyEventModel) {
        if (aMPSFrequencyEventModel == null) {
            return;
        }
        try {
            String mediationSpaceId = aMPSFrequencyEventModel.getMediationSpaceId();
            if (TextUtils.isEmpty(mediationSpaceId)) {
                return;
            }
            List<AMPSFrequencyEventModel> list = mMediationFrequencyData.containsKey(mediationSpaceId) ? mMediationFrequencyData.get(mediationSpaceId) : null;
            if (list == null || list.size() == 0) {
                list = new ArrayList<>();
            }
            list.add(aMPSFrequencyEventModel);
            Collections.sort(list, mComparator);
            mMediationFrequencyData.put(mediationSpaceId, list);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void initFrequencyData(String str) {
        try {
            if (this.mAmpsDataBaseManager == null) {
                this.mAmpsDataBaseManager = new AMPSDataBaseManager(AMPSSDKManager.getInstance().getContext());
            }
            AMPSDataBaseManager aMPSDataBaseManager = this.mAmpsDataBaseManager;
            aMPSDataBaseManager.setTableNameAndModel("amps_frequency_event_table_" + str, AMPSFrequencyEventModel.class);
            if (mMediationFrequencyData.containsKey(str)) {
                return;
            }
            System.currentTimeMillis();
            if (this.mAmpsDataBaseManager == null) {
                return;
            }
            AMPSFrequencyEventModel aMPSFrequencyEventModel = new AMPSFrequencyEventModel();
            aMPSFrequencyEventModel.setEventTime(String.valueOf(AMPSDateUtil.getTimeMillisBeforeDay(2)));
            this.mAmpsDataBaseManager.deleteOutTime(aMPSFrequencyEventModel);
            AMPSFrequencyEventModel aMPSFrequencyEventModel2 = new AMPSFrequencyEventModel();
            aMPSFrequencyEventModel2.setMediationSpaceId(str);
            putFrequencyData(str, this.mAmpsDataBaseManager.query(aMPSFrequencyEventModel2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isPassAdSourceFrequencyLimit(String str, FrequencyModel frequencyModel) {
        List<AMPSFrequencyEventModel> list;
        try {
            if (!TextUtils.isEmpty(str) && frequencyModel != null) {
                long time = frequencyModel.getTime();
                String event = frequencyModel.getEvent();
                if (time != 0 && !TextUtils.isEmpty(event) && mAdSourceFrequencyData.containsKey(str) && (list = mAdSourceFrequencyData.get(str)) != null && list.size() != 0) {
                    int count = frequencyModel.getCount();
                    String valueOf = String.valueOf(System.currentTimeMillis() - time);
                    int i4 = 0;
                    for (AMPSFrequencyEventModel aMPSFrequencyEventModel : list) {
                        if (aMPSFrequencyEventModel != null && !TextUtils.isEmpty(aMPSFrequencyEventModel.getEventCode()) && !TextUtils.isEmpty(aMPSFrequencyEventModel.getEventTime())) {
                            String eventCode = aMPSFrequencyEventModel.getEventCode();
                            String eventTime = aMPSFrequencyEventModel.getEventTime();
                            if (event.equalsIgnoreCase(eventCode)) {
                                if (eventTime.compareTo(valueOf) > 0) {
                                    i4++;
                                }
                                LogUtil.d(AMPSConstants.AMPS_LOG_TAG, "filter isPassAdSourceFrequencyLimit tempFrequencyCount:" + i4 + ";eventCode:" + event + ";spaceId:" + str + ";eventTime:" + eventTime + ";compareTo:" + eventTime.compareTo(valueOf));
                                if (i4 >= count) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    public boolean isPassMediationFrequencyLimit(String str, FrequencyModel frequencyModel) {
        List<AMPSFrequencyEventModel> list;
        try {
            if (!TextUtils.isEmpty(str) && frequencyModel != null) {
                long time = frequencyModel.getTime();
                String event = frequencyModel.getEvent();
                if (time != 0 && !TextUtils.isEmpty(event) && mMediationFrequencyData.containsKey(str) && (list = mMediationFrequencyData.get(str)) != null && list.size() != 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - time);
                    int count = frequencyModel.getCount();
                    int i4 = 0;
                    for (AMPSFrequencyEventModel aMPSFrequencyEventModel : list) {
                        if (aMPSFrequencyEventModel != null && !TextUtils.isEmpty(aMPSFrequencyEventModel.getEventCode()) && !TextUtils.isEmpty(aMPSFrequencyEventModel.getEventTime())) {
                            String eventCode = aMPSFrequencyEventModel.getEventCode();
                            String eventTime = aMPSFrequencyEventModel.getEventTime();
                            if (event.equalsIgnoreCase(eventCode) && (!"request".equalsIgnoreCase(eventCode) || TextUtils.isEmpty(aMPSFrequencyEventModel.getAdSourceSpaceId()))) {
                                if (event.equalsIgnoreCase(eventCode) && eventTime.compareTo(valueOf) > 0) {
                                    i4++;
                                }
                                if (i4 >= count) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    public void putFrequencyData(AMPSFrequencyEventModel aMPSFrequencyEventModel) {
        if (aMPSFrequencyEventModel == null) {
            return;
        }
        try {
            putMediationFrequencyData(aMPSFrequencyEventModel);
            putAdsourceFrequencyData(aMPSFrequencyEventModel);
            AMPSDataBaseManager aMPSDataBaseManager = this.mAmpsDataBaseManager;
            if (aMPSDataBaseManager != null) {
                aMPSDataBaseManager.insert(aMPSFrequencyEventModel);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void putFrequencyData(String str, List<AMPSFrequencyEventModel> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                for (AMPSFrequencyEventModel aMPSFrequencyEventModel : list) {
                    putAdsourceFrequencyData(aMPSFrequencyEventModel);
                }
                ArrayList arrayList = new ArrayList();
                for (List<AMPSFrequencyEventModel> list2 : mAdSourceFrequencyData.values()) {
                    arrayList.addAll(list2);
                }
                if (arrayList.size() > 0) {
                    mMediationFrequencyData.put(str, arrayList);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
