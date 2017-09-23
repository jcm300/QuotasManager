/**
 * @author jcm300
 */

package quotasmanager;

public class AlunoNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>AlunoNotFoundException</code> without
     * detail message.
     */
    public AlunoNotFoundException() {
    }

    /**
     * Constructs an instance of <code>AlunoNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlunoNotFoundException(String msg) {
        super(msg);
    }
}
