package ru.itm.pass.services;

import java.util.random.RandomGenerator;

public class AdminServiceImpl implements AdminService{
    private static String lowAlpha = "abcdefghijklmnopqrstuvwxyz";
    private static String highAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String numericString = "0123456789";
    private static String punctuationMarks = "!@#$%^&*()-_+=/?\\|~[]{}";
    private static Integer len = 12;
    private static String lastPassword = "";
    private static Boolean isLowAlpha = true;
    private static Boolean isHighAlpha = true;
    private static Boolean isNumeric = true;
    private static Boolean isPunctuationMarks = true;
    private static RandomGenerator randomGenerator = RandomGenerator.getDefault();


    @Override
    public String generatePassword(){
        StringBuffer stringBuffer = new StringBuffer();
        if(isLowAlpha) stringBuffer.append(lowAlpha);
        if(isHighAlpha) stringBuffer.append(highAlpha);
        if(isNumeric) stringBuffer.append(numericString);
        if(isPunctuationMarks) stringBuffer.append(punctuationMarks);
        if(stringBuffer.isEmpty() || len<1) return "";
        StringBuffer passString = new StringBuffer();
        for(int i=0; i<len; i++){
            passString.append(stringBuffer.charAt(randomGenerator.nextInt(stringBuffer.length())));
        }
        return passString.toString();
    }

    @Override
    public String getLowAlpha() {
        return lowAlpha;
    }

    @Override
    public void setLowAlpha(String lowAlpha) {
        AdminServiceImpl.lowAlpha = lowAlpha;
    }

    @Override
    public String getHighAlpha() {
        return highAlpha;
    }

    @Override
    public void setHighAlpha(String highAlpha) {
        AdminServiceImpl.highAlpha = highAlpha;
    }

    @Override
    public String getNumericString() {
        return numericString;
    }

    @Override
    public void setNumericString(String numericString) {
        AdminServiceImpl.numericString = numericString;
    }

    @Override
    public String getPunctuationMarks() {
        return punctuationMarks;
    }

    @Override
    public void setPunctuationMarks(String punctuationMarks) {
        AdminServiceImpl.punctuationMarks = punctuationMarks;
    }

    @Override
    public Integer getLen() {
        return len;
    }

    @Override
    public void setLen(Integer len) {
        AdminServiceImpl.len = len;
    }

    @Override
    public String getLastPassword() {
        return lastPassword;
    }

    @Override
    public void setLastPassword(String lastPassword) {
        AdminServiceImpl.lastPassword = lastPassword;
    }

    @Override
    public Boolean getIsLowAlpha() {
        return isLowAlpha;
    }

    @Override
    public void setIsLowAlpha(Boolean isLowAlpha) {
        AdminServiceImpl.isLowAlpha = isLowAlpha;
    }

    @Override
    public Boolean getIsHighAlpha() {
        return isHighAlpha;
    }

    @Override
    public void setIsHighAlpha(Boolean isHighAlpha) {
        AdminServiceImpl.isHighAlpha = isHighAlpha;
    }

    @Override
    public Boolean getIsNumeric() {
        return isNumeric;
    }

    @Override
    public void setIsNumeric(Boolean isNumeric) {
        AdminServiceImpl.isNumeric = isNumeric;
    }

    @Override
    public Boolean getIsPunctuationMarks() {
        return isPunctuationMarks;
    }

    @Override
    public void setIsPunctuationMarks(Boolean isPunctuationMarks) {
        AdminServiceImpl.isPunctuationMarks = isPunctuationMarks;
    }

    @Override
    public RandomGenerator getRandomGenerator() {
        return randomGenerator;
    }

    @Override
    public void setRandomGenerator(RandomGenerator randomGenerator) {
        AdminServiceImpl.randomGenerator = randomGenerator;
    }
}
