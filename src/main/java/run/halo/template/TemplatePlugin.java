package run.halo.template;

import org.pf4j.PluginWrapper;
import run.halo.app.extension.Scheme;
import run.halo.app.extension.SchemeManager;
import run.halo.app.plugin.BasePlugin;

/**
 * @author guqing
 * @since 2.0.0
 */
public class TemplatePlugin extends BasePlugin {
    private final SchemeManager schemeManager;

    public TemplatePlugin(PluginWrapper wrapper) {
        super(wrapper);
        this.schemeManager = getApplicationContext().getBean(SchemeManager.class);
    }

    @Override
    public void start() {
        schemeManager.register(Apple.class);
    }

    @Override
    public void stop() {
        Scheme scheme = schemeManager.get(Apple.class);
        schemeManager.unregister(scheme);
    }
}
