package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.vcs.BuildPatchByCheckoutRules;
import jetbrains.buildServer.vcs.CheckoutRules;
import jetbrains.buildServer.vcs.VcsException;
import jetbrains.buildServer.vcs.VcsRoot;
import jetbrains.buildServer.vcs.patches.PatchBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

/**
 * Created by Eugene Petrenko (eugene.petrenko@gmail.com)
 * Date: 02.09.12 14:27
 */
public class RepoShBuildPatchPolicy implements BuildPatchByCheckoutRules {
  private final GitPluginProxy myProxy;

  public RepoShBuildPatchPolicy(@NotNull final GitPluginProxy proxy) {
    myProxy = proxy;
  }

  public void buildPatch(@NotNull VcsRoot root,
                         @Nullable String fromVersion,
                         @NotNull String toVersion,
                         @NotNull PatchBuilder builder,
                         @NotNull CheckoutRules checkoutRules) throws IOException, VcsException {
    throw new VcsException("not implemented");
  }
}
