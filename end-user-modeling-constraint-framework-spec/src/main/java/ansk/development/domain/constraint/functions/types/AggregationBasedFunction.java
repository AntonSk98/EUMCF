/*
 * Copyright (c) 2023 Anton Skripin
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package ansk.development.domain.constraint.functions.types;

import ansk.development.domain.constraint.functions.ConstraintFunction;
import ansk.development.exception.constraint.function.FunctionException;
import ansk.development.exception.constraint.function.NotImplementedException;

import java.util.Map;

/**
 * Function that takes an array of attributes and applies an aggregation like
 * total number of elements,
 * average value,
 * etc.
 */
public class AggregationBasedFunction extends CollectionBasedFunction {
    public AggregationBasedFunction(String name, String navigation, ConstraintFunction lambdaFunction, Map<String, String> params) {
        super(name, navigation, lambdaFunction, params);
        throw new NotImplementedException(this.getClass().getSimpleName());
    }

    public AggregationBasedFunction(String name, String navigation, ConstraintFunction constraintFunction, Map<String, String> params, boolean asTemplate) {
        super(name, navigation, constraintFunction, params, asTemplate);
        throw new NotImplementedException(this.getClass().getSimpleName());
    }
}
