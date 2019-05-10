import java.util.Calendar;
import java.util.Date;

public abstract class SerVivo {

    private String especie;
    private Date dataNascimento;

    public void nascer() {
        this.dataNascimento = Calendar.getInstance().getTime();
    }

    public abstract void viver();

    public void morrer() {
        System.out.println("Puf!");
    }
}
