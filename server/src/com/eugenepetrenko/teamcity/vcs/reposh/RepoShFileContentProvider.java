package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.vcs.*;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Eugene Petrenko (eugene.petrenko@gmail.com)
 * Date: 02.09.12 14:08
 */
public class RepoShFileContentProvider implements VcsFileContentProvider {
  private final GitPluginProxy myProxy;

  public RepoShFileContentProvider(@NotNull final GitPluginProxy proxy) {
    myProxy = proxy;
  }

  @NotNull
  public byte[] getContent(@NotNull final VcsModification vcsModification,
                           @NotNull final VcsChangeInfo change,
                           @NotNull final VcsChangeInfo.ContentType contentType,
                           @NotNull final VcsRoot vcsRoot) throws VcsException {
    throw new VcsException("Not implemented");
  }

  @NotNull
  public byte[] getContent(@NotNull final String filePath,
                           @NotNull final VcsRoot versionedRoot,
                           @NotNull final String version) throws VcsException {
    throw new VcsException("Not implemented");
  }
}
