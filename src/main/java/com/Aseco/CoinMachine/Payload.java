package com.Aseco.CoinMachine;

import java.util.List;

public class Payload {
    private List<String> rightPerson;
    private List<String> leftPerson;

    public List<String> getRightPerson() {
        return rightPerson;
    }

    public void setRightPerson(List<String> rightPerson) {
        this.rightPerson = rightPerson;
    }
    
    public List<String> getLeftPerson() {
        return leftPerson;
    }

    public void setLeftPerson(List<String> leftPerson) {
        this.leftPerson = leftPerson;
    }
}
