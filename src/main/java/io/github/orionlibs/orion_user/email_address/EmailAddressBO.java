package io.github.orionlibs.orion_user.email_address;

import io.github.orionlibs.orion_assert.Assert;
import io.github.orionlibs.orion_cryptology.encoding.base64.Base64EncodingService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class EmailAddressBO
{
    private String emailAddress;


    public static EmailAddressBO of(String emailAddress)
    {
        return EmailAddressBO.builder().emailAddress(emailAddress).build();
    }


    public String normaliseEmailAddress()
    {
        Assert.notEmpty(emailAddress, "The emailAddress input cannot be null/empty.");
        return emailAddress.trim().toLowerCase();
    }


    public boolean isValidEmailAddress(String emailAddressPattern)
    {
        if(emailAddress != null)
        {
            String decodedPattern = Base64EncodingService.decodeBase64ForString(emailAddressPattern);
            Pattern pattern = Pattern.compile(decodedPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(emailAddress.trim());
            return matcher.matches();
        }
        else
        {
            return false;
        }
    }
}