package denshchikov.dmitry.stackoverflowclient.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeFromEpochDeserializer extends StdDeserializer<LocalDateTime> {

    public LocalDateTimeFromEpochDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(jp.readValueAs(Long.class)), ZoneId.systemDefault());
    }

}