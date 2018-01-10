class main {
    public static void main(String[] args) {
        System.out.println("Un dés");
        for (int i = 0; i < 10; i++){
            System.out.println(de.randomDie());
        }
        System.out.println("Deux dés");
        for (int i = 0; i < 10; i++){
            System.out.println(de.randomDice());
        }
    }
}