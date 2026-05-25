package src

class Colors {
    static final String RESET   = "\033[0m"
    static final String BOLD    = "\033[1m"
    static final String BLACK   = "\033[30m"

    static final String RED     = "\033[31m"
    static final String GREEN   = "\033[32m"
    static final String YELLOW  = "\033[33m"
    static final String BLUE    = "\033[34m"
    static final String ORANGE  = "\033[38;5;208m"

    void info(String iMessage, String isTextBold=false){
        String style = isTextBold ? BOLD : ""
        println("${style}$${BLUE}[INFO] - ${iMessage}${RESET}")
    }

    void warning(String iMessage, String isTextBold=false){
        String style = isTextBold ? BOLD : ""
        println("${style}$${ORANGE}[WARNING] - ${iMessage}${RESET}")
    }

    void error(String iMessage, String isTextBold=false){
        String style = isTextBold ? BOLD : ""
        println("${style}$${RED}[ERROR] - ${iMessage}${RESET}")
    }

    void debug(String iMessage, String isTextBold=false){
        String style = isTextBold ? BOLD : ""
        println("${style}$${BLACK}[DEBUG] - ${iMessage}${RESET}")
    }

    void system(String iMessage, String isTextBold=false){
        String style = isTextBold ? BOLD : ""
        println("${style}$${YELLOW}[SYSTEM] - ${iMessage}${RESET}")
    }
}