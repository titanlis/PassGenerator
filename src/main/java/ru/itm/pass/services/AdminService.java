package ru.itm.pass.services;

import java.util.random.RandomGenerator;

public interface AdminService {
    String generatePassword();

    String getLowAlpha();
    void setLowAlpha(String lowAlpha);
    String getHighAlpha();
    void setHighAlpha(String highAlpha);
    String getNumericString();
    void setNumericString(String numericString);
    String getPunctuationMarks();
    void setPunctuationMarks(String punctuationMarks);
    Integer getLen();
    void setLen(Integer len);
    String getLastPassword();
    void setLastPassword(String lastPassword);

    Boolean getIsLowAlpha();

    void setIsLowAlpha(Boolean isLowAlpha);

    Boolean getIsHighAlpha();

    void setIsHighAlpha(Boolean isHighAlpha);

    Boolean getIsNumeric();

    void setIsNumeric(Boolean isNumeric);

    Boolean getIsPunctuationMarks();

    void setIsPunctuationMarks(Boolean isPunctuationMarks);

    RandomGenerator getRandomGenerator();

    void setRandomGenerator(RandomGenerator randomGenerator);
}

