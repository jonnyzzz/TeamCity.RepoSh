package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.WebControllerManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Eugene Petrenko (eugene.petrenko@gmail.com)
 * Date: 02.09.12 13:56
 */
public class RepoShController extends BaseController implements RepoShPaths {
  private final String myPath;
  @NotNull
  private final GitPluginProxy myProxy;
  private final PluginDescriptor myDescriptor;

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
}
