package com.alura.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "languages")
public record Language(
    @Id String Id, 
    @Field(name = "title") String Title, 
    @Field(name="imageUrl") String ImageUrl, 
    @Field(name="ranking") int Ranking) {}
