package com.example.guitarApi.modules.entities.productEntities.MusicalInstrument;

import com.example.guitarApi.modules.entities.productEntities.GuitarType;

public interface IGuitar {
    public Long getId();
    public String getName();
    public String getCompany();
    public double getWeight();
    public String getColor();
    public int getStringQuantity();
    public double getPrice();
    public GuitarType getGuitarType();

    public String getDescription();

}
