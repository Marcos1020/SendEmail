package com.sendEmail.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateAndTimeDeserializer extends JsonDeserializer<Date> {
  @Override
  public Date deserialize(final JsonParser paramJsonParser, final DeserializationContext paramDeserializationContext)
          throws IOException {
      final String str = paramJsonParser.getText().trim();
      try {
          return new SimpleDateFormat("dd/MM/yyyy").parse(str);
      } catch (final ParseException e){
        log.error(e.getMessage(),e);
      }
      return paramDeserializationContext.parseDate(str);
  }
}