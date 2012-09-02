package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.vcs.VcsException;
import jetbrains.buildServer.vcs.VcsSupportCore;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.WebControllerManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Eugene Petrenko (eugene.petrenko@gmail.com)
 * Date: 02.09.12 13:56
 */
public class RepoShController extends BaseController {
  private static final String REPOSH_SETTINGS_HTML = "reposh-settings.html";

  private final GitPluginProxy myProxy;
  private final PluginDescriptor myDescriptor;

  public RepoShController(@NotNull final GitPluginProxy proxy,
                          @NotNull final PluginDescriptor desc,
                          @NotNull final WebControllerManager web) {
    myProxy = proxy;
    myDescriptor = desc;
    String path = desc.getPluginResourcesPath(REPOSH_SETTINGS_HTML);
    web.registerController(path, this);
  }

  @NotNull
  public String getSettingsPath() {
    //Default path is /plugins/<vcs name>/<path returned here>
    //In our setup we assume paths are same to let it work.
    return REPOSH_SETTINGS_HTML;
  }

  @Nullable
  @Override
  protected ModelAndView doHandle(@NotNull final HttpServletRequest request,
                                  @NotNull final HttpServletResponse response) throws Exception {
    ModelAndView mv = new ModelAndView(myDescriptor.getPluginResourcesPath("reposh-settings.jsp"));
    VcsSupportCore core = myProxy.getGitPlugin().getCore();
    //have to workaround obsolete API usage
    mv.getModel().put("gitsettings", "/plugins/" + core.getName() + "/" + core.getVcsSettingsJspFilePath());
    return mv;
  }

  public PropertiesProcessor getVcsPropertiesProcessor() {
    return new PropertiesProcessor() {
      public Collection<InvalidProperty> process(Map<String, String> properties) {
        final List<InvalidProperty> props = new ArrayList<InvalidProperty>();

        final PropertiesProcessor proc = getVcsPropertiesProcessor();
        if (proc != null) {
          Collection<InvalidProperty> res = proc.process(properties);
          if (res != null) props.addAll(res);
        }
        return props;
      }

      @Nullable
      private PropertiesProcessor getVcsPropertiesProcessor() {
        try {
          return myProxy.getGitPlugin().getCore().getVcsPropertiesProcessor();
        } catch (VcsException e) {
          return null;
        }
      }
    };
  }
}
