/*
 * Copyright 2000-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.teamcity.caldav.data;

import jetbrains.buildServer.serverSide.SBuildServer;
import jetbrains.buildServer.serverSide.SBuildType;
import jetbrains.buildServer.serverSide.SProject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ServerBuildTypesProvider implements BuildTypesProvider {

  @NotNull
  private final SBuildServer server;

  public ServerBuildTypesProvider(@NotNull SBuildServer server) {
    this.server = server;
  }

  @NotNull
  public List<SBuildType> getActiveBuildTypes() {
    return server.getProjectManager().getActiveBuildTypes();
  }

  @NotNull
  public List<SBuildType> getProjectBuildTypes(@NotNull SProject project) {
    return project.getBuildTypes();
  }
}
