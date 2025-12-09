// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     CoinFlipperData data = Converter.fromJsonString(jsonString);

package com.apiverve.coinflipper.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static CoinFlipperData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(CoinFlipperData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(CoinFlipperData.class);
        writer = mapper.writerFor(CoinFlipperData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// CoinFlipperData.java

package com.apiverve.coinflipper.data;

import com.fasterxml.jackson.annotation.*;

public class CoinFlipperData {
    private long totalFlips;
    private FirstFlip[] flips;
    private long headsCount;
    private long tailsCount;
    private long headsPercentage;
    private long tailsPercentage;
    private LongestStreak longestStreak;
    private FirstFlip firstFlip;
    private FirstFlip lastFlip;
    private boolean isFair;

    @JsonProperty("total_flips")
    public long getTotalFlips() { return totalFlips; }
    @JsonProperty("total_flips")
    public void setTotalFlips(long value) { this.totalFlips = value; }

    @JsonProperty("flips")
    public FirstFlip[] getFlips() { return flips; }
    @JsonProperty("flips")
    public void setFlips(FirstFlip[] value) { this.flips = value; }

    @JsonProperty("heads_count")
    public long getHeadsCount() { return headsCount; }
    @JsonProperty("heads_count")
    public void setHeadsCount(long value) { this.headsCount = value; }

    @JsonProperty("tails_count")
    public long getTailsCount() { return tailsCount; }
    @JsonProperty("tails_count")
    public void setTailsCount(long value) { this.tailsCount = value; }

    @JsonProperty("heads_percentage")
    public long getHeadsPercentage() { return headsPercentage; }
    @JsonProperty("heads_percentage")
    public void setHeadsPercentage(long value) { this.headsPercentage = value; }

    @JsonProperty("tails_percentage")
    public long getTailsPercentage() { return tailsPercentage; }
    @JsonProperty("tails_percentage")
    public void setTailsPercentage(long value) { this.tailsPercentage = value; }

    @JsonProperty("longest_streak")
    public LongestStreak getLongestStreak() { return longestStreak; }
    @JsonProperty("longest_streak")
    public void setLongestStreak(LongestStreak value) { this.longestStreak = value; }

    @JsonProperty("first_flip")
    public FirstFlip getFirstFlip() { return firstFlip; }
    @JsonProperty("first_flip")
    public void setFirstFlip(FirstFlip value) { this.firstFlip = value; }

    @JsonProperty("last_flip")
    public FirstFlip getLastFlip() { return lastFlip; }
    @JsonProperty("last_flip")
    public void setLastFlip(FirstFlip value) { this.lastFlip = value; }

    @JsonProperty("is_fair")
    public boolean getIsFair() { return isFair; }
    @JsonProperty("is_fair")
    public void setIsFair(boolean value) { this.isFair = value; }
}

// FirstFlip.java

package com.apiverve.coinflipper.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum FirstFlip {
    HEADS, TAILS;

    @JsonValue
    public String toValue() {
        switch (this) {
            case HEADS: return "Heads";
            case TAILS: return "Tails";
        }
        return null;
    }

    @JsonCreator
    public static FirstFlip forValue(String value) throws IOException {
        if (value.equals("Heads")) return HEADS;
        if (value.equals("Tails")) return TAILS;
        throw new IOException("Cannot deserialize FirstFlip");
    }
}

// LongestStreak.java

package com.apiverve.coinflipper.data;

import com.fasterxml.jackson.annotation.*;

public class LongestStreak {
    private long length;
    private FirstFlip type;

    @JsonProperty("length")
    public long getLength() { return length; }
    @JsonProperty("length")
    public void setLength(long value) { this.length = value; }

    @JsonProperty("type")
    public FirstFlip getType() { return type; }
    @JsonProperty("type")
    public void setType(FirstFlip value) { this.type = value; }
}