package practica07;

import javax.swing.*;
import java.io.IOException;

public abstract class Ranking {
    protected String title_;
    public abstract void update();
    public abstract JPanel writeRanking() throws IOException;
}
