package conversion;
/**
 * Models a token encountered in input.
 * @author luka
 *
 */
public class Token {
    public String token;
    public String type;

    public Token(String token, int type) {

        this.token = token;
        switch (type) {
        case 0:
            this.type = "function";
            break;
        case 1:
            this.type = "left";
            break;
        case 2:
            this.type = "right";
            break;
        case 3:
            this.type = "operator";
            break;
        case 4:
            this.type = "operator";
            break;
        case 5:
            this.type = "operator";
            break;
        case 6:
            this.type = "number";
            break;
        case 7:
            this.type = "variable";
            break;
        default:
            break;
        }
    }

    public String toString() {
        return this.token;
    }
}