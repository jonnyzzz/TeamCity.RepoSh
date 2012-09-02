package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.vcs.*;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Map;

/**
 * @author Eugene Petrenko (eugene.petrenko@gmail.com)
 *         Date: 31.08.12 16:58
 */
public class RepoShVcsSupport extends ServerVcsSupport {
  @NotNull
  public String getCurrentVersion(@NotNull VcsRoot root) throws VcsException {
    return null;
  }

  public boolean sourcesUpdatePossibleIfChangesNotFound(@NotNull VcsRoot root) {
    return false;
  }

  @NotNull
  public String getName() {
    return "repo.sh";
  }

  @NotNull
  public String getDisplayName() {
    return "git-repo checkout";
  }

  public PropertiesProcessor getVcsPropertiesProcessor() {
    return null;
  }

  @NotNull
  public String getVcsSettingsJspFilePath() {
    return null;
  }

  @NotNull
  public String describeVcsRoot(VcsRoot vcsRoot) {
    return null;
  }

  public Map<String, String> getDefaultVcsProperties() {
    return null;
  }

  public String getVersionDisplayName(@NotNull String version, @NotNull VcsRoot root) throws VcsException {
    return null;
  }

  @NotNull
  public Comparator<String> getVersionComparator() {
    return null;
  }

  @NotNull
  public VcsFileContentProvider getContentProvider() {
    return null;
  }

  @NotNull
  public CollectChangesPolicy getCollectChangesPolicy() {
    return null;
  }

  @NotNull
  public BuildPatchPolicy getBuildPatchPolicy() {
    return null;
  }
}
