package com.whitehorse.qingzhi.service;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.whitehorse.qingzhi.entity.ManagerInfo;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("${password.algorithmName}")
    private String algorithmName = "md5";
    @Value("${password.hashIterations}")
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    /**
     * 密码加密
     * @param managerInfo
     */
    public void encryptPassword(ManagerInfo managerInfo) {

    	//managerInfo.injectSalt(randomNumberGenerator.nextBytes().toHex());
    	
        String newPassword = new SimpleHash(
                algorithmName,
                managerInfo.getManagerPassword(),
                ByteSource.Util.bytes(managerInfo.obtainCredentialsSalt()),
                hashIterations).toHex();

        managerInfo.setManagerPassword(newPassword);
    }
}
