package io.github.orionlibs.orion_user.phone_number;

import io.github.orionlibs.orion_enumeration.OrionEnumeration;

public enum PhoneNumberRegionCode implements OrionEnumeration
{
    GB("GB");
    private String name;


    private PhoneNumberRegionCode(String name)
    {
        setName(name);
    }


    @Override
    public String get()
    {
        return getName();
    }


    public String getName()
    {
        return this.name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof PhoneNumberRegionCode && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof PhoneNumberRegionCode && this != other;
    }


    public static boolean valueExists(String other)
    {
        PhoneNumberRegionCode[] values = values();
        for(PhoneNumberRegionCode value : values)
        {
            if(value.get().equals(other))
            {
                return true;
            }
        }
        return false;
    }


    public static PhoneNumberRegionCode getEnumForValue(String other)
    {
        PhoneNumberRegionCode[] values = values();
        for(PhoneNumberRegionCode value : values)
        {
            if(value.get().equals(other))
            {
                return value;
            }
        }
        return null;
    }
}