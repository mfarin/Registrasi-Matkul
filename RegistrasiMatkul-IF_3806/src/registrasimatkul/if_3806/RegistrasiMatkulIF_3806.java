package registrasimatkul.if_3806;
import java.sql.SQLException;
import registrasimatkul.Console.Aplikasi;
import registrasimatkul.Controller.ControllerAdminUtama;
import registrasimatkul.Controller.ControllerMenu;
import registrasimatkul.Controller.ControllerView;
import registrasimatkul.Controller.Mahasiswa1;

public class RegistrasiMatkulIF_3806{
    public static void main(String args[]) throws SQLException{
        Aplikasi a = new Aplikasi();
        a.getKoneksi();
        //a.mainMenu();
        new ControllerMenu(a);
    }
}
