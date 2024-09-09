package xyz.adscope.amps.report.inter;

import java.util.List;
import xyz.adscope.amps.model.AMPSCycleModel;
import xyz.adscope.amps.report.model.request.AMPSReportRequestModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IReportInterface {
    void deleteLog(List<AMPSReportRequestModel> list);

    void reportAdLog(AMPSCycleModel aMPSCycleModel, String str);

    void reportInitLog(String str, String str2);

    void saveLog(AMPSReportRequestModel aMPSReportRequestModel);

    void uploadLog(AMPSReportRequestModel aMPSReportRequestModel);
}
