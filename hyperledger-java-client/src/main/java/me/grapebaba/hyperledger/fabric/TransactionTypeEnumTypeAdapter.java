/*
 * Copyright 2016 281165273@qq.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package me.grapebaba.hyperledger.fabric;

import com.google.gson.*;
import me.grapebaba.hyperledger.fabric.models.Transaction;

import java.lang.reflect.Type;

/**
 * TypeAdapter for Transaction.Type.
 */
public class TransactionTypeEnumTypeAdapter implements JsonSerializer<Transaction.Type>, JsonDeserializer<Transaction.Type> {
    @Override
    public Transaction.Type deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return Transaction.Type.values()[json.getAsInt()];
    }

    @Override
    public JsonElement serialize(Transaction.Type src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.ordinal());
    }
}
