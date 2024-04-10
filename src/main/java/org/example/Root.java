package org.example;

import com.google.gson.annotations.SerializedName;

public class Root {
    @SerializedName("Date")
    public String date;

    @SerializedName("Valute")
    public Valute valute;
}

class Valute{
    @SerializedName("USD")
    public Usd usd;

    @SerializedName("EUR")
    public Eur eur;

    @SerializedName("BYN")
    public Byn byn;
}

class Usd{
    @SerializedName("Name")
    public String name;

    @SerializedName("Value")
    public String value;

    @SerializedName("Previous")
    public String previous;
}

class Byn{
    @SerializedName("Name")
    public String name;

    @SerializedName("Value")
    public String value;

    @SerializedName("Previous")
    public String previous;
}

class Eur{
    @SerializedName("Name")
    public String name;

    @SerializedName("Value")
    public String value;

    @SerializedName("Previous")
    public String previous;
}