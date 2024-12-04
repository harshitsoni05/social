package com.social.products.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "categoryType"
    )
@JsonSubTypes({
    @JsonSubTypes.Type(value = Shirt.class, name = "Shirt"),
    @JsonSubTypes.Type(value = Jeans.class, name = "Jeans")
})
public interface Category extends ProductSpecification{
    String getCategoryId();
}
