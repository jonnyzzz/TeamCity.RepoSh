package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.vcs.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Eugene Petrenko (eugene.petrenko@gmail.com)
 * Date: 02.09.12 14:21
 */
public class RepoShCollectChangesPolicy implements CollectChangesByCheckoutRules, CollectChangesBetweenRoots {
  @NotNull
  private final GitPluginProxy myProxy;

  public RepoShCollectChangesPolicy(@NotNull final GitPluginProxy proxy) {
    myProxy = proxy;
  }

  @NotNull
  public List<ModificationData> collectChanges(@NotNull VcsRoot fromRoot,
                                               @NotNull String fromVersion,
                                               @NotNull VcsRoot toRoot,
                                               @Nullable String toVersion,
                                               @NotNull CheckoutRules checkoutRules) throws VcsException {
    throw new VcsException("Not implemented");
  }

  public List<ModificationData> collectChanges(@NotNull VcsRoot root,
                                               @NotNull String fromVersion,
                                               @Nullable String currentVersion,
                                               @NotNull CheckoutRules checkoutRules) throws VcsException {
    throw new VcsException("Not implemented");
  }
}
