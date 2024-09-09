package xyz.adscope.ad.config.task;

import java.util.List;
import xyz.adscope.ad.control.template.TemplateManager;
import xyz.adscope.ad.model.http.response.config.TemplateModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeTemplateUpdateTask implements Runnable {
    private List<TemplateModel> templateModelList;

    public AdScopeTemplateUpdateTask(List<TemplateModel> list) {
        this.templateModelList = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        TemplateManager.getInstance().updateTemplateConfig(this.templateModelList);
    }
}
