package org.sweetycode.clrs.cryptology.rsa;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;

/**
 * @Auther: sweetycode
 * @Date: 2018/8/24
 * @Description:
 */
public class RSADemo {
    private static final String CHARSET = "UTF-8";
    private static final String ALGORITHM = "RSA";
    private static final String PROVIDER = "BC";    //BC  SunRsaSign

    private static int KEY_MODE = 0;    //加密模式：0,私钥加密公钥解密；1,公钥加密私钥解密

    private static String publicKeyStr;
    private static String privateKeyStr;

    private static RSAPublicKey publicKey;
    private static RSAPrivateKey privateKey;

    public static void init (int keySize){

        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try {
            kpg = KeyPairGenerator.getInstance(ALGORITHM, PROVIDER);
        } catch (NoSuchAlgorithmException e){
            throw new IllegalArgumentException("RSADemo::init: No such algorithm-->[" + ALGORITHM + "]");
        } catch (NoSuchProviderException e) {
            throw new IllegalArgumentException("RSADemo::init: No such provider-->[" + PROVIDER + "]");
        }

        //初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(keySize);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());

        init(publicKeyStr, privateKeyStr);
    }

    public static void init(String publicKeyStr, String privateKeyStr) {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM, PROVIDER);
            publicKey = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
            privateKey = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("RSADemo::init: No such algorithm-->[" + ALGORITHM + "]");
        } catch (InvalidKeySpecException e) {
            throw new IllegalArgumentException("RSADemo::init:InvalidKeySpec");
        } catch (NoSuchProviderException e) {
            throw new IllegalArgumentException("RSADemo::init: No such provider-->[" + PROVIDER + "]");
        }
    }

    //Cipher.ENCRYPT_MODE
    public static String rsa(String data, int mode) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM, PROVIDER);
            if( (KEY_MODE == 0 && mode == Cipher.ENCRYPT_MODE) || (KEY_MODE == 1 && mode == Cipher.DECRYPT_MODE)) {
                cipher.init(mode, privateKey);
                if(mode == Cipher.ENCRYPT_MODE) {
                    return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, mode, data.getBytes(CHARSET), privateKey.getModulus().bitLength()));
                } else {
                    return new String(rsaSplitCodec(cipher, mode, Base64.decodeBase64(data), privateKey.getModulus().bitLength()), CHARSET);
                }
            } else if((KEY_MODE == 0 && mode == Cipher.DECRYPT_MODE) || (KEY_MODE == 1 && mode == Cipher.ENCRYPT_MODE)) {
                cipher.init(mode, publicKey);
                if(mode == Cipher.ENCRYPT_MODE) {
                    return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, mode, data.getBytes(CHARSET), publicKey.getModulus().bitLength()));
                } else {
                    return new String(rsaSplitCodec(cipher, mode, Base64.decodeBase64(data), publicKey.getModulus().bitLength()), CHARSET);
                }
            } else {
                throw new IllegalArgumentException("RSADemo::rsa: No such Encrypt Mode-->[" + KEY_MODE + "]");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("RSADemo::rsa: No such algorithm-->[" + ALGORITHM + "]");
        } catch (NoSuchPaddingException e) {
            throw new IllegalArgumentException("RSADemo::rsa: No such padding-->[" + ALGORITHM + "]");
        } catch (NoSuchProviderException e) {
            throw new IllegalArgumentException("RSADemo::rsa: No such provider-->[" + PROVIDER + "]");
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("RSADemo::rsa: InvalidKey");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("RSADemo::rsa: Illegal charset-->[" + CHARSET +"]");
        }
    }

    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize){
        int maxBlock = 0;
        if(opmode == Cipher.DECRYPT_MODE){
            maxBlock = keySize / 8;
        }else{
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try{
            while(datas.length > offSet){
                if(datas.length-offSet > maxBlock){
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                }else{
                    buff = cipher.doFinal(datas, offSet, datas.length-offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        }catch(Exception e){
            throw new RuntimeException("加解密阀值为["+maxBlock+"]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        IOUtils.closeQuietly(out);
        return resultDatas;
    }

    public static void setKeyMode(int keyMode) {
        KEY_MODE = keyMode;
    }

    private void printAllProviders() {
        try {
            Provider p[] = Security.getProviders();
            for (int i = 0; i < p.length; i++) {
                System.out.println(p[i]);
                for (Enumeration e = p[i].keys(); e.hasMoreElements();)
                    System.out.println("\t" + e.nextElement());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String plain = "This is a test message.";

        RSADemo.init(128);
        // RSADemo.init("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAK66MzGdO1XVlDBrKnI4BnkCAwEAAQ","MHcCAQAwDQYJKoZIhvcNAQEBBQAEYzBhAgEAAhEArrozMZ07VdWUMGsqcjgGeQIDAQABAhAPW6WBUGk1P5Xedyk88IKzAgkA5vPSWhNnj5sCCQDBrVdja3gFewIITbxl4jHD2t8CCCccC9OFthzVAgh6namhdPxumw");
        System.out.println("私钥：");
        System.out.println(RSADemo.privateKeyStr);
        System.out.println("公钥：");
        System.out.println(RSADemo.publicKeyStr);
        System.out.println("密文：");
        String cipher = RSADemo.rsa(plain, Cipher.ENCRYPT_MODE);
        System.out.println(cipher);
        System.out.println("明文：");
        System.out.println(RSADemo.rsa(cipher, Cipher.DECRYPT_MODE));

    }
}
