package com.ramper.gamification.client;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.ramper.gamification.client.dto.MultiplicationResultAttempt;

public class MultiplicationResultAttemptDeserializer extends JsonDeserializer<MultiplicationResultAttempt> {

    @Override
    public MultiplicationResultAttempt deserialize(JsonParser p, DeserializationContext ctxt)
	    throws IOException, JsonProcessingException {
	ObjectCodec oc = p.getCodec();
	JsonNode jsonNode = oc.readTree(p);
	return new MultiplicationResultAttempt(jsonNode.get("user").get("alias").asText(),
		jsonNode.get("multiplication").get("factorA").asInt(),
		jsonNode.get("multiplication").get("factorB").asInt(), jsonNode.get("resultAttempt").asInt(),
		jsonNode.get("correct").asBoolean());
    }

}
