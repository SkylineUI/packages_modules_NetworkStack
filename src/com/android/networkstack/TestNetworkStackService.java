/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.networkstack;

import static com.android.server.util.PermissionUtil.isDebuggableBuild;

import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.android.server.NetworkStackService;

/**
 * A {@link NetworkStackService} that can only be bound to on debuggable builds.
 */
public class TestNetworkStackService extends NetworkStackService {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if (!isDebuggableBuild()) {
            throw new SecurityException(
                    "TestNetworkStackService is only available on debuggable builds");
        }
        return super.onBind(intent);
    }
}
