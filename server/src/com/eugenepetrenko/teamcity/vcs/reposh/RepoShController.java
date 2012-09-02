package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.vcs.VcsException;
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
  private final String myPath;
  @NotNull
  private final GitPluginProxy myProxy;
  private final PluginDescriptor myDescriptor;
  private PropertiesProcessor myVcsPropertiesProcessor;

  public RepoShController(@NotNull final GitPluginProxy proxy,
                          @NotNull final PluginDescriptor desc,
                          @NotNull final WebControllerManager web) {
    myProxy = proxy;
    myDescriptor = desc;
    myPath = desc.getPluginResourcesPath("reposh-settings.html");
    web.registerController(myPath, this);
  }

  @NotNull
  public String getSettingsUrl() {
    return myPath;
  }

  @Nullable
  @Override
  protected ModelAndView doHandle(@NotNull final HttpServletRequest request,
                                  @NotNull final HttpServletResponse response) throws Exception {
    ModelAndView mv = new ModelAndView(myDescriptor.getPluginResourcesPath("reposh-settings.jsp"));
    mv.getModel().put("gitsettings", myProxy.getGitPlugin().getCore().getVcsSettingsJspFilePath());
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
