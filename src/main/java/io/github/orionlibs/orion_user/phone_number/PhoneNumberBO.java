package io.github.orionlibs.orion_user.phone_number;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class PhoneNumberBO
{
    private String phoneNumber;
    private String regionCodeString;
    private PhoneNumberRegionCode regionCode;


    public static PhoneNumberBO of(String phoneNumber, String regionCodeString)
    {
        return PhoneNumberBO.builder().phoneNumber(phoneNumber).regionCodeString(regionCodeString).build();
    }


    public static PhoneNumberBO of(String phoneNumber, PhoneNumberRegionCode regionCode)
    {
        return PhoneNumberBO.builder().phoneNumber(phoneNumber).regionCode(regionCode).build();
    }


    public boolean isValid()
    {
        if(phoneNumber != null)
        {
            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
            try
            {
                PhoneNumber phoneNumberTemp = PhoneNumberUtil.getInstance().parse(phoneNumber.trim(), regionCodeString);
                return phoneUtil.isValidNumber(phoneNumberTemp);
            }
            catch(NumberParseException e)
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }


    public String normalise()
    {
        if(phoneNumber != null)
        {
            phoneNumber = phoneNumber.trim();
            if(!phoneNumber.isEmpty())
            {
                return PhoneNumberUtil.normalizeDigitsOnly(phoneNumber.trim());
            }
            else
            {
                return "";
            }
        }
        else
        {
            return "";
        }
    }


    public String convertToInternationalFormat()
    {
        if(phoneNumber != null)
        {
            phoneNumber = phoneNumber.trim();
            if(!phoneNumber.isEmpty())
            {
                PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
                try
                {
                    Phonenumber.PhoneNumber parsedPhoneNumber = phoneNumberUtil.parse(phoneNumber, regionCode.get());
                    return phoneNumberUtil.format(parsedPhoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    return "";
                }
            }
            else
            {
                return "";
            }
        }
        else
        {
            return "";
        }
    }
}