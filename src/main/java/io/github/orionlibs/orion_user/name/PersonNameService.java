package io.github.orionlibs.orion_user.name;

public class PersonNameService
{
    public static String normaliseName(String name)
    {
        return PersonNameBO.of(name).normaliseName();
    }


    public static boolean isValidFirstName(String firstName)
    {
        return PersonNameBO.of(firstName).isValidName();
    }


    public static boolean isInvalidFirstName(String firstName)
    {
        return !isValidFirstName(firstName);
    }


    public static boolean isValidLastName(String lastName)
    {
        return PersonNameBO.of(lastName).isValidName();
    }


    public static boolean isInvalidLastName(String lastName)
    {
        return !isValidLastName(lastName);
    }
}