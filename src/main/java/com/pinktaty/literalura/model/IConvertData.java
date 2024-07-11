package com.pinktaty.literalura.model;

public interface IConvertData {
    <T> T obtainData(String json, Class<T> clase);
}
