package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.vcs.VcsException;
import jetbrains.buildServer.vcs.VcsManager;
import jetbrains.buildServer.vcs.VcsSupportContext;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Created by Eugene Petrenko (eugene.petrenko@gmail.com)
 * Date: 02.09.12 13:45
 */
public class GitPluginProxy {
  @NotNull
  private final VcsManager myVcs;

  public GitPluginProxy(@NotNull final VcsManager vcs) {
    myVcs = vcs;
  }

  @NotNull
  public VcsSupportContext getGitPlugin() throws VcsException {
    Collection<VcsSupportContext> allVcs = myVcs.getAllVcs();
    for (VcsSupportContext allVc : allVcs) {
      if (allVc.getCore().getName().equals("jetbrains.git")) return allVc;
    }
    throw new VcsException("Failed to find 'jetbrains.git' VCS plugin");
  }
}
