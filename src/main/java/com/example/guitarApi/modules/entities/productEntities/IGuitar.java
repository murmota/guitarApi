package com.example.guitarApi.modules.entities.productEntities;

public interface IGuitar {
    public Long getID();
    public String getName();
    public String getCompany();
    public double getWeight();
    public String getColor();
    public int getStringQuantity();
    public double getPrice();
    public GuitarType getGuitarType();

    public String getDescription();

}
