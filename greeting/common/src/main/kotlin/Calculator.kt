/*
 * Copyright 2018 JetBrains s.r.o.
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
class Calculator {
    companion object {
        fun sum(a: Int, b: Int): Int = a + b;

        internal val myMap: Map<String, List<String>> = mapOf(
                "val1" to listOf("a1", "a2", "a3"),
                "val2" to listOf("b1", "b2")
        );

        fun getName(name: String): String {
            for (entry in myMap) {
                if (entry.value.contains(name)) {
                    return entry.key;
                }
            }

            return name;
        }
    }


}