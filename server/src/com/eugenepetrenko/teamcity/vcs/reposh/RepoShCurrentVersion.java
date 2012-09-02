package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.vcs.VcsException;
import jetbrains.buildServer.vcs.VcsRoot;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Eugene Petrenko (eugene.petrenko@gmail.com)
 * Date: 02.09.12 14:12
 */
public class RepoShCurrentVersion {
  private final GitPluginProxy myProxy;

  public RepoShCurrentVersion(@NotNull final GitPluginProxy proxy) {
    myProxy = proxy;
  }

  @NotNull
  public String getCurrentVersion(@NotNull VcsRoot root) throws VcsException {
    return null;
  }

}
