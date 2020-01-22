package com.example.demo.test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
/**
 * @author:zhongbo
 * @Description: 自定义序列化，继承StdSerializer<T>
 * @date:  2020/1/15 17:47
 */
public class MySerializer extends StdSerializer<Person> {
    public MySerializer(){
        super(Person.class);
    }
    @Override
    public void serialize(Person person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name",person.getName());
        jsonGenerator.writeStringField("age",String.valueOf(person.getAge()));
        jsonGenerator.writeStringField("address",person.getAddress());
        jsonGenerator.writeStringField("sex","男");
        jsonGenerator.writeStringField("id","20147710450");
        jsonGenerator.writeEndObject();
    }
}
