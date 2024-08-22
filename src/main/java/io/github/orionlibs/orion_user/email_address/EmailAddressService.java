package io.github.orionlibs.orion_user.email_address;

public class EmailAddressService
{
    public static String normaliseEmailAddress(String emailAddress)
    {
        return EmailAddressBO.of(emailAddress).normaliseEmailAddress();
    }


    public static boolean isValidEmailAddress(String emailAddress, String emailAddressPattern)
    {
        return EmailAddressBO.of(emailAddress).isValidEmailAddress(emailAddressPattern);
    }


    public static boolean isInvalidEmailAddress(String emailAddress, String emailAddressPattern)
    {
        return !isValidEmailAddress(emailAddress, emailAddressPattern);
    }
}