package Personnages;

public abstract class CharacterBand extends Character {
    private Integer characterNumber;

    public Integer getCharacterNumber() {
        return characterNumber;
    }

    public void setCharacterNumber(Integer newBandNumber) {
        this.characterNumber = newBandNumber;
    }
}

