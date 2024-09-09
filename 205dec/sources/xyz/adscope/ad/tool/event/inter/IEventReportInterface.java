package xyz.adscope.ad.tool.event.inter;

import java.util.List;
import xyz.adscope.ad.tool.event.model.AdScopeEventReportModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IEventReportInterface {
    void deleteLog(List<AdScopeEventReportModel> list, String str);

    void saveLog(AdScopeEventReportModel adScopeEventReportModel, String str);

    void uploadLog(AdScopeEventReportModel adScopeEventReportModel, String str);
}
