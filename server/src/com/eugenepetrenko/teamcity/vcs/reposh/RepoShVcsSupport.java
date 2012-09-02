package com.eugenepetrenko.teamcity.vcs.reposh;

import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.util.CaseInsensitiveStringComparator;
import jetbrains.buildServer.vcs.*;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * @author Eugene Petrenko (eugene.petrenko@gmail.com)
 *         Date: 31.08.12 16:58
 */
public class RepoShVcsSupport extends ServerVcsSupport {
  private final RepoShController myPaths;
  private final RepoShFileContentProvider myFileContentProvider;
  private final RepoShCurrentVersion myCurrentVersion;
  private final RepoShCollectChangesPolicy myCollectChangesPolicy;
  private final RepoShBuildPatchPolicy myBuildPatchPolicy;

  public RepoShVcsSupport(@NotNull final RepoShController paths,
                          @NotNull final RepoShFileContentProvider fileContentProvider,
                          @NotNull final RepoShCurrentVersion currentVersion,
                          @NotNull final RepoShCollectChangesPolicy collectChangesPolicy,
                          @NotNull final RepoShBuildPatchPolicy buildPatchPolicy) {
    myPaths = paths;
    myFileContentProvider = fileContentProvider;
    myCurrentVersion = currentVersion;
    myCollectChangesPolicy = collectChangesPolicy;
    myBuildPatchPolicy = buildPatchPolicy;
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
    return myPaths.getSettingsUrl();
  }

  @NotNull
  public String describeVcsRoot(VcsRoot vcsRoot) {
    return "repo.sh root" + vcsRoot.getName();
  }

  public Map<String, String> getDefaultVcsProperties() {
    return Collections.emptyMap();
  }

  public String getVersionDisplayName(@NotNull String version, @NotNull VcsRoot root) throws VcsException {
    return version;
  }

  @NotNull
  public Comparator<String> getVersionComparator() {
    return new CaseInsensitiveStringComparator();
  }

  @NotNull
  public VcsFileContentProvider getContentProvider() {
    return myFileContentProvider;
  }

  @NotNull
  public String getCurrentVersion(@NotNull VcsRoot root) throws VcsException {
    return myCurrentVersion.getCurrentVersion(root);
  }

  @NotNull
  public CollectChangesPolicy getCollectChangesPolicy() {
    return myCollectChangesPolicy;
  }

  @NotNull
  public BuildPatchPolicy getBuildPatchPolicy() {
    return myBuildPatchPolicy;
  }
}
