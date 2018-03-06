/*
 * Copyright (C) 2013 The Android Open Source Project
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

package edu.ucdavis.nmng.ecs193_mapp;

import java.util.HashMap;
import java.util.UUID;

/**
 * This class includes a small subset of standard GATT attributes for demonstration purposes.
 */
public class SampleGattAttributes {
    private static HashMap<String, String> attributes = new HashMap();
//    public static UUID[] devices = new UUID[] {UUID.fromString("6c4d170b-6df3-4fec-b88a-38cbb4034ebe")};
    public static UUID[] devices = new UUID[] {UUID.fromString("72369d5c-94e1-41d7-acab-a88062c506a8")};


    static {
        // Sample Services.
//        attributes.put("6c4d170b-6df3-4fec-b88a-38cbb4034ebe", "Service");
        attributes.put("72369d5c-94e1-41d7-acab-a88062c506a8", "Service");

        // Sample Characteristics.
        attributes.put("9a9609a2-6e59-463e-8319-f72ca5c51c74", "Char1");
        attributes.put("91ac487a-fa16-4914-89f3-0f94ee26c7a0", "Char2");
        attributes.put("1ccacaf2-a7c7-4494-a116-af04140baa55", "Char3");
        attributes.put("0063cccb-c897-42ae-bc95-048aaca1cd83", "Char4");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}
