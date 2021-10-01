public enum KindOfAccount {
    CHECHINGACOUNT(0),
    SAVINGACCOUNT(1),
    LOANACCOUNT(2);
    public static KindOfAccount kindaccount;
    private int shortcut;
    KindOfAccount(int shortcut) {
        this.shortcut = shortcut;
    }
    public int getShortcut() {
        return shortcut;
    }
}
