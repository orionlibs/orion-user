package io.github.orionlibs.orion_user.username;

import io.github.orionlibs.orion_cryptology.encryption.rsa.RSAEncryptionException;
import io.github.orionlibs.orion_cryptology.hashing.md5.MD5HashingException;
import io.github.orionlibs.orion_cryptology.security.DataSecurityService;
import io.github.orionlibs.orion_cryptology.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import io.github.orionlibs.orion_enumeration.OrionEnumeration;
import java.util.List;

public class UsernameService
{
    public static String encryptUsername(String rawUsername) throws MD5HashingException, RSAEncryptionException, NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return DataSecurityService.encryptUsername(rawUsername);
    }


    public static String encryptUsername(String rawUsername, List<OrionEnumeration> encodingAndEncryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {
        return DataSecurityService.encryptData(rawUsername, encodingAndEncryptionAlgorithmsToBeUsedInOrder);
    }


    public static String decryptUsername(String encryptedUsername) throws MD5HashingException, RSAEncryptionException, NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return DataSecurityService.decryptUsername(encryptedUsername);
    }


    public static String decryptUsername(String encryptedUsername, List<OrionEnumeration> decodingAndDecryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {
        return DataSecurityService.decryptData(encryptedUsername, decodingAndDecryptionAlgorithmsToBeUsedInOrder);
    }
}